//Author: Daniele Chiarion
//Date: 26-02-2024

/* scrivi un programma che
* leggendo una stringa
* dividi le parole separate da spazi
* inserendolo in un array di stringhe */

import java.util.Scanner;

public class Chiarion_3E_Es20A_dividiStringhe {
    public static void main(String[] args) {
        /* dichiarazione variabile */
        String input;
        /* creazione vettore */
        String[] parole = new String[0]; //inizializzo a 0, non so ancora la dimensione
        /* istanziazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* input stringa */
        System.out.println("Inserisci la stringa: ");
        input = keyboard.next();

        /* divisione stringa in parole */
        dividiParole(parole, input);

        /* output risultati */
        printParole(parole);
    }

    /* metodo per aggiungere posizioni array */
    private static void aggiungiPosArray(String[] vet) {
        /* dichiarazione secondo vettore */
        String[] vet2 = new String[vet.length + 1];

        /* cambio indirizzo a cui punta l'array */
        vet = vet2;
    }

    /* metodo per suddividere la stringa
     * in un vettore di stringhe */
    private static void dividiParole(String[] vet, String input) {
        /* dichiarazione e inizializzazione variabili */
        int indexInizio = 0, indexFine;

        do {
            /* se il carattere è diverso da uno spazio */
            if (input.charAt(indexInizio) != ' ') {
                /* assegnazione valore indice finale */
                indexFine = indexInizio;
                /* vado avanti fino a quando non ci sono spazi */
                while (input.charAt(indexFine) != ' ' && indexFine<input.length()-1)
                    indexFine++;

                /* aumento posizione vettore */
                aggiungiPosArray(vet);
                vet[vet.length - 1] = input.substring(indexInizio, indexFine);

                /* riassegnazione valori indici
                 * si parte dal carattere nella posizione successiva alla fine */
                indexInizio = indexInizio + 2; //salto un carattere, che corrisponde allo spazio
                indexFine = indexInizio;
            } else
                indexInizio++;
        } while (indexInizio < input.length()); //continua fino a quando non si arriva a fine stringa
    }

    /* metodo per l'output delle diverse
    * stringhe divise */
    private static void printParole(String[] vet) {
        System.out.println("\nSUDDIVISIONE IN PAROLE");
        for (int i = 0; i < vet.length; i++) {
            System.out.println((i + 1) + "^ parola: " + vet[i]); //output delle singole parole
        }
    }
}