package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i4 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile i4 f47521b;

    /* renamed from: a, reason: collision with root package name */
    public Context f47522a;

    public i4(Context context) {
        this.f47522a = context;
    }

    public static i4 a(Context context) {
        if (f47521b == null) {
            synchronized (i4.class) {
                if (f47521b == null) {
                    f47521b = new i4(context);
                }
            }
        }
        return f47521b;
    }

    public final void b(gc.d dVar) {
        if (dVar instanceof gc.c) {
            hc.a.c(this.f47522a, (gc.c) dVar);
        } else if (dVar instanceof gc.b) {
            hc.a.b(this.f47522a, (gc.b) dVar);
        }
    }

    public void c(String str, int i10, long j10, long j11) {
        if (i10 < 0 || j11 < 0 || j10 <= 0) {
            return;
        }
        gc.c i11 = h4.i(this.f47522a, i10, j10, j11);
        i11.a(str);
        i11.b("3_7_6");
        b(i11);
    }

    public void d(String str, Intent intent, int i10, String str2) {
        if (intent == null) {
            return;
        }
        f(str, h4.j(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i10, System.currentTimeMillis(), str2);
    }

    public void e(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        f(str, h4.j(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
    }

    public void f(String str, String str2, String str3, int i10, long j10, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        gc.b f10 = h4.f(this.f47522a, str2, str3, i10, j10, str4);
        f10.a(str);
        f10.b("3_7_6");
        b(f10);
    }

    public void g(String str, String str2, String str3, int i10, String str4) {
        f(str, str2, str3, i10, System.currentTimeMillis(), str4);
    }

    public void h(String str, String str2, String str3, String str4) {
        f(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void i(String str, String str2, String str3, String str4) {
        f(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    public void j(String str, String str2, String str3, String str4) {
        f(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }
}
