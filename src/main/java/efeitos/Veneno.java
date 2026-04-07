// Classe para representar um efeito de veneno que pode ser aplicado a uma entidade durante uma batalha

package efeitos;

import entidades.*;
import batalhas.*;

public class Veneno extends Efeito {

    // Construtor
    /**
     * Cria um efeito de cura com os atributos da classe {@link Efeito}
     */
    public Veneno(String nome, Entidade dono, int acumulo, int efeito, Evento evento, Batalha batalha) {
        super(nome, dono, acumulo, efeito, evento, batalha);
    }

    // Metodos
    /**
     * Aplica o efeito, diminuindo a vida da entidade de acordo com o poder do efeito
     */
    @Override
    protected void aplicarEfeito(){
        getDono().receberDano(getEfeito());
    }

}
