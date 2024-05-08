package com.tencent.bugly.idasc.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bg;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<a> f39497a = new ArrayList<a>() { // from class: com.tencent.bugly.idasc.proguard.ab.1
        {
            byte b4 = 0;
            add(new l(b4));
            add(new f(b4));
            add(new g(b4));
            add(new m(b4));
            add(new h(b4));
            add(new i(b4));
            add(new k(b4));
            add(new e(b4));
            add(new j(b4));
            add(new b(b4));
            add(new d(b4));
            add(new c(b4));
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Integer, String> f39498b = new HashMap<Integer, String>() { // from class: com.tencent.bugly.idasc.proguard.ab.2
        {
            put(1, "GPRS");
            put(2, "EDGE");
            put(3, "UMTS");
            put(8, "HSDPA");
            put(9, "HSUPA");
            put(10, "HSPA");
            put(4, "CDMA");
            put(5, "EVDO_0");
            put(6, "EVDO_A");
            put(7, "1xRTT");
            put(11, "iDen");
            put(12, "EVDO_B");
            put(13, "LTE");
            put(14, "eHRPD");
            put(15, "HSPA+");
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f39499c = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a {
        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }

        public abstract String a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends a {
        private b() {
            super((byte) 0);
        }

        public /* synthetic */ b(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.gn.gnromvernumber");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "amigo/" + a10 + "/" + ap.a("ro.build.display.id");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends a {
        private c() {
            super((byte) 0);
        }

        public /* synthetic */ c(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            return ap.a("ro.build.fingerprint") + "/" + ap.a("ro.build.rom.id");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d extends a {
        private d() {
            super((byte) 0);
        }

        public /* synthetic */ d(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.build.tyd.kbstyle_version");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "dido/".concat(a10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e extends a {
        private e() {
            super((byte) 0);
        }

        public /* synthetic */ e(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.aa.romver");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "htc/" + a10 + "/" + ap.a("ro.build.description");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class f extends a {
        private f() {
            super((byte) 0);
        }

        public /* synthetic */ f(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.build.version.emui");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "HuaWei/EMOTION/".concat(a10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class g extends a {
        private g() {
            super((byte) 0);
        }

        public /* synthetic */ g(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.lenovo.series");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "Lenovo/VIBE/".concat(String.valueOf(ap.a("ro.build.version.incremental")));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class h extends a {
        private h() {
            super((byte) 0);
        }

        public /* synthetic */ h(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.meizu.product.model");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "Meizu/FLYME/" + ap.a("ro.build.display.id");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class i extends a {
        private i() {
            super((byte) 0);
        }

        public /* synthetic */ i(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.build.version.opporom");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "Oppo/COLOROS/".concat(a10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class j extends a {
        private j() {
            super((byte) 0);
        }

        public /* synthetic */ j(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.lewa.version");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "tcl/" + a10 + "/" + ap.a("ro.build.display.id");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class k extends a {
        private k() {
            super((byte) 0);
        }

        public /* synthetic */ k(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.vivo.os.build.display.id");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "vivo/FUNTOUCH/".concat(a10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class l extends a {
        private l() {
            super((byte) 0);
        }

        public /* synthetic */ l(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.miui.ui.version.name");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "XiaoMi/MIUI/".concat(a10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m extends a {
        private m() {
            super((byte) 0);
        }

        public /* synthetic */ m(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a10 = ap.a("ro.build.nubia.rom.name");
            if (ap.b(a10) || a10.equals(bg.b.S)) {
                return null;
            }
            return "Zte/NUBIA/" + a10 + "_" + ap.a("ro.build.nubia.rom.code");
        }
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (al.a(th)) {
                return bg.b.S;
            }
            th.printStackTrace();
            return bg.b.S;
        }
    }

    public static String a(Context context) {
        if (context != null && context.getApplicationInfo() != null) {
            String str = context.getApplicationInfo().nativeLibraryDir;
            if (TextUtils.isEmpty(str)) {
                return bg.b.S;
            }
            if (str.endsWith("arm")) {
                return "armeabi-v7a";
            }
            if (str.endsWith("arm64")) {
                return "arm64-v8a";
            }
            if (str.endsWith("x86")) {
                return "x86";
            }
            if (str.endsWith("x86_64")) {
                return "x86_64";
            }
        }
        return bg.b.S;
    }

    public static long b(Context context) {
        long pss;
        ActivityManager activityManager;
        try {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } catch (Throwable unused) {
            pss = Debug.getPss();
        }
        if (activityManager == null) {
            return 0L;
        }
        pss = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
        return pss * 1024;
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (al.a(th)) {
                return bg.b.S;
            }
            th.printStackTrace();
            return bg.b.S;
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String c(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        String str = "unknown";
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            e = e2;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            int networkType = telephonyManager.getNetworkType();
            String str2 = f39498b.get(Integer.valueOf(networkType));
            if (str2 == null) {
                try {
                    str = "MOBILE(" + networkType + ")";
                } catch (Exception e10) {
                    e = e10;
                    str = str2;
                    if (!al.a(e)) {
                        e.printStackTrace();
                    }
                    return str;
                }
            } else {
                str = str2;
            }
        }
        return str;
    }

    public static String d() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th) {
            if (al.a(th)) {
                return bg.b.S;
            }
            th.printStackTrace();
            return bg.b.S;
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        r0 = java.lang.Long.parseLong(r2.replaceAll("[^\\d]", ""));
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x002e -> B:13:0x0040). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long g() {
        /*
            r0 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L34
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L34
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L34
        Lf:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L29
            java.lang.String r4 = "VmSize"
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L32
            if (r4 == 0) goto Lf
            java.lang.String r4 = "[^\\d]"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replaceAll(r4, r5)     // Catch: java.lang.Throwable -> L32
            long r0 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L32
        L29:
            r3.close()     // Catch: java.lang.Throwable -> L2d
            goto L40
        L2d:
            r2 = move-exception
            r2.printStackTrace()
            goto L40
        L32:
            r2 = move-exception
            goto L38
        L34:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L38:
            com.tencent.bugly.idasc.proguard.al.a(r2)     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L40
            r3.close()     // Catch: java.lang.Throwable -> L2d
        L40:
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r2
            return r0
        L45:
            r0 = move-exception
            if (r3 == 0) goto L50
            r3.close()     // Catch: java.lang.Throwable -> L4c
            goto L50
        L4c:
            r1 = move-exception
            r1.printStackTrace()
        L50:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.ab.g():long");
    }

    public static long h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!al.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e10) {
                    if (!al.a(e10)) {
                        e10.printStackTrace();
                    }
                }
                return parseLong;
            }
            try {
                bufferedReader.close();
            } catch (IOException e11) {
                if (!al.a(e11)) {
                    e11.printStackTrace();
                }
            }
            try {
                fileReader.close();
                return -1L;
            } catch (IOException e12) {
                if (al.a(e12)) {
                    return -1L;
                }
                e12.printStackTrace();
                return -1L;
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e13) {
                        if (!al.a(e13)) {
                            e13.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e14) {
                    if (al.a(e14)) {
                        return -2L;
                    }
                    e14.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e15) {
                        if (!al.a(e15)) {
                            e15.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e16) {
                        if (!al.a(e16)) {
                            e16.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    public static long j() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!al.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e10) {
                    if (!al.a(e10)) {
                        e10.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e11) {
                    if (!al.a(e11)) {
                        e11.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e12) {
                    if (!al.a(e12)) {
                        e12.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(parseLong2);
            long j10 = parseLong + (parseLong2 * 1024);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e13) {
                    if (!al.a(e13)) {
                        e13.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e14) {
                    if (!al.a(e14)) {
                        e14.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong3 = j10 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e15) {
                if (!al.a(e15)) {
                    e15.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e16) {
                if (!al.a(e16)) {
                    e16.printStackTrace();
                }
            }
            return parseLong3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e17) {
                        if (!al.a(e17)) {
                            e17.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e18) {
                    if (al.a(e18)) {
                        return -2L;
                    }
                    e18.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e19) {
                        if (!al.a(e19)) {
                            e19.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e20) {
                        if (!al.a(e20)) {
                            e20.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    public static long k() {
        if (!s()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (al.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long l() {
        if (!s()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (al.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String m() {
        return "";
    }

    public static String n() {
        Iterator<a> iterator2 = f39497a.iterator2();
        while (iterator2.hasNext()) {
            String a10 = iterator2.next().a();
            if (!TextUtils.isEmpty(a10)) {
                return a10;
            }
        }
        return null;
    }

    public static boolean o() {
        return !TextUtils.isEmpty(new i((byte) 0).a());
    }

    public static boolean p() {
        return !TextUtils.isEmpty(new k((byte) 0).a());
    }

    public static boolean q() {
        boolean z10;
        String[] strArr = f39499c;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (new File(strArr[i10]).exists()) {
                z10 = true;
                break;
            }
            i10++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z10;
    }

    public static boolean r() {
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f10 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f11 = maxMemory - f10;
        al.c("maxMemory : %f", Float.valueOf(maxMemory));
        al.c("totalMemory : %f", Float.valueOf(f10));
        al.c("freeMemory : %f", Float.valueOf(f11));
        return f11 < 10.0f;
    }

    private static boolean s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }
}
