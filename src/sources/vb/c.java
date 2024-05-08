package vb;

import java.util.Random;

/* compiled from: RotationInitiazer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public int f54069a;

    /* renamed from: b, reason: collision with root package name */
    public int f54070b;

    public c(int i10, int i11) {
        this.f54069a = i10;
        this.f54070b = i11;
    }

    @Override // vb.b
    public void a(com.plattysoft.leonids.b bVar, Random random) {
        bVar.f38048f = random.nextInt(this.f54070b - this.f54069a) + this.f54069a;
    }
}
