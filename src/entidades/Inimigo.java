package entidades;
// Subclasse para representar um inimigo do jogo, que é um tipo específico de entidade

import java.util.List;

import batalhas.Batalha;
import batalhas.Evento;
import efeitos.Efeito;
import efeitos.Veneno;

public class Inimigo extends Entidade{

    private int dano_ataque;
    private Batalha batalha;
    private int duraçaoEfeito;
    private int danoEfeito;
    private List <Evento> eventos;

    // Construtor
    public Inimigo(String nome, String descricao, int vida, int escudo, List<Efeito> efeitos, int dano_ataque,
            Batalha batalha, int duraçaoEfeito, int danoEfeito, List<Evento> eventos) {
        super(nome, descricao, vida, escudo, efeitos);
        this.dano_ataque = dano_ataque;
        this.batalha = batalha;
        this.duraçaoEfeito = duraçaoEfeito;
        this.danoEfeito = danoEfeito;
        this.eventos = eventos;
    }
    // Getters

    public int getAtaque(){
        return dano_ataque;
    }
    
    public int getDano_ataque() {
        return dano_ataque;
    }

    public Batalha getBatalha() {
        return batalha;
    }

    public int getDuraçaoEfeito() {
        return duraçaoEfeito;
    }

    public int getDanoEfeito() {
        return danoEfeito;
    }

    public List<Evento> getEventos() {
        return eventos;
    }


    // Setters

    public void setAtaque(int ataque){
        this.dano_ataque = ataque;
    }
    
    public void setDano_ataque(int dano_ataque) {
        this.dano_ataque = dano_ataque;
    }
    
    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }
    
    public void setDuraçaoEfeito(int duraçaoEfeito) {
        this.duraçaoEfeito = duraçaoEfeito;
    }
    public void setDanoEfeito(int danoEfeito) {
        this.danoEfeito = danoEfeito;
    }
    
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    //Outros metodos

    public void atacar(Heroi nomeHeroi){
        nomeHeroi.receberDano(dano_ataque);
    }

    private void notificarCriacaoEfeito(Efeito efeito){
        batalha.serNotificadoCriacaoEfeito(efeito);
    }

    public void envenenar(Heroi nomeHeroi){
        Veneno veneno = new Veneno("veneno", nomeHeroi, duraçaoEfeito, danoEfeito, eventos.get(0));
        notificarCriacaoEfeito(veneno);
    }

    
    

}

