//Author: Daniele Chiarion
//Date: 06-12-2023

/* Realizzare il programma della morra cinese.
La morra cinese è quel semplice gioco tra due

giocatori, dove ognuno dei due sceglie tra i tre
elementi: sasso, carta e forbici. Le regole del gioco sono 3 e sono
semplicissime:
la carta vince sul sasso
il sasso vince sulle forbici
le forbici vincono sulla carta

Il gioco deve essere realizzato in modo che i
due giocatori si possano sfidare
utilizzando la tastiera.
Si suppone che per il primo giocatore sia
abilitato ad utilizzare i tasti
A = carta,S = sasso,D = forbici,
mentre per il secondo
J = carta,K = sasso,L = forbici.
La digitazione dei tasti non deve essere
visibile.

Specifiche di progetto:
- la gara è valida solamente se i valori letti in input
appartengono all’insieme di validità;
- Il programma si deve ripetere finchè uno dei due
giocatori non inserisce «X». */

import java.util.Scanner;
import java.io.IOException;

public class Chiarion_3E_Es05A_morraCinese {
    public static void ClrScr()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        char player1, player2=' ';

        /* creazione scanner */
        Scanner keyboard= new Scanner(System.in);

        /* Inserimento informazioni e
        richiesta inserimento dati input */
        System.out.println("Benvenuto alla morra cinese. Ecco i comandi da digitare: ");
        System.out.println("Giocatore 1 - A (carta), S (sasso), D (forbici)");

        do {
            do {
                System.out.println("\nGiocatore 1 - inserire l'elemento: ");
                player1 = keyboard.next().charAt(0);
            }while(player1!='A' && player1!='S' && player1!='D' && player1!='X');
            ClrScr();

            if(player1!='X')
            {
                System.out.println("Giocatore 2 - J (carta), K (sasso), L (forbici)");

                do {
                    System.out.println("\nGiocatore 2 - inserire l'elemento: ");
                    player2 = keyboard.next().charAt(0);
                }while(player2!='J' && player2!='K' && player2!='L' && player2!='X');
                ClrScr();
            }

            /* elaborazione dati e output dei risultati */

            /* posso ommettere la condizione in cui l'inserimento sia X
            perchè in tutte le seguenti condizioni non è esplicitato */
            if((player1=='A' && player2=='J') || (player1=='S' && player2=='K') || (player1=='D' && player2=='L'))
                System.out.println("Pareggio");
            else if(player1=='A' && player2=='K')
                System.out.println("Vince il giocatore 1");
            else if(player1=='S' && player2=='L')
                System.out.println("Vince il giocatore 1");
            else if(player1=='D' && player2=='J')
                System.out.println("Vince il giocatore 1");
            else if(player1=='S' && player2=='J')
                System.out.println("Vince il giocatore 2");
            else if(player1=='D' && player2=='K')
                System.out.println("Vince il giocatore 2");
            else if(player1=='A' && player2=='L')
                System.out.println("Vince il giocatore 2");

            System.out.print("\n\n");
        }while(player1!='X' && player2!='X');
    }
}
