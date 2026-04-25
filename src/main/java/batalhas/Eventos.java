package batalhas;

import java.util.List;
import java.util.Scanner;

import baralho.Baralho;
import entidades.Heroi;
import entidades.Inimigo;

public abstract class Eventos {
    
     public abstract void iniciar(Baralho baralho, Heroi heroi, List<Inimigo> inimigos, Scanner scanner);
     
     public abstract void menu(Baralho baralho, Heroi heroi, List<Inimigo> inimigos);
}
