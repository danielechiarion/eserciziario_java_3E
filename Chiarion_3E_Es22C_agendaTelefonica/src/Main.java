import static tools.utility.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta=0;
        /* array con le opzioni disponibili */
        String[] opzioni = {"FUNZIONI RUBRICA",
        "Aggiungi contatto",
        "Rimuovi contatto",
        "Ordina rubrica",
        "Cerca contatto",
        "Visualizza rubrica",
        "Fine"};
        /* creazione scanner */
        Scanner scanner = new Scanner(System.in);

        /* se sono alla prima operazione
         * creo la rubrica */
        Rubrica rubrica = initialBoot(scanner);
        do {
            scelta=menu(opzioni,scanner); //input scelta fatta dall'utente
            ClrScr();
            /* suddivido i vari casi */
            switch(scelta){
                /* aggiunta contatto */
                case 1:
                    aggiungiContatto(rubrica, scanner);
                    break;
                /* rimozione contatto */
                case 2:
                    rimuoviContatto(rubrica, scanner);
                    break;
                /* ordinamento rubrica */
                case 3:
                    rubrica.ordina();
                    rubrica.visualizza(new int[]{-1});
                    break;
                /* ricera contatto */
                case 4:
                    ricercaContatto(rubrica, scanner);
                    break;
                /* visualizzazione rubrica completa */
                case 5:
                    rubrica.visualizza(new int[]{-1});
                    break;
                default:
                    System.out.println("Fine programma");
            }
            Wait(5);
            ClrScr();
        }while(scelta!=opzioni.length-1);
    }

    /**
     * Metodo per la creazione iniziale di una rubrica
     * @param scanner
     * @return
     */
    private static Rubrica initialBoot(Scanner scanner){
        /* dichiarazione variabili */
        int maxContatti;
        double ricaricaDefault, tariffa;

        /* input valori */
        do {
            maxContatti=safeIntInput("Inserisci la dimensione della tua rubrica: ", scanner);
            /* possibile messaggio errore */
            if(maxContatti<=0)
                messaggioErrore(1);
        }while(maxContatti<=0);
        do {
            ricaricaDefault=safeDoubleInput("Inserisci la ricarica di default dei contatti: ", scanner);
            /* possibile messaggio errore */
            if(ricaricaDefault<=0)
                messaggioErrore(1);
        }while(ricaricaDefault<=0);
        do {
            tariffa = safeDoubleInput("Inserisci la tariffa mensile del contratto: ", scanner);
            /* possibile messaggio errore */
            if(tariffa<=0)
                messaggioErrore(1);
        }while(tariffa<=0);

        return new Rubrica(maxContatti, ricaricaDefault, tariffa); //ritorno il nuovo oggetto rubrica
    }

    /**
     * Metodo per l'inserimento dei dati base di un contatto
     * (nome, cognome, numero di telefono)
     * @param vetInput - vettore in cui inserire i valori
     * @param ricerca - se è TRUE indica che non è necessario avere tutti i dati
     * @param scanner - per prendere in input i dati
     */
    private static void inputDatiBase(String[] vetInput, boolean ricerca, Scanner scanner){
        /* input dati */
        do {
            do {
                System.out.println("Inserisci il nome");
                vetInput[0]=scanner.nextLine();
            }while(!ricerca && vetInput[0].isBlank()); //vengono applicati controlli mirati per verificare se l'inserimento è necessario
            do {
                System.out.println("Inserisci il cognome");
                vetInput[1]=scanner.nextLine();
            }while(!ricerca && vetInput[1].isBlank());
            do {
                System.out.println("Inserisci il numero di telefono");
                vetInput[2]=scanner.nextLine();
            }while(!ricerca && vetInput[2].isBlank());

            /* possibile errore in caso di mancato compilamento
            * di tutti i dati */
            if(vetInput[0].isBlank() && vetInput[1].isBlank() && vetInput[2].isBlank())
                messaggioErrore(3);
        }while(vetInput[0].isBlank() && vetInput[1].isBlank() && vetInput[2].isBlank()); //controllo finale per verificare se almeno un campo è stato compilato
    }

    /**
     * Metodo per l'aggiunta di un contatto alla rubrica
     * @param rubrica - oggetto considerato
     * @param scanner - per l'input dei dati
     */
    private static void aggiungiContatto(Rubrica rubrica, Scanner scanner){
        /* dichiarazione variabili e vettori */
        String[] datiBase = new String[3];
        String stringaBase, stringaExtra="";
        char input;

        do {
            inputDatiBase(datiBase, false, scanner); //input dei dati base
            if(rubrica.ricerca(datiBase[0], datiBase[1], datiBase[2])[0]>=0)
                messaggioErrore(4);
        }while(rubrica.ricerca(datiBase[0], datiBase[1], datiBase[2])[0]>=0); //controllo se il contatto esiste già

        /* richiesta inserimento dati optional */
        System.out.println("Vuoi inserire altre informazioni? Digita S per confermare");
        input=scanner.next().charAt(0);

        /* se la risposta è affermativa,
        vengono inseriti i dati aggiuntivi */
        if(Character.toUpperCase(input)=='S'){
            System.out.println("Inserisci secondo numero");
            stringaExtra=scanner.next()+",";
            System.out.println("Inserisci email");
            stringaExtra+=scanner.next()+",";
            System.out.println("Inserisci indirizzo");
            stringaExtra+=scanner.next();
        }

        /* creazione stringa con informazioni base
        * e creazione oggetto contatto */
        stringaBase=datiBase[0]+","+datiBase[1]+","+datiBase[2];
        rubrica.aggiungi(stringaBase, stringaExtra);
    }

    /**
     * Metodo per la rimozione di un contatto
     * @param rubrica
     * @param scanner
     */
    private static void rimuoviContatto(Rubrica rubrica, Scanner scanner){
        /* dichiarazione variabili
        * e vettori */
        int[] posizione;
        String[] inputData = new String[3];

        inputDatiBase(inputData, false, scanner); //input dati per la ricerca
        posizione = rubrica.ricerca(inputData[0], inputData[1], inputData[2]); //posizione ottenuta

        /* controllo se esiste il contatto */
        if(posizione[0]<0){
            System.out.println("Contatto non trovato");
            return;
        }

        rubrica.togli(posizione[0]); //rimuovo il contatto
        System.out.println("Contatto eliminato con successo"); //output conferma operazione
    }

    /**
     * Metodo per la ricerca di uno o più contatti
     */
    private static void ricercaContatto(Rubrica rubrica, Scanner scanner){
        /* dichiarazione vettori */
        int[] posizione;
        String[] inputData = new String[3];

        inputDatiBase(inputData, true, scanner); //input valori di ricerca
        posizione = rubrica.ricerca(inputData[0], inputData[1], inputData[2]); //risultati della ricerca

        /* controllo se la ricerca
        * e' andata a buon fine, con i risultati sperati,
        * altrimenti restiuisco un messaggio di errore */
        if(posizione[0]==-1)
            System.out.println("Nessun contatto corrisponde ai criteri di ricerca");
        else
            rubrica.visualizza(posizione);
    }
}
