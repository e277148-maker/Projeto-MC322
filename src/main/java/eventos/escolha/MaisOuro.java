package eventos.escolha;

import entidades.Heroi;

public class MaisOuro implements ItemEscolha {
    public String getNome(){
        return "Saco de ouro";
    }

    public void aplicar(Heroi heroi){
        heroi.ganharOuro(10);
    }
}
