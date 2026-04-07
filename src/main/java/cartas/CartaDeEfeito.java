// Classe para representar uma carta de efeito que pode ser usada durante uma batalha para aplicar um efeito a uma entidade

package cartas;

import batalhas.*;
import efeitos.*;
import entidades.*;
/**
 * Gerencia as cartas de efeitos
 */
public class CartaDeEfeito extends Carta {
    /**
     * Número de turnos que o efeito ficara ativo
     */
    private int acumulo;
    /**
     * Evento no qual será aplicado o efeito
     */
    private Evento evento;
    /**
     * Batalha na qual o efeito pertence
     */
    private Batalha batalha;
    /**
     * Tipo do efeito
     */
    private String tipoEfeito;
    /**
     * Alvo do efeito
     */
    private String alvoEfeito;

    /**
     * Inicializa uma carta de efeito
     * @param nome Nome da carta
     * @param descricao Descrição da carta
     * @param custo Custo da carta
     * @param efeito Efeito da carta
     * @param acumulo Número de turnos que o efeito ficara ativo
     * @param evento Evento no qual o efeito deverá ser aplicado
     * @param batalha Batalha na qual o efeito pertence
     * @param tipoEfeito Tipo do efeito
     * @param alvoEfeito Alvo do efeito
     */
    public CartaDeEfeito(String nome, String descricao, int custo, int efeito, int acumulo, Evento evento, Batalha batalha, String tipoEfeito, String alvoEfeito) {

        super(nome, descricao, custo, efeito);

        this.acumulo = acumulo;
        this.evento = evento;
        this.batalha = batalha;
        this.tipoEfeito = tipoEfeito;
        this.alvoEfeito = alvoEfeito;

    }

    // Getters

    public int getAcumulo() {
        return acumulo;
    }

    public Evento getEvento() {
            return evento;
    }
        
    public Batalha getBatalha() {
        return batalha;
    }

    public String getTipoEfeito() {
        return tipoEfeito;
    }

    public String getAlvoEfeito() {
        return alvoEfeito;
    }

    // Setters
    public void setAcumulo(int acumulo) {
        this.acumulo = acumulo;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }

    public void setTipoEfeito(String tipoEfeito) {
        this.tipoEfeito = tipoEfeito;
    }

    public void setAlvoEfeito(String alvoEfeito) {
        this.alvoEfeito = alvoEfeito;
    }


    // Método para usar a carta, que aplica o efeito correspondente ao tipo de efeito e alvo

    @Override
    /**
     * Herói usa a carta, que cria um efeito que tem  como efeito o alvo  da carta 
     */
    public void usar(Heroi heroi, Inimigo inimigo) {

        Efeito novoEfeito = null;
        Entidade alvo;

        // Descobre o alvo
        if (this.alvoEfeito.equalsIgnoreCase("heroi")) {
            alvo = heroi;
        } else {
            alvo = inimigo;
        }

        // Cria o efeito correspondente ao tipo de efeito
        if (this.tipoEfeito.equalsIgnoreCase("veneno")) {
            novoEfeito = new Veneno(this.tipoEfeito, alvo, this.acumulo, getEfeito(), this.evento, this.batalha);

        } else if (this.tipoEfeito.equalsIgnoreCase("buff")) {
            novoEfeito = new Cura(this.tipoEfeito, alvo, this.acumulo, getEfeito(), this.evento, this.batalha);

        }

        if (novoEfeito != null) {
            alvo.aplicarEfeito(novoEfeito);
        }

        heroi.perderEnergia(getCusto());

    }

}
