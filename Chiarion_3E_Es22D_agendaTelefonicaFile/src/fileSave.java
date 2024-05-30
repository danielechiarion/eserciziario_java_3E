import java.io.*;
import java.util.Scanner;

import static tools.utility.menu;

public class fileSave {
    /* metodo che scrive su file CSV */
    public static void scriviFile(Contatto[] gestore, int contrattiVenduti, String filePath)throws IOException {
        FileWriter out = new FileWriter(filePath); //creazione di un fileWriter

        for(int i=0;i<contrattiVenduti;i++)
            out.write(gestore[i].toString()+"\r\n"); //scrivo ogni contatto nel file

        out.flush(); //svuota il buffer
        out.close(); //chiude il file
    }

    /* metodo che scrivi i file utilizzando
    * l'append */
    public static void appendFile(Contatto elemento, String filePath)throws IOException{
        FileWriter out = new FileWriter(filePath, true); //append di un file

        out.append(elemento.toString()+"\r\t"); //aggiungo l'elemento in coda

        /* svuoto il buffer e chiudo e il file */
        out.flush();
        out.close();
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

    /* metodo che permette di scrivere N contatti */
    public static void scriviNContatti(String filePath, int numContatti, Contatto[] rubrica)throws IOException{
        FileWriter out = new FileWriter(filePath);

        out.write(numContatti+"\r\n"); //prima metto il numero di contatti

        /* scrivo tutti gli altri valori */
        for(int i=0;i<numContatti && i<rubrica.length;i++)
            out.write(rubrica[i].toString()+"\r\n");

        /* svuoto il buffer e chiudo il file */
        out.flush();
        out.close();
    }

    /* metodo che permette di leggere
    quanti un numero N di contatti */
    public static Contatto[] leggiNContatti(String fileName)throws IOException{
        /* dichiarazione lettori di file */
        FileReader in = new FileReader(fileName);
        Scanner scanner = new Scanner(in);

        /* dichiarazioni variabili */
        String lineIn;
        String[] vetAttributi;
        int contaPosOccupate=0;


        /* leggo quante righe contiene il vettore */
        int dimensione = Integer.parseInt(scanner.nextLine());
        if(dimensione<0)
            return null;

        Contatto[] gestore = new Contatto[dimensione]; //creo array con la dimensione trovata

        for(int i=0;i<dimensione;i++){
            vetAttributi = scanner.nextLine().split(","); //leggo i valori separati dalla virgola
            gestore[i]=new Contatto(vetAttributi[0],vetAttributi[1], vetAttributi[2], tipoContratto.valueOf(vetAttributi[3]));
            gestore[i].setRicarica(-gestore[i].getRicarica()+Double.parseDouble(vetAttributi[4]));
        }

        return gestore;
    }

   /* public static String[] cercaFileDirectory(String percorso, String estensione){
        File directory = new File(percorso); //creo la directory
        File[] list = directory.listFiles(); //trova la lista dei file

        /* conto quanti file hanno l'estensione indicata */
        /*int cont=0;

        for(File thisFile : list){
            if(thisFile.getPath().substring(thisFile.getPath().length()-estensione.length(), thisFile.getPath().length()-1).equals(estensione)) //se la parte finale corrisponde all'estensione inserita
                cont++; //aumento il contatore
        }
    } */


    /* metodo che legge l'elenco di file
    * visibili in formato CSV, ritornando la serie di percorsi */
    public static String[] leggiFileDirectory(){
        String userDirectoryPath = System.getProperty("user.dir");
        String[] listaFile=null;

        File dir = new File(userDirectoryPath); //creo la directory con il percorso
        if(dir.isDirectory()){
            listaFile=dir.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".csv");
                }
            }); //lista dei file inseriti
        }

        return listaFile; //ritorno la lista di percorso dei file
    }

    /* metodo che permette la scelta dei file
    * per il salvataggio */
    public static String scegliFile(String[] listaFile, Scanner keyboard){
        int scelta; //variabile per la scelta

        String[] listaCSV = new String[listaFile.length+1];
        /* copio tutti i valori */
        listaCSV[0] = "LISTA FILE CSV";
        for(int i=0;i<listaFile.length;i++)
            listaCSV[i+1]=listaFile[i];
        scelta = menu(listaCSV, keyboard);

        return listaCSV[scelta]; //ritorno la stringa con il percorso
    }
}
