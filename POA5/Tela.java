import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tela extends JFrame implements ActionListener {

    private JButton btnIniciar;
    private JButton btnParar;
    private JLabel  pista;
    private ImageIcon elefante1;
    private ImageIcon elefante2;
    public Tela() {
      this.setLayout(null);
      this.setSize(600, 400);
      this.setLocation(50,50);
      this.setResizable(false);
      getContentPane().setBackground(Color.white);
      this.setTitle("Corrida de Elefantes");
      this.pista = new JLabel();
      this.pista.setBounds(0, 0, 600, 400);
      this.add(pista);
      this.btnIniciar = new JButton("Iniciar");
      this.btnParar = new JButton("Parar");
      this.btnIniciar.setBounds(10, 310, 100, 30);
      this.btnParar.setBounds(120, 310, 100, 30);
      this.add(btnIniciar);
      this.add(btnParar);
      elefante1 = new ImageIcon("elefante1.jpg");
      elefante2 = new ImageIcon("elefante2.png");
      this.setVisible(true);
      btnIniciar.addActionListener(this);
      btnParar.addActionListener(this);
    }

    public JLabel jLabelElefantes(String nome, ImageIcon img, int posx, int posy) {
      Elefante elefante = new Elefante(nome, posx, posy, img);
      elefante.setVisible(true);
      return elefante;
    }

    @Override
    public void actionPerformed(ActionEvent dispara) {
      if(dispara.getSource() == btnIniciar) {
        Elefante.resetResultado();
        this.pista.removeAll();
        this.pista.setLayout(null);
        this.pista.add(this.jLabelElefantes("Elefante 1", elefante1, 0, 50));
        this.pista.add(this.jLabelElefantes("Elefante 2", elefante2, 0, 170));
        this.pista.repaint();
      }
      if(dispara.getSource() == btnParar) {
       System.exit(0);
      }
    }
}
