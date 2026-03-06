public class CartaEscudo {
    String nome;
    int custo;
    int efeito;

    void usarCarta(heroi nomeHeroi){
        nomeHeroi.ganharEscudo(efeito);
        nomeHeroi.perderEnergia(custo);
    }
}
