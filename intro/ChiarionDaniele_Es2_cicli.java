import java.util.Scanner;
public class ChiarionDaniele_Es2_cicli {
    public static void main(String[] args) {
        //dichiarazione variabili
        int quantita, numero=0;
        int i;

        //creazione scanner
        Scanner keyboard= new Scanner(System.in);

        //richiesta quantità numeri
        do {
            System.out.print("Quanti numeri vuoi inserire? ");
            quantita=keyboard.nextInt();
        }while(quantita<=0);

        System.out.println("Inserire "+quantita+" numeri");

        //richiesta inserimento numeri
        for(i=0; i<quantita; i++)
        {
            System.out.println("Inserire il "+(i+1)+"° numero: ");
            numero=keyboard.nextInt();
        }

        System.out.println("Ho letto il numero "+numero);
    }
}
