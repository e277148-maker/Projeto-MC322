package cartas;
import batalhas.*;

public abstract class CartaDeEfeito extends Carta {

    private int acumulo;
    private Evento evento;
    private Batalha batalha;

    public CartaDeEfeito(String nome, String descricao, int custo, int efeito, int acumulo, Evento evento, Batalha batalha) {
        super(nome, descricao, custo, efeito);

        this.acumulo = acumulo;
        this.evento = evento;
        this.batalha = batalha;
    }

    // Getters

    public int getAcumulo() {
        return acumulo;
    }

    public Evento getEvento() {
            return evento;
    }
        
    public Batalha getBatalha() {
        return batalha;
    }

    // Setters
    public void setAcumulo(int acumulo) {
        this.acumulo = acumulo;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }

}
