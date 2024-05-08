package com.tencent.turingface.sdk.mfa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ShGzN extends ucT3w {

    /* renamed from: a, reason: collision with root package name */
    public int f45708a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f45709b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f45710c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f45711d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f45712e = 0;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45708a, 0);
        d5hoq.a(this.f45709b, 1);
        d5hoq.a(this.f45710c, 2);
        d5hoq.a(this.f45711d, 3);
        d5hoq.a(this.f45712e, 4);
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f45708a = nyvkz.a(this.f45708a, 0, true);
        this.f45709b = nyvkz.b(1, true);
        this.f45710c = nyvkz.b(2, true);
        this.f45711d = nyvkz.b(3, true);
        this.f45712e = nyvkz.a(this.f45712e, 4, true);
    }
}
