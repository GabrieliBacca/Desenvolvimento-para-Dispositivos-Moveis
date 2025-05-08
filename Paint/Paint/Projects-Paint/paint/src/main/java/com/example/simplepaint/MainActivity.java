package com.example.simplepaint;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorListener;

public class MainActivity extends AppCompatActivity {
    SimplePaint simplePaint;
    ColorPickerView colorPickerView;
    ImageButton circleButton, penButton, squareButton, undoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplePaint = findViewById(R.id.simplePaint);
        colorPickerView = findViewById(R.id.colorPickerView);
        squareButton = findViewById(R.id.squareButton);
        penButton = findViewById(R.id.penButton);
        circleButton = findViewById(R.id.circleButton);
        undoButton = findViewById(R.id.undoButton);

        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(int color, boolean fromUser) {
                if(fromUser) {
                    SimplePaint simplePaint = findViewById(R.id.simplePaint);
                    simplePaint.previewLayer.paint.setColor(color);
                }
            }
        });

        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(simplePaint.drawShape.equals(Shapes.Square)) {
                    simplePaint.setDrawingShape(Shapes.Path);
                } else {

                    simplePaint.setDrawingShape(Shapes.Square); // Alterna entre os modos
                }
            }
        });

        penButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplePaint.setDrawingShape(Shapes.Path);
            }
        });

        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplePaint.setDrawingShape(Shapes.Circle);
            }
        });

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplePaint.undo();
            }
        });
    }
}