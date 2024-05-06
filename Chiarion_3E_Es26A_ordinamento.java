public class Chiarion_3E_Es26A_ordinamento {
    public static void main(String[] args) {
        /* creazione array di numeri
        * da ordinare */
        int[] vet = {1,2,2,4,3,5,8,7,6,9};

        mergeSort(vet); //ordinamento array

        /* output risultati */
        stampaNumeri(vet); //array ordinato
        stampaNumeri(arraySenzaRipetizioni(vet)); //stampa array ordinato senza ripetizioni
    }

    /**
     * Algoritmo di ordinamento che impiega il Merge Sort
     * @param array - vettore con valori da riordinare
     */
    public static void mergeSort(int[] array){
        /* controllo se il vettore ha
         * più di un valore al suo interno,
         * altrimenti termino l'esecuzione */
        if(array.length<=1)
            return;

        int middle = array.length/2; //imposto la separazione del vettore a metà

        /* dichiaro quindi due nuovi array */
        int[] left = new int[middle];
        int[] right = new int[array.length-middle];

        /* copio i valori */
        for(int i=0;i<left.length;i++)
            left[i]=array[i];
        for(int i=middle;i<array.length;i++)
            right[i-middle]=array[i];

        /* dimezzo ricorsivamente gli array,
        fin quando non avrò due elementi per ognuno */
        mergeSort(left);
        mergeSort(right);

        mergeofMerge(left, right, array); //unisco i valori ottenuti riordinandoli
    }

    /* dal momento che è sempre valida la divisione a metà dell'array,
    * andiamo a cambiare le condizioni di unione dell'array
    * al momento del merge. */
    /**
     * Metodo che unisce i valori di due vettori riordinandoli.
     * Metodo associato all'algoritmo di merge sort
     * @param left - primo vettore
     * @param right - secondo vettore
     * @param array - array dove unire i due vettori precedenti
     */
    public static void mergeofMerge(int[] left, int[] right, int[] array){
        int indexLeft=0, indexRight=0, indexArray=0; //dichiarazione degli indici del vettore

        /* finchè tutti e due gli indici rientrano nella
         * lunghezza dei loro array */
        while(indexLeft<left.length && indexRight<right.length){
            /* nel caso in cui entrambi i valori siano dello stesso tipo (pari o dispari),
            * controllo quale dei due è minore,
            * sennò avrà precedenza il numero dispari */
            if((left[indexLeft]%2!=0 && right[indexRight]%2!=0 || left[indexLeft]%2==0 && right[indexRight]%2==0)
            && left[indexLeft]<right[indexRight] ||
            left[indexLeft]%2!=0 && right[indexRight]%2==0)
                array[indexArray++]=left[indexLeft++]; //viene inserito il valore del primo vettore incrementando gli indici
            else
                array[indexArray++]=right[indexRight++]; //viene inserito il valore del secondo vettore incrementando gli indici
        }

        /* vengono copiati i valori rimanenti del primo array,
         * qualora ve ne fossero */
        while(indexLeft<left.length)
            array[indexArray++]=left[indexLeft++];
        /* vengono copiati i valori rimanenti del secondo array,
         * qualora ve ne fossero */
        while(indexRight<right.length)
            array[indexArray++]=right[indexRight++];
    }

    private static int[] arraySenzaRipetizioni(int[] vet){
        int cont=1; //contatore dei numeri non ripetuti

        /* conto quanti numeri diversi nel vettore
        * ci sono */
        for (int i=1;i<vet.length;i++)
        {
            /* prima di incrementare controllo
            * che il numero trovato non sia uguale al precedente */
            if(vet[i]!=vet[i-1])
                cont++;
        }

        /* dopo avre ottenuto il contatore,
        * dichiaro il vettore ed il suo indice*/
        int[] vet2 = new int[cont];
        int indexVet2=0;

        vet2[indexVet2++]=vet[0]; //copio già il primo valore
        /* scorro tutti i valori e
        * ricopio quelli non ripetuti */
        for (int i=1;i<vet.length;i++)
        {
            /* prima di incrementare controllo
             * che il numero trovato non sia uguale al precedente */
            if(vet[i]!=vet[i-1])
                vet2[indexVet2++]=vet[i];
        }

        return vet2; //ritorno il nuovo vettore senza ripetizioni
    }

    /**
     * Metodo che stampa i valori di un vettore
     * in formato tabellare
     * @param vet
     */
    private static void stampaNumeri(int[] vet)
    {
        System.out.println("ARRAY: ");
        for(int i=0;i<vet.length;i++)
        {
            System.out.print(vet[i]+"\t");
        }
        System.out.println(); //metto un a capo
    }
}
