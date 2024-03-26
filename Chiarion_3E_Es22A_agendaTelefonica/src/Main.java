import static tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE", "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Fine"};

        final int nMax=3;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        boolean fine=true;
        do {
            switch(menu(operazioni, keyboard)) {
                case 1->{}
                case 2->{}
                case 3->{}
                default-> fine=false;
            }
        }while(fine);
    }
}