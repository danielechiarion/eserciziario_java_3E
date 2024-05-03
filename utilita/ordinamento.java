public class ordinamento {
    /**
     * Metodo che compie ordinamento attraverso bubble sort
     * @param array - input array da riordinare
     */
    private static void bubbleSort(int[] array){
        /* dichiarazione variabili */
        boolean stato; //permette di controllare se l'array è gia ordinato
        int temp; //variabile temporanea
        int volte=0; //indica il numero di passaggi nel ciclo

        do {
            stato=false; //reinizializzo ogni volta la variabile
            /* scorro continuamente l'array, 
             * lasciando escluso gli ultimi valori 
             * già sistemati in precedenza, in quanto già maggiori e ordinati */
            for(int i=0;i<array.length-volte-1;i++){
                /* ogni volta che viene trovato un valore
                 * maggiore di quello successivo */
                if(array[i]>array[i+1]){
                    /* scambio valori  */
                    temp=array[i+1];
                    array[i+1]=array[i];
                    array[i]=temp;

                    stato=true; //cambia lo stato del vettore
                }
            }
            volte++;
        }while(stato); //va avanti fino a quando viene fatta almeno una modifica, altrimenti vuol dire che è già ordinato
    }

    /**
     * Algoritmo di ordinamento che sfrutta il 
     * principio del selection sort
     * @param vet - array in input da riordinare
     */
    public static void selectionSort(int[] vet){
        int temp; //dichiarazione variabile temporanea

        /* si scorrono tutti i valori fino al penultimo
         * (per fare un confronto ho bisogno di almeno due valori) */
        for(int i=0;i<vet.length-1;i++){
            /* ogni valore lo confronto con i successivi */
            for(int j=i+1;j<vet.length;j++)
            {
                /* se quello successivo è minore, 
                 * scambio i valori */
                if(vet[j]<vet[i]){
                    temp=vet[i];
                    vet[i]=vet[j];
                    vet[j]=temp;
                }
            }
        }
    }

    /**
     * Metodo di ordinamento che sfrutta il selection sort
     * @param array - array in input da riordinare
     * @return nuovo array ordinato
     */
    private static int[] insertionSort(int[] array){
        int[] newArray = new int[array.length]; //dichiarazione nuovo array
        int pos; //indica la posizione in cui andrà inserito valore per valore

        newArray[0]=array[0]; //assegno al nuovo array il primo valore dell'array dato dall'utente
        /* inserisco tutti gli altri valori */
        for(int i=1;i<array.length;i++){
            pos=0; //inzializzo ogni volta la posizione
            for(int j=0;j<i;j++){
                /* ogni volta che il valore è maggiore di quelli
                 * già inseriti, 
                 * aumenta di posizione */
                if(array[i]>newArray[j])
                    pos++;
            }
            /* se il valore viene aggiunto in coda, 
             * viene semplicemente copiato */
            if(pos==i)
                newArray[i]=array[i];
            /* altrimenti, gli altri valori vengono spostati e
            infine il valore viene inserito */
            else{
                for(int k=i-1;k>=pos;k--)
                    newArray[k+1]=newArray[k];
                newArray[pos]=array[i];
            }
        }

        return newArray; //ritorna l'array ordinato
    }

    /**
     * Algoritmo di ordinamento sfruttante il quick sort
     * @param array - array da riordinare
     */
    private static void quickSort(int[] array){
        /* effettuo subito un controllo
         * se l'array ha almeno un valore, 
         * altrimenti non ha senso riordinare */
        if(array.length<1)
            return;

        /* dichiarazione variabili */
        int pivot=array[array.length-1]; //il pivot viene impostato per convenzione nell'ultima posizione
        int contaMin=0;
        int index1=0, index2=0;

        /* vengono contati quanti numeri sono
         * minori del pivot identificato */
        for(int i=0;i< array.length-1;i++)
            if(array[i]<pivot)
                contaMin++;

        /* vengono così creati due array */
        int[] array1 = new int[contaMin]; //array con numeri minori del pivot
        int[] array2 = new int[array.length-contaMin-1]; //array con numeri maggiori o uguali del pivot

        /* vengono così popolati i vettori  */
        for(int i=0;i< array.length-1;i++){
            if(array[i]<pivot)
                array1[index1++]=array[i];
            else
                array2[index2++]=array[i];
        }

        /* vengono ricorsivamente suddivisi i due vettori */
        quickSort(array1);
        quickSort(array2);

        mergeofQuick(array, array1, array2, pivot); //i valori vengono poi unificati
    }

    /**
     * Metodo che prevede l'unione dei dati 
     * del quick sort
     * @param array - array dove i dati verranno sovrascritti
     * @param array1 - primo array con i numeri minori del pivot
     * @param array2 - secondo array con i numeri maggiori del pivot
     * @param pivot - valore collocato tra il primo e secondo array
     */
    private static void mergeofQuick(int[] array, int[] array1, int[] array2, int pivot){
        int index1=0, index2=0; //dichiarazione degli indici dei due array

        for(int i=0;i<array.length;i++){
            /* vengono copiati prima tutti i valori del
             * primo vettore */
            if(index1<array1.length)
                array[i]=array1[index1++];
            /* poi viene inserito il pivot */
            else if(i==index1)
                array[i]=pivot;
            /* poi vengono copiati tutti i valori
             * del secondo vettore */
            else if(index2< array2.length)
                array[i]=array2[index2++];
        }
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
            if(left[indexLeft]<=right[indexRight]) //se il valore a del primo vettore è minore del secondo
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
}

