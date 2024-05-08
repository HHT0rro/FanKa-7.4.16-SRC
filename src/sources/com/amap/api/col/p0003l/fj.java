package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: AppInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fj {

    /* renamed from: a, reason: collision with root package name */
    public static String f5763a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f5764b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String f5765c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f5766d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f5767e = "";

    /* renamed from: f, reason: collision with root package name */
    private static String f5768f = "";

    public static boolean a() {
        if (f5764b) {
            return true;
        }
        if (b(f5763a)) {
            f5764b = true;
            return true;
        }
        if (!TextUtils.isEmpty(f5763a)) {
            f5764b = false;
            f5763a = null;
            return false;
        }
        if (b(f5766d)) {
            f5764b = true;
            return true;
        }
        if (!TextUtils.isEmpty(f5766d)) {
            f5764b = false;
            f5766d = null;
            return false;
        }
        return true;
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c4 : str.toCharArray()) {
            if (('A' > c4 || c4 > 'z') && (('0' > c4 || c4 > ':') && c4 != '.')) {
                try {
                    gy.b(fv.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String c(Context context) {
        String str;
        try {
            str = f5766d;
        } catch (Throwable th) {
            gv.a(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f5766d;
        }
        String packageName = context.getPackageName();
        f5766d = packageName;
        if (!b(packageName)) {
            f5766d = context.getPackageName();
        }
        return f5766d;
    }

    public static String d(Context context) {
        try {
        } catch (Throwable th) {
            gv.a(th, "AI", "gAV");
        }
        if (!"".equals(f5767e)) {
            return f5767e;
        }
        f5767e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f5767e;
        return str == null ? "" : str;
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(fv.c("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                String upperCase = Integer.toHexString(b4 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(u.bD);
            }
            String str = packageInfo.packageName;
            if (b(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f5766d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f5763a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            gv.a(th, "AI", "gsp");
            return f5763a;
        }
    }

    public static String f(Context context) {
        try {
            fk.a(context);
        } catch (Throwable unused) {
        }
        try {
            return h(context);
        } catch (Throwable th) {
            gv.a(th, "AI", "gKy");
            return f5768f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String g(android.content.Context r6) {
        /*
            java.lang.String r0 = "k.store"
            java.lang.String r6 = com.amap.api.col.p0003l.gw.c(r6, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r6 = r0.exists()
            java.lang.String r1 = ""
            if (r6 != 0) goto L14
            return r1
        L14:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3b
            int r6 = r2.available()     // Catch: java.lang.Throwable -> L39
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L39
            r2.read(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = com.amap.api.col.p0003l.fv.a(r6)     // Catch: java.lang.Throwable -> L39
            int r0 = r6.length()     // Catch: java.lang.Throwable -> L39
            r3 = 32
            if (r0 != r3) goto L30
            r1 = r6
        L30:
            r2.close()     // Catch: java.lang.Throwable -> L34
            goto L38
        L34:
            r6 = move-exception
            r6.printStackTrace()
        L38:
            return r1
        L39:
            r6 = move-exception
            goto L3f
        L3b:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L3f:
            java.lang.String r3 = "AI"
            java.lang.String r4 = "gKe"
            com.amap.api.col.p0003l.gv.a(r6, r3, r4)     // Catch: java.lang.Throwable -> L5f
            boolean r6 = r0.exists()     // Catch: java.lang.Throwable -> L50
            if (r6 == 0) goto L54
            r0.delete()     // Catch: java.lang.Throwable -> L50
            goto L54
        L50:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L5f
        L54:
            if (r2 == 0) goto L5e
            r2.close()     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
            r6 = move-exception
            r6.printStackTrace()
        L5e:
            return r1
        L5f:
            r6 = move-exception
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.lang.Throwable -> L66
            goto L6a
        L66:
            r0 = move-exception
            r0.printStackTrace()
        L6a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.fj.g(android.content.Context):java.lang.String");
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f5768f;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                String string = bundle.getString("com.amap.api.v2.apikey");
                f5768f = string;
                if (string == null) {
                    f5768f = g(context);
                }
            } else {
                return f5768f;
            }
        }
        return f5768f;
    }

    public static String b(Context context) {
        try {
        } catch (Throwable th) {
            gv.a(th, "AI", "gAN");
        }
        if (!"".equals(f5765c)) {
            return f5765c;
        }
        PackageManager packageManager = context.getPackageManager();
        f5765c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f5765c;
    }

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f5768f;
        }
    }

    public static void a(String str) {
        f5766d = str;
    }

    public static void a(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f5768f = str;
        if (context != null) {
            jd.a().a(new je() { // from class: com.amap.api.col.3l.fj.1
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    FileOutputStream fileOutputStream;
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        File file = new File(gw.c(context, "k.store"));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(fv.a(str));
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            gv.a(th, "AI", "stf");
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                        } catch (Throwable th5) {
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th6) {
                                    th6.printStackTrace();
                                }
                            }
                            throw th5;
                        }
                    }
                }
            });
        }
    }
}
