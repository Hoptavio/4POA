import java.io.Serializable;

public class Pessoa implements Serializable {
 public String nome;
 private int idade;
 private String telefone;

 public Pessoa(String nome, int idade, String telefone) {
    this.nome = nome;
    this.idade = idade;
    this.telefone = telefone;
 }

 public String getNome() {
    return nome;
 }

 public void setNome(String nome) {
    this.nome = nome;
 }

 public int getIdade() {
    return idade;
 }

 public void setIdade(int idade) {
    this.idade = idade;
 }

 public String getTelefone() {
    return telefone;
 }

 public void setTelefone(String telefone) {
    this.telefone = telefone;
 }
 public String toString() {
    return "Nome: " + nome + " Idade: " + idade + " Telefone: " + telefone;
 }

 public void mostrar() {
    System.out.println("Nome: " + nome);
    System.out.println("Idade: " + idade);
    System.out.println("Telefone: " + telefone);
 }
}
