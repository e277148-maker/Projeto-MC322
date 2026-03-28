package efeitos;
import entidades.*;
import batalhas.*;

public abstract class Efeito {

    // Atributos
    private String nome;
    private Entidade dono;
    private int acumulo;
    private int efeito;
    private Evento evento;

    

    // Constructors

    public Efeito(String nome, Entidade dono, int acumulo, int efeito, Evento evento) {
            this.nome = nome;
            this.dono = dono;
            this.acumulo = acumulo;
            this.efeito = efeito;
            this.evento = evento;
        }

    // Getters
    public String getNome() {
        return nome;
    }
    
    public Entidade getDono() {
        return dono;
    }
    
    public int getAcumulo() {
        return acumulo;
    }

    public int getEfeito() {
        return efeito;
    }

    public Evento getEvento() {
        return evento;
    }
    
    // Setters
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDono(Entidade dono) {
        this.dono = dono;
    }
    
    public void setAcumulo(int acumulo) {
        this.acumulo = acumulo;
    }

    public void setEfeito(int efeito) {
        this.efeito = efeito;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    // Outros metodos

    public void getString(){
        System.out.printf("%s: %d acumulos", nome, acumulo);
    }

    // Metodos do Subscriber
    public void serNotificado(){
        aplicarEfeito();
        acumulo--;
        checarAcumulo();
    }

    // Metodos do Publisher

    private void notificarAcumulo(Efeito efeito, Batalha batalha){
        batalha.serNotificadoAcumulo(efeito);
    }
    

    protected abstract void aplicarEfeito(); // Ver se deve ser protected mesmo (Apagar esse comentario depois de checar)

    private void checarAcumulo(){
            if (acumulo == 0){
                notificarAcumulo(null, null);
            }
        }



    


}
