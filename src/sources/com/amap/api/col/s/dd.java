package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dd {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7649a = "/a/";

    /* renamed from: b, reason: collision with root package name */
    public static final String f7650b = "b";

    /* renamed from: c, reason: collision with root package name */
    public static final String f7651c = "c";

    /* renamed from: d, reason: collision with root package name */
    public static final String f7652d = "d";

    /* renamed from: e, reason: collision with root package name */
    public static String f7653e = "s";

    /* renamed from: f, reason: collision with root package name */
    public static final String f7654f = "g";

    /* renamed from: g, reason: collision with root package name */
    public static final String f7655g = "h";

    /* renamed from: h, reason: collision with root package name */
    public static final String f7656h = "e";

    /* renamed from: i, reason: collision with root package name */
    public static final String f7657i = "f";

    /* renamed from: j, reason: collision with root package name */
    public static final String f7658j = "j";

    /* renamed from: k, reason: collision with root package name */
    public static final String f7659k = "k";

    /* renamed from: l, reason: collision with root package name */
    private static long f7660l;

    /* renamed from: m, reason: collision with root package name */
    private static Vector<ch> f7661m = new Vector<>();

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f7649a + str;
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static boolean b(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void a(final Context context) {
        try {
            if (System.currentTimeMillis() - f7660l < 60000) {
                return;
            }
            f7660l = System.currentTimeMillis();
            ex.a().b(new ey() { // from class: com.amap.api.col.s.dd.1
                @Override // com.amap.api.col.s.ey
                public final void a() {
                    try {
                        dg.b(context);
                        dg.d(context);
                        dg.c(context);
                        eg.a(context);
                        ee.a(context);
                    } catch (RejectedExecutionException unused) {
                    } catch (Throwable th) {
                        df.c(th, "Lg", "proL");
                    }
                }
            });
        } catch (Throwable th) {
            df.c(th, "Lg", "proL");
        }
    }

    public static void a(ch chVar) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (chVar == null) {
                    return;
                }
                if (f7661m.contains(chVar)) {
                    return;
                }
                f7661m.add(chVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static List<ch> a() {
        Vector<ch> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f7661m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f7661m;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        r1 = r7.length;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        if (r2 >= r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (b(r6, r7[r2].trim()) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String[] r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L4d
            if (r7 != 0) goto L6
            goto L4d
        L6:
            java.lang.String r1 = "\n"
            java.lang.String[] r7 = r7.split(r1)     // Catch: java.lang.Throwable -> L49
            int r1 = r7.length     // Catch: java.lang.Throwable -> L49
            r2 = 0
        Le:
            r3 = 1
            if (r2 >= r1) goto L35
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L49
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L49
            if (r5 != 0) goto L2e
            java.lang.String r5 = "at "
            boolean r5 = r4.startsWith(r5)     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L2e
            java.lang.String r5 = "uncaughtException"
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L2e
            goto L2f
        L2e:
            r3 = 0
        L2f:
            if (r3 == 0) goto L32
            return r0
        L32:
            int r2 = r2 + 1
            goto Le
        L35:
            int r1 = r7.length     // Catch: java.lang.Throwable -> L49
            r2 = 0
        L37:
            if (r2 >= r1) goto L4d
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L49
            boolean r4 = b(r6, r4)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L46
            return r3
        L46:
            int r2 = r2 + 1
            goto L37
        L49:
            r6 = move-exception
            r6.printStackTrace()
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dd.a(java.lang.String[], java.lang.String):boolean");
    }
}
