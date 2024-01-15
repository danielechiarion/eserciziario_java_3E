//Author: Daniele Chiarion
//Date: 15-01-2024

/* scrivi un programma che simuli l'estrazione del lotto sulle varie ruote */
import java.util.*;

public class Chiarion_3E_Es15A_lotto {
    public static void main(String[] args) {
        /* dichiarazione costante */
        final int tot=5;

        /* dichiarazione vettore */
        int[] numeri = new int[tot];

        /* dichiarazione variabile di controllo */
        int check=0;

        /* creazione generatore casuale */
        Random casuale = new Random();

        System.out.println("Estrazioni ruota VENEZIA");

        /* Creazione numeri e stampa a video */
        for(int i=0;i<numeri.length;i++)
        {
            do {
                check=0; //azzeramento variabile
                numeri[i]=casuale.nextInt(0,90)+1;
                for(int k=i-1;k>=0;k--)
                {
                    if(numeri[i]==numeri[k])
                        check++;
                }
            }while(check!=0); //viene effettuato questo controllo per evitare che ci siano numeri doppi

            /* output risultati */
            System.out.println(numeri[i]);
        }
    }
}
