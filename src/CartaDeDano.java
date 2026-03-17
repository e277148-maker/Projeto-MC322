public class CartaDeDano {

    String nome;
    int custo;
    int efeito;

    // Metodos para usar carta de dano
    void usarCartaDano(Heroi nomeHeroi, Inimigo nomeInimigo){

        nomeInimigo.receberDano(efeito);
        nomeHeroi.perderEnergia(custo);

    }
}
