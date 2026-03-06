public class CartaDeDano {
    String nome;
    int custo;
    int efeito;

    void usarCarta(heroi nomeHeroi, inimigo nomeInimigo){
        nomeInimigo.receberDano(efeito);
        nomeHeroi.perderEnergia(custo);
    }
}
