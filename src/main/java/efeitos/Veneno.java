// Classe para representar um efeito de veneno que pode ser aplicado a uma entidade durante uma batalha

package efeitos;

import entidades.*;
import eventos.batalha.Batalha;
import eventos.batalha.EventoDaBatalha;
/**
 * Gerencia os efeitos de veneno
 */
public class Veneno extends Efeito {

    // Construtor
/**
 * Inicializa um efeito de cura
 * @param nome Nome do efeito
 * @param dono Entidade na qual o efeito sera aplicado
 * @param acumulo Número de turnos que o efeito ficará ativo
 * @param efeito Quantidade maxi de dano que será causado
 * @param evento Evento no qual o efeito será aplicado
 * @param batalha Batalha ao qual o efeito pertence
 */
    public Veneno(String nome, Entidade dono, int acumulo, int efeito, EventoDaBatalha evento, Batalha batalha) {
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
