// Este código define a classe Evento, que representa um evento ou ação que pode ocorrer durante as batalhas no jogo. 

package batalhas;

public class Evento {

    // Atributos
    private String nome;

    // Constructors
    public Evento(String nome) {
        this.nome = nome;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
}
