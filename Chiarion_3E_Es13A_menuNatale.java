import java.util.Scanner;
import java.io.IOException;
public class Esercizio {
    private static double incassoGiornata = 0.00;

    public static void main(String[] args) {
        //Istanziamento dell'oggetto keyboard
        Scanner keyboard = new Scanner(System.in);
        //Variabile termine programma
        boolean termineProgramma = false;

        //Loop fino a specifica termine programma
        do {
            //Stampa dei lavori vari
            System.out.println("Selezionare il lavoro da eseguire :");
            System.out.println("Lavoro 1: cuocere tante uova di natale finche' l'utente non e' stanco");
            System.out.println("Lavoro 2: pagare il conto relativo ad hamburger vegani ed hamburger di renna (costano il doppio) e bevande natalizie analcoliche ed alcoliche (costano il doppio), comunicato dal singolo utente. Se si superano i 10 euro c'e' lo sconto del 15% per le cifre oltre i 10 euro.");
            System.out.println("Lavoro 3: Stampare l'intero incasso del giorno.");

            //Richiesta input con controllo errori
            int input;
            do {
                System.out.print("\n[1, 2, 3] > ");
                input = keyboard.nextInt();

                if(input < 1 || input > 3)
                    System.out.println("Errore : il numero inserito deve essere compreso tra 1 e 3");
            } while (input < 1 || input > 3);

            //Esecuzione del lavoro richiesto
            switch(input) {
                case 1 : CucinaUovo(keyboard);break;
                case 2 : ContoHamburger(keyboard);break;
                case 3 : StampaIncasso();break;

                default : System.out.println("Si e' verificato un errore durante il controllo sull'input");break;
            }

            //Richiesta di termine del programma
            System.out.print("Se si vuole terminare il programma digitare 'S', altrimenti dgitare un'altro tasto : ");
            //Controllo su input inserito
            if(
                keyboard.next().toUpperCase().charAt(0) == 'S'
            )
                termineProgramma = true;

        } while(!termineProgramma);

 
        //Termine programma
        System.out.println("Termine del programma");
    }

    private static void CucinaUovo (Scanner input) //creazione main
    {
        char scelta;
        System.out.println("\nDesidera mangiare un Uovo? Costa 3$\n Digitare 'S' se si desidera un uovo: ");
        scelta = input.next().toUpperCase().charAt(0);
        while (scelta == 'S')
        {
            System.out.println("\nMo ti arriva l'uovo");
            Sleep();
            System.out.println("\necco cucinato");
            incassoGiornata = incassoGiornata + 3.00;

            System.out.println("\nDesidera mangiare un altro Uovo?\n Digita 'S' se desidera un uovo: ");
            scelta = input.next ().toUpperCase ().charAt (0);
        }
    }

    //creazione funzione InserisciUovo
    private static void Sleep() 
    {
        try
        {
            Thread.sleep(3 * 60 * 1000); //"Blocca" l'esecuzione per il tempo indicato (millisecondi)
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void ContoHamburger(Scanner keyboard)
    {
        /* dichiarazioene e inizializzazione variabili */
        int quantita1, quantita2;
        int scelta1, scelta2;
        char input, ripetere;
        double totale=0;

        /* dichiarazione costanti */
        final double prezzoBurger=3.5;
        final double prezzoBurger2 = prezzoBurger * 2;
        final double prezzoBibita=1.25;
        final double prezzoBibita2 = prezzoBibita * 2;

        do {
            /* menu di scelta */
            System.out.println("Benvenuto!");
            System.out.println("Desideri prendere un hamburger? DIGITA S per confermare, altro tasto per annullare");
            input = keyboard.next().charAt(0);

            if(input=='s' || input=='S')
            {
                do {
                    System.out.println("Scegli hamburger:\n1 - Hamburger vegano\n2 - Hamburger renna");
                    scelta1=keyboard.nextInt();
                }while(scelta1<1 || scelta1>2);

                do {
                    System.out.println("Inserisci la quantita': ");
                    quantita1=keyboard.nextInt();
                }while(quantita1<=0);

                if(scelta1==1)
                    totale+=prezzoBurger*quantita1;
                else
                    totale+=prezzoBurger2*quantita1;
            }

            System.out.println("\nDesideri acquistare una bibita? Digita S per confermare, altro tasto per annullare");
            input = keyboard.next().charAt(0);

            if(input=='s' || input=='S')
            {
                do {
                    System.out.println("Scegli bibita:\n1 - analcolica\n2 - alcolica");
                    scelta2=keyboard.nextInt();
                }while(scelta2<1 || scelta2>2);

                do {
                    System.out.println("Inserisci la quantita': ");
                    quantita2=keyboard.nextInt();
                }while(quantita2<=0);

                if(scelta2==1)
                    totale+=prezzoBibita*quantita2;
                else
                    totale+=prezzoBibita2*quantita2;
            }

            System.out.println("Il totale da pagare e' "+totale);
            do {
                System.out.println("Desideri effettuare un nuovo acquisto? Inserisci S per procedere, N per chiudere cassa");
                ripetere=keyboard.next().charAt(0);
            }while(ripetere!='s' && ripetere!='S' && ripetere!='n' && ripetere!='N');
        }while(ripetere=='s' || ripetere=='S');

        //Incrementare l'incasso della giornata in modo da contenere il totale acquistato
        incassoGiornata += totale;
    }

    private static void StampaIncasso() {
        System.out.println("Incasso totale del giorno : " + incassoGiornata + " Euro.");
    }
}