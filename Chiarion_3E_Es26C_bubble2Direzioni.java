
public class Chiarion_3E_Es26C_bubble2Direzioni{

    public static void main(String args[]){
		 int[] vet = {15,6,28,3,1,5,19};
		 
		 bubbleSort(vet);
    }
	
	private static void bubbleSort(int[] array){
        /* dichiarazione variabili */
        boolean stato; //permette di controllare se l'array è gia ordinato
        int temp; //variabile temporanea
        int volteSx=0, volteDx=0; //indica il numero di passaggi nel ciclo

        do {
            stato=false; //reinizializzo ogni volta la variabile
			 if((volteSx+volteDx)%2==0){
			 	/* scorro continuamente l'array, 
             * lasciando escluso gli ultimi valori 
             * già sistemati in precedenza, in quanto già maggiori e ordinati */
            	for(int i=volteSx;i<array.length-volteDx-1;i++){
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
            	volteDx++;
			 }
			 else{
			 	/* scorro continuamente l'array, 
             * lasciando escluso gli ultimi valori 
             * già sistemati in precedenza, in quanto già maggiori e ordinati */
            	for(int i=array.length-1-volteDx;i>volteSx;i--){
                /* ogni volta che viene trovato un valore
                 * maggiore di quello successivo */
                if(array[i]<array[i-1]){
                    /* scambio valori  */
                    temp=array[i-1];
                    array[i-1]=array[i];
                    array[i]=temp;

                    stato=true; //cambia lo stato del vettore
                }
            	}
            	volteSx++;
			 }
			stampaNumeri(array);
        }while(stato); //va avanti fino a quando viene fatta almeno una modifica, altrimenti vuol dire che è già ordinato
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



