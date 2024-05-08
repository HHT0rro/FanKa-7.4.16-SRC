package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s6 {

    /* renamed from: a, reason: collision with root package name */
    public final x6 f48150a;

    /* renamed from: b, reason: collision with root package name */
    public final d7 f48151b;

    public s6(jo joVar) {
        d7 d7Var = new d7();
        this.f48151b = d7Var;
        this.f48150a = joVar.a(d7Var);
    }

    public void a(jb jbVar, byte[] bArr) {
        try {
            this.f48151b.h(bArr);
            jbVar.a(this.f48150a);
        } finally {
            this.f48150a.I();
        }
    }
}
