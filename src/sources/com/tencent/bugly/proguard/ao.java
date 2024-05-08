package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ao extends k implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f40085a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f40086b = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40085a, 0);
        jVar.a(this.f40086b, 1);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40085a = iVar.b(0, true);
        this.f40086b = iVar.b(1, true);
    }
}
