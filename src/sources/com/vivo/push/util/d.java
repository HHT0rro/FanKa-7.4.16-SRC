package com.vivo.push.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: BitmapUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public static Bitmap a(Bitmap bitmap, int i10, int i11) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f10 = i10 / width;
        float f11 = i11 / height;
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(f10, f11);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception unused) {
            return bitmap;
        }
    }
}
