public class CartaDeDano extends Carta {
    @Override
    public void usar(heroi heroi, inimigo inimigo){
            inimigo.receberDano(getEfeito());
            heroi.perderEnergia(getCusto());
        
    }
}
