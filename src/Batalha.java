import java.util.Random;
import java.util.Scanner;

public class Batalha {
    public void rodarBatalha(Baralho b, heroi h, inimigo i, Scanner scanner){
        int defesaInimigo = 15;
        ponto_controle:
        while (h.getVida() > 0 && i.getVida() > 0) {

            h.setTurno(true);
            h.setEscudo(0);

            while (h.getTurno()) { // Turno do heroi

                b.comprarCarta();

                imprimirMenu(b, h, i);

                int escolha = scanner.nextInt();


                if(escolha < b.getMao().size() && escolha >= 0){
                    Carta cartaEscolida = b.getMao().get(escolha);
                    if(h.getEnergia() >= cartaEscolida.getCusto()){
                        cartaEscolida.usar(h, i);
                        b.descartar(cartaEscolida);
                    }
                    else{
                        System.out.println("");
                        System.out.println("Não possui energia suficiente para utiliza essa carta"); 
                    }
                    
                }
                if (escolha == b.getMao().size()){
                    h.setTurno(false);
                }
                else{
                    System.out.println("");
                    System.out.println("Escolha invalida, tente novamente");
                }

            }
            // Turno do inimigo

            Random random = new Random();

            int acaoInimigo = random.nextInt(3);

            switch (acaoInimigo) {

                case 0:

                    i.atacar(h);
                    break;

                case 1:

                    i.ganharEscudo(defesaInimigo);
                    break;

                case 2:

                    i.atacar(h);
                    i.ganharEscudo(defesaInimigo);
                    break;

                }

                if (!h.estarVivo()) {

                    System.out.println("");
                    System.out.println("Que pena... Você perdeu o combate");
                    break ponto_controle;

            }

            // Entre rodadas

            h.setEscudo(0);
            h.ganharEnergia();

        }
        
    }

    public void imprimirMenu(Baralho b, heroi h, inimigo i){
        System.out.println("");
                System.out.printf("%s (%d/50 de vida) (%d de escudo) (%d/6 de energia)\n", h.getNome(), h.getVida(), h.getEscudo(), h.getEnergia());
                System.out.println("vs");
                System.out.printf("%s (%d/30 de vida) (%d de escudo)\n", i.getNome(), i.getVida(), i.getEscudo());
                System.out.println("");
                System.out.println("Você pode: ");
                System.out.println("");
                for (int j = 0; j < b.getMao().size(); j++){
                    System.out.printf("%d - usar %s", j, b.getMao().get(j).getNome());
                    System.out.println("");
                }
                System.out.printf("%d - Encerrar turno ", b.getMao().size());
                System.out.println("");
                System.out.println("Escolha: ");
                System.out.println("");
    }
}
