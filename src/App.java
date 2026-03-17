import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // criando herói, inimigo e cartas

        Heroi heroi = new Heroi();
        heroi.vida = 50;
        heroi.escudo = 0;
        heroi.energia = 6;

        Inimigo inimigo = new Inimigo();
        inimigo.nome = "Goblin raivoso";
        inimigo.vida = 30;
        inimigo.escudo = 0;
        inimigo.ataque = 10;

        CartaDeDano carta_espada = new CartaDeDano();
        carta_espada.nome = "Espada";
        carta_espada.custo = 2;
        carta_espada.efeito = 10;

        CartaEscudo carta_escudo = new CartaEscudo();
        carta_escudo.nome = "Armadura";
        carta_escudo.custo = 1;
        carta_escudo.efeito = 15;

        // Início do jogo
        System.out.println("");
        System.out.println("Olá jogador! Seja bem vindo e se prepare para a jornada...");
        System.out.println("");

        // Nomeando o personagem do jogador
        Scanner scanner = new Scanner(System.in);
        System.out.println("Comece escolhendo o nome de seu herói: ");
        heroi.nome = scanner.next();
        System.out.println("");
        System.out.println("Boa sorte na batalha, você irá precisar! ");
        System.out.println("");

        ponto_controle:  // para controlar o fluxo do jogo e evitar que continue após o fim da batalha

        while (heroi.vida > 0 && inimigo.vida > 0) { // Batalha

            // Começa com o heroi
            heroi.turno = true;
            // Zera o escudo a cada turno
            heroi.escudo = 0;

            while (heroi.turno) { // Turno do heroi

                System.out.println("");
                System.out.printf("%s (%d/50 de vida) (%d de escudo) (%d/6 de energia)\n", heroi.nome, heroi.vida, heroi.escudo, heroi.energia);
                System.out.println("vs");
                System.out.printf("%s (%d/30 de vida) (%d de escudo)\n", inimigo.nome, inimigo.vida, inimigo.escudo);
                System.out.println("");
                System.out.println("1 - Usar carta de dano");
                System.out.println("2 - Usar carta de escudo");
                System.out.println("3 - Encerrar turno");
                System.out.println("");
                System.out.println("O que deseja fazer? ");
                System.out.println("");

                int escolha = scanner.nextInt(); // captura a escolha do jogador
                if (escolha == 1){ // Carta de dano

                    if (heroi.energia >= carta_espada.custo){ // Energia suficiente
                        carta_espada.usarCartaDano(heroi, inimigo);

                        if (inimigo.vida <= 0) { // Se a vida do inimigo acabar

                            System.out.println("");
                            System.out.printf("Parabéns, %s! Você ganhou o combate\n", heroi.nome);

                            break ponto_controle;

                        }

                    } else { // Sem energia

                        System.out.println("");
                        System.out.println("Não possui energia suficiente para utiliza essa carta");

                    }

                } else if (escolha == 2) { // Carta de escudo

                    if (heroi.energia >= carta_escudo.custo) { // Energia suficiente
                        carta_escudo.usarCartaHeroi(heroi);
                    }

                    else{ // Sem energia

                        System.out.println("");
                        System.out.println("Não possui energia suficiente para utiliza essa carta"); 

                    }

                } else if (escolha == 3) { // Encerrar turno

                    heroi.escudo = 0;
                    heroi.energia = 6;
                    heroi.turno = false;

                } else {

                    System.out.println("");
                    System.out.println("Escolha invalida, tente novamente");

                }

            }
            // Turno do inimigo

            Random random = new Random();

            // "Sorteia" um inteiro (0, 1 ou 2)
            int acaoInimigo = random.nextInt(3);

            // Define a ação do inimigo de acordo com o número sorteado
            switch (acaoInimigo) {

                // Ataca
                case 0:

                    inimigo.atacar(heroi);
                    break;

                // Usa carta de escudo
                case 1:

                    carta_escudo.usarCartaInimigo(inimigo);
                    break;

                // Ataca e usa carta de escudo
                case 2:

                    inimigo.atacar(heroi);
                    carta_escudo.usarCartaInimigo(inimigo);
                    break;

                }

                // Se o herói morrer, o jogo acaba
                if (!heroi.estarVivo()) {

                    System.out.println("");
                    System.out.println("Que pena... Você perdeu o combate");
                    break ponto_controle;

            }

        }

        scanner.close(); // fecha o scanner para evitar vazamento de memória

    }
}
