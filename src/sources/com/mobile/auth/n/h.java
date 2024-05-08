package com.mobile.auth.n;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.n.k;
import com.mobile.auth.n.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f37510a;

    /* renamed from: b, reason: collision with root package name */
    private static String f37511b;

    /* renamed from: c, reason: collision with root package name */
    private static long f37512c;

    private static int a(String str) {
        String b4;
        if (TextUtils.isEmpty(f37511b)) {
            b4 = k.b("pre_sim_key", "");
            f37511b = b4;
        } else {
            b4 = f37511b;
        }
        if (TextUtils.isEmpty(b4)) {
            return 0;
        }
        return b4.equals(str) ? 1 : 2;
    }

    public static long a() {
        long a10;
        long j10;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(f37510a)) {
            String b4 = k.b("phonescripcache", "");
            a10 = k.a("phonescripstarttime", 0L);
            if (TextUtils.isEmpty(b4)) {
                j10 = 0;
                return Math.max(j10 / 1000, 0L);
            }
        } else {
            c.b("PhoneScripUtils", f37511b + " " + f37512c);
            a10 = f37512c;
        }
        j10 = (a10 - currentTimeMillis) - 10000;
        return Math.max(j10 / 1000, 0L);
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f37510a)) {
            return f37510a;
        }
        String b4 = k.b("phonescripcache", "");
        if (TextUtils.isEmpty(b4)) {
            c.a("PhoneScripUtils", "null");
            return null;
        }
        f37512c = k.a("phonescripstarttime", 0L);
        f37511b = k.b("pre_sim_key", "");
        String b10 = b.b(context, b4);
        f37510a = b10;
        return b10;
    }

    public static void a(final Context context, final String str, long j10, final String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j10 <= 0) {
            return;
        }
        c.b("PhoneScripUtils", "save phone scrip simKey = " + str2);
        f37510a = str;
        long j11 = j10 * 1000;
        f37512c = System.currentTimeMillis() + j11;
        c.b("sLifeTime", f37512c + "");
        f37511b = str2;
        if (!"operator".equals(str3)) {
            n.a(new n.a() { // from class: com.mobile.auth.n.h.1
                @Override // com.mobile.auth.n.n.a
                public void a() {
                    c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                    h.b(context, str, h.f37512c, str2);
                }
            });
        } else if (j11 > 3600000) {
            f37512c = System.currentTimeMillis() + 3600000;
        } else {
            f37512c = System.currentTimeMillis() + j11;
        }
    }

    public static void a(boolean z10, boolean z11) {
        k.a a10 = k.a();
        a10.a("phonescripstarttime");
        a10.a("phonescripcache");
        a10.a("pre_sim_key");
        if (z11) {
            a10.a();
        } else {
            a10.b();
        }
        if (z10) {
            f37510a = null;
            f37511b = null;
            f37512c = 0L;
        }
    }

    private static boolean a(long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        c.b("PhoneScripUtils", j10 + "");
        c.b("PhoneScripUtils", currentTimeMillis + "");
        return j10 - currentTimeMillis > 10000;
    }

    public static boolean a(com.cmic.sso.sdk.a aVar) {
        int a10 = a(aVar.b("scripKey"));
        aVar.a("imsiState", a10 + "");
        c.b("PhoneScripUtils", "simState = " + a10);
        if (k.a("phonescripversion", 0) != 1 && a10 != 0) {
            a(true, false);
            b.a();
            c.b("PhoneScripUtils", "phoneScriptVersion change");
            return false;
        }
        if (a10 == 1) {
            return c();
        }
        if (a10 == 2) {
            a(true, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, long j10, String str2) {
        String a10 = b.a(context, str);
        if (TextUtils.isEmpty(a10)) {
            return;
        }
        k.a a11 = k.a();
        a11.a("phonescripcache", a10);
        a11.a("phonescripstarttime", j10);
        a11.a("phonescripversion", 1);
        a11.a("pre_sim_key", str2);
        a11.b();
    }

    private static boolean c() {
        if (TextUtils.isEmpty(f37510a)) {
            return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0L));
        }
        c.b("PhoneScripUtils", f37511b + " " + f37512c);
        return a(f37512c);
    }
}
