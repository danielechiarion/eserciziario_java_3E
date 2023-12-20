//Author: Daniele Chiarion
//Date: 06-12-2023

/* Inserire un numero intero che rappresenta i secondi trascorsi dall’inizio di oggi e mostra in
uscita l’ora attuale espressa in hh:mm:ss (ore:minuti:secondi).
Se l’utente inserisce un valore nullo o un valore superiore ad un giorno chiedere il
reinserimento. */

import java.util.Scanner;

public class Chiarion_3E_Es04A_hMinSec {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        int ore, min, sec;
        int input;

        /* dichiarazione e inizializzazione costanti */
        final int secGiorno=86400;

        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* Inserimento dati input */
        do {
            System.out.println("Inserisci i secondi: ");
            input=keyboard.nextInt();

            if(input<=0 || input>secGiorno)
                System.out.println("Valore inserito errato. Riprova");
        }while(input<=0 || input>secGiorno);

        /* Elaborazione dati */
        ore=input/3600;
        min=input%3600/60;
        sec=input-ore*3600-min*60;

        /* restituzione dati output */
        System.out.println(input+" secondi corrispondono a:");
        System.out.println(ore+" ore: "+min+" minuti: "+sec+" secondi");
    }
}
