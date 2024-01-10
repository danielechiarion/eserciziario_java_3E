import java.util.*;

public class Chiarion_3E_Es14B_staticheDado {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int i;
        int valore;
        int cont1=0,cont2=0,cont3=0,cont4=0,cont5=0,cont6=0;

        /* generazione dati casuali */
        for(i=0;i<10;i++)
        {
            valore = valCasuale(0,6)+1;
            //System.out.printf("\nValore: %d", valore);
            //%d intero
            //%f float
            //%d stringa
            //%c char
            FacceDado(valore);
            Wait();
            ClrScr();

            switch(valore)
            {
                case 1:
                    cont1++;
                    break;
                case 2:
                    cont2++;
                    break;
                case 3:
                    cont3++;
                    break;
                case 4:
                    cont4++;
                    break;
                case 5:
                    cont5++;
                    break;
                case 6:
                    cont6++;
                    break;
            }
        }

        /* output risultati */
        System.out.printf("\n\nFaccia %d : %d", 1, cont1);
        System.out.printf("\nFaccia %d : %d", 2, cont2);
        System.out.printf("\nFaccia %d : %d", 3, cont3);
        System.out.printf("\nFaccia %d : %d", 4, cont4);
        System.out.printf("\nFaccia %d : %d", 5, cont5);
        System.out.printf("\nFaccia %d : %d", 6, cont6);
    }

    private static int valCasuale(int min, int max)
    {
        /* creazione oggetto random */
        Random casuale = new Random(); //costruttore - senza parametri

        return casuale.nextInt(min,max);
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
}
