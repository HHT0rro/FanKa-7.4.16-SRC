package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n6 {

    /* renamed from: a, reason: collision with root package name */
    public static String f48028a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f48029b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f48030c;

    /* renamed from: d, reason: collision with root package name */
    public static String f48031d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f48032e = String.valueOf((char) 2);

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f48033f = {"--", "a-", "u-", "v-", "o-", "g-"};

    /* renamed from: g, reason: collision with root package name */
    public static String f48034g = null;

    /* renamed from: h, reason: collision with root package name */
    public static volatile boolean f48035h = false;

    public static boolean A(Context context) {
        return context.getPackageManager().checkPermission(com.kuaishou.weapon.p0.g.f36117c, context.getPackageName()) == 0;
    }

    public static String B() {
        return (e(Environment.getDataDirectory()) / 1024) + "KB";
    }

    public static String C(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            fc.c.k(th);
            return null;
        }
    }

    public static String D(Context context) {
        int t2 = t();
        String E = E(context);
        while (E == null) {
            int i10 = t2 - 1;
            if (t2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            E = E(context);
            t2 = i10;
        }
        return E;
    }

    public static String E(Context context) {
        Object obj;
        Object g3;
        Object e2;
        if (g7.k()) {
            return "";
        }
        String str = f48028a;
        if (str != null) {
            return str;
        }
        try {
            String str2 = (!g7.f() || (g3 = k0.g("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (e2 = k0.e(g3, "getMiuiDeviceId", new Object[0])) == null || !(e2 instanceof String)) ? null : (String) String.class.cast(e2);
            if (str2 == null && A(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT < 26) {
                    str2 = telephonyManager.getDeviceId();
                } else {
                    if (1 == telephonyManager.getPhoneType()) {
                        obj = k0.e(telephonyManager, "getImei", null);
                    } else if (2 == telephonyManager.getPhoneType()) {
                        obj = k0.e(telephonyManager, "getMeid", null);
                    }
                    str2 = (String) obj;
                }
            }
            if (!x(str2)) {
                return "";
            }
            f48028a = str2;
            return str2;
        } catch (Throwable th) {
            fc.c.k(th);
            return null;
        }
    }

    public static String F(Context context) {
        int t2 = t();
        String H = H(context);
        while (H == null) {
            int i10 = t2 - 1;
            if (t2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            H = H(context);
            t2 = i10;
        }
        return H;
    }

    public static String G(Context context) {
        Object e2;
        if (g7.k()) {
            return "";
        }
        if (!TextUtils.isEmpty(f48029b)) {
            return f48029b;
        }
        if (!A(context)) {
            return "";
        }
        E(context);
        if (TextUtils.isEmpty(f48028a)) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Integer num = (Integer) k0.e(telephonyManager, "getPhoneCount", new Object[0]);
            if (num == null || num.intValue() <= 1) {
                return "";
            }
            String str = null;
            for (int i10 = 0; i10 < num.intValue(); i10++) {
                if (Build.VERSION.SDK_INT < 26) {
                    e2 = k0.e(telephonyManager, "getDeviceId", Integer.valueOf(i10));
                } else if (1 == telephonyManager.getPhoneType()) {
                    e2 = k0.e(telephonyManager, "getImei", Integer.valueOf(i10));
                } else {
                    if (2 == telephonyManager.getPhoneType()) {
                        e2 = k0.e(telephonyManager, "getMeid", Integer.valueOf(i10));
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(f48028a, str) && x(str)) {
                        f48029b += str + ",";
                    }
                }
                str = (String) e2;
                if (!TextUtils.isEmpty(str)) {
                    f48029b += str + ",";
                }
            }
            int length = f48029b.length();
            if (length > 0) {
                f48029b = f48029b.substring(0, length - 1);
            }
            return f48029b;
        } catch (Exception e10) {
            fc.c.n(e10.toString());
            return "";
        }
    }

    public static String H(Context context) {
        G(context);
        String str = "";
        if (TextUtils.isEmpty(f48029b)) {
            return "";
        }
        for (String str2 : f48029b.split(",")) {
            if (x(str2)) {
                str = str + p0.b(str2) + ",";
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String I(Context context) {
        synchronized (n6.class) {
            String str = f48031d;
            if (str != null) {
                return str;
            }
            String k10 = p0.k(C(context) + f());
            f48031d = k10;
            return k10;
        }
    }

    public static synchronized String J(Context context) {
        String k10;
        synchronized (n6.class) {
            k10 = p0.k(C(context) + ((String) null));
        }
        return k10;
    }

    public static String K(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String L(Context context) {
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        if (r1 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        r1.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0096, code lost:
    
        if (r1 == null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String M(android.content.Context r6) {
        /*
            boolean r0 = w(r6)
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r6 = "not support read lvdd."
            fc.c.i(r6)
            return r1
        Ld:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.lang.String r3 = "/.vdevdir/"
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.lang.String r3 = ".vdevidlocal"
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            if (r0 == 0) goto L6e
            boolean r0 = r2.isFile()     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            if (r0 == 0) goto L6e
            com.xiaomi.push.o7 r6 = com.xiaomi.push.o7.a(r6, r2)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.lang.String r0 = com.xiaomi.push.s7.a(r2)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            if (r3 != 0) goto L54
            java.lang.String r3 = com.xiaomi.push.n6.f48032e     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            java.lang.String[] r0 = r0.split(r3)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            int r3 = r0.length     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            r4 = 2
            if (r3 != r4) goto L54
            r3 = 0
            r3 = r0[r3]     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            r4 = 1
            r0 = r0[r4]     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L66
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L66
            int r4 = d(r3)     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L66
            if (r4 != r0) goto L54
            r1 = r3
        L54:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            if (r0 == 0) goto L62
            com.xiaomi.push.s7.c(r2)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            java.lang.String r0 = "lvdd content invalid, remove it."
            fc.c.l(r0)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
        L62:
            r5 = r1
            r1 = r6
            r6 = r5
            goto L74
        L66:
            r0 = move-exception
            r1 = r6
            goto L9a
        L69:
            r0 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L7e
        L6e:
            java.lang.String r6 = "lvdf not exists"
            fc.c.l(r6)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            r6 = r1
        L74:
            if (r1 == 0) goto L99
        L76:
            r1.b()
            goto L99
        L7a:
            r0 = move-exception
            goto L9a
        L7c:
            r0 = move-exception
            r6 = r1
        L7e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r2.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r3 = "get lvdd failure :"
            r2.append(r3)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L7a
            r2.append(r0)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L7a
            fc.c.i(r0)     // Catch: java.lang.Throwable -> L7a
            if (r1 == 0) goto L99
            goto L76
        L99:
            return r6
        L9a:
            if (r1 == 0) goto L9f
            r1.b()
        L9f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.n6.M(android.content.Context):java.lang.String");
    }

    public static String N(Context context) {
        int t2 = t();
        String E = E(context);
        while (TextUtils.isEmpty(E)) {
            int i10 = t2 - 1;
            if (t2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            E = E(context);
            t2 = i10;
        }
        return E;
    }

    public static double a(double d10) {
        int i10 = 1;
        while (true) {
            double d11 = i10;
            if (d11 >= d10) {
                return d11;
            }
            i10 <<= 1;
        }
    }

    public static float b(int i10) {
        float f10 = ((((((i10 + AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d10 = f10;
        return d10 > 0.5d ? (float) Math.ceil(d10) : f10;
    }

    public static int c() {
        Object g3 = k0.g("android.os.UserHandle", "myUserId", new Object[0]);
        if (g3 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(g3)).intValue();
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            i10 = (i10 * 31) + str.charAt(i11);
        }
        return i10;
    }

    public static long e(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static String f() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return Build.SERIAL;
        }
        if (i10 >= 26) {
            return (String) k0.g("android.os.Build", "getSerial", null);
        }
        return null;
    }

    public static String g(int i10) {
        if (i10 > 0) {
            String[] strArr = f48033f;
            if (i10 < strArr.length) {
                return strArr[i10];
            }
        }
        return f48033f[0];
    }

    public static String h(Context context) {
        return "a-" + p0.k(((String) null) + C(context) + ((String) null));
    }

    public static String i(Context context, boolean z10) {
        if (f48030c == null) {
            String C = C(context);
            String D = !g7.k() ? z10 ? D(context) : N(context) : "";
            String f10 = f();
            int i10 = 1;
            if (!(Build.VERSION.SDK_INT < 26) && s(D) && s(f10)) {
                String a10 = d0.a(context).a();
                if (TextUtils.isEmpty(a10)) {
                    String M = M(context);
                    if (TextUtils.isEmpty(M)) {
                        String b4 = d0.a(context).b();
                        if (TextUtils.isEmpty(b4)) {
                            i10 = 5;
                        } else {
                            i10 = 4;
                            C = b4;
                        }
                    } else {
                        C = M;
                        i10 = 3;
                    }
                } else {
                    C = a10 + C;
                    i10 = 2;
                }
            } else {
                C = D + C + f10;
            }
            fc.c.l("devid rule select:" + i10);
            if (i10 == 3) {
                f48030c = C;
            } else {
                f48030c = g(i10) + p0.k(C);
            }
            q(context, f48030c);
        }
        return f48030c;
    }

    public static void j(Context context, String str) {
        fc.c.m("update vdevid = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f48034g = str;
        o7 o7Var = null;
        try {
            try {
                if (w(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    o7Var = o7.a(context, file2);
                    s7.c(file2);
                    s7.e(file2, f48034g);
                }
                s7.e(new File(context.getFilesDir(), ".vdevid"), f48034g);
                if (o7Var == null) {
                    return;
                }
            } catch (IOException e2) {
                fc.c.i("update vdevid failure :" + e2.getMessage());
                if (o7Var == null) {
                    return;
                }
            }
            o7Var.b();
        } catch (Throwable th) {
            if (o7Var != null) {
                o7Var.b();
            }
            throw th;
        }
    }

    public static void k(Context context, Map<String, String> map) {
        if (map == null || context == null) {
            return;
        }
        String M = M(context);
        if (TextUtils.isEmpty(M)) {
            return;
        }
        map.put("local_virt_devid", M);
    }

    public static boolean l(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i10 = 0;
        while (true) {
            String[] strArr = f48033f;
            if (i10 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i10])) {
                return true;
            }
            i10++;
        }
    }

    public static int n() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return 0;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        }
        return 0;
    }

    public static String o() {
        return b(n()) + "GB";
    }

    public static String p(Context context) {
        try {
            return j.a(context).a();
        } catch (Exception e2) {
            fc.c.i("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    public static void q(Context context, String str) {
        fc.c.m("write lvdd = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        o7 o7Var = null;
        try {
            try {
                if (w(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevidlocal");
                    if (file2.exists() && file2.isFile()) {
                        fc.c.l("vdr exists, not rewrite.");
                        return;
                    }
                    o7Var = o7.a(context, file2);
                    s7.c(file2);
                    s7.e(file2, f48030c + f48032e + d(f48030c));
                    fc.c.l("lvdd write succ.");
                } else {
                    fc.c.i("not support write lvdd.");
                }
                if (o7Var == null) {
                    return;
                }
            } catch (IOException e2) {
                fc.c.i("write lvdd failure :" + e2.getMessage());
                if (0 == 0) {
                    return;
                }
            }
            o7Var.b();
        } catch (Throwable th) {
            if (0 != 0) {
                o7Var.b();
            }
            throw th;
        }
    }

    public static boolean r(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    public static boolean s(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown");
    }

    public static int t() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    public static String u() {
        return a(((e(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    public static String v(Context context) {
        o7 o7Var = null;
        if (!w(context)) {
            return null;
        }
        if (!TextUtils.isEmpty(f48034g)) {
            return f48034g;
        }
        String a10 = s7.a(new File(context.getFilesDir(), ".vdevid"));
        f48034g = a10;
        if (!TextUtils.isEmpty(a10)) {
            return f48034g;
        }
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
                o7Var = o7.a(context, file);
                f48034g = "";
                String a11 = s7.a(file);
                if (a11 != null) {
                    f48034g = a11;
                }
                String str = f48034g;
                if (o7Var != null) {
                    o7Var.b();
                }
                return str;
            } catch (IOException e2) {
                fc.c.i("getVDevID failure :" + e2.getMessage());
                if (o7Var != null) {
                    o7Var.b();
                }
                return f48034g;
            }
        } catch (Throwable th) {
            if (o7Var != null) {
                o7Var.b();
            }
            throw th;
        }
    }

    public static boolean w(Context context) {
        if (!h7.a(context, com.kuaishou.weapon.p0.g.f36124j) || g7.f()) {
            return false;
        }
        boolean z10 = Build.VERSION.SDK_INT >= 26;
        return !z10 ? n7.h(context) : z10;
    }

    public static boolean x(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && p0.l(str) && !p0.m(str);
    }

    public static String y() {
        return n() + "KB";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String z(android.content.Context r6) {
        /*
            boolean r0 = w(r6)
            r1 = 0
            if (r0 == 0) goto Lcb
            boolean r0 = com.xiaomi.push.n6.f48035h
            if (r0 == 0) goto Ld
            goto Lcb
        Ld:
            r0 = 1
            com.xiaomi.push.n6.f48035h = r0
            java.io.File r0 = new java.io.File
            java.io.File r2 = r6.getFilesDir()
            java.lang.String r3 = ".vdevid"
            r0.<init>(r2, r3)
            java.lang.String r0 = com.xiaomi.push.s7.a(r0)
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.lang.String r5 = "/.vdevdir/"
            r2.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            com.xiaomi.push.o7 r2 = com.xiaomi.push.o7.a(r6, r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.lang.String r3 = com.xiaomi.push.s7.a(r4)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> Lc3
            if (r2 == 0) goto L62
            r2.b()
            goto L62
        L3d:
            r3 = move-exception
            goto L44
        L3f:
            r6 = move-exception
            goto Lc5
        L42:
            r3 = move-exception
            r2 = r1
        L44:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r4.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = "check id failure :"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> Lc3
            r4.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> Lc3
            fc.c.i(r3)     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto L61
            r2.b()
        L61:
            r3 = r1
        L62:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto Lbb
            com.xiaomi.push.n6.f48034g = r0
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L85
            int r2 = r3.length()
            r4 = 128(0x80, float:1.794E-43)
            if (r2 <= r4) goto L79
            goto L85
        L79:
            boolean r6 = android.text.TextUtils.equals(r0, r3)
            if (r6 != 0) goto L9c
            java.lang.String r6 = "vid changed, need sync"
            fc.c.i(r6)
            return r3
        L85:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "recover vid :"
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            fc.c.i(r2)
            j(r6, r0)
        L9c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "vdevid = "
            r6.append(r0)
            java.lang.String r0 = com.xiaomi.push.n6.f48034g
            r6.append(r0)
            java.lang.String r0 = " "
            r6.append(r0)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            fc.c.m(r6)
            return r1
        Lbb:
            java.lang.String r6 = "empty local vid"
            fc.c.i(r6)
            java.lang.String r6 = "F*"
            return r6
        Lc3:
            r6 = move-exception
            r1 = r2
        Lc5:
            if (r1 == 0) goto Lca
            r1.b()
        Lca:
            throw r6
        Lcb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.n6.z(android.content.Context):java.lang.String");
    }
}
