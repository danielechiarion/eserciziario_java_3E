import java.util.*;

public class Chiarion_3E_Es12A_testaCroce {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        Random casuale = new Random();
        int esito, scelta1, scelta2, risultato;
        String player1="Bego", player2="Chiarion";

        System.out.println(player1+" testa o croce? (0 e 1)");
        scelta1 = keyboard.nextInt();

        if(scelta1==0)
            scelta2=1;
        else
            scelta2=0;

        esito = casuale.nextInt();

        if(esito%2==0)
            risultato=0;
        else
            risultato=1;

        if(risultato==scelta1)
            System.out.println("Vince "+player1);
        else
            System.out.println("Vince "+player2);
    }
}
