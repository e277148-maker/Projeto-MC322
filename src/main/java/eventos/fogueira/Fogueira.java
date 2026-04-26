package eventos.fogueira;

import java.util.Scanner;

import baralho.Baralho;
import entidades.Heroi;


public class Fogueira {
    
    
    // Metodos

    /**
     * Inicia o evento de uma fogueira
     * @param heroi heroi controlado pelo jogador
     * @param scanner scaner que permite o jogo ser
     * @param baralho baralhoo do jogador
     */
    public void iniciar(Baralho baralho, Heroi heroi, Scanner scanner){

        boolean continuar = true;
        while(continuar == true){
            EscudoInicial escudoInicial = new EscudoInicial();
            MaisEnergia maisEnergia = new MaisEnergia();
            MaisOuro maisOuro = new MaisOuro();
            menu(baralho, heroi);
            int escolha = scanner.nextInt();
            if (escolha == 1){
                escudoInicial.aplicar(heroi);
                continuar = false;
            }
            if (escolha == 2){
                maisEnergia.aplicar(heroi);
                continuar = false;
            }
            if( escolha == 3){
                maisOuro.aplicar(heroi);
                continuar = false;
            }
            else{
                System.out.println("Escolha invalida");
            }
        }
    }
    /**
     * Imprime o menu da loja
     * @param baralho baralho do jogador
     * @param heroi heroi controlado pelo jogador
     */
    public void menu(Baralho baralho, Heroi heroi){
        System.out.printf("Ouro: %d\n", heroi.getOuro());
        System.out.println("Escolha entre:");
        System.out.println("1) Armadura permanente");
        System.out.println("2) Poção de energia");
        System.out.println("3) Saco de ouro");
    }

    
    
}