package com.huawei.quickcard;

import com.huawei.quickcard.utils.FloatUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private float f34161a = -1.0f;

    /* renamed from: b, reason: collision with root package name */
    private float f34162b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    private float f34163c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f34164d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f34165e = -1.0f;

    public void a(float f10) {
        this.f34165e = f10;
    }

    public void b(float f10) {
        this.f34164d = f10;
    }

    public void c(float f10) {
        this.f34161a = f10;
    }

    public float d() {
        return this.f34161a;
    }

    public void e(float f10) {
        this.f34162b = f10;
    }

    public float f() {
        return this.f34162b;
    }

    public boolean a() {
        return this.f34161a > -1.0f && FloatUtils.equals(this.f34164d, this.f34163c) && FloatUtils.equals(this.f34163c, this.f34161a) && FloatUtils.equals(this.f34164d, this.f34162b);
    }

    public float b() {
        return this.f34165e;
    }

    public float c() {
        return this.f34164d;
    }

    public void d(float f10) {
        this.f34163c = f10;
    }

    public float e() {
        return this.f34163c;
    }
}
