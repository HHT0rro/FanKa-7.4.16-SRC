package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class bm {
    public static int a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String b() {
        long j10 = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j10 = statFs.getBlockSize() * statFs.getBlockCount();
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(j10);
    }

    public static String c() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x006c, code lost:
    
        if (r3 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject d() {
        /*
            java.lang.String r0 = ";"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = "lsmod"
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L64
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L64
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L64
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L64
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L61
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L61
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L61
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L61
        L25:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L5a
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L62
            if (r5 != 0) goto L25
            java.lang.String r2 = com.kuaishou.weapon.p0.bo.a(r2)     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "-"
            boolean r5 = r2.contains(r5)     // Catch: java.lang.Throwable -> L62
            if (r5 == 0) goto L25
            boolean r5 = r2.contains(r0)     // Catch: java.lang.Throwable -> L62
            if (r5 == 0) goto L25
            java.lang.String r5 = ";;;"
            java.lang.String r2 = r2.replace(r5, r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String[] r2 = r2.split(r0)     // Catch: java.lang.Throwable -> L62
            int r5 = r2.length     // Catch: java.lang.Throwable -> L62
            r6 = 1
            if (r5 <= r6) goto L25
            r5 = 0
            r5 = r2[r5]     // Catch: java.lang.Throwable -> L62
            r2 = r2[r6]     // Catch: java.lang.Throwable -> L62
            r1.put(r5, r2)     // Catch: java.lang.Throwable -> L62
            goto L25
        L5a:
            r4.close()     // Catch: java.io.IOException -> L5d
        L5d:
            r3.close()     // Catch: java.io.IOException -> L6f
            goto L6f
        L61:
            r3 = r2
        L62:
            r2 = r4
            goto L65
        L64:
            r3 = r2
        L65:
            if (r2 == 0) goto L6c
            r2.close()     // Catch: java.io.IOException -> L6b
            goto L6c
        L6b:
        L6c:
            if (r3 == 0) goto L6f
            goto L5d
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bm.d():org.json.JSONObject");
    }

    public static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            TimeZone timeZone = Calendar.getInstance().getTimeZone();
            if (timeZone == null) {
                return null;
            }
            jSONObject.put("0", String.valueOf(timeZone.getOffset(System.currentTimeMillis()) / 1000));
            jSONObject.put("1", timeZone.getID());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
