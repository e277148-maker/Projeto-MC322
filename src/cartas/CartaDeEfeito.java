// Classe para representar uma carta de efeito que pode ser usada durante uma batalha para aplicar um efeito a uma entidade

package cartas;

import batalhas.*;
import efeitos.*;
import entidades.*;

public class CartaDeEfeito extends Carta {

    private int acumulo;
    private Evento evento;
    private Batalha batalha;
    private String tipoEfeito;
    private String alvoEfeito;


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
