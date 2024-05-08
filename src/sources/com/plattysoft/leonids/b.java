package com.plattysoft.leonids;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.List;

/* compiled from: Particle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f38043a;

    /* renamed from: b, reason: collision with root package name */
    public float f38044b;

    /* renamed from: c, reason: collision with root package name */
    public float f38045c;

    /* renamed from: d, reason: collision with root package name */
    public float f38046d;

    /* renamed from: e, reason: collision with root package name */
    public int f38047e;

    /* renamed from: f, reason: collision with root package name */
    public float f38048f;

    /* renamed from: g, reason: collision with root package name */
    public float f38049g;

    /* renamed from: h, reason: collision with root package name */
    public float f38050h;

    /* renamed from: i, reason: collision with root package name */
    public float f38051i;

    /* renamed from: j, reason: collision with root package name */
    public float f38052j;

    /* renamed from: k, reason: collision with root package name */
    public float f38053k;

    /* renamed from: l, reason: collision with root package name */
    public Matrix f38054l;

    /* renamed from: m, reason: collision with root package name */
    public Paint f38055m;

    /* renamed from: n, reason: collision with root package name */
    public float f38056n;

    /* renamed from: o, reason: collision with root package name */
    public float f38057o;

    /* renamed from: p, reason: collision with root package name */
    public float f38058p;

    /* renamed from: q, reason: collision with root package name */
    public long f38059q;

    /* renamed from: r, reason: collision with root package name */
    public long f38060r;

    /* renamed from: s, reason: collision with root package name */
    public int f38061s;

    /* renamed from: t, reason: collision with root package name */
    public int f38062t;

    /* renamed from: u, reason: collision with root package name */
    public List<wb.b> f38063u;

    public b() {
        this.f38046d = 1.0f;
        this.f38047e = 255;
        this.f38048f = 0.0f;
        this.f38049g = 0.0f;
        this.f38050h = 0.0f;
        this.f38051i = 0.0f;
        this.f38054l = new Matrix();
        this.f38055m = new Paint();
    }

    public b a(long j10, List<wb.b> list) {
        this.f38060r = j10;
        this.f38063u = list;
        return this;
    }

    public void b(long j10, float f10, float f11) {
        this.f38061s = this.f38043a.getWidth() / 2;
        int height = this.f38043a.getHeight() / 2;
        this.f38062t = height;
        float f12 = f10 - this.f38061s;
        this.f38056n = f12;
        float f13 = f11 - height;
        this.f38057o = f13;
        this.f38044b = f12;
        this.f38045c = f13;
        this.f38059q = j10;
    }

    public void c(Canvas canvas) {
        this.f38054l.reset();
        this.f38054l.postRotate(this.f38058p, this.f38061s, this.f38062t);
        Matrix matrix = this.f38054l;
        float f10 = this.f38046d;
        matrix.postScale(f10, f10, this.f38061s, this.f38062t);
        this.f38054l.postTranslate(this.f38044b, this.f38045c);
        this.f38055m.setAlpha(this.f38047e);
        canvas.drawBitmap(this.f38043a, this.f38054l, this.f38055m);
    }

    public void d() {
        this.f38046d = 1.0f;
        this.f38047e = 255;
    }

    public boolean e(long j10) {
        long j11 = j10 - this.f38060r;
        if (j11 > this.f38059q) {
            return false;
        }
        float f10 = (float) j11;
        this.f38044b = this.f38056n + (this.f38050h * f10) + (this.f38052j * f10 * f10);
        this.f38045c = this.f38057o + (this.f38051i * f10) + (this.f38053k * f10 * f10);
        this.f38058p = this.f38048f + ((this.f38049g * f10) / 1000.0f);
        for (int i10 = 0; i10 < this.f38063u.size(); i10++) {
            this.f38063u.get(i10).a(this, j11);
        }
        return true;
    }

    public b(Bitmap bitmap) {
        this();
        this.f38043a = bitmap;
    }
}
