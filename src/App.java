import bean.Bevanda;
import exception.BevandaNonValidaException;
import service.BevandaService;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    BevandaService bevandaService;

    private static void addBevanda(BevandaService bevandaService, Scanner in) {

        Bevanda bevanda = new Bevanda();
        System.out.println("Inserire Codice Bevanda: ");
        bevanda.setCodice(in.next());
        System.out.println("Inserire Nome Bevanda: ");
        bevanda.setBevanda(in.next());
        System.out.println("Inserire Prezzo Bevanda: ");
        bevanda.setPrezzo(in.nextDouble());
        bevandaService.aggiungiBevanda(bevanda);


    }

    private static void showBevande(BevandaService bevandaService) {
        bevandaService.mostraBevande();
    }


    private static void searchBevande(BevandaService bevandaService, Scanner in) throws BevandaNonValidaException {
        System.out.println("Inserire Codice Bevanda da cercare: ");

        bevandaService.getInfoBevanda(in.next());
    }


    public static void main(String[] args) {

        //Inizializzazione
        Scanner in = new Scanner(System.in);
        BevandaService bevandaService = new BevandaService(new ArrayList<>());

        //Stampa del menù
        displayMenu();

        boolean quit = false;
        int menuItem;
        do {
            System.out.println("Scegli una operazione: ");
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1: //Aggiungi una Bevanda
                    addBevanda(bevandaService, in);
                    break;
                case 2: //Mostra Elenco Bevande
                    showBevande(bevandaService);
                    break;
                case 3: //Cerca Bevanda per codice
                    try {
                        searchBevande(bevandaService, in);
                    } catch (BevandaNonValidaException e) {
                        e.getMessage();
                    }
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (!quit);
        System.out.println("Ciao!");
    }

    public static void displayMenu() {
        System.out.println("*****************************");
        System.out.println("** Distributore di bevande **");
        System.out.println("*****************************");
        System.out.println("Seleziona: ");
        System.out.println("1: Aggiungi una Bevanda");
        System.out.println("2: Mostra Elenco Bevande");
        System.out.println("3: Cerca Bevanda per codice");

        System.out.println("---------");
        System.out.println("0: Esci");
    }

}
