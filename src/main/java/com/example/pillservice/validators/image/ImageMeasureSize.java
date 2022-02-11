package com.example.pillservice.validators.image;

public enum ImageMeasureSize {

    KILOBYTE(1024),
    MEGABYTE(1024 * 1024);

    private int size;

    ImageMeasureSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}