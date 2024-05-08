package com.huawei.hms.ml.scan;

import android.graphics.Bitmap;
import android.graphics.YuvImage;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HmsScanFrame {
    private Bitmap bitmap;
    private int height;
    private int width;
    private YuvImage yuvImage;

    public HmsScanFrame(YuvImage yuvImage) {
        if (yuvImage.getYuvData() == null || yuvImage.getYuvFormat() != 17) {
            return;
        }
        this.yuvImage = yuvImage;
        this.width = yuvImage.getWidth();
        this.height = yuvImage.getHeight();
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public YuvImage getYuvImage() {
        return this.yuvImage;
    }

    public HmsScanFrame(Bitmap bitmap) {
        this.bitmap = bitmap;
        if (bitmap == null) {
            return;
        }
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
    }
}
