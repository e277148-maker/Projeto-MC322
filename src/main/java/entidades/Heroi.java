// Subclasse para representar o herói do jogo, que é um tipo específico de entidade

package entidades;

import java.util.List;

import batalhas.Batalha;
import efeitos.Efeito;
/**
 * Gerencia o herói
 */
public class Heroi extends Entidade {

    private int energia;
    private boolean turno;

    // Construtor
/**
 * Inicializa um herói
 * @param nome Nome do herói
 * @param descricao Descrição do herói
 * @param vida Vida do herói
 * @param escudo Escudo do herói
 * @param efeitos Efeitos ativos no herói
 * @param vidaMaxima Vida maxima do herói
 * @param batalha Batalha ao qual o herói pertence
 * @param eventos Lista de eventos no qual efeitos são aplicados
 * @param energia Energia inicial do herói
 * @param turno Indica se é o turno do herói
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