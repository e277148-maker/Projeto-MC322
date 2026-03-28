package efeitos;
import entidades.*;
import batalhas.*;

public class Veneno extends Efeito {

    //Construtor

    public Veneno(String nome, Entidade dono, int acumulo, int efeito, Evento evento) {
        super(nome, dono, acumulo, efeito, evento);
    }
    // Metodos

    @Override
    protected void aplicarEfeito(){
        getDono().receberDano(getEfeito());
    }

    
}
