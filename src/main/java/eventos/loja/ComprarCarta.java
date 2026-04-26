package eventos.loja;

import java.util.List;

import baralho.Baralho;
import cartas.Carta;
import entidades.Heroi;

public class ComprarCarta implements ItemLoja {
    
    private Carta carta;


    public ComprarCarta(Carta carta) {
        this.carta = carta;
    }

    public String getNome(){
        return carta.getNome();
    }

    public int getPreco(){
        return 10;
    }

    public void aplicar(Heroi heroi){
        Baralho baralho = heroi.getBaralho();
        List <Carta> pilhaDeCompra = baralho.getPilhaDeCompras();
        pilhaDeCompra.add(carta);
        heroi.getBaralho().setPilhaDeCompra(pilhaDeCompra);

        heroi.perderOuro(getPreco());
    }
}
