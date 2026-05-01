package baralho;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import entidades.*;
import eventos.batalha.*;
import cartas.Carta;

public class CartaTeste {

    class BatalhaFake extends Batalha {
        public BatalhaFake() {
            super(new ArrayList<>(), new ArrayList<>(), new String(), new ArrayList<>());
        }
    }

    class EventoFake extends EventoDaBatalha {
        public EventoFake() {
            super("EventoFake"); // ajusta se necessário
        }
    }

    class HeroiFake extends Heroi {
        public HeroiFake(Batalha batalha) {
            super("Heroi", "Teste", 100, 0, new ArrayList<>(), 100, 10, true, batalha, 0 , new Baralho(null, null, null), 0, 0);
        }
    }

    class InimigoFake extends Inimigo {
        public InimigoFake(Batalha batalha) {
            super(
                "Inimigo",
                "Teste",
                100,
                0,
                new ArrayList<>(),
                100,
                10,
                batalha,
                2,
                5,
                new ArrayList<>()
            );
        }
    }

    class CartaFake extends Carta {

        public CartaFake() {
            super("Teste", "Descrição", 1, 10);
        }

        @Override
        public void usar(Heroi heroi, Inimigo inimigo) {
            // comportamento vazio
        }
    }

    @Test
    void testConstrutorEGetters() {
        Carta carta = new CartaFake();

        assertEquals("Teste", carta.getNome());
        assertEquals("Descrição", carta.getDescricao());
        assertEquals(1, carta.getCusto());
        assertEquals(10, carta.getEfeito());
    }

    @Test
    void testSetters() {
        Carta carta = new CartaFake();

        carta.setNome("Nova");
        carta.setDescricao("Nova desc");
        carta.setCusto(5);
        carta.setEfeito(20);

        assertEquals("Nova", carta.getNome());
        assertEquals("Nova desc", carta.getDescricao());
        assertEquals(5, carta.getCusto());
        assertEquals(20, carta.getEfeito());
    }

    @Test
    void testUsarCartaSemErro() {

        Batalha batalha = new BatalhaFake();

        Heroi h = new HeroiFake(batalha);
        Inimigo i = new InimigoFake(batalha);

        Carta carta = new CartaFake();

        assertDoesNotThrow(() -> carta.usar(h, i));
    }
}