package com.lizav.bp4app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.lizav.bp4app.R;
import com.lizav.bp4app.helper.Pers;
import com.lizav.bp4app.helper.PersAdapter;
import com.lizav.bp4app.model.Persoon;

import java.util.ArrayList;

public class PersonenActivity extends AppCompatActivity {
    private ArrayList<Persoon> personen;
    private ArrayList<Pers> pers;
    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personen);

        Bundle bundle = getIntent().getExtras();
        personen = (ArrayList<Persoon>) bundle.getSerializable("pers");

        parsePers();
        setAdapter();

    }

    private void setAdapter() {
        PersAdapter persAdapter = new PersAdapter(this, pers);
        listView = findViewById(R.id.lvPersonen);
        listView.setAdapter(persAdapter);
    }

    private void parsePers() {
        pers = new ArrayList<>();
        for (Persoon persoon : personen) {
            Pers p = new Pers(persoon);
            pers.add(p);
        }
    }
}
