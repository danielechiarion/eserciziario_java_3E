//Author: Daniele Chiarion
//Date: 29-01-2024

/* Realizzare un programma che, utilizzando la strategia del vettore dei booleani, permetta,
data una stringa di valori alfabetici,
di stampare caratteri presenti e non presenti nella stringa. */

import java.util.Scanner;

public class Chiarion_3E_Es16A_stringaChar {
    public static void main(String[] args) {
        /* creazione vettore */
        boolean[] alfabeto = new boolean[26];
        /* dichiarazione variabili */
        String frase;
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* richiesta inserimento dati input */
        System.out.println("Inserisci una stringa ");
        frase = keyboard.next().toUpperCase(); //risolvo il problema della differenza di lettere maiuscole o minuscole

        /* verifica lettere presenti */
        for(int i=0;i<frase.length();i++)
        {
            alfabeto[asciiNum(frase.charAt(i))]=true;
        }

        /* restituzione output */
        System.out.println("\nCARATTERI PRESENTI");
        printChar(alfabeto, true);
        System.out.println("\nCARATTERI MANCANTI");
        printChar(alfabeto, false);
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

    private static void printChar(boolean[] vet, boolean x)
    {
        for(int i=0;i<vet.length;i++)
        {
            if(vet[i]==x)
            {
                System.out.print(asciiLet(i)+"\t");
            }
        }
    }
}
