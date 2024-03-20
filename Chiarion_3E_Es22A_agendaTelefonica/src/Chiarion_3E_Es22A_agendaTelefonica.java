import java.util.Scanner;
import persona.*;

public class Chiarion_3E_Es22A_agendaTelefonica {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta;
        /* dichiarazione costanti */
        final int nMax=3;
        /* creazione scanner */
        Scanner keyboard = new Scanner(System.in);
        /* creazione vettori */
        String[] opzioni = {"RUBRICA TELEFONICA",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Fine"}; //menu per le opzioni
        Contatto[] rubrica = new Contatto[nMax];
        /* creazione oggetto */
        //serve per riservare in memoria lo spazio per il nostro oggetto
        //Contatto utente = new Contatto(); //istanza di un oggetto di tipo contatto

        /* utente.nome="pippo";
        utente.cognome="rossi";
        utente.telefono="0123456789";
        utente.utilizzo=Contatto.tipoTel.AZIENDALE;

        System.out.println(utente.anagrafica()); */

        do {
            scelta=menu(opzioni, keyboard);
            switch(scelta)
            {
                case 1:
                    System.out.println("INSERIMENTO NUMERO");
                    break;
                case 2:
                    System.out.println("VISUALIZZAZIONE NUMERO");
                    break;
                case 3:
                    System.out.println("RICERCA NUMERO");
                    break;
                default:
                    System.out.println("Chiusura programma");
                    Wait(3);
                    ClrScr();
            }
        }while(scelta!= opzioni.length-1);
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

    private static void leggiPersona(boolean checkTel, Scanner keyboard)
    {

    }
}
