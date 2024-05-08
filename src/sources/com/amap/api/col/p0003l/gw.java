package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gw {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6162a = "/a/";

    /* renamed from: b, reason: collision with root package name */
    public static final String f6163b = "b";

    /* renamed from: c, reason: collision with root package name */
    public static final String f6164c = "c";

    /* renamed from: d, reason: collision with root package name */
    public static final String f6165d = "d";

    /* renamed from: e, reason: collision with root package name */
    public static String f6166e = "s";

    /* renamed from: f, reason: collision with root package name */
    public static final String f6167f = "g";

    /* renamed from: g, reason: collision with root package name */
    public static final String f6168g = "h";

    /* renamed from: h, reason: collision with root package name */
    public static final String f6169h = "e";

    /* renamed from: i, reason: collision with root package name */
    public static final String f6170i = "f";

    /* renamed from: j, reason: collision with root package name */
    public static final String f6171j = "j";

    /* renamed from: k, reason: collision with root package name */
    public static final String f6172k = "k";

    /* renamed from: l, reason: collision with root package name */
    private static long f6173l;

    /* renamed from: m, reason: collision with root package name */
    private static Vector<fu> f6174m = new Vector<>();

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f6162a + str;
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
            if (System.currentTimeMillis() - f6173l < 60000) {
                return;
            }
            f6173l = System.currentTimeMillis();
            jd.a().a(new je() { // from class: com.amap.api.col.3l.gw.1
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    try {
                        gz.b(context);
                        gz.d(context);
                        gz.c(context);
                        im.a(context);
                        ik.a(context);
                    } catch (RejectedExecutionException unused) {
                    } catch (Throwable th) {
                        gy.b(th, "Lg", "proL");
                    }
                }
            });
        } catch (Throwable th) {
            gy.b(th, "Lg", "proL");
        }
    }

    public static void a(fu fuVar) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (fuVar == null) {
                    return;
                }
                if (f6174m.contains(fuVar)) {
                    return;
                }
                f6174m.add(fuVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static List<fu> a() {
        Vector<fu> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f6174m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f6174m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.gw.a(java.lang.String[], java.lang.String):boolean");
    }
}
