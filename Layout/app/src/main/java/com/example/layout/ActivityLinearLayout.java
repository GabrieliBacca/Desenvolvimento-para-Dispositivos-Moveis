package com.example.layout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button enviar = findViewById(R.id.enviar);
        EditText nome = findViewById(R.id.nome);
        EditText email = findViewById(R.id.email);
        RadioGroup radioGroup = findViewById(R.id.grupoRadio);

        enviar.setOnClickListener(b -> {
            String texto = nome.getText().toString() + " - " + email.getText().toString();
            Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
        });
    }
}
