public class Main {
    public static void main(String[] args) {
        String linea = "la mamma va al mercato a comprare i pomodori"; //dichiaro una stringa e uso la virgola come carattere separatore
        String[] parole;
        parole = linea.split(" "); //suddivido il vettore utilizzando il separatore

        /* output risultati */
        for(String x : parole)
            System.out.println(x);

        linea="gino,maria,giovanni";
        String[] nomi = linea.split(",");
        /* output risultati */
        for(String x : nomi)
            System.out.println(x);

        linea="la mamma di Martina va al mercato per comperare le fragole per fare la macedonia"; //assegnazione valore stringa
        System.out.println(linea.length()); //output lunghezza
        String[] dueStringhe = marginaStringa(linea); //divisione in due stringhe
        /* output risultati */
        System.out.println("\nSTRINGA 1:");
        System.out.println(dueStringhe[0]);
        System.out.println("\nSTRINGA 2:");
        System.out.println(dueStringhe[1]);
    }

    /* margina stringa */
    private static String[] marginaStringa(String x){
        String[] dueStringhe = {"", ""}; //dichiaro un vettore di due stringhe
        int lunghezza=0; //lunghezza della stringa che incrementa volta per volta
        final int limite = 40; //limite dove si passa all'altra stringa

        String[] frase = x.split(" "); //separo la stringa utilizzando gli spazi

        for(int i=0;i<frase.length;i++)
        {
            lunghezza += frase[i].length(); //ogni volta la lunghezza incrementa
            if(lunghezza<limite) //se la lunghezza e' minore di 40
                dueStringhe[0]+=frase[i]+" "; //ricostruisco la prima stringa
            else
                dueStringhe[1]+=frase[i]+" "; //altrimenti viene inserito il resto nella seconda
        }

        return dueStringhe; //viene ritornato il vettore con due stringhe separate
    }
}