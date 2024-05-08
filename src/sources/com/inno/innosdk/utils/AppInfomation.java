package com.inno.innosdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.android.internal.os.PowerProfile;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kuaishou.weapon.p0.an;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppInfomation {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f35538a = {"com.jifen.ac"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f35539b = {"com.jifen.ac"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f35540c = {"goldfish"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f35541d = {"/system/bin/androVM-prop", "/system/bin/microvirt-prop", "/system/lib/libdroid4x.so", "/system/bin/windroyed", "/system/bin/microvirtd", "/system/bin/nox-prop", "/system/bin/ttVM-prop", "/system/bin/droid4x-prop", "/data/.bluestacks.prop"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f35542e = {"/data/app/com.bluestacks.appmart-1.apk", "/data/app/com.bluestacks.BstCommandProcessor-1.apk", "/data/app/com.bluestacks.help-1.apk", "/data/app/com.bluestacks.home-1.apk", "/data/app/com.bluestacks.s2p-1.apk", "/data/app/com.bluestacks.searchapp-1.apk", "/data/bluestacks.prop", "/data/data/com.androVM.vmconfig", "/data/data/com.bluestacks.accelerometerui", "/data/data/com.bluestacks.appfinder", "/data/data/com.bluestacks.appmart", "/data/data/com.bluestacks.appsettings", "/data/data/com.bluestacks.BstCommandProcessor", "/data/data/com.bluestacks.bstfolder", "/data/data/com.bluestacks.help", "/data/data/com.bluestacks.home", "/data/data/com.bluestacks.s2p", "/data/data/com.bluestacks.searchapp", "/data/data/com.bluestacks.settings", "/data/data/com.bluestacks.setup", "/data/data/com.bluestacks.spotlight", "/mnt/prebundledapps/bluestacks.prop.orig"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f35543f = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    /* renamed from: g, reason: collision with root package name */
    public static final FileFilter f35544g = new a();

    /* renamed from: h, reason: collision with root package name */
    public static boolean f35545h = false;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f35546i = false;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f35547j = false;

    /* renamed from: k, reason: collision with root package name */
    public static String f35548k = null;

    /* renamed from: l, reason: collision with root package name */
    public static String f35549l = null;

    /* renamed from: m, reason: collision with root package name */
    public static String f35550m = null;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ boolean f35551n = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            try {
                String name = file.getName();
                if (name.startsWith(IAdInterListener.AdProdType.PRODUCT_CPU)) {
                    for (int i10 = 3; i10 < name.length(); i10++) {
                        if (!Character.isDigit(name.charAt(i10))) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
            return false;
        }
    }

    public static String A() {
        BufferedReader bufferedReader;
        String t2 = t();
        if (TextUtils.isEmpty(t2)) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(t2 + "serial"));
            try {
                return bufferedReader.readLine();
            } catch (Throwable th) {
                th = th;
                try {
                    com.inno.innosdk.utils.u.a.a(th);
                    return null;
                } finally {
                    com.inno.innosdk.utils.t.a.a(bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static String B() {
        try {
            return Arrays.toString(Environment.getRootDirectory().listFiles()).replaceAll(" " + Environment.getRootDirectory().getAbsolutePath() + "/", "").replaceAll(Environment.getRootDirectory().getAbsolutePath() + "/", "");
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static int C() {
        Throwable th;
        BufferedReader bufferedReader;
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            FileReader fileReader3 = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader3, 8192);
                try {
                    int intValue = BigDecimal.valueOf(bufferedReader.readLine().split("\\s+").length > 1 ? Integer.parseInt(r2[1]) : ShadowDrawableWrapper.COS_45).setScale(0, 4).intValue();
                    com.inno.innosdk.utils.t.a.a(bufferedReader);
                    com.inno.innosdk.utils.t.a.a(fileReader3);
                    return intValue;
                } catch (Throwable th2) {
                    fileReader = fileReader3;
                    th = th2;
                    fileReader2 = fileReader;
                    try {
                        com.inno.innosdk.utils.u.a.a(th);
                        return 0;
                    } finally {
                        com.inno.innosdk.utils.t.a.a(bufferedReader);
                        com.inno.innosdk.utils.t.a.a(fileReader2);
                    }
                }
            } catch (Throwable th3) {
                fileReader = fileReader3;
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static boolean D() {
        try {
            if (f() || g()) {
                return true;
            }
            return h();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static boolean a() {
        try {
            for (String str : f35542e) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        return false;
    }

    public static String b(Context context) {
        try {
            return context.getResources().getString(context.getApplicationInfo().labelRes);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static String c(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static Boolean checkSimulator(Context context) {
        try {
            g a10 = g.a(context);
            if (e().booleanValue() || c().booleanValue() || o.a(context).a() || o.a(context).b() || o.a(context).c() || b() || a() || d() || a10.e()) {
                return Boolean.TRUE;
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        return Boolean.FALSE;
    }

    public static String d(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static boolean d(String str) {
        return false;
    }

    public static String e(Context context) {
        Throwable th;
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        try {
        } catch (Throwable th3) {
            th = th3;
            com.inno.innosdk.utils.u.a.a(th);
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String f(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
            }
            return String.valueOf(memoryInfo.availMem / 1024);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "0";
        }
    }

    public static boolean g() {
        try {
            return new File("/system/app/Superuser.apk").exists();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static boolean h() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static String i(Context context) {
        return null;
    }

    public static boolean i() {
        BufferedReader bufferedReader;
        try {
            HashSet<String> hashSet = new HashSet();
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                        hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.inno.innosdk.utils.u.a.a(th);
                        com.inno.innosdk.utils.t.a.a(bufferedReader);
                        return false;
                    } finally {
                        com.inno.innosdk.utils.t.a.a(bufferedReader);
                    }
                }
            }
            for (String str : hashSet) {
                if (str.contains("com.saurik.substrate")) {
                    return true;
                }
                if (str.contains("XposedBridge.jar")) {
                    return true;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        com.inno.innosdk.utils.t.a.a(bufferedReader);
        return false;
    }

    public static String j(Context context) {
        return null;
    }

    public static boolean j() {
        try {
            try {
                new FileReader("innotech_xposed_exception").close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e10) {
            try {
                int i10 = 0;
                for (StackTraceElement stackTraceElement : e10.getStackTrace()) {
                    if (stackTraceElement.getClassName().toLowerCase().contains("xposed")) {
                        return true;
                    }
                    if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName()) && (i10 = i10 + 1) == 2) {
                        return true;
                    }
                    if ("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && "invoked".equals(stackTraceElement.getMethodName())) {
                        return true;
                    }
                    if (an.f35798b.equals(stackTraceElement.getClassName()) && "main".equals(stackTraceElement.getMethodName())) {
                        return true;
                    }
                    if (an.f35798b.equals(stackTraceElement.getClassName()) && "handleHookedMethod".equals(stackTraceElement.getMethodName())) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
                com.inno.innosdk.utils.u.a.a((Throwable) e10);
            }
        }
        return false;
    }

    public static long k() {
        try {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return 0L;
        }
    }

    public static synchronized String k(Context context) {
        synchronized (AppInfomation.class) {
        }
        return "";
    }

    public static String l(Context context) {
        return context.getPackageName();
    }

    public static String m() {
        Throwable th;
        Process process;
        BufferedReader bufferedReader = null;
        try {
            process = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            try {
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb2.append(readLine);
                        } else {
                            String lowerCase = sb2.toString().toLowerCase();
                            com.inno.innosdk.utils.t.a.a(bufferedReader2);
                            com.inno.innosdk.utils.t.a.a(process);
                            return lowerCase;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        try {
                            com.inno.innosdk.utils.u.a.a(th);
                            com.inno.innosdk.utils.t.a.a(bufferedReader);
                            com.inno.innosdk.utils.t.a.a(process);
                            return "";
                        } catch (Throwable th3) {
                            com.inno.innosdk.utils.t.a.a(bufferedReader);
                            com.inno.innosdk.utils.t.a.a(process);
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            process = null;
        }
    }

    public static String m(Context context) {
        return "";
    }

    public static String n(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels + "," + displayMetrics.heightPixels;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static String o(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels + "," + displayMetrics.heightPixels + "," + displayMetrics.density;
    }

    public static String p() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return String.valueOf(((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static String q() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return String.valueOf(((statFs.getBlockCount() * statFs.getBlockSize()) / 1024) / 1024);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static String r() {
        StringBuilder sb2 = new StringBuilder();
        try {
            if (f()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (g()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            sb2.append("0");
            sb2.append(",");
            if (h()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            sb2.append("0");
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        return sb2.toString();
    }

    public static String s() {
        try {
            String arrays = Arrays.toString(new File(Environment.getRootDirectory().getAbsolutePath() + "/framework").listFiles());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            sb2.append(new File(Environment.getRootDirectory().getAbsolutePath() + "/framework").getAbsolutePath());
            sb2.append("/");
            return arrays.replaceAll(sb2.toString(), "").replaceAll(new File(Environment.getRootDirectory().getAbsolutePath() + "/framework").getAbsolutePath() + "/", "");
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static String t(Context context) {
        AudioManager audioManager;
        StringBuilder sb2 = new StringBuilder();
        try {
            audioManager = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        if (audioManager == null) {
            return "";
        }
        sb2.append(audioManager.getStreamVolume(0));
        sb2.append(",");
        sb2.append(audioManager.getStreamVolume(1));
        sb2.append(",");
        sb2.append(audioManager.getStreamVolume(2));
        sb2.append(",");
        sb2.append(audioManager.getStreamVolume(3));
        sb2.append(",");
        sb2.append(audioManager.getStreamVolume(4));
        return sb2.toString();
    }

    public static synchronized String u() {
        String str;
        synchronized (AppInfomation.class) {
            try {
                if (f35549l == null && com.inno.innosdk.a.c.l() != null) {
                    f35549l = com.inno.innosdk.a.c.l().getMac();
                }
                str = f35549l;
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
                return null;
            }
        }
        return str;
    }

    public static String u(Context context) {
        return null;
    }

    public static String v(Context context) {
        String c4 = com.inno.innosdk.a.b.c();
        NativeUtils.f35553b = "runtime";
        if (!com.inno.innosdk.utils.t.a.b(c4) || 1 != NativeUtils.a(c4)) {
            String d10 = com.inno.innosdk.b.b.d();
            if (com.inno.innosdk.utils.t.a.b(d10) && d10.startsWith("a") && d10.length() == 34) {
                NativeUtils.f35553b = "acid";
                c4 = NativeUtils.c(d10);
            }
        }
        if (!com.inno.innosdk.utils.t.a.b(c4) || 1 != NativeUtils.a(c4)) {
            NativeUtils.f35553b = "getFileData";
            c4 = q.a(context, "inno_ncuid", "");
        }
        if (!com.inno.innosdk.utils.t.a.b(c4) || 1 != NativeUtils.a(c4)) {
            NativeUtils.f35553b = "getKey";
            c4 = com.inno.innosdk.utils.t.a.a("ncuid", context, f35538a, "ncuid", "inno_ncuid");
        }
        if (com.inno.innosdk.utils.t.a.b(c4) && 1 == NativeUtils.a(c4)) {
            return c4;
        }
        String a10 = NativeUtils.a();
        com.inno.innosdk.a.b.c(a10);
        q.c(context, "inno_ncuid", a10);
        com.inno.innosdk.utils.t.a.a("ncuid", context, a10, f35538a, "ncuid");
        return a10;
    }

    public static boolean w(Context context) {
        try {
            if (i()) {
                return true;
            }
            return j();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static boolean x(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static Boolean y(Context context) {
        return Boolean.FALSE;
    }

    public static String z() {
        BufferedReader bufferedReader;
        String t2 = t();
        if (TextUtils.isEmpty(t2)) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(t2 + "name"));
            try {
                return bufferedReader.readLine();
            } catch (Throwable th) {
                th = th;
                try {
                    com.inno.innosdk.utils.u.a.a(th);
                    return null;
                } finally {
                    com.inno.innosdk.utils.t.a.a(bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static String z(Context context) {
        return "";
    }

    public static int l() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f35544g).length;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return 0;
        }
    }

    public static String y() {
        BufferedReader bufferedReader;
        String t2 = t();
        if (TextUtils.isEmpty(t2)) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(t2 + "csd"));
            try {
                return bufferedReader.readLine();
            } catch (Throwable th) {
                th = th;
                try {
                    com.inno.innosdk.utils.u.a.a(th);
                    return null;
                } finally {
                    com.inno.innosdk.utils.t.a.a(bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static Boolean c() {
        try {
            for (String str : f35541d) {
                if (new File(str).exists()) {
                    return Boolean.TRUE;
                }
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        return Boolean.FALSE;
    }

    public static int w() {
        try {
            int a10 = a("/sys/devices/system/cpu/possible");
            if (a10 == -1) {
                a10 = a("/sys/devices/system/cpu/present");
            }
            return a10 == -1 ? l() : a10;
        } catch (NullPointerException | SecurityException e2) {
            com.inno.innosdk.utils.u.a.a(e2);
            return -1;
        }
    }

    public static String x() {
        BufferedReader bufferedReader;
        String t2 = t();
        if (TextUtils.isEmpty(t2)) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(t2 + "cid"));
            try {
                return bufferedReader.readLine();
            } catch (Throwable th) {
                th = th;
                try {
                    com.inno.innosdk.utils.u.a.a(th);
                    return null;
                } finally {
                    com.inno.innosdk.utils.t.a.a(bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (r0.contains("amd") != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b() {
        /*
            r0 = 0
            java.lang.String r1 = "/system/bin/cat"
            java.lang.String r2 = "/proc/cpuinfo"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}     // Catch: java.lang.Throwable -> L55
            java.lang.ProcessBuilder r2 = new java.lang.ProcessBuilder     // Catch: java.lang.Throwable -> L55
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L55
            java.lang.Process r1 = r2.start()     // Catch: java.lang.Throwable -> L55
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r2.<init>()     // Catch: java.lang.Throwable -> L53
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L53
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L53
            java.io.InputStream r5 = r1.getInputStream()     // Catch: java.lang.Throwable -> L53
            java.lang.String r6 = "utf-8"
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L53
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L53
        L27:
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L31
            r2.append(r0)     // Catch: java.lang.Throwable -> L51
            goto L27
        L31:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = r0.toLowerCase()     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "intel"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L49
            java.lang.String r2 = "amd"
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L5d
        L49:
            com.inno.innosdk.utils.t.a.a(r3)
            com.inno.innosdk.utils.t.a.a(r1)
            r0 = 1
            return r0
        L51:
            r0 = move-exception
            goto L5a
        L53:
            r2 = move-exception
            goto L58
        L55:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L58:
            r3 = r0
            r0 = r2
        L5a:
            com.inno.innosdk.utils.u.a.a(r0)     // Catch: java.lang.Throwable -> L65
        L5d:
            com.inno.innosdk.utils.t.a.a(r3)
            com.inno.innosdk.utils.t.a.a(r1)
            r0 = 0
            return r0
        L65:
            r0 = move-exception
            com.inno.innosdk.utils.t.a.a(r3)
            com.inno.innosdk.utils.t.a.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.AppInfomation.b():boolean");
    }

    public static String g(Context context) {
        String b4;
        try {
            b4 = q.b(context, "innoBm", null);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        if (b4 != null) {
            return b4;
        }
        try {
            String c4 = c(q.a(com.inno.innosdk.utils.t.a.a(new File("/efs/bluetooth/bt_addr"))));
            if (c4 != null) {
                q.d(context, "innoBm", c4);
                return c4;
            }
        } catch (Throwable th2) {
            com.inno.innosdk.utils.u.a.a(th2);
        }
        return null;
    }

    public static int h(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return -1;
        }
    }

    public static synchronized String a(Context context) {
        String str;
        synchronized (AppInfomation.class) {
            try {
                if (f35548k == null && com.inno.innosdk.a.c.l() != null) {
                    f35548k = com.inno.innosdk.a.c.l().getAndroidId();
                }
                str = f35548k;
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
                return "";
            }
        }
        return str;
    }

    public static boolean d() {
        try {
            for (String str : f35543f) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[Catch: all -> 0x0073, TryCatch #1 {all -> 0x0073, blocks: (B:3:0x0001, B:5:0x001a, B:7:0x0022, B:9:0x0028, B:16:0x0038, B:17:0x0053, B:19:0x005e, B:23:0x0066, B:21:0x0069, B:38:0x006c, B:39:0x006f, B:32:0x0050), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Boolean e() {
        /*
            r0 = 2
            java.io.File[] r1 = new java.io.File[r0]     // Catch: java.lang.Throwable -> L73
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L73
            java.lang.String r3 = "/proc/tty/drivers"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L73
            r3 = 0
            r1[r3] = r2     // Catch: java.lang.Throwable -> L73
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L73
            java.lang.String r4 = "/proc/cpuinfo"
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L73
            r4 = 1
            r1[r4] = r2     // Catch: java.lang.Throwable -> L73
            r2 = 0
        L18:
            if (r2 >= r0) goto L77
            r4 = r1[r2]     // Catch: java.lang.Throwable -> L73
            boolean r5 = r4.exists()     // Catch: java.lang.Throwable -> L73
            if (r5 == 0) goto L70
            boolean r5 = r4.canRead()     // Catch: java.lang.Throwable -> L73
            if (r5 == 0) goto L70
            long r5 = r4.length()     // Catch: java.lang.Throwable -> L73
            int r6 = (int) r5     // Catch: java.lang.Throwable -> L73
            byte[] r5 = new byte[r6]     // Catch: java.lang.Throwable -> L73
            r6 = 0
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47 java.io.FileNotFoundException -> L4c
            r7.<init>(r4)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47 java.io.FileNotFoundException -> L4c
            r7.read(r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L42
            com.inno.innosdk.utils.t.a.a(r7)     // Catch: java.lang.Throwable -> L73
            goto L53
        L3c:
            r0 = move-exception
            r6 = r7
            goto L6c
        L3f:
            r4 = move-exception
            r6 = r7
            goto L48
        L42:
            r4 = move-exception
            r6 = r7
            goto L4d
        L45:
            r0 = move-exception
            goto L6c
        L47:
            r4 = move-exception
        L48:
            com.inno.innosdk.utils.u.a.a(r4)     // Catch: java.lang.Throwable -> L45
            goto L50
        L4c:
            r4 = move-exception
        L4d:
            com.inno.innosdk.utils.u.a.a(r4)     // Catch: java.lang.Throwable -> L45
        L50:
            com.inno.innosdk.utils.t.a.a(r6)     // Catch: java.lang.Throwable -> L73
        L53:
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L73
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L73
            java.lang.String[] r5 = com.inno.innosdk.utils.AppInfomation.f35540c     // Catch: java.lang.Throwable -> L73
            int r6 = r5.length     // Catch: java.lang.Throwable -> L73
            r7 = 0
        L5c:
            if (r7 >= r6) goto L70
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L73
            boolean r8 = r4.contains(r8)     // Catch: java.lang.Throwable -> L73
            if (r8 == 0) goto L69
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L73
            return r0
        L69:
            int r7 = r7 + 1
            goto L5c
        L6c:
            com.inno.innosdk.utils.t.a.a(r6)     // Catch: java.lang.Throwable -> L73
            throw r0     // Catch: java.lang.Throwable -> L73
        L70:
            int r2 = r2 + 1
            goto L18
        L73:
            r0 = move-exception
            com.inno.innosdk.utils.u.a.a(r0)
        L77:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.AppInfomation.e():java.lang.Boolean");
    }

    public static String s(Context context) {
        String b4 = com.inno.innosdk.a.b.b();
        if (!com.inno.innosdk.utils.t.a.b(b4)) {
            try {
                b4 = com.inno.innosdk.utils.t.a.a("cuid", context, f35539b, "cuid", "cusc");
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
        if (!com.inno.innosdk.utils.t.a.b(b4)) {
            b4 = NativeUtils.b();
        } else if (!com.inno.innosdk.utils.t.a.a(b4)) {
            b4 = NativeUtils.b();
            f35546i = false;
        }
        try {
            if (!f35546i) {
                f35546i = true;
                com.inno.innosdk.a.b.b(b4);
                com.inno.innosdk.utils.t.a.a("cuid", context, b4, f35539b, "cuid");
            }
        } catch (Throwable th2) {
            com.inno.innosdk.utils.u.a.a(th2);
        }
        return b4;
    }

    public static boolean f() {
        try {
            String str = Build.TAGS;
            if (str != null) {
                return str.contains("test-keys");
            }
            return false;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static String p(Context context) {
        try {
            Point point = new Point();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getRealSize(point);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return String.valueOf(BigDecimal.valueOf(Math.sqrt(Math.pow(point.x / displayMetrics.xdpi, 2.0d) + Math.pow(point.y / displayMetrics.ydpi, 2.0d))).setScale(1, 4).doubleValue());
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static String q(Context context) {
        StringBuilder sb2 = new StringBuilder();
        try {
            g a10 = g.a(context);
            if (e().booleanValue()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (c().booleanValue()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (o.a(context).a()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (o.a(context).b()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (o.a(context).c()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (b()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (a()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (d()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (com.inno.innosdk.utils.w.a.o().a(context, null)) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (a10.a()) {
                sb2.append("1");
                sb2.append(",");
            } else {
                sb2.append("0");
                sb2.append(",");
            }
            if (y(context).booleanValue()) {
                sb2.append("1");
            } else {
                sb2.append("0");
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        return sb2.toString();
    }

    public static int n() {
        FileInputStream fileInputStream;
        Throwable th;
        int i10 = -1;
        for (int i11 = 0; i11 < w(); i11++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i11 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        try {
                            fileInputStream2.read(bArr);
                            int i12 = 0;
                            while (Character.isDigit(bArr[i12]) && i12 < 128) {
                                i12++;
                            }
                            Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i12)));
                            if (valueOf.intValue() > i10) {
                                i10 = valueOf.intValue();
                            }
                        } catch (NumberFormatException e2) {
                            com.inno.innosdk.utils.u.a.a((Throwable) e2);
                        }
                        com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream2);
                    } catch (Throwable th2) {
                        com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream2);
                        throw th2;
                    }
                }
            } catch (IOException e10) {
                com.inno.innosdk.utils.u.a.a((Throwable) e10);
                return -1;
            }
        }
        if (i10 == -1) {
            try {
                fileInputStream = new FileInputStream("/proc/cpuinfo");
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            try {
                int a10 = a("cpu MHz", fileInputStream) * 1000;
                if (a10 > i10) {
                    i10 = a10;
                }
                com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream);
            } catch (Throwable th4) {
                th = th4;
                com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream);
                throw th;
            }
        }
        return i10;
    }

    public static String o() {
        BufferedReader bufferedReader;
        StringBuilder sb2 = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String[] split = bufferedReader.readLine().split("\\s+");
                for (int i10 = 2; i10 < split.length; i10++) {
                    sb2.append(split[i10]);
                    sb2.append(" ");
                }
                String str = sb2.toString() + "," + w() + "," + n();
                com.inno.innosdk.utils.t.a.a(bufferedReader);
                com.inno.innosdk.utils.t.a.a(fileReader2);
                return str;
            } catch (Throwable th2) {
                th = th2;
                fileReader = fileReader2;
                try {
                    com.inno.innosdk.utils.u.a.a(th);
                    com.inno.innosdk.utils.t.a.a(bufferedReader);
                    com.inno.innosdk.utils.t.a.a(fileReader);
                    return "";
                } catch (Throwable th3) {
                    com.inno.innosdk.utils.t.a.a(bufferedReader);
                    com.inno.innosdk.utils.t.a.a(fileReader);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static int a(String str) {
        BufferedReader bufferedReader;
        IOException iOException;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream2 = new FileInputStream(str);
        } catch (IOException e2) {
            iOException = e2;
            bufferedReader2 = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            com.inno.innosdk.utils.t.a.a(bufferedReader);
            com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream4);
            throw th;
        }
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream2));
            try {
                int b4 = b(bufferedReader2.readLine());
                com.inno.innosdk.utils.t.a.a(bufferedReader2);
                com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream2);
                return b4;
            } catch (IOException e10) {
                fileInputStream3 = fileInputStream2;
                iOException = e10;
                fileInputStream4 = fileInputStream3;
                try {
                    com.inno.innosdk.utils.u.a.a((Throwable) iOException);
                    com.inno.innosdk.utils.t.a.a(bufferedReader2);
                    com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream4);
                    return -1;
                } catch (Throwable th3) {
                    fileInputStream2 = fileInputStream4;
                    th = th3;
                    fileInputStream = fileInputStream2;
                    bufferedReader = bufferedReader2;
                    th = th;
                    fileInputStream4 = fileInputStream;
                    com.inno.innosdk.utils.t.a.a(bufferedReader);
                    com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream4);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = fileInputStream2;
                bufferedReader = bufferedReader2;
                th = th;
                fileInputStream4 = fileInputStream;
                com.inno.innosdk.utils.t.a.a(bufferedReader);
                com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream4);
                throw th;
            }
        } catch (IOException e11) {
            fileInputStream3 = fileInputStream2;
            iOException = e11;
            bufferedReader2 = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = fileInputStream2;
            bufferedReader = null;
            fileInputStream4 = fileInputStream;
            com.inno.innosdk.utils.t.a.a(bufferedReader);
            com.inno.innosdk.utils.t.a.a((Closeable) fileInputStream4);
            throw th;
        }
    }

    public static String c(String str) {
        try {
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        if (!TextUtils.isEmpty(str) && !str.contains("unknown") && !str.contains("null") && !str.contains("nil")) {
            int i10 = 0;
            for (int i11 = 0; i11 <= str.length() - 1; i11++) {
                if ('0' == str.charAt(i11) && (i10 = i10 + 1) > str.length() / 2) {
                    return "";
                }
            }
            return str;
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String r(android.content.Context r6) {
        /*
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L3c
            r1 = 0
            android.content.Intent r6 = r6.registerReceiver(r1, r0)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r0 = "status"
            r1 = -1
            int r0 = r6.getIntExtra(r0, r1)     // Catch: java.lang.Throwable -> L3c
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == r2) goto L1e
            r5 = 5
            if (r0 != r5) goto L1c
            goto L1e
        L1c:
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            java.lang.String r5 = "plugged"
            int r6 = r6.getIntExtra(r5, r1)     // Catch: java.lang.Throwable -> L3c
            if (r6 != r2) goto L29
            r1 = 1
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r6 != r4) goto L2d
            r3 = 1
        L2d:
            if (r0 == 0) goto L39
            if (r1 == 0) goto L34
            java.lang.String r6 = "2"
            goto L42
        L34:
            if (r3 == 0) goto L40
            java.lang.String r6 = "3"
            goto L42
        L39:
            java.lang.String r6 = "1"
            goto L42
        L3c:
            r6 = move-exception
            com.inno.innosdk.utils.u.a.a(r6)
        L40:
            java.lang.String r6 = ""
        L42:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.AppInfomation.r(android.content.Context):java.lang.String");
    }

    public static String t() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str = "/sys/block/mmcblk0/device/";
        BufferedReader bufferedReader3 = null;
        try {
            if (new File("/sys/block/mmcblk0/device/type").exists()) {
                bufferedReader2 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/type"));
            } else {
                str = null;
                bufferedReader2 = null;
            }
            com.inno.innosdk.utils.t.a.a(bufferedReader2);
        } catch (Throwable unused) {
            com.inno.innosdk.utils.t.a.a((Closeable) null);
            str = null;
        }
        try {
            if (new File("/sys/block/mmcblk1/device/type").exists()) {
                bufferedReader = new BufferedReader(new FileReader("/sys/block/mmcblk1/device/type"));
                str = "/sys/block/mmcblk1/device/";
            } else {
                bufferedReader = null;
            }
            com.inno.innosdk.utils.t.a.a(bufferedReader);
        } catch (Throwable unused2) {
            com.inno.innosdk.utils.t.a.a((Closeable) null);
        }
        try {
            if (new File("/sys/block/mmcblk2/device/type").exists()) {
                str = "/sys/block/mmcblk2/device/";
                bufferedReader3 = new BufferedReader(new FileReader("/sys/block/mmcblk2/device/type"));
            }
        } catch (Throwable unused3) {
        }
        com.inno.innosdk.utils.t.a.a(bufferedReader3);
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String v() {
        return NativeUtils.f35553b;
    }

    public static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i10 = 0;
            while (i10 < read) {
                if (bArr[i10] == 10 || i10 == 0) {
                    if (bArr[i10] == 10) {
                        i10++;
                    }
                    for (int i11 = i10; i11 < read; i11++) {
                        int i12 = i11 - i10;
                        if (bArr[i11] != str.charAt(i12)) {
                            break;
                        }
                        if (i12 == str.length() - 1) {
                            return a(bArr, i11);
                        }
                    }
                }
                i10++;
            }
            return -1;
        } catch (IOException e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
            return -1;
        } catch (NumberFormatException e10) {
            com.inno.innosdk.utils.u.a.a((Throwable) e10);
            return -1;
        }
    }

    public static int b(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.matches("0-[\\d]+$")) {
                return Integer.valueOf(str.substring(2)).intValue() + 1;
            }
            return -1;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return 0;
        }
    }

    public static int a(byte[] bArr, int i10) {
        while (i10 < bArr.length && bArr[i10] != 10) {
            try {
                if (Character.isDigit(bArr[i10])) {
                    int i11 = i10 + 1;
                    while (i11 < bArr.length && Character.isDigit(bArr[i11])) {
                        i11++;
                    }
                    return Integer.parseInt(new String(bArr, 0, i10, i11 - i10));
                }
                i10++;
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
                return -1;
            }
        }
        return -1;
    }

    public static String a(String str, String str2) {
        String[] strArr;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                StringBuilder sb2 = new StringBuilder();
                try {
                    strArr = str2.split(",");
                } catch (Throwable th) {
                    com.inno.innosdk.utils.u.a.a(th);
                    strArr = null;
                }
                if (strArr != null && strArr.length != 0) {
                    for (String str3 : strArr) {
                        if (str.contains(str3)) {
                            if (sb2.length() != 0) {
                                sb2.append(",");
                            }
                            sb2.append(str3);
                        }
                    }
                    return sb2.toString();
                }
                return null;
            } catch (Throwable th2) {
                com.inno.innosdk.utils.u.a.a(th2);
            }
        }
        return null;
    }
}
