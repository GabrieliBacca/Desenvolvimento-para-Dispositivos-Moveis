package com.ifsc.contaclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    Context mContext;
    Integer mResource;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        mContext=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Infla as view
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        View v= layoutInflater.inflate(mResource,parent,false);
        // #  texto
        TextView tv=v.findViewById(R.id.textView);
        ImageView imageView=v.findViewById(R.id.imageView2);

        //Recupera o objeto a ser exibido na view
        Planeta p = getItem(position);
        tv.setText(p.getNome());
        imageView.setImageResource(p.getFoto());
        return v;
    }
}
