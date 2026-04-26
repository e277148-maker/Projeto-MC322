package eventos.fogueira;

import entidades.Heroi;

public class MaisOuro implements ItemFogueira {
    public String getNome(){
        return "Saco de ouro";
    }

    public void aplicar(Heroi heroi){
        heroi.ganharOuro(10);
    }
}
