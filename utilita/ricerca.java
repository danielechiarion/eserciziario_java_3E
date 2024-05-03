public class ricerca {
    public static void main(String[] args) {
        String elemento = "Fine";
        String[] operazioni = {"VODAFONE",
                "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Cambia numero di telefono",
                "Cambia contratto",
                "Elimina contratto",
                "Fine"};

        System.out.println(ricercaSentinella(operazioni, elemento));
    }

    /* metodo che utilizza la ricerca con la sentinella.
    * Posizione l'elemento in  ultima posizione.
    * Se ritorna l'ultima posizione, vuol dire che non ha trovato nulla,
    * altrimenti restituisce la posizione */
    private static int ricercaSentinella(Object[] vet, Object elemento){
        /* creo un nuovo vettore e ci copio i valori */
        Object[] vet2 = new Object[vet.length+1];
        System.arraycopy(vet, 0, vet2, 0, vet.length);
        vet2[vet2.length-1]=elemento; //posiziono l'elemento all'ultima posizione

        /* scorro tutti i valori
        * per vedere se l'elemento è corretto */
        for(int i=0;i<vet.length;i++){
            /* se l'elemento e' uguale,
            * ritorno la posizione */
            if(vet[i].equals(elemento))
                return i;
        }

        return vet.length; //altrimenti ritorno l'ultima posizione
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

}
