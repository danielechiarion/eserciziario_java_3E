//Author: Daniele Chiarion
//Date: 28-02-2024

/* Dato un valore numerico intero che
rappresenta la data odierna nel formato
ggmmaaaa determinare i valori che
rappresentano il giorno,mese anno. */

import java.util.Scanner;

public class Chiarion_3E_Es21A_dataSemplice {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int inputData;
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);
        /* creazione vettore */
        int[] dataDivisa;

        /* input data utente */
        do {
            System.out.println("Inserisci la data");
            System.out.println("(Per il mese, se prima di ottobre, occorre mettere uno 0)"); //indicazioni
            inputData = keyboard.nextInt();
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
    private static boolean controlloDataInt(int data)
    {
        /* dichiarazione costante */
        final int maxlength = 8;
        final int minlength=7;
        /* dichiarazione variabili */
        boolean result;
        int cont=0;

        /* conto quanti numeri sono presenti */
        while(data!=0)
        {
            cont++;//incremento variabile
            data=data/10;
        }

        if(cont>=minlength && cont<=maxlength) //se il numero di cifre corrisponde, si va avanti
            result=true;
        else //altrimenti darà risultato falso
            result=false;

        return result; //ritorno valore
    }

    /* metodo per dividere la data
    * in giorno, mese, anno */
    private static int[] dividiData(int inputData)
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
            diviso[i]=inputData%potenza(10, step[i]); //assegno al valore il resto della divisione
            inputData=inputData/potenza(10, step[i]); //divido il valore per passare alla nuova operazione
        }

        return diviso; //ritorno vettore
    }

    /* metodo per l'output del risultato */
    private static void printData(int[] vet)
    {
        System.out.println("\nDIVISIONE DELLA DATA:");
        System.out.println("Giorno: "+vet[0]);
        System.out.println("Mese: "+vet[1]);
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
