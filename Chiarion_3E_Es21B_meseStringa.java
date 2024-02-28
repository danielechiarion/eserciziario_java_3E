//Author: Daniele Chiarion
//Date: 28-02-2024

/* Modificare l’esercizio precedente in modo
che il mese venga scritto in formato
stringa. */

import java.util.Scanner;

public class Chiarion_3E_Es21B_meseStringa {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        String inputData;
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);
        /* creazione vettore */
        int[] dataDivisa;

        /* input data utente */
        do {
            System.out.println("Inserisci la data");
            inputData = keyboard.next();
            /* messaggio di errore */
            if(!controlloDataInt(inputData))
            {
                System.out.println("La data non ha la giusta lunghezza. Riscrivila");
                Wait(4);
                ClrScr();
            }
        }while(!controlloDataInt(inputData)); //se la data non ha la giusta lunghezza

        /* divisione data */
        dataDivisa=dividiData(inputData);
        /* output risultati */
        printData(dataDivisa);
    }

    /* controllo correttezza data
     * (deve essere lungo otto numeri)
     * restituisce un valore booleano */
    private static boolean controlloDataInt(String data)
    {
        /* dichiarazione costante */
        final int maxlength = 8;
        /* dichiarazione variabili */
        boolean result;

        if(data.length()==maxlength) //se il numero di cifre corrisponde, si va avanti
            result=true;
        else //altrimenti darà risultato falso
            result=false;

        return result; //ritorno valore
    }

    /* metodo per dividere la data
     * in giorno, mese, anno */
    private static int[] dividiData(String inputData)
    {
        /* creazione vettore */
        int[] diviso = new int[3];
        /* dichiarazione costanti
         * - serve a capire quanto suddividere l'input dato */
        final int[] step = {2,2,4};

        /* divisione giorno-mese-anno
         * si parte dalla fine */
        for(int i=diviso.length-1;i>=0; i--)
        {
            diviso[i]=Integer.parseInt(inputData.substring(inputData.length()-1-step[i])); //prendo la porzione di stringa interessata
            inputData= inputData.substring(0,inputData.length()-1-step[i]); //tolgo i valori già selezionati
        }

        return diviso; //ritorno vettore
    }

    /* metodo per l'output del risultato */
    private static void printData(int[] vet)
    {
        System.out.println("\nDIVISIONE DELLA DATA:");
        System.out.println("Giorno: "+vet[0]);
        System.out.println("Mese: "+matchMese(vet[1]));
        System.out.println("Anno: "+vet[2]);
    }

    /* metodo per calcolare la potenza */
    private static int potenza(int base, int esponente)
    {
        /* dichiarazione e inizializzazione variabile */
        int result=1;

        /* ciclo per la moltiplicazione */
        for(int i=0;i<esponente;i++)
        {
            result=result*base;
        }

        return result; //valore di ritorno
    }

    /* metodo per corrispondere ad un valore numerico
    * la stringa corrispondente */
    private static String matchMese(int val)
    {
        /* dichiarazione variabile */
        String mese=switch (val) //switch case con le varie opzioni
        {
            case 1 -> "gennaio";
            case 2 -> "febbraio";
            case 3 -> "marzo";
            case 4 -> "aprile";
            case 5 -> "maggio";
            case 6 -> "giugno";
            case 7 -> "luglio";
            case 8 -> "agosto";
            case 9 -> "settembre";
            case 10 -> "ottobre";
            case 11 -> "novembre";
            case 12 -> "dicembre";
            default -> "sbagliato"; //nel caso in cui la cifra sia un'altra
        };

        return mese; //valore di ritorno
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
