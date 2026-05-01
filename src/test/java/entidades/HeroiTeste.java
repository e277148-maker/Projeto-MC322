package entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import eventos.batalha.*;
import baralho.Baralho;

public class HeroiTeste {

    class BatalhaFake extends Batalha {
        public BatalhaFake() {
            super(new ArrayList<>(), new ArrayList<>(), "NomeTeste", new ArrayList<>());
        }
    }

    @Test
    void testEnergia() {
        Batalha batalha = new BatalhaFake();

        Heroi h = new Heroi("Heroi", "Teste", 100, 0,
                new ArrayList<>(), 100, 10, true, batalha, 0, new Baralho(null, null, null), 0, 0);

        h.perderEnergia(3);

        assertEquals(7, h.getEnergia());
    }

    @Test
    void testTurno() {
        Batalha batalha = new BatalhaFake();

        Heroi h = new Heroi("Heroi", "Teste", 100, 0,
                new ArrayList<>(), 100, 10, true, batalha, 0, new Baralho(null, null, null), 0, 0);

        h.setTurno(false);

        assertFalse(h.getTurno());
    }
}