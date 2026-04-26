// Subclasse para representar o herói do jogo, que é um tipo específico de entidade

package entidades;

import java.util.List;

import baralho.Baralho;
import efeitos.Efeito;
import eventos.batalha.Batalha;
/**
 * Gerencia o herói
 */
public class Heroi extends Entidade {

    private int energia;
    private boolean turno;
    private int ouro;
    private Baralho baralho;
    private int energiaMaxima;
    private int escudoInicial;


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
 * @param energia Energia inicial do herói
 * @param turno Indica se é o turno do herói
 * @param ouro Indica a quantidade de dinheiro do herói
 * @param baralho baralho do heroi
 * @param energiaMaxima maximo de energia que o heroi pode ter
 */
    public Heroi(String nome, String descricao, int vida, int escudo, List<Efeito> efeitos, int vidaMaxima, int energia,
            boolean turno, Batalha batalha, int ouro, Baralho baralho, int energiaMaxima, int escudoInicial) {

        super(nome, descricao, vida, escudo, efeitos, vidaMaxima, batalha);
        this.energia = energia;
        this.turno = turno;
        this.ouro = ouro;
        this.baralho = baralho;
        this.energiaMaxima = energiaMaxima;
        this.escudoInicial = escudoInicial;

    }

    // Getters

    public int getEnergia(){
        return energia;
    }

    public boolean getTurno(){
        return turno;
    }
    
    public int getOuro() {
        return ouro;
    }
    
    public Baralho getBaralho() {
        return baralho;
    }
    
    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    // Setters

    public void setTurno(boolean turno){
        this.turno = turno;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }
    
    public void setOuro(int ouro) {
        this.ouro = ouro;
    }
    
    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }
    
    public void setEnergiaMaxima(int energiaMaxima) {
        this.energiaMaxima = energiaMaxima;
    }
    
    public int getEscudoInicial() {
        return escudoInicial;
    }

    // Outros metodos
    /**
     * Tira energia do herói
     * @param gasto Quantidade que será reduzida da energia
     */
    public void perderEnergia(int gasto){
        energia -= gasto;
    }
    
    public void setEscudoInicial(int escudoInicial) {
        this.escudoInicial = escudoInicial;
    }

    /**
     * Tira ouro do herói
     * @param gasto Quantidade que será reduzida do ouro
     */
    public void perderOuro(int gasto){
        ouro -= gasto;
    }

    /**
     * Aumenta o ouro do herói
     * @param ganho Quantidade que será aumentadda do ouro
     */
    public void ganharOuro(int ganho){
        ouro += ganho;
    }

    /**
     * Aumenta o escudoInicial do herói
     * @param ganho Quantidade que será aumentadada do escudo inicial
     */
    public void ganharEscudoInicial(int ganho){
        escudoInicial += ganho;
    }

    /**
     * Aumenta a energia maxima do herói
     * @param ganho Quantidade que será aumentadada da energia maxima
     */
    public void ganharEnergiaMaxima(int ganho){
        energiaMaxima += ganho;
    }

    

    

    

    

    

    

    
}