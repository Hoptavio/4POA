package POA3.src.exemplo;

public class Principal {
    public static void main(String[] args) {
        Agenda a1 = new Agenda();
        a1.escrita("Otavio Augusto", "(21)98115-7936");
        a1.escrita("Matheus", "(21)99971-2874");
        a1.lertodos();
        a1.lernome("Matheus");
    }
}
