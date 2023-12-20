import java.util.Scanner;
//util è la libreria, Scanner è il package

public class leggi {
    public static void main(String[] args) {
        System.out.println("Lettura dati Java");

        Scanner keyboard=new Scanner(System.in);

        //dichiarazione variabile
        int datoint;
        double datodouble;
        byte datobyte;
        float datofloat;
        boolean datobool;
        char datochar;
        String datostringa;

        System.out.println("Inserisci un valore ");
        datoint= keyboard.nextInt();
        System.out.println("Dato intero: "+datoint);
        datobyte= keyboard.nextByte();
        System.out.println("Byte: "+datobyte);
        datodouble= keyboard.nextDouble();
        System.out.println("Dato decimale: "+datodouble);
        datofloat= keyboard.nextFloat();
        System.out.println("Dato decimale: "+datofloat);
        datobool= keyboard.nextBoolean(); //il bool occupa 1 byte
        System.out.println("Dato booleano: "+datobool);
        datochar= keyboard.next().charAt(0);//vuole la posizione del carattere
        System.out.println("Dato char: "+datochar); //char occupa 2 byte (UTF-8)
        datostringa= keyboard.nextLine();
        System.out.println("Dato intero: "+datostringa); //2 byte per carattere + 1 byte iniziale per la dimensione
    }
}
