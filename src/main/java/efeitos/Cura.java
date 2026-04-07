// Classe para representar um efeito de cura que pode ser aplicado a uma entidade durante uma batalha

package efeitos;

import batalhas.*;
import entidades.Entidade;

public class Cura extends Efeito {
    /**
     * Cria um efeito de cura com os atributos da classe {@link Efeito}
     */
    public Cura(String nome, Entidade dono, int acumulo, int efeito, Evento evento, Batalha batalha) {
        super(nome, dono, acumulo, efeito, evento, batalha);
    }

    @Override
    /**
     * Aplica o efeito, aumentando a vida da entidade de acordo com o poder do efeito até, no maximo, a vida maxima dessa entidade
     */
    protected void aplicarEfeito(){

        int vidaDono = getDono().getVida();

        // Verifica se a cura ultrapassa a vida máxima da entidade e ajusta a vida de acordo
        if (vidaDono < getDono().getVidaMaxima() - getEfeito()){
            getDono().setVida(vidaDono + getEfeito());        

        } else {

            getDono().setVida(getDono().getVidaMaxima());

        }
    }
}
