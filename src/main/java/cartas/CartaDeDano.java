package cartas;
import entidades.*;


public class CartaDeDano extends Carta {

    // Construtor
    /**
     * Cria uma carta com um nome, uma descrição, um custo e um efeito
     * @param nome Nome da carta
     * @param descricao Descrição da carta
     * @param custo O quanto de energia que é gasto ao usar a carta
     * @param efeito Quantidade de dano que a carta causa se o inimigo não tivar escudo
     */
    public CartaDeDano(String nome, String descricao, int custo, int efeito){

        super(nome, descricao, custo, efeito);

    }
    
    //Sobrescreve o método usar da classe Carta, aplicando o dano ao inimigo e reduzindo a energia do heroi
    @Override
    /**
     * Herói usa a carta de dano
     */
    public void usar(Heroi heroi, Inimigo inimigo){

        inimigo.receberDano(getEfeito());
        heroi.perderEnergia(getCusto());
        
    }
}
