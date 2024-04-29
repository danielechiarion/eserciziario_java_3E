package tools;

import java.util.Scanner;

public class utility {
    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait(int x) {
        try {
            Thread.sleep(1000 * x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int menu(String[] opzioni, Scanner keyboard) {
        int scelta;

        do {
            ClrScr();
            System.out.println("=== " + opzioni[0] + " ===");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " " + opzioni[i]);
            }
            try {
                scelta = Integer.parseInt(keyboard.nextLine());
            }catch(Exception e){
                scelta = Integer.parseInt(keyboard.next());
                keyboard.nextLine();
            }
            if (scelta < 1 || scelta > opzioni.length - 1) {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }

    /* metodo che indica il messaggio di errore */
    public static void messaggioErrore(int value) {
        /* switch case per i messaggi di errore */
        switch (value) {
            case 1:
                System.out.println("ERROR! Input out of range");
                break;
            case 2:
                System.out.println("ERROR! Wrong domain");
                break;
            case 3:
                System.out.println("ERROR! All empty data!");
                break;
            case 4:
                System.out.println("This data already exists!");
                break;
            default:
                System.out.println("");
        }
        Wait(3);
        ClrScr();
    }

    /* metodo per l'input sicuro di interi */
    public static int safeIntInput(String testoInput, Scanner scanner){
        /* dichiarazione variabili */
        int input=0;
        boolean check;

        do {
            check=false; //reinizializzo ogni volta la variabile
            /* input dati */
            System.out.println(testoInput);
            try {
                input = scanner.nextInt();
            }catch (Exception e){
                /* messaggio di errore */
                System.out.println("Dominio errato!");
                Wait(3);
                System.out.println("Riprova");
                check=true; //modifico la variabile
                scanner.nextLine();
            }
        }while (check);

        return input; //ritorno valore
    }

    /* metodo per l'input sicuro di interi */
    public static double safeDoubleInput(String testoInput, Scanner scanner){
        /* dichiarazione variabili */
        double input=0;
        boolean check;

        do {
            check=false; //reinizializzo ogni volta la variabile
            /* input dati */
            System.out.println(testoInput);
            try {
                input = scanner.nextDouble();
            }catch (Exception e){
                /* messaggio di errore */
                System.out.println("Dominio errato!");
                Wait(3);
                System.out.println("Riprova");
                check=true; //modifico la variabile
                scanner.nextLine();
            }
        }while (check);

        return input; //ritorno valore
    }
}