package batalha;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import entidades.*;
import efeitos.*;
import baralho.*;
import batalhas.Batalha;
import batalhas.Evento;
import cartas.*;

public class BatalhaTeste {

    class EventoFake extends Evento {
        public EventoFake() {
            super("EventoFake");
        }
    }

    class EfeitoFake extends Efeito {

        public EfeitoFake() {
            super("Fake", null, 1, 1, new EventoFake(), null);
        }

        @Override
        public void aplicarEfeito() {}

        @Override
        public void serNotificado(Evento e) {}
    }

    class CartaFake extends Carta {
        public CartaFake() {
            super("Carta", "desc", 1, 1);
        }

        @Override
        public void usar(Heroi h, Inimigo i) {
            i.setVida(i.getVida() - 5); // garante interação
        }
    }

    @Test
    void testPublisherSistema() {
        List<Efeito> efeitos = new ArrayList<>();
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new EventoFake());

        Batalha batalha = new Batalha(efeitos, eventos);

        EfeitoFake efeito = new EfeitoFake();

        batalha.inscrever(efeito);
        assertEquals(1, batalha.getSubscribersEfeito().size());

        batalha.desinscrever(efeito);
        assertEquals(0, batalha.getSubscribersEfeito().size());
    }

    @Test
    void testGettersSetters() {
        Batalha b = new Batalha(new ArrayList<>(), new ArrayList<>());

        List<Evento> eventos = new ArrayList<>();
        List<Efeito> efeitos = new ArrayList<>();

        b.setEventos(eventos);
        b.setSubscribersEfeito(efeitos);

        assertEquals(eventos, b.getEventos());
        assertEquals(efeitos, b.getSubscribersEfeito());
    }

    @Test
    void testRodarBatalhaSaiRapido() {

        // eventos obrigatórios (usa index 0 e 1!)
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new EventoFake());
        eventos.add(new EventoFake());

        Batalha batalha = new Batalha(new ArrayList<>(), eventos);

        Heroi heroi = new Heroi(
            "Heroi", "desc",
            1, // VIDA BAIXA -> MORRE RÁPIDO
            0,
            new ArrayList<>(),
            100,
            10,
            true,
            batalha
        );

        List<Evento> eventosInimigo = new ArrayList<>();
        eventosInimigo.add(new EventoFake());
        eventosInimigo.add(new EventoFake());

        Inimigo inimigo = new Inimigo(
            "Inimigo", "desc",
            100,
            0,
            new ArrayList<>(),
            100,
            50, // DANO ALTO -> mata rápido
            batalha,
            1,
            1,
            eventosInimigo
        );

        List<Inimigo> inimigos = new ArrayList<>();
        inimigos.add(inimigo);

        // baralho mínimo
        List<Carta> compra = new ArrayList<>();
        List<Carta> descarte = new ArrayList<>();
        List<Carta> mao = new ArrayList<>();

        compra.add(new CartaFake());

        Baralho baralho = new Baralho(compra, descarte, mao);

        // Scanner fake → sempre encerra turno (opção 0)
        Scanner scanner = new Scanner(new java.io.ByteArrayInputStream("0\n".repeat(100).getBytes()));

        assertDoesNotThrow(() -> {
            batalha.rodarBatalha(baralho, heroi, inimigos, scanner);
        });
    }
}