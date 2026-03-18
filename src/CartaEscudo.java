public class CartaEscudo extends Carta{

    public void usar(heroi heroi, inimigo inimigo){
        heroi.ganharEscudo(getEfeito());
        heroi.perderEnergia(getCusto());
    }

}
