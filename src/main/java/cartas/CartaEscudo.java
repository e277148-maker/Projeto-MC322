package cartas;
import entidades.*;
/**
 * Gerencia as cartas de escudo
 */
public class CartaEscudo extends Carta{

    // Construtor
    /**
     * Inicializas uma carta de escudo
     * @param nome Nome da carta
     * @param descricao Descrição da carta
     * @param custo Energia gasta ao usar a carta
     * @param efeito Quantidade de escudo que o herói ganha
     */
    public CartaEscudo(String nome, String descricao, int custo, int efeito) {

        super(nome, descricao, custo, efeito);

    }

    // Sobrescreve o método usar da classe Carta, aplicando o escudo ao heroi e reduzindo a energia do heroi
    @Override
    public void usar(Heroi heroi, Inimigo inimigo){

        heroi.ganharEscudo(getEfeito());
        heroi.perderEnergia(getCusto());

    }

}
