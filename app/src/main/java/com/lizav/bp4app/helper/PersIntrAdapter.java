package com.lizav.bp4app.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lizav.bp4app.R;

import java.util.ArrayList;

public class PersIntrAdapter extends ArrayAdapter<PersIntr> {

    public PersIntrAdapter(Context context, ArrayList<PersIntr> persIntrs) {
        super(context, R.layout.listview_item_double, persIntrs);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        PersIntr pi = this.getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_double, parent, false);
        }
        TextView naam = (TextView) view.findViewById(R.id.itemLeft);
        TextView interesse = (TextView) view.findViewById(R.id.itemRight);
        naam.setText(pi.getNaam());
        interesse.setText(pi.getInteresse());
        return view;
    }

}
