package eventos.fogueira;

import entidades.Heroi;

public class MaisEnergia implements ItemFogueira{
    public String getNome(){
        return "Poção de energia";
    }

    public void aplicar(Heroi heroi){
        heroi.ganharEnergiaMaxima(2);
    }
}
