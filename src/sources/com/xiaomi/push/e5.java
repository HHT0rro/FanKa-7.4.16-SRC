package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e5 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f47211b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b5 f47212c;

    public e5(b5 b5Var, String str) {
        this.f47212c = b5Var;
        this.f47211b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        v1.c().b(this.f47211b, true);
    }
}
