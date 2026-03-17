import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Inicializar cartas e entidades

        heroi h = new heroi();
        h.setVida(50);
        h.setEscudo(0);
        h.setEnergia(6);

        inimigo i = new inimigo();
        i.setNome("Goblin raivoso");
        i.setVida(30);
        i.setEscudo(0);
        i.setAtaque(10);

        CartaDeDano d = new CartaDeDano();
        d.setNome("Espada");
        d.setCusto(2);
        d.setEfeito(10);

        CartaEscudo e = new CartaEscudo();
        e.setNome("Armadura");
        e.setCusto(1);
        e.setEfeito(15);

        // Criar baralho

        Baralho b = new Baralho();

        List<Carta> pilhaDeCompra = new ArrayList<>();
        pilhaDeCompra.add(d);
        pilhaDeCompra.add(e);

        List<Carta> mao = new ArrayList<>();
        List<Carta> pilhaDeDescarte = new ArrayList<>();
        

        b.setPilhaDeCompra(pilhaDeCompra);
        b.setPilhaDeDescarte(pilhaDeDescarte);
        b.setMao(mao);


        // Escolher o nome do heroi

        System.out.println("");
        System.out.println("Olá jogador! Seja bem vindo e se prepare para a jornada...");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Comece escolhendo o nome de seu herói: ");
        h.setNome(scanner.next());
        System.out.println("");
        System.out.println("Boa sorte na batalha, você irá precisar! ");
        System.out.println("");

        // Batalha

        ponto_controle:
        while (h.getVida() > 0 && i.getVida() > 0) {

            h.setTurno(true);
            h.setEscudo(0);

            while (h.getTurno()) { // Turno do heroi

                b.comprarCarta();

                System.out.println("");
                System.out.printf("%s (%d/50 de vida) (%d de escudo) (%d/6 de energia)\n", h.getNome(), h.getVida(), h.getEscudo(), h.getEnergia());
                System.out.println("vs");
                System.out.printf("%s (%d/30 de vida) (%d de escudo)\n", i.getNome(), i.getVida(), i.getEscudo());
                System.out.println("");
                System.out.println("1 - Usar carta de dano");
                System.out.println("2 - Usar carta de escudo");
                System.out.println("3 - Encerrar turno");
                System.out.println("");
                System.out.println("Escolha: ");
                System.out.println("");

                int escolha = scanner.nextInt();

                if (escolha == 1){ // Carta de dano

                    if (h.getEnergia() >= d.getCusto()){ // Energia suficiente
                        d.usarCartaDano(h, i);

                        if (i.getVida() <= 0) {

                            System.out.println("");
                            System.out.printf("Parabéns, %s! Você ganhou o combate\n", h.getNome());

                            break ponto_controle;

                        }

                    }

                    else{

                        System.out.println("");
                        System.out.println("Não possui energia suficiente para utiliza essa carta");

                    }

                } else if (escolha == 2){ // Carta de escudo

                    if (h.getEnergia() >= e.getCusto()){ // Energia suficiente
                        e.usarCartaHeroi(h);
                    }

                    else{ // Sem energia

                        System.out.println("");
                        System.out.println("Não possui energia suficiente para utiliza essa carta"); 

                    }

                } else if (escolha == 3) { // Encerrar turno

                    h.setTurno(false);

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

            // Entre rodadas

            h.setEscudo(0);
            h.ganharEnergia();


        }

        scanner.close();

    }
}
