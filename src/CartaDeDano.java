public class CartaDeDano extends Carta {

    // Construtor
    public CartaDeDano(String nome, String descricao, int custo, int efeito){

        super(nome, descricao, custo, efeito);

    }
    

    @Override
    public void usar(Heroi heroi, Inimigo inimigo){

        inimigo.receberDano(getEfeito());
        heroi.perderEnergia(getCusto());
        
    }
}
