package entidades;
// Subclasse para representar um inimigo do jogo, que é um tipo específico de entidade

import java.util.List;

import batalhas.Batalha;
import batalhas.Evento;
import efeitos.Cura;
import efeitos.Efeito;
import efeitos.Veneno;

public class Inimigo extends Entidade{

    private int dano_ataque;
    private int duraçaoEfeito;
    private int danoEfeito;
    private List <Evento> eventos;

    

    // Construtor
    public Inimigo(String nome, String descricao, int vida, int escudo, List<Efeito> efeitos, int vidaMaxima,
            int dano_ataque, Batalha batalha, int duraçaoEfeito, int danoEfeito, List<Evento> eventos) {
        super(nome, descricao, vida, escudo, efeitos, vidaMaxima, batalha);
        this.dano_ataque = dano_ataque;
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
        getBatalha().serNotificadoCriacaoEfeito(efeito);
    }

    public void envenenar(Heroi nomeHeroi){
        Veneno veneno = new Veneno("Veneno", nomeHeroi, duraçaoEfeito, danoEfeito, eventos.get(0), getBatalha());
        notificarCriacaoEfeito(veneno);
    }

    public void curar(Inimigo inimigo){
        Cura cura = new Cura("Cura", inimigo, duraçaoEfeito, danoEfeito, eventos.get(1), getBatalha());
        notificarCriacaoEfeito(cura);
    }

}

