public class CartaDeDano extends Carta {
    @Override
    public void usar(heroi nomeHeroi, inimigo nomeInimigo){
            nomeInimigo.receberDano(getEfeito());
            nomeHeroi.perderEnergia(getCusto());
        
    }
}
