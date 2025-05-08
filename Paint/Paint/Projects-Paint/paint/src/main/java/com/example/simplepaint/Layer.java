package com.example.simplepaint;

import android.graphics.Paint;
import android.graphics.Path;

public class Layer {
    public Paint paint;
    public Path path;

    public Layer(Paint paint) {
        this.paint = new Paint(paint);
        this.path = new Path();
    }

    public Layer() {
        this.paint = new Paint();
        this.path = new Path();
    }

    public void clear() {
        path.reset();
    }
}
