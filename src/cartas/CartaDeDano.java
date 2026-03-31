package cartas;
import entidades.*;


public class CartaDeDano extends Carta {

    // Construtor
    public CartaDeDano(String nome, String descricao, int custo, int efeito){

        super(nome, descricao, custo, efeito);

    }
    
    //Sobrescreve o método usar da classe Carta, aplicando o dano ao inimigo e reduzindo a energia do heroi
    @Override
    public void usar(Heroi heroi, Inimigo inimigo){

        inimigo.receberDano(getEfeito());
        heroi.perderEnergia(getCusto());
        
    }
}
