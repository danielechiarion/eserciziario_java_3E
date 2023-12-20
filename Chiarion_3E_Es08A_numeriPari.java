//Author: Daniele Chiarion
//Date: 18-12-2023

/* scrivi un programma che
visualizza i primi 5 numeri pari
di una sequenza */

public class Chiarion_3E_Es08A_numeriPari {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int cont=0;
        int num=1;

        /* dichiatazione costante */
        final int tot=5;

        while(cont<tot){
            if(num%2==0) {
                System.out.print(num+" ");
                cont++;
            }
            num++;
        }
    }
}
