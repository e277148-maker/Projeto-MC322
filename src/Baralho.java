import java.util.List;
import java.util.Random;

public class Baralho {
    private List <Carta> pilhaDeCompra;
    private List <Carta> pilhaDeDescarte;
    private List <Carta> mao;

    // Getters

    public List <Carta> getPilhaDeCompras(){
        return pilhaDeCompra;
    }

    public List <Carta> getPilhaDeDescarte(){
        return pilhaDeDescarte;
    }

    public List <Carta> mao(){
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

    public void comprarCarta(){
        Random random = new Random();
        int indice = random.nextInt(pilhaDeCompra.size());
        mao.add(pilhaDeCompra.get(indice));
        pilhaDeCompra.remove(indice);
        if(pilhaDeCompra.size() == 0){
            for(int i = 0; i < pilhaDeDescarte.size(); i++){
                pilhaDeCompra.add(pilhaDeDescarte.get(i));
                pilhaDeDescarte.remove(i);
            }
        }
    }

    public void descartar(Carta carta){
        int indice = mao.indexOf(carta);
        pilhaDeDescarte.add(carta);
        mao.remove(indice);
    }

    public void imprimirMao(){
        System.out.println("Sua mão: ");
        for (int i = 0; i < mao.size(); i++){
            System.out.print(i + 1);
            System.out.print("- ");
            System.out.println(mao.get(i).getNome());
        }
    }
}
