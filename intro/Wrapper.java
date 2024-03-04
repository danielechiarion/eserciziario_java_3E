/* versione reference dei tipi primitivi */
public class Wrapper {
    public static void main(String[] args) {
        Boolean vero = true; //un oggetto istanziato, compatibile con il primitivo
        boolean Vero = true;

        //i Boolean ha tanti metodi specifici per quella classe
        if(vero==Vero) {
            System.out.println("Reference e primitivo sono uguali");
            System.out.println("Primitivo = "+Vero);
            System.out.println("Reference = "+vero);
        }

        /*
        * int -> Integer
        * double -> Double
        * float -> Float
        * char -> Character */

        char car='a';
        if(car>='a' && car<='z')
            System.out.println("è un carattere alfabetico");
        else
            System.out.println("Non è un carattere alfabetico");

        car=Character.toUpperCase(car); //converte in maiuscolo
        if(Character.isLetter(car)) //controlla se è alfabetico
            System.out.println("è un carattere alfabetico");
        else
            System.out.println("Non è un carattere alfabetico");

        int valore1;
        Integer valore2;
        String ggmmaaaa = "12122004";
        valore1 = Integer.parseInt(ggmmaaaa);

        System.out.println("Valore: "+valore1);

        valore1=Integer.parseInt("1111", 2); //la base è quella del numero che inserisci
        System.out.println(valore1);
    }
}
