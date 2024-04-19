import java.util.Scanner;

public class Chiarion_3E_Es24B_ricercaOrdinamento {
    public static void main(String[] args) {
        /* dichiarazione variabile */
        int spartiAcque; //variabile di separazione tra pari e dispari
        int dimensione; //indica la lunghezza dell'array
        int numeroRicerca, posNumero;

        /* creazione scanner */
        Scanner scanner = new Scanner(System.in);

        /* input valori */
        System.out.println("Quanti numeri vuoi inserire? ");
        dimensione = scanner.nextInt(); //chiedo dimensione vettore

        int[] vet = new int[dimensione]; //creo il vettore con la dimensione apposita

        /* ciclo di inserimento numeri */
        System.out.println("Inserisci la sequenza di numeri separata da uno spazio");
        for(int i=0;i<vet.length;i++)
            vet[i]=scanner.nextInt();

        /* ORDINAMENTO VETTORE */
        spartiAcque=evenOddSearch(vet); //riordino il vettore
        stampaNumeri(vet); //output risultati

        /* RICERCA NUMERO */
        /* input dati */
        System.out.println("\nInserisci numero: ");
        numeroRicerca=scanner.nextInt();

        posNumero=biBinarySearch(vet, numeroRicerca, spartiAcque);

        /* output risultati */
        if(posNumero>=0)
            System.out.println("Il valore si trova nella posizione "+posNumero);
        else
            System.out.println("Numero non trovato");
    }

    private static int evenOddSearch(int[] vet){
        /* dichiarazione variabili */
        int contaPari=0;
        int indexPari=0, indexDispari=0; //indici dei vettori che andremo a creare

        /* cerco quanti numeri pari ci sono */
        for(int i=0;i<vet.length;i++)
            if(vet[i]%2==0)
                contaPari++;

        /* creazione vettori */
        int[] vetPari = new int[contaPari];
        int[] vetDispari = new int[vet.length-contaPari];

        /* popolo i vettori */
        for(int i=0;i<vet.length;i++)
        {
            if(vet[i]%2==0){ //se è pari
                vetPari[indexPari]=vet[i]; //assegno il valore al vettore
                indexPari++; //incremento l'indice
            }
            else{ //se è dispari
                vetDispari[indexDispari]=vet[i];
                indexDispari++;
            }
        }

        /* ordino i singoli vettori */
        ordinaNumeri(vetPari);
        ordinaNumeri(vetDispari);

        /* ripopolo il vettore originario ordinato */
        /* ordino il vettore dei numeri pari
        * in ordine crescente */
        for(int i=0;i<vetPari.length;i++)
            vet[i]=vetPari[i];

        /* ordino il vettore dei numeri dispari
         * in ordine decrescente */
        for(int i=vetDispari.length-1;i>=0;i--)
            vet[vet.length-1-i]=vetDispari[i];

        return contaPari; //ritorno lo spartiacque tra numeri pari e numeri dispari
    }

    /* metodo che ordina i numeri interi
     * utilizzando l'insertion sort */
    private static void ordinaNumeri(int[] vet){
        /* dichiarazione variabili per
         * l'ordinamento */
        int temp; //variabile temporanea per il trasferimento dati

        /* scorro tutti i valori. Mettendo il minimo
        * alla prima posizione,
        * verrà in seguito trascurato*/
        for(int i=0;i<vet.length-1;i++){
            for(int k=i+1; k< vet.length;k++){
                /* trovo il minimo numero ogni volta
                * fino ad arrivare alla fine */
                if(vet[k]<vet[i]){
                    /* scambio variabili */
                    temp=vet[i]; //sposto il valore su una variabile temporanea
                    vet[i]=vet[k]; //assegno il minimo
                    vet[k]=temp; //sposto l'altro valore nel vettore
                }
            }
        }
    }

    /* metodo che cerca un numero sfruttando
    la ricerca dicotomica */
    private static int biBinarySearch(int[] vet, int numeroRicerca, int spartiAcque)
    {
        /* dichiarazione variabili */
        int start, limite, index;

        /* controllo già se il numero e' pari o dispari,
        * così da ridurre il campo di ricerca */
        if(numeroRicerca%2==0)
        {
            start=0;
            limite=spartiAcque;
            index=spartiAcque/2;
        }
        else{
            start=spartiAcque+1;
            limite=vet.length-1;
            index=(start+limite)/2;
        }

        /* comincio la ricerca, compiendola solo se
        * il valore non è già ciò che voglio e se
        * start e limite sono diversi */
        while(vet[index]!=numeroRicerca && vet[start]!=numeroRicerca && vet[limite]!=numeroRicerca && start<=limite){
            /* se il numero è minore di
            * quello richiesto, mi sposto a sinistra,
            * quindi modifico il limite */
            if(numeroRicerca<vet[index] && numeroRicerca%2==0 || numeroRicerca>vet[index] && numeroRicerca%2!=0)
            {
                limite=index-1;
                index=(start+limite)/2;
            }
            /* se il numero è maggiore
            * di quello richiesto, mi sposto a destra,
            * quindi modifico lo start */
            else if(numeroRicerca>vet[index] && numeroRicerca%2==0 || numeroRicerca<vet[index] && numeroRicerca%2!=0)
            {
                start=index+1;
                index=(start+limite)/2;
            }
        }

        /* controllo se il valore ottenuto
        * e' corretto */
        if(vet[index]==numeroRicerca)
            return index;
        else if(vet[start]==numeroRicerca)
            return start;
        else if(vet[limite]==numeroRicerca)
            return limite;
        else
            return -1;
    }

    /* metodo per l'output dei numeri
    * all'interno di un vettore */
    private static void stampaNumeri(int[] vet)
    {
        System.out.println("VETTORE: ");
        for(int i=0;i<vet.length;i++)
        {
            System.out.print(vet[i]+"\t");
        }
    }
}
