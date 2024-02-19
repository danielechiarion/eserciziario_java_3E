//Author: Daniele Chiarion
//Date: 19-02-2024

/* realizzare un programma che
* stampi in output solo le stringhe con la lettera maiuscola */

public class Chiarion_3E_Es16D_stringMaiusc {
    public static void main(String[] args) {
        /* dichiarazione vettore stringa */
        String[] disney ={"Pippo", "pluto", "Topolino", "qui", "quo", "Qua"};

        /* output risultati */
        System.out.println("\nStringhe che iniziano con la lettera maiuscola:");
        printInizialeMaiusc(disney);
    }

    /* metodo che stampa le stringhe
    * con la iniziale maiuscola */
    private static void printInizialeMaiusc(String[] vet)
    {
        for(int i=0;i<vet.length;i++)
        {
            if(vet[i].charAt(0)>='A' && vet[i].charAt(0)<='Z')
                System.out.println(vet[i]);
        }
    }
}
