//Author: Daniele Chiarion
//Date: 13-12-2023

/* Realizza un programma che visualizzi un codice digitale
* che inizi con S e finisca con P */

/* importazione librerie */
import java.io.IOException;
import java.util.Scanner;

public class Chiarion_3E_Es07A_cronoDigitale {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        int sec,dec,cent;
        String inizio, fine="";

        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* richiesta inserimento dati input */
        do {
            System.out.println("Inserisci S per far partire il cronometro: ");
            inizio = keyboard.next().toUpperCase();
        }while(!inizio.equals("S"));

        /* avvio timer */
        if(inizio.equals("S")) {
            for (sec = 0; sec < 60; sec++) {
                for (dec = 0; dec < 10; dec++) {
                    for (cent = 0; cent < 10; cent++) {
                        if (!fine.equals("P")) {
                            System.out.print("\r" + sec + "." + dec + cent);
                            Wait();
                        }
                    }
                }
            }
        }
    }

    private static void Wait()
    {
        try{
            Thread.sleep(10);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
