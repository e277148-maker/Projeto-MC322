package eventos.escolha;

import entidades.Heroi;

public interface ItemEscolha {
    String getNome();

    void aplicar(Heroi heroi);
    
}
