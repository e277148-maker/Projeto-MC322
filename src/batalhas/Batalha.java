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
    private List <Efeito> subscribersEfeito;
    private List <Evento> eventos;

    // Construtor
    public Batalha(List<Efeito> subscribersEfeito, List<Evento> eventos) {
        this.subscribersEfeito = subscribersEfeito;
        this.eventos = eventos;
    }

    public void rodarBatalha(Baralho baralho, Heroi heroi, Inimigo inimigo, Scanner scanner){

        int defesaInimigo = 15;
        ponto_controle:

        // Loop principal com alternancia de turnos, até que alguem morra
        while (heroi.getVida() > 0 && inimigo.getVida() > 0) {

            // reseta escudo e energia do heroi no inicio do turno
            heroi.setTurno(true);
            heroi.setEscudo(0);
            heroi.setEnergia(6);

            // COMPRA AS CARTAS NO INÍCIO DO TURNO
            while (baralho.getMao().size() < 5 && (!baralho.getPilhaDeCompras().isEmpty() || !baralho.getPilhaDeDescarte().isEmpty())) {
                baralho.comprarCarta();
            }

            while (heroi.getTurno()) { // Loop de escolhas do herói
                imprimirMenu(baralho, heroi, inimigo);
                
                int escolha = scanner.nextInt();
                int opcaoEncerrar = baralho.getMao().size();

                if(escolha >= 0 && escolha < opcaoEncerrar){ 
                    // Opção escolhida é uma carta na mão do jogador
                    Carta cartaEscolida = baralho.getMao().get(escolha);

                    if(heroi.getEnergia() >= cartaEscolida.getCusto()){ 
                        cartaEscolida.usar(heroi, inimigo);
                        baralho.descartar(cartaEscolida);
                    }
                    else{
                        System.out.println("\nNão possui energia suficiente para utilizar essa carta.\n"); 
                    }
                    
                }
                else if (escolha == opcaoEncerrar){ // Encerrar o turno
                    heroi.setTurno(false);
                    baralho.descartarMao(); // Limpa a mão para o próximo turno
                    notificar(eventos.get(0));
                }
                else if (escolha == opcaoEncerrar + 1) { // Descartar manualmente
                    System.out.println("Digite o número da carta que deseja descartar da sua mão (0 a " + (baralho.getMao().size() - 1) + "):");
                    int indiceDescarte = scanner.nextInt();
                    
                    if (indiceDescarte >= 0 && indiceDescarte < baralho.getMao().size()) {
                        System.out.println("Você descartou: " + baralho.getMao().get(indiceDescarte).getNome());
                        baralho.descartar(baralho.getMao().get(indiceDescarte));
                    } else {
                        System.out.println("Opção inválida para descarte.\n");
                    }
                }
                else if (escolha == opcaoEncerrar + 2) { // Comprar carta extra
                    if (heroi.getEnergia() >= 1) {
                        heroi.perderEnergia(1);
                        baralho.comprarCarta();
                        System.out.println("\nVocê comprou uma carta extra!\n");
                    } else {
                        System.out.println("\nEnergia insuficiente para comprar carta!\n");
                    }
                }
                else {
                    System.out.println("\nEscolha invalida, tente novamente!\n");
                }

            } // Fim do turno do heroi

            // Turno do inimigo
            if (inimigo.getVida() > 0){

                Random random = new Random();
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
            // Fim do turno do inimigo

            notificar(eventos.get(1));

            if (!heroi.estarVivo()) {  // Se o heroi morrer o jogo acaba
                System.out.println("\nQue pena... Você perdeu o combate");
                break ponto_controle;
            }

        } // Fim do while principal

    }

    public void imprimirMenu(Baralho baralho, Heroi heroi, Inimigo inimigo){

        System.out.println("===============================================================================");
        System.out.println("Cartas no Baralho: " + baralho.getPilhaDeCompras().size() + " | Cartas no Descarte: " + baralho.getPilhaDeDescarte().size());
        System.out.println("Próxima carta a ser comprada: [" + baralho.verTopoBaralho() + "]");
        System.out.println("===============================================================================");
        System.out.println("");
        System.out.printf("%s (%d/50 de vida) (%d de escudo) (%d/6 de energia)\n", heroi.getNome(), heroi.getVida(), heroi.getEscudo(), heroi.getEnergia());

        if (!heroi.getEfeitos().isEmpty()) {
            System.out.print("Efeitos ativos: ");
            for (Efeito e : heroi.getEfeitos()) {
                System.out.print("[" + e.getString() + "] ");
            }
            System.out.println();
        }

        System.out.println("vs");
        System.out.printf("%s (%d/30 de vida) (%d de escudo)\n", inimigo.getNome(), inimigo.getVida(), inimigo.getEscudo());

        if (!inimigo.getEfeitos().isEmpty()) {
            System.out.print("Efeitos ativos: ");
            for (Efeito e : inimigo.getEfeitos()) {
                System.out.print("[" + e.getString() + "] ");
            }
            System.out.println();
        }

        System.out.println("");
        System.out.println("===============================================================================");
        System.out.println("");
        System.out.println("Você pode: ");
        System.out.println("");

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

    // Metodos do publisher

    public void inscrever(Efeito efeito){
        if (!subscribersEfeito.contains(efeito)) {
            subscribersEfeito.add(efeito);
        }
    }
    
    public void desinscrever(Efeito efeito){
        subscribersEfeito.remove(efeito);
    }

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