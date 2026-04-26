package batalhas;

import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;

import baralho.Baralho;
import entidades.Heroi;

/**
 * Gerencia o sistema de progresão com varias batalhas
 */
public class Mapa {

    /**
     * Executa uma sequencia de batalhas
     * @param noBatalhaInicial Ultima batalha concluida pelo jogador
     * @param listaInimigos Lista com as listas de inimigos
     * @param heroi Heroi controlado pelo jogador
     * @param baralho Baralho com as cartas
     * @param scanner Utilizado para receber inputs do jogador
     * @param posicaoBatalha Posição da batalha na arvore de batalhas
     */
    public void rodarSequnciaDeBatalhas(DefaultMutableTreeNode noBatalhaInicial, Heroi heroi, Baralho baralho, Scanner scanner, Loja loja){
        Batalha batalha = (Batalha) noBatalhaInicial.getUserObject();
        batalha.iniciar(baralho, heroi, scanner);
        if (heroi.estarVivo() & !noBatalhaInicial.isLeaf()){
            loja.iniciar(baralho, heroi, scanner);
        }
        menuEntreBatalhas(noBatalhaInicial, heroi);
        if(heroi.estarVivo() & !noBatalhaInicial.isLeaf()){
            int escolha = scanner.nextInt();
            if(escolha == 1){
                DefaultMutableTreeNode noProximaBatalha = (DefaultMutableTreeNode) noBatalhaInicial.getChildAt(0);
                rodarSequnciaDeBatalhas(noProximaBatalha, heroi, baralho, scanner, loja);
            }
            if(escolha == 2){
                DefaultMutableTreeNode noProximaBatalha = (DefaultMutableTreeNode) noBatalhaInicial.getChildAt(1);
                rodarSequnciaDeBatalhas(noProximaBatalha, heroi, baralho, scanner, loja);
            }
        }
    }

        /**
     * Imprime o menu entre as batalhas
     * @param noBatalhaAtual No da arvore de batalhas que contem a última batalha finalizada
     * @param heroi Herói controlado pelo jogador
     */
    private void menuEntreBatalhas (DefaultMutableTreeNode noBatalhaAtual, Heroi heroi){
        if (heroi.estarVivo() & !noBatalhaAtual.isLeaf()){

            DefaultMutableTreeNode noProximaBatalha1 = (DefaultMutableTreeNode) noBatalhaAtual.getChildAt(0);
            DefaultMutableTreeNode noProximaBatalha2 = (DefaultMutableTreeNode) noBatalhaAtual.getChildAt(1);

            Batalha ProximaBatalha1 = (Batalha) noProximaBatalha1.getUserObject();
            Batalha ProximaBatalha2 = (Batalha) noProximaBatalha2.getUserObject();

            System.out.println("Selecione a sua próxima batalha:");
            System.out.printf("1- %s\n", ProximaBatalha1.getNome());
            System.out.printf("2- %s\n", ProximaBatalha2.getNome());
            System.out.println("");
            System.out.println("Escolha:");
        }
        if (heroi.estarVivo() & noBatalhaAtual.isLeaf()) {
            System.out.println("PARABENS, VOCÊ GANHOU O JOGO!!!");
        }
    }
}
