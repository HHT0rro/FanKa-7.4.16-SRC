package com.kwad.sdk.core.imageloader.core.assist;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ImageSize {
    private static final String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    public ImageSize(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public ImageSize scale(float f10) {
        return new ImageSize((int) (this.width * f10), (int) (this.height * f10));
    }

    public ImageSize scaleDown(int i10) {
        return new ImageSize(this.width / i10, this.height / i10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(9);
        sb2.append(this.width);
        sb2.append("x");
        sb2.append(this.height);
        return sb2.toString();
    }

    public ImageSize(int i10, int i11, int i12) {
        if (i12 % 180 == 0) {
            this.width = i10;
            this.height = i11;
        } else {
            this.width = i11;
            this.height = i10;
        }
    }
}
