import java.io.IOException;
import java.time.LocalDateTime; //contiene metodi relativi a giorno e ora
import java.util.Random;
import java.io.FileReader;
import java.util.Scanner;

public class Chiamata extends Object {
    public String numero;
    public LocalDateTime dataChiamata;
    int durata; //espresso in secondi

    /* metodo costruttore della chiamata */
    public Chiamata(String numero){
        this.numero=numero;
        this.dataChiamata=LocalDateTime.now();
        this.durata=durataChiamata();
    }
    @Override
    public String toString(){
        return String.format("%s, %s, %s, %dsec", this.numero, this.dataChiamata.toLocalDate(),this.dataChiamata.toLocalTime(), this.durata);
    }

    /* metodo che genera randomicamente la durata della chiamata */
    public int durataChiamata(){
        Random random = new Random();

        return random.nextInt(0,3600)+1;
    }

    public String toCSV(){
        return String.format("%s,%s,%d", this.numero, this.dataChiamata.toString(), this.durata);
    }

    public static Chiamata[] parseCSV(String filePath)throws IOException {
        /* creo fileReader e scanner */
        FileReader fileReader = new FileReader(filePath);
        Scanner scanner = new Scanner(fileReader);

        int righe=fileSave.contaRigheCSV(filePath); //conto il numero di righe

        /* creo il vettore e converto ogni stringa in un
        * oggetto chiamata */
        Chiamata[] registro = new Chiamata[righe];
        String[] attributi; //dichiaro il vettore di stringa di attributi che poi andrò a popolare
        for(int i=0;i<registro.length;i++){
            attributi = scanner.nextLine().split(","); //leggo la stringa e separo i valori

            if(attributi.length!=3)
                continue;

            /* creo l'oggetto chiamata e aggiorno gli attributi */
            registro[i]=new Chiamata(attributi[0]);
            registro[i].dataChiamata=LocalDateTime.parse(attributi[1]);
            registro[i].durata=Integer.parseInt(attributi[2]);
        }

        fileReader.close();
        scanner.close();

        return registro; //ritorno il nuovo registro
    }
}