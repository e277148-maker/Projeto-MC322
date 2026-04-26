// Superclasse para representar uma entidade genérica no jogo, como um jogador ou um inimigo

package entidades;

import java.util.List;

import efeitos.Efeito;
import eventos.batalha.Batalha;

/**
 * Gerencia uma entidade
 */
public abstract class Entidade {

    // Atributos
    /**
     * Nome da entidade
     */
    private String nome;
    /**
     * Descrição da entidade
     */
    private String descricao;
    /**
     * Vida da entidade
     */
    private int vida;
    /**
     * Vida maxima da entidade
     */
    private int vidaMaxima;
    /**
     * Escudo da entidade
     */
    private int escudo;
    /**
     * Lista de efeitos ativos em na entidade
     */
    private List <Efeito> efeitos;
    /**
     * Batalha que a entidade pertence
     */
    private Batalha batalha;

    // Construtor
    /**
     * Inicializa uma entidade
     * @param nome Nome da entidade
     * @param descricao Descrição da entidade
     * @param vida Vida da entidade
     * @param escudo Escudo da entidade
     * @param efeitos Lista de efeitos ativos em na entidade
     * @param vidaMaxima Vida maxima da entidade
     * @param batalha Batalha que a entidade pertence
     */
    public Entidade(String nome, String descricao, int vida, int escudo, List<Efeito> efeitos, int vidaMaxima, Batalha batalha) {

        this.nome = nome;
        this.descricao = descricao;
        this.vida = vida;
        this.escudo = escudo;
        this.efeitos = efeitos;
        this.vidaMaxima = vidaMaxima;
        this.batalha = batalha;

    }

    // Getters

    public String getNome(){
        return nome;
    }

    public int getVida(){
        return vida;
    }
    public int getEscudo(){
        return escudo;
    }

    public String getDescricao(){
        return descricao;
    }
    
    public List<Efeito> getEfeitos() {
        return efeitos;
    }
    
    public int getVidaMaxima() {
        return vidaMaxima;
    }
    
    public Batalha getBatalha() {
        return batalha;
    }

    // Setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public void setEscudo(int escudo){
        this.escudo = escudo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setEfeitos(List<Efeito> efeitos) {
        this.efeitos = efeitos;
    }
    
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }
    
    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }

    // Outros metodos
    /**
     * Causa dano na entidade subitraido do seu escudo
     * @param dano Dano inicial que será subtraido do escudo
     */
    public void receberDano(int dano){

        int danoReal = dano - escudo;  // Escudo reduz o dano

        if (danoReal < 0) {

            danoReal = 0;  // Não pode ter dano negativo
        }

        escudo = escudo - dano;  // Escudo é consumido

        if (escudo < 0) {

            escudo = 0;

        }

        vida = vida - danoReal;

        if (vida < 0) {

            vida = 0;

        }

    }
    /**
     * Aumenta o escudo da entidade
     * @param defesa Quantidade que o escudo será aumentado
     */
    public void ganharEscudo(int defesa){
        escudo += defesa;
    }

    public boolean estarVivo(){

        if (vida > 0){
            return true;
        }

        else{
            return false;
        }

    }
    /**
     * Coloca um efeito na lista {@link efeitos} se ele não estiver na lista. Caso contrario soma o acumulo do efeito novo e o que já estava na lista
     * @param novoEfeito 
     */
    public void aplicarEfeito(Efeito novoEfeito){

        boolean jaPossuiEfeito = false;

        // Percorre a lista de efeitos atuais da entidade
        for (Efeito e : efeitos) {

            // Se achar um efeito com o mesmo nome, apenas soma os acúmulos
            if (e.getNome().equals(novoEfeito.getNome())) {

                e.setAcumulo(e.getAcumulo() + novoEfeito.getAcumulo());
                jaPossuiEfeito = true;
                break; // Achou e somou, pode parar o loop

            }
        }

        // Se terminou o loop e não tinha o efeito, adiciona na lista e inscreve no Publisher
        if (!jaPossuiEfeito) {

            efeitos.add(novoEfeito);
            batalha.inscrever(novoEfeito); 

        }
    }
}
