package entidades;
import efeitos.*;
import java.util.List;
// Superclasse para representar uma entidade genérica no jogo, como um jogador ou um inimigo

import batalhas.Batalha;

public class Entidade {

    // Atributos
    private String nome;
    private String descricao;
    private int vida;
    private int escudo;
    private List <Efeito> efeitos;
    private int vidaMaxima;
    private Batalha batalha;

    // Construtor
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

    protected void aplicarEfeito(Efeito efeito){
        efeitos.add(efeito);
    }

    

    

    

    

    

    
}
