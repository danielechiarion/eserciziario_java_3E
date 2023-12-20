//Author: Daniele Chiarion
//Date: 20-12-2023

/* scrivi un programma
che organizza le interrogazioni
automaticamente */

/* importazione librerie */
import java.util.*; // tutti i comandi del package util

public class Chiarion_3E_Es11A_interrogazione {
    public static void main(String[] args) {
        String studente;

        /* creazione variabili dinamiche (generazione causale) */
        Random casuale = new Random();

        /* for(int i=0; i<10; i++)
        {
            //OVERLOAD: per lo stesso metodo ci sono più variazioni
            System.out.println(casuale.nextInt(0,20)+1);
        } */

        /* Generiamo un valore casuale (1-20) corrispondente
        al numero di studenti della 3E */
        // System.out.println(casuale.nextInt(0,20)+1);

        //no operazioni booleane
        /*
        switch(casuale.nextInt(0,9)+1){ //posso definire byte, short, char, int, string, numeratori
            case 1: //non posso definire espressioni di confronto
                studente="Mattia Albieri";
                break;
            case 2:
                studente="Filippo Barchi";
                break;
            case 3:
                studente="Noemi Basaglia";
                break;
            case 4: //non posso definire espressioni di confronto
                studente="Francesco Bego";
                break;
            case 5: //non posso definire espressioni di confronto
                studente="Stefano Boscolo";
                break;
            case 6: //non posso definire espressioni di confronto
                studente="Daniele Chiarion";
                break;
            case 7: //non posso definire espressioni di confronto
                studente="Eleonora Cosmi";
                break;
            case 8: //non posso definire espressioni di confronto
                studente="Mattia Crepaldi";
                break;

            default:
                studente="Oggi non si interroga";
                break;
        }

        System.out.println("E' uscito il nome di "+studente); */

        switch(casuale.nextInt(0,9)+1){ //posso definire byte, short, char, int, string, numeratori
            case 1: //non posso definire espressioni di confronto

            case 2:

            case 3:

            case 4: //non posso definire espressioni di confronto
                studente="Francesco Bego";
                break;
            case 5: //non posso definire espressioni di confronto

            case 6: //non posso definire espressioni di confronto

            case 7: //non posso definire espressioni di confronto
                studente="Eleonora Cosmi";
                break;
            case 8: //non posso definire espressioni di confronto
                studente="Mattia Crepaldi";
                break;

            default:
                studente="Oggi non si interroga";
                break;
        }

        System.out.println("E' uscito il nome di "+studente);
    }
}
