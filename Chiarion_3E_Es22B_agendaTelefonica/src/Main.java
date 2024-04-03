import static tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE", "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Fine"};

        final int nMax=3;
        int contrattiVenduti=0;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        boolean fine=true;
        do {
            switch(menu(operazioni, keyboard)) {
                case 1:
                    /* se ho un numero di contratti inferiore al limite,
                     * permetto il reinserimento del contratto */
                    if(contrattiVenduti<nMax){
                        gestore[contrattiVenduti]=leggiPersona(true, keyboard); //assegno al contatto i valori inseriti
                        /* controllo se il contratto
                        * non è già stato creato */
                        if(!checkContratto(gestore[contrattiVenduti], gestore, contrattiVenduti))
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
        int scelta;

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

            /* input tipologia */
            scelta=menu(tipologia, keyboard);
            nuovoContatto.tipo=tipoContratto.valueOf(tipologia[scelta]);
        }
        /* se non è previsto l'inserimento del telefono,
         * assegnamolo a dei valori di default */


        return nuovoContatto;
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
    * - TRUE se l'account è già presente
    * - FALSE se non è stato ancora creato */
    private static boolean checkContratto(Contatto contatto, Contatto[] vet, int contrattiVenduti){
        /* scorro tutti i valori */
        for(int i=0;i<contrattiVenduti;i++)
        {
            /* se un contratto corrisponde
            * a quello inserito, ritorno il valore */
            if(contatto.nome.equals(vet[i].nome) && contatto.cognome.equals(vet[i].cognome))
                return true;
        }

        return false; //altrimenti ritorno l'altro valore
    }
}