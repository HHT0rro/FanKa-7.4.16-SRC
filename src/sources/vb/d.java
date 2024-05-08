package vb;

import java.util.Random;

/* compiled from: ScaleInitializer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public float f54071a;

    /* renamed from: b, reason: collision with root package name */
    public float f54072b;

    public d(float f10, float f11) {
        this.f54072b = f10;
        this.f54071a = f11;
    }

    @Override // vb.b
    public void a(com.plattysoft.leonids.b bVar, Random random) {
        float nextFloat = random.nextFloat();
        float f10 = this.f54071a;
        float f11 = this.f54072b;
        bVar.f38046d = (nextFloat * (f10 - f11)) + f11;
    }
}
