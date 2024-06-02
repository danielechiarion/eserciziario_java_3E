import static tools.utility.*;

import java.util.Scanner;
import java.io.*;

public class Main {
    /* variabili e vettori per
     * menu della tipologia del telefono */
    public static String[] tipologia = {"MODALITA' TELEFONO","abitazione", "cellulare", "aziendale"};

    public static void main(String[] args) {
        /* opzioni possibili per
        * il gestore della vodafone */
        String[] operazioni = {"VODAFONE",
                "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Cambia numero di telefono",
                "Cambia contratto",
                "Elimina contratto per nome e cognome",
                "Elimina contratto per numero di telefono",
                "Ordina rubrica",
                "Effettua telefonata",
                "Ricarica telefono",
                "Chiama",
                "Registro chiamate",
                "Salva file",
                "Importa da file",
                "Fine"};

        final String inputCSVRegistro="registro_"; //indico la prima parte del nome del file obbligatoria per un file di registro
        
        /* dichiarazione variabili */
        final int nMax=7;
        final double costoChiamata=1;
        int contrattiVenduti=0;
        int posContatto;
        int scelta;
        Contatto[] gestore = new Contatto[nMax]; //vettore di contratti
        Chiamata[] registroChiamate = null;
        String percorso="";

        Scanner keyboard = new Scanner(System.in); //creazione scanner

        boolean fine=true;
        do {
            scelta=menu(operazioni, keyboard);
            switch(scelta) {
                case 1:
                    ClrScr();
                    /* se ho un numero di contratti inferiore al limite,
                     * permetto il reinserimento del contratto */
                    if(contrattiVenduti< gestore.length){
                        gestore[contrattiVenduti]=leggiPersona(true, keyboard); //assegno al contatto i valori inseriti
                        /* controllo se il contratto
                        * non è già stato creato */
                        if(checkContratto(gestore[contrattiVenduti].getNome(), gestore[contrattiVenduti].getCognome(), gestore, contrattiVenduti)<0)
                            contrattiVenduti++; //incremento l'indice
                        /* altrimenti restituisco un messaggio */
                        else
                            System.out.println("Contratto già esistente");
                    }
                    /* altrimenti restituisco un messaggio
                     * di indisponibilità, quindi
                     * chiedo se vuole salvarlo su file e
                     * e quindi recuperare il dato */
                    else{
                        System.out.println("Gestore telefonico pieno. Vuoi inserire un nuovo contatto? Digita SI per continuare");
                        String risposta = keyboard.next().toUpperCase();
                        keyboard.nextLine();
                        if(risposta.equals("SI")){
                            Contatto contatto = leggiPersona(true, keyboard); //creo contatto

                            /* ricavo il percorso e poi scrivo su file */
                            percorso = fileSave.scegliFile(fileSave.leggiFileDirectory(inputCSVRegistro), keyboard);
                            try {
                                fileSave.appendFile(contatto.toString(), percorso);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            /* alla fine ricavo ogni volta l'array di contatti */
                            /* legge il contenuto del file */
                            try {
                                fileSave.scriviNContatti(percorso, contrattiVenduti+1, gestore); //riscrivo il file con la dimensione
                                fileSave.appendFile(contatto.toString(), percorso); //aggiungo in coda l'ultimo elemento
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;
                case 2:
                    ClrScr();
                    visualizzaContatti(gestore, contrattiVenduti);
                    break;
                case 3:
                    ClrScr();
                    /* ricerca contatto */
                    posContatto=cercaContatto(gestore, contrattiVenduti, keyboard, false);
                    /* output differenziato */
                    if(posContatto>=0) //se il contatto è stato trovato
                        System.out.println(gestore[posContatto].stampa()); //stampa le informazioni del contratto
                    else
                        System.out.println("Contratto non trovato"); //altrimenti riporto messaggio di errore
                    break;
                case 4:
                    ClrScr();
                    posContatto = cercaContatto(gestore, contrattiVenduti, keyboard, false); //trovo la posizione del contratto
                    /* controllo se il contratto presente e' diverso da
                    * -1, quindi se il contratto esiste */
                    if(posContatto>=0){
                        /* inserimento nuovo
                        numero di telefono */
                        System.out.println("Inserisci il nuovo numero di telefono: ");
                        String nuovoNumero = keyboard.next();
                        gestore[posContatto].setTelefono(nuovoNumero); //sostuisco il nuovo numero
                    }else if(contrattiVenduti>0)
                        System.out.println("Contratto non trovato");
                    break;
                case 5:
                    ClrScr();
                    posContatto = cercaContatto(gestore, contrattiVenduti, keyboard, false); //trovo la posizione del contratto
                    /* controllo se il contratto presente e' diverso da
                     * -1, quindi se il contratto esiste */
                    if(posContatto>=0){
                        int sceltaTipologia=sceltaTipologia(keyboard); //ricerca valore
                        gestore[posContatto].setTipo(tipoContratto.valueOf(tipologia[sceltaTipologia])); //assegnazione valore
                    }
                    else if(contrattiVenduti>0)
                        System.out.println("Contratto non trovato");
                    break;
                case 6,7:
                    ClrScr();
                    /* verifico se ricercare per nome e cognome
                    * o per telefono */
                    if(scelta==6)
                        posContatto = cercaContatto(gestore, contrattiVenduti, keyboard, false); //ricerca posizione contratto
                    else
                        posContatto = cercaContatto(gestore, contrattiVenduti, keyboard, true); //ricerca posizione contratto

                    /* se la posizione non è numero negativo,
                    * è stato trovato il contatto */
                    if(posContatto>=0){
                        cancellaPosArray(posContatto, contrattiVenduti, gestore); //cancello l'elemento nell'array
                        contrattiVenduti--; //diminuisco il numero di contratti vendutiù
                        System.out.println("Contatto eliminato con successo"); //output di operazione riuscita
                    }
                    /* possibile messaggio di errore */
                    else
                        System.out.println("Contatto non trovato");
                    break;
                case 8:
                    ClrScr();
                    int[] copia = copiaArrayOrdinata(gestore, contrattiVenduti); //ordino vettore
                    visualizzaContatti(gestore, contrattiVenduti); //visualizzo risultato in output
                    Wait(5);
                    break;
                case 9:
                    posContatto=cercaContatto(gestore, contrattiVenduti, keyboard, false); //ricerca contatto

                    System.out.println("Il costo per ogni chiamata e' di "+costoChiamata+"€"); //info costo chiamata
                    /* se l'utente ha ancora contante disponibile,
                    * effettuo la chiamata */
                    if(contrattiVenduti>0  && posContatto>0 && gestore[posContatto].getRicarica()>=costoChiamata){
                        gestore[posContatto].setRicarica(-costoChiamata); //sottrazione importo
                        System.out.println("Il saldo rimasto e' di "+gestore[posContatto].getRicarica()+"€");
                    }
                    /* altrimenti restituisco un messaggio
                    * di saldo insufficiente */
                    else if(contrattiVenduti>0)
                        System.out.println("Non hai saldo sufficiente per effettuare una chiamata. Effettua una ricarica");
                    break;
                case 10:
                    boolean check; //valore booleano per controllare se il valore inserito e' corretto
                    double importo=0; //valore per ricaricare la carta

                    posContatto=cercaContatto(gestore, contrattiVenduti, keyboard, false); //ricerca contatto

                    do {
                        check=false;
                        try{
                            System.out.println("Di quanto vuoi ricaricare la carta?");
                            importo = keyboard.nextDouble();
                        }catch(Exception e){
                            messaggioErrore(2);
                            check=true;
                        }
                        if(!check && importo<0){
                            messaggioErrore(1);
                            check=true;
                        }
                    }while(check);

                    gestore[posContatto].setRicarica(importo); //impostazione saldo
                    System.out.println("Il saldo attuale del tuo telefono e': "+gestore[posContatto].getRicarica()+"€"); //output risultati
                    break;
                case 11:
                     Chiamata chiamata=effettuaChiamata(gestore, contrattiVenduti, keyboard);
                     if(chiamata!=null){
                         registroChiamate=aggiungiPosArray(registroChiamate);
                         registroChiamate[registroChiamate.length-1]=chiamata;
                         try {
                             fileSave.appendFile(chiamata.toCSV(), inputCSVRegistro+percorso);
                         } catch (IOException e) {
                             throw new RuntimeException(e);
                         }
                     }
                    break;
                case 12:
                    visualizzaChiamate(gestore, contrattiVenduti, registroChiamate, keyboard);
                    break;
                case 13:
                    /* richiede inserimento nome file */
                    System.out.println("Inserisci nome file ");
                    String nome = keyboard.next();

                    try {
                        fileSave.scriviNContatti(nome, contrattiVenduti, gestore);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                /* scelta file da cui prendere i dati */
                case 14:
                    percorso = fileSave.scegliFile(fileSave.leggiFileDirectory(inputCSVRegistro), keyboard); //ricavo il percorso

                    /* legge il contenuto del file */
                    try {
                        gestore = fileSave.leggiNContatti(percorso);
                        contrattiVenduti=gestore.length;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        registroChiamate=Chiamata.parseCSV(inputCSVRegistro+percorso); //prendo anche i dati delle chiamate
                    } catch (IOException e) {
                        registroChiamate=null;
                    }
                    break;
                default:
                    fine=false; //cambio valore booleano e esco dal ciclo
                    System.out.println("Fine programma");
            }
            Wait(5); //attesa per qualsiasi operazione da compiere
        }while(fine);
    }

    /* metodo per prendere in input
     * il numero telefonico della persona */
    private static Contatto leggiPersona(boolean siTel, Scanner keyboard){
        /* dichiarazione variabili
        * e assegnamento di valori di default */
        String nome, cognome;
        String telefono="//";
        tipoContratto tipo = tipoContratto.undefined;

        /* input dati */
        ClrScr();
        System.out.println("Inserisci nome ");
        nome=keyboard.nextLine();
        System.out.println("Inserisci cognome ");
        cognome=keyboard.nextLine();

        /* controllo se ha richiesto
         * l'inserimento del numero di telefono */
        if(siTel)
        {
            /* input numero di telefono
             * e tipologia */
            System.out.println("Inserisci il numero di telefono");
            telefono=keyboard.nextLine();

            tipo=tipoContratto.valueOf(tipologia[sceltaTipologia(keyboard)]);
        }


        return new Contatto(nome, cognome, telefono, tipo); //ritorno il nuovo oggetto creato
    }

    /* metodo che sceglie la tipologia
    * di telefono da inserire */
    private static int sceltaTipologia(Scanner keyboard){
        int scelta;

        /* input tipologia */
        scelta=menu(tipologia, keyboard);

        return scelta;
    }

    /* metodo che stampa in output
     * che visualizza tutti i contatti */
    private static void visualizzaContatti(Contatto[] vet, int nContratti){
        ClrScr();

        /* controllo se hanno
         * stipulato contratti */
        if(nContratti>0){
            for(int i=0;i<nContratti;i++)
                System.out.println(vet[i].stampa()); //stampo i contatti
        }
        /* altrimenti restituisco un
         * messaggio di errore */
        else
            System.out.println("Nessun contratto è stato ancora firmato per oggi");
    }

    /* metodo che controlla se
    * il contratto inserito e' già presente. Ritorna:
    * - l'indice del valore trovato
    * - -1 se il contatto non è stato trovato*/
    private static int checkContratto(String nome, String cognome, Contatto[] vet, int contrattiVenduti){
        /* scorro tutti i valori */
        for(int i=0;i<contrattiVenduti;i++)
        {
            /* se un contratto corrisponde
            * a quello inserito, ritorno il valore */
            if(nome.equalsIgnoreCase(vet[i].getNome()) && cognome.equalsIgnoreCase(vet[i].getCognome()))
                return i;
        }

        return -1; //altrimenti ritorno un valore negativo
    }

    /* metodo che trova il contatto
    * utilizzando il numero di telefono */
    private static int trovaTel(String tel, Contatto[] vet, int contrattiVenduti){
        /* scorro tutti i valori */
        for(int i=0;i<contrattiVenduti;i++)
        {
            /* se un contratto corrisponde
             * a quello inserito, ritorno il valore */
            if(tel.equals(vet[i].getTelefono()))
                return i;
        }

        return -1; //altrimenti ritorno un valore negativo
    }

    /* metodo per eseguire
    * la ricerca di un contatto.
    * Si mette cercaTel a TRUE per cercare utilizzando il telefono
    * Si mette cercaTel a FALSE per eseguire la classica ricerca per nome o cognome */
    private static int cercaContatto(Contatto[] vet, int contrattiVenduti, Scanner keyboard, boolean cercaTel){
        /* dichiarazione variabili */
        String nome, cognome, telefono;
        int pos;

        /* controllo se il vettore
        * è vuoto o meno */
        if(contrattiVenduti==0)
            System.out.println("Nessun contratto ancora firmato"); //messaggio di errore
        else{
            if(!cercaTel){ //se si cerca contratto per nome e cognome
                /* richiesta inserimento dati input */
                System.out.println("Inserisci nome: ");
                nome = keyboard.nextLine();
                System.out.println("Inserisci cognome: ");
                cognome=keyboard.nextLine();

                pos = checkContratto(nome, cognome, vet, contrattiVenduti); //trovo la posizione del contratto
            }
            else { //ricerca contatto per numero di telefono
                /* richiesta inserimento dati input */
                System.out.println("Inserisci il numero di telefono: ");
                telefono=keyboard.nextLine();

                pos=trovaTel(telefono, vet, contrattiVenduti); //trovo la posizione del contatto
            }
            /* controllo se il valore ritornato è
            * effettivamente una posizione */
            if(pos>=0)
                return pos; //ritorno il vettore di contratti nella posizione trovata
        }

        return -1; //altrimenti non ritorno nulla
    }

    /* metodo che cancella
    * la posizione di un array */
    private static void cancellaPosArray(int pos, int contratti, Contatto[] gestore){
        /* avvio ciclo che,
        * partendo dalla posizione subito dopo il contratto trovato,
        * scorre tutti i valori a sinistra */
        for(int i=pos+1;i<contratti;i++)
            gestore[i-1]=gestore[i];

        /* se la posizione e' l'ultima,
        * cancello semplicemente il valore */
        if(pos==contratti-1)
            gestore[pos]=null;
    }

    /* metoodo che effettua una chiamata e lo aggiunge
    * all'array */
    private static Chiamata effettuaChiamata(Contatto[] rubrica, int contrattiVenduti, Scanner scanner){
        int pos = cercaContatto(rubrica, contrattiVenduti, scanner, false); //effettuo ricerca per nome e cognome

        /* vedo se è stato trovato il contatto,
        * altrimenti restituisco un messaggio di errore */
        if(pos<0){
            System.out.println("Contatto non trovato");
            return null;
        }

        /* altrimenti creo la chiamata e la visualizzo */
        Chiamata chiamata = new Chiamata(rubrica[pos].getTelefono());
        System.out.println(chiamata.toString());

        return chiamata;
    }

    /* metodo che visualizza il registro chiamate di un
    * contatto specifico */
    public static void visualizzaChiamate(Contatto[] rubrica, int contrattiVenduti, Chiamata[] registro, Scanner scanner){
        int pos = cercaContatto(rubrica, contrattiVenduti, scanner, true); //ricerco il contatto per telefono

        /* controllo se il contatto è stato effettivamente trovato,
        * altrimenti restituisco un messaggio di errore */
        if(pos<0){
            System.out.println("Nessun contatto trovato");
            return;
        }
        if(registro==null)
            return;

        /* se il contatto è stato trovato mostro tutti
        * i contatti che hanno lo stesso numero di telefono */
        for(int i=0;i<registro.length;i++){
            if(registro[i]!=null && registro[i].numero.equals(rubrica[pos].getTelefono()))
                System.out.println(registro[i].toString());
        }
    }

    /* metodo che ordina i contatti,
    * generando una copia del vettore e restituendola ordinata */
    private static int[] copiaArrayOrdinata(Contatto[] vet, int contrattiVenduti){
        /* creazione di una copia dell'array */
        int[] copia = new int[vet.length];
        System.arraycopy(vet, 0, copia, 0, contrattiVenduti);

        ordinamento.ordinaSelection(vet, contrattiVenduti); //ordina una copia dell'array ordinato

        return copia; //ritorna una copia dell'array ordinato
    }


    /* metodo che conta quanti contratti sono stati già fatti */
    private static int contaContratti(Contatto[] gestore){
        int contatore=0;

        for(int i=0;i<gestore.length && gestore[i]!=null;i++)
            contatore++;

        return contatore;
    }

    /* metodo che aggiunge una posizione ad un array */
    public static Chiamata[] aggiungiPosArray(Chiamata[] array){
        /* se l'array è nullo ritorno un vettore
         * con posizione uno */
        if(array==null)
            return new Chiamata[1];

        /* altrimenti creo un nuovo array dove ha
         * lunghezza maggiore di 1
         * e dovo copio gli altri dati presenti */
        Chiamata[] array2 = new Chiamata[array.length+1];
        System.arraycopy(array, 0, array2, 0, array.length);

        return array2; //ritorno il nuovo array
    }
}