package entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import batalhas.Batalha;
import batalhas.EventoDaBatalha;

public class InimigoTeste {

    class BatalhaFake extends Batalha {
        public BatalhaFake() {
            super(new ArrayList<>(), new ArrayList<>(), "NomeTeste");
        }
    }

    class EventoFake extends EventoDaBatalha {
        public EventoFake() {
            super("EventoFake");
        }
    }

    class HeroiFake extends Heroi {
        public HeroiFake(Batalha batalha) {
            super("Heroi", "Teste", 100, 0, new ArrayList<>(), 100, 10, true, batalha);
        }
    }

    @Test
    void testAtaque() {
        Batalha batalha = new BatalhaFake();
        Heroi heroi = new HeroiFake(batalha);

        Inimigo inimigo = new Inimigo(
            "Inimigo", "Teste", 100, 0,
            new ArrayList<>(), 100,
            10, batalha,
            2, 5,
            new ArrayList<>()
        );

        int vidaAntes = heroi.getVida();

        inimigo.atacar(heroi);

        assertTrue(heroi.getVida() < vidaAntes);
    }

    @Test
    void testSettersEGetters() {
        Batalha batalha = new BatalhaFake();

        Inimigo inimigo = new Inimigo(
            "Inimigo", "Teste", 100, 0,
            new ArrayList<>(), 100,
            10, batalha,
            2, 5,
            new ArrayList<>()
        );

        inimigo.setDano_ataque(20);
        inimigo.setDuraçaoEfeito(3);
        inimigo.setDanoEfeito(7);

        assertEquals(20, inimigo.getDano_ataque());
        assertEquals(3, inimigo.getDuraçaoEfeito());
        assertEquals(7, inimigo.getDanoEfeito());
    }

    @Test
    void testEnvenenarNaoQuebra() {
        Batalha batalha = new BatalhaFake();
        Heroi heroi = new HeroiFake(batalha);

        List<EventoDaBatalha> eventos = new ArrayList<>();
        eventos.add(new EventoFake());

        Inimigo inimigo = new Inimigo(
            "Inimigo", "Teste", 100, 0,
            new ArrayList<>(), 100,
            10, batalha,
            2, 5,
            eventos
        );

        assertDoesNotThrow(() -> inimigo.envenenar(heroi));
    }

    @Test
    void testCurarNaoQuebra() {
        Batalha batalha = new BatalhaFake();

        List<EventoDaBatalha> eventos = new ArrayList<>();
        eventos.add(new EventoFake());
        eventos.add(new EventoFake()); // importante (índice 1)

        Inimigo inimigo = new Inimigo(
            "Inimigo", "Teste", 100, 0,
            new ArrayList<>(), 100,
            10, batalha,
            2, 5,
            eventos
        );

        assertDoesNotThrow(() -> inimigo.curar(inimigo));
}

}