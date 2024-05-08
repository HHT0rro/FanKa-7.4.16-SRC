package com.tencent.bugly.idasc.proguard;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bs extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f39835a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f39836b = "";

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39835a = kVar.b(0, true);
        this.f39836b = kVar.b(1, true);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39835a, 0);
        lVar.a(this.f39836b, 1);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }
}
