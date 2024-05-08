package com.vivo.push;

import android.content.Context;

/* compiled from: PushClientTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public Context f46360a;

    /* renamed from: b, reason: collision with root package name */
    private int f46361b;

    /* renamed from: c, reason: collision with root package name */
    private v f46362c;

    public s(v vVar) {
        this.f46361b = -1;
        this.f46362c = vVar;
        int b4 = vVar.b();
        this.f46361b = b4;
        if (b4 >= 0) {
            this.f46360a = m.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.f46361b;
    }

    public abstract void a(v vVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f46360a;
        if (context != null && !(this.f46362c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.u.a(context, "[执行指令]" + ((Object) this.f46362c));
        }
        a(this.f46362c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        v vVar = this.f46362c;
        sb2.append(vVar == null ? "[null]" : vVar.toString());
        sb2.append(com.alipay.sdk.util.i.f4738d);
        return sb2.toString();
    }
}
