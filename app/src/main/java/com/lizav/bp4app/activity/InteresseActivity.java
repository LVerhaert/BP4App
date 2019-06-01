package com.lizav.bp4app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lizav.bp4app.R;
import com.lizav.bp4app.model.Interesse;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class InteresseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interesses);

        Bundle bundle = getIntent().getExtras();
        ArrayList<Interesse> interesses = (ArrayList<Interesse>) bundle.getSerializable("intr");

        ArrayList<String> strIntr = new ArrayList<>();
        if (interesses != null) {
            for (Interesse intr : interesses) {
                strIntr.add(intr.getOnderwerp());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strIntr);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }

}
