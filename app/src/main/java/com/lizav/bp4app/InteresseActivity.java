package com.lizav.bp4app;

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
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.textView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:15574/BP4Data1/webresources/bp4data.bpinteresse";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        buildItems(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    public void buildItems(String response) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList interesse = doc.getElementsByTagName("bpInteresses");
            NodeList alInteresses = (interesse.item(0)).getChildNodes();
            ArrayList<String> deInteresses = new ArrayList<>();
            for (int i = 0; i < alInteresses.getLength(); i++) {
                Node n = alInteresses.item(i);
                Node name = n.getChildNodes().item(0);
                String strName = name.getTextContent();
                deInteresses.add(strName);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, deInteresses);
//            ListView lv = (ListView) findViewById(R.id.lv);
//            lv.setAdapter(adapter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
