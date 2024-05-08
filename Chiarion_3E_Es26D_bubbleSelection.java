/* Realizzare un esercizio in cui un array  viene prima duplicato, poi uno viene ordinato con selection sort,  l'altro con bubble sort.

        Contare il numero di operazioni svolte, tramite un contatore che deve essere stampato alla fine di ognuna delle due esecuzioni.

        Testare con array di lunghezza:
        10
        100
        1000
        10000
        100000
        1000000
        elementi */

import java.util.Scanner;
import java.util.Random;

public class Chiarion_3E_Es26D_bubbleSelection {
    public static void main(String[] args) {
        /* creazione oggetti scanner
        * e random */
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        /* dichiarazione variabili */
        int input;
        int contaBubble, contaSelection;

        /* richiesta inserimento dati input */
        System.out.println("Inserisci quanti numeri vuoi ordinare: ");
        input = scanner.nextInt();

        /* creazione vettori */
        int[] arrayOriginale = new int[input];
        int[] arrayBubble = new int[arrayOriginale.length];
        int[] arraySelection = new int[arrayOriginale.length];

        /* popolazione vettori */
        popolaVettoreRandom(arrayOriginale, random); //popolo l'array originale con numeri casuali
        /* copio i valori negli altri array */
        System.arraycopy(arrayOriginale, 0, arrayBubble, 0, arrayOriginale.length);
        System.arraycopy(arrayOriginale, 0, arraySelection, 0, arrayOriginale.length);
        /* ritorno i valori del vettore originale all'utente */
        stampaNumeri(arrayOriginale, "ARRAY POPOLATO");

        /* ordinamento dei due array con ritorno
        * del numero di operazioni fatte */
        contaBubble = bubbleSort(arrayBubble);
        contaSelection = selectionSort(arraySelection);

        /* output vettori ordinati
        * con numero di operazioni eseguite */
        stampaNumeri(arrayBubble, "BUBBLE SORT");
        System.out.println(contaBubble+" operazioni eseguite");
        stampaNumeri(arraySelection, "SELECTION SORT");
        System.out.println(contaSelection+" operazioni eseguite");
    }

    /* metodo che popola randomicamente
    * il vettore con un range di numeri pari alla
    * lunghezza moltiplicata per 10 */
    private static void popolaVettoreRandom(int[] vet, Random random){
        /* scorro tutto il vettore e lo
        * popolo di numeri casuali.
        * Per ora non mi interessano le ripetizioni */
        for(int i=0;i<vet.length;i++)
            vet[i]=random.nextInt(1,vet.length*10+1);
    }

    /*
     * Metodo che stampa i valori di un vettore
     * in formato tabellare
     */
    private static void stampaNumeri(int[] vet, String text)
    {
        System.out.println(text);
        for(int i=0;i<vet.length;i++)
        {
            System.out.print(vet[i]+"\t");
        }
        System.out.println(); //metto un a capo
    }

    /**
     * Metodo che compie ordinamento attraverso bubble sort
     * @param array - input array da riordinare
     * @return numero di operazioni fatte
     */
    private static int bubbleSort(int[] array){
        int operazioni=0; //conta quante operazioni vengono eseguite

        /* dichiarazione variabili */
        boolean stato; //permette di controllare se l'array è gia ordinato
        int temp; //variabile temporanea
        int volte=0; //indica il numero di passaggi nel ciclo

        do {
            stato=false; //reinizializzo ogni volta la variabile
            operazioni++;
            /* scorro continuamente l'array,
             * lasciando escluso gli ultimi valori
             * già sistemati in precedenza, in quanto già maggiori e ordinati */
            for(int i=0;i<array.length-volte-1;i++){
                /* ogni volta che viene trovato un valore
                 * maggiore di quello successivo */
                operazioni++;
                if(array[i]>array[i+1]){
                    /* scambio valori  */
                    temp=array[i+1];
                    operazioni++;
                    array[i+1]=array[i];
                    operazioni++;
                    array[i]=temp;
                    operazioni++;

                    stato=true; //cambia lo stato del vettore
                    operazioni++;
                }
            }
            volte++;
            operazioni++;
        }while(stato); //va avanti fino a quando viene fatta almeno una modifica, altrimenti vuol dire che è già ordinato

        return operazioni; //ritorno il numero di operazioni contate
    }

    /**
     * Algoritmo di ordinamento che sfrutta il
     * principio del selection sort
     * @param vet - array in input da riordinare
     * @return numero di operazioni fatte
     */
    public static int selectionSort(int[] vet){
        int operazioni=0; //numero di operazioni eseguite
        int temp; //dichiarazione variabile temporanea

        /* si scorrono tutti i valori fino al penultimo
         * (per fare un confronto ho bisogno di almeno due valori) */
        for(int i=0;i<vet.length-1;i++){
            /* ogni valore lo confronto con i successivi */
            for(int j=i+1;j<vet.length;j++)
            {
                operazioni++;
                /* se quello successivo è minore,
                 * scambio i valori */
                if(vet[j]<vet[i]){
                    temp=vet[i];
                    operazioni++;
                    vet[i]=vet[j];
                    operazioni++;
                    vet[j]=temp;
                    operazioni++;
                }
            }
        }

        return operazioni; //ritorno il numero di operazioni
    }
}
