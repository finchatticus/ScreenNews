package com.gjevass.pixels.app.model;

import android.graphics.Bitmap;

public class EvenViewModel {
    private float rotate;
    private int width;
    private int height;
    private int marginLeft;
    private int marginTop;
    private int resourceId;
    private Bitmap bitmap;

    public EvenViewModel(float rotate, int width, int height, int marginLeft, int marginTop, int resourceId) {
        this.rotate = rotate;
        this.width = width;
        this.height = height;
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.resourceId = resourceId;
    }

    public float getRotate() {
        return rotate;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getResourceId() {
        return resourceId;
    }

    public int getMarginLeft() {
        return marginLeft;
    }
}
