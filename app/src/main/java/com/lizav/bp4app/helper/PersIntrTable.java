package com.lizav.bp4app.helper;

import com.lizav.bp4app.model.Interesse;
import com.lizav.bp4app.model.Persoon;

import java.io.Serializable;

public class PersIntrTable implements Serializable {
    private String naam;
    private String koffieOfThee;
    private String interesse;

    public PersIntrTable(Persoon persoon, Interesse interesse) {
        this.naam = persoon.getNaam();
        this.koffieOfThee = persoon.isKoffie() ? "koffie" : "thee";
        this.interesse = interesse.getOnderwerp();
    }

    public String getNaam() {
        return naam;
    }

    public String getKoffieOfThee() {
        return koffieOfThee;
    }

    public String getInteresse() {
        return interesse;
    }
}
