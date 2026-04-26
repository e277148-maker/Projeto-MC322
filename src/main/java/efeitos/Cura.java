// Classe para representar um efeito de cura que pode ser aplicado a uma entidade durante uma batalha

package efeitos;

import entidades.Entidade;
import eventos.batalha.Batalha;
import eventos.batalha.EventoDaBatalha;
/**
 * Gerencia os efeitos de cura
 */
public class Cura extends Efeito {
/**
 * Inicializa um efeito de cura
 * @param nome Nome do efeito
 * @param dono Entidade na qual o efeito sera aplicado
 * @param acumulo Número de turnos que o efeito ficará ativo
 * @param efeito Quantidade maxi de vida que será curada
 * @param evento Evento no qual o efeito será aplicado
 * @param batalha Batalha ao qual o efeito pertence
 */
    public Cura(String nome, Entidade dono, int acumulo, int efeito, EventoDaBatalha evento, Batalha batalha) {
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
