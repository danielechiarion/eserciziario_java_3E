public class ordinamento {
    /* metodo che ordina i contatti
     * utilizzando l'insertion sort */
    public static void ordinaSelection(Contatto[] vet, int contrattiVenduti){
        /* dichiarazione variabili per
         * l'ordinamento */
        Contatto temp; //variabile temporanea per il trasferimento dati

        /* scorro tutti i valori */
        for(int i=0;i<contrattiVenduti-1;i++){
            for(int k=i+1; k<contrattiVenduti;k++){
                /* inizialmente controllo i cognomi e
                 * trovo il minimo.
                 * Altrimenti verifico se, a parità di cognomi, ho nomi differenti */
                if(vet[k].getCognome().compareToIgnoreCase(vet[i].getCognome())<0 || vet[k].getCognome().equalsIgnoreCase(vet[i].getCognome()) && vet[k].getNome().compareToIgnoreCase(vet[i].getNome())<0){
                    /* scambio variabili */
                    temp=vet[i]; //sposto il valore su una variabile temporanea
                    vet[i]=vet[k]; //assegno il minimo
                    vet[k]=temp; //sposto l'altro valore nel vettore
                }
            }
        }
    }
}
