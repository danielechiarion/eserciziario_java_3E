/* a differenza della versione B
* utilizziamo un array al posto delle variabili */
import java.util.Random;

public class Chiarion_3E_Es14C_staticheDado2 {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int i;
        int valore;

        /* dichiarazione vettore */
        int[] frequenza = new int[6]; //un array è una collezione di dati dello stesso tipo
        //inizializza già tutto a 0

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
                    frequenza[0]++;
                    break;
                case 2:
                    frequenza[1]++;
                    break;
                case 3:
                    frequenza[2]++;
                    break;
                case 4:
                    frequenza[3]++;
                    break;
                case 5:
                    frequenza[4]++;
                    break;
                case 6:
                    frequenza[5]++;
                    break;
            }
        }

        /* output risultati */
        for(i=0;i<frequenza.length;i++)
        {
            System.out.printf("\nFaccia %d : %d", i+1, frequenza[i]);
        }
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
