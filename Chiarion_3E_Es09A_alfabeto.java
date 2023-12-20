//Author: Daniele Chiarion
//Date: 18-12-2023

/* scrivi un programma che
in base ad una stringa data in input visualizzi:
_ caratteri numerici
_ caratteri alfabetici
_ caratteri strani */

import java.util.Scanner;

public class Chiarion_3E_Es09A_alfabeto {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        String frase;
        int i;
        int contLettere=0,contNumeri=0,contStrani=0;

        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* richiesta inserimento stringa */
        System.out.println("Inserisci una stringa: ");
        frase = keyboard.nextLine();

        /* conteggio caratteri */
        for(i=0;i<frase.length();i++)
        {
            if((frase.charAt(i)>='a' && frase.charAt(i)<='z') || (frase.charAt(i)>='A' && frase.charAt(i)<='Z'))
                contLettere++;
            else if(frase.charAt(i)>='0' && frase.charAt(i)<='9')
                contNumeri++;
                else
                    contStrani++;
        }

        /* restituzione dati output */
        System.out.println("Le lettere inserite sono "+contLettere);
        System.out.println("I numeri inseriti sono "+contNumeri);
        System.out.println("Altri caratteri inseriti sono "+contStrani);
    }
}
