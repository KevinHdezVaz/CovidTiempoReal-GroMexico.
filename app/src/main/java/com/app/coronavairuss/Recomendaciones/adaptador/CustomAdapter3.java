package com.app.coronavairuss.Recomendaciones.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.coronavairuss.R;

import java.util.ArrayList;

public class CustomAdapter3 extends BaseAdapter {

    private Context context;
    private ArrayList<lista2> listItem;


    public CustomAdapter3(Context context, ArrayList<lista2> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        lista2 Item =(lista2)getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.model3,null);
        ImageView imagen = (ImageView)view.findViewById(R.id.imagen3);
        TextView titulo = (TextView)view.findViewById(R.id.titulox);

        imagen.setImageResource(Item.getImgFoto());
        titulo.setText(Item.getTitulo());
        return view;

    }
}