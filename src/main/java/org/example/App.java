/* Este código é a classe principal do jogo, onde a execução começa. 
 * Ele cria os eventos, a batalha, as cartas, o herói e o inimigo, e inicia a batalha. 
 * O código também inclui interações com o jogador para escolher o nome do herói e exibe mensagens de boas-vindas e instruções durante o jogo.
 */

// Importações das classes necessárias para o funcionamento do jogo
package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.tree.DefaultMutableTreeNode;

import batalhas.*;
import cartas.*;
import efeitos.Efeito;
import entidades.Heroi;
import entidades.Inimigo;
import baralho.Baralho;
/**
 * Roda o código principal
 */
public class App {

        // Método principal onde a execução do programa começa
        public static void main(String[] args) throws Exception {

                // Criar eventos

                EventoDaBatalha fimDeTurnoHeroi = new EventoDaBatalha("fimDeTurnoHeroi"); 
                EventoDaBatalha fimDeTurnoInimigo = new EventoDaBatalha("fimDeTurnoInimigo");

                // Criar lista de eventos
                List <EventoDaBatalha> eventos = new ArrayList<>();
                eventos.add(fimDeTurnoHeroi); // Indice 0 na lista de eventos
                eventos.add(fimDeTurnoInimigo); // Indice 1 na lista de eventos

                // Criar batalha
                List <Efeito> subscribersEfeito = new ArrayList<>();
                List <Inimigo> listaProvisoria = new ArrayList<>();

                Batalha batalha01 = new Batalha(subscribersEfeito, eventos, "batalha01", listaProvisoria);
                Batalha batalha11 = new Batalha(subscribersEfeito, eventos, "batalha11", listaProvisoria);
                Batalha batalha12 = new Batalha(subscribersEfeito, eventos, "batalha12", listaProvisoria);
                Batalha batalha21 = new Batalha(subscribersEfeito, eventos, "batalha21",listaProvisoria);
                Batalha batalha22 = new Batalha(subscribersEfeito, eventos, "batalha22", listaProvisoria);
                Batalha batalha23 = new Batalha(subscribersEfeito, eventos, "batalha23", listaProvisoria);
                Batalha batalha24 = new Batalha(subscribersEfeito, eventos, "batalha24", listaProvisoria);

                // Criar arvore de batalhas

                DefaultMutableTreeNode batalha_01 = new DefaultMutableTreeNode(batalha01);

                DefaultMutableTreeNode batalha_11 = new DefaultMutableTreeNode(batalha11);
                batalha_01.add(batalha_11);
                DefaultMutableTreeNode batalha_12 = new DefaultMutableTreeNode(batalha12);
                batalha_01.add(batalha_12);
                
                DefaultMutableTreeNode batalha_21 = new DefaultMutableTreeNode(batalha21);
                batalha_11.add(batalha_21);
                DefaultMutableTreeNode batalha_22 = new DefaultMutableTreeNode(batalha22);
                batalha_11.add(batalha_22);

                DefaultMutableTreeNode batalha_23 = new DefaultMutableTreeNode(batalha23);
                batalha_01.add(batalha_23);
                DefaultMutableTreeNode batalha_24 = new DefaultMutableTreeNode(batalha24);
                batalha_01.add(batalha_24);
                


                // Inicializar cartas, entidades e eventos(com construtores)
                List <Efeito> efeitos = new ArrayList<>();

                Heroi heroi = new Heroi(null, null, 100, 0, efeitos, 100, 0, false, batalha01, 0);

                // Criar a lista de inimigos
                List<Inimigo> inimigos01 = new ArrayList<>();
                List<Inimigo> inimigos11 = new ArrayList<>();
                List<Inimigo> inimigos12 = new ArrayList<>();
                List<Inimigo> inimigos21 = new ArrayList<>();
                List<Inimigo> inimigos22 = new ArrayList<>();
                List<Inimigo> inimigos23 = new ArrayList<>();
                List<Inimigo> inimigos24 = new ArrayList<>();

                List<List <Inimigo>> inimigos = new ArrayList<>();

                // Criar inimigos e adiciona na lista
                Inimigo goblin = new Inimigo("Goblin Raivoso", "Pequeno e irritante", 30, 0, new ArrayList<>(), 30, 10, batalha01, 3, 5, eventos);
                Inimigo orc1 = new Inimigo("Orc Brucutu", "Forte, mas lento", 45, 0, new ArrayList<>(), 45, 15, batalha01, 3, 5, eventos);
                Inimigo slime = new Inimigo("Slime Venenoso", "Gosmento", 25, 0, new ArrayList<>(), 25, 8, batalha01, 3, 5, eventos);

                Inimigo rato1 = new Inimigo("Rato", "Pequeno e irritante", 35, 0, new ArrayList<>(), 35, 15, batalha11, 3, 5, eventos);
                Inimigo rato2 = new Inimigo("Rato", "Pequeno e irritante", 35, 0, new ArrayList<>(), 35, 15, batalha11, 3, 5, eventos);
                Inimigo escorpião = new Inimigo("Escorpião", "Muito venenoso", 35, 0, new ArrayList<>(), 35, 10, batalha11, 3, 9, eventos);

                Inimigo orc2 = new Inimigo("Orc Brucutu", "Forte, mas lento", 45, 0, new ArrayList<>(), 45, 15, batalha12, 3, 5, eventos);
                Inimigo orc3 = new Inimigo("Orc Brucutu", "Forte, mas lento", 45, 0, new ArrayList<>(), 45, 15, batalha12, 3, 5, eventos);
                Inimigo orc4 = new Inimigo("Orc Brucutu", "Forte, mas lento", 45, 0, new ArrayList<>(), 45, 15, batalha12, 3, 5, eventos);

                Inimigo bandoDeGoblins1 = new Inimigo("Bando de Goblins Raivosos", "Pequenos e irritantes", 60, 0, new ArrayList<>(), 60, 9, batalha21, 3, 5, eventos);
                Inimigo bandoDeGoblins2 = new Inimigo("Bando de Goblins Raivosos", "Pequenos e irritantes", 60, 0, new ArrayList<>(), 60, 9, batalha21, 3, 5, eventos);
                Inimigo aranhaGigante = new Inimigo("Aranha Gigante", "Grande e agressiva", 50, 0, new ArrayList<>(), 50, 20, batalha21, 4, 7, eventos);

                Inimigo bruxa1 = new Inimigo("Bruxa", "Velha e perigosa", 40, 0, new ArrayList<>(), 40, 10, batalha22, 5, 10, eventos);
                Inimigo bruxa2 = new Inimigo("Bruxa", "Velha e perigosa", 40, 0, new ArrayList<>(), 40, 10, batalha22, 5, 10, eventos);
                Inimigo gigante = new Inimigo("Gigante", "Grande, mas lento", 70, 0, new ArrayList<>(), 70, 15, batalha22, 3, 5, eventos);

                Inimigo dragao1 = new Inimigo("Dragao", "Voa e cospe fogo", 50, 0, new ArrayList<>(), 50, 30, batalha23, 2, 2, eventos);
                Inimigo dragao2 = new Inimigo("Dragao", "Voa e cospe fogo", 50, 0, new ArrayList<>(), 50, 30, batalha23, 2, 2, eventos);
                Inimigo dragao3 = new Inimigo("Dragao", "Voa e cospe fogo", 50, 0, new ArrayList<>(), 50, 30, batalha23, 2, 2, eventos);

                Inimigo bandoDeOrcs1 = new Inimigo("Bando de Orcs", "Fortes e bravos", 65, 0, new ArrayList<>(), 65, 20, batalha23, 2, 2, eventos);
                Inimigo bandoDeOrcs2 = new Inimigo("Bando de Orcs", "Fortes e bravos", 65, 0, new ArrayList<>(), 65, 20, batalha23, 2, 2, eventos);
                Inimigo bandoDeOrcs3 = new Inimigo("Bando de Orcs", "Fortes e bravos", 65, 0, new ArrayList<>(), 65, 20, batalha23, 2, 2, eventos);

                inimigos01.add(goblin);
                inimigos01.add(orc1);
                inimigos01.add(slime);
                batalha01.setInimigos(inimigos01);

                inimigos11.add(rato1);
                inimigos11.add(rato2);
                inimigos11.add(escorpião);
                batalha11.setInimigos(inimigos11);

                inimigos12.add(orc2);
                inimigos12.add(orc3);
                inimigos12.add(orc4);
                batalha12.setInimigos(inimigos12);

                inimigos21.add(bandoDeGoblins1);
                inimigos21.add(bandoDeGoblins2);
                inimigos21.add(aranhaGigante);
                batalha21.setInimigos(inimigos21);

                inimigos22.add(gigante);
                inimigos22.add(bruxa1);
                inimigos22.add(bruxa2);
                batalha22.setInimigos(inimigos22);

                inimigos23.add(dragao1);
                inimigos23.add(dragao2);
                inimigos23.add(dragao3);
                batalha23.setInimigos(inimigos23);

                inimigos24.add(bandoDeOrcs1);
                inimigos24.add(bandoDeOrcs2);
                inimigos24.add(bandoDeOrcs3);
                batalha24.setInimigos(inimigos24);

                inimigos.add(inimigos01);
                inimigos.add(inimigos11);
                inimigos.add(inimigos12);
                inimigos.add(inimigos21);
                inimigos.add(inimigos22);
                inimigos.add(inimigos23);
                inimigos.add(inimigos24);


                CartaDeDano carta_espada = new CartaDeDano("Espada", "Uma espada afiada que causa dano ao inimigo.", 2, 10);
                CartaDeDano carta_machado = new CartaDeDano("Machado", "Um machado antigo pesado de manusear.", 4, 15);
                CartaDeDano carta_cajado = new CartaDeDano("Cajado", "Um cajado mágico que causa dano elemental.", 3, 12);
                CartaDeDano carta_adagas = new CartaDeDano("Adagas", "Uma par de adagas afiadas e ágeis.", 1, 8);
                CartaDeDano carta_arco_flecha = new CartaDeDano("Arco e Flecha", "Um arco e flechas precisas que causam dano à distância.", 3, 11);
                CartaDeDano carta_adaga_de_lancamento = new CartaDeDano("Adaga de lançamento", "Uma adaga que pode ser jogada no inimigo", 2, 10);
                CartaDeDano carta_besta = new CartaDeDano("Besta", "uma besta que dispara dardos no inimigo", 4, 13);
        

                CartaEscudo carta_armadura = new CartaEscudo("Armadura", "Uma armadura resistente que aumenta sua defesa.", 3, 15);
                CartaEscudo carta_escudo_madeira = new CartaEscudo("Escudo de Madeira", "Um escudo de madeira que aumenta sua defesa.", 2, 10);
                CartaEscudo carta_escudo = new CartaEscudo("Escudo", "Um escudo simples que aumenta sua defesa.", 1, 5);
                CartaEscudo carta_feitico_protecao = new CartaEscudo("Feitiço de Proteção", "Um feitiço que cria um escudo mágico em torno do herói.", 5, 20);
                CartaEscudo carta_soro_resistencia = new CartaEscudo("Soro de Resistência", "Um soro que aumenta a resistência do herói.", 2, 10);
                CartaEscudo carta_cota_de_malha = new CartaEscudo("Cota de malha", "Uma cota de malha que aumenta a defesa", 0, 7);
                CartaEscudo carta_capacete = new CartaEscudo("Capacete", "Um capacete que aumenta a resistencia", 2, 7);

                CartaDeEfeito carta_frasco_envenenado = new CartaDeEfeito("Frasco Envenenado", "Um frasco contendo um veneno mortal. Causa dano ao longo do tempo.", 3, 5, 3, eventos.get(0), batalha01, "dano", "inimigo");
                CartaDeEfeito carta_pocao_de_cura = new CartaDeEfeito("Poção de Cura", "Uma poção que restaura a saúde do herói ao longo do tempo.", 3, 5, 3, eventos.get(0), batalha01, "cura", "heroi");
                CartaDeEfeito carta_feitico_de_cura = new CartaDeEfeito("Feitiço de cura", "Um feitiço que restaura a saúde do herói", 2, 4, 2, eventos.get(0), batalha01, "cura", "heroi");

                // Criar listas e depois o prórprio baralho

                List<Carta> pilhaDeCompra = new ArrayList<>();

                pilhaDeCompra.add(carta_espada);
                pilhaDeCompra.add(carta_machado);
                pilhaDeCompra.add(carta_cajado);
                pilhaDeCompra.add(carta_adagas);
                pilhaDeCompra.add(carta_arco_flecha);
                pilhaDeCompra.add(carta_adaga_de_lancamento);
                pilhaDeCompra.add(carta_besta);

                pilhaDeCompra.add(carta_armadura);
                pilhaDeCompra.add(carta_escudo_madeira);
                pilhaDeCompra.add(carta_escudo);
                pilhaDeCompra.add(carta_feitico_protecao);
                pilhaDeCompra.add(carta_soro_resistencia);
                pilhaDeCompra.add(carta_cota_de_malha);
                pilhaDeCompra.add(carta_capacete);

                pilhaDeCompra.add(carta_frasco_envenenado);
                pilhaDeCompra.add(carta_pocao_de_cura);
                pilhaDeCompra.add(carta_feitico_de_cura);

                List<Carta> mao = new ArrayList<>();
                List<Carta> pilhaDeDescarte = new ArrayList<>();

                Baralho baralho = new Baralho(pilhaDeCompra, pilhaDeDescarte, mao);
                // Criar loja
                List<Carta> cartas = new ArrayList<>();

                CartaDeEfeito carta_adaga_envenenada = new CartaDeEfeito("Adaga envenenada", "Uma adaga com veneno. Causa dano ao longo do tempo.", 2, 5, 3, eventos.get(0), batalha01, "dano", "inimigo");
                CartaDeEfeito carta_curativo = new CartaDeEfeito("Curativo", "Um curativo que restaura a saúde do herói ao longo do tempo.", 2, 5, 3, eventos.get(0), batalha01, "cura", "heroi");
                CartaDeEfeito carta_soro_de_resistencia = new CartaDeEfeito("Soro de resistencia", "Um soro que restaura a saúde do herói e aumenta a sua resistencia", 1, 4, 2, eventos.get(0), batalha01, "cura", "heroi");

                cartas.add(carta_soro_de_resistencia);
                cartas.add(carta_adaga_envenenada);
                cartas.add(carta_curativo);
                 Loja loja = new Loja(cartas);



                // Escolher o nome do heroi

                System.out.println("");
                System.out.println("Olá jogador! Seja bem vindo e se prepare para a jornada...");
                System.out.println("");

                Scanner scanner = new Scanner(System.in);
                System.out.println("Comece escolhendo o nome de seu herói: ");
                System.out.println("");
                heroi.setNome(scanner.next());
                System.out.println("");
                System.out.println("Boa sorte na batalha, você irá precisar! ");
                System.out.println("");

                // Roda a sequencia de batalhas
                Mapa mapa = new Mapa();
                mapa.rodarSequnciaDeBatalhas(batalha_01, heroi, baralho, scanner, loja);

                scanner.close(); // Fecha o scanner para evitar vazamento de memoria

        }
}

