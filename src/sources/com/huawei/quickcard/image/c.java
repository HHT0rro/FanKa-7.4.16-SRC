package com.huawei.quickcard.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Util;
import com.huawei.quickcard.framework.unit.LengthUnit;
import com.huawei.quickcard.framework.unit.LengthValue;
import com.huawei.quickcard.views.image.extension.ClipRect;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.concurrent.locks.Lock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends BitmapTransformation {

    /* renamed from: c, reason: collision with root package name */
    private static final String f34041c = "com.bumptech.glide.load.resource.bitmap.ScaleCropTransform";

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f34042d = f34041c.getBytes(Key.CHARSET);

    /* renamed from: e, reason: collision with root package name */
    private static final int f34043e = 6;

    /* renamed from: a, reason: collision with root package name */
    private final Paint f34044a = new Paint(6);

    /* renamed from: b, reason: collision with root package name */
    private final ClipRect f34045b;

    public c(@NonNull ClipRect clipRect) {
        this.f34045b = clipRect;
    }

    @NonNull
    private Bitmap a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap) {
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        RectF a10 = a(rectF);
        if (rectF.equals(a10) || Float.compare(a10.width(), 0.0f) < 1 || Float.compare(a10.height(), 0.0f) < 1) {
            return bitmap;
        }
        float width = rectF.width() / a10.width();
        float height = rectF.height() / a10.height();
        float f10 = ((rectF.right - a10.right) - (a10.left - rectF.left)) / 2.0f;
        float f11 = ((rectF.bottom - a10.bottom) - (a10.top - rectF.top)) / 2.0f;
        Matrix matrix = new Matrix();
        matrix.postTranslate(f10, f11);
        matrix.postScale(width, height, rectF.width() / 2.0f, rectF.height() / 2.0f);
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), a(bitmap));
        TransformationUtils.setAlpha(bitmap, bitmap2);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f34045b.equals(((c) obj).f34045b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(577165595, this.f34045b.hashCode());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i10, int i11) {
        return a(bitmapPool, bitmap);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f34042d);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f34045b.hashCode()).array());
    }

    @NonNull
    private RectF a(@NonNull RectF rectF) {
        return new RectF(rectF.left + a(this.f34045b.getLeft(), rectF.width()), rectF.top + a(this.f34045b.getTop(), rectF.height()), rectF.right - a(this.f34045b.getRight(), rectF.width()), rectF.bottom - a(this.f34045b.getBottom(), rectF.height()));
    }

    private float a(LengthValue lengthValue, @FloatRange(from = 0.0d) float f10) {
        if (lengthValue == null) {
            return 0.0f;
        }
        float f11 = lengthValue.value;
        if (lengthValue.unit == LengthUnit.PERCENT) {
            f11 *= f10;
        }
        float max = Math.max(f11, 0.0f);
        if (Float.compare(max, f10 / 2.0f) >= 0) {
            return 0.0f;
        }
        return max;
    }

    private void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock bitmapDrawableLock = TransformationUtils.getBitmapDrawableLock();
        bitmapDrawableLock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, this.f34044a);
            a(canvas);
        } finally {
            bitmapDrawableLock.unlock();
        }
    }

    private void a(@NonNull Canvas canvas) {
        canvas.setBitmap(null);
    }

    @NonNull
    private Bitmap.Config a(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }
}
