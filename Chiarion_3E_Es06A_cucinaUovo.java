//Author: Daniele Chiarion
//Date: 11-12-2023

/* scrivi un programma
che valuti il tempo di attesa nella cottura di un uovo.
E che alla fine dica "uovo pronto" */

import java.util.Scanner;
public class Chiarion_3E_Es06A_cucinaUovo {
    /* creazione metodo wait */
    private static void Wait()
    {
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++)
        {
            System.out.print("°_°");
            Wait();
        }
    }
}
