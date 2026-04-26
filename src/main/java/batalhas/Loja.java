package batalhas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baralho.Baralho;
import cartas.Carta;
import entidades.Heroi;
/**
 * Gerencia a loja
 */
public class Loja extends Eventos {
    // Atributos

    /**
     * Cartas que podem ser adicionadas no baralho por meio de compras na loja
     */
    private List <Carta> cartas = new ArrayList<>();
    
    // Metodos
    /**
     * Cria uma loja
     * @param cartas Cartas que podem ser adicionadas no baralho por meio de compras na loja
     */
    public Loja(List<Carta> cartas) {
        this.cartas = cartas;
    }
    /**
     * Inicia o evento de uma loja
     * @param baralho baralho do jogador
     * @param heroi heroi controlado pelo jogador
     * @param scanner scaner que permite o jogo ser
     */
    public void iniciar(Baralho baralho, Heroi heroi, Scanner scanner){
        boolean continuar = true;
        while(continuar == true){
            menu(baralho, heroi);
            int escolha = scanner.nextInt();
            if (escolha == 1){
                if(heroi.getOuro() >= 25){
                    heroi.setVida(heroi.getVidaMaxima());
                    heroi.perderEnergia(25);
                }
                else{
                    System.out.println("Você não tem ouro suficiente");
                }
            }
            if (escolha == 2){
                if (heroi.getOuro() >= 10){
                    List <Carta> pilhaDeCompra = baralho.getPilhaDeCompras();
                    pilhaDeCompra.add(cartas.get(0));
                    baralho.setPilhaDeCompra(pilhaDeCompra);
                    cartas.remove(0); 
                    heroi.perderEnergia(10); 
                }
                
            }
            if( escolha == 3){
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
        System.out.println("Você pode:");
        System.out.println("1) Restaurar vida ---- 25 moedas");
        System.out.printf("2) Adcionar a carta %s no baralho ---- 10 moedas\n", cartas.get(0).getNome());
        System.out.println("3) Sair da loja");
    }
    // Getters

    public List<Carta> getCartas() {
        return cartas;
    }
    // Setters

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
    
}
