package com.lizav.bp4app.helper;

import android.os.Parcel;
import android.os.Parcelable;

import com.lizav.bp4app.model.Interesse;
import com.lizav.bp4app.model.Persoon;

public class PersoonInteresse implements Parcelable {
    public static final Creator<PersoonInteresse> CREATOR = new Creator<PersoonInteresse>() {
        @Override
        public PersoonInteresse createFromParcel(Parcel in) {
            return new PersoonInteresse(in);
        }

        @Override
        public PersoonInteresse[] newArray(int size) {
            return new PersoonInteresse[size];
        }
    };

    private String naam;
    private String koffie;
    private String interesse;

    protected PersoonInteresse(Parcel in) {
        this.naam = in.readString();
        this.koffie = in.readString();
        this.interesse = in.readString();
    }

    public PersoonInteresse(Persoon p, Interesse interesse) {
        this.naam = p.getNaam();
        this.koffie = p.isKoffie() ? "koffie" : "thee";
        this.interesse = interesse.getOnderwerp();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getKoffie() {
        return koffie;
    }

    public void setKoffie(String koffie) {
        this.koffie = koffie;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(naam);
        dest.writeString(koffie);
        dest.writeString(interesse);
    }
}
