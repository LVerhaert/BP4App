package com.lizav.bp4app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lizav.bp4app.R;
import com.lizav.bp4app.model.Interesse;

import java.util.ArrayList;

public class InteressesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interesses);

        Bundle bundle = getIntent().getExtras();
        ArrayList<Interesse> interesses = (ArrayList<Interesse>) bundle.getSerializable("intr");

        ArrayList<String> strIntr = new ArrayList<>();
        for (Interesse intr : interesses) {
            strIntr.add(intr.getOnderwerp());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_item_single, strIntr);
        ListView lv = findViewById(R.id.lvInteresses);
        lv.setAdapter(adapter);
    }

}
