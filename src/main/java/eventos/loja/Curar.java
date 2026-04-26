package eventos.loja;

import entidades.Heroi;

public class Curar implements ItemLoja {
     public String getNome(){
        return "Poção de cura";
    }

    public int getPreco(){
        return 20;
    }

    public void aplicar(Heroi heroi){
        heroi.setVida(heroi.getVidaMaxima());

        heroi.perderOuro(getPreco());
    }
}
