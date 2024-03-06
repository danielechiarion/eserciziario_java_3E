//Author: Daniele Chiarion
//Date: 06-03-2024

/* scrivi un programma come l'es 21A,
* convertendo la data divisa da intero a stringa */

import java.util.Scanner;

public class Chiarion_3E_Es21D_dataStringa {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int inputData=0;
        boolean check=false;
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);
        /* creazione vettore */
        int[] dataDivisa;
        String dataStringa;

        /* input data utente */
        do {
            System.out.println("Inserisci la data");
            System.out.println("(Per il mese, se prima di ottobre, occorre mettere uno 0)"); //indicazioni
            try{
                inputData=keyboard.nextInt();
            }catch(Exception x)
            {
                messaggioErrore(1);
                check=true;
            }
        }while(check); //se la data non ha la giusta lunghezza

        /* divisione data */
        dataDivisa=dividiData(inputData);
        /* output risultati */
        printData(dataDivisa);
        System.out.println("Metodo conversione 1: "+convertiStringa1(dataDivisa));
        System.out.println("Metodo conversione 2: "+convertiStringa2(dataDivisa));
        System.out.println("Metodo conversione 3: "+convertiStringa3(dataDivisa));
    }

    /* controllo correttezza data
     * (deve essere lungo otto numeri)
     * restituisce un valore booleano */

    /* diversi tipi di errore:
    * 1 - out of range
    * 2 - domani incorrect */
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

    private static int controlloDataString(String data)
    {
        /* dichiarazione costante */
        final int maxlength = 8;
        final int minlength=7;
        /* dichiarazione variabili */
        int result=-1;

        if(data.length()<minlength || data.length()>maxlength) //se il numero di cifre corrisponde, si va avanti
            result=1;
        /* scorro i caratteri fin quando non trovo
        * un carattere non numerico*/
        for(int i=0;i<data.length();i++)
        {
            if(data.charAt(i)<'0' && data.charAt(i)>'9')
            {
                result=2; //assegno secondo risultato
                break; //esco dal ciclo
            }
        }

        return result; //ritorno valore
    }

    /* metodo che indica il messaggio di errore */
    private static void messaggioErrore(int value)
    {
        /* switch case per i messaggi di errore */
        switch(value)
        {
            case 1:
                System.out.println("ERROR! Input out of range");
                break;
            case 2:
                System.out.println("ERROR! Wrong domain");
                break;
        }
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

    /* metodo per convertire la data in stringa
    * utilizzando la classe String */
    private static String convertiStringa1(int[] dataDivisa)
    {
        /* creazione variabile stringa */
        String dataStringa="";

        /* conversione data in stringa */
        for(int i=0;i<dataDivisa.length;i++)
        {
            dataStringa+=String.valueOf(dataDivisa[i])+"/";
        }

        return dataStringa;
    }

    /* metodo per convertire la data in stringa
     * utilizzando la classe Integer */
    private static String convertiStringa2(int[] dataDivisa)
    {
        /* creazione variabile stringa */
        String dataStringa="";

        /* conversione data in stringa */
        for(int i=0;i<dataDivisa.length;i++)
        {
            dataStringa+=Integer.toString(dataDivisa[i])+"/";
        }

        return dataStringa;
    }

    /* metodo per convertire la data in stringa
     * convertendo il dato in Integer */
    private static String convertiStringa3(int[] dataDivisa)
    {
        /* creazione variabile stringa */
        String dataStringa="";
        Integer boxing;

        /* conversione data in stringa */
        for(int i=0;i<dataDivisa.length;i++)
        {
            boxing = dataDivisa[i];
            dataStringa+=Integer.toString(boxing)+"/";
        }

        return dataStringa;
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
