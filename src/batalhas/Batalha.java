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

    // Metodos


    // Constructor
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

            while (heroi.getTurno()) { // Turno do heroi

                while (baralho.getMao().size() < 5 && (!baralho.getPilhaDeCompras().isEmpty() || !baralho.getPilhaDeDescarte().isEmpty())) {
                    baralho.comprarCarta();
                }

                imprimirMenu(baralho, heroi, inimigo);

                int escolha = scanner.nextInt();

                if(escolha < baralho.getMao().size() && escolha >= 0){ // Opção escolida é uma carta na mão do jogador

                    Carta cartaEscolida = baralho.getMao().get(escolha);

                    if(heroi.getEnergia() >= cartaEscolida.getCusto()){ // Heroi tem energia para jogar a carta
                        cartaEscolida.usar(heroi, inimigo);
                        baralho.descartar(cartaEscolida);
                    }
                    else{
                        System.out.println("");
                        System.out.println("Não possui energia suficiente para utiliza essa carta"); 
                    }
                    
                }
                else if (escolha == baralho.getMao().size()){ // Encerrar o turno
                    heroi.setTurno(false);
                    notificarEfeito(subscribersEfeito, eventos.get(0));
                }
                else {
                    System.out.println("");
                    System.out.println("Escolha invalida, tente novamente!\n");
                }

            }
            // Turno do inimigo

            if (inimigo.getVida() > 0){

                Random random = new Random();

                int acaoInimigo = random.nextInt(4); // Sorteia um inteiro, 0, 1 ou 2

                switch (acaoInimigo) {

                    case 0: // Ataca

                        inimigo.atacar(heroi);
                        System.out.println("Inimigo atacou");
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
            }
            // Fim do turno do inimigo

            notificarEfeito(subscribersEfeito, eventos.get(1));


                if (!heroi.estarVivo()) {  // Se o heroi morrer o jogo acaba

                    System.out.println("");
                    System.out.println("Que pena... Você perdeu o combate");
                    break ponto_controle;

            }

        }

    }

    public void imprimirMenu(Baralho baralho, Heroi heroi, Inimigo inimigo){

        // Imprime o menu do jogo, mostrando as informações do heroi, inimigo e as cartas na mão do jogador

        System.out.println("===============================================================================");
        System.out.println("");
        System.out.printf("%s (%d/50 de vida) (%d de escudo) (%d/6 de energia)\n", heroi.getNome(), heroi.getVida(), heroi.getEscudo(), heroi.getEnergia());
        System.out.println("vs");
        System.out.printf("%s (%d/30 de vida) (%d de escudo)\n", inimigo.getNome(), inimigo.getVida(), inimigo.getEscudo());
        System.out.println("");
        System.out.println("===============================================================================");
        System.out.println("");
        System.out.println("Você pode: ");
        System.out.println("");

        for (int j = 0; j < baralho.getMao().size(); j++){

            System.out.printf("%d - usar %s - %d de energia\n", j, baralho.getMao().get(j).getNome(), baralho.getMao().get(j).getCusto());
            //System.out.println("");

        }

        System.out.println("");
        System.out.printf("%d - Encerrar turno \n", baralho.getMao().size());
        System.out.println("");
        System.out.println("Escolha: ");
        System.out.println("");

    }

    // Metodos do publisher

    private void inscreverEfeito(Efeito efeito){
        subscribersEfeito.add(efeito);
    }
    
    private void desinscreverEfeito(Efeito efeito){
        subscribersEfeito.remove(efeito);
    }

    private void notificarEfeito(List <Efeito> subscribersEfeito, Evento evento){
        for (int i = 0; i < subscribersEfeito.size(); i++){
            Efeito efeito = subscribersEfeito.get(i);
            if (efeito.getEvento() == evento){
                efeito.serNotificado();
            }
            
        }
        
    }

    // Metodos do subscriber

    public void serNotificadoAcumulo(Efeito efeito){
        desinscreverEfeito(efeito);
    }

    public void serNotificadoCriacaoEfeito(Efeito efeito){
        inscreverEfeito(efeito);
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
