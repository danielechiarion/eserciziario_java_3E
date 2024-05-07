
public class Chiarion_3E_Es26B_ordinamento{
	public static void main(String[] args) {
        /* creazione array di numeri
        * da ordinare */
        int[] vet = {1,2,2,4,3,5,8,7,6,9};
		 int occupato;

        occupato=mergeSort(vet); //ordinamento array

        /* output risultati */
        stampaNumeri(vet, occupato); //array ordinato senza ripetizioni
    }

	/**
     * Algoritmo di ordinamento che impiega il Merge Sort
     * @param array - vettore con valori da riordinare
     */
    public static int mergeSort(int[] array){
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

        intervallo=mergeofMerge(left, right, array); //unisco i valori ottenuti riordinandoli
		 return intervallo;
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
    public static int mergeofMerge(int[] left, int[] right, int[] array){
        int indexLeft=0, indexRight=0, indexArray=0; //dichiarazione degli indici del vettore
		 int contatore=0;

        /* finchè tutti e due gli indici rientrano nella
         * lunghezza dei loro array */
        while(indexLeft<left.length && indexRight<right.length){
			/* nel caso in cui entrambi i valori siano dello stesso tipo (pari o dispari),
            * controllo quale dei due è minore,
            * sennò avrà precedenza il numero dispari */
            if((left[indexLeft]%2!=0 && right[indexRight]%2!=0 || left[indexLeft]%2==0 && right[indexRight]%2==0)
            && left[indexLeft]<right[indexRight] ||
            left[indexLeft]%2!=0 && right[indexRight]%2==0){
				if(indexLeft==0 || indexLeft!=0 && left[indexLeft]!=array[indexArray-1]){
					contatore++;
					array[indexArray++]=left[indexLeft++];
				}
				else
					indexLeft++;
			}
			else{
				if((left[indexLeft]%2!=0 && right[indexRight]%2!=0 || left[indexLeft]%2==0 && right[indexRight]%2==0)
            && left[indexLeft]<right[indexRight] ||
            left[indexLeft]%2!=0 && right[indexRight]%2==0){
				if(indexRight==0 || indexRight!=0 && right[indexRight]!=array[indexArray-1]){
					contatore++;
					array[indexArray++]=right[indexRight++];
				}
				else
					indexRight++;
			}
		}
			
			return contatore;
	}
    /**
     * Metodo che stampa i valori di un vettore
     * in formato tabellare
     * @param vet
     */
    private static void stampaNumeri(int[] vet, int index)
    {
        System.out.println("ARRAY: ");
        for(int i=0;i<index;i++)
        {
            System.out.print(vet[i]+"\t");
        }
        System.out.println(); //metto un a capo
    }
}