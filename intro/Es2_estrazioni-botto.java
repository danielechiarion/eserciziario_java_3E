/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;
import java.util.Random;
public class Main
{
	public static void main(String[] args) {
		//creazione generatore numeri random
		Random random = new Random();
		
		//dichiarazione e inizializzazione variabili
		int i=0, prova=0;
		int numero = random.nextInt(90)+1;
		
		//definizione costante
		final int tentativi=10;
		
		//creazione oggetto Scanner
		Scanner in = new Scanner(System.in);
		
		//inserimento indicazioni
		System.out.println("Benvenuti alle estrazioni col botto!");
		System.out.println("Prova ad indovinare un numero a caso da 1 a 90");
		System.out.println("\nATTENZIONE! Hai solo "+tentativi+" tentativi! Buona fortuna!\n\n");
		
		
		//richiesta inserimento dati input
		while(i<tentativi && prova!=numero)
		{
		    do{
		        System.out.println("Inserisci un numero da 1 a 90");
		        prova=in.nextInt();
		    }while(prova<1 || prova>90);
		    
		    if(prova>numero && i!=9)
		        System.out.println("Il numero è troppo grande");
		        else if(prova<numero && i!=9)
		            System.out.println("Il numero è troppo piccolo");
		            
		  
		  
		    i++;
		}
		
		if(prova==numero)
		    System.out.println("Bravo, hai indovinato!");
		   
		   else
		        System.out.println("Hai fatto il botto! Il numero era "+numero);
	}
}
