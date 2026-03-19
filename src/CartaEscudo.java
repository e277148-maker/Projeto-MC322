public class CartaEscudo extends Carta{

    // Construtor
    public CartaEscudo(String nome, String descricao, int custo, int efeito) {

        super(nome, descricao, custo, efeito);

    }

    public void usar(Heroi heroi, Inimigo inimigo){

        heroi.ganharEscudo(getEfeito());
        heroi.perderEnergia(getCusto());

    }

}
