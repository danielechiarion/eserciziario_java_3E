//Author: Daniele Chiarion
//Date: 09-02-2024

/* Realizzare un programma che, utilizzando la strategia del vettore dei booleani, permetta,
data una stringa di valori alfabetici,
di stampare caratteri presenti e non presenti nella stringa.

Ricostruire poi la stringa iniziale*/

import java.util.Scanner;

public class Chiarion_3E_Es16C_stringaRicostruzione {
    public static void main(String[] args) {
        /* dichiarazione vettore booleano */
        boolean[] alfabeto=new boolean[26];
        /* dichiarazione variabili */
        String frase;
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* richiesta inserimento dati input */
        System.out.println("Inserisci una stringa ");
        frase = keyboard.next().toUpperCase(); //risolvo il problema della differenza di lettere maiuscole o minuscole
        /* dichiarazione vettore */
        int[] codice = new int[frase.length()]; //il vettore deve avere la stessa dimensione della stringa

        /* verifica lettere presenti */
        for(int i=0;i<frase.length();i++)
        {
            codice[i]=asciiNum(frase.charAt(i)); //ad ogni posizione del vettore viene assegnato un numero corrispondente alla posizione in ordine alfabetico del carattere
            alfabeto[asciiNum(frase.charAt(i))]=true; //il vettore di booleani servirà per stampare caratteri validi e non validi
        }

        /* restituzione output */
        System.out.println("\nCARATTERI PRESENTI");
        printChar(alfabeto,true);
        System.out.println("\nCARATTERI MANCANTI");
        printChar(alfabeto, false);

        /* ricostruzione frase */
        System.out.println("\nStringa ricostruita");
        ricostruzione(codice);
    }

    private static int asciiNum(char x)
    {
        int ascii = (int)x -65;
        return ascii;
    }

    private static char asciiLet(int x)
    {
        char ascii = (char)(x+65);
        return ascii;
    }

    private static void printChar(boolean[] vet, boolean condition)
    {
        for(int i=0;i<vet.length;i++)
        {
            if(vet[i]==condition)
            {
                System.out.print(asciiLet(i)+"\t");
            }
        }
    }

    private static void ricostruzione(int[] vet)
    {
        for(int i=0;i<vet.length;i++)
        {
            System.out.print(asciiLet(vet[i]));
        }
    }
}
