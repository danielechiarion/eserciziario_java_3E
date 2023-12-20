/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import java.util.Scanner;
public class Main
{
		public static void main(String[] args) {
		    
		//dichiarazione variabili
		int bottiglioni, scelta;
		String vino1="Prosecco", vino2="Merlot", vino3="Lugana";
		double pIva, netto, lordo;
		
		//definizione di costanti 
		final double iva=0.22;
		final double capacita=1.5;
		final double prezzo1=2.5, prezzo2=3, prezzo3=5;
		
		//creazione oggetto scanner
		Scanner in = new Scanner(System.in);
		
		//richiesta inserimento dati input
		System.out.println("Benvenuto alla TANA DEI GOTI!\nQui puoi scegliere tra i seguenti vini:");
		System.out.println(vino1+" - "+prezzo1+"€ - Digita 1");
		System.out.println(vino2+" - "+prezzo2+"€ - Digita 2");
		System.out.println(vino3+" - "+prezzo3+"€ - Digita 3");
		do
		{
		  System.out.println("Fai la tua scelta: ");
		  scelta=in.nextInt();  
		}while(scelta<1 || scelta>3);
		
		do{
		    System.out.println("Quanti bottiglioni vuoi acquistare? ");
		    bottiglioni=in.nextInt();
		}while(bottiglioni<=0);
		
		//assegno ad ognuno il rispettivo costo netto (IVA esclusa)
		if(scelta==1)
		{
		    netto=prezzo1*capacita*bottiglioni;
		    System.out.println("Hai acquistato "+bottiglioni+" di "+vino1);
		}
		    
		    else if(scelta==2)
		    {
		        netto=prezzo2*capacita*bottiglioni;
		        System.out.println("Hai acquistato "+bottiglioni+ " di "+vino2);
		    }
		        
		            else
		            {
		                netto=prezzo3*capacita*bottiglioni;
		                System.out.println("Hai acquistato "+bottiglioni+ " di " + vino3);
		            }
		                
		
		//proseguo con il resto dei calcoli
		pIva=netto*iva;
		lordo=netto+iva;
		
		
		//restituzione dati output
		System.out.println("Il prezzo imponibile è "+netto+"€");
		System.out.println("L'IVA applicata è "+pIva+"€");
		System.out.println("Il totale da pagare è "+lordo+"€");
		System.out.println("Grazie e arrivederci");
	}
}
