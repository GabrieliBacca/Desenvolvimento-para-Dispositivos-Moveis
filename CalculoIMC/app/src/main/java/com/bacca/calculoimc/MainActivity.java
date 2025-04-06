package com.bacca.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText peso;
    EditText altura;
    float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        peso=findViewById(R.id.Peso);
        altura=findViewById(R.id.editTextTextPersonName);
    }

    public void abreSegundaActivity(View v){
        Intent i = new Intent(this, MainActivity2.class);
        String strAltura = String.valueOf(altura.getText());
        String strPeso = peso.getText().toString();
        float floataltura = Float.valueOf(strAltura);
        float floatpeso = Float.valueOf(strPeso);

        resultado= floatpeso * floataltura;
        String s = Float.toString(resultado);

        i.putExtra("imc",s);
        startActivity(i);
    }


}

/*
    MENOR QUE 18,5	MAGREZA	0
    ENTRE 18,5 E 24,9	NORMAL	0
    ENTRE 25,0 E 29,9	SOBREPESO	I
    ENTRE 30,0 E 39,9	OBESIDADE	II
    MAIOR QUE 40,0	OBESIDADE GRAVE	III
    */
