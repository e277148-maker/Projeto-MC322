package geral;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import entidades.*;
import batalhas.*;
import cartas.*;

public class SmokeTest {

    class BatalhaFake extends Batalha {
        public BatalhaFake() {
            super(new ArrayList<>(), new ArrayList<>(), "NomeTeste");
        }
    }

    class EventoFake extends Evento {
        public EventoFake() {
            super("EventoFake");
        }
    }

    class CartaFake extends Carta {
        public CartaFake() {
            super("Carta", "desc", 1, 1);
        }

        @Override
        public void usar(Heroi h, Inimigo i) {}
    }

    @Test
    void testFluxoBasicoJogo() {

        Batalha batalha = new BatalhaFake();

        List<Evento> eventos = new ArrayList<>();
        eventos.add(new EventoFake());
        eventos.add(new EventoFake());

        Heroi heroi = new Heroi("Heroi", "desc", 100, 0,
                new ArrayList<>(), 100, 10, true, batalha);

        Inimigo inimigo = new Inimigo("Inimigo", "desc", 100, 0,
                new ArrayList<>(), 100, 10,
                batalha, 2, 5, eventos);

        // interações
        inimigo.atacar(heroi);
        inimigo.envenenar(heroi);
        inimigo.curar(inimigo);

        heroi.perderEnergia(2);

        Carta carta = new CartaFake();
        carta.usar(heroi, inimigo);

        assertTrue(true); // só pra garantir execução
    }
}
