package entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import batalhas.Batalha;

public class HeroiTeste {

    class BatalhaFake extends Batalha {
        public BatalhaFake() {
            super(new ArrayList<>(), new ArrayList<>());
        }
    }

    @Test
    void testEnergia() {
        Batalha batalha = new BatalhaFake();

        Heroi h = new Heroi("Heroi", "Teste", 100, 0,
                new ArrayList<>(), 100, 10, true, batalha);

        h.perderEnergia(3);

        assertEquals(7, h.getEnergia());
    }

    @Test
    void testTurno() {
        Batalha batalha = new BatalhaFake();

        Heroi h = new Heroi("Heroi", "Teste", 100, 0,
                new ArrayList<>(), 100, 10, true, batalha);

        h.setTurno(false);

        assertFalse(h.getTurno());
    }
}