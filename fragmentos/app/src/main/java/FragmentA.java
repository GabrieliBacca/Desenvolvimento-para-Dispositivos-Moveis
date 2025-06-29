package com.ifsc.contaclick;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        Button bo = v.findViewById(R.id.button2);
        EditText n1 = v.findViewById(R.id.n1);
        EditText n2 = v.findViewById(R.id.n2);

        bo.setOnClickListener(e->{
            if (n1.getText().toString().isEmpty() || n2.getText().toString().isEmpty()){
                return;
            }

            int valor = Integer.parseInt(n1.getText().toString())+Integer.parseInt(n2.getText().toString());
            FragmentB fragmentB = new FragmentB();
            Bundle b = new Bundle();
            b.putInt("valor", valor);
            fragmentB.setArguments(b);

            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.frame,fragmentB);
            transaction.commit();
        });

        return v;
    }
}