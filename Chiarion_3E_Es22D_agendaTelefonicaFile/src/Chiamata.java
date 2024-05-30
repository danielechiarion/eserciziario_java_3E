import java.time.LocalDateTime; //contiene metodi relativi a giorno e ora
import java.util.Random;

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
}