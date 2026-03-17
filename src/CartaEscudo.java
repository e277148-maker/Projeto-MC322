public class CartaEscudo extends Carta{

    public void usar(heroi nomeHeroi, inimigo nomeInimigo){
        nomeHeroi.ganharEscudo(getEfeito());
        nomeHeroi.perderEnergia(getCusto());
    }


    void usarCartaInimigo(inimigo nomeInimigo){
        nomeInimigo.ganharEscudo(getEfeito());
    }

}
