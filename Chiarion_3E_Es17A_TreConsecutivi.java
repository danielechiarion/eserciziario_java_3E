//Author: Daniele Chiarion
//Date: 09-02-2024

/* Scrivere un programma TreConsecutivi che prevede un array di 10 numeri interi contenente valori a piacere (senza bisogno di chiederli all’utente)
e stampa "Tre valori consecuitivi uguali" se l’array contiene tre valori uguali in tre posizioni consecutive,
oppure stampa "NO" altrimenti. */
public class Chiarion_3E_Es17A_TreConsecutivi {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int cont=1;
        int indexVet=1; //l'indice del vettore parte a 1 per evitare di avere, durante il ciclo, indici negativi
        /* dichiarazione vettore numeri */
        int[] vet = {0,3,7,7,9,18,54};

        /* fase di calcolo */
        while(cont<3 && indexVet<vet.length)
        {
            if(vet[indexVet]==vet[indexVet-1])
                cont++; //se un numero è uguale al precedente, il contatore incrementa
            else
                cont=1; //se non c'è uguaglianza, il contatore resettato per sicurezza evitando di alterare i risultati

            indexVet++; //incremento dell'indice
        }

        /* output finale */
        if(cont==3)
            System.out.println("Tre valori consecutivi uguali");
        else
            System.out.println("NO");
    }
}
