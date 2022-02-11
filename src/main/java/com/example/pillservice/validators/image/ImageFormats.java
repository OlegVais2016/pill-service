package com.example.pillservice.validators.image;

public enum ImageFormats {

    JPG(new byte[]{(byte) 0xFF, (byte) 0xD8}),
    PNG(new byte[]{(byte) 0x89, (byte) 0x50}),
    BMP(new byte[]{(byte) 0x42, (byte) 0x4D}),
    GIF(new byte[]{(byte) 0x47, (byte) 0x49});

    private byte[] format;

    ImageFormats(byte[] format) {
        this.format = format;
    }

    public byte[] getFormat() {
        return format;
    }
}
