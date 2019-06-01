package com.lizav.bp4app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lizav.bp4app.R;
import com.lizav.bp4app.helper.PersIntrAdapter;
import com.lizav.bp4app.helper.PersIntrTable;
import com.lizav.bp4app.model.Interesse;
import com.lizav.bp4app.model.Persoon;
import com.lizav.bp4app.model.Verzamelingen;

import java.util.ArrayList;

public class PersIntrActivity extends AppCompatActivity {

    private ArrayList<Persoon> personen;
    private Verzamelingen verzamelingen;
    private ArrayList<PersIntrTable> persIntrs;
    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persintr);

        Bundle bundle = getIntent().getExtras();
        personen = (ArrayList<Persoon>) bundle.getSerializable("pers");
        verzamelingen = (Verzamelingen) bundle.getSerializable("verz");

        parsePersonen();
        setAdapter();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(view.getContext(), PersIntrDetailActivity.class);
                PersIntrTable pi = (PersIntrTable) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("pi", pi);
                bundle.putSerializable("verz", verzamelingen);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    private void setAdapter() {
        PersIntrAdapter persIntrAdapter = new PersIntrAdapter(this, persIntrs);
        listView = findViewById(R.id.lvInteresses);
        listView.setAdapter(persIntrAdapter);
    }

    private void parsePersonen() {
        persIntrs = new ArrayList<>();
        for (Persoon persoon : personen) {
            for (Interesse interesse : persoon.getInteresses()) {
                PersIntrTable pi = new PersIntrTable(persoon, interesse);
                persIntrs.add(pi);
            }
        }
    }
}
