package com.lizav.bp4app.helper;

import com.lizav.bp4app.model.Interesse;
import com.lizav.bp4app.model.Persoon;

import java.io.Serializable;

public class Pers implements Serializable {
    private String naam;
    private String koffieOfThee;

    public Pers(Persoon persoon) {
        this.naam = persoon.getNaam();
        this.koffieOfThee = persoon.isKoffie() ? "koffie" : "thee";
    }

    public String getNaam() {
        return naam;
    }

    public String getKoffieOfThee() {
        return koffieOfThee;
    }

}
