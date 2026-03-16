public class CartaEscudo extends Carta{

    void usarCartaHeroi(heroi nomeHeroi){
        nomeHeroi.ganharEscudo(getEfeito());
        nomeHeroi.perderEnergia(getCusto());
    }


    void usarCartaInimigo(inimigo nomeInimigo){
        nomeInimigo.ganharEscudo(getEfeito());
    }

}
