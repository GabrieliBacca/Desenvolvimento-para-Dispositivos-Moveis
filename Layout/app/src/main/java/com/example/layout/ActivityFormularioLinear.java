package com.example.layout;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityFormularioLinear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_linear);

        EditText nome = findViewById(R.id.nome);
        EditText endereco = findViewById(R.id.endereco);
        EditText cidade = findViewById(R.id.cidade);
        EditText email = findViewById(R.id.email);
        EditText telefone = findViewById(R.id.telefone);
        Spinner spinner = findViewById(R.id.spinner);
        EditText cep = findViewById(R.id.cep);
        EditText aniversario = findViewById(R.id.aniversario);
        ImageButton calendario = findViewById(R.id.calendario);

        calendario.setOnClickListener(v -> {
            Toast.makeText(this, "Abrir calendário não implementado", Toast.LENGTH_SHORT).show();
        });
    }
}
