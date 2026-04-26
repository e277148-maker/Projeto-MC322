package eventos.loja;

import entidades.Heroi;

public interface ItemLoja {

    String getNome();

    int getPreco();

    void aplicar(Heroi heroi);
}