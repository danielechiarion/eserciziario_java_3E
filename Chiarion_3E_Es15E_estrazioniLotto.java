/* GIOCATA UTENTE: il giocatore punta 5 numeri sulla ruota di Venezia */
/* LISTA SPESA:
- vettore di dimensione 5 elementi
- controllo che i numeri siano compresi nel range
- controllare di aver inserito i 5 valori
- controllo che non ci siano ripetizioni */

/* VISUALIZZA GIOCATE
- menu di scelta (ruota o giocatore) */

import java.util.Random;
import java.util.Scanner;

public class Chiarion_3E_Es15E_estrazioniLotto {
    public static void main(String[] args) {
        /* dichirazione variabili e vettori */
        String[] opzioni={"Estrazioni lotto","[1] Estrazioni ruota di Venezia", "[2] Giocata utente", "[3] Verifica vincita", "[4] Visualizza giocate", "[5] Fine"};
        String[] opzioni2={"output risultati","[1] Estrazioni ruota di Venezia", "[2] Giocata utente", "[3] Entrambi"};
        int[] player = new int[5];
        int[] riferimento = new int[player.length];
        int[] scelta = new int[2];
        int[] check = new int[2];
        int cont=0;
        double puntata=0, premio;
        /* dichiarazione oggetti */
        Scanner keyboard = new Scanner(System.in);
        Random casuale = new Random();

        do {
            /* menu scelta */
            scelta[0]=menu(opzioni, keyboard);
            ClrScr();
            /* possibilità di scelta */
            switch(scelta[0])
            {
                case 1:
                    /* se un'utente ha erroneamente o volutamente
                    * estratto i numeri più volte
                    * pareggio i due contatori di controllo per evitare successivi problemi */
                    if(check[0]>check[1])
                    {
                        check[1]=check[0];
                    }
                    riferimento=valCasuale(riferimento, casuale); //assegnazione numeri casuali
                    check[0]++;//aumento del valore del vettore di controllo
                    System.out.println("Estrazione ruota di Venezia completata"); //output di azione completata
                    Wait(3); //attesa
                    break;
                case 2:
                    player = inputVal(player, keyboard); //richiesta inserimento valori
                    check[1]++;//aumento del valore del vettore di controllo
                    System.out.println("Hai giocato i tuoi valori"); //output di azione completata
                    Wait(3);
                    break;
                case 3:
                    /* il metodo controllo check serve per controllare che estrazione e valori giocati
                    siano di pari passo. Senza questo controllo
                    sarebbe possibile vedere i valori vinti e vincere di conseguenza, mentre così è possibile giocare
                    senza poter barare*/
                    if(controllo(check)==true)
                        risultato(player,riferimento);
                    break;
                case 4:
                    if(controllo(check)==true)
                    {
                        scelta[1]=menu(opzioni2, keyboard);
                        ClrScr();
                        /* output risultati */
                        switch(scelta[1])
                        {
                            case 1:
                                System.out.println("Numeri estratti ruota di Venezia");
                                stampaNumeri(riferimento);
                                break;
                            case 2:
                                System.out.println("Numeri giocati dall'utente");
                                stampaNumeri(player);
                                break;
                            case 3:
                                System.out.println("I tuoi numeri");
                                stampaNumeri(player);
                                System.out.println("\nNumeri vincenti");
                                stampaNumeri(riferimento);
                                break;
                            default:
                                System.out.println("Valore inserito errato. Riprova");
                        }
                    }
                    Wait(5);
                    break;
                case 5:
                    System.out.println("Fine del programma");
                    Wait(3);
                    break;
                default:
                    System.out.println("Valore inserito errato. Riprova.");
                    Wait(3);
            }
            /* se è stata fatta una giocata, l'ultima scelta (tra giocatore e ruota di Venezia)
             * viene salvata e utilizzata nella verifica e nell'output dei risultati */
            if(scelta[0]==1 || scelta[0]==2)
            {
                scelta[1]=scelta[0];
            }
        }while(scelta[0]!=5);
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

    private static int[] valCasuale(int[] vet, Random casuale)
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

    private static int risultato(int[] vet1, int[] vet2)
    {
        int cont=0;

        for(int i=0;i<vet1.length;i++)
        {
            for(int k=0;k<vet2.length;k++)
            {
                if(vet1[i]==vet2[k])
                    cont++;
            }
        }

        System.out.println("Hai fatto: ");
        switch(cont)
        {
            case 1:
                System.out.println("Ambata");
                break;
            case 2:
                System.out.println("Ambo");
            case 3:
                System.out.println("Terna");
                break;
            case 4:
                System.out.println("Quaterna");
                break;
            case 5:
                System.out.println("Cinquina");
                break;
            default:
                System.out.println("///");
        }

        return cont;
    }

    private static void stampaNumeri(int[] vet)
    {
        for(int i=0;i<vet.length;i++)
        {
            System.out.print(vet[i]+"\t");
        }
    }

    private static boolean controllo(int[] check)
    {
        boolean status=false;

        if(check[0]==check[1])
            status=true;
        else if(check[0]<check[1])
            System.out.println("Devi eseguire un'estrazione");
        else
            System.out.println("Devi giocare i tuoi numeri");

        return status;
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
