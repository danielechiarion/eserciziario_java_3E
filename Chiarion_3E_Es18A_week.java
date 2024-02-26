//Author: Daniele Chiarion
//Date: 19-02-2024

/* realizzare un programma che
* prendendo in input un nome,
* indichi se è pari o dispari */

import java.util.Scanner;

public class Chiarion_3E_Es18A_week {
    public static void main(String[] args) {
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);
        /* dichiarazione variabili */
        String day;
        String result;
        /* dichiarazione vettore */
        String[] week ={"lunedi", "martedi'", "mercoledi", "giovedi", "venerdi", "sabato", "domenica"};

        /* richiesta inserimento dati in input */
        System.out.println("Inserisci giorno della settimana: ");
        day = keyboard.next().toLowerCase();

        /* output del risultato */
        System.out.println("Il giorno e' "+dayResult(day));
    }

    private static String dayResult(String day)
    {
        String result;
        switch(day)
        {
            case "lunedi":
            case "mercoledi":
            case "venerdi":
            case "domenica":
                result="dispari";
                break;

            case "martedi", "giovedi", "sabato":
                result="pari";
                break;

            default:
                result="sbagliato";
                break;
        }
        return result;
    }

    private static String dayResult2(String day)
    {
        String result;
        return result=switch(day)
        {
            case "lunedi", "mercoledi", "venerdi", "domenica" ->
                "dispari";

            case "martedi", "giovedi", "sabato" ->
                "pari";

            default ->
                "sbagliato";
        }; //e' obbligatorio alla fine mettere il punto e virgola
    }
}
