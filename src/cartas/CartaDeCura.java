package cartas;

import batalhas.Batalha;
import batalhas.Evento;
import efeitos.Cura;
import entidades.Heroi;
import entidades.Inimigo;

public class CartaDeCura extends CartaDeEfeito {

    public CartaDeCura(String nome, String descricao, int custo, int efeito, int acumulo, Evento evento,
            Batalha batalha) {
        super(nome, descricao, custo, efeito, acumulo, evento, batalha);
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo){
        Cura cura = new Cura("Cura", heroi, getAcumulo(), getEfeito(), getEvento(), getBatalha());
        notificarCriacaoEfeito(cura);
        heroi.perderEnergia(getCusto());
    }
}
