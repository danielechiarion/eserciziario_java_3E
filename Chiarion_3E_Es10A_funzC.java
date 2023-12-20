//Author: Daniele Chiarion
//Date: 19-12-2023

/* scrivi un programma che
corrisponda all'insieme delle funzionalità
degli es 2-3-4
realizzati in C*/

/* importazione librerie */
import java.util.Scanner;

public class Chiarion_3E_Es10A_funzC {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta;

        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* Menu di scelta */
        System.out.println("Benvenuto! Scegli tra le seguenti funzionalita': ");
        System.out.println("Digita 1 - Sconto prezzi");
        System.out.println("Digita 2 - Conteggio, somma e media di numeri positivi e negativi");
        System.out.println("Digita 3 - Somma di numeri primi alterni");

        /* input di controllo */
        do {
            scelta=keyboard.nextInt();
            if(scelta<1 || scelta>3)
                System.out.println("Valore inserito errato. Riprova");
        }while(scelta<1 || scelta>3);

        /* differenziazione operazioni */
        if(scelta==1)
            sconto();
        else if(scelta==2)
            posNeg();
        else
            numPrimi();
    }

    private static void sconto()
    {
        /* dichiarazione e inizializzazione di variabili */
        int prezzo;
        int ripetere;
        double sconto;
        double prezzo_scontato;

        /* dichiarazione e inizializzazione costanti */
        final int SCONTO1=10, SCONTO2=20, SCONTO3=30;

        /* creazione scanner */
        Scanner keyboard=new Scanner(System.in);

        do
        {
            /* inserimento dati input */
            do
            {
                System.out.println("Inserisci un prezzo da pagare: ");
                prezzo=keyboard.nextInt();
            } while (prezzo <= 0);

            /* calcolo dati */
            if (prezzo <= 500)
            {
                System.out.println("\nLo sconto applicato e' del "+SCONTO1+"%");
                prezzo_scontato = (double)(prezzo - prezzo * SCONTO1 / 100);
            }

            else if (prezzo > 500 && prezzo <= 1000)
            {
                System.out.println("\nLo sconto applicato e' del "+SCONTO2+"%");
                prezzo_scontato = (double)(prezzo - prezzo * SCONTO2 / 100);
            }

            else
            {
                System.out.println("\n Lo sconto applicato e' del "+SCONTO3+"%");
                prezzo_scontato = (double)(prezzo - prezzo * SCONTO3 / 100);
            }

            System.out.printf("\nIl prezzo scontato e' %.2f", prezzo_scontato);

            /* richiesta ripetizione */
            do
            {
                System.out.println("\nDesidera ripetere?\nInserire 1 per ripetere\n0 per annullare");
                ripetere = keyboard.nextInt();
            } while (ripetere != 0 && ripetere != 1);

        } while (ripetere == 1);
    }

    private static void posNeg()
    {
        /* dichiarazione e inizializzazione variabili */
        int dim, i;
        int num;
        int contPos=0, contNeg=0;
        int sommaPos=0, sommaNeg=0;
        double mediaPos=0, mediaNeg=0;

        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* richiesta numero valori */
        do
        {
            System.out.println("Quanti numeri vuoi inserire? ");
            dim = keyboard.nextInt();
        } while (dim<=0);

        /* richiesta inserimento valori */
        System.out.print("\n\n");
        for(i=0;i<dim;i++)
        {
            System.out.println("Inserisci un valore: ");
            num = keyboard.nextInt();

            if(num<0)
            {
                contNeg++;
                sommaNeg=sommaNeg-num;
            }

            else
            {
                contPos++;
                sommaPos=sommaPos+num;
            }
        }

        /* calcolo media */
        mediaPos=(double) sommaPos/contPos;
        mediaNeg=(double) sommaNeg/contNeg;

        /* output di sistema */
        System.out.print("\nNUMERI POSITIVI: ");
        System.out.println("Numero = "+ contPos);
        System.out.println("Somma = "+ sommaPos);
        System.out.printf("Media = %.2f", mediaPos);
        System.out.println("\nNUMERI NEGATIVI: ");
        System.out.println("Numero = "+ contNeg);
        System.out.println("Somma (valore assoluto) = "+sommaNeg);
        System.out.printf("Media = %.2f", mediaNeg);
    }

    private static void numPrimi()
    {
        /* dichiarazione e inizializzazione variabili */
        int num;
        int i=0,j,k;
        int contDiv=0;
        int somma=0;

        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        /* richiesta inserimento dati input */
        do {
            System.out.println("Inserisci un numero positivo: ");
            num = keyboard.nextInt();
        }while(num<0);

        /* ricerca numeri primi */
        k=num;
        while(i<num*2) //verranno trovati il doppio dei numeri primi, visto che gli vogliamo alterni
        {
            /* nel primo step si vede per ogni numero
            quante volte è divisibile per i precedenti */
            for(j=k;j>0;j--)
            {
                if(k%j==0)
                    contDiv++;
            }

            if(contDiv==2) // se è divisibile per 2 allora è un numero primo
            {
                i++;

                if(i%2!=0) // considera solo i numeri primi alterni (in questo caso quando il contatore è dispari)
                {
                    somma=somma+k;
                    System.out.println("Il "+i+"^ numero primo e' "+k);
                }
            }

            /* incremento e azzeramento variabili opportune */
            contDiv=0;
            k++;
        }

        /* output finale */
        System.out.println("\nLa somma finale dei "+num+" numeri alterni maggiori di "+num+" e' "+somma);
    }
}
