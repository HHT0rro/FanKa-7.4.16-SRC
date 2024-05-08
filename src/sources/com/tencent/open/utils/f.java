package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static Context f45296a;

    public static final Context a() {
        Context context = f45296a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context a10 = a();
        if (a10 != null) {
            return a10.getCacheDir();
        }
        return null;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final void a(Context context) {
        f45296a = context;
    }

    public static final File a(String str) {
        return l.h(a(), str);
    }
}
