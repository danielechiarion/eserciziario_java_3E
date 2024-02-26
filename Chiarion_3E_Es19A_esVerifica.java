//Author: Daniele Chiarion
//Date: 26-02-2024

/* Scrivere un programma FirstOddAfterEven che chiede all’utente di inserire
una sequenza di interi (chiedendo prima quanti numeri voglia inserire) e
poi, al temine dell’inserimento, conta quanti numeri pari sono seguiti da
un numero dispari all’interno del vettore.
Bonus: utilizzare un metodo per contare i numeri. */

import java.util.Scanner;

public class Chiarion_3E_Es19A_esVerifica {
    public static void main(String[] args) {
        /* istanziazione Scanner */
        Scanner keyboard = new Scanner(System.in);
        /* dichiarazione variabili */
        int dimVet;

        /* richiesta inserimento
        * quanti numeri da inserire */
        do {
            System.out.println("Quanti numeri vuoi inserire? ");
            dimVet=keyboard.nextInt();
            /* messaggio di errore */
            if(dimVet<=0)
                System.out.println("Non puoi inserire una dimensione negativa o nulla");
        }while(dimVet<=0);
        /* creazione vettore */
        int[] vet = new int[dimVet];

        /* input dati */
        inputSequenza(vet, keyboard);

        /* output risultati */
        System.out.println("Ci sono "+pariDispariConsecutivi(vet)+" numeri pari seguiti da un numero dispari");
    }

    /* metodo per richiedere l'input dei dati */
    private static void inputSequenza(int[] vet, Scanner keyboard)
    {
        /* richiesta inserimento sequenza numeri */
        for(int i=0;i<vet.length;i++)
        {
            System.out.println("Inserisci il "+(i+1)+"^ numero: ");
            vet[i]=keyboard.nextInt();
        }
    }

    /* metodo per contare
    * quanti numeri pari sono seguiti da un numero dispari */
    private static int pariDispariConsecutivi(int[] vet)
    {
        /* dichiarazione contatore */
        int cont=0;

        /* controllo di tutti i valori */
        /* controlla tutti i valori meno l'ultimo,
        perchè viene già fatto nelle istruzioni seguenti */
        for(int i=0;i<vet.length-1;i++)
        {
            if(vet[i]%2==0 && vet[i+1]%2!=0) //se un numero è pari e il suo successivo e' dispari
                cont++;
        }

        return cont; //ritorno quanti pari sono seguiti da dispari
    }
}
