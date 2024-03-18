//Author: Daniele Chiarion
//Date: 18-03-2023

/* scrivi un programma che
* prendendo in input due date,
* ne calcoli la distanza in giorni */

import java.util.Scanner;

public class Chiarion_3E_Es21F_distanzaDate {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); //creazione scanner
        /* dichiarazione variabili */
        int diffData;
        /* dichiarazione vettore */
        int[] data1;
        int[] data2;

        /* input date */
        data1=inputData(keyboard);
        data2=inputData(keyboard);

        /* calcolo differenza giorni */
        diffData=diffGiorni(data1, data2);

        /* output risultati */
        System.out.println("La differenza dei giorni e' "+diffData);
    }

    /* metodo per calcolare i giorni di differenza */
    private static int diffGiorni(int[] data1, int[] data2)
    {
        /* dichiarazione variabili */
        int giorniDiff=0;
        int anni=0, mesi=0, giorni=0;

        /* dichiarazione vettore */
        int[] dataMin;
        int[] dataMag;

        /* controllo quale data è maggiore e quale è minore */
        if(data1[2]>data2[2]){
            dataMag=data1;
            dataMin=data2;
        }
        else if(data2[2]>data1[2])
        {
            dataMin=data1;
            dataMag=data2;
        }
        /* se gli anni sono uguali controllo i mesi */
        else
        {
            if(data1[1]>data2[1])
            {
                dataMin=data2;
                dataMag=data1;
            }
            else if(data2[1]>data1[1])
            {
                dataMag=data2;
                dataMin=data1;
            }
            /* se non i mesi sono uguali controllo i giorni  */
            else
            {
                if(data1[0]>data2[0])
                {
                    dataMin=data2;
                    dataMag=data1;
                }
                else
                {
                    dataMag=data2;
                    dataMin=data1;
                }
            }
        }

        /* aggiungo giorni anni bisestili */
        for(int i=dataMin[2];i<dataMag[2] && dataMin[1]<=2;i++)
            giorniDiff++;
        /* controllo la distanza tra l'una e l'altra data */
        anni = dataMag[2]-dataMin[2];
        /* se non abbiamo un anno di differenza esatto  */
        if(dataMag[1]<dataMin[1])
        {
            mesi = 12+(dataMag[1]-dataMin[1]); //calcolo i mesi
            anni--; //diminuisco il numero di anni
        }
        else
            mesi=dataMag[1]-dataMin[1]; //calcolo normalmente

        if(dataMag[0]<dataMin[0])
        {
            giorni = giorniperMese(dataMag[1], 0)+(dataMag[0]-dataMin[0]); //conto quanti giorni di differenza ci sono
            mesi--; //decremento il numero di mesi
        }
        else
            giorni=dataMag[0]-dataMin[0];

        /* calcolo distanza in anni */
        for(int i=dataMin[1];i<dataMin[1]+anni;i++)
        {
            if(controlloBisestile(i))
                giorniDiff+=366;
            else
                giorniDiff+=365;
        }

        /* assegnazione valore del mese */
        if(data1[1]>data2[1])
        {
            dataMin=data2;
            dataMag=data1;        }
        else
        {
            dataMin=data1;
            dataMag=data2;
        }

        /* calcolo distanza in mesi */
        for(int i=dataMin[1]; i<dataMin[1]+mesi;i++)
        {
            giorniDiff+=giorniperMese(i, 0);
        }

        /* calcolo giorni */
        giorniDiff+=giorni;

        return giorniDiff;
    }

    /* metodo per l'input della data */
    private static int[] inputData(Scanner keyboard)
    {
        /* dichiarazione variabili */
        int inputData=0;
        boolean check;
        /* creazione vettore */
        int[] dataDivisa;

        /* input data utente */
        do {
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
            {
                messaggioErrore(3); //errore di data non valida
                check=true;
            }
        }while(check);

        return dataDivisa; //ritorno il valore
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
                if(anno==0 || !controlloBisestile(anno))
                    giorniMese=28;
                else
                    giorniMese=29;
                break;
            default:
                giorniMese=-1;
        }

        return giorniMese; //ritorno variabile
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
}
