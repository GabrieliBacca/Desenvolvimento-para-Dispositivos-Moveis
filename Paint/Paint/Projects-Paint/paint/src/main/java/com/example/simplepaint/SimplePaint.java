package com.example.simplepaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.skydoves.colorpickerview.ColorPickerView;

import java.util.ArrayList;
import java.util.Map;

public class SimplePaint extends View {
    public boolean drawingSquare = false;
    private Square square;
    private Circle circle;
    Shapes drawShape;
    ArrayList<Layer> camadas;
    Layer previewLayer;
    CoordenadasTraco coordenadasTraco;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        camadas = new ArrayList<Layer>();
        camadas.add(new Layer());
        previewLayer = new Layer();
        setupLayer(previewLayer);
        this.drawShape = Shapes.Path;
    }

    private void setupLayer(Layer layer) {
        layer.paint.setColor(Color.BLACK);
        layer.paint.setStrokeWidth(6f);
        layer.paint.setAntiAlias(true);
        layer.paint.setStyle(Paint.Style.STROKE);
        layer.paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        for(Layer layer : camadas) {
            canvas.drawPath(layer.path, layer.paint);
        }

        canvas.drawPath(previewLayer.path, previewLayer.paint);
    }

    public void clear() {
        getCurrentLayer().path.reset();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                addLayer();
                getCurrentLayer().path.moveTo(x, y);
                coordenadasTraco = new CoordenadasTraco();
                coordenadasTraco.InicialX = x;
                coordenadasTraco.InicialY = y;
                return true;

            case MotionEvent.ACTION_MOVE:
                if(drawShape.equals(Shapes.Square)) {
                    getCurrentLayer().path.reset();
                    getCurrentLayer().path.addRect(coordenadasTraco.InicialX, coordenadasTraco.InicialY, x, y, Path.Direction.CW);
                } else if(drawShape.equals(Shapes.Path)) {
                    getCurrentLayer().path.lineTo(x, y);
                } else if(drawShape.equals(Shapes.Circle)) {
                    getCurrentLayer().path.reset();
                    getCurrentLayer().path.moveTo(coordenadasTraco.InicialX, coordenadasTraco.InicialY);
                    previewLayer.clear();
                    previewLayer.path.moveTo(coordenadasTraco.InicialX, coordenadasTraco.InicialY);
                    previewLayer.path.lineTo(x, y);

                    float raio = (float) Math.sqrt(Math.pow(coordenadasTraco.InicialX - x, 2) + Math.pow(coordenadasTraco.InicialY - y, 2));
                    getCurrentLayer().path.addCircle(x, y, raio, Path.Direction.CW);
                } else if(drawShape.equals(Shapes.Finger)) {
                    getCurrentLayer().path.addRect(x - 30, y - 30, x + 30, y + 30, Path.Direction.CW);
                }
                break;

            case MotionEvent.ACTION_UP:
                previewLayer.path.reset();
                break;

            default:
            return false;
        }

        invalidate();
        return super.onTouchEvent(event);
    }

    public Layer getCurrentLayer() {
        return camadas.get(camadas.size()-1);
    }

    public void setCollor(int color) {
        camadas.add(new Layer(getCurrentLayer().paint));
        getCurrentLayer().paint.setColor(color);
    }

    private void addLayer() {
        camadas.add(new Layer(previewLayer.paint));
        invalidate();
    }

    public void setDrawingShape(Shapes shape) {
        this.drawShape = shape;

        if(shape.equals(Shapes.Square)) {
            square = new Square();
        }

        if(shape.equals(Shapes.Circle)) {
            circle = new Circle();
        }

        invalidate();
    }

    public void undo() {
        if(camadas.size() > 1) {
            camadas.remove(camadas.size()-1);
            invalidate();
        } else {
            clear();
        }
    }
}
