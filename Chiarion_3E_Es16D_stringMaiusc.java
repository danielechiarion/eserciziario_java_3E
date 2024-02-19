//Author: Daniele Chiarion
//Date: 19-02-2024

/* realizzare un programma che
* stampi in output solo le stringhe con la lettera maiuscola */

public class Chiarion_3E_Es16D_stringMaiusc {
    public static void main(String[] args) {
        /* dichiarazione vettore stringa */
        String[] disney ={"Pippo", "pluto", "Topolino", "qui", "quo", "Qua"};

        /* output risultati */
        showResult(checkInizialeMaiusc(disney));
    }

    /* metodo che restituisce un vettore
    * con le stringhe che iniziano con la maiuscola */
    private static String[] checkInizialeMaiusc(String[] vet)
    {
        /* dichiarazione vettore maiuscole
        * e relativo indice*/
        String[] maiuscola = new String[vet.length];

        for(int i=0;i<vet.length;i++)
        {
            /* controllo se la stringa inizia con la maiuscola */
            if(vet[i].charAt(0)>='A' && vet[i].charAt(0)<='Z')
            {
                maiuscola[i]=vet[i]; //assegnazione della stringa al vettore maiuscola
            }
        }

        return maiuscola;
    }

    /* metodo che stampa in output le stringhe
    * che iniziano con la maiuscola */
    private static void showResult(String[] vet)
    {
        System.out.println("\nStringhe che iniziano con la lettera maiuscola: ");
        for(int i=0;i<vet.length;i++)
        {
            //stampa le stringhe del vettore se il contenuto non è nullo
            if(vet[i]!=null)
                System.out.println(vet[i]);
        }
    }
}
