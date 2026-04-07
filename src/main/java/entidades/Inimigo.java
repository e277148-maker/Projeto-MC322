// Subclasse para representar um inimigo do jogo, que é um tipo específico de entidade

package entidades;

import java.util.List;

import batalhas.*;
import efeitos.*;
/**
 * Gerencia os inimigos
 */
public class Inimigo extends Entidade{

    private int dano_ataque;
    private int duraçaoEfeito;
    private int danoEfeito;
    private List <Evento> eventos;

    // Construtor
/**
 * Inicializa um inimigo
 * @param nome Nome do inimigo
 * @param descricao Descrição do inimigo
 * @param vida Vida do inimigo
 * @param escudo Escudo do inimigo
 * @param efeitos Efeitos ativos no inimigo
 * @param vidaMaxima Vida maxima do inimigo
 * @param dano_ataque Dano base que o inimigo causa ao herói
 * @param batalha Batalha ao qual o inimigo pertence
 * @param duraçaoEfeito Duração do efeito causado pelo inimigo
 * @param danoEfeito Poder do efeito causado pelo inimigo
 * @param eventos Lista de eventos no qual efeitos são aplicados
 */
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
    /**
     * Ataca o heroi, causando dano nele
     * @param nomeHeroi Herói que será atacado
     */
    public void atacar(Heroi nomeHeroi){
        nomeHeroi.receberDano(dano_ataque);
    }
    /**
     * Envenena o herói
     * @param nomeHeroi Herói que será envenenado
     */
    public void envenenar(Heroi nomeHeroi){
        Veneno veneno = new Veneno("Veneno", nomeHeroi, duraçaoEfeito, danoEfeito, eventos.get(0), getBatalha());
        nomeHeroi.aplicarEfeito(veneno);
    }
    /**
     * Cria um efeito de cura no propio inimigo
     * @param inimigo Inimigo que será curado
     */
    public void curar(Inimigo inimigo){
        Cura cura = new Cura("Cura", inimigo, duraçaoEfeito, danoEfeito, eventos.get(1), getBatalha());
        inimigo.aplicarEfeito(cura);
    }

}

