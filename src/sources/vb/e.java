package vb;

import java.util.Random;

/* compiled from: SpeeddByComponentsInitializer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e implements b {

    /* renamed from: a, reason: collision with root package name */
    public float f54073a;

    /* renamed from: b, reason: collision with root package name */
    public float f54074b;

    /* renamed from: c, reason: collision with root package name */
    public float f54075c;

    /* renamed from: d, reason: collision with root package name */
    public float f54076d;

    public e(float f10, float f11, float f12, float f13) {
        this.f54073a = f10;
        this.f54074b = f11;
        this.f54075c = f12;
        this.f54076d = f13;
    }

    @Override // vb.b
    public void a(com.plattysoft.leonids.b bVar, Random random) {
        float nextFloat = random.nextFloat();
        float f10 = this.f54074b;
        float f11 = this.f54073a;
        bVar.f38050h = (nextFloat * (f10 - f11)) + f11;
        float nextFloat2 = random.nextFloat();
        float f12 = this.f54076d;
        float f13 = this.f54075c;
        bVar.f38051i = (nextFloat2 * (f12 - f13)) + f13;
    }
}
