package com.wangmai.okhttp.convert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BitmapConvert implements Converter<Bitmap> {
    public Bitmap.Config decodeConfig;
    public int maxHeight;
    public int maxWidth;
    public ImageView.ScaleType scaleType;

    public BitmapConvert() {
        this(1000, 1000, Bitmap.Config.RGB_565, ImageView.ScaleType.CENTER_INSIDE);
    }

    public static int findBestSampleSize(int i10, int i11, int i12, int i13) {
        double min = Math.min(i10 / i12, i11 / i13);
        float f10 = 1.0f;
        while (true) {
            float f11 = 2.0f * f10;
            if (f11 > min) {
                return (int) f10;
            }
            f10 = f11;
        }
    }

    public static int getResizedDimension(int i10, int i11, int i12, int i13, ImageView.ScaleType scaleType) {
        if (i10 == 0 && i11 == 0) {
            return i12;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i10 == 0 ? i12 : i10;
        }
        if (i10 == 0) {
            return (int) (i12 * (i11 / i13));
        }
        if (i11 == 0) {
            return i10;
        }
        double d10 = i13 / i12;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d11 = i11;
            return ((double) i10) * d10 < d11 ? (int) (d11 / d10) : i10;
        }
        double d12 = i11;
        return ((double) i10) * d10 > d12 ? (int) (d12 / d10) : i10;
    }

    private Bitmap parse(byte[] bArr) throws OutOfMemoryError {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.maxWidth == 0 && this.maxHeight == 0) {
            options.inPreferredConfig = this.decodeConfig;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        int resizedDimension = getResizedDimension(this.maxWidth, this.maxHeight, i10, i11, this.scaleType);
        int resizedDimension2 = getResizedDimension(this.maxHeight, this.maxWidth, i11, i10, this.scaleType);
        options.inJustDecodeBounds = false;
        options.inSampleSize = findBestSampleSize(i10, i11, resizedDimension, resizedDimension2);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (decodeByteArray == null) {
            return decodeByteArray;
        }
        if (decodeByteArray.getWidth() <= resizedDimension && decodeByteArray.getHeight() <= resizedDimension2) {
            return decodeByteArray;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, resizedDimension, resizedDimension2, true);
        decodeByteArray.recycle();
        return createScaledBitmap;
    }

    public BitmapConvert(int i10, int i11) {
        this(i10, i11, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.okhttp.convert.Converter
    public Bitmap convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        return parse(body.bytes());
    }

    public BitmapConvert(int i10, int i11, Bitmap.Config config, ImageView.ScaleType scaleType) {
        this.maxWidth = i10;
        this.maxHeight = i11;
        this.decodeConfig = config;
        this.scaleType = scaleType;
    }
}
