package POA3.src.exemplo;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Agenda {
    public void escrita(String nome, String telefone) {
        try {
            FileWriter fw = new FileWriter("agenda.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nome + ";" + telefone);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void lertodos() {
        try{
       FileReader fr = new FileReader("agenda.txt");
       BufferedReader br = new BufferedReader(fr);
       String aux;
       System.out.println("Agenda completa:\n");
       while ((aux = br.readLine()) != null) {
            if (aux.trim().isEmpty()) continue;
            String []dados = aux.split(";");
            if (dados.length >= 2) {
                System.out.println("Nome: " + dados[0] + " | Telefone: " + dados[1]);
            }
       }
       br.close();
       fr.close();
    } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
     public void lernome(String nome) {
        try{
       FileReader fr = new FileReader("agenda.txt");
       BufferedReader br = new BufferedReader(fr);
       boolean encontrado = false;
       String aux;
       System.out.println("Pessoa encontrada:\n");
       while ((aux = br.readLine()) != null) {
            if (aux.trim().isEmpty()) continue;
            String []dados = aux.split(";");
            if (dados.length >= 2 && dados[0].toLowerCase().contains(nome.toLowerCase())) {
                System.out.println("Nome: " + dados[0] + " | Telefone: " + dados[1]);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Dados não encontrados!");
        }
       br.close();
       fr.close();
    } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}