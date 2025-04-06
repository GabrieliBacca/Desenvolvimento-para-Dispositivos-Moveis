package com.bacca.sorteioApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int contagem=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclodevida", "onCreate");
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.TextView);
        textView.setText(Integer.toString(contagem));
    }

    public void contaClick (View v){
        ((Button) v).setText("bacca");

        textView.setText(Integer.toString(contagem++));
    }

    public void aumentar(View v){
//        getResources().getDisplayMetrics().density
       textView.setTextSize( (textView.getTextSize()/getResources().getDisplayMetrics().density)+1);
    }

    public void reduzir(View v){
        textView.setTextSize((textView.getTextSize()/getResources().getDisplayMetrics().density)-1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclodevida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclodevida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclodevida", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclodevida", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclodevida", "onDestroy");
    }
}