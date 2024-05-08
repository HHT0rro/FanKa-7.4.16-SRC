package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y5 {

    /* renamed from: a, reason: collision with root package name */
    public static r f48511a = new r(true);

    /* renamed from: b, reason: collision with root package name */
    public static volatile int f48512b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static long f48513c = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f48514d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static List<a> f48515e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f, reason: collision with root package name */
    public static String f48516f = "";

    /* renamed from: g, reason: collision with root package name */
    public static jc.a f48517g = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f48518a;

        /* renamed from: b, reason: collision with root package name */
        public long f48519b;

        /* renamed from: c, reason: collision with root package name */
        public int f48520c;

        /* renamed from: d, reason: collision with root package name */
        public int f48521d;

        /* renamed from: e, reason: collision with root package name */
        public String f48522e;

        /* renamed from: f, reason: collision with root package name */
        public long f48523f;

        public a(String str, long j10, int i10, int i11, String str2, long j11) {
            this.f48518a = str;
            this.f48519b = j10;
            this.f48520c = i10;
            this.f48521d = i11;
            this.f48522e = str2;
            this.f48523f = j11;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f48518a, this.f48518a) && TextUtils.equals(aVar.f48522e, this.f48522e) && aVar.f48520c == this.f48520c && aVar.f48521d == this.f48521d && Math.abs(aVar.f48519b - this.f48519b) <= 5000;
        }
    }

    public static int a(Context context) {
        if (f48512b == -1) {
            f48512b = n(context);
        }
        return f48512b;
    }

    public static int b(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    public static long c(int i10, long j10, boolean z10, long j11, boolean z11) {
        if (z10 && z11) {
            long j12 = f48513c;
            f48513c = j11;
            if (j11 - j12 > 30000 && j10 > 1024) {
                return j10 * 2;
            }
        }
        return (j10 * (i10 == 0 ? 13 : 11)) / 10;
    }

    public static synchronized String e(Context context) {
        synchronized (y5.class) {
            if (TextUtils.isEmpty(f48516f)) {
                return "";
            }
            return f48516f;
        }
    }

    public static jc.a g(Context context) {
        jc.a aVar = f48517g;
        if (aVar != null) {
            return aVar;
        }
        jc.a aVar2 = new jc.a(context);
        f48517g = aVar2;
        return aVar2;
    }

    public static void h(Context context) {
        f48512b = n(context);
    }

    public static void i(Context context, String str, long j10, boolean z10, long j11) {
        int a10;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a10 = a(context))) {
            return;
        }
        synchronized (f48514d) {
            isEmpty = f48515e.isEmpty();
            l(new a(str, j11, a10, z10 ? 1 : 0, a10 == 0 ? e(context) : "", j10));
        }
        if (isEmpty) {
            f48511a.f(new z5(context), 5000L);
        }
    }

    public static void j(Context context, String str, long j10, boolean z10, boolean z11, long j11) {
        i(context, str, c(a(context), j10, z10, j11, z11), z10, j11);
    }

    public static void l(a aVar) {
        for (a aVar2 : f48515e) {
            if (aVar2.a(aVar)) {
                aVar2.f48523f += aVar.f48523f;
                return;
            }
        }
        f48515e.add(aVar);
    }

    public static synchronized void m(String str) {
        synchronized (y5.class) {
            if (!g7.k() && !TextUtils.isEmpty(str)) {
                f48516f = str;
            }
        }
    }

    public static int n(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void o(Context context, List<a> list) {
        try {
            synchronized (jc.a.f50558c) {
                SQLiteDatabase writableDatabase = g(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f48518a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f48519b));
                        contentValues.put("network_type", Integer.valueOf(aVar.f48520c));
                        contentValues.put("bytes", Long.valueOf(aVar.f48523f));
                        contentValues.put("rcv", Integer.valueOf(aVar.f48521d));
                        contentValues.put("imsi", aVar.f48522e);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e2) {
            fc.c.k(e2);
        }
    }
}
