/* Este código é a classe principal do jogo, onde a execução começa. 
 * Ele cria os eventos, a batalha, as cartas, o herói e o inimigo, e inicia a batalha. 
 * O código também inclui interações com o jogador para escolher o nome do herói e exibe mensagens de boas-vindas e instruções durante o jogo.
 */

// Importações das classes necessárias para o funcionamento do jogo
package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import batalhas.*;
import batalhas.Batalha;
import cartas.*;
import cartas.Carta;
import efeitos.Efeito;
import entidades.*;
import entidades.Heroi;
import entidades.Inimigo;
import baralho.*;
import baralho.Baralho;

public class App {

        // Método principal onde a execução do programa começa
        public static void main(String[] args) throws Exception {

                // Criar eventos

                Evento fimDeTurnoHeroi = new Evento("fimDeTurnoHeroi"); 
                Evento fimDeTurnoInimigo = new Evento("fimDeTurnoInimigo");

                // Criar lista de eventos
                List <Evento> eventos = new ArrayList<>();
                eventos.add(fimDeTurnoHeroi); // Indice 0 na lista de eventos
                eventos.add(fimDeTurnoInimigo); // Indice 1 na lista de eventos

                // Criar batalha
                List <Efeito> subscribersEfeito = new ArrayList<>();

                Batalha batalha = new Batalha(subscribersEfeito, eventos);

                // Inicializar cartas, entidades e eventos(com construtores)
                List <Efeito> efeitos = new ArrayList<>();

                Heroi heroi = new Heroi(null, null, 100, 0, efeitos, 50, 0, false, batalha);

                // Criar a lista de inimigos
                List<Inimigo> inimigos = new ArrayList<>();

                // Criar inimigos e adiciona na lista
                Inimigo goblin = new Inimigo("Goblin Raivoso", "Pequeno e irritante", 30, 0, new ArrayList<>(), 30, 10, batalha, 3, 5, eventos);
                Inimigo orc = new Inimigo("Orc Brucutu", "Forte, mas lento", 45, 0, new ArrayList<>(), 45, 15, batalha, 3, 5, eventos);
                Inimigo slime = new Inimigo("Slime Venenoso", "Gosmento", 25, 0, new ArrayList<>(), 25, 8, batalha, 3, 5, eventos);

                inimigos.add(goblin);
                inimigos.add(orc);
                inimigos.add(slime);

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
                CartaEscudo carta_cota_de_malha = new CartaEscudo("Cota de malha", "Uma cota de malha que aumenta a defesa", 2, 7);
                CartaEscudo carta_capacete = new CartaEscudo("Capacete", "Um capacete que aumenta a resistencia", 3, 7);

                CartaDeEfeito carta_frasco_envenenado = new CartaDeEfeito("Frasco Envenenado", "Um frasco contendo um veneno mortal. Causa dano ao longo do tempo.", 3, 5, 3, eventos.get(0), batalha, "dano", "inimigo");
                CartaDeEfeito carta_pocao_de_cura = new CartaDeEfeito("Poção de Cura", "Uma poção que restaura a saúde do herói ao longo do tempo.", 3, 5, 3, eventos.get(0), batalha, "cura", "heroi");
                CartaDeEfeito carta_feitico_de_cura = new CartaDeEfeito("Feitiço de cura", "Um feitiço que restaura a saúde do herói", 2, 4, 2, eventos.get(0), batalha, "cura", "heroi");

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

                // Inicialização da batalha

                batalha.rodarBatalha(baralho, heroi, inimigos, scanner);

                scanner.close(); // Fecha o scanner para evitar vazamento de memoria

        }
}

