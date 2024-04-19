import java.util.Scanner;
import java.util.Random;

import static tools.utility.*;

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
                "Fine"};

        /* dichiarazione variabili */
        final int nMax=3;
        final double costoChiamata=1;
        int contrattiVenduti=0;
        int posContatto;
        int scelta;
        Contatto[] gestore = new Contatto[nMax]; //vettore di contratti

        Scanner keyboard = new Scanner(System.in); //creazione scanner

        boolean fine=true;

        do {
            scelta = menu(operazioni, keyboard);
            switch (scelta) {
                case 1:
                    ClrScr();
                    /* se ho un numero di contratti inferiore al limite,
                     * permetto il reinserimento del contratto */
                    if (contrattiVenduti < nMax) {
                        gestore[contrattiVenduti] = leggiPersona(true, keyboard); //assegno al contatto i valori inseriti
                        /* controllo se il contratto
                         * non è già stato creato */
                        if (checkContratto(gestore[contrattiVenduti].getNome(), gestore[contrattiVenduti].getCognome(), gestore, contrattiVenduti) < 0)
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
                    wrongIndexSearch(gestore,contrattiVenduti,keyboard); //invoco il metodo per la ricerca "sbagliata"
                    break;
                default:
                    fine=false;
                    System.out.println("Fine programma");
            }
            Wait(5);
        }while(fine);
    }

    /* metodo che effettua delle ricerche sbagliate dopo
    * un certo numero di volte */
    private static void wrongIndexSearch(Contatto[] gestore, int contrattiVenduti, Scanner scanner){
        /* variabili per il funzionamento del programma */
        int posPrecedente=0; //memorizza la posizione precedente
        int contatore=0; //conta quante posizioni prima di quella errata
        int posErrore; //è il numero di volte estratto generalmente dove visualizzare l'errore
        int posContatto; //indica la posizione del contatto da visualizzare
        char input;

        /* creazione scanner e random */
        Random random = new Random();

        /* prima generazione numero casuale */
        posErrore = random.nextInt(3,6);

        if(contrattiVenduti>0){
            do {
                ClrScr();
                posContatto = cercaContatto(gestore, contrattiVenduti, scanner, false); //normale ricerca contatto

                if(posContatto>=0){
                    /* se non sono nella posizione, di errore,
                     * stampo il risultato corretto */
                    if(contatore<posErrore) {
                        posPrecedente=posContatto; //copio la posizione del contatto nella variabile di memoria
                        contatore++; //incremento il contatore
                    }
                    /* se invece sono giunto
                     * nella posizione di errore */
                    else{
                        posContatto=posPrecedente; //copio il valore della posizione precedente
                        contatore=0; //riazzero il contatore
                        posErrore=random.nextInt(3,6); //riassegno il valore casuale
                    }
                    System.out.println(gestore[posContatto].stampa()); //in entrambi i casi, stampo il contatto
                }
                else
                    System.out.println("Contatto non trovato");

                /* richiesta di ripetizione */
                System.out.println("\nDesideri effettuare una nuova ricerca? Digita S per continuare");
                input = scanner.next().charAt(0);
                scanner.nextLine();
            }while(Character.toUpperCase(input) == 'S'); //ripeto fin quando lo desidera l'utente
        }
        else
            System.out.println("Nessun contratto ancora firmato");
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
}
