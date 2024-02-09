//Author: Daniele Chiarion
//Date: 09-02-2024

/* Inserire in vettore una sequenza di stringhe,
stampare a video solamente quelle che iniziano con la lettera maiuscola */

import java.util.Scanner;

public class Chiarion_3E_Es16B_stringaMaiusc {
    public static void main(String[] args) {
        /* dichiarazione variabile */
        int dim;
        /* creazione Scanner */
        Scanner keyboard = new Scanner(System.in);

        /* richiesta inserimento dimensione vettore */
        do {
            System.out.println("Quante stringhe vuoi inserire?");
            dim = keyboard.nextInt();
            if(dim<=0)
                System.out.println("Valore negativo o nullo non valido. Riprova");
        }while(dim<=0); //controllo se il numero di stringhe è positivo
        /* dichiarazione di un vettore */
        String[] stringhe = new String[dim];

        /* richiesta inserimento stringhe */
        for(int i=0;i<stringhe.length;i++)
        {
            System.out.println("Inserisci la "+(i+1)+"^ stringa");
            stringhe[i]=keyboard.next();
        }

        System.out.println("\nStringhe che iniziano con la lettera maiuscola:");
        /* output delle stringhe che
        * iniziano con la lettera maiuscola */
        for(int i=0;i<stringhe.length;i++)
        {
            if(stringhe[i].charAt(0)>='A' && stringhe[i].charAt(0)<='Z') //restituisce in output se la lettera iniziale è compresa tra A e Z
                System.out.println(stringhe[i]);
        }
    }
}
