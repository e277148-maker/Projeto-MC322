package cartas;
import entidades.*;

public class CartaEscudo extends Carta{

    // Construtor
    /**
     * Cria uma carta de escudo com um nome, uma descrição, um custo eum efeito
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
