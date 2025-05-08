package com.example.simplepaint;

public class Circle {
    public float cX, cY, radius;

    public void setStart(float x, float y) {
        this.cX = x;
        this.cY = y;
    }

    public void setRadius(float x, float y) {
        this.radius = (float) Math.sqrt(Math.pow(x - cX, 2) + Math.pow(y - cY, 2));
    }

}
