//Author: Daniele Chiarion
//Date: 15-03-2024

/* Modificare l’esercizio precedente in modo
tale che l’utente tramite un menù possa aggiungere o togliere giorni alla data
precedentemente inserita.

Per la risoluzione dell’esercizio creare
due metodi:

 "data_up "e "data_down" che ricevuti in input il n° di giorni da
aggiungere o togliere ritornino
la nuova data. */

import java.util.Scanner;

public class Chiarion_3E_Es21E_dataUpDown {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int inputData=0;
        int aggiungiTogliGiorni=0;
        boolean check, check2;
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);
        /* creazione vettore */
        int[] dataDivisa;
        int[] dataModificata = new int[3];
        String dataStringa;

        /* input data utente */
        do {
            check=false; //inizializzo ogni volta la variabile
            do {
                check=false; //inizializzo ogni volta la variabile
                System.out.println("Inserisci la data");
                System.out.println("(Per il mese, se prima di ottobre, occorre mettere uno 0)"); //indicazioni
                try{
                    inputData=keyboard.nextInt();
                }catch(Exception x)
                {
                    check=true; //cambio variabile
                    /* messaggio di errore */
                    messaggioErrore(2);
                    keyboard.nextLine(); //questo comando dà la possibilità di inserire nuovamente il numero
                }
            }while(check); //se la data non è del formato intero

            /* controllo lunghezza data */
            if(!controlloDataInt(inputData)) //se la data non è della lunghezza giusta
            {
                check=true; //cambio valore alla variabile booleana
                /* messaggio di errore */
                messaggioErrore(1);
            }
        }while(check); //ripeto nuovamente dall'inizio se la lunghezza non è esatta

        /* separazione data */
        dataDivisa=dividiData(inputData);

        /* controllo validità della data,
        * ovvero controllo se la data effettivamente esiste da calendario */
        if(!controlloValiditaData(dataDivisa))
            messaggioErrore(3); //errore di data non valifa
        else
        {
            do {
                check2=false; //inizializzo ogni volta la variabile
                /* output primi risultati */
                printData(dataDivisa);
                /* richiesta inserimento giorni
                 * per modificare la data */
                System.out.println("\nInserisci quanti giorni vuoi aggiungere o togliere alla data. " +
                        "\n(per togliere giorni basta inserire un numero negativo.");
                try{
                    aggiungiTogliGiorni=keyboard.nextInt();
                }catch(Exception e){
                    check2=true;
                    messaggioErrore(1);
                    keyboard.nextLine();
                }
            }while(check2);

            /* calcolo giorni aggiunti o tolti dalla data di partenza */
            if(aggiungiTogliGiorni>0)
                dataModificata=data_up(dataDivisa, aggiungiTogliGiorni);
            else
                dataModificata=data_down(dataDivisa, aggiungiTogliGiorni);

            /* output risultati */
            System.out.println("\n\nLa data modificata e': ");
            printData(dataModificata);
        }
    }

    /* metodo per aggiungere giorni ad una data iniziale */
    private static int[] data_up(int[] data1, int aggiungiGiorni)
    {
        /* dichiarazione variabili */
        int anni=0, mesi=0, giorni=0; //saranno i valori che poi verranno aggiunti
        int divisoreAnni, divisoreMesi; //saranno i valori per i quali aggiungiorni verrà diviso

        /* dichiarazione vettore */
        int[] dataNuova= new int[data1.length];

        /* - DIVISORE ANNI: quanti giorni in un anno
        *  - DIVISORE MESI: quanti giorni in un mese */

        /* calcolo anni */
        do {
            /* assegnazione valori anno bisestile */
            if(controlloBisestile(data1[2]+anni))
                divisoreAnni=366;
            else
                divisoreAnni=365;

            /* controllo se il la differenza è maggiore di 0,
            * quindi incremento il numero di anni*/
            if(aggiungiGiorni-divisoreAnni>=0)
            {
                anni++; //aumento gli anni
                aggiungiGiorni = aggiungiGiorni-divisoreAnni; //tolgo i giorni calcolati
            }
        }while(aggiungiGiorni-divisoreAnni>0);

        /* calcolo mesi */
        do{
            /* assegnazione valori giorni per mese */
            divisoreMesi=giorniperMese(data1[1]+mesi, data1[2]+anni);

            /* controllo se la differenza è maggiore di 0,
            quindi incremento il numero di mesi */
            if(aggiungiGiorni-divisoreMesi>=0)
            {
                mesi++;
                aggiungiGiorni=aggiungiGiorni-divisoreMesi;
            }
        }while(aggiungiGiorni-divisoreMesi>0);

        giorni=aggiungiGiorni; //ovviamente i giorni sono l'ultima cosa rimasta dopo tutte le sottrazioni possibibili

        /* assegnazione giorni
        * (controllo se superano il mese in considerazione) */
        if(data1[0]+giorni>giorniperMese(data1[1], data1[2]+anni))
        {
            mesi++;
            if(data1[1]+mesi<=12)
                giorni = data1[0]+giorni-giorniperMese(data1[1], data1[2]+anni);
            else
                giorni = data1[0]+giorni-giorniperMese(data1[1], data1[2]+anni);
        }
        else
            giorni+=data1[0];

        /* assegnazione mesi
        * controllo se superano i 12 */
        if(data1[1]+mesi>12)
        {
            anni++;
            mesi = data1[1]+mesi-12;
        }
        else
            mesi+=data1[1];

        anni+= data1[2];
        /* popolamento nuovo vettore */
        dataNuova[0]=giorni;
        dataNuova[1]=mesi;
        dataNuova[2]=anni;
        return dataNuova; //ritorno della nuova data
    }

    /* metodo per togliere giorni da una data stabilita */
    private static int[] data_down(int[] dataDivisa, int togliGiorni)
    {
        /* dichiarazione variabili */
        int giorni=0, mesi=0,anni=0;
        int sottMesi, sottAnni; //indica di quanto sottrarre per ottenere un mese o un anno
        /* creazione vettore */
        int[] nuovaData = new int[dataDivisa.length];

        togliGiorni=-togliGiorni;

        /* trovo quanti anni sono necessari */
        /* calcolo anni */
        do {
            /* assegnazione valori anno bisestile */
            if(controlloBisestile(dataDivisa[2]+anni))
                sottAnni=366;
            else
                sottAnni=365;

            /* controllo se il la differenza è maggiore di 0,
             * quindi incremento il numero di anni*/
            if(togliGiorni-sottAnni>=0)
            {
                anni++; //aumento gli anni
                togliGiorni = togliGiorni-sottAnni; //tolgo i giorni calcolati
            }
        }while(togliGiorni-sottAnni>0);

        /* calcolo mesi */
        do{
            /* assegnazione valori giorni per mese */
            sottMesi=giorniperMese(dataDivisa[1]+mesi, dataDivisa[2]+anni);

            /* controllo se la differenza è maggiore di 0,
            quindi incremento il numero di mesi */
            if(togliGiorni-sottMesi>=0)
            {
                mesi++;
                togliGiorni=togliGiorni-sottMesi;
            }
        }while(togliGiorni-sottMesi>0);

        giorni = togliGiorni; //i giorni sono gli ultimi rimasti

        /* controllo se, sottraendo i giorni,
        si rimane nello stesso mese */
        if(dataDivisa[0]-giorni<=0)
        {
            mesi++; //incremento il contatore di mesi da sottrarre in seguito
            /* se non abbiamo una differenza negativa */
            if(dataDivisa[1]-mesi>0)
                giorni=giorniperMese(dataDivisa[1]-mesi, dataDivisa[2]-anni)-(giorni-dataDivisa[0]);
            else //altrimenti cambio il calcolo dei mesi per farlo risultare positivo
                giorni=giorniperMese(12+dataDivisa[1]-mesi, dataDivisa[2]-anni)-(giorni-dataDivisa[0]);
        }
        else
            giorni=dataDivisa[0]-giorni;
        if(dataDivisa[1]-mesi<=0)
        {
            anni++; //incremento il numero di anni da sottrarre
            mesi=12-(mesi-dataDivisa[1]);
        }
        else
            mesi=dataDivisa[1]-mesi;

        anni=dataDivisa[2]-anni; //gli anni sono quelli che rimangono

        /* assegnazione valori al vettore */
        nuovaData[0]=giorni;
        nuovaData[1]=mesi;
        nuovaData[2]=anni;

        return nuovaData; //ritorno il nuovo vettore
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

        /* assegnazione giorni al mese inserito,
        * controllando se l'anno è bisestile */
        giorniMese=giorniperMese(vet[1], vet[2]);

        /* restituzione booleano */
        if(vet[0]<=giorniMese) //se il giorno del mese e minore o uguale al massimo
            result=true;
        else
            result=false;

        return result;
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
            case 3:
                System.out.println("La data inserita non esiste");
                break;
            default:
                System.out.println("");
        }
        /* attesa e cancellazione risultato schermo */
        Wait(3);
        ClrScr();
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

    /* metodo che associa al valore inserito del mese
    * i corrispondenti giorni */
    private static int giorniperMese(int mese, int anno)
    {
        int giorniMese; //dichiarazione variabile

        /* switch case con tutte le possibili scelte */
        switch(mese)
        {
            case 1,3,5,7,8,10,12:
                giorniMese=31;
                break;
            case 4,6,9,11:
                giorniMese=30;
                break;
            case 2:
                if(controlloBisestile(anno)) //controllo se l'anno e' bisestile
                    giorniMese=29;
                else
                    giorniMese=28;
                break;
            default:
                giorniMese=-1;
        }

        return giorniMese; //ritorno variabile
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
}
