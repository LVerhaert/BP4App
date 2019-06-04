package com.lizav.bp4app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lizav.bp4app.R;
import com.lizav.bp4app.helper.PersIntr;
import com.lizav.bp4app.model.Persoon;
import com.lizav.bp4app.model.Verzamelingen;

public class PersIntrDetailActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persintr_details);
        Bundle bundle = getIntent().getExtras();
        PersIntr pi = (PersIntr) bundle.getSerializable("pi");
        Verzamelingen verzamelingen = (Verzamelingen) bundle.getSerializable("verz");

        String naam = pi.getNaam();
        Persoon p = verzamelingen.getPersoon(naam);

        TextView tvNaam = findViewById(R.id.detailsNaam);
        TextView tvKoffie = findViewById(R.id.detailsKoffie);
        TextView tvInteresse = findViewById(R.id.detailsInteresse);

        String textNaam = getString(R.string.details_naam).concat(p.getNaam());
        String textKoffieThee = getString(R.string.details_koffiethee).concat(p.koffieTheeToString());
        String textInteresses = getString(R.string.details_interesses).concat(p.interessesToString());

        tvNaam.setText(textNaam);
        tvKoffie.setText(textKoffieThee);
        tvInteresse.setText(textInteresses);
    }
}
