package com.alibaba.wireless.security.framework.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import com.android.internal.content.NativeLibraryHelper;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.alibaba.wireless.security.framework.utils.е, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0055 {

    /* renamed from: а, reason: contains not printable characters */
    private static String[] f62 = {"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};

    /* renamed from: б, reason: contains not printable characters */
    private static boolean f63 = true;

    /* renamed from: в, reason: contains not printable characters */
    private static boolean f64 = false;

    /* renamed from: г, reason: contains not printable characters */
    private static boolean f65 = true;

    /* renamed from: д, reason: contains not printable characters */
    private static boolean f66 = false;

    /* renamed from: е, reason: contains not printable characters */
    private static boolean f67 = true;

    /* renamed from: ё, reason: contains not printable characters */
    private static boolean f68;

    /* renamed from: а, reason: contains not printable characters */
    public static String m1844(Context context) {
        try {
            int myPid = Process.myPid();
            if (context == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    return str != null ? str : "";
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static String m1845(ClassLoader classLoader, String str) {
        if (classLoader == null || str == null || "".equals(str)) {
            return null;
        }
        String m1846 = m1846(classLoader, str, true);
        return m1846 == null ? m1846(classLoader, str, false) : m1846;
    }

    /* renamed from: а, reason: contains not printable characters */
    private static String m1846(ClassLoader classLoader, String str, boolean z10) {
        if (classLoader != null) {
            try {
                Method method = z10 ? classLoader.getClass().getMethod("findLibrary", String.class) : classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
                if (method != null) {
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    Object invoke = method.invoke(classLoader, str);
                    if (invoke != null && (invoke instanceof String)) {
                        return (String) invoke;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: а, reason: contains not printable characters */
    public static boolean m1847() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: а, reason: contains not printable characters */
    public static boolean m1848(String str, String str2, File file) {
        boolean z10;
        ZipFile zipFile;
        boolean z11 = false;
        z11 = false;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            try {
                z10 = false;
                for (String str3 : f62) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(NativeLibraryHelper.LIB_DIR_NAME);
                        String str4 = File.separator;
                        sb2.append(str4);
                        sb2.append(str3);
                        sb2.append(str4);
                        sb2.append(str2);
                        ZipEntry entry = zipFile.getEntry(sb2.toString());
                        if (entry != null && entry.getSize() != 0 && C0050.m1828(entry.getName())) {
                            z10 = m1849(zipFile, entry, file);
                        }
                    } catch (IOException e10) {
                        e = e10;
                        z11 = z10;
                        zipFile2 = zipFile;
                        C0049.m1822("", e);
                        if (zipFile2 == null) {
                            return z11;
                        }
                        z10 = z11;
                        zipFile = zipFile2;
                        zipFile.close();
                        return z10;
                    }
                }
            } catch (IOException e11) {
                e = e11;
            }
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            return z10;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileOutputStream] */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m1849(java.util.zip.ZipFile r9, java.util.zip.ZipEntry r10, java.io.File r11) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.C0055.m1849(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    /* renamed from: б, reason: contains not printable characters */
    public static boolean m1850(Context context) {
        if (f67) {
            try {
                String m1844 = m1844(context);
                String packageName = context.getPackageName();
                if ("com.ali.money.shield".equals(packageName)) {
                    packageName = packageName + ":fore";
                }
                f68 = m1844.equals(packageName);
                f67 = false;
            } catch (Exception unused) {
            }
        }
        return f68;
    }

    /* renamed from: в, reason: contains not printable characters */
    public static boolean m1851(Context context) {
        boolean z10;
        PackageInfo packageInfo;
        if (f63) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Throwable unused) {
            }
            if (packageInfo != null) {
                int i10 = packageInfo.applicationInfo.flags;
                if ((i10 & 1) != 0 && (i10 & 128) == 0) {
                    z10 = true;
                    f64 = z10;
                    f63 = false;
                }
            }
            z10 = false;
            f64 = z10;
            f63 = false;
        }
        return f64;
    }

    /* renamed from: г, reason: contains not printable characters */
    public static boolean m1852(Context context) {
        boolean z10;
        PackageInfo packageInfo;
        if (f65) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Throwable unused) {
            }
            if (packageInfo != null) {
                if ((packageInfo.applicationInfo.flags & 128) != 0) {
                    z10 = true;
                    f66 = z10;
                    f65 = false;
                }
            }
            z10 = false;
            f66 = z10;
            f65 = false;
        }
        return f66;
    }
}
