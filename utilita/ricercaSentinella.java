public class ricercaSentinella {
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
}
