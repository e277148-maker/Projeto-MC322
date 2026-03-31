package cartas;
import entidades.*;

public class CartaEscudo extends Carta{

    // Construtor
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
