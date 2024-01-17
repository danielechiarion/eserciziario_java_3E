//Author: Daniele Chiarion
//Date: 15-01-2024

/* scrivi un programma che simuli l'estrazione del lotto sulle varie ruote */

import java.util.Random;
import java.util.Scanner;

public class Chiarion_3E_Es15C_appLotto {
    public static void main(String[] args) {
        /* dichiarazione costante */
        final int tot=5;
        /* dichiarazione variabili */
        int scelta;
        /* dichiarazione vettore */
        int[] vet = new int[tot]; //non servirebbe crearlo, perchè non deve puntare ad una memoria
        //necessita però di essere dichiarato per il case 2

        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        do {
            ClrScr(); //pulisce lo schermo ogni volta
            /* menu di scelta */
            System.out.println("=== APP LOTTO ===");
            System.out.println("Menu:");
            System.out.println("\n[1] Estrazioni ruota di Venezia");
            System.out.println("[2] Visualizzazione risultati");
            System.out.println("[3] Fine");
            scelta = keyboard.nextInt();

            /* istruzioni suddivise in base al valore di scelta */
            switch(scelta)
            {
                case 1:
                    vet=estrazione(tot);
                    System.out.println("I valori sono stati estratti");
                    Wait(2); //attesa per visualizzare i risultati
                    break;
                case 2:
                    visual(vet);
                    Wait(5);
                    break;
                case 3:
                    System.out.println("Fine del programma");
                    Wait(3);
                    break;
                default:
                    System.out.println("Scelta errata. RIPROVA");
                    Wait(3);
            }
        }while(scelta!=3); //ripetizione se il valore non è quello della fine
    }

    private static int[] estrazione(int tot)
    {
        /* dichiarazione vettore */
        int[] numeri = new int[tot];

        /* dichiarazione variabile di controllo */
        int check=0;

        /* creazione generatore casuale */
        Random casuale = new Random();

        /* Creazione numeri e stampa a video */
        for(int i=0;i<numeri.length;i++)
        {
            do {
                check = 0; //azzeramento variabile
                numeri[i] = casuale.nextInt(0, 90) + 1;
                for (int k = i - 1; k >= 0; k--) {
                    if (numeri[i] == numeri[k])
                        check++;
                }
            }while(check!=0); //viene effettuato questo controllo per evitare che ci siano numeri doppi
        }

        return numeri;
    }

    /* metodo per la visualizzazione in output dei risultati */
    private static void visual(int[] vet)
    {
        /* output risultati */
        System.out.println("Estrazioni ruota di Venezia");
        int i=0;
        for(int numero : vet) //FOR EACH scorre tutte le posizioni del vettore
        {
            System.out.println(i+1+"^ numero: "+numero);
            i++; //il contatore non si aggiorna, numero è una variabile
        }
    }

    /* metodo per la pulizia dello schermo */
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* metodo per il tempo di attesa
    come parametro si inserisce il numero di secondi */
    private static void Wait(int val)
    {
        try{
            Thread.sleep(1000*val);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}