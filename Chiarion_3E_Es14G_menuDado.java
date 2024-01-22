import java.util.Scanner;
import java.util.Random;

public class Chiarion_3E_Es14G_menuDado{
    public static void main(String[] args) {
        int scelta;
        int[] vet = new int[2];
        String[] nomi = new String[2];

        String[] opzioni={"Gara lancio dadi","[1] Sfida tra due giocatori", "[2] Sfida contro computer", "[3] fine"};
        Scanner keyboard = new Scanner(System.in);
        do {
            ClrScr();
            scelta=menu(opzioni, keyboard);
            Wait(5);
            ClrScr();
            switch(scelta)
            {
                case 1:
                    System.out.println("Inserisci il nome del primo giocatore: ");
                    nomi[0]=keyboard.next();
                    System.out.println("Inserisci il nome del secondo giocatore: ");
                    nomi[1]=keyboard.next();
                    ClrScr();
                    vet=estrazione();
                    printFacce(vet[0], nomi[0]);
                    printFacce(vet[1], nomi[1]);
                    confronto(vet, nomi);
                    Wait(5);
                    break;
                case 2:
                    System.out.println("Inserisci il nome del giocatore: ");
                    nomi[0]=keyboard.next();
                    nomi[1]="computer";
                    ClrScr();
                    vet=estrazione();
                    printFacce(vet[0], nomi[0]);
                    confronto(vet, nomi);
                    Wait(5);
                    break;

                case 3:
                    System.out.println("Fine programma");
                    break;
            }
        }while(scelta!=3);
    }

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

    private static int[] estrazione()
    {
        int[] vet = new int[2];
        Random casuale = new Random();

        vet[0]=casuale.nextInt(0,6)+1;
        vet[1]=casuale.nextInt(0,6)+1;

        return vet;
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
