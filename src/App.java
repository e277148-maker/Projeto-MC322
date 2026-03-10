import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        heroi h = new heroi();
        h.vida = 40;
        h.escudo = 0;
        h.energia  = 3;

        inimigo i = new inimigo();
        i.nome = "Rato";
        i.vida = 20;
        i.escudo = 0;
        i.ataque = 15;

        CartaDeDano d = new CartaDeDano();
        d.nome = "Espada";
        d.custo = 2;
        d.efeito = 15;

        CartaEscudo e = new CartaEscudo();
        e.nome = "Armadura";
        e.custo = 1;
        e.efeito = 10;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do heroi:");
        h.nome = scanner.next();
        

        while (h.vida > 0 && i.vida > 0) { // Batalha
            h.turno = true;
            while (h.turno) { // Turno do heroi
                System.out.printf("%s (%d/40 de vida) (%d de escudo) (%d/3 de energia)", h.nome, h.vida, h.escudo, h.energia);
                System.out.printf("%s (%d/20 de vida) (%d de escudo)", i.nome, i.vida, i.escudo);
                System.out.println("1 - Usar carta de dano");
                System.out.println("2 - Usar carta de escudo");
                System.out.println("3 - Encerrar turno");
                System.out.print("Escolha: ");
                int ação = scanner.nextInt();

                if (ação == 1){ // Carta de dano
                    if (h.energia >= d.custo){ // Energia suficiente
                        d.usarCarta(h, i);
                    }
                    else{
                        System.out.println("Não possui energia suficiente para utiliza essa carta");
                    }
                }
                if (ação == 2){ // Carde escudo
                    if (h.energia >= e.custo){ // Energia suficiente
                        e.usarCarta(h);
                    }
                    else{ // Sem energia
                        System.out.println("Não possui energia suficiente para utiliza essa carta"); 
                    }
                }
                if (ação == 3){ // Encerrar turno
                    if (h.energia < 3){ // Reabastecer energia
                        h.energia++;
                    }
                    h.turno = false;
                }
                else{
                    System.out.println("Escolha invalida, tente novamente");
                }

            }
            // Turno do inimigo

            // Sugestão: Escolher um numero aleatorio, se for par, ataque, se for impar, use o escudo.
        }




        scanner.close(); // Nescessario ?
    }
}
