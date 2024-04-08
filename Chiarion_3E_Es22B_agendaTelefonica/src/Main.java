import static tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE", "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Cambia numero di telefono",
                "Cambia contratto",
                "Fine"};

        final int nMax=3;
        int contrattiVenduti=0;
        int posContatto;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        boolean fine=true;
        do {
            ClrScr();
            switch(menu(operazioni, keyboard)) {
                case 1:
                    /* se ho un numero di contratti inferiore al limite,
                     * permetto il reinserimento del contratto */
                    if(contrattiVenduti<nMax){
                        gestore[contrattiVenduti]=leggiPersona(true, keyboard); //assegno al contatto i valori inseriti
                        /* controllo se il contratto
                        * non è già stato creato */
                        if(checkContratto(gestore[contrattiVenduti].nome, gestore[contrattiVenduti].cognome, gestore, contrattiVenduti)<0)
                            contrattiVenduti++; //incremento l'indice
                        /* altrimenti restituisco un messaggio */
                        else{
                            System.out.println("Contratto già esistente");
                            Wait(5);
                        }
                    }
                    /* altrimenti restituisco un messaggio
                     * di indisponibilità*/
                    else{
                        System.out.println("Gestore telefonico pieno. Non è più possibile inserire numeri");
                        Wait(5);
                    }
                    break;
                case 2:
                    visualizzaContatti(gestore, contrattiVenduti);
                    Wait(5);
                    break;
                case 3:
                    break;
                case 4:
                    posContatto = cercaContatto(gestore, contrattiVenduti, keyboard); //trovo la posizione del contratto
                    /* controllo se il contratto presente e' diverso da
                    * -1, quindi se il contratto esiste */
                    if(posContatto>=0){
                        /* inserimento nuovo
                        numero di telefono */
                        System.out.println("Inserisci il nuovo numero di telefono: ");
                        String nuovoNumero = keyboard.next();
                        gestore[posContatto].telefono=nuovoNumero; //sostuisco il nuovo numero
                    }
                    else //messaggio di errore
                        System.out.println("Contatto non trovato");
                    break;
                case 5:
                    posContatto = cercaContatto(gestore, contrattiVenduti, keyboard); //trovo la posizione del contratto
                    gestore[posContatto]=sceltaTipologia(tipologia, keyboard);
                    break;
                default:
                    fine=false; //cambio valore booleano e esco dal ciclo
            }
        }while(fine);
    }

    /* metodo per prendere in input
     * il numero telefonico della persona */
    private static Contatto leggiPersona(boolean siTel, Scanner keyboard){
        Contatto nuovoContatto = new Contatto(); //dichiarazione oggetto
        /* variabili e vettori per
         * menu della tipologia del telefono */
        String[] tipologia = {"MODALITA' TELEFONO","abitazione", "cellulare", "aziendale"};

        /* input dati */
        ClrScr();
        System.out.println("Inserisci nome ");
        nuovoContatto.nome=keyboard.nextLine().toLowerCase();
        System.out.println("Inserisci cognome ");
        nuovoContatto.cognome=keyboard.nextLine().toLowerCase();

        /* controllo se ha richiesto
         * l'inserimento del numero di telefono */
        if(siTel)
        {
            /* input numero di telefono
             * e tipologia */
            System.out.println("Inserisci il numero di telefono");
            nuovoContatto.telefono=keyboard.nextLine();

            nuovoContatto.tipo=tipoContratto.valueOf(tipologia[sceltaTipologia(tipologia,keyboard)]);
        }
        /* se non è previsto l'inserimento del telefono,
         * assegnamolo a dei valori di default */


        return nuovoContatto;
    }

    /* metodo che sceglie la tipologia
    * di telefono da inserire */
    private static int sceltaTipologia(String[] tipologia, Scanner keyboard){
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
            if(nome.equals(vet[i].nome) && cognome.equals(vet[i].cognome))
                return i;
        }

        return -1; //altrimenti ritorno un valore negativo
    }

    /* metodo per eseguire
    * la ricerca di un contatto */
    private static int cercaContatto(Contatto[] vet, int contrattiVenduti, Scanner keyboard){
        /* dichiarazione variabili */
        String nome, cognome;

        /* controllo se il vettore
        * è vuoto o meno */
        if(contrattiVenduti==0)
            System.out.println("Nessun contratto ancora firmato"); //messaggio di errore
        else{
            /* richiesta inserimento dati input */
            System.out.println("Inserisci nome: ");
            nome = keyboard.nextLine().toLowerCase();
            System.out.println("Inserisci cognome: ");
            cognome=keyboard.nextLine().toLowerCase();

            int pos = checkContratto(nome, cognome, vet, contrattiVenduti);
            /* controllo se
            * ritorna un valore */
            if(pos>=0)
                return pos; //ritorno il vettore di contratti nella posizione trovata
        }

        return -1; //altrimenti non ritorno nulla
    }
}