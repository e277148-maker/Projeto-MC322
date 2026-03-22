// Subclasse para representar o herói do jogo, que é um tipo específico de entidade

public class Heroi extends Entidade {

    private int energia;
    private boolean turno;

    // Construtor
    public Heroi(String nome, String descricao, int vida, int escudo) {

        super(nome, descricao, vida, escudo);
        this.energia = 6;
        this.turno = false;

    }

    // Getters

    public int getEnergia(){
        return energia;
    }

    public boolean getTurno(){
        return turno;
    }

    // Setters

    public void setTurno(boolean turno){
        this.turno = turno;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }
    
    // Outros metodos

    void perderEnergia(int gasto){
        energia = energia - gasto;
    }

    /*

    void ganharEnergia(){

        if (energia <= 4){
            energia += 2;
        }

        if (energia == 5){
            energia++;

        }   

    }

    */

}