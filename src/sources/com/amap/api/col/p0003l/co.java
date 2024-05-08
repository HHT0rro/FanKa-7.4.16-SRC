package com.amap.api.col.p0003l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

/* compiled from: OverlayFormatter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class co {

    /* renamed from: a, reason: collision with root package name */
    private static Paint f5222a = new Paint();

    /* renamed from: b, reason: collision with root package name */
    private static Rect f5223b = new Rect();

    public static float a(int i10, boolean z10) {
        if (z10) {
            if (i10 != 1) {
                return i10 != 2 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }
        if (i10 != 8) {
            return i10 != 16 ? 0.5f : 1.0f;
        }
        return 0.0f;
    }

    public static MarkerOptions a(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(b(textOptions));
        markerOptions.anchor(a(textOptions.getAlignX(), true), a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    public static BitmapDescriptor b(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        f5222a.setTypeface(textOptions.getTypeface());
        f5222a.setSubpixelText(true);
        f5222a.setAntiAlias(true);
        f5222a.setStrokeWidth(5.0f);
        f5222a.setStrokeCap(Paint.Cap.ROUND);
        f5222a.setTextSize(textOptions.getFontSize());
        f5222a.setTextAlign(Paint.Align.CENTER);
        f5222a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = f5222a.getFontMetrics();
        int i10 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i11 = (int) (((i10 - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            f5222a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), f5223b);
        }
        Bitmap createBitmap = Bitmap.createBitmap(f5223b.width() + 6, i10, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), f5223b.centerX() + 3, i11, f5222a);
        }
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
