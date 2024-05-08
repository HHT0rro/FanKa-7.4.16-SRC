package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h2 implements fc.a {

    /* renamed from: a, reason: collision with root package name */
    public fc.a f47354a;

    /* renamed from: b, reason: collision with root package name */
    public fc.a f47355b;

    public h2(fc.a aVar, fc.a aVar2) {
        this.f47354a = aVar;
        this.f47355b = aVar2;
    }

    @Override // fc.a
    public void log(String str) {
        fc.a aVar = this.f47354a;
        if (aVar != null) {
            aVar.log(str);
        }
        fc.a aVar2 = this.f47355b;
        if (aVar2 != null) {
            aVar2.log(str);
        }
    }

    @Override // fc.a
    public void log(String str, Throwable th) {
        fc.a aVar = this.f47354a;
        if (aVar != null) {
            aVar.log(str, th);
        }
        fc.a aVar2 = this.f47355b;
        if (aVar2 != null) {
            aVar2.log(str, th);
        }
    }
}
