import java.util.Random;
import java.util.Scanner;

public class Batalha {
    public void rodarBatalha(Baralho baralho, heroi heroi, inimigo inimigo, Scanner scanner){
        int defesaInimigo = 15;
        ponto_controle:
        while (heroi.getVida() > 0 && inimigo.getVida() > 0) {

            heroi.setTurno(true);
            heroi.setEscudo(0);

            while (heroi.getTurno()) { // Turno do heroi

                baralho.comprarCarta();

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
                if (escolha == baralho.getMao().size()){ // Encerrar o turno
                    heroi.setTurno(false);
                }
                else{
                    System.out.println("");
                    System.out.println("Escolha invalida, tente novamente");
                }

            }
            // Turno do inimigo

            Random random = new Random();

            int acaoInimigo = random.nextInt(3); // Sorteia um inteiro, 0, 1 ou 2

            switch (acaoInimigo) {

                case 0: // Ataca

                    inimigo.atacar(heroi);
                    break;

                case 1: // Ganha escudo

                    inimigo.ganharEscudo(defesaInimigo);
                    break;

                case 2: // Ataca e ganha escudo

                    inimigo.atacar(heroi);
                    inimigo.ganharEscudo(defesaInimigo);
                    break;

                }

                if (!heroi.estarVivo()) {  // Se o heroi morrer o jogo acaba

                    System.out.println("");
                    System.out.println("Que pena... Você perdeu o combate");
                    break ponto_controle;

            }

            // Entre rodadas

            heroi.setEscudo(0);
            heroi.ganharEnergia();

        }
        
    }

    public void imprimirMenu(Baralho baralho, heroi heroi, inimigo inimigo){
        System.out.println("");
                System.out.printf("%s (%d/50 de vida) (%d de escudo) (%d/6 de energia)\n", heroi.getNome(), heroi.getVida(), heroi.getEscudo(), heroi.getEnergia());
                System.out.println("vs");
                System.out.printf("%s (%d/30 de vida) (%d de escudo)\n", inimigo.getNome(), inimigo.getVida(), inimigo.getEscudo());
                System.out.println("");
                System.out.println("Você pode: ");
                System.out.println("");
                for (int j = 0; j < baralho.getMao().size(); j++){
                    System.out.printf("%d - usar %s", j, baralho.getMao().get(j).getNome());
                    System.out.println("");
                }
                System.out.printf("%d - Encerrar turno ", baralho.getMao().size());
                System.out.println("");
                System.out.println("Escolha: ");
                System.out.println("");
    }
}
