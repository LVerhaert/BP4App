package com.lizav.bp4app.model;

import java.util.ArrayList;

public abstract class Persoon {
    protected String naam;
    protected boolean koffie;
    protected ArrayList<Interesse> interesses;

    protected Persoon(String naam, boolean koffie) {
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

    public void addInteresse(Interesse interesse) {
        interesses.add(interesse);
    }
}
