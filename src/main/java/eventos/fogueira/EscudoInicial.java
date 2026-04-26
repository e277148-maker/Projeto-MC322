package eventos.fogueira;

import entidades.Heroi;

public class EscudoInicial implements ItemFogueira {
    public String getNome(){
        return "Armadura permanente";
    }

    public void aplicar(Heroi heroi){
        heroi.ganharEscudoInicial(5);
    }
}
