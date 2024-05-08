package o;

import sun.util.locale.LanguageTag;

/* compiled from: ScaleXY.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public float f52236a;

    /* renamed from: b, reason: collision with root package name */
    public float f52237b;

    public d(float f10, float f11) {
        this.f52236a = f10;
        this.f52237b = f11;
    }

    public boolean a(float f10, float f11) {
        return this.f52236a == f10 && this.f52237b == f11;
    }

    public float b() {
        return this.f52236a;
    }

    public float c() {
        return this.f52237b;
    }

    public void d(float f10, float f11) {
        this.f52236a = f10;
        this.f52237b = f11;
    }

    public String toString() {
        return b() + LanguageTag.PRIVATEUSE + c();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}
