package com.lizav.bp4app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lizav.bp4app.R;
import com.lizav.bp4app.helper.PersoonInteresse;
import com.lizav.bp4app.helper.PersoonInteresseAdapter;
import com.lizav.bp4app.model.Interesse;
import com.lizav.bp4app.model.Persoon;
import com.lizav.bp4app.model.Verzamelingen;

import java.util.ArrayList;

public class BejaardeInteresseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persintr);

        Bundle bundle = getIntent().getExtras();
        ArrayList<Persoon> bejaarden = (ArrayList<Persoon>) bundle.getSerializable("pers");

        ArrayList<PersoonInteresse> persIntrs = new ArrayList<>();
        for (Persoon bejaarde : bejaarden) {
            for (Interesse interesse : bejaarde.getInteresses()) {
                PersoonInteresse pi = new PersoonInteresse(bejaarde, interesse);
                persIntrs.add(pi);
            }
        }

        ListView lv = findViewById(R.id.lv);
        ArrayAdapter<PersoonInteresse> persIntrAdapter = new PersoonInteresseAdapter(this, persIntrs);
        lv.setAdapter(persIntrAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), PersIntrDetailActivity.class);
                PersoonInteresse pi = (PersoonInteresse)parent.getItemAtPosition(position);
                i.putExtra("pi", pi);
                startActivity(i);
            }
        });
    }
}
