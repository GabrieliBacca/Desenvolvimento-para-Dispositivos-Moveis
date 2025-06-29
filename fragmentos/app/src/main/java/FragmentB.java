package com.ifsc.contaclick;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    TextView tv;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null && getArguments().containsKey("valor")) {
            Integer valor = getArguments().getInt("valor");
            tv.setText(valor.toString());
        } else {
            tv.setText("No fargmento A digite os números e some");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        tv = v.findViewById(R.id.textView);

        return v;
    }
}