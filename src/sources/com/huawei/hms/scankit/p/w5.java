package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: Particle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class w5 {

    /* renamed from: b, reason: collision with root package name */
    private float f31690b;

    /* renamed from: c, reason: collision with root package name */
    private float f31691c;

    /* renamed from: h, reason: collision with root package name */
    private long f31696h;

    /* renamed from: i, reason: collision with root package name */
    private float f31697i;

    /* renamed from: j, reason: collision with root package name */
    private float f31698j;

    /* renamed from: l, reason: collision with root package name */
    private float f31700l;

    /* renamed from: m, reason: collision with root package name */
    private float f31701m;

    /* renamed from: n, reason: collision with root package name */
    private int f31702n;

    /* renamed from: o, reason: collision with root package name */
    private int f31703o;

    /* renamed from: p, reason: collision with root package name */
    private long f31704p;

    /* renamed from: r, reason: collision with root package name */
    private f4 f31706r;

    /* renamed from: a, reason: collision with root package name */
    private float f31689a = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private int f31692d = 255;

    /* renamed from: e, reason: collision with root package name */
    private float f31693e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f31694f = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    private int f31705q = 0;

    /* renamed from: k, reason: collision with root package name */
    private float f31699k = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    private int f31695g = 255;

    public w5(Bitmap bitmap) {
        if (bitmap != null) {
            this.f31702n = bitmap.getWidth() / 2;
            this.f31703o = bitmap.getHeight() / 2;
        }
    }

    public void a(long j10, float f10, float f11, long j11, @NonNull f4 f4Var) {
        float f12 = f10 - this.f31702n;
        this.f31700l = f12;
        float f13 = f11 - this.f31703o;
        this.f31701m = f13;
        this.f31697i = f12;
        this.f31698j = f13;
        this.f31704p = j10;
        this.f31696h = j11;
        this.f31706r = f4Var;
    }

    public void b(float f10) {
        this.f31699k = f10;
    }

    public float c() {
        return this.f31697i;
    }

    public float d() {
        return this.f31698j;
    }

    public int e() {
        return this.f31692d;
    }

    public float f() {
        return this.f31699k;
    }

    public int b() {
        return this.f31705q;
    }

    public void b(int i10) {
        this.f31705q = i10;
    }

    public boolean a(long j10) {
        long j11 = j10 - this.f31696h;
        if (j11 > this.f31704p) {
            return false;
        }
        float f10 = (float) j11;
        float f11 = (float) (j11 * j11);
        this.f31697i = this.f31700l + (this.f31693e * f10) + (this.f31690b * f11);
        this.f31698j = this.f31701m + (this.f31694f * f10) + (this.f31691c * f11);
        this.f31706r.a(this, j11);
        return true;
    }

    public int a() {
        return this.f31695g;
    }

    public void a(int i10) {
        this.f31695g = i10;
    }

    public void a(float f10) {
        this.f31689a = f10;
    }
}
