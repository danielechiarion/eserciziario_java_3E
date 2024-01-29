//Author: Daniele Chiarion
//Date: 29-01-2024

/* verifico che l'estrazione dei numeri non si ripeta
* utilizzando un vettore di booleani */

import java.util.*;
public class Chiarion_3E_Es15F_estrazioniBool {
    public static void main(String[] args) {
        Random casuale = new Random(); //generazione estrattore casuale
        int[] ruota = new int[5];

        /* estrazione numeri casuali */
        ruota = estrazione(casuale, ruota);
        /* output risultati */
        System.out.println("I numeri vincenti: ");
        printNumeri(ruota);
    }

    private static int[] estrazione(Random casuale, int[] vet)
    {
        boolean[] check = new boolean[90]; //creazione vettore di controllo, inizializza a FALSE

        for(int i=0; i<vet.length;i++)
        {
            do {
                vet[i]=casuale.nextInt(0,90)+1;
            }while(check[vet[i]-1]==true);
            check[vet[i]-1]=true;
        }

        return vet;
    }

    private static void printNumeri(int[] vet)
    {
        for(int i=0;i<vet.length;i++)
        {
            System.out.print(vet[i]+"\t");
        }
    }
}