import java.util.Random;
import java.util.Scanner;

public class Chiarion_3E_Es14F_menuDado {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        int scelta;
        int[] vet = new int[2];

        /* creazione vettore */
        Scanner keyboard = new Scanner(System.in);

        do {
            ClrScr();
            /* menu di scelta */
            System.out.println("=== APP lancio dadi ===");
            System.out.println("[1] 2 giocatori");
            System.out.println("[2] vs computer");
            System.out.println("[3] Fine");
            scelta = keyboard.nextInt();

            /* istruzioni differenziate */
            switch(scelta)
            {
                case 1:
                    vet = dueGiocatori();
                    ClrScr();
                    System.out.println("Giocatore 1:");
                    printFacce(vet[0]);
                    ClrScr();
                    System.out.println("Giocatore 2:");
                    printFacce(vet[1]);
                    ClrScr();
                    System.out.println("Dado giocatore 1: "+vet[0]);
                    System.out.println("Dado giocatore 2: "+vet[1]);
                    System.out.println("\n"+confronto(vet, 1));
                    break;
                case 2:
                    vet = dueGiocatori();
                    ClrScr();
                    System.out.println("Giocatore 1:");
                    printFacce(vet[0]);
                    ClrScr();
                    System.out.println("Dado giocatore 1: "+vet[0]);
                    System.out.println("Dado computer: "+vet[1]);
                    System.out.println("\n"+confronto(vet, 2));
                    break;
                case 3:
                    System.out.println("Fine programma");
                    break;
                default:
                    System.out.println("Valore inserito errato");
            }
        }while(scelta!=3); //ripete le operazioni fin quando non si digita 3
    }

    /* metodo che simula il confronto tra due giocatori */
    private static int[] dueGiocatori()
    {
        int[] vet=new int[2];

        vet[0]=valCasuale(0,6);
        vet[1]=valCasuale(0,6);

        return vet;
    }

    private static String confronto(int[] vet, int caso)
    {
        String vincitore="";
        if(vet[0]>vet[1])
            vincitore="Vince giocatore 1";
        else if(vet[1]>vet[0]){
            switch(caso)
            {
                case 1:
                    vincitore="Vince giocatore 2";
                    break;
                case 2:
                    vincitore="Parità";
                    break;
            }
        }
        else
            vincitore="Parità";

        return vincitore;
    }

    private static void printFacce(int num)
    {
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

    private static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int valCasuale(int min, int max)
    {
        /* creazione oggetto random */
        Random casuale = new Random(); //costruttore - senza parametri

        return casuale.nextInt(min,max)+1;
    }
}
