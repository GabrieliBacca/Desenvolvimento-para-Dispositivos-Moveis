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

import com.ifsc.contaclick.Aplicativo;

import java.util.List;

public class AppAdapter extends ArrayAdapter<Aplicativo> {
    int mResouce;
    public AppAdapter(@NonNull Context context, int resource, @NonNull List<Aplicativo> objects) {
        super(context, resource, objects);
        mResouce = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView= inflater.inflate(mResouce, parent, false);


        Aplicativo aplicativo = getItem(position);

        if (aplicativo != null) {
            TextView nomeTextView = convertView.findViewById(R.id.textView);
            ImageView iconeImageView = convertView.findViewById(R.id.imageView2);
            nomeTextView.setText(aplicativo.getNome());
            iconeImageView.setImageDrawable(aplicativo.getIcone());


        }
        return convertView;
    }
}