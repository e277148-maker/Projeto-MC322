// Este código define a classe Evento, que representa um evento ou ação que pode ocorrer durante as batalhas no jogo. 

package batalhas;
/**
 * Gerencia os eventos durante uma batalha
 */
public class EventoDaBatalha {

    // Atributos
    /**
     * Nome do evento
     */
    private String nome;

    // Constructors
    /**
     * Cria um evento com um nome
     * @param nome Nome do evento
     */
    public EventoDaBatalha(String nome) {
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
