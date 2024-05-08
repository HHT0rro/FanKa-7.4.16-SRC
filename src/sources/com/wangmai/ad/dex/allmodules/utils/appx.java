package com.wangmai.ad.dex.allmodules.utils;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.huawei.openalliance.ad.constant.u;
import com.wangmai.common.utils.ThreadUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appx {

    /* renamed from: appa, reason: collision with root package name */
    private static final String f46868appa = "appx";
    private static String appb = "";
    private static int[] appc = {28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14};
    private static int[] appd = {9, 8, 8, 7, 7, 6, 5, 5, 4, 4, 4, 4, 4, 4, 4};
    private static final FileFilter appe = new appb();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa implements Callable<Integer> {
        appa() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() {
            int i10 = 0;
            int i11 = 1;
            try {
                if (Build.VERSION.SDK_INT > 10) {
                    try {
                        i10 = new File("/sys/devices/system/cpu/").listFiles(appx.appe).length;
                        i11 = i10;
                    } catch (Throwable th) {
                        appa.appa.appf.appd.appe(appx.f46868appa, "getCpuCores error:" + th.toString());
                    }
                }
            } catch (Throwable th2) {
                Object[] objArr = new Object[2];
                objArr[i10] = appx.f46868appa;
                objArr[1] = "getCpuType error1:" + th2.toString();
                appa.appa.appf.appd.appe(objArr);
            }
            return Integer.valueOf(i11);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb implements FileFilter {
        appb() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements Callable<Integer> {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46869appa;

        appc(String str) {
            this.f46869appa = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        
            if (r3 == null) goto L23;
         */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Integer call() {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
                java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L28
                java.lang.String r3 = r9.f46869appa     // Catch: java.lang.Throwable -> L28
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L28
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L23
                r3.<init>(r2)     // Catch: java.lang.Throwable -> L23
                java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> L21
                java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L21
                int r1 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L21
                r2.close()     // Catch: java.lang.Throwable -> L1d
            L1d:
                r3.close()     // Catch: java.lang.Throwable -> L5a
                goto L5a
            L21:
                r0 = move-exception
                goto L2c
            L23:
                r3 = move-exception
                r8 = r3
                r3 = r0
                r0 = r8
                goto L2c
            L28:
                r2 = move-exception
                r3 = r0
                r0 = r2
                r2 = r3
            L2c:
                r4 = 2
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5f
                java.lang.String r5 = com.wangmai.ad.dex.allmodules.utils.appx.appb()     // Catch: java.lang.Throwable -> L5f
                r4[r1] = r5     // Catch: java.lang.Throwable -> L5f
                r5 = 1
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f
                r6.<init>()     // Catch: java.lang.Throwable -> L5f
                java.lang.String r7 = "getCpuFrequency error1:"
                r6.append(r7)     // Catch: java.lang.Throwable -> L5f
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5f
                r6.append(r0)     // Catch: java.lang.Throwable -> L5f
                java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L5f
                r4[r5] = r0     // Catch: java.lang.Throwable -> L5f
                appa.appa.appf.appd.appe(r4)     // Catch: java.lang.Throwable -> L5f
                if (r2 == 0) goto L57
                r2.close()     // Catch: java.lang.Throwable -> L56
                goto L57
            L56:
            L57:
                if (r3 == 0) goto L5a
                goto L1d
            L5a:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                return r0
            L5f:
                r0 = move-exception
                if (r2 == 0) goto L67
                r2.close()     // Catch: java.lang.Throwable -> L66
                goto L67
            L66:
            L67:
                if (r3 == 0) goto L6c
                r3.close()     // Catch: java.lang.Throwable -> L6c
            L6c:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appc.call():java.lang.Integer");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] appc(android.content.Context r10) {
        /*
            java.lang.String r0 = "status"
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = -1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = 0
            r3[r6] = r5
            r5 = 0
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r7 = 1
            r3[r7] = r5
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
            r8 = 2
            r3[r8] = r5
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch: java.lang.Throwable -> L61
            java.lang.String r9 = "android.intent.action.BATTERY_CHANGED"
            r5.<init>(r9)     // Catch: java.lang.Throwable -> L61
            r9 = 0
            android.content.Intent r10 = r10.registerReceiver(r9, r5)     // Catch: java.lang.Throwable -> L61
            int r5 = r10.getIntExtra(r0, r4)     // Catch: java.lang.Throwable -> L61
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L61
            r3[r6] = r5     // Catch: java.lang.Throwable -> L61
            java.lang.String r5 = "level"
            int r5 = r10.getIntExtra(r5, r4)     // Catch: java.lang.Throwable -> L61
            java.lang.String r9 = "scale"
            int r9 = r10.getIntExtra(r9, r4)     // Catch: java.lang.Throwable -> L61
            int r5 = r5 * 100
            float r5 = (float) r5     // Catch: java.lang.Throwable -> L61
            float r9 = (float) r9     // Catch: java.lang.Throwable -> L61
            float r5 = r5 / r9
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch: java.lang.Throwable -> L61
            r3[r7] = r5     // Catch: java.lang.Throwable -> L61
            int r10 = r10.getIntExtra(r0, r4)     // Catch: java.lang.Throwable -> L61
            if (r10 == r8) goto L59
            r0 = 5
            if (r10 != r0) goto L57
            goto L59
        L57:
            r10 = 0
            goto L5a
        L59:
            r10 = 1
        L5a:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> L61
            r3[r8] = r10     // Catch: java.lang.Throwable -> L61
            goto L82
        L61:
            r10 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r4 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r6] = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getBatteryInfo error:"
            r4.append(r5)
            java.lang.String r10 = r10.toString()
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            r0[r7] = r10
            appa.appa.appf.appd.appe(r0)
        L82:
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            r0 = 10
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 <= 0) goto Lae
            java.lang.Object[] r10 = new java.lang.Object[r8]
            java.lang.String r0 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r10[r6] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "电池信息获取耗时："
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10[r7] = r0
            appa.appa.appf.appd.appe(r10)
        Lae:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appc(android.content.Context):java.lang.Object[]");
    }

    private static boolean appd() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean appe(android.content.Context r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 2
            r3 = 1
            r4 = 0
            java.lang.String r5 = "sensor"
            java.lang.Object r8 = r8.getSystemService(r5)     // Catch: java.lang.Throwable -> L18
            android.hardware.SensorManager r8 = (android.hardware.SensorManager) r8     // Catch: java.lang.Throwable -> L18
            r5 = 4
            android.hardware.Sensor r8 = r8.getDefaultSensor(r5)     // Catch: java.lang.Throwable -> L18
            if (r8 == 0) goto L39
            r8 = 1
            goto L3a
        L18:
            r8 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r5[r4] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "getDeviceGyroscope error:"
            r6.append(r7)
            java.lang.String r8 = r8.toString()
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            r5[r3] = r8
            appa.appa.appf.appd.appe(r5)
        L39:
            r8 = 0
        L3a:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r0 = 10
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 <= 0) goto L66
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r4] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "设备陀螺仪获取耗时："
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r3] = r1
            appa.appa.appf.appd.appe(r0)
        L66:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appe(android.content.Context):boolean");
    }

    public static String appf(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        try {
            StringBuffer stringBuffer = new StringBuffer();
            List<Sensor> sensorList = ((SensorManager) context.getSystemService("sensor")).getSensorList(-1);
            if (sensorList != null && !sensorList.isEmpty()) {
                Iterator<Sensor> iterator2 = sensorList.iterator2();
                while (iterator2.hasNext()) {
                    stringBuffer.append(iterator2.next().getName());
                    stringBuffer.append(",");
                }
                str = stringBuffer.toString();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getDeviceSensors error:" + th.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "传感器信息获取耗时：" + currentTimeMillis2 + " ms");
        }
        return str;
    }

    public static String appg(Context context) {
        String defaultUserAgent;
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        try {
            if (TextUtils.isEmpty(appb)) {
                try {
                    if (Build.VERSION.SDK_INT < 19) {
                        defaultUserAgent = new WebView(context).getSettings().getUserAgentString();
                    } else {
                        defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    }
                    str = defaultUserAgent;
                } catch (Throwable unused) {
                }
                appb = str;
            } else {
                str = appb;
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getUserAgent error:" + th.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "获取设备UA耗时：" + currentTimeMillis2 + " ms");
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int apph() {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.wangmai.ad.dex.allmodules.utils.appx$appa r2 = new com.wangmai.ad.dex.allmodules.utils.appx$appa
            r2.<init>()
            java.util.concurrent.Future r2 = com.wangmai.common.utils.ThreadUtils.runOnThreadPool(r2)
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L1d
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L1d
            goto L3f
        L1d:
            r2 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.String r7 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r6[r3] = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getCpuType error2:"
            r7.append(r8)
            java.lang.String r2 = r2.toString()
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r6[r5] = r2
            appa.appa.appf.appd.appe(r6)
        L3e:
            r2 = 1
        L3f:
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r0
            r0 = 10
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 <= 0) goto L6b
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r3] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "CPU核数获取耗时："
            r1.append(r3)
            r1.append(r6)
            java.lang.String r3 = " ms"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0[r5] = r1
            appa.appa.appf.appd.appe(r0)
        L6b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.apph():int");
    }

    public static String appi() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (Build.VERSION.SDK_INT >= 21) {
                for (String str2 : Build.SUPPORTED_ABIS) {
                    stringBuffer.append(str2);
                    stringBuffer.append(",");
                }
            } else {
                stringBuffer.append(Build.CPU_ABI);
                stringBuffer.append(",");
                stringBuffer.append(Build.CPU_ABI2);
            }
            str = stringBuffer.toString();
            if (!TextUtils.isEmpty(str) && str.endsWith(",")) {
                str = str.substring(0, str.length() - 1);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getCpuType error:" + th.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "CPU类型获取耗时：" + currentTimeMillis2 + " ms");
        }
        return str;
    }

    public static int appj() {
        return appa("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
    }

    public static String appk() {
        return Build.DEVICE;
    }

    public static int appl() {
        int i10;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            i10 = (int) ((new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() / 1024) / 1024);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getFreeMemory error:" + th.toString());
            i10 = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "可用ROM获取耗时：" + currentTimeMillis2 + " ms");
        }
        return i10;
    }

    public static int appm() {
        return appa("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
    }

    public static int appn() {
        return appa("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean appo(android.content.Context r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 2
            r3 = 1
            r4 = 0
            java.lang.String r5 = "phone"
            java.lang.Object r8 = r8.getSystemService(r5)     // Catch: java.lang.Throwable -> L17
            android.telephony.TelephonyManager r8 = (android.telephony.TelephonyManager) r8     // Catch: java.lang.Throwable -> L17
            int r8 = r8.getPhoneType()     // Catch: java.lang.Throwable -> L17
            if (r8 == 0) goto L38
            r8 = 1
            goto L39
        L17:
            r8 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r5[r4] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isSupportPhoneCalls error:"
            r6.append(r7)
            java.lang.String r8 = r8.toString()
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            r5[r3] = r8
            appa.appa.appf.appd.appe(r5)
        L38:
            r8 = 0
        L39:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r0 = 10
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 <= 0) goto L65
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r4] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "是否支持拨打电话获取耗时："
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r3] = r1
            appa.appa.appf.appd.appe(r0)
        L65:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appo(android.content.Context):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
    
        if (android.text.TextUtils.isEmpty(r8.getName()) != false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean appp(android.content.Context r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 2
            r3 = 0
            r4 = 1
            java.lang.String r5 = "android.permission.BLUETOOTH"
            boolean r8 = com.wangmai.common.utils.PermissionUtils.checkPermission(r8, r5)     // Catch: java.lang.Throwable -> L22
            if (r8 == 0) goto L43
            android.bluetooth.BluetoothAdapter r8 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch: java.lang.Throwable -> L22
            if (r8 != 0) goto L17
        L15:
            r8 = 1
            goto L44
        L17:
            java.lang.String r8 = r8.getName()     // Catch: java.lang.Throwable -> L22
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L22
            if (r8 == 0) goto L43
            goto L15
        L22:
            r8 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r5[r3] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "notHasBlueTooth error:"
            r6.append(r7)
            java.lang.String r8 = r8.toString()
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            r5[r4] = r8
            appa.appa.appf.appd.appe(r5)
        L43:
            r8 = 0
        L44:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r0 = 10
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 <= 0) goto L70
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r3] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "判定模拟器【检测蓝牙是否可用】耗时："
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r4] = r1
            appa.appa.appf.appd.appe(r0)
        L70:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appp(android.content.Context):boolean");
    }

    public static int[] appq() {
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr = {0, 0, 0};
        try {
            String[] split = Build.VERSION.RELEASE.split("\\.");
            if (split != null && split.length > 0 && split[0] != null) {
                if (appb(split[0])) {
                    iArr[0] = Integer.valueOf(split[0]).intValue();
                    if (split.length > 1 && split[1] != null && appb(split[1])) {
                        iArr[1] = Integer.valueOf(split[1]).intValue();
                    }
                    if (split.length > 2 && split[2] != null && appb(split[2])) {
                        iArr[2] = Integer.valueOf(split[2]).intValue();
                    }
                } else {
                    int i10 = Build.VERSION.SDK_INT;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= appc.length) {
                            break;
                        }
                        if (i10 == appc[i11]) {
                            iArr[0] = Integer.valueOf(appd[i11]).intValue();
                            break;
                        }
                        i11++;
                    }
                }
            } else {
                int i12 = Build.VERSION.SDK_INT;
                int i13 = 0;
                while (true) {
                    if (i13 >= appc.length) {
                        break;
                    }
                    if (i12 == appc[i13]) {
                        iArr[0] = appd[i13];
                        break;
                    }
                    i13++;
                }
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getOsVersionInfo error:" + th.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "操作系统版本获取耗时：" + currentTimeMillis2 + " ms");
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int appr() {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 2
            r3 = 0
            r4 = 0
            r5 = 1
            java.lang.String r6 = "/proc/meminfo"
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5c
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5c
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L53
            r8 = 1024(0x400, float:1.435E-42)
            r6.<init>(r7, r8)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L53
            java.lang.String r3 = r6.readLine()     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            boolean r9 = android.text.TextUtils.isEmpty(r3)     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            if (r9 != 0) goto L43
            java.lang.String r9 = ":"
            java.lang.String[] r3 = r3.split(r9)     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            if (r3 == 0) goto L43
            int r9 = r3.length     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            if (r9 <= r5) goto L43
            r9 = r3[r5]     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            if (r9 == 0) goto L43
            r3 = r3[r5]     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            java.lang.String r9 = "kB"
            java.lang.String r10 = ""
            java.lang.String r3 = r3.replace(r9, r10)     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            java.lang.String r3 = r3.trim()     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.io.IOException -> L4d java.lang.Throwable -> Lb8
            int r3 = r3 / r8
            goto L44
        L43:
            r3 = 0
        L44:
            r7.close()     // Catch: java.lang.Throwable -> L4b
            r6.close()     // Catch: java.lang.Throwable -> L4b
            goto L8b
        L4b:
            goto L8b
        L4d:
            r3 = move-exception
            goto L60
        L4f:
            r0 = move-exception
            r6 = r3
            goto Lb9
        L53:
            r6 = move-exception
            r11 = r6
            r6 = r3
            r3 = r11
            goto L60
        L58:
            r0 = move-exception
            r6 = r3
            r7 = r6
            goto Lb9
        L5c:
            r6 = move-exception
            r7 = r3
            r3 = r6
            r6 = r7
        L60:
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r9 = "RequestJson"
            r8[r4] = r9     // Catch: java.lang.Throwable -> Lb8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb8
            r9.<init>()     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r10 = "getMemoryInfo:"
            r9.append(r10)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lb8
            r9.append(r3)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r3 = r9.toString()     // Catch: java.lang.Throwable -> Lb8
            r8[r5] = r3     // Catch: java.lang.Throwable -> Lb8
            appa.appa.appf.appd.appe(r8)     // Catch: java.lang.Throwable -> Lb8
            if (r7 == 0) goto L85
            r7.close()     // Catch: java.lang.Throwable -> L8a
        L85:
            if (r6 == 0) goto L8a
            r6.close()     // Catch: java.lang.Throwable -> L8a
        L8a:
            r3 = 0
        L8b:
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r0
            r0 = 10
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 <= 0) goto Lb7
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r4] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "获取运行内存(RAM)耗时："
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r5] = r1
            appa.appa.appf.appd.appe(r0)
        Lb7:
            return r3
        Lb8:
            r0 = move-exception
        Lb9:
            if (r7 == 0) goto Lbe
            r7.close()     // Catch: java.lang.Throwable -> Lc3
        Lbe:
            if (r6 == 0) goto Lc3
            r6.close()     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appr():int");
    }

    public static int apps() {
        int i10;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            i10 = (int) ((new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() / 1024) / 1024);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("RequestJson", "getTotalInternalMemorySize:" + th.toString());
            i10 = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "获取存储内存(ROM)耗时：" + currentTimeMillis2 + " ms");
        }
        return i10;
    }

    private static boolean appt() {
        System.currentTimeMillis();
        try {
            if (!Build.FINGERPRINT.startsWith("generic") && !Build.FINGERPRINT.toLowerCase().contains("vbox") && !Build.FINGERPRINT.toLowerCase().contains("test-keys") && !Build.MODEL.contains("google_sdk") && !Build.MODEL.contains("Emulator") && !Build.MODEL.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic"))) {
                if (!"google_sdk".equals(Build.PRODUCT)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "ifFeatures error:" + th.toString());
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (appe() != false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean appu() {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 2
            r3 = 1
            r4 = 0
            boolean r5 = appd()     // Catch: java.lang.Throwable -> L15
            if (r5 != 0) goto L13
            boolean r5 = appe()     // Catch: java.lang.Throwable -> L15
            if (r5 == 0) goto L36
        L13:
            r5 = 1
            goto L37
        L15:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r7 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r6[r4] = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "isRooted error:"
            r7.append(r8)
            java.lang.String r5 = r5.toString()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6[r3] = r5
            appa.appa.appf.appd.appe(r6)
        L36:
            r5 = 0
        L37:
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r0
            r0 = 10
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 <= 0) goto L63
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r4] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Root判定耗时："
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r3] = r1
            appa.appa.appf.appd.appe(r0)
        L63:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appu():boolean");
    }

    private static String appv() {
        System.currentTimeMillis();
        BufferedReader bufferedReader = null;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    } else {
                        String lowerCase = stringBuffer.toString().toLowerCase();
                        try {
                            bufferedReader2.close();
                            return lowerCase;
                        } catch (Throwable unused) {
                            return lowerCase;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        appa.appa.appf.appd.appe(f46868appa, "readCpuInfo error:" + th.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        return "";
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String appa(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String appa2 = appa(context, u.W);
        if (TextUtils.isEmpty(appa2)) {
            appa2 = "";
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "获取华为应用市场版本耗时：" + currentTimeMillis2 + " ms");
        }
        return appa2;
    }

    public static String appb(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String appa2 = appa(context, "com.huawei.hwid");
        if (TextUtils.isEmpty(appa2)) {
            appa2 = "";
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "获取华为移动服务HMS版本耗时：" + currentTimeMillis2 + " ms");
        }
        return appa2;
    }

    private static boolean appj(Context context) {
        boolean z10;
        try {
            z10 = false;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                try {
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(context.getApplicationInfo().processName)) {
                        z10 = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    appa.appa.appf.appd.appe(f46868appa, "isForeground(runningProcess) error:" + th.toString());
                    return z10;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
        return z10;
    }

    private static boolean appk(Context context) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks.isEmpty()) {
                return false;
            }
            return runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "isForeground(runningTasks) error:" + th.toString());
            return false;
        }
    }

    public static boolean appm(Context context) {
        boolean z10;
        boolean isScreenOn;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (Build.VERSION.SDK_INT >= 20) {
                isScreenOn = powerManager.isInteractive();
            } else {
                isScreenOn = powerManager.isScreenOn();
            }
            z10 = !isScreenOn;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "isScreenBlack error:" + th.toString());
            z10 = false;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "是否黑屏获取耗时：" + currentTimeMillis2 + " ms");
        }
        return z10;
    }

    public static boolean appn(Context context) {
        boolean z10;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            z10 = ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "isScreenLocked error:" + th.toString());
            z10 = false;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            appa.appa.appf.appd.appe(f46868appa, "是否锁屏获取耗时：" + currentTimeMillis2 + " ms");
        }
        return z10;
    }

    public static int appd(Context context) {
        try {
            return context.getResources().getConfiguration().orientation == 1 ? 2 : 1;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getConfigOrientation error:" + th.toString());
            return 2;
        }
    }

    private static String appa(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 1);
            return packageInfo != null ? String.valueOf(packageInfo.versionCode) : "";
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getVersionCode error:" + th.toString());
            return "";
        }
    }

    private static boolean appb(String str) {
        return Pattern.compile("[0-9]*$").matcher(str).matches();
    }

    private static boolean appe() {
        try {
            for (String str : new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}) {
                if (new File(str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            appa.appa.appf.appd.appa(f46868appa, "isRooted error:" + th.toString());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int apph(android.content.Context r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            r3 = 2
            r4 = 0
            android.content.pm.PackageManager r5 = r8.getPackageManager()     // Catch: java.lang.Throwable -> L18
            java.lang.String r8 = r8.getPackageName()     // Catch: java.lang.Throwable -> L18
            android.content.pm.PackageInfo r8 = r5.getPackageInfo(r8, r4)     // Catch: java.lang.Throwable -> L18
            if (r8 == 0) goto L39
            int r8 = r8.versionCode     // Catch: java.lang.Throwable -> L18
            goto L3a
        L18:
            r8 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.String r6 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r5[r4] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "getVersionCode error:"
            r6.append(r7)
            java.lang.String r8 = r8.toString()
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            r5[r2] = r8
            appa.appa.appf.appd.appe(r5)
        L39:
            r8 = 0
        L3a:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r0 = 10
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 <= 0) goto L66
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r4] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "获取应用版本号耗时："
            r1.append(r3)
            r1.append(r5)
            java.lang.String r3 = " ms"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0[r2] = r1
            appa.appa.appf.appd.appe(r0)
        L66:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.apph(android.content.Context):int");
    }

    public static String appo() {
        return Build.MODEL;
    }

    public static boolean appl(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return appj(context);
        }
        return appk(context);
    }

    public static int appp() {
        return Build.VERSION.SDK_INT;
    }

    private static int appa(String str) {
        System.currentTimeMillis();
        Future runOnThreadPool = ThreadUtils.runOnThreadPool(new appc(str));
        if (runOnThreadPool == null) {
            return 0;
        }
        try {
            return ((Integer) runOnThreadPool.get()).intValue();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getCpuFrequency error2:" + th.toString());
            return 0;
        }
    }

    public static String appf() {
        return Build.BOOTLOADER;
    }

    public static String appg() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "getCountryCode error:" + th.toString());
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        if (appc() != false) goto L5;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean appi(android.content.Context r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 2
            r3 = 0
            r4 = 1
            boolean r5 = appp(r8)     // Catch: java.lang.Throwable -> L24
            if (r5 == 0) goto Lf
        Ld:
            r8 = 1
            goto L46
        Lf:
            boolean r8 = appq(r8)     // Catch: java.lang.Throwable -> L24
            if (r8 == 0) goto L16
            goto Ld
        L16:
            boolean r8 = appt()     // Catch: java.lang.Throwable -> L24
            if (r8 == 0) goto L1d
            goto Ld
        L1d:
            boolean r8 = appc()     // Catch: java.lang.Throwable -> L24
            if (r8 == 0) goto L45
            goto Ld
        L24:
            r8 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r5[r3] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isEmulator error:"
            r6.append(r7)
            java.lang.String r8 = r8.toString()
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            r5[r4] = r8
            appa.appa.appf.appd.appe(r5)
        L45:
            r8 = 0
        L46:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r0 = 10
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 <= 0) goto L72
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r3] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "是否模拟器获取耗时："
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r4] = r1
            appa.appa.appf.appd.appe(r0)
        L72:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appi(android.content.Context):boolean");
    }

    private static boolean appc() {
        System.currentTimeMillis();
        try {
            String appv = appv();
            if (TextUtils.isEmpty(appv)) {
                return false;
            }
            if (!appv.contains("intel")) {
                if (!appv.contains("amd")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46868appa, "checkIsNotRealPhone error:" + th.toString());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean appq(android.content.Context r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 2
            r3 = 1
            r4 = 0
            java.lang.String r5 = "sensor"
            java.lang.Object r8 = r8.getSystemService(r5)     // Catch: java.lang.Throwable -> L18
            android.hardware.SensorManager r8 = (android.hardware.SensorManager) r8     // Catch: java.lang.Throwable -> L18
            r5 = 5
            android.hardware.Sensor r8 = r8.getDefaultSensor(r5)     // Catch: java.lang.Throwable -> L18
            if (r8 != 0) goto L39
            r8 = 1
            goto L3a
        L18:
            r8 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r5[r4] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "notHasLightSensorManager error:"
            r6.append(r7)
            java.lang.String r8 = r8.toString()
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            r5[r3] = r8
            appa.appa.appf.appd.appe(r5)
        L39:
            r8 = 0
        L3a:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r0 = 10
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 <= 0) goto L66
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = com.wangmai.ad.dex.allmodules.utils.appx.f46868appa
            r0[r4] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "判定模拟器【检测光传感器】耗时："
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r3] = r1
            appa.appa.appf.appd.appe(r0)
        L66:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.utils.appx.appq(android.content.Context):boolean");
    }
}
