//Author: Daniele Chiarion
//Date: 26-02-2024

/* Scrivere un programma DueSequenze che lette da input due sequenze di
numeri interi, ciascuna di 5 elementi, stampa il messaggio "OK" se almeno un
numero della prima sequenza compare anche nella seconda, altrimenti stampa
il messaggio "NO".
Bonus: utilizzare un metodo per inserire i dati all’interno dei vettori di
interi e, nel caso in cui le due sequenze abbiano almeno un valore in
comune, interrompere i confronti.
Es: risolto 7 con metodo e interruzione 8 */

import java.util.Scanner;

public class Chiarion_Es19B_esVerifica {
    public static void main(String[] args) {
        /* dichiarazione costanti */
        final int numElementi=5;
        /* istanziazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* output risultati */
        if(checkSequenze(inputSequenza(numElementi, keyboard, 1), inputSequenza(numElementi, keyboard, 2)))
            System.out.println("OK"); //se compare almeno un numero uguale in entrambe le sequenze
        else
            System.out.println("NO"); //se non compare almeno un numero uguale in entrambe le sequenze
    }

    /* metodo per inserire in input i numeri */
    private static int[] inputSequenza(int dim, Scanner keyboard, int pos)
    {
        /* creazione vettore */
        int[] vet = new int[dim];

        System.out.println("\n"+pos+"^ SEQUENZA DI STRINGHE");
        /* input numeri */
        for(int i=0;i<vet.length;i++)
        {
            System.out.println("Inserisci "+(i+1)+"^ numero");
            vet[i]=keyboard.nextInt();
        }

        return vet; //restituisce vettore
    }

    /* metodo per controllare se è presente
    * almeno un numero uguale in entrambe le sequenze */
    private static boolean checkSequenze(int[] vet1, int[] vet2)
    {
        /* dichiarazione e inizializzazione variabile */
        boolean check=false;

        /* scorro tutti i valori del primo vettore */
        for(int i=0;i<vet1.length;i++)
        {
            /* scorro tutti i valori del secondo vettore */
            for(int j=0;j<vet2.length;j++)
            {
                /* se almeno un numero del primo vettore e' uguale a un
                * elemento del secondo */
                if(vet1[i]==vet2[j])
                {
                    check=true; //cambio valore booleano
                    break; //esco dal secondo ciclo
                }
            }

            if(check)
                break; //esco dal primo ciclo
        }

        return check; //ritorno valore booleano
    }
}
