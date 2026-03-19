import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Inicializar cartas e entidades (com construtores)

        Heroi heroi = new Heroi("", "", 50, 0);

//        heroi.setVida(50);
//        heroi.setEscudo(0);
//        heroi.setEnergia(6);

        Inimigo inimigo = new Inimigo("Goblin raivoso", "Parece inofensivo, até você se aproximar!", 30, 0, 10);

//        inimigo.setNome("Goblin raivoso");
//        inimigo.setVida(30);
//        inimigo.setEscudo(0);
//        inimigo.setAtaque(10);

        CartaDeDano carta_espada = new CartaDeDano("Espada", "Uma espada afiada que causa dano ao inimigo.", 2, 10);

//        carta_espada.setNome("Espada");
//        carta_espada.setCusto(2);
//        carta_espada.setEfeito(10);

        CartaEscudo carta_armadura = new CartaEscudo("Armadura", "Uma armadura resistente que aumenta sua defesa.", 1, 15);

//        carta_armadura.setNome("Armadura");
//        carta_armadura.setCusto(1);
//        carta_armadura.setEfeito(15);

        // Criar listas e depois o prórprio baralho

        List<Carta> pilhaDeCompra = new ArrayList<>();
        pilhaDeCompra.add(carta_espada);
        pilhaDeCompra.add(carta_armadura);

        List<Carta> mao = new ArrayList<>();
        List<Carta> pilhaDeDescarte = new ArrayList<>();

        Baralho baralho = new Baralho(pilhaDeCompra, pilhaDeDescarte, mao);

//        baralho.setPilhaDeCompra(pilhaDeCompra);
//        baralho.setPilhaDeDescarte(pilhaDeDescarte);
//        baralho.setMao(mao);

        // Escolher o nome do heroi

        System.out.println("");
        System.out.println("Olá jogador! Seja bem vindo e se prepare para a jornada...");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Comece escolhendo o nome de seu herói: ");
        heroi.setNome(scanner.next());
        System.out.println("");
        System.out.println("Boa sorte na batalha, você irá precisar! ");
        System.out.println("");

        // Batalha

        Batalha batalha = new Batalha();
        batalha.rodarBatalha(baralho, heroi, inimigo, scanner);

        scanner.close(); // Fecha o scanner para evitar vazamento de memoria

    }
}
