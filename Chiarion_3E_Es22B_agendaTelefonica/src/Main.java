import static tools.utility.*;

import java.util.Scanner;
public class Main {
    /* variabili e vettori per
     * menu della tipologia del telefono */
    public static String[] tipologia = {"MODALITA' TELEFONO","abitazione", "cellulare", "aziendale"};
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE",
                "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Cambia numero di telefono",
                "Cambia contratto",
                "Elimina contratto per nome e cognome",
                "Elimina contratto per numero di telefono",
                "Fine"};

        final int nMax=3;
        int contrattiVenduti=0;
        int posContatto;
        int scelta;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        boolean fine=true;
        do {
            scelta=menu(operazioni, keyboard);
            switch(scelta) {
                case 1:
                    ClrScr();
                    /* se ho un numero di contratti inferiore al limite,
                     * permetto il reinserimento del contratto */
                    if(contrattiVenduti<nMax){
                        gestore[contrattiVenduti]=leggiPersona(true, keyboard); //assegno al contatto i valori inseriti
                        /* controllo se il contratto
                        * non è già stato creato */
                        if(checkContratto(gestore[contrattiVenduti].nome, gestore[contrattiVenduti].cognome, gestore, contrattiVenduti)<0)
                            contrattiVenduti++; //incremento l'indice
                        /* altrimenti restituisco un messaggio */
                        else
                            System.out.println("Contratto già esistente");
                    }
                    /* altrimenti restituisco un messaggio
                     * di indisponibilità*/
                    else
                        System.out.println("Gestore telefonico pieno. Non è più possibile inserire numeri");
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
                        gestore[posContatto].telefono=nuovoNumero; //sostuisco il nuovo numero
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
                        gestore[posContatto].tipo=tipoContratto.valueOf(tipologia[sceltaTipologia]); //assegnazione valore
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
                    break;
                default:
                    ClrScr();
                    fine=false; //cambio valore booleano e esco dal ciclo
                    System.out.println("Fine programma");
            }
            Wait(5); //attesa per qualsiasi operazione da compiere
        }while(fine);
    }

    /* metodo per prendere in input
     * il numero telefonico della persona */
    private static Contatto leggiPersona(boolean siTel, Scanner keyboard){
        Contatto nuovoContatto = new Contatto(); //dichiarazione oggetto

        /* input dati */
        ClrScr();
        System.out.println("Inserisci nome ");
        nuovoContatto.nome=keyboard.nextLine();
        System.out.println("Inserisci cognome ");
        nuovoContatto.cognome=keyboard.nextLine();

        /* controllo se ha richiesto
         * l'inserimento del numero di telefono */
        if(siTel)
        {
            /* input numero di telefono
             * e tipologia */
            System.out.println("Inserisci il numero di telefono");
            nuovoContatto.telefono=keyboard.nextLine();

            nuovoContatto.tipo=tipoContratto.valueOf(tipologia[sceltaTipologia(keyboard)]);
        }
        /* se non è previsto l'inserimento del telefono,
         * assegnamolo a dei valori di default */


        return nuovoContatto;
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
            if(nome.equalsIgnoreCase(vet[i].nome.toLowerCase()) && cognome.equalsIgnoreCase(vet[i].cognome.toLowerCase()))
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
            if(tel.equals(vet[i].telefono))
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
}