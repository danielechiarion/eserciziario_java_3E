/**
 * Classe che consente la gestione
 * di una rubrica con metodi di inserimento,
 * eliminazione, ordinamento e ricerca.
 */
public class Rubrica {
    /* definizione attributi */
    protected int maxContatti;
    protected int contrattiFirmati;
    protected Persona[] elenco;
    protected double ricaricaDefault;
    protected double tariffaMensile;

    /* metodi get / set necessari */
    public int getMaxContatti(){
        return this.maxContatti;
    }
    public int getContrattiFirmati(){
        return this.contrattiFirmati;
    }
    public double getRicaricaDefault(){
        return this.ricaricaDefault;
    }
    public double getTariffaMensile(){
        return this.tariffaMensile;
    }

    public void setRicaricaDefault(double ricarica){
        this.ricaricaDefault=ricarica;
    }
    public void setTariffaMensile(double tariffa){
        this.tariffaMensile=tariffa;
    }

    /* non metto i metodi set per valori
    * quali il numero massimo di contratti e i contratti venduti
    * in quanto comporterebbero problemi nella gestione degli array
    * e non ulteriormente modificabili una volta istanziato l'oggetto. */

    /**
     * Metodo costruttore che permette di creare una rubrica
     * @param maxContatti - ovvero la dimensione del vettore
     * @param ricaricaDefault - ovvero il valore minimo di ricarica che ogni scheda
     *                        ha nel momento della sua creazione
     * @param tarrifa - il costo mensile di tale contratto
     */
    public Rubrica(int maxContatti, double ricaricaDefault, double tarrifa){
        /* inizializzazione attributi
        * grazie ai dati inseriti */
        this.maxContatti=maxContatti;
        this.ricaricaDefault=ricaricaDefault;
        this.tariffaMensile=tarrifa;

        /* creazione del vettore di contatti */
        this.elenco=new Persona[maxContatti];

        /* inizializzazione attributi non
        * inseriti nella firma del metodo */
        this.contrattiFirmati=0;
    }

    /**
     * Metodo per l'aggiunta di un account in una rubrica
     * @param info - informazioni di base del contatto
     * @param extra - informazioni aggiuntive non obbligatorie del contatto
     */
    public void aggiungi(String info, String extra){
        Persona persona = new Persona(info, extra, this.ricaricaDefault); //istanziazione nuovo contattp

        this.elenco[this.contrattiFirmati]=persona; //collocazione nella sua posizione
        this.contrattiFirmati++; //incremento variabile dei contratti firmati
    }

    /**
     * Metodo per la rimozione di un contatto
     * dall'elenco.
     * @param pos - posizione del contatto indicato
     */
    public void togli(int pos){
        /* spostamento valori successivi
        * alla posizione individuata */
        for(int i=pos+1;i<this.contrattiFirmati;i++)
            this.elenco[i-1]=this.elenco[i];

        this.elenco[this.contrattiFirmati]=null; //cancellazione valore ultima posizione occupata del vettore
        this.contrattiFirmati--; //decremento della variabile dei contratti
    }

    /**
     * Metodo che sfrutta l'algoritmo di ordinamento bubble sort.
     * Vengono utilizzati come attributi di riferimento il nome e il cognome
     * del contatto, in modo da ottenere un elenco in ordine alfabetico.
     * Viene inoltre effettuato un controllo se l'array è gia ordinato,
     * in modo da ridurre il numero di azioni da compiere
     */
    public void ordina(){
        /* dichiarazione variabili
        * utili all'ordinamento */
        boolean scambio; //indica se è avvenuto almeno uno scambio all'interno di un ciclo
        int passaggi=0; //indica quanti passaggi ha compiuto il bubble sort
        Persona temp; //variabile temporanea per lo switch

        do {
            scambio=false; //reinizializzo ogni volta la variabile
            for(int i=0;i<this.contrattiFirmati-passaggi-1;i++){
                /* se il contatto ha un cognome che viene dopo nell'ordine alfabetico,
                * (o il nome, in caso dello stesso cognome) ... */
                if(this.elenco[i].getCognome().compareToIgnoreCase(this.elenco[i+1].getCognome())>0 ||
                    this.elenco[i].getCognome().equalsIgnoreCase(this.elenco[i+1].getCognome()) &&
                        this.elenco[i].getNome().compareToIgnoreCase(this.elenco[i+1].getNome())>0){
                    /* ... si effettua lo scambio tra i contatti */
                    temp=this.elenco[i];
                    this.elenco[i]=this.elenco[i+1];
                    this.elenco[i+1]=temp;

                    scambio=true; //si aggiorna la variabile
                }
            }
            passaggi++; //si incrementa il numero di passaggi fatti
        }while(scambio); //continua se è stata fatta almeno un'operazione, altrimenti vuol dire che è già tutto ordinato
    }

