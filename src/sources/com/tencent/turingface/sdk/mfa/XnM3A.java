package com.tencent.turingface.sdk.mfa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class XnM3A extends ucT3w {

    /* renamed from: a, reason: collision with root package name */
    public int f45722a = 0;

    /* renamed from: b, reason: collision with root package name */
    public float f45723b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f45724c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f45725d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f45726e = 0.0f;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45722a, 0);
        d5hoq.a(this.f45723b, 1);
        d5hoq.a(this.f45724c, 2);
        float f10 = this.f45725d;
        if (f10 != 0.0f) {
            d5hoq.a(f10, 3);
        }
        float f11 = this.f45726e;
        if (f11 != 0.0f) {
            d5hoq.a(f11, 4);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f45722a = nyvkz.a(this.f45722a, 0, true);
        this.f45723b = nyvkz.a(this.f45723b, 1, true);
        this.f45724c = nyvkz.a(this.f45724c, 2, true);
        this.f45725d = nyvkz.a(this.f45725d, 3, false);
        this.f45726e = nyvkz.a(this.f45726e, 4, false);
    }
}
