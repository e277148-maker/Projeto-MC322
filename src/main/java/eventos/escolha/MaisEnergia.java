package eventos.escolha;

import entidades.Heroi;

public class MaisEnergia implements ItemEscolha{
    public String getNome(){
        return "Poção de energia";
    }

    public void aplicar(Heroi heroi){
        heroi.ganharEnergiaMaxima(2);
    }
}
