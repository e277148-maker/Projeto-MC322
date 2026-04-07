// Superclasse abstrata para representar as cartas do jogo

package cartas;

import entidades.*;
/**
 * Gerencia as cartas
 */
public abstract class Carta {
    /**
     * Nome da carta
     */
    private String nome;
    /**
     * Descrição da carta
     */
    private String descricao;
    /**
     * O quanto de energia que é gasto ao usar a carta
     */
    private int custo;
    /**
     * O poder que a carta tem
     */
    private int efeito;

    // Construtor
    /**
     * Inicializa uma carta
     * @param nome Nome da carta
     * @param descricao Descrição da carta
     * @param custo O quanto de energia que é gasto ao usar a carta
     * @param efeito O poder que a carta tem
     */
    public Carta(String nome, String descricao, int custo, int efeito){

        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.efeito = efeito;

    }

    // Getters

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public int getCusto(){
        return custo;
    }

    public int getEfeito(){
        return efeito;
    }

    // Setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setCusto(int custo){
        this.custo = custo;
    }

    public void setEfeito(int efeito){
        this.efeito = efeito;
    }

    // Método abstrato para usar a carta, que será implementado nas classes filhas

    /**
     * Herói usa carta
     * @param heroi Herói controlado pelo jogador
     * @param inimigo Inimigo contra o qual a carta será usada
     */
    public abstract void usar(Heroi heroi, Inimigo inimigo);

}
