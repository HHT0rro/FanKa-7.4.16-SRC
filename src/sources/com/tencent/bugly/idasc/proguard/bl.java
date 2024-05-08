package com.tencent.bugly.idasc.proguard;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bl extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f39759a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f39760b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f39761c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f39762d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f39763e = "";

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39759a = kVar.b(0, true);
        this.f39760b = kVar.b(1, false);
        this.f39761c = kVar.b(2, false);
        this.f39762d = kVar.b(3, false);
        this.f39763e = kVar.b(4, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39759a, 0);
        String str = this.f39760b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f39761c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        String str3 = this.f39762d;
        if (str3 != null) {
            lVar.a(str3, 3);
        }
        String str4 = this.f39763e;
        if (str4 != null) {
            lVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }
}
