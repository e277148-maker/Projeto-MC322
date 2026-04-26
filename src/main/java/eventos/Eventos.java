package eventos;

import java.util.Scanner;

import baralho.Baralho;
import entidades.Heroi;


public abstract class Eventos {
    
     public abstract void iniciar(Baralho baralho,Heroi heroi, Scanner scanner);
     
     public abstract void menu(Baralho baralho, Heroi heroi);
}
