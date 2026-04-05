/* Este código é a classe principal do jogo, onde a execução começa. 
 * Ele cria os eventos, a batalha, as cartas, o herói e o inimigo, e inicia a batalha. 
 * O código também inclui interações com o jogador para escolher o nome do herói e exibe mensagens de boas-vindas e instruções durante o jogo.
 */

// Importações das classes necessárias para o funcionamento do jogo

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import batalhas.*;
import cartas.*;
import efeitos.Efeito;
import entidades.*;
import baralho.*;

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

                Heroi heroi = new Heroi(null, null, 50, 0, efeitos, 50, 0, false, batalha);
                Inimigo inimigo = new Inimigo("Goblin raivoso", "Parece inofensivo, até você se aproximar!", 30, 0, efeitos, 30, 15, batalha, 3, 5, eventos);

                CartaDeDano carta_espada = new CartaDeDano("Espada", "Uma espada afiada que causa dano ao inimigo.", 2, 10);
                CartaDeDano carta_machado = new CartaDeDano("Machado", "Um machado antigo pesado de manusear.", 4, 15);
                CartaDeDano carta_cajado = new CartaDeDano("Cajado", "Um cajado mágico que causa dano elemental.", 3, 12);
                CartaDeDano carta_adagas = new CartaDeDano("Adagas", "Uma par de adagas afiadas e ágeis.", 1, 8);
                CartaDeDano carta_arco_flecha = new CartaDeDano("Arco e Flecha", "Um arco e flechas precisas que causam dano à distância.", 3, 11);

                CartaEscudo carta_armadura = new CartaEscudo("Armadura", "Uma armadura resistente que aumenta sua defesa.", 3, 15);
                CartaEscudo carta_escudo_madeira = new CartaEscudo("Escudo de Madeira", "Um escudo de madeira que aumenta sua defesa.", 2, 10);
                CartaEscudo carta_escudo = new CartaEscudo("Escudo", "Um escudo simples que aumenta sua defesa.", 1, 5);
                CartaEscudo carta_feitico_protecao = new CartaEscudo("Feitiço de Proteção", "Um feitiço que cria um escudo mágico em torno do herói.", 5, 20);
                CartaEscudo carta_soro_resistencia = new CartaEscudo("Soro de Resistência", "Um soro que aumenta a resistência do herói.", 2, 10);

                CartaDeEfeito carta_frasco_envenenado = new CartaDeEfeito("Frasco Envenenado", "Um frasco contendo um veneno mortal. Causa dano ao longo do tempo.", 3, 5, 3, eventos.get(0), batalha, "dano", "inimigo");
                CartaDeEfeito carta_pocao_de_cura = new CartaDeEfeito("Poção de Cura", "Uma poção que restaura a saúde do herói ao longo do tempo.", 3, 5, 3, eventos.get(0), batalha, "cura", "heroi");

                // Criar listas e depois o prórprio baralho

                List<Carta> pilhaDeCompra = new ArrayList<>();

                pilhaDeCompra.add(carta_espada);
                pilhaDeCompra.add(carta_machado);
                pilhaDeCompra.add(carta_cajado);
                pilhaDeCompra.add(carta_adagas);
                pilhaDeCompra.add(carta_arco_flecha);

                pilhaDeCompra.add(carta_armadura);
                pilhaDeCompra.add(carta_escudo_madeira);
                pilhaDeCompra.add(carta_escudo);
                pilhaDeCompra.add(carta_feitico_protecao);
                pilhaDeCompra.add(carta_soro_resistencia);

                pilhaDeCompra.add(carta_frasco_envenenado);
                pilhaDeCompra.add(carta_pocao_de_cura);

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

                batalha.rodarBatalha(baralho, heroi, inimigo, scanner);

                scanner.close(); // Fecha o scanner para evitar vazamento de memoria

        }
}
