package baralho;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import cartas.Carta;

public class BaralhoTeste {

    class CartaFake extends Carta {
        public CartaFake(String nome) {
            super(nome, "desc", 1, 1);
        }

        @Override
        public void usar(entidades.Heroi h, entidades.Inimigo i) {}
    }

    @Test
    void testComprarCartaNormal() {
        List<Carta> compra = new ArrayList<>();
        List<Carta> descarte = new ArrayList<>();
        List<Carta> mao = new ArrayList<>();

        compra.add(new CartaFake("A"));

        Baralho b = new Baralho(compra, descarte, mao);

        b.comprarCarta();

        assertEquals(0, b.getPilhaDeCompras().size());
        assertEquals(1, b.getMao().size());
    }

    @Test
    void testComprarCartaComEmbaralhamento() {
        List<Carta> compra = new ArrayList<>();
        List<Carta> descarte = new ArrayList<>();
        List<Carta> mao = new ArrayList<>();

        descarte.add(new CartaFake("B"));

        Baralho b = new Baralho(compra, descarte, mao);

        b.comprarCarta();

        // carta foi embaralhada e comprada
        assertEquals(0, b.getPilhaDeDescarte().size());
        assertEquals(1, b.getMao().size());
    }

    @Test
    void testComprarCartaSemNada() {
        Baralho b = new Baralho(
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>()
        );

        b.comprarCarta();

        assertEquals(0, b.getMao().size());
    }

    @Test
    void testDescartarCarta() {
        List<Carta> compra = new ArrayList<>();
        List<Carta> descarte = new ArrayList<>();
        List<Carta> mao = new ArrayList<>();

        Carta c = new CartaFake("C");
        mao.add(c);

        Baralho b = new Baralho(compra, descarte, mao);

        b.descartar(c);

        assertEquals(0, b.getMao().size());
        assertEquals(1, b.getPilhaDeDescarte().size());
    }

    @Test
    void testDescartarMao() {
        List<Carta> compra = new ArrayList<>();
        List<Carta> descarte = new ArrayList<>();
        List<Carta> mao = new ArrayList<>();

        mao.add(new CartaFake("A"));
        mao.add(new CartaFake("B"));

        Baralho b = new Baralho(compra, descarte, mao);

        b.descartarMao();

        assertEquals(0, b.getMao().size());
        assertEquals(2, b.getPilhaDeDescarte().size());
    }

    @Test
    void testVerTopoBaralhoComCarta() {
        List<Carta> compra = new ArrayList<>();
        compra.add(new CartaFake("Topo"));

        Baralho b = new Baralho(compra, new ArrayList<>(), new ArrayList<>());

        assertEquals("Topo", b.verTopoBaralho());
    }

    @Test
    void testVerTopoBaralhoVazio() {
        Baralho b = new Baralho(
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>()
        );

        assertEquals("Nenhuma (Embaralho iminente)", b.verTopoBaralho());
    }

    @Test
    void testSetters() {
        Baralho b = new Baralho(
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>()
        );

        List<Carta> novaCompra = new ArrayList<>();
        List<Carta> novoDescarte = new ArrayList<>();
        List<Carta> novaMao = new ArrayList<>();

        b.setPilhaDeCompra(novaCompra);
        b.setPilhaDeDescarte(novoDescarte);
        b.setMao(novaMao);

        assertEquals(novaCompra, b.getPilhaDeCompras());
        assertEquals(novoDescarte, b.getPilhaDeDescarte());
        assertEquals(novaMao, b.getMao());
    }
}