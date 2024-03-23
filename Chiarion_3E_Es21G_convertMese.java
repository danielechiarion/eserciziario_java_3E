//Author: Daniele Chiarion
//Date: 20-03-2024

/* Realizzare un metodo (intToStrMese) che riceve in input un stringa corrispondente al valore di un mese es:GENNAIO e
ritorna in output il corrispondente valore numerico es:1.
Se il valore inserito non è valido il metodo deve ritornare -1 */

import java.util.Scanner;

public class Chiarion_3E_Es21G_convertMese {
    public static void main(String[] args) {
        String mese; //dichiarazione variabile

        Scanner keyboard = new Scanner(System.in); //creazione scanner

        /* richiesta inserimento dati input */
        System.out.println("Inserisci il mese");
        mese = keyboard.next().toLowerCase(); //prendo in input tutto in minuscolo

        System.out.println("Il corrispondente numero e' "+intToStrMese(mese)); //output risultato
    }

    /* metodo che, in base al mese inserito
    * restituisce il relativo numero intero */
    private static int intToStrMese(String mese)
    {
        /* dichiarazione variabile e
        * assegnazione valore mediante switch case */
        int num = switch(mese)
        {
            case "gennaio" -> 1;
            case "febbraio" -> 2;
            case "marzo" -> 3;
            case "aprile" -> 4;
            case "maggio" -> 5;
            case "giugno" -> 6;
            case "luglio" -> 7;
            case "agosto" -> 8;
            case "settembre" -> 9;
            case "ottobre" -> 10;
            case "novembre" -> 11;
            case "dicembre" -> 12;
            default -> -1; //se il mese inserito è sbagliato
        };

        return num; //ritorno numero
    }
}
