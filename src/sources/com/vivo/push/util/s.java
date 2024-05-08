package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;

/* compiled from: LogController.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s implements t {

    /* renamed from: a, reason: collision with root package name */
    private static final String f46451a = "(" + Process.myPid() + ")";

    @Override // com.vivo.push.util.t
    public final int a(String str, String str2) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f46451a + str2);
    }

    @Override // com.vivo.push.util.t
    public final int b(String str, String str2) {
        return Log.w("VivoPush.Client.".concat(String.valueOf(str)), f46451a + str2);
    }

    @Override // com.vivo.push.util.t
    public final int c(String str, String str2) {
        return Log.d("VivoPush.Client.".concat(String.valueOf(str)), f46451a + str2);
    }

    @Override // com.vivo.push.util.t
    public final int d(String str, String str2) {
        if (!u.a()) {
            return -1;
        }
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f46451a + str2);
    }

    @Override // com.vivo.push.util.t
    public final int e(String str, String str2) {
        if (!u.a()) {
            return -1;
        }
        return Log.v("VivoPush.Client.".concat(String.valueOf(str)), f46451a + str2);
    }

    @Override // com.vivo.push.util.t
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.t
    public final int b(String str, String str2, Throwable th) {
        if (!u.a()) {
            return -1;
        }
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f46451a + str2, th);
    }

    @Override // com.vivo.push.util.t
    public final void c(Context context, String str) {
        if (a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.t
    public final void b(Context context, String str) {
        if (a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.t
    public final int a(String str, String str2, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f46451a + str2, th);
    }

    @Override // com.vivo.push.util.t
    public final String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    @Override // com.vivo.push.util.t
    public final void a(Context context, String str) {
        if (a()) {
            a(context, str, 0);
        }
    }

    private void a(Context context, String str, int i10) {
        com.vivo.push.b.n nVar = new com.vivo.push.b.n();
        nVar.b(str);
        nVar.a(i10);
        if (i10 > 0) {
            d("LogController", str);
        }
        nVar.g();
        com.vivo.push.a.a.a(context, nVar, context.getPackageName());
    }

    private static boolean a() {
        u.a();
        return com.vivo.push.g.a.a().b();
    }
}
