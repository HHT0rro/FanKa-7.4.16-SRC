package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ah extends k implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f40009a = "";

    /* renamed from: d, reason: collision with root package name */
    private String f40012d = "";

    /* renamed from: b, reason: collision with root package name */
    public String f40010b = "";

    /* renamed from: e, reason: collision with root package name */
    private String f40013e = "";

    /* renamed from: c, reason: collision with root package name */
    public String f40011c = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40009a, 0);
        String str = this.f40012d;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.f40010b;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        String str3 = this.f40013e;
        if (str3 != null) {
            jVar.a(str3, 3);
        }
        String str4 = this.f40011c;
        if (str4 != null) {
            jVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40009a = iVar.b(0, true);
        this.f40012d = iVar.b(1, false);
        this.f40010b = iVar.b(2, false);
        this.f40013e = iVar.b(3, false);
        this.f40011c = iVar.b(4, false);
    }
}
