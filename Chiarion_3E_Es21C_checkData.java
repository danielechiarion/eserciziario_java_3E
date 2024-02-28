//Author: Daniele Chiarion
//Date: 28-02-2024

/* Modificare l’esercizio precedente in modo
che il mese venga scritto in formato
stringa. */

import java.util.Scanner;

public class Chiarion_3E_Es21C_checkData {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int inputData;
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);

        do {
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

            if(!controlloValiditaData(dividiData(inputData)))
                System.out.println("La data inserita e' sbagliata"); //messaggio di errore
            else
                printData(dividiData(inputData)); //output risultati
        }while(ripetiProgramma(keyboard)); //ripetizione programma
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

    /* metodo per controllare se l'anno e' bisestile */
    private static boolean controlloBisestile(int anno)
    {
        /* dichiarazione variabili */
        boolean result;

        /* per essere booleano il numero deve essere divisibile per 4 E,
        * se multiplo di 100, deve essere divisibile anche per 400 */
        if((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0)
            result=true;
        else
            result=false;

        return result; //ritorno risultato
    }

    /* controllo della validità della data
    * in base al giorno e al mese inserito */
    private static boolean controlloValiditaData(int[] vet)
    {
        /* dichiarazione variabili */
        int giorniMese;
        boolean result;

        /* switch case con tutte le possibili scelte */
        switch(vet[1])
        {
            case 1,3,5,7,8,10,12:
                giorniMese=31;
                break;
            case 4,6,9,11:
                giorniMese=30;
                break;
            case 2:
                if(controlloBisestile(vet[2])) //controllo se l'anno e' bisestile
                    giorniMese=29;
                else
                    giorniMese=28;
                break;
            default:
                    giorniMese=-1;
        }

        /* restituzione booleano */
        if(vet[0]<=giorniMese) //se il giorno del mese e minore o uguale al massimo
            result=true;
        else
            result=false;

        return result;
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
        System.out.println("Mese: "+matchMese(vet[1]));
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

    /* metodo per la ripetizione del programma */
    private static boolean ripetiProgramma(Scanner keyboard)
    {
        /* dichiarazione variabili */
        char scelta;
        boolean result;
        /* messaggio */
        System.out.println("\nDesideri ripetere il programma?\nDigita S per confermare\nQualsiasi altro tasto per annullare");
        scelta=keyboard.next().charAt(0);

        /* assegnazione valore booleano */
        if(scelta=='S' || scelta=='s')
            result=true;
        else
            result=false;

        ClrScr();

        return result; //ritorno valore booleano
    }

    /* metodo per corrispondere ad un valore numerico
    * la stringa corrispondente */
    private static String matchMese(int val)
    {
        /* dichiarazione variabile */
        String mese=switch (val) //switch case con le varie opzioni
        {
            case 1 -> "gennaio";
            case 2 -> "febbraio";
            case 3 -> "marzo";
            case 4 -> "aprile";
            case 5 -> "maggio";
            case 6 -> "giugno";
            case 7 -> "luglio";
            case 8 -> "agosto";
            case 9 -> "settembre";
            case 10 -> "ottobre";
            case 11 -> "novembre";
            case 12 -> "dicembre";
            default -> "sbagliato"; //nel caso in cui la cifra sia un'altra
        };

        return mese; //valore di ritorno
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
