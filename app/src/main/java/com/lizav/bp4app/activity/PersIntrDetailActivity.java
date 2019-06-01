package com.lizav.bp4app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lizav.bp4app.R;
import com.lizav.bp4app.helper.PersIntrTable;
import com.lizav.bp4app.model.Persoon;
import com.lizav.bp4app.model.Verzamelingen;

public class PersIntrDetailActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persintr_details);
        Bundle bundle = getIntent().getExtras();
        PersIntrTable pi = (PersIntrTable) bundle.getSerializable("pi");
        Verzamelingen verzamelingen = (Verzamelingen) bundle.getSerializable("verz");

        String naam = pi.getNaam();
        Persoon p = verzamelingen.getPersoon(naam);

        TextView tvNaam = findViewById(R.id.detailsNaam);
        TextView tvKoffie = findViewById(R.id.detailsKoffie);
        TextView tvInteresse = findViewById(R.id.detailsInteresse);

        tvNaam.setText(p.getNaam());
        tvKoffie.setText(p.isKoffie() ? "koffie" : "thee");
        tvInteresse.setText(p.interessesToString());
    }
}
