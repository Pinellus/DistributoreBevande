package service;

import bean.Bevanda;
import exception.BevandaNonValidaException;

import java.util.ArrayList;
import java.util.Arrays;

public class BevandaService {

    //Costruttore di classe
    public BevandaService(ArrayList<Bevanda> bevande) {
        this.bevande = bevande;
    }

    private ArrayList<Bevanda> bevande;


    public void aggiungiBevanda(Bevanda bevanda) {

        this.bevande.add(bevanda);

    }

    public void getInfoBevanda(String codice) throws BevandaNonValidaException {
        boolean flag = true;

        for(Bevanda bevanda : this.bevande) {
            if (bevanda.getCodice().equals(codice)) {
                printBevanda(bevanda);
                flag = false;
            }
            if(flag) {
                throw new BevandaNonValidaException("Bevanda non presente in elenco");
            }
        }
    }


    public void mostraBevande() {

        for(Bevanda bevanda : this.bevande) {
            printBevanda(bevanda);
        }
    }

    private void printBevanda(Bevanda bevanda) {
        System.out.println(bevanda.getCodice() + " - " + bevanda.getBevanda() + " - " + bevanda.getPrezzo());
    }

}
