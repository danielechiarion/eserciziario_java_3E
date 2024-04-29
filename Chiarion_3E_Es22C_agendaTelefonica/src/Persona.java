/**
 * La classe persona contiene gli attributi e i
 * metodi essenziali per qualsiasi
 * tipo di contatto.
 */
public class Persona {
    /* lista attributi */
    protected String nome;
    protected String cognome;

    protected String telefono;
    protected double ricarica;
    protected String[] altro; //informazioni supplementari da aggiungere

    /* metodi get/set attributi */
    public String getNome(){
        return this.nome;
    }
    public String getCognome(){
        return this.cognome;
    }
    public String getTelefono(){
        return this.telefono;
    }
    public String getAltroElemento(int pos){
        return this.altro[pos];
    }
    public String[] getAltro(){
        return this.altro;
    }
    public double getRicarica(){
        return this.ricarica;
    }

    public void setNome(String x){
        this.nome=x;
    }
    public void setCognome(String x){
        this.cognome=x;
    }
    public void setTelefono(String x){
        this.telefono=x;
    }
    public void setAltroElemento(String x, int pos){
        this.altro[pos]=x;
    }
    public void setRicarica(double num){
        this.ricarica+=num;
    }

    /**
     * Metodo costruttore della classe Persona.
     * Dovrà acquisire gli attributi necessari eseguendo uno split delle
     * stringhe.
     *
     * @param base - informazioni essenziali per la creazione di un contatto
     *             (nome, cognome, numero di telefono).
     * @param extra - informazioni aggiuntive del contatto
     * @param ricaricaDefault  - valore di default della ricarica iniziale stabilito dalla rubrica
     */
    public Persona(String base, String extra, double ricaricaDefault){
        String[] infoBase = base.split(","); //raccolgo le informazioni di base suddividendole

        /* setto gli attributi grazie ai valori ottenuti */
        this.nome=infoBase[0];
        this.cognome=infoBase[1];
        this.telefono=infoBase[2];

        /* controllo se ha delle informazioni
        * aggiuntive sul contatto, in tal caso
        * le memorizzo nel vettore apposito */
        if(!extra.isBlank())
            this.altro=extra.split(","); //il separatore della virgola è stabilito per convenzione

        this.ricarica=ricaricaDefault; //viene assegnata la variabile di default della rubrica scelta
    }

    /**
     * Metodo per la stampa delle informazioni base del contatto in questione
     */
    public String stampa(){
        /* assegno inizialmente le informazioni di base */
        String info = String.format("Nome: %s\tCognome: %s\nTelefono: %s\tRicarica: %.2f€",
                this.nome, this.cognome, this.telefono, this.ricarica);

        /* se ci sono anche informazioni aggiuntive,
        * le aggiungo */
        if(this.altro!=null){
            info+="\n";
            for(int i=0;i<this.altro.length;i++){
                info += String.format("%s\t", this.altro[i]);
                if(i%3==0)
                    info += "\n";
            }
        }

        return info; //ritorno il valore finale
    }
}
