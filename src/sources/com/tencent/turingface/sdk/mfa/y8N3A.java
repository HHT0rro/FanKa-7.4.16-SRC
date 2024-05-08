package com.tencent.turingface.sdk.mfa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class y8N3A extends ucT3w {

    /* renamed from: a, reason: collision with root package name */
    public String f45991a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f45992b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f45993c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f45994d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f45995e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f45996f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f45997g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f45998h = "";

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45991a, 0);
        String str = this.f45992b;
        if (str != null) {
            d5hoq.a(str, 1);
        }
        d5hoq.a(this.f45993c, 2);
        d5hoq.a(this.f45994d, 3);
        d5hoq.a(this.f45995e, 4);
        d5hoq.a(this.f45996f, 5);
        String str2 = this.f45997g;
        if (str2 != null) {
            d5hoq.a(str2, 6);
        }
        String str3 = this.f45998h;
        if (str3 != null) {
            d5hoq.a(str3, 7);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f45991a = nyvkz.b(0, true);
        this.f45992b = nyvkz.b(1, false);
        this.f45993c = nyvkz.b(2, true);
        this.f45994d = nyvkz.a(this.f45994d, 3, true);
        this.f45995e = nyvkz.b(4, true);
        this.f45996f = nyvkz.b(5, true);
        this.f45997g = nyvkz.b(6, false);
        this.f45998h = nyvkz.b(7, false);
    }
}
