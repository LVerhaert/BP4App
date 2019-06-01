package com.lizav.bp4app.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Persoon implements Serializable {
    String naam;
    boolean koffie;
    ArrayList<Interesse> interesses;

    Persoon(String naam, boolean koffie) {
        this.naam = naam;
        this.koffie = koffie;
        interesses = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isKoffie() {
        return koffie;
    }

    public void setKoffie(boolean koffie) {
        this.koffie = koffie;
    }

    public ArrayList<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(ArrayList<Interesse> interesses) {
        this.interesses = interesses;
    }

    public String interessesToString() {
        String lijst = "";
        if (!interesses.isEmpty()) {
            lijst = lijst.concat(interesses.get(0).getOnderwerp());
            for (int i = 1; i < interesses.size(); i++) {
                lijst = lijst.concat(", " + interesses.get(i).getOnderwerp());
            }
        }
        return lijst;
    }

    public void addInteresse(Interesse interesse) {
        interesses.add(interesse);
    }
}
