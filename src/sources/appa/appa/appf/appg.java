package appa.appa.appf;

import android.os.Build;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: RomUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appg {

    /* renamed from: appa, reason: collision with root package name */
    private static String f1018appa;
    private static String appb;

    public static boolean appa() {
        return appb("OPPO");
    }

    public static boolean appb() {
        return appb("VIVO");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String appa(java.lang.String r6) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r4.<init>()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r4.append(r6)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r3 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.lang.String r2 = r1.readLine()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L62
            r1.close()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L62
            r1.close()     // Catch: java.io.IOException -> L35 java.lang.Throwable -> L62
            goto L39
        L35:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L62
        L39:
            return r2
        L3a:
            r2 = move-exception
            goto L41
        L3c:
            r6 = move-exception
            r1 = r0
            goto L63
        L3f:
            r2 = move-exception
            r1 = r0
        L41:
            java.lang.String r3 = "RomUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "Unable to read prop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L62
            r4.append(r6)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L62
            android.util.Log.e(r3, r6, r2)     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L61
            r1.close()     // Catch: java.io.IOException -> L5d java.lang.Throwable -> L62
            goto L61
        L5d:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L62
        L61:
            return r0
        L62:
            r6 = move-exception
        L63:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.io.IOException -> L69
            goto L6d
        L69:
            r0 = move-exception
            r0.printStackTrace()
        L6d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: appa.appa.appf.appg.appa(java.lang.String):java.lang.String");
    }

    public static boolean appb(String str) {
        String str2 = f1018appa;
        if (str2 != null) {
            return str2.equals(str);
        }
        String appa2 = appa("ro.miui.ui.version.name");
        appb = appa2;
        if (TextUtils.isEmpty(appa2) && !ADEvent.XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
            String appa3 = appa("ro.build.version.emui");
            appb = appa3;
            if (TextUtils.isEmpty(appa3) && !appf.appa()) {
                String appa4 = appa("ro.build.version.opporom");
                appb = appa4;
                if (TextUtils.isEmpty(appa4) && !appf.appb()) {
                    String appa5 = appa("ro.vivo.os.version");
                    appb = appa5;
                    if (TextUtils.isEmpty(appa5) && !appf.appc()) {
                        String appa6 = appa("ro.smartisan.version");
                        appb = appa6;
                        if (!TextUtils.isEmpty(appa6)) {
                            f1018appa = "SMARTISAN";
                        } else {
                            appb = Build.DISPLAY;
                            if (appb.toUpperCase().contains("FLYME")) {
                                f1018appa = "FLYME";
                            } else {
                                appb = "unknown";
                                f1018appa = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    } else {
                        f1018appa = "VIVO";
                    }
                } else {
                    f1018appa = "OPPO";
                }
            } else {
                f1018appa = "EMUI";
            }
        } else {
            f1018appa = "MIUI";
        }
        return f1018appa.equals(str);
    }
}
