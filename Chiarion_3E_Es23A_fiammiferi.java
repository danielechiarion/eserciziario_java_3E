//Author: Daniele Chiarion
//Date: 20-03-2024

/* realizza un programma che
* simuli il gioco dei fiammiferi */

import java.util.Scanner;
import java.util.Random;

public class Chiarion_3E_Es23A_fiammiferi {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        String nome1, nome2;
        int fiammGiocati;
        int fiammiferi=21;
        int cont=0;
        int scelta;
        /* creazione vettore opzioni */
        String opzioni[] = {"MODALITA' DI GIOCO", "[1] 2 giocatori", "[2] Giocatore vs Computer"};
        /* creazione Scanner */
        Scanner keyboard = new Scanner(System.in);
        /* creazione generatore Random */
        Random casuale = new Random();

        scelta = menu(opzioni, keyboard);

        /* input nomi giocatori */
        nome1= inputNome(1, keyboard);
        /* nome inserito diverso in base alla
        * scelta fatta */
        if(scelta==1)
            nome2 = inputNome(2, keyboard); //2 giocatori
        else
            nome2 = "Questo PC"; //vs computer

        /* ciclo per ripetere la sottrazione di fiammiferi
        * fin quando non si arriva a 1 */
        while(fiammiferi>1)
        {
            ClrScr();
            printFiammiferi(fiammiferi);
            /* differenzio l'input in base al giocatore
            * (vado a cambiarne il nome) */
            if(cont%2==0)
                fiammGiocati=inputNum(nome1, keyboard);
            else if(scelta==1) //se è tra due giocatori e tocca al secondo
                fiammGiocati=inputNum(nome2, keyboard); //si chiede a sua volta di inserire il numero
            else //se lo scontro è con il computer
                fiammGiocati=casuale.nextInt(1,4); //il computer estrae casualmente

            fiammiferi-=fiammGiocati; //sottrazione ai fiammiferi quelli inseriti da togliere
            cont++; //incremento il contatore
        }

        /* output vincita */
        ClrScr();
        /* se il contatore si è fermato sul primo giocatore,
        * vuol dire che ha vinto il primo */
        if(cont%2!=0 && fiammiferi==1)
            System.out.println("Ha vinto "+nome2);
        /* altrimenti vuol dire che ha vinto
        * il secondo giocatore */
        else if(fiammiferi==1)
            System.out.println("Ha vinto "+nome1);
        /* se il numero dei fiammiferi non è 1,
        * nessuno dei due ha vinto */
        else
            System.out.println("Non ha vinto nessuno dei due");
    }

    /* metodo per inserire il numero di fiammiferi,
    * include controllo try catch */
    private static int inputNum(String nome, Scanner keyboard)
    {
        /* dichiarazione variabili */
        int input=0; //numero da inserire
        boolean check; //possibile ripetizione dati
        /* dichiarazione costanti */
        final int maxFiammiferi=3;

       do {
           check=false; //reinizializzo ogni volta che entro nel ciclo, altrimenti darà sempre errore
           do {
               System.out.println("\nE' il turno di: "+ nome);
               System.out.println("Inserisci un numero (da 1 a 3)");
               /* controllo validità dominio */
               try {
                   input=keyboard.nextInt();
               }catch(Exception e)
               {
                   check=true;
                   messaggioErrore(2);
                   Wait(3);
                   ClrScr();
                   keyboard.nextLine();
               }
           }while(check); //prima ripetizione per valore non appartenente al dominio
           if(input<=0 || input>maxFiammiferi)
           {
               check=true;
               messaggioErrore(1);
               Wait(3);
               ClrScr();
           }
       }while(check); //seconda ripetizione per valore al di fuori dell'intervallo

        return input;
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

    /* metodo per richidere in input il nome
    NUM serve per l'ordinale */
    private static String inputNome(int num, Scanner keyboard)
    {
        System.out.println("Inserisci il "+num+"^ nome");
        return keyboard.next();
    }

    /* metodo per stampare quanti fiammiferi vengono inseriti
    * nella firma */
    private static void printFiammiferi(int num)
    {
        /* creo un ciclo dove stampare più fiammiferi */
        for(int i=0;i<num;i++)
            System.out.print("\t*");
        System.out.println("\n");
        for(int i=0;i<num;i++)
            System.out.print("\t|");
        System.out.print("\n");
        for(int i=0;i<num;i++)
            System.out.print("\t|");
        System.out.print("\n");
        for(int i=0;i<num;i++)
            System.out.print("\t|");
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

    private static int menu(String[] opzioni, Scanner keyboard)
    {
        int scelta=0;

        do {
            ClrScr();
            System.out.println("=== "+opzioni[0]+" ===");
            for(int i=1;i<opzioni.length;i++)
            {
                System.out.println(opzioni[i]);
            }
            try{
                scelta = keyboard.nextInt();
            }catch(Exception e){
                Wait(3);
                keyboard.nextLine();
            }
            if(scelta<1 || scelta>opzioni.length-1) //se un valore diverso e' stato letto
            {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        }while(scelta<1 || scelta>opzioni.length-1);

        return scelta;
    }
}
