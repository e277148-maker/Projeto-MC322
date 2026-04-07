// Esta classe é responsável por controlar o fluxo da batalha, alternando os turnos entre o herói e o inimigo
// e gerenciando as ações de ambos. Ela também implementa o padrão Publisher para notificar os efeitos ativos
// sobre eventos específicos durante a batalha.

package batalhas;

import java.util.Random;
import java.util.Scanner;
import java.util.List;

import efeitos.*;
import cartas.*;
import entidades.*;
import baralho.*;

public class Batalha {

    // Atributos
    /**
     * Lista de efeitos que a classe notifica quando ocorre um evento
     */
    private List <Efeito> subscribersEfeito; 
    /**
     * Lista de eventos importantes de uma batalha
     */
    private List <Evento> eventos;

    // Construtor
   /**
    * Cria uma batalha com uma lista de  efeitos que serão notificados e uma lista de eventos
    * @param subscribersEfeito Lista de efeitos que a classe notifica quando ocorre um evento
    * @param eventos Lista de eventos importantes de uma batalha
    */
    public Batalha(List<Efeito> subscribersEfeito, List<Evento> eventos) {
        this.subscribersEfeito = subscribersEfeito;
        this.eventos = eventos;
    }
    /**
     * Cria e gerencia uma batalha entre um herói e um ou mais inimigos
     * @param baralho Baralho com uma pilha de compra, pilha de descarte e mão do jogador 
     * @param heroi Herói que será controlado pelo jogador
     * @param inimigos Lista de inimigos que lutarão contra o herói
     * @param scanner Scanner utilizado para o jogo ser iterativo
     */

