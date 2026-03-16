public class CartaDeDano extends Carta {

    void usarCartaDano(heroi nomeHeroi, inimigo nomeInimigo){
        nomeInimigo.receberDano(getEfeito());
        nomeHeroi.perderEnergia(getCusto());
    }
}
