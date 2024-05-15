import java.io.FileWriter;
import java.io.IOException;

public class fileSave {
    public static void scriviFile(Contatto[] gestore, int contrattiVenduti, String filePath)throws IOException {
        filePath="archivio.csv"; //definizione percorso
        FileWriter out = new FileWriter(filePath); //creazione di un fileWriter

        for(int i=0;i<contrattiVenduti;i++)
            out.write(gestore[i].toString()+"\r\n"); //scrivo ogni contatto nel file

        out.flush(); //svuota il buffer
        out.close(); //chiude il file
    }

    public static Contatto[] leggiFile(){
         
    }
}