    public void rodarBatalha(Baralho baralho, Heroi heroi, List<Inimigo> inimigos, Scanner scanner) {

        int defesaInimigo = 15;
        ponto_controle:

        // Loop principal com alternancia de turnos, até que alguem morra
        while (heroi.getVida() > 0 && temInimigoVivo(inimigos)) {

            // reseta escudo e energia do heroi no inicio do turno
            heroi.setTurno(true);
            heroi.setEscudo(0);
            heroi.setEnergia(6);

            // Compra as cartas no inicio do turno do heroi
            while (baralho.getMao().size() < 5 && (!baralho.getPilhaDeCompras().isEmpty() || !baralho.getPilhaDeDescarte().isEmpty())) {
                baralho.comprarCarta();
            }

            while (heroi.getTurno()) { // Loop de escolhas do herói

                imprimirMenu(baralho, heroi, inimigos);

                int escolha = scanner.nextInt();
                int opcaoEncerrar = baralho.getMao().size();

                if (escolha >= 0 && escolha < opcaoEncerrar) { 

                    // Opção escolhida é uma carta na mão do jogador
                    Carta cartaEscolida = baralho.getMao().get(escolha);

                    if(heroi.getEnergia() >= cartaEscolida.getCusto()){

                        Inimigo alvoSelecionado = pegaPrimeiroVivo(inimigos); // Alvo padrão
                        
                        // Verifica se a carta afeta o inimigo para perguntar o alvo
                        boolean focaInimigo = (cartaEscolida instanceof CartaDeDano) || 
                                              (cartaEscolida instanceof CartaDeEfeito && ((CartaDeEfeito)cartaEscolida).getAlvoEfeito().equalsIgnoreCase("Inimigo"));

                        // Se tiver mais de um vivo e for carta ofensiva, pede pra escolher!
                        if (focaInimigo && contaInimigosVivos(inimigos) > 1) {
                            System.out.println("\nEscolha o alvo:");
                            for (int i = 0; i < inimigos.size(); i++) {
                                if (inimigos.get(i).getVida() > 0) {
                                    System.out.printf("%d - %s (%d de vida)\n", i, inimigos.get(i).getNome(), inimigos.get(i).getVida());
                                }
                            }
                            int alvoIndex = scanner.nextInt();
                            if (alvoIndex >= 0 && alvoIndex < inimigos.size() && inimigos.get(alvoIndex).getVida() > 0) {
                                alvoSelecionado = inimigos.get(alvoIndex);
                            } else {
                                System.out.println("Alvo inválido! O ataque pegará no primeiro inimigo vivo.");
                            }
                        }

                        cartaEscolida.usar(heroi, alvoSelecionado);
                        baralho.descartar(cartaEscolida);

                    } else {
                        System.out.println("\nNão possui energia suficiente para utilizar essa carta.\n"); 
                    }

                } else if (escolha == opcaoEncerrar){ // Encerrar o turno

                    heroi.setTurno(false);
                    baralho.descartarMao(); // Limpa a mão para o próximo turno
                    notificar(eventos.get(0));

                } else if (escolha == opcaoEncerrar + 1) { // Descartar manualmente

                    System.out.println("Digite o número da carta que deseja descartar da sua mão (0 a " + (baralho.getMao().size() - 1) + "):");
                    int indiceDescarte = scanner.nextInt();

                    if (indiceDescarte >= 0 && indiceDescarte < baralho.getMao().size()) {

                        System.out.println("Você descartou: " + baralho.getMao().get(indiceDescarte).getNome());
                        baralho.descartar(baralho.getMao().get(indiceDescarte));

                    } else {
                        System.out.println("Opção inválida para descarte.\n");
                    }

                } else if (escolha == opcaoEncerrar + 2) { // Comprar carta extra

                    if (heroi.getEnergia() >= 1) {

                        heroi.perderEnergia(1);
                        baralho.comprarCarta();
                        System.out.println("\nVocê comprou uma carta extra!\n");

                    } else {
                        System.out.println("\nEnergia insuficiente para comprar carta!\n");
                    }

                } else {
                    System.out.println("\nEscolha invalida, tente novamente!\n");
                }

            } // Fim do turno do heroi

            // Turno do inimigo
            Random random = new Random();
            
            for (Inimigo inimigo : inimigos) {
                if (inimigo.getVida() > 0 && heroi.getVida() > 0){
                    
                    System.out.println("\n--- Turno de " + inimigo.getNome() + " ---");
                    int acaoInimigo = random.nextInt(5); // Alterado para 5 para incluir a cura!

                    switch (acaoInimigo) {

                        case 0: // Ataca
                            inimigo.atacar(heroi);
                            System.out.println("Inimigo atacou\n");
                            break;

                        case 1: // Ganha escudo
                            inimigo.ganharEscudo(defesaInimigo);
                            System.out.printf("%s ganhou escudo\n", inimigo.getNome());
                            break;

                        case 2: // Ataca e ganha escudo
                            inimigo.atacar(heroi);
                            inimigo.ganharEscudo(defesaInimigo);
                            System.out.printf("%s atacou e ganhou escudo\n", inimigo.getNome());
                            break;

                        case 3: // Usar veneno
                            System.out.printf("%s envenenou heroi\n", inimigo.getNome());
                            inimigo.envenenar(heroi);
                            break;

                        case 4: // Usar cura
                            System.out.printf("%s usou cura\n", inimigo.getNome());
                            inimigo.curar(inimigo);
                            break;

                    }

                    System.out.println("-----------------------------------------");

                    try {
                        // Pede para o Java pausar a execução por 2500 milissegundos (2.5 segundos)
                        Thread.sleep(2500); 

                    } catch (InterruptedException e) {
                        System.out.println("Aviso: A pausa do turno foi interrompida.");
                    }

                }
            }
            // Fim do turno do inimigo

            notificar(eventos.get(1));

            if (!heroi.estarVivo()) {  // Se o heroi morrer o jogo acaba
                System.out.println("\nQue pena... Você perdeu o combate");
                break ponto_controle;
            } else if (!temInimigoVivo(inimigos)) {
                System.out.println("\nPARABÉNS! VOCÊ VENCEU A BATALHA!");
            }

        } // Fim do while principal

    }


    /**
     * Imprime um menu com as decisões que o jogador pode tomar durante uma batalha
     * @param baralho Baralho com uma pilha de compra, pilha de descarte e mão do jogador 
     * @param heroi Personagem controlado pelo jogador
     * @param inimigos Lista de inimigos que lutarão contra o herói
     */
    public void imprimirMenu(Baralho baralho, Heroi heroi, List<Inimigo> inimigos){

        System.out.println("===============================================================================");
        System.out.println("Cartas no Baralho: " + baralho.getPilhaDeCompras().size() + " | Cartas no Descarte: " + baralho.getPilhaDeDescarte().size());
        System.out.println("Próxima carta a ser comprada: [" + baralho.verTopoBaralho() + "]");
        System.out.println("===============================================================================");
        System.out.println("");
        System.out.printf("%s (%d/50 de vida) (%d de escudo) (%d/6 de energia)\n", heroi.getNome(), heroi.getVida(), heroi.getEscudo(), heroi.getEnergia());

        // Imprime os efeitos ativos do heroi, se houver
        if (!heroi.getEfeitos().isEmpty()) {

            System.out.print("Efeitos ativos: ");

            for (Efeito e : heroi.getEfeitos()) {
                System.out.print("[" + e.getString() + "] ");
            }

            System.out.println();

        }

        System.out.println("vs");
        
        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo inim = inimigos.get(i);
            if (inim.getVida() > 0) {
                System.out.printf("%d. %s (%d/%d de vida) (%d de escudo)\n", i, inim.getNome(), inim.getVida(), inim.getVidaMaxima(), inim.getEscudo());
                // Imprime os efeitos ativos do inimigo, se houver
                if (!inim.getEfeitos().isEmpty()) {
                    System.out.print("   Efeitos ativos: ");
                    for (Efeito e : inim.getEfeitos()) {
                        System.out.print("[" + e.getString() + "] ");
                    }
                    System.out.println();
                }
            } else {
                System.out.printf("%d. %s (MORTALMENTE DERROTADO)\n", i, inim.getNome());
            }
        }

        System.out.println("");
        System.out.println("===============================================================================");
        System.out.println("");
        System.out.println("Você pode: ");
        System.out.println("");

        // Imprime as cartas na mão do jogador
        for (int j = 0; j < baralho.getMao().size(); j++){
            System.out.printf("%d - usar %s - %d de energia\n", j, baralho.getMao().get(j).getNome(), baralho.getMao().get(j).getCusto());
        }

        System.out.println("");
        int opcaoEncerrar = baralho.getMao().size();

        System.out.printf("%d - Encerrar turno \n", opcaoEncerrar);
        System.out.printf("%d - Descartar uma carta manualmente (0 energia)\n", opcaoEncerrar + 1);
        System.out.printf("%d - Comprar uma carta extra (1 energia)\n", opcaoEncerrar + 2);

        System.out.println("");
        System.out.println("Escolha: ");
        System.out.println("");

    }

    // --- MÉTODOS AUXILIARES PARA LIDAR COM A LISTA DE INIMIGOS ---

    /**
     * Confere se existe pelo menos um inimigo vivo
     * @param inimigos Lista de inimigos
     * @return Retorna falso se totdos os inimigos morreram e verdadeiro caso contrário
     */
    private boolean temInimigoVivo(List<Inimigo> inimigos) {
        for (Inimigo i : inimigos) {
            if (i.getVida() > 0) return true;
        }
        return false;
    }
    /**
     * Conta o número de inimigos vivos
     * @param inimigos Lista de inimigos que lutarão contra o herói
     * @return Retorna o numero de inimigos vivos
     */
    private int contaInimigosVivos(List<Inimigo> inimigos) {
        int cont = 0;
        for (Inimigo i : inimigos) {
            if (i.getVida() > 0) cont++;
        }
        return cont;
    }

    /**
     * Pega o primeiro inimigo vivo da lista de inimigos
     * @param inimigos Lista de inimigos que lutarão contra o herói
     * @return Retorna o primeiro inimigo vivo da lista de inimigos se ouver um inimigo vivo. Caso contrario retorna o primeiro inimigo da lista
     */
    private Inimigo pegaPrimeiroVivo(List<Inimigo> inimigos) {
        for (Inimigo i : inimigos) {
            if (i.getVida() > 0) return i;
        }
        return inimigos.get(0);
    }

    // Metodos do publisher
    /**
     * Adciona um efeito à lista de efeitos {@link subscribersEfeito}, que contem os efeitos que devem ser avisados pela batalha 
     * @param efeito Efeito que será adcionado
     */
    public void inscrever(Efeito efeito){
        if (!subscribersEfeito.contains(efeito)) {
            subscribersEfeito.add(efeito);
        }
    }
    /**
     * Retira um efeito da lista de efeitos {@link subscribersEfeito}, que contem os efeitos que devem ser avisados pela batalha 
     * @param efeito Efeito que será retirado
     */
    public void desinscrever(Efeito efeito){
        subscribersEfeito.remove(efeito);
    }
    /**
     * Notifica os efeitos que devem ser notificados quando um certo envento ocorre
     * @param eventoAtual Evento que ocorreu
     */
    private void notificar(Evento eventoAtual){

        List<Efeito> copiaSubscribers = new java.util.ArrayList<>(subscribersEfeito);

        for (Efeito efeito : copiaSubscribers) {
            efeito.serNotificado(eventoAtual);
        }

    }

    // Getters
    public List<Evento> getEventos() {
        return eventos;
    }
    
    public List<Efeito> getSubscribersEfeito() {
        return subscribersEfeito;
    }

    // Setters
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void setSubscribersEfeito(List<Efeito> subscribersEfeito) {
        this.subscribersEfeito = subscribersEfeito;
    }
}