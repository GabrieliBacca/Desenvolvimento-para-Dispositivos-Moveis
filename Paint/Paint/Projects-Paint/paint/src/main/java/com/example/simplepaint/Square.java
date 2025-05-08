package com.example.simplepaint;

import android.graphics.Rect;

public class Square {
    public float startX, startY, endX, endY;

    public void setStart(float startX, float startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public void setEnd(float endX, float endY) {
        this.endX = endX;
        this.endY = endY;
    }

    public Rect getSquareRect() {
        return new Rect((int)startX, (int)startY, (int)endX, (int)endY);
    }
}
