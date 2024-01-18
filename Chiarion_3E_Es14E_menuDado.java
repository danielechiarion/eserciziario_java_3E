import java.util.*; //importazione librerie

public class Chiarion_3E_Es14E_menuDado {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        int scelta;

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
                    dueGiocatori();
                    break;
                case 2:
                    vsComputer();
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
    private static void dueGiocatori()
    {
        /* dichiarazione e inizializzazione variabili */
        int num1=valCasuale(0,6),num2=valCasuale(0,6);

        /* output valori */
        System.out.println("Giocatore 1: ");
        printFacce(num1);
        System.out.println("Giocatore 2: ");
        printFacce(num2);

        /* output risultati */
        System.out.println("Giocatore 1: "+num1);
        System.out.println("Giocatore 2: "+num2);

        if(num1>num2)
            System.out.println("\nVince il giocatore 1");
        else if(num1<num2)
                System.out.println("\nVince il giocatore 2");
            else
                System.out.println("\nParità");
    }

    private static void vsComputer()
    {
        /* dichiarazione e inizializzazione variabili */
        int player=valCasuale(0,6),computer=valCasuale(0,6);

        /* output valore */
        System.out.println("Giocatore: ");
        printFacce(player);

        /* output risultati */
        System.out.println("Giocatore: "+player);
        System.out.println("Computer: "+ computer);

        if(player>computer)
            System.out.println("Hai vinto");
        else if (player<computer)
            System.out.println("Hai perso");
            else
            System.out.println("Parità");
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
