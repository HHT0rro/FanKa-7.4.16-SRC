package tb;

import android.widget.ImageView;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SVGAScaleInfo.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public float f53802a;

    /* renamed from: b, reason: collision with root package name */
    public float f53803b;

    /* renamed from: c, reason: collision with root package name */
    public float f53804c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f53805d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f53806e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public boolean f53807f;

    public final boolean a() {
        return this.f53807f;
    }

    public final float b() {
        return this.f53804c;
    }

    public final float c() {
        return this.f53805d;
    }

    public final float d() {
        return this.f53802a;
    }

    public final float e() {
        return this.f53803b;
    }

    public final void f(float f10, float f11, float f12, float f13, @NotNull ImageView.ScaleType scaleType) {
        s.j(scaleType, "scaleType");
        if (f10 == 0.0f || f11 == 0.0f || f12 == 0.0f || f13 == 0.0f) {
            return;
        }
        g();
        float f14 = (f10 - f12) / 2.0f;
        float f15 = (f11 - f13) / 2.0f;
        float f16 = f12 / f13;
        float f17 = f10 / f11;
        float f18 = f11 / f13;
        float f19 = f10 / f12;
        switch (e.f53801a[scaleType.ordinal()]) {
            case 1:
                this.f53802a = f14;
                this.f53803b = f15;
                return;
            case 2:
                if (f16 > f17) {
                    this.f53806e = f18;
                    this.f53807f = false;
                    this.f53804c = f18;
                    this.f53805d = f18;
                    this.f53802a = (f10 - (f12 * f18)) / 2.0f;
                    return;
                }
                this.f53806e = f19;
                this.f53807f = true;
                this.f53804c = f19;
                this.f53805d = f19;
                this.f53803b = (f11 - (f13 * f19)) / 2.0f;
                return;
            case 3:
                if (f12 < f10 && f13 < f11) {
                    this.f53802a = f14;
                    this.f53803b = f15;
                    return;
                }
                if (f16 > f17) {
                    this.f53806e = f19;
                    this.f53807f = true;
                    this.f53804c = f19;
                    this.f53805d = f19;
                    this.f53803b = (f11 - (f13 * f19)) / 2.0f;
                    return;
                }
                this.f53806e = f18;
                this.f53807f = false;
                this.f53804c = f18;
                this.f53805d = f18;
                this.f53802a = (f10 - (f12 * f18)) / 2.0f;
                return;
            case 4:
                if (f16 > f17) {
                    this.f53806e = f19;
                    this.f53807f = true;
                    this.f53804c = f19;
                    this.f53805d = f19;
                    this.f53803b = (f11 - (f13 * f19)) / 2.0f;
                    return;
                }
                this.f53806e = f18;
                this.f53807f = false;
                this.f53804c = f18;
                this.f53805d = f18;
                this.f53802a = (f10 - (f12 * f18)) / 2.0f;
                return;
            case 5:
                if (f16 > f17) {
                    this.f53806e = f19;
                    this.f53807f = true;
                    this.f53804c = f19;
                    this.f53805d = f19;
                    return;
                }
                this.f53806e = f18;
                this.f53807f = false;
                this.f53804c = f18;
                this.f53805d = f18;
                return;
            case 6:
                if (f16 > f17) {
                    this.f53806e = f19;
                    this.f53807f = true;
                    this.f53804c = f19;
                    this.f53805d = f19;
                    this.f53803b = f11 - (f13 * f19);
                    return;
                }
                this.f53806e = f18;
                this.f53807f = false;
                this.f53804c = f18;
                this.f53805d = f18;
                this.f53802a = f10 - (f12 * f18);
                return;
            case 7:
                this.f53806e = Math.max(f19, f18);
                this.f53807f = f19 > f18;
                this.f53804c = f19;
                this.f53805d = f18;
                return;
            default:
                this.f53806e = f19;
                this.f53807f = true;
                this.f53804c = f19;
                this.f53805d = f19;
                return;
        }
    }

    public final void g() {
        this.f53802a = 0.0f;
        this.f53803b = 0.0f;
        this.f53804c = 1.0f;
        this.f53805d = 1.0f;
        this.f53806e = 1.0f;
        this.f53807f = false;
    }
}
