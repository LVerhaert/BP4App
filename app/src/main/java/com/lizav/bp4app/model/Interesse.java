package com.lizav.bp4app.model;

import java.io.Serializable;

public class Interesse implements Serializable {
    String onderwerp;

    public Interesse (String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }
}
