package com.example.contaclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvContagem;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContagem = findViewById(R.id.textView);
        tvContagem.setText(Integer.toString(0));
    }

    public void contaClick(View view){
        i++;
        tvContagem.setText(Integer.toString(i));

    }
}