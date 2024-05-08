package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static z0 f30055a;

    private static synchronized z0 a() {
        z0 z0Var;
        synchronized (a.class) {
            if (f30055a == null) {
                f30055a = q.c().b();
            }
            z0Var = f30055a;
        }
        return z0Var;
    }

    public static void a(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i10 == 1 || i10 == 0) {
            f30055a.a(i10, str, linkedHashMap);
            return;
        }
        v.d("hmsSdk", "Data type no longer collects range.type: " + i10);
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (a() != null) {
            f30055a.a(context, str, str2);
        }
    }

    public static void b(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i10 == 1 || i10 == 0) {
            f30055a.b(i10, str, linkedHashMap);
            return;
        }
        v.d("hmsSdk", "Data type no longer collects range.type: " + i10);
    }

    public static boolean b() {
        return q.c().a();
    }

    public static void c() {
        if (a() == null || !q1.b().a()) {
            return;
        }
        f30055a.a(-1);
    }
}
