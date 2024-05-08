package vb;

import java.util.Random;

/* compiled from: AccelerationInitializer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public float f54065a;

    /* renamed from: b, reason: collision with root package name */
    public float f54066b;

    /* renamed from: c, reason: collision with root package name */
    public int f54067c;

    /* renamed from: d, reason: collision with root package name */
    public int f54068d;

    public a(float f10, float f11, int i10, int i11) {
        this.f54065a = f10;
        this.f54066b = f11;
        this.f54067c = i10;
        this.f54068d = i11;
    }

    @Override // vb.b
    public void a(com.plattysoft.leonids.b bVar, Random random) {
        int i10 = this.f54067c;
        float f10 = i10;
        int i11 = this.f54068d;
        if (i11 != i10) {
            f10 = random.nextInt(i11 - i10) + this.f54067c;
        }
        float f11 = (float) ((f10 * 3.141592653589793d) / 180.0d);
        float nextFloat = random.nextFloat();
        float f12 = this.f54066b;
        float f13 = this.f54065a;
        double d10 = (nextFloat * (f12 - f13)) + f13;
        double d11 = f11;
        bVar.f38052j = (float) (Math.cos(d11) * d10);
        bVar.f38053k = (float) (d10 * Math.sin(d11));
    }
}
