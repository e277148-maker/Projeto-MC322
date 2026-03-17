import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Heroi h = new Heroi();
        h.vida = 50;
        h.escudo = 0;
        h.energia = 6;

        Inimigo i = new Inimigo();
        i.nome = "Goblin raivoso";
        i.vida = 30;
        i.escudo = 0;
        i.ataque = 10;

        CartaDeDano d = new CartaDeDano();
        d.nome = "Espada";
        d.custo = 2;
        d.efeito = 10;

        CartaEscudo e = new CartaEscudo();
        e.nome = "Armadura";
        e.custo = 1;
        e.efeito = 15;

        System.out.println("");
        System.out.println("Olá jogador! Seja bem vindo e se prepare para a jornada...");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Comece escolhendo o nome de seu herói: ");
        h.nome = scanner.next();
        System.out.println("");
        System.out.println("Boa sorte na batalha, você irá precisar! ");
        System.out.println("");

        ponto_controle:
        while (h.vida > 0 && i.vida > 0) { // Batalha

            h.turno = true;
            h.escudo = 0;

            while (h.turno) { // Turno do heroi

                System.out.println("");
                System.out.printf("%s (%d/50 de vida) (%d de escudo) (%d/6 de energia)\n", h.nome, h.vida, h.escudo, h.energia);
                System.out.println("vs");
                System.out.printf("%s (%d/30 de vida) (%d de escudo)\n", i.nome, i.vida, i.escudo);
                System.out.println("");
                System.out.println("1 - Usar carta de dano");
                System.out.println("2 - Usar carta de escudo");
                System.out.println("3 - Encerrar turno");
                System.out.println("");
                System.out.println("Escolha: ");
                System.out.println("");

                int escolha = scanner.nextInt();

                if (escolha == 1){ // Carta de dano

                    if (h.energia >= d.custo){ // Energia suficiente
                        d.usarCartaDano(h, i);

                        if (i.vida <= 0) {

                            System.out.println("");
                            System.out.printf("Parabéns, %s! Você ganhou o combate\n", h.nome);

                            break ponto_controle;

                        }

                    }

                    else{

                        System.out.println("");
                        System.out.println("Não possui energia suficiente para utiliza essa carta");

                    }

                } else if (escolha == 2){ // Carta de escudo

                    if (h.energia >= e.custo){ // Energia suficiente
                        e.usarCartaHeroi(h);
                    }

                    else{ // Sem energia

                        System.out.println("");
                        System.out.println("Não possui energia suficiente para utiliza essa carta"); 

                    }

                } else if (escolha == 3) { // Encerrar turno

                    h.escudo = 0;
                    h.energia = 6;
                    h.turno = false;

                } else {


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

                    e.usarCartaInimigo(i);
                    break;

                case 2:

                    i.atacar(h);
                    e.usarCartaInimigo(i);
                    break;

                }

                if (!h.estarVivo()) {

                    System.out.println("");
                    System.out.println("Que pena... Você perdeu o combate");
                    break ponto_controle;

            }

        }

        scanner.close();

    }
}
