import java.util.Scanner;

public class Chiarion_3E_Es25A_stringSplit {
    public static void main(String[] args) {
        /* dichiarazione variabili e costanti */
        final int maxChar = 80; //lunghezza massima stringa
        final int substringMaxLength=40; //massima lunghezza sottostringa
        String input; //stringhe da prendere in input
        String[] dueStringhe = new String[2]; //due stringhe divise
        /* creazione Scanner */
        Scanner scanner = new Scanner(System.in);

        /* input dati con controllo
        * lunghezza stringa */
        do {
            System.out.println("Inserisci la stringa (max 80 caratteri)");
            input=scanner.nextLine();

            /* possibile messaggio di errore */
            if(input.length()>maxChar)
                System.out.println("Stringa di lunghezza superiore agli "+maxChar+" caratteri");
        }while(input.length()>maxChar);

        /* divisione stringa in due sottostringhe */
        dueStringhe = marginaStringa(input, substringMaxLength);

        /* output risultati */
        System.out.println("Prima stringa: \n"+"'"+dueStringhe[0]+"'");
        System.out.println("Seconda stringa: \n"+"'"+dueStringhe[1]+"'");
    }

    /* metodo che suddivide una stringa iniziale
    * in due sottostringhe, evitando lo stroncamento
    * di parole */
    private static String[] marginaStringa(String x, int limite){
        String[] dueStringhe = {"", ""}; //dichiaro un vettore di due stringhe
        int lunghezza=0; //lunghezza della stringa che incrementa volta per volta

        String[] frase = x.split(" "); //separo la stringa utilizzando gli spazi

        for(int i=0;i<frase.length;i++)
        {
            lunghezza += frase[i].length(); //ogni volta la lunghezza incrementa
            if(lunghezza<=limite) //se la lunghezza e' minore di 40
                dueStringhe[0]+=frase[i]+" "; //ricostruisco la prima stringa
            else
                dueStringhe[1]+=frase[i]+" "; //altrimenti viene inserito il resto nella seconda
        }

        return dueStringhe; //viene ritornato il vettore con due stringhe separate
    }
}
