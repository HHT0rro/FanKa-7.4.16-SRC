package com.huawei.openalliance.ad.views;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h extends g {
    private float D;
    private float L;

    /* renamed from: a, reason: collision with root package name */
    private Path f33035a;

    /* renamed from: b, reason: collision with root package name */
    private RectF f33036b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f33037c;

    /* renamed from: d, reason: collision with root package name */
    private Rect f33038d;

    /* renamed from: e, reason: collision with root package name */
    private float f33039e;

    public h(Drawable drawable, int i10, int i11) {
        super(drawable, i10, i11);
        this.f33035a = new Path();
        this.f33036b = new RectF();
        this.f33037c = new RectF();
        I();
    }

    private void B(float f10) {
        this.f33035a.reset();
        this.f33035a.addArc(this.f33036b, 90.0f, 180.0f);
        float f11 = this.f33038d.right - this.f33039e;
        if (Float.compare(Code(), V()) != 0) {
            Path path = this.f33035a;
            Rect rect = this.f33038d;
            path.addRect(this.f33039e + rect.left, rect.top, f11, rect.bottom, Path.Direction.CCW);
        }
        float V = Float.compare(Code(), 0.0f) != 0 ? ((f10 - V()) / Code()) * this.f33039e : 0.0f;
        Rect rect2 = this.f33038d;
        this.f33037c.set(f11 - V, rect2.top, f11 + V, rect2.bottom);
        this.f33035a.addArc(this.f33037c, 270.0f, 180.0f);
    }

    private float C(float f10) {
        return f10 / 2.0f;
    }

    private void Code(float f10) {
        this.D = f10;
    }

    private void I() {
        Rect bounds = getBounds();
        this.f33038d = bounds;
        Code(bounds.left, bounds.top, r1 + bounds.height(), this.f33038d.bottom);
        this.f33039e = C(this.f33038d.height());
    }

    private void I(float f10) {
        this.f33035a.reset();
        this.f33035a.addArc(this.f33036b, 90.0f, 180.0f);
        float Code = Float.compare(Code(), 0.0f) != 0 ? (f10 / Code()) * this.f33039e : 0.0f;
        Rect rect = this.f33038d;
        RectF rectF = this.f33037c;
        Rect rect2 = this.f33038d;
        rectF.set(rect2.left + Code, rect2.top, (rect.left + rect.height()) - Code, rect2.bottom);
        this.f33035a.addArc(this.f33037c, 270.0f, -180.0f);
    }

    private void V(float f10) {
        this.L = f10;
    }

    private void Z(float f10) {
        this.f33035a.reset();
        this.f33035a.addArc(this.f33036b, 90.0f, 180.0f);
        Rect rect = this.f33038d;
        float f11 = rect.left + this.f33039e;
        float width = rect.width() * f10;
        Rect rect2 = this.f33038d;
        this.f33035a.addRect(f11, rect2.top, width + rect2.left, rect2.bottom, Path.Direction.CCW);
    }

    public float Code() {
        return this.D;
    }

    public void Code(float f10, float f11, float f12, float f13) {
        this.f33036b.set(f10, f11, f12, f13);
    }

    public void Code(int i10, int i11, int i12, int i13) {
        this.f33038d.set(i10, i11, i12, i13);
        Code(i10, i11, i10 + r4, i13);
        this.f33039e = C(i13 - i11);
    }

    public float V() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.views.g
    public Path V(int i10) {
        float f10 = i10 / 10000.0f;
        if (Float.compare(f10, Code()) < 0) {
            I(f10);
        } else if (Float.compare(f10, V()) < 0) {
            Z(f10);
        } else {
            B(f10);
        }
        return this.f33035a;
    }

    @Override // com.huawei.openalliance.ad.views.g, android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        Code(i10, i11, i12, i13);
        int i14 = i12 - i10;
        if (i14 != 0) {
            Code(this.f33039e / i14);
            V(1.0f - Code());
        }
    }
}
