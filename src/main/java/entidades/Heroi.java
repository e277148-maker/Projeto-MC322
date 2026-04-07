// Subclasse para representar o herói do jogo, que é um tipo específico de entidade

package entidades;

import java.util.List;

import batalhas.Batalha;
import efeitos.Efeito;

public class Heroi extends Entidade {

    private int energia;
    private boolean turno;

    // Construtor
    /**
     * Cria um herói com os atributos de uma entidade, com uma variavl {@link turno} que indica se esta no seu turno e com uma quantidade de energia inicial
     * @param energia
     * @param turno
     */
    public Heroi(String nome, String descricao, int vida, int escudo, List<Efeito> efeitos, int vidaMaxima, int energia,
            boolean turno, Batalha batalha) {

        super(nome, descricao, vida, escudo, efeitos, vidaMaxima, batalha);
        this.energia = energia;
        this.turno = turno;

    }

    // Getters

    public int getEnergia(){
        return energia;
    }

    public boolean getTurno(){
        return turno;
    }

    // Setters

    public void setTurno(boolean turno){
        this.turno = turno;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    // Outros metodos
    /**
     * Tira energia do herói
     * @param gasto Quantidade que será reduzida da energia
     */
    public void perderEnergia(int gasto){
        energia -= gasto;
    }

}