/* GIOCATA UTENTE: il giocatore punta 5 numeri sulla ruota di Venezia */
/* LISTA SPESA:
- vettore di dimensione 5 elementi
- controllo che i numeri siano compresi nel range
- controllare di aver inserito i 5 valori
- controllo che non ci siano ripetizioni */

/* VISUALIZZA GIOCATE
- menu di scelta (ruota o giocatore) */

import java.util.Scanner;
import java.util.Random;

public class Chiarion_3E_Es15D_estrazioniLotto {
    public static void main(String[] args) {
        /* dichirazione variabili, scanner e vettori */
        String[] opzioni={"Estrazioni lotto","[1] Estrazioni ruota di Venezia", "[2] Giocata utente", "[3] verifica vincita", "[4] Visualizza giocate"};
        String[] opzioni2={"[1] Venezia", "[2] giocatore"};
        int[] player = new int[5];
        int[] riferimento = new int[5];
        int scelta;
        Scanner keyboard = new Scanner(System.in);
        Random casuale = new Random();
        /* menu scelta */
        scelta=menu(opzioni, keyboard);
        Wait(5);

        /* possibilità di scelta */
        switch(scelta)
        {
            case 1:
                player=inputVal(player, keyboard);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:

        }
    }

    private static int[] inputVal(int[] vet, Scanner keyboard)
    {
        int check=0;
        for(int i=0;i<vet.length;i++)
        {
            do {
                check = 0; //azzeramento variabile
                System.out.println("Inserisci il "+(i+1)+"^ valore: ");
                vet[i] = keyboard.nextInt();
                if(i>0)
                {
                    for (int k = i - 1; k >= 0; k--) {
                        if (vet[i] == vet[k])
                            check++;
                    }
                }
            }while(check!=0 || (vet[i]<1 || vet[i]>90)); //viene effettuato questo controllo per evitare che ci siano numeri doppi
        }
        return vet;
    }

    private static int[] casuale(int[] vet, Random casuale)
    {
        int check;
        for(int i=0; i<vet.length; i++)
        {
            do {
                check = 0; //azzeramento variabile
                vet[i] = casuale.nextInt(0, 90) + 1;
                for (int k = i - 1; k >= 0; k--) {
                    if (vet[i] == vet[k])
                        check++;
                }
            }while(check!=0);
        }

        return vet;
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
}
