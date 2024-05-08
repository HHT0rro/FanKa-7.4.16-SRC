package com.tencent.turingface.sdk.mfa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class sWkeo extends ucT3w implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f45940a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f45941b = "";

    /* renamed from: c, reason: collision with root package name */
    public int f45942c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f45943d = 0;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45940a, 0);
        d5hoq.a(this.f45941b, 1);
        int i10 = this.f45942c;
        if (i10 != 0) {
            d5hoq.a(i10, 3);
        }
        int i11 = this.f45943d;
        if (i11 != 0) {
            d5hoq.a(i11, 4);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f45940a = nyvkz.a(this.f45940a, 0, true);
        this.f45941b = nyvkz.b(1, true);
        this.f45942c = nyvkz.a(this.f45942c, 3, false);
        this.f45943d = nyvkz.a(this.f45943d, 4, false);
    }
}
