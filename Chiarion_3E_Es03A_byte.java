//Author: Daniele Chiarion
//Date: 04-12-2023

/* in base ad una sequenza di numeri inserita
determinare se si tratta di un byte */

import java.util.Scanner;

public class Chiarion_3E_Es03A_byte {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabile */
        String numero;
        int i;
        int cifre=0;
        boolean flagByte=true;

        /* creazione scanner */
        Scanner keyboard=new Scanner(System.in);

        /* richiesta inserimento valore */
        System.out.println("Inserisci un numero: ");
        numero=keyboard.next();

        /* calcolo frequenza cifre, 0 e 1 */
        cifre=numero.length(); //ritorna la dimensione della stringa
        for(i=0;i<cifre;i++)
        {
            if(numero.charAt(i)!='0' && numero.charAt(i)!='1')
                flagByte=false;
        }

        /* output */
        if(cifre==8 && flagByte == true)
            System.out.println("\nIl numero inserito e' un byte");
        else
            System.out.println("\nIl numero inserito non e' un byte");
    }
}