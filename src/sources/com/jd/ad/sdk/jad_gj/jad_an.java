package com.jd.ad.sdk.jad_gj;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.jd.ad.sdk.jad_an.jad_cp;
import com.kuaishou.weapon.p0.an;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an {
    public static Context jad_an;
    public static boolean jad_bo;

    public static String jad_an() {
        PackageInfo packageInfo;
        Context context = jad_an;
        String str = "";
        if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_bo.jad_an)) {
            if (context == null) {
                com.jd.ad.sdk.jad_dq.jad_an.jad_cp("AppInfo", "context is null");
            } else {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(com.jd.ad.sdk.jad_an.jad_bo.jad_an(context), 16384);
                } catch (Exception unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    com.jd.ad.sdk.jad_dq.jad_an.jad_cp("AppInfo", "packageInfo is null");
                } else {
                    com.jd.ad.sdk.jad_an.jad_bo.jad_an = context.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString();
                }
            }
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getAppName() --> ".concat(String.valueOf(str)));
            return str;
        }
        str = com.jd.ad.sdk.jad_an.jad_bo.jad_an;
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getAppName() --> ".concat(String.valueOf(str)));
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        if (r3 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_bo() {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L36
            java.lang.String r3 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L36
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L24
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L24
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            r2.close()     // Catch: java.io.IOException -> L1a
        L1a:
            r3.close()     // Catch: java.io.IOException -> L41
            goto L41
        L1e:
            r0 = move-exception
            goto L22
        L20:
            r0 = move-exception
            r3 = r1
        L22:
            r1 = r2
            goto L29
        L24:
            r3 = r1
        L25:
            r1 = r2
            goto L37
        L27:
            r0 = move-exception
            r3 = r1
        L29:
            if (r1 == 0) goto L30
            r1.close()     // Catch: java.io.IOException -> L2f
            goto L30
        L2f:
        L30:
            if (r3 == 0) goto L35
            r3.close()     // Catch: java.io.IOException -> L35
        L35:
            throw r0
        L36:
            r3 = r1
        L37:
            if (r1 == 0) goto L3e
            r1.close()     // Catch: java.io.IOException -> L3d
            goto L3e
        L3d:
        L3e:
            if (r3 == 0) goto L41
            goto L1a
        L41:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "getCpuCurFreq() --> "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "BaseInfo.CoreInfo"
            com.jd.ad.sdk.jad_dq.jad_an.jad_an(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gj.jad_an.jad_bo():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r2 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_cp() {
        /*
            java.lang.String r0 = com.jd.ad.sdk.jad_an.jad_cp.jad_hu
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L57
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L34
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = ":\\s+"
            r4 = 2
            java.lang.String[] r0 = r0.split(r3, r4)     // Catch: java.lang.Throwable -> L2f
            int r3 = r0.length     // Catch: java.lang.Throwable -> L2f
            if (r3 < r4) goto L28
            r3 = 1
            r0 = r0[r3]     // Catch: java.lang.Throwable -> L2f
            com.jd.ad.sdk.jad_an.jad_cp.jad_hu = r0     // Catch: java.lang.Throwable -> L2f
        L28:
            r1.close()     // Catch: java.io.IOException -> L2b
        L2b:
            r2.close()     // Catch: java.io.IOException -> L57
            goto L57
        L2f:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3c
        L34:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r1
            r1 = r5
            goto L3c
        L3a:
            r1 = move-exception
            r2 = r0
        L3c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L46
            r0.close()     // Catch: java.io.IOException -> L45
            goto L46
        L45:
        L46:
            if (r2 == 0) goto L57
            goto L2b
        L49:
            r1 = move-exception
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.io.IOException -> L50
            goto L51
        L50:
        L51:
            if (r2 == 0) goto L56
            r2.close()     // Catch: java.io.IOException -> L56
        L56:
            throw r1
        L57:
            java.lang.String r0 = com.jd.ad.sdk.jad_an.jad_cp.jad_hu
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "getCpuName() --> "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "BaseInfo.CoreInfo"
            com.jd.ad.sdk.jad_dq.jad_an.jad_an(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gj.jad_an.jad_cp():java.lang.String");
    }

    public static String jad_dq() {
        String str;
        if (TextUtils.isEmpty(jad_cp.jad_jt)) {
            try {
                jad_cp.jad_jt = String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new com.jd.ad.sdk.jad_cp.jad_an()).length);
            } catch (Exception unused) {
                str = "1";
            }
        }
        str = jad_cp.jad_jt;
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getCPUNum() --> ".concat(String.valueOf(str)));
        return str;
    }

    public static String jad_er() {
        String str;
        if (TextUtils.isEmpty(jad_cp.jad_dq)) {
            if (TextUtils.isEmpty(jad_cp.jad_cp)) {
                jad_cp.jad_cp = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.BRAND, "");
            }
            if (ADEvent.XIAOMI.equalsIgnoreCase(jad_cp.jad_cp)) {
                try {
                    str = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(null, "ro.product.marketname", "");
                } catch (Throwable th) {
                    com.jd.ad.sdk.jad_dq.jad_an.jad_cp("CoreInfo.SystemPropertyUtil", "An exception happends when call get(), key='ro.product.marketname':\n" + th.toString());
                    str = "";
                }
                jad_cp.jad_dq = str;
            }
            if (TextUtils.isEmpty(jad_cp.jad_dq)) {
                jad_cp.jad_dq = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.MODEL, "");
            }
        }
        String str2 = jad_cp.jad_dq;
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getModel() --> ".concat(String.valueOf(str2)));
        return str2;
    }

    public static String jad_fs() {
        String str;
        Context context = jad_an;
        String str2 = "";
        if (context != null) {
            try {
                str2 = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(((TelephonyManager) context.getSystemService("phone")).getSimOperator(), "");
            } catch (Throwable th) {
                str = "DeviceInfo.getSimOperator() exception: " + th.getMessage();
            }
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getSimOperator() --> ".concat(String.valueOf(str2)));
            return str2;
        }
        str = "context is null";
        com.jd.ad.sdk.jad_dq.jad_an.jad_cp("DeviceInfo", str);
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getSimOperator() --> ".concat(String.valueOf(str2)));
        return str2;
    }

    public static String jad_hu() {
        List<Sensor> sensorList = ((SensorManager) jad_an.getSystemService("sensor")).getSensorList(-1);
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getSensorList() --> ".concat(String.valueOf(sensorList)));
        if (sensorList == null || sensorList.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("");
        int size = sensorList.size();
        for (int i10 = 0; i10 < size; i10++) {
            stringBuffer.append(sensorList.get(i10).getName());
            if (i10 != size - 1) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:2|3)|(2:29|30)|5|(3:6|7|8)|(8:10|(1:12)|13|14|(1:16)|(1:18)|21|22)|26|(0)|13|14|(0)|(0)|21|22) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[Catch: Exception -> 0x0041, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0041, blocks: (B:30:0x000b, B:12:0x0022, B:18:0x003a), top: B:29:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[Catch: Exception -> 0x0041, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0041, blocks: (B:30:0x000b, B:12:0x0022, B:18:0x003a), top: B:29:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_iv() {
        /*
            android.content.Context r0 = com.jd.ad.sdk.jad_gj.jad_an.jad_an
            r1 = 0
            boolean r2 = android.os.Debug.isDebuggerConnected()     // Catch: java.lang.Exception -> L8
            goto L9
        L8:
            r2 = 0
        L9:
            if (r2 == 0) goto L12
            long r2 = com.jd.ad.sdk.jad_il.jad_an.jad_an     // Catch: java.lang.Exception -> L41
            r4 = 1
            long r2 = r2 | r4
            com.jd.ad.sdk.jad_il.jad_an.jad_an = r2     // Catch: java.lang.Exception -> L41
        L12:
            r2 = 1
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()     // Catch: java.lang.Exception -> L1f
            int r3 = r3.flags     // Catch: java.lang.Exception -> L1f
            r3 = r3 & 2
            if (r3 == 0) goto L1f
            r3 = 1
            goto L20
        L1f:
            r3 = 0
        L20:
            if (r3 == 0) goto L29
            long r3 = com.jd.ad.sdk.jad_il.jad_an.jad_an     // Catch: java.lang.Exception -> L41
            r5 = 2
            long r3 = r3 | r5
            com.jd.ad.sdk.jad_il.jad_an.jad_an = r3     // Catch: java.lang.Exception -> L41
        L29:
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L37
            java.lang.String r3 = "adb_enabled"
            int r0 = android.provider.Settings.Secure.getInt(r0, r3, r1)     // Catch: java.lang.Exception -> L37
            if (r0 <= 0) goto L38
            r1 = 1
            goto L38
        L37:
        L38:
            if (r1 == 0) goto L41
            long r0 = com.jd.ad.sdk.jad_il.jad_an.jad_an     // Catch: java.lang.Exception -> L41
            r2 = 4
            long r0 = r0 | r2
            com.jd.ad.sdk.jad_il.jad_an.jad_an = r0     // Catch: java.lang.Exception -> L41
        L41:
            long r0 = com.jd.ad.sdk.jad_il.jad_an.jad_an
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gj.jad_an.jad_iv():java.lang.String");
    }

    public static int jad_jt() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Context context = jad_an;
        if (context == null) {
            com.jd.ad.sdk.jad_dq.jad_an.jad_cp("AppInfo", "getRunningAppProcesses context is null");
            runningAppProcesses = new ArrayList<>();
        } else {
            runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        }
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getRunningAppProcesses() --> ".concat(String.valueOf(runningAppProcesses)));
        if (runningAppProcesses != null) {
            return runningAppProcesses.size();
        }
        return 0;
    }

    public static String jad_jw() {
        Boolean bool;
        try {
            if (com.jd.ad.sdk.jad_il.jad_bo.jad_an(jad_an).booleanValue()) {
                com.jd.ad.sdk.jad_il.jad_bo.jad_an |= 2;
            }
            if (com.jd.ad.sdk.jad_il.jad_bo.jad_an().booleanValue()) {
                com.jd.ad.sdk.jad_il.jad_bo.jad_an |= 4;
            }
            try {
                try {
                    Class.forName("de.robv.android.xposed.XC_MethodHook");
                    bool = Boolean.TRUE;
                } catch (Exception unused) {
                    bool = Boolean.FALSE;
                }
            } catch (Exception unused2) {
                Class.forName(an.f35797a);
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                com.jd.ad.sdk.jad_il.jad_bo.jad_an |= 8;
            }
            Boolean bool2 = Boolean.FALSE;
            try {
                if (System.getProperty("vxp") != null) {
                    bool2 = Boolean.TRUE;
                }
            } catch (Exception unused3) {
            }
            if (bool2.booleanValue()) {
                com.jd.ad.sdk.jad_il.jad_bo.jad_an |= 16;
            }
        } catch (Exception unused4) {
        }
        return String.valueOf(com.jd.ad.sdk.jad_il.jad_bo.jad_an);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(13:2|3|(1:5)|6|(2:7|(2:9|(2:12|13)(1:11))(2:65|66))|(1:15)|16|(1:18)|19|(2:61|62)|21|(1:23)|24)|(10:53|(2:55|(2:57|(1:59)))|60|(1:29)|30|31|(2:32|(4:34|35|(2:37|(2:41|42)(2:39|40))|49)(1:50))|(1:44)|46|47)(1:26)|27|(0)|30|31|(3:32|(0)(0)|49)|(0)|46|47) */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088 A[Catch: Exception -> 0x00c0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c0, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x000f, B:9:0x001f, B:15:0x002f, B:16:0x0036, B:18:0x003c, B:19:0x0043, B:62:0x0048, B:23:0x0058, B:24:0x005f, B:29:0x0088, B:44:0x00b9, B:53:0x006a, B:55:0x0072, B:57:0x007a, B:11:0x0029), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d A[Catch: Exception -> 0x00b6, TryCatch #2 {Exception -> 0x00b6, blocks: (B:31:0x008f, B:32:0x0097, B:34:0x009d, B:37:0x00a9), top: B:30:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b9 A[Catch: Exception -> 0x00c0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c0, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x000f, B:9:0x001f, B:15:0x002f, B:16:0x0036, B:18:0x003c, B:19:0x0043, B:62:0x0048, B:23:0x0058, B:24:0x005f, B:29:0x0088, B:44:0x00b9, B:53:0x006a, B:55:0x0072, B:57:0x007a, B:11:0x0029), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7 A[EDGE_INSN: B:50:0x00b7->B:43:0x00b7 BREAK  A[LOOP:1: B:32:0x0097->B:49:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_kx() {
        /*
            android.content.Context r0 = com.jd.ad.sdk.jad_gj.jad_an.jad_an
            boolean r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an(r0)     // Catch: java.lang.Exception -> Lc0
            if (r1 == 0) goto Lf
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lc0
            r3 = 1
            long r1 = r1 | r3
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lc0
        Lf:
            java.io.File r1 = r0.getFilesDir()     // Catch: java.lang.Exception -> Lc0
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Exception -> Lc0
            java.lang.String[] r2 = com.jd.ad.sdk.jad_il.jad_cp.jad_cp     // Catch: java.lang.Exception -> Lc0
            int r3 = r2.length     // Catch: java.lang.Exception -> Lc0
            r4 = 0
            r5 = 0
        L1c:
            r6 = 1
            if (r5 >= r3) goto L2c
            r7 = r2[r5]     // Catch: java.lang.Exception -> Lc0
            boolean r7 = r1.contains(r7)     // Catch: java.lang.Exception -> Lc0
            if (r7 == 0) goto L29
            r1 = 1
            goto L2d
        L29:
            int r5 = r5 + 1
            goto L1c
        L2c:
            r1 = 0
        L2d:
            if (r1 == 0) goto L36
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lc0
            r7 = 2
            long r1 = r1 | r7
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lc0
        L36:
            boolean r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an()     // Catch: java.lang.Exception -> Lc0
            if (r1 == 0) goto L43
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lc0
            r7 = 4
            long r1 = r1 | r7
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lc0
        L43:
            android.net.LocalServerSocket r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_bo     // Catch: java.lang.Exception -> Lc0
            if (r1 == 0) goto L48
            goto L53
        L48:
            android.net.LocalServerSocket r1 = new android.net.LocalServerSocket     // Catch: java.io.IOException -> L55 java.lang.Exception -> Lc0
            java.lang.String r2 = r0.getPackageName()     // Catch: java.io.IOException -> L55 java.lang.Exception -> Lc0
            r1.<init>(r2)     // Catch: java.io.IOException -> L55 java.lang.Exception -> Lc0
            com.jd.ad.sdk.jad_il.jad_cp.jad_bo = r1     // Catch: java.io.IOException -> L55 java.lang.Exception -> Lc0
        L53:
            r1 = 0
            goto L56
        L55:
            r1 = 1
        L56:
            if (r1 == 0) goto L5f
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lc0
            r7 = 16
            long r1 = r1 | r7
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lc0
        L5f:
            java.lang.String r1 = r0.getPackageName()     // Catch: java.lang.Exception -> Lc0
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Lc0
            if (r2 == 0) goto L6a
            goto L83
        L6a:
            java.lang.String r2 = "com.jingdong.app.mall"
            boolean r2 = r1.equals(r2)     // Catch: java.lang.Exception -> Lc0
            if (r2 != 0) goto L85
            java.lang.String r2 = "com.jd.pingou"
            boolean r2 = r1.equals(r2)     // Catch: java.lang.Exception -> Lc0
            if (r2 != 0) goto L85
            java.lang.String r2 = "com.jd.jdlite"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> Lc0
            if (r1 == 0) goto L83
            goto L85
        L83:
            r1 = 0
            goto L86
        L85:
            r1 = 1
        L86:
            if (r1 == 0) goto L8f
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lc0
            r7 = 32
            long r1 = r1 | r7
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lc0
        L8f:
            java.util.List r0 = com.jd.ad.sdk.jad_hk.jad_an.jad_an(r0)     // Catch: java.lang.Exception -> Lb6
            java.util.Iterator r0 = r0.iterator2()     // Catch: java.lang.Exception -> Lb6
        L97:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> Lb6
            if (r1 == 0) goto Lb7
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> Lb6
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Lb6
            java.lang.String[] r2 = com.jd.ad.sdk.jad_il.jad_cp.jad_cp     // Catch: java.lang.Exception -> Lb6
            int r3 = r2.length     // Catch: java.lang.Exception -> Lb6
            r5 = 0
        La7:
            if (r5 >= r3) goto L97
            r7 = r2[r5]     // Catch: java.lang.Exception -> Lb6
            boolean r7 = r1.contains(r7)     // Catch: java.lang.Exception -> Lb6
            if (r7 == 0) goto Lb3
            r4 = 1
            goto Lb7
        Lb3:
            int r5 = r5 + 1
            goto La7
        Lb6:
        Lb7:
            if (r4 == 0) goto Lc0
            long r0 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lc0
            r2 = 64
            long r0 = r0 | r2
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r0     // Catch: java.lang.Exception -> Lc0
        Lc0:
            long r0 = com.jd.ad.sdk.jad_il.jad_cp.jad_an
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gj.jad_an.jad_kx():java.lang.String");
    }

    public static boolean jad_ly() {
        try {
            return ((KeyguardManager) jad_an.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_dq.jad_an.jad_bo("AntiSDK", e2.getMessage());
            return false;
        }
    }

    public static boolean jad_mz() {
        try {
            return !((PowerManager) jad_an.getSystemService("power")).isScreenOn();
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_dq.jad_an.jad_bo("AntiSDK", e2.getMessage());
            return false;
        }
    }
}