    /**
     * Metodo di ricerca di uno o più contatti
     * in base ai parametri forniti.
     * Viene utilizzato il metodo brute force, perchè si potrebbe
     * ricercare solo per numero di telefono
     *
     * @param nome
     * @param cognome
     * @param telefono
     * @return vettore delle posizioni (o -1 se non ha trovato niente)
     */
    public int[] ricerca(String nome, String cognome, String telefono){
        /* dichiarazione variabili */
        int uguali=0;
        String param1="", param2; //stringhe per il confronto tra due parametri

        if(!nome.isBlank())
            param1+=nome;
        if(!cognome.isBlank())
            param1+=cognome;
        if(!telefono.isBlank())
            param1+=telefono;

        /* scorro tutto l'array in cerca di corrispondenze */
        for(int i=0;i<this.contrattiFirmati;i++){
            param2="";//reinizializzo ogni volta la stringa
            /* pongo delle condizioni per comporre la seconda stringa, basandomi su
            * quali campi sono rimasti vuoti */
            if(!nome.isBlank())
                param2+=this.elenco[i].getNome();
            if(!cognome.isBlank())
                param2+=this.elenco[i].getCognome();
            if(!telefono.isBlank())
                param2+=this.elenco[i].getTelefono();

            /* confronto le due stringhe e vedo se ci sono uguaglianze */
            if(param1.equalsIgnoreCase(param2))
                uguali++;
        }

        /* controllo se ho trovato dei risultati
        * e, in caso affermativo, dichiaro un vettore */
        if(uguali==0)
            return new int[]{-1};

        int[] vetPos = new int[uguali];
        int indexVetPos=0;

        /* scorro nuovamente il valore per cercare
        le posizioni degli oggetti uguali */
        for(int i=0;i<this.contrattiFirmati;i++){
            param2="";//reinizializzo ogni volta la stringa
            /* pongo delle condizioni per comporre la seconda stringa, basandomi su
             * quali campi sono rimasti vuoti */
            if(!nome.isBlank())
                param2+=this.elenco[i].getNome();
            if(!cognome.isBlank())
                param2+=this.elenco[i].getCognome();
            if(!telefono.isBlank())
                param2+=this.elenco[i].getTelefono();

            /* confronto le due stringhe e vedo se ci sono uguaglianze */
            if(param1.equalsIgnoreCase(param2))
                vetPos[indexVetPos++]=i;
        }

        return vetPos; //ritorno l'array di posizioni
    }

    /**
     * Metodo che visualizza la serie di contatti indicati
     * @param vetPos - lista delle posizioni da visualizzare, -1 per visualizzare tutto
     */
    public void visualizza(int[] vetPos){
        /* controllo se esistono dei contratti esistenti */
        if(this.contrattiFirmati==0){
            System.out.println("Nessun contratto ancora firmato");
            return;
        }

        /* se il valore del vettore
        * è -1, vuol dire che devo visualizzare
        * tutti gli elementi dell'array */
        if(vetPos[0]==-1){
            System.out.println("*** ELENCO COMPLETO CONTATTI ***");
            for(int i=0;i<this.contrattiFirmati;i++)
                System.out.println(this.elenco[i].stampa());
        }
        /* altrimenti stampo solo in base al
        vettore di posizioni fornito */
        else{
            System.out.println("*** CONTATTI TROVATI ***");
            for(int i=0;i<vetPos.length;i++)
                System.out.println(this.elenco[vetPos[i]].stampa());
        }
    }
}
