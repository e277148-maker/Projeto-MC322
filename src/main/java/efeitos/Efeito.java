// Superclasse abstrata para representar um efeito que pode ser aplicado a uma entidade durante uma batalha

package efeitos;

import entidades.*;
import batalhas.*;

public abstract class Efeito {

    // Atributos
    /**
     * Nome do efeito
     */
    private String nome;
    /**
     * Entidade na qual o efeito será aplicado
     */
    private Entidade dono;
    /**
     * Número de turnos que o efeito será aplicado
     */
    private int acumulo;
    /**
     * Poder do efeito
     */
    private int efeito;
    /**
     * Evento no qual o efeito será aplicado
     */
    private Evento evento;
    /**
     * Batalha na qual o efeito pertence
     */
    private Batalha batalha;

    // Construtores
    /**
     * Cria um efeito com um nome, um dono, um acumulo, um efeito, um evento e uma batalha
     * @param nome Nome do efeito
     * @param dono Entidade na qual o efeito será aplicado
     * @param acumulo Número de turnos que o efeito será aplicado
     * @param efeito Poder do efeito
     * @param evento Evento no qual o efeito será aplicado
     * @param batalha Batalha na qual o efeito pertence
     */
    public Efeito(String nome, Entidade dono, int acumulo, int efeito, Evento evento, Batalha batalha) {

        this.nome = nome;
        this.dono = dono;
        this.acumulo = acumulo;
        this.efeito = efeito;
        this.evento = evento;
        this.batalha = batalha;

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
    
    public Batalha getBatalha() {
        return batalha;
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
    
    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }

    // Outros metodos
    /**
     * Pega o nome e o acumulo do efeito
     * @return Retorna uma string com o nome e o acumuolo do efeito
     */
    public String getString(){
        return nome + ": " + acumulo + " acumulos";
    }

    // Metodos do Subscriber
    /**
     * Aplica o efeito se o evento que aconteceu for o evento no qual o efeito deve ser notificado
     * @param eventoAtual Evento que ocorreu
     */
    public void serNotificado(Evento eventoAtual){

        if (this.evento == eventoAtual){
            aplicarEfeito();
            acumulo--;

            if (acumulo <= 0){
                batalha.desinscrever(this);
                dono.getEfeitos().remove(this);
            }
        }
    }

    // Outros metodos
    /**
     * Aplica o efeito
     */
    protected abstract void aplicarEfeito();

}
