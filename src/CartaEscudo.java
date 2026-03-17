public class CartaEscudo {

    String nome;

    int custo;
    int efeito;

    // metodos para usar carta de escudo no heroi
    void usarCartaHeroi(Heroi nomeHeroi){
        nomeHeroi.ganharEscudo(efeito);
        nomeHeroi.perderEnergia(custo);
    }

    // metodo para usar carta de escudo no inimigo
    void usarCartaInimigo(Inimigo nomeInimigo){
        nomeInimigo.ganharEscudo(efeito);
    }

}
