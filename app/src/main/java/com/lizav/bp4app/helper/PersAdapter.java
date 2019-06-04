package com.lizav.bp4app.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lizav.bp4app.R;

import java.util.ArrayList;

public class PersAdapter extends ArrayAdapter<Pers> {

    public PersAdapter(Context context, ArrayList<Pers> pers) {
        super(context, R.layout.listview_item_double, pers);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Pers p = this.getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_double, parent, false);
        }
        TextView naam = (TextView) view.findViewById(R.id.itemLeft);
        TextView koffieOfThee = (TextView) view.findViewById(R.id.itemRight);
        naam.setText(p.getNaam());
        koffieOfThee.setText(p.getKoffieOfThee());
        return view;
    }

}
