package com.lizav.bp4app.model;

import java.util.ArrayList;

public class Verzamelingen {
    private ArrayList<Interesse> interesses;
    private ArrayList<Bejaarde> bejaarden;
    private ArrayList<Vrijwilliger> vrijwilligers;

    public Verzamelingen() {
        interesses = new ArrayList<>();
        bejaarden = new ArrayList<>();
        vrijwilligers = new ArrayList<>();
    }

    public ArrayList<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(ArrayList<Interesse> interesses) {
        this.interesses = interesses;
    }

    public ArrayList<Bejaarde> getBejaarden() {
        return bejaarden;
    }

    public void setBejaarden(ArrayList<Bejaarde> bejaarden) {
        this.bejaarden = bejaarden;
    }

    public ArrayList<Vrijwilliger> getVrijwilligers() {
        return vrijwilligers;
    }

    public void setVrijwilligers(ArrayList<Vrijwilliger> vrijwilligers) {
        this.vrijwilligers = vrijwilligers;
    }

    public Persoon getPersoon(String naam) {
        for (Vrijwilliger vrijwilliger : vrijwilligers) {
//            System.out.println("Checking " + naam + " with vrijwilliger " + vrijwilliger.getNaam());
            if (vrijwilliger.getNaam().equals(naam)) {
                return vrijwilliger;
            }
        }
        for (Bejaarde bejaarde : bejaarden) {
//            System.out.println("Checking " + naam + " with bejaarde " + bejaarde.getNaam());
            if (bejaarde.getNaam().equals(naam)) {
                return bejaarde;
            }
        }
        return null;
    }
}
