/* importazione librerie */
import java.io.IOException;
import java.util.*;

public class Chiarion_3E_Es14A_dado {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        int ris1,ris2;

        ris1=Giocata(1);
        ris2=Giocata(2);
        ClrScr();

        /* output risultati */
        System.out.println("Dado giocatore 1: "+ris1);
        System.out.println("Dado giocatore 2: "+ris2);
        if(ris1>ris2)
            System.out.println("\nVince il giocatore 1");
        else if(ris2>ris1)
                System.out.println("\nVince il giocatore 2");
                else
                    System.out.println("\nParita'");
    }

    private static void Wait()
    {
        try{
            Thread.sleep(1000);
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

    private static int Giocata(int n)
    {
        /* dichiarazione variabili */
        int valore=0;
        int i;

        /* creazione oggetto random */
        Random faccia = new Random();

        for(i=0;i<=7;i++)
        {
            if(i==7)
            {
                System.out.println("Il dado del giocatore "+n+" e': ");
                valore=faccia.nextInt(0,6)+1;
                FacceDado(valore);
                Wait();
                Wait();
                Wait();
            }
            else
            {
                System.out.println("Giocatore "+n+":");
                valore=i;
                FacceDado(valore);
                Wait();
                ClrScr();
            }
        }

        return valore;
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
