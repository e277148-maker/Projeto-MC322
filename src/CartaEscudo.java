public class CartaEscudo {
    String nome;
    int custo;
    int efeito;

    void usarCartaHeroi(heroi nomeHeroi){
        nomeHeroi.ganharEscudo(efeito);
        nomeHeroi.perderEnergia(custo);
    }


    void usarCartaInimigo(inimigo nomeInimigo){
        nomeInimigo.ganharEscudo(efeito);
    }

}
