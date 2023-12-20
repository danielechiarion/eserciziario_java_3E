//Author: Daniele Chiarion
//Date: 04-12-2023

/* inserisci una sequenza chiusa da uno 0
e determina se è una sequenza di numeri
calcola anche la frequenza di ogni singola cifra*/

import java.util.Scanner;

public class Chiarion_3E_Es02A_sequenzaNumeri {
    public static void main(String[] args) {
        /* dichiarazione e inizializzazione variabili */
        int cont=0,numero,copia,resto;
        int fr0=0,fr1=0,fr2=0,fr3=0,fr4=0,fr5=0,fr6=0,fr7=0,fr8=0,fr9=0;

        /* creazione scanner */
        Scanner keyboard=new Scanner(System.in);

        /* Inserimento dati input */
        System.out.println("Inserisci una sequenza di numeri: ");
        do {
            numero=keyboard.nextInt();
            copia=numero;
            cont++;

            do {
                resto=copia%10;

                if(resto==0)
                    fr0++;
                    else if(resto==1)
                        fr1++;
                        else if(resto==2)
                            fr2++;
                            else if(resto==3)
                                fr3++;
                                else if(resto==4)
                                    fr4++;
                                    else if(resto==5)
                                        fr5++;
                                        else if(resto==6)
                                            fr6++;
                                            else if(resto==7)
                                                fr7++;
                                                else if(resto==8)
                                                    fr8++;
                                                    else if(resto==9)
                                                        fr9++;
                copia=copia/10;
            }while(copia!=0);

            /* output risultati */
            System.out.println("\n\nNel numero "+numero+":");
            if(fr0!=0)
                System.out.println("La cifra 0 si ripete "+fr0+" volte");
            if(fr1!=0)
                System.out.println("La cifra 1 si ripete "+fr1+" volte");
            if(fr2!=0)
                System.out.println("La cifra 2 si ripete "+fr2+" volte");
            if(fr3!=0)
                System.out.println("La cifra 3 si ripete "+fr3+" volte");
            if(fr4!=0)
                System.out.println("La cifra 4 si ripete "+fr4+" volte");
            if(fr5!=0)
                System.out.println("La cifra 5 si ripete "+fr5+" volte");
            if(fr6!=0)
                System.out.println("La cifra 6 si ripete "+fr6+" volte");
            if(fr7!=0)
                System.out.println("La cifra 7 si ripete "+fr7+" volte");
            if(fr8!=0)
                System.out.println("La cifra 8 si ripete "+fr8+" volte");
            if(fr9!=0)
                System.out.println("La cifra 9 si ripete "+fr9+" volte");

            /* azzeramento variabili */
            fr0=0;
            fr1=0;
            fr2=0;
            fr3=0;
            fr4=0;
            fr5=0;
            fr6=0;
            fr7=0;
            fr8=0;
            fr9=0;
        }while(numero!=0);

        /* output risultati */
        if(cont==1 && numero==0)
            System.out.println("\n\nSequenza vuota");

    }
}
