package eventos.escolha;

import entidades.Heroi;

public class EscudoInicial implements ItemEscolha {
    public String getNome(){
        return "Armadura permanente";
    }

    public void aplicar(Heroi heroi){
        heroi.ganharEscudoInicial(5);
    }
}
