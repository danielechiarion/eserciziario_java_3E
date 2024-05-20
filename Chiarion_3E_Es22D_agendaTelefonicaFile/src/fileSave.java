import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class fileSave {
    /* metodo che scrive su file CSV */
    public static void scriviFile(Contatto[] gestore, int contrattiVenduti, String filePath)throws IOException {
        FileWriter out = new FileWriter(filePath); //creazione di un fileWriter

        for(int i=0;i<contrattiVenduti;i++)
            out.write(gestore[i].toString()+"\r\n"); //scrivo ogni contatto nel file

        out.flush(); //svuota il buffer
        out.close(); //chiude il file
    }

    /* metodo che legge da file CSV
    * e lo trasforma in un array di contatti */
    public static int leggiFile(String fileName, Contatto[] gestore)throws IOException{
          /* creo uno stream che permette
          * di leggere i dati */
        FileReader in = new FileReader(fileName);

        Scanner scanner = new Scanner(in); //creo lo scanner del file

        /* dichiarazioni variabili e vettori */
        int contrattiVenduti=0; //dichiaro la variabile di contratti venduti
        String lineIn;
        String[] vetAttributi;

        while(scanner.hasNextLine() && contrattiVenduti<gestore.length){ //fin quando si ha una riga dopo
            lineIn = scanner.nextLine(); //leggo la riga
            vetAttributi=lineIn.split(","); //separo i vari valori

            /* prendo gli attributi ricavati nel vettori
            * e creo un nuovo contatto */
            gestore[contrattiVenduti] = new Contatto(vetAttributi[0], vetAttributi[1], vetAttributi[2], tipoContratto.valueOf(vetAttributi[3]));
            gestore[contrattiVenduti].setRicarica(-gestore[contrattiVenduti].getRicarica()+Double.parseDouble(vetAttributi[4]));
            contrattiVenduti++; //incremento i contratti venduti
        }

        return contrattiVenduti; //ritorna il valore di contratti venduti
    }

    /* metodo che permette di leggere
    quanti un numero N di contatti */
    public static Contatto[] leggiNContatti(int num, String fileName)throws IOException{
        /* dichiarazione lettori di file */
        FileReader in = new FileReader(fileName);
        Scanner scanner = new Scanner(in);

        /* dichiarazioni variabili */
        String lineIn;
        String[] vetAttributi;
        int contaPosOccupate=0;


        /* leggo quante righe contiene il vettore */
        int dimensione = Integer.parseInt(scanner.nextLine()); //conto il numero di contatti disponibili

        /* se la dimensione è maggiore del numero,
        * il vettore avrà lunghezza numero, altrimenti avrà lunghezza
        * dimensione */

        Contatto[] gestore = new Contatto[num]; //creo array

        return gestore;
    }
}
