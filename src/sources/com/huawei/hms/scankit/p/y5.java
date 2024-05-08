package com.huawei.hms.scankit.p;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: ParticleEffect.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class y5 {

    /* renamed from: a, reason: collision with root package name */
    private long f31764a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f31765b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f31766c;

    /* renamed from: d, reason: collision with root package name */
    private int f31767d;

    /* renamed from: e, reason: collision with root package name */
    private int f31768e;

    /* renamed from: f, reason: collision with root package name */
    private float f31769f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f31770g;

    /* renamed from: h, reason: collision with root package name */
    private b6 f31771h;

    public y5(@NonNull b6 b6Var, Rect rect, int i10, float f10, int[] iArr) {
        this.f31766c = 0;
        this.f31767d = 0;
        this.f31771h = b6Var;
        this.f31770g = rect;
        this.f31768e = i10;
        if (iArr != null && iArr.length >= 2) {
            this.f31766c = iArr[0];
            this.f31767d = iArr[1];
        }
        this.f31769f = f10;
        c();
    }

    private void a() {
        b6 b6Var = this.f31771h;
        if (b6Var != null) {
            b6Var.a();
        }
    }

    private int b() {
        float a10 = n6.a(1.0f);
        int red = Color.red(this.f31766c);
        int blue = Color.blue(this.f31766c);
        return Color.rgb((int) (red + ((Color.red(this.f31767d) - red) * a10) + 0.5f), (int) (Color.green(this.f31766c) + ((Color.green(this.f31767d) - r3) * a10) + 0.5f), (int) (blue + ((Color.blue(this.f31767d) - blue) * a10) + 0.5f));
    }

    private void c() {
        Rect rect;
        a();
        this.f31765b = 0L;
        this.f31764a = System.currentTimeMillis();
        b6 b6Var = this.f31771h;
        if (b6Var == null || (rect = this.f31770g) == null) {
            return;
        }
        b6Var.a(rect, this.f31768e);
    }

    public void a(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.f31771h == null || canvas == null || rect == null) {
            return;
        }
        long currentTimeMillis = this.f31765b + (System.currentTimeMillis() - this.f31764a);
        this.f31765b = currentTimeMillis;
        this.f31771h.b(currentTimeMillis);
        List<w5> c4 = this.f31771h.c();
        if (c4 == null || c4.isEmpty()) {
            return;
        }
        a(canvas, rect, c4);
        this.f31764a = System.currentTimeMillis();
    }

    private void a(Canvas canvas, Rect rect, List<w5> list) {
        for (w5 w5Var : list) {
            Paint paint = new Paint();
            if (w5Var.b() == 0) {
                w5Var.b(b());
            }
            paint.setColor(w5Var.b());
            boolean z10 = w5Var.d() > ((float) Math.max(rect.top, rect.bottom)) || w5Var.d() < ((float) Math.min(rect.top, rect.bottom));
            float f10 = 0.0f;
            if (rect.height() != 0 && rect.width() != 0 && !z10) {
                f10 = (rect.bottom - w5Var.d()) / rect.height();
            }
            int a10 = (int) (w5Var.a() * Math.abs(f10));
            if (a10 > 0) {
                paint.setAlpha(a10);
                canvas.drawCircle(w5Var.c(), w5Var.d(), w5Var.f() * this.f31769f, paint);
            }
        }
    }
}
