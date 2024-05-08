package com.cupidapp.live.liveshow.view.tag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: ParallelogramLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ParallelogramLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Path f15985b;

    /* renamed from: c, reason: collision with root package name */
    public final double f15986c;

    /* renamed from: d, reason: collision with root package name */
    public float f15987d;

    /* renamed from: e, reason: collision with root package name */
    public float f15988e;

    /* renamed from: f, reason: collision with root package name */
    public int f15989f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15990g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParallelogramLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15990g = new LinkedHashMap();
        this.f15985b = new Path();
        this.f15986c = Math.tan(Math.toRadians(15.0d));
        this.f15987d = h.c(this, 4.0f);
    }

    public final void a(int i10, int i11) {
        float f10 = i10;
        float f11 = i11;
        this.f15985b.reset();
        Path path = this.f15985b;
        float f12 = this.f15987d;
        float f13 = 2;
        double d10 = this.f15986c;
        path.arcTo((float) ((f11 - (f12 * f13)) * d10), this.f15988e / f13, (float) (((f11 - (f12 * f13)) * d10) + (f12 * f13)), f12 * f13, 195.0f, 75.0f, true);
        Path path2 = this.f15985b;
        float f14 = this.f15987d;
        float f15 = this.f15988e;
        path2.arcTo(f10 - (f14 * f13), f15 / f13, f10 - (f15 / f13), f14 * f13, 270.0f, 105.0f, false);
        Path path3 = this.f15985b;
        double d11 = f10;
        float f16 = this.f15987d;
        double d12 = this.f15986c;
        path3.arcTo((float) ((d11 - ((f11 - (f16 * f13)) * d12)) - (f16 * f13)), f11 - (f16 * f13), (float) (d11 - ((f11 - (f16 * f13)) * d12)), f11 - (this.f15988e / f13), 15.0f, 75.0f, false);
        Path path4 = this.f15985b;
        float f17 = this.f15988e;
        float f18 = this.f15987d;
        path4.arcTo(f17 / f13, f11 - (f18 * f13), f18 * f13, f11 - (f17 / f13), 90.0f, 105.0f, false);
        this.f15985b.close();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        s.i(canvas, "canvas");
        int save = canvas.save();
        canvas.clipPath(this.f15985b);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
        if ((this.f15988e == 0.0f) || this.f15989f == 0) {
            return;
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(this.f15988e);
        paint.setColor(this.f15989f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawPath(this.f15985b, paint);
    }

    public final float getRadius() {
        return this.f15987d;
    }

    public final float getStroke() {
        return this.f15988e;
    }

    public final int getStrokeColor() {
        return this.f15989f;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a(i10, i11);
    }

    public final void setRadius(float f10) {
        this.f15987d = f10;
    }

    public final void setStroke(float f10) {
        this.f15988e = f10;
    }

    public final void setStrokeColor(int i10) {
        this.f15989f = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParallelogramLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15990g = new LinkedHashMap();
        this.f15985b = new Path();
        this.f15986c = Math.tan(Math.toRadians(15.0d));
        this.f15987d = h.c(this, 4.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParallelogramLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15990g = new LinkedHashMap();
        this.f15985b = new Path();
        this.f15986c = Math.tan(Math.toRadians(15.0d));
        this.f15987d = h.c(this, 4.0f);
    }
}
