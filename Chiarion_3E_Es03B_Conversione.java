//Author: Daniele Chiarion
//Date: 04-12-2023

/* Completare l'esercizio visto in classe in modo da convertire il valore binario
"Stringa di caratteri" in un valore decimale. */

import java.util.Scanner;

public class Chiarion_3E_Es03B_Conversione {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        int i, pot=0;
        int cifra;
        double dec=0;
        boolean vBin=true;
        String numero;

        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* richiesta inserimento dati input */
        {
            System.out.println("Inserisci un numero binario: ");
            numero=keyboard.nextLine();

            for(i=0; i<numero.length(); i++)
            {
                if(numero.charAt(i)!='0' && numero.charAt(i)!='1')
                    vBin=false;
            }

            if(vBin==false)
                System.out.println("Non hai inserito un numero binario. Riprova");
        }while(vBin==false);

        /* calcolo numero decimale */
        for(i=numero.length()-1;i>=0;i--)
        {
            cifra=numero.charAt(i)-'0';
            dec=(double)(dec+cifra*Math.pow(2, pot));

            pot++;
        }

        /* restituzione dati output */
        System.out.println("\nIl numero "+numero+" in decimale corrisponde a "+dec);
    }
}
