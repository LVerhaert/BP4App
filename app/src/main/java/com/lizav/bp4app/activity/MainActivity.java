package com.lizav.bp4app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lizav.bp4app.R;
import com.lizav.bp4app.model.Bejaarde;
import com.lizav.bp4app.model.Interesse;
import com.lizav.bp4app.model.Verzamelingen;
import com.lizav.bp4app.model.Vrijwilliger;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    private static String URL = "http://10.0.2.2:15574/BP4Data1/webresources/bp4data.bp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Verzamelingen verzamelingen = new Verzamelingen();

        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);

        fillModel(verzamelingen, textView);

        final Button btnIntr = findViewById(R.id.btnIntr);
        btnIntr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(btnIntr.getContext(), InteresseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("intr", verzamelingen.getInteresses());
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        final Button btnPersIntr = findViewById(R.id.btnPersIntr);
        btnPersIntr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(btnPersIntr.getContext(), BejaardeInteresseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("pers", verzamelingen.getBejaarden());
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    private void fillModel(final Verzamelingen verzamelingen, final TextView textView) {
        final RequestQueue queue = Volley.newRequestQueue(this);
        String urlInteresse = URL + "interesse";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlInteresse,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        findInteresses(response, verzamelingen);
                        textView.setText("Interesses geladen. Personen laden...");
                        fillPersonen(verzamelingen, textView, queue);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    private void findInteresses(String response, Verzamelingen verzamelingen) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList interesse = doc.getElementsByTagName("bpInteresses");
            NodeList alInteresses = (interesse.item(0)).getChildNodes();
            ArrayList<Interesse> interesses = new ArrayList<>();
            for (int i = 0; i < alInteresses.getLength(); i++) {
                Node n = alInteresses.item(i);
                Node onderwerp = n.getChildNodes().item(0);
                String strOnderwerp = onderwerp.getTextContent();
                interesses.add(new Interesse(strOnderwerp));
            }
            verzamelingen.setInteresses(interesses);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void fillPersonen(final Verzamelingen verzamelingen, final TextView textView, final RequestQueue queue) {
        String urlPersoon = URL + "persoon";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlPersoon,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        findPersonen(response, verzamelingen);
                        textView.setText("Personen geladen. PersIntr laden...");
                        fillPersonenInteresses(verzamelingen, textView, queue);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    private void findPersonen(String response, Verzamelingen verzamelingen) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList persoon = doc.getElementsByTagName("bpPersoons");
            NodeList alPersonen = (persoon.item(0)).getChildNodes();
            ArrayList<Vrijwilliger> vrijwilligers = new ArrayList<>();
            ArrayList<Bejaarde> bejaarden = new ArrayList<>();
            for (int i = 0; i < alPersonen.getLength(); i++) {
                Node n = alPersonen.item(i);

                Node naam = n.getChildNodes().item(1);
                String strNaam = naam.getTextContent();

                Node soort = n.getChildNodes().item(2);
                String strSoort = soort.getTextContent();

                Node koffieOfThee = n.getChildNodes().item(0);
                boolean boolKoffie = (koffieOfThee.getTextContent().equals("koffie"));

                if (strSoort.equals("vrijwilliger")) {
                    vrijwilligers.add(new Vrijwilliger(strNaam, boolKoffie));
                } else  if (strSoort.equals("bejaarde")) {
                    bejaarden.add(new Bejaarde(strNaam, boolKoffie));
                } else {
                    System.out.println(strNaam + " is geen vrijwilliger of bejaarde..");
                }
            }
            verzamelingen.setVrijwilligers(vrijwilligers);
            verzamelingen.setBejaarden(bejaarden);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void fillPersonenInteresses(final Verzamelingen verzamelingen, final TextView textView, final RequestQueue queue) {
        String urlPersoonInteresse = URL + "persooninteresse";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlPersoonInteresse,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillPersonenInteresses(response, verzamelingen);
                        textView.setText("Laden voltooid.");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    private void fillPersonenInteresses(String response, Verzamelingen verzamelingen) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList persoonInteresse = doc.getElementsByTagName("bpPersoonInteresses");
            NodeList alPersoonInteresses = (persoonInteresse.item(0)).getChildNodes();
            for (int i = 0; i < alPersoonInteresses.getLength(); i++) {
                Node n = alPersoonInteresses.item(i);
                Node persoon = n.getChildNodes().item(2);

                Node naam = persoon.getChildNodes().item(1);
                String strNaam = naam.getTextContent();

                Node interesse = n.getChildNodes().item(1);
                String strInteresse = interesse.getTextContent();

                verzamelingen.getPersoon(strNaam).addInteresse(new Interesse(strInteresse));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
