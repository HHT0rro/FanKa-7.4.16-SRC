package com.bef.effectsdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import h0.a;
import java.io.ByteArrayOutputStream;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ImgporcUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class InterpolationFlags {
        public static final int INTER_LINEAR = 1;
        public static final int INTER_NEAREST = 0;
        public static final int WARP_INVERSE_MAP = 16;
    }

    public static float calculateAspectRatio(PointF[] pointFArr, int i10, int i11) {
        return nativeCalculateAspectRatio(pointFArr, i10, i11);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        if (i12 > i11 || i13 > i10) {
            int i15 = i12 / 2;
            int i16 = i13 / 2;
            while (i15 / i14 >= i11 && i16 / i14 >= i10) {
                i14 *= 2;
            }
        }
        return i14;
    }

    @a
    public static byte[] compressImage(Bitmap bitmap, int i10, int i11) {
        Bitmap.CompressFormat compressFormat = i10 == 1 ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i11, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap correctPerspective(Bitmap bitmap, PointF[] pointFArr, int i10, int i11, int i12) {
        return nativeCorrectPerspective(bitmap, pointFArr, i10, i11, i12);
    }

    @a
    public static Bitmap decodeImage(byte[] bArr, int i10, int i11) {
        if (i10 > 0 && i11 > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int calculateInSampleSize = calculateInSampleSize(options, i10, i11);
            options.inJustDecodeBounds = false;
            options.inSampleSize = calculateInSampleSize;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    private static native float nativeCalculateAspectRatio(PointF[] pointFArr, int i10, int i11);

    private static native Bitmap nativeCorrectPerspective(Bitmap bitmap, PointF[] pointFArr, int i10, int i11, int i12);

    public static Bitmap correctPerspective(Bitmap bitmap, PointF[] pointFArr, int i10, int i11) {
        return nativeCorrectPerspective(bitmap, pointFArr, i10, i11, 1);
    }
}
