import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Elefante extends JLabel implements Runnable {
    private Thread elefante = null;
    private static int posicao = 0;
    private static String resultadoStr = "";
    private int x;
    private int y;
    private ImageIcon img;
    private String nome;

    public static void resetResultado() {
        posicao = 0;
        resultadoStr = "";
    }

    public Elefante(String nome, int x, int y, ImageIcon img) {
        super(img);
        this.nome = nome;
        this.x = x;
        this.y = y;

        java.awt.Image image = img.getImage();
        java.awt.Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        this.img = new ImageIcon(newimg);
        this.setIcon(this.img);

        this.setSize(100, 100);

        elefante = new Thread(this);
        elefante.start();
    }

    @Override
    public void run() {
        while (x < 500) {
            x += new Random().nextInt(4) * 10;
            this.setLocation(x, y);
            if (x >= 500) {
                int minhaPosicao;
                synchronized (Elefante.class) {
                    posicao++;
                    minhaPosicao = posicao;
                    resultadoStr += minhaPosicao + "º lugar: " + this.nome + "\n";
                }
                if (minhaPosicao == 2) {
                    JOptionPane.showMessageDialog(null, "Resultado da Corrida:\n" + resultadoStr);
                }
                break;
            }
            try {
                Thread.sleep(new Random().nextInt(7) * 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
