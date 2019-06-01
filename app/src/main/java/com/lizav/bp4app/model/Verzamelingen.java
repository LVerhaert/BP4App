package com.lizav.bp4app.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Verzamelingen implements Serializable {
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

        for (Object vrw : vrijwilligers) {
            Vrijwilliger vrijwilliger = (Vrijwilliger) vrw;
            if (vrijwilliger.getNaam().equals(naam)) {
                return vrijwilliger;
            }
        }

        for (Object bej : bejaarden) {
            Bejaarde bejaarde = (Bejaarde) bej;
            if (bejaarde.getNaam().equals(naam)) {
                return bejaarde;
            }
        }
        return null;
    }

}
