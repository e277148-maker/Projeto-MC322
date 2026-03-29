package cartas;
import entidades.*;
import batalhas.*;
import efeitos.*;

public class CartaDeVeneno extends CartaDeEfeito {

    // Construtor
    public CartaDeVeneno(String nome, String descricao, int custo, int efeito, int acumulo, Evento evento, Batalha batalha) {
        super(nome, descricao, custo, efeito, acumulo, evento, batalha);
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo){
        Veneno veneno = new Veneno("veneno", inimigo, getAcumulo(), getEfeito(), getEvento(), getBatalha());
        notificarCriacaoEfeito(veneno);
        heroi.perderEnergia(getCusto());
    }

}
