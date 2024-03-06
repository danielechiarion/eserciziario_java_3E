import java.util.Scanner;

public class tryCatch {
    public static void main(String[] args) {
        String ggmmaaaa="12122024";
        int valore1;
        int inputVal;
        boolean error=false;

        Scanner keyboard = new Scanner(System.in);

        /* sollevo il possibile errore */
        try{
            valore1=Integer.parseInt(ggmmaaaa);
        }catch(Exception x)
        {
            System.out.println("Errore: Stringa non valida");
        }

        do {
            System.out.println("Inserisci un valore in input: ");
            try {
                inputVal=keyboard.nextInt();
            }catch(Exception x)
            {
                System.out.println("Valore inserito non valido");
                error=true;
                keyboard.nextLine();
            }
        }while(error);
    }
}
