import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
public class Principal {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Otavio", 24, "123456789");
       
        try {
             FileOutputStream aSer = new FileOutputStream("pessoa.ser");
             ObjectOutputStream oSer = new ObjectOutputStream(aSer);
             oSer.writeObject(pessoa);
             oSer.close();
             aSer.close();

             pessoa.setNome("Augusto");
             pessoa.setIdade(25);
             pessoa.setTelefone("987654321");

             System.out.println(pessoa);
             System.out.println("-------------------------");

             FileInputStream aDes = new FileInputStream("pessoa.ser");
             ObjectInputStream oDes = new ObjectInputStream(aDes);
             pessoa = (Pessoa) oDes.readObject();
             oDes.close();
             aDes.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pessoa.mostrar();
    }
}
