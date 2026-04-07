/* Este código define a classe Baralho, que representa o baralho de cartas em um jogo.
* Ele inclui métodos para comprar cartas, descartar cartas e ver o topo do baralho. 
* O código também lida com a situação em que o baralho de compras está vazio, 
* embaralhando a pilha de descarte para formar um novo baralho de compras quando necessário.
*/

package baralho;

import java.util.List;
import java.util.Collections;
import cartas.*;

/**
 * Gerencia o baralho
 */
public class Baralho {

    // Cria as listas para o baralho, descarte e mão do jogador


    /**
     * Lista que contem as cartas que o heroi pode comprar
     */
    private List <Carta> pilhaDeCompra;
    /**
     * Lista que contem as cartas descartadas
     */
    private List <Carta> pilhaDeDescarte;
    /**
     * Lista que contem as cartas da mâo do herói
     */
    private List <Carta> mao;

    // Construtor
    /**
     * Inicializa o baralho
     * @param pilhaDeCompra Lista que contem as cartas que o heroi pode comprar
     * @param pilhaDeDescarte Lista que contem as cartas descartadas
     * @param mao Lista que contem as cartas da mâo do herói
     */
    public Baralho(List <Carta> pilhaDeCompra, List <Carta> pilhaDeDescarte, List <Carta> mao){

        this.pilhaDeCompra = pilhaDeCompra;
        this.pilhaDeDescarte = pilhaDeDescarte;
        this.mao = mao;

    }

    // Getters
    public List <Carta> getPilhaDeCompras(){
        return pilhaDeCompra;
    }

    public List <Carta> getPilhaDeDescarte(){
        return pilhaDeDescarte;
    }

    public List <Carta> getMao(){
        return mao;
    }

    // Setters
    public void setPilhaDeCompra(List <Carta> pilhaDeCompra){
        this.pilhaDeCompra = pilhaDeCompra;
    }

    public void setPilhaDeDescarte(List <Carta> pilhaDeDescarte){
        this.pilhaDeDescarte = pilhaDeDescarte;
    }

    public void setMao(List <Carta> mao){
        this.mao = mao;
    }

    // Outros metodos


    /**
     * Jogador compra uma carta da pilha de compra
     */
    public void comprarCarta(){
    
        if (pilhaDeCompra.isEmpty()) {
            if (!pilhaDeDescarte.isEmpty()) {

                // Feedback visual do embaralhamento
                System.out.println("\n[SISTEMA] Embaralhando a pilha de descarte para formar nova pilha de compras...\n");

                pilhaDeCompra.addAll(pilhaDeDescarte);
                pilhaDeDescarte.clear();
                Collections.shuffle(pilhaDeCompra);

            } else {
                return; 
            }
        }

        if (!pilhaDeCompra.isEmpty()) {

            Carta cartaComprada = pilhaDeCompra.remove(0);
            mao.add(cartaComprada);

        }

    }
    /**
     * Descarta uma carta da mão do jogador
     * @param carta Carta que será descartada
     */
    public void descartar(Carta carta){

        int indice = mao.indexOf(carta);
        pilhaDeDescarte.add(carta);
        mao.remove(indice);

    }

    /**
     * Descarta todas as cartas da mão do herói
     */
    public void descartarMao() {
        pilhaDeDescarte.addAll(mao);
        mao.clear();
    }
    /**
     * Pega a primeira carta da pilha de compra
     * @return Retorna a primira carta do baralho se a pilha de compra não for nula, se for nula retorna a string "Nenhuma (Embaralho iminente)"
     */
    public String verTopoBaralho() {

        if (!pilhaDeCompra.isEmpty()) {
            return pilhaDeCompra.get(0).getNome();
        }
        return "Nenhuma (Embaralho iminente)";
    }

}
