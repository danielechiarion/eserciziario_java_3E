import java.util.Scanner;
import java.util.Random;

public class Chiarion_3E_Es14G_menuDado{
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta;
        int[] vet = new int[2];
        String[] nomi = new String[2];

        /* creazione vettore stringa e lo scanner */
        String[] opzioni={"Gara lancio dadi","[1] Sfida tra due giocatori", "[2] Sfida contro computer", "[3] fine"};
        Scanner keyboard = new Scanner(System.in);
        do {
            /* visualizzazione delle scelte attraverso il metodo menu */
            ClrScr();
            scelta=menu(opzioni, keyboard);
            Wait(5);
            ClrScr();
            /* opzioni differenziate in base alla scelta */
            switch(scelta)
            {
                case 1:
                    /* richiesta inserimento nomi giocatori */
                    System.out.println("Inserisci il nome del primo giocatore: ");
                    nomi[0]=keyboard.next();
                    System.out.println("Inserisci il nome del secondo giocatore: ");
                    nomi[1]=keyboard.next();
                    ClrScr();
                    /* estrazione numeri */
                    vet=estrazione();
                    /* output grafico */
                    printFacce(vet[0], nomi[0]);
                    printFacce(vet[1], nomi[1]);
                    /* output esito */
                    confronto(vet, nomi);
                    Wait(5);
                    break;
                case 2:
                    /* assegnazione nomi giocatore */
                    System.out.println("Inserisci il nome del giocatore: ");
                    nomi[0]=keyboard.next();
                    nomi[1]="computer";
                    ClrScr();
                    /* estrazione numeri */
                    vet=estrazione();
                    /* output grafico */
                    printFacce(vet[0], nomi[0]);
                    /* output risultati */
                    confronto(vet, nomi);
                    Wait(5);
                    break;
                case 3:
                    /* messaggio di fine programma */
                    System.out.println("Fine programma");
                    break;
            }
        }while(scelta!=3);
    }

    /* metodo per la visualizzazione del menu
    e della scelta */
    private static int menu(String[] opzioni, Scanner keyboard)
    {
        int scelta;

        do {
            ClrScr();
            System.out.println("=== "+opzioni[0]+" ===");
            for(int i=1;i<opzioni.length;i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = keyboard.nextInt();
            if(scelta<1 || scelta>opzioni.length-1)
            {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        }while(scelta<1 || scelta>opzioni.length-1);

        return scelta;
    }

    /* metodo per l'output del risultato
    in base ai dadi lanciati */
    private static void confronto(int[] vet, String[] nome)
    {
        System.out.println(nome[0]+": "+vet[0]);
        System.out.println(nome[1]+": "+vet[1]);
        if(vet[0]>vet[1])
            System.out.println("Vince "+nome[0]);
        else if(vet[1]>vet[0])
            System.out.println("Vince "+nome[1]);
        else
            System.out.println("Parità");
    }

    /* metodo che genera l'estrazione di due numeri casuali */
    private static int[] estrazione()
    {
        int[] vet = new int[2];
        Random casuale = new Random();

        vet[0]=casuale.nextInt(0,6)+1;
        vet[1]=casuale.nextInt(0,6)+1;

        return vet;
    }

    /* metodo per pulire lo schermo nel CMD */
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* metodo per l'attesa */
    private static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /* metodo per l'output dei dadi in sequenza
    a scopo grafico */
    private static void printFacce(int num, String nome)
    {
        System.out.println(nome+":");
        for(int i=0;i<6;i++)
        {
            FacceDado(i+1);
            Wait(1);
            ClrScr();
        }
        System.out.println("Dado lanciato: ");
        FacceDado(num);
        Wait(5);
        ClrScr();
    }

    /* metodo per l'output dell'immagine del dado
    differente in base al valore inserito */
    private static void FacceDado(int faccia)
    {
        switch(faccia)
        {
            //ALT + 201 ╔
            //ALT + 188 ╝
            //ALT + 187 ╗
            //ALT + 200 ╚
            //ALT + 205 ═
            //ALT + 186 ║
            case 1:
                System.out.println("\t\t\t\t╔═════════╗");
                System.out.println("\t\t\t\t║         ║");
                System.out.println("\t\t\t\t║    0    ║");
                System.out.println("\t\t\t\t║         ║");
                System.out.println("\t\t\t\t╚═════════╝");
                break;
            case 2:
                System.out.println("\t\t\t\t╔═════════╗");
                System.out.println("\t\t\t\t║ 0       ║");
                System.out.println("\t\t\t\t║         ║");
                System.out.println("\t\t\t\t║       0 ║");
                System.out.println("\t\t\t\t╚═════════╝");
                break;
            case 3:
                System.out.println("\t\t\t\t╔═════════╗");
                System.out.println("\t\t\t\t║       0 ║");
                System.out.println("\t\t\t\t║    0    ║");
                System.out.println("\t\t\t\t║ 0       ║");
                System.out.println("\t\t\t\t╚═════════╝");
                break;
            case 4:
                System.out.println("\t\t\t\t╔═════════╗");
                System.out.println("\t\t\t\t║ 0     0 ║");
                System.out.println("\t\t\t\t║         ║");
                System.out.println("\t\t\t\t║ 0     0 ║");
                System.out.println("\t\t\t\t╚═════════╝");
                break;
            case 5:
                System.out.println("\t\t\t\t╔═════════╗");
                System.out.println("\t\t\t\t║ 0     0 ║");
                System.out.println("\t\t\t\t║    0    ║");
                System.out.println("\t\t\t\t║ 0     0 ║");
                System.out.println("\t\t\t\t╚═════════╝");
                break;
            case 6:
                System.out.println("\t\t\t\t╔═════════╗");
                System.out.println("\t\t\t\t║ 0     0 ║");
                System.out.println("\t\t\t\t║ 0     0 ║");
                System.out.println("\t\t\t\t║ 0     0 ║");
                System.out.println("\t\t\t\t╚═════════╝");
                break;
        }
    }
}
