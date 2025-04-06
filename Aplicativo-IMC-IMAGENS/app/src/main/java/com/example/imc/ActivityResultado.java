package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ActivityResultado extends AppCompatActivity {
    public TextView txtResultado;
    public TextView txtResultado2;
    public ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle bundle = getIntent().getExtras();
        float valor = bundle.getFloat("msg");
        txtResultado = findViewById(R.id.imcValorResultado);
        txtResultado2 = findViewById(R.id.imcResultado);
        img = findViewById(R.id.img);
        DecimalFormat d = new DecimalFormat("#.#");
        String s = String.valueOf(d.format(valor));
        txtResultado.setText(s);
        Resultado(valor);
    }

    public void Resultado(float valor){
        if(valor<=18.5){
            img.setImageResource(R.drawable.abaixopeso);
            txtResultado2.setText("Abaixo do Peso");
        } else {
            if((valor>18.5)&&(valor<25)){
                img.setImageResource(R.drawable.normal);
                txtResultado2.setText("Peso Ideal");
            } else{
                if ((valor>=25)&&(valor<30)){
                    img.setImageResource(R.drawable.sobrepeso);
                    txtResultado2.setText("Sobrepeso");
                } else{
                    if((valor>=30)&&(valor<35)){
                        img.setImageResource(R.drawable.obesidade1);
                        txtResultado2.setText("Obesidade grau I");
                    } else{
                        if ((valor>=35)&&(valor<40)){
                            img.setImageResource(R.drawable.obesidade2);
                            txtResultado2.setText("Obesidade grau II");
                        } else{
                            if((valor>=40)){
                                img.setImageResource(R.drawable.obesidade3);
                                txtResultado2.setText("Obesidade morbida");
                            }
                        }
                    }
                }
            }
        }
    }
}