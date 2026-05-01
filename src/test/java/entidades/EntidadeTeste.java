package entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import eventos.batalha.*;
import efeitos.Efeito;

// Classe de teste
public class EntidadeTeste {

    class EntidadeFake extends Entidade {

        public EntidadeFake(int vida, int escudo, List<Efeito> efeitos, Batalha batalha) {
            super("Fake", "Teste", vida, escudo, efeitos, vida, batalha);
        }
    }

class EfeitoFake extends Efeito {

    public EfeitoFake(String nome, Entidade dono, int acumulo, Batalha batalha) {
        super(nome, dono, acumulo, 0, null, batalha);
    }

    @Override
    protected void aplicarEfeito() {
        // Não faz nada (suficiente pro teste)
    }
}

    @Test
    void testAplicarEfeitoNovo() {
        List<Efeito> efeitos = new ArrayList<>();
        Batalha batalha = new Batalha(new ArrayList<>(), new ArrayList<>(), "NomeTeste", new ArrayList<>());

        Entidade e = new EntidadeFake(100, 0, efeitos, batalha);

        Efeito efeito = new EfeitoFake("Veneno", e, 2, batalha);

        e.aplicarEfeito(efeito);

        assertEquals(1, e.getEfeitos().size());
    }

    @Test
    void testAcumularEfeito() {
        List<Efeito> efeitos = new ArrayList<>();
        Batalha batalha = new Batalha(new ArrayList<>(), new ArrayList<>(), "NomeTeste", new ArrayList<>());

        Entidade e = new EntidadeFake(100, 0, efeitos, batalha);

        Efeito e1 = new EfeitoFake("Veneno", e, 2, batalha);
        Efeito e2 = new EfeitoFake("Veneno", e, 3, batalha);

        e.aplicarEfeito(e1);
        e.aplicarEfeito(e2);

        assertEquals(1, e.getEfeitos().size());
        assertEquals(5, e.getEfeitos().get(0).getAcumulo());
    }
}