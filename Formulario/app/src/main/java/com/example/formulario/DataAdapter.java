package com.example.formulario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter<Data>  extends BaseAdapter {
    public DataAdapter(SecondWindow secondWindow, int simpleListItem1, ArrayList<String> data) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater shown=LayoutInflater.from(view.getContext());
        View element=shown.inflate(R.layout.list_view_element,parent,false);
        TextView fieldTitle=(TextView) element.findViewById(R.id.fieldTitle);
        TextView fieldValue=(TextView) element.findViewById(R.id.fieldValue);
        return element;
    }
}
