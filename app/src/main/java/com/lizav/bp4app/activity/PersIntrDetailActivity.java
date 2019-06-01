package com.lizav.bp4app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lizav.bp4app.R;
import com.lizav.bp4app.helper.PersoonInteresse;

public class PersIntrDetailActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persintr_details);
        Intent i = getIntent();
        PersoonInteresse pi = (PersoonInteresse) i.getParcelableExtra("pi");
        TextView tvNaam = findViewById(R.id.tvNaam);
        TextView tvKoffie = findViewById(R.id.tvKoffie);
        TextView tvInteresse = findViewById(R.id.tvInteresse);

        tvNaam.setText(pi.getNaam());
        tvKoffie.setText(pi.getKoffie());
        tvInteresse.setText(pi.getInteresse());
    }
}
