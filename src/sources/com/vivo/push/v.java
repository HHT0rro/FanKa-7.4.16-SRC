package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: PushCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private int f46457a;

    /* renamed from: b, reason: collision with root package name */
    private String f46458b;

    public v(int i10) {
        this.f46457a = -1;
        if (i10 >= 0) {
            this.f46457a = i10;
            return;
        }
        throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
    }

    private void e(d dVar) {
        dVar.a("command", this.f46457a);
        dVar.a("client_pkgname", this.f46458b);
        c(dVar);
    }

    public final String a() {
        return this.f46458b;
    }

    public final int b() {
        return this.f46457a;
    }

    public abstract void c(d dVar);

    public boolean c() {
        return false;
    }

    public abstract void d(d dVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f46458b = str;
    }

    public final void b(Intent intent) {
        d a10 = d.a(intent);
        if (a10 == null) {
            com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            return;
        }
        a10.a("method", this.f46457a);
        e(a10);
        Bundle b4 = a10.b();
        if (b4 != null) {
            intent.putExtras(b4);
        }
    }

    public final void a(Intent intent) {
        d a10 = d.a(intent);
        if (a10 == null) {
            com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a10);
        Bundle b4 = a10.b();
        if (b4 != null) {
            intent.putExtras(b4);
        }
    }

    public final void a(d dVar) {
        String a10 = x.a(this.f46457a);
        if (a10 == null) {
            a10 = "";
        }
        dVar.a("method", a10);
        e(dVar);
    }

    public final void b(d dVar) {
        String a10 = dVar.a();
        if (!TextUtils.isEmpty(a10)) {
            this.f46458b = a10;
        } else {
            this.f46458b = dVar.a("client_pkgname");
        }
        d(dVar);
    }
}
