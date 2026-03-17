import java.util.List;
import java.util.ArrayList;
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

        Batalha batalha = new Batalha();
        batalha.rodarBatalha(b, h, i, scanner);

        scanner.close();

    }
}
