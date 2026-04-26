package efeito;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import efeitos.*;
import eventos.*;

public class EfeitoTeste {

    class EventoFake extends EventoDaBatalha {
        public EventoFake() {
            super("EventoFake");
        }
    }

    class EfeitoFake extends Efeito {

        private boolean executou = false;

        public EfeitoFake() {
            super("Fake", null, 1, 1, new EventoFake(), null);
        }

        @Override
        public void aplicarEfeito() {
            executou = true;
        }

        @Override
        public void serNotificado(EventoDaBatalha e) {}

        public boolean foiExecutado() {
            return executou;
        }

        // wrapper pra contornar protected (JEITO CERTO DE TESTE)
        public void executar() {
            aplicarEfeito();
        }
    }

    @Test
    void testEfeitoExecutaCorretamente() {
        EfeitoFake e = new EfeitoFake();

        e.executar();

        assertTrue(e.foiExecutado());
    }

    @Test
    void testMultiplaExecucaoNaoQuebra() {
        EfeitoFake e = new EfeitoFake();

        e.executar();
        e.executar();

        assertTrue(e.foiExecutado());
    }

    @Test
    void testNotificacaoNaoQuebra() {
        EventoFake evento = new EventoFake();

        EfeitoFake e = new EfeitoFake();

        assertDoesNotThrow(() -> {
            e.serNotificado(evento);
        });
    }

    @Test
    void testCriacaoEfeitoConcreto() {
        EventoFake evento = new EventoFake();

        EfeitoFake e = new EfeitoFake();

        assertNotNull(evento);
        assertNotNull(e);
        
    }
}