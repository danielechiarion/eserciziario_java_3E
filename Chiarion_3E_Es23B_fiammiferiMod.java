import java.util.Scanner;
import java.util.Random;

public class Chiarion_3E_Es23B_fiammiferiMod {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        String nome1, nome2;
        int fiammGiocati=0;
        int fiammiferi=21;
        int cont=0;
        int scelta;
        int giocataPrecedente=0;
        /* creazione vettore opzioni */
        String opzioni[] = {"MODALITA' DI GIOCO",
                "[1] 2 giocatori",
                "[2] Giocatore vs Computer",
                "[3] Computer vince sempre",
                "[4] quit"};
        /* creazione Scanner */
        Scanner keyboard = new Scanner(System.in);
        /* creazione generatore Random */
        Random casuale = new Random();

        /* ripetizione casi possibili */
        do {
            /* differenzio la strategia attraverso un menu */
            scelta=menu(opzioni, keyboard);
            switch(scelta){
                case 1,2:
                    /* input nomi */
                    nome1=inputNome(1, keyboard);
                    if(scelta==1)
                        nome2=inputNome(2, keyboard);
                    else
                        nome2="Questo PC";
                    /* ripetizione ciclo */
                    while(fiammiferi>1){
                        /* output fiammiferi */
                        ClrScr();
                        printFiammiferi(fiammiferi);

                        if(cont%2==0) //tocca al primo giocatore
                            fiammGiocati=inputNum(nome1, keyboard, fiammiferi);
                        else if(cont%2!=0 && scelta==1) //tocca al secondo giocatore
                            fiammGiocati=inputNum(nome2, keyboard, fiammiferi);
                        else //tocca al computer
                        {
                            fiammGiocati= casuale.nextInt(1,4);
                            System.out.println("\nIl computer ha tolto "+fiammGiocati+" fiammiferi");
                            Wait(4);
                        }

                        /* aggiorno variabili */
                        fiammiferi-=fiammGiocati;
                        cont++;
                    }

                    if(cont%2==0)
                        System.out.println("Ha vinto "+nome2);
                    else
                        System.out.println("Ha vinto "+nome1);
                    break;
                case 3:
                    /* input nome utente */
                    nome1=inputNome(1, keyboard); //ne prendo solo uno di nome

                    /* ripeto le azioni con un ciclo */
                    while(fiammiferi>1){
                        /* output fiammiferi */
                        ClrScr();
                        printFiammiferi(fiammiferi);

                        if(cont%2==0) //tocca al computer
                        {
                            if(cont==0) //se è la prima volta, ne toglie 3
                                fiammGiocati=3;
                            else //altrimenti, trova il valore della giocata precedente per arrivare a 4
                                fiammGiocati=4-giocataPrecedente;

                            /* output risultati */
                            System.out.println("\nIl COMPUTER ha tolto "+fiammGiocati+" fiammiferi");
                            Wait(4);
                        }
                        else
                        {
                            fiammGiocati=inputNum(nome1, keyboard, fiammiferi);
                            giocataPrecedente=fiammGiocati; //memorizzo i fiammiferi giocati
                        }

                        /* aggiorno variabili */
                        fiammiferi-=fiammGiocati;
                        cont++;
                    }

                    System.out.println("\nMi dispiace, ma il computer vince sempre");
                    Wait(3);
                    break;
                default:
                    System.out.println("Arresto del programma");
            }
        }while(scelta!= opzioni.length);
    }
    /* metodo per inserire il numero di fiammiferi,
     * include controllo try catch */
    private static int inputNum(String nome, Scanner keyboard, int fiammRimasti)
    {
        /* dichiarazione variabili */
        int input=0; //numero da inserire
        boolean check; //possibile ripetizione dati
        /* dichiarazione costanti */
        int maxFiammiferi;
        if(fiammRimasti>=3) //se il numero di fiammiferi rimasti e' pari o superiore a 3
            maxFiammiferi=3; //il numero massimo di fiammiferi rimane 3
        else
            maxFiammiferi=2; //altrimenti diventa 2

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
