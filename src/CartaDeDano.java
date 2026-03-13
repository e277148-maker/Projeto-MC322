public class CartaDeDano {
    String nome;
    int custo;
    int efeito;

    void usarCartaDano(heroi nomeHeroi, inimigo nomeInimigo){
        nomeInimigo.receberDano(efeito);
        nomeHeroi.perderEnergia(custo);
    }
}
