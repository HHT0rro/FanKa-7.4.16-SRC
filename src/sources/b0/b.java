package b0;

import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.android.internal.os.PowerProfile;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.g;
import com.mobile.auth.gatewayauth.Constant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f1232a = new b();

    public static String A(Context context) {
        if (e(context, g.f36117c)) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            if (simSerialNumber == null) {
                return "";
            }
            try {
                if (simSerialNumber.length() == 0) {
                    return "";
                }
            } catch (Throwable unused) {
            }
            return simSerialNumber;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String B() {
        String str;
        try {
            str = Build.SERIAL;
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String C(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String D() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x001d, code lost:
    
        if ("02:00:00:00:00:00".equals(r0) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String E(android.content.Context r3) {
        /*
            java.lang.String r0 = "android.permission.BLUETOOTH"
            boolean r0 = e(r3, r0)
            java.lang.String r1 = ""
            if (r0 == 0) goto Lb
            return r1
        Lb:
            java.lang.String r0 = W()
            if (r0 == 0) goto L1f
            int r2 = r0.length()     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L1f
            java.lang.String r2 = "02:00:00:00:00:00"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L29
        L1f:
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "bluetooth_address"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r3, r2)     // Catch: java.lang.Throwable -> L2e
        L29:
            if (r0 != 0) goto L2c
            goto L2d
        L2c:
            r1 = r0
        L2d:
            r0 = r1
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b.E(android.content.Context):java.lang.String");
    }

    public static String F() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String G(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String H() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String I(android.content.Context r2) {
        /*
            java.lang.String r0 = "android.permission.ACCESS_WIFI_STATE"
            boolean r0 = e(r2, r0)
            java.lang.String r1 = ""
            if (r0 == 0) goto Lb
            return r1
        Lb:
            java.lang.String r0 = "wifi"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch: java.lang.Throwable -> L22
            android.net.wifi.WifiManager r2 = (android.net.wifi.WifiManager) r2     // Catch: java.lang.Throwable -> L22
            boolean r0 = r2.isWifiEnabled()     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L22
            android.net.wifi.WifiInfo r2 = r2.getConnectionInfo()     // Catch: java.lang.Throwable -> L22
            java.lang.String r2 = r2.getBSSID()     // Catch: java.lang.Throwable -> L22
            goto L23
        L22:
            r2 = r1
        L23:
            if (r2 != 0) goto L26
            goto L27
        L26:
            r1 = r2
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b.I(android.content.Context):java.lang.String");
    }

    public static String J() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SystemClock.elapsedRealtime());
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String K(Context context) {
        try {
            String Q = Q(context);
            String a10 = a();
            if (!z.a.g(Q) || !z.a.g(a10)) {
                return "";
            }
            return Q + u.bD + a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String L() {
        try {
            StringBuilder sb2 = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb2.append("00" + u.bD);
            for (int i10 = 0; i10 < 7; i10++) {
                sb2.append(new File(strArr[i10]).exists() ? "1" : "0");
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String M(Context context) {
        try {
            long j10 = 0;
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            for (int i10 = 0; i10 < 5; i10++) {
                long j11 = -1;
                try {
                    j11 = new File(strArr[i10]).lastModified();
                } catch (Throwable unused) {
                }
                j10 = Math.max(j11, j10);
            }
            return "1:" + j10;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String N() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb2 = new StringBuilder();
        sb2.append("00");
        sb2.append(u.bD);
        for (int i10 = 0; i10 <= 0; i10++) {
            try {
                Class.forName(strArr[0]);
                sb2.append("1");
            } catch (Throwable unused) {
                sb2.append("0");
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String O(android.content.Context r3) {
        /*
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L3f
            r1 = 0
            android.content.Intent r3 = r3.registerReceiver(r1, r0)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r0 = "level"
            r1 = -1
            int r0 = r3.getIntExtra(r0, r1)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = "status"
            int r3 = r3.getIntExtra(r2, r1)     // Catch: java.lang.Throwable -> L3f
            r1 = 2
            if (r3 == r1) goto L22
            r1 = 5
            if (r3 != r1) goto L20
            goto L22
        L20:
            r3 = 0
            goto L23
        L22:
            r3 = 1
        L23:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            r1.<init>()     // Catch: java.lang.Throwable -> L3f
            if (r3 == 0) goto L2d
            java.lang.String r3 = "1"
            goto L2f
        L2d:
            java.lang.String r3 = "0"
        L2f:
            r1.append(r3)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = ":"
            r1.append(r3)     // Catch: java.lang.Throwable -> L3f
            r1.append(r0)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L3f
            return r3
        L3f:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b.O(android.content.Context):java.lang.String");
    }

    public static String P() {
        StringBuilder sb2 = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb2.append("00" + u.bD);
        for (String str : linkedHashMap.h()) {
            LineNumberReader lineNumberReader = null;
            char c4 = '0';
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                            c4 = '1';
                            break;
                        }
                    } catch (Throwable unused) {
                        lineNumberReader = lineNumberReader2;
                        sb2.append('0');
                        if (lineNumberReader != null) {
                            lineNumberReader.close();
                        }
                    }
                }
                sb2.append(c4);
                try {
                    lineNumberReader2.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        }
        return sb2.toString();
    }

    public static String Q(Context context) {
        if (e(context, g.f36116b)) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype != 4 && subtype != 1 && subtype != 2 && subtype != 7 && subtype != 11) {
                if (subtype != 3 && subtype != 5 && subtype != 6 && subtype != 8 && subtype != 9 && subtype != 10 && subtype != 12 && subtype != 14 && subtype != 15) {
                    return subtype == 13 ? "4G" : "UNKNOW";
                }
                return "3G";
            }
            return "2G";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String R() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("00" + u.bD);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str : linkedHashMap.h()) {
            char c4 = '0';
            try {
                String str2 = (String) Build.class.getField(str).get(null);
                String str3 = (String) linkedHashMap.get(str);
                String lowerCase = str2 != null ? str2.toLowerCase() : null;
                if (lowerCase != null && lowerCase.contains(str3)) {
                    c4 = '1';
                }
            } catch (Throwable unused) {
            }
            sb2.append(c4);
        }
        return sb2.toString();
    }

    public static String S() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("00" + u.bD);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put(SystemUtils.PRODUCT_BRAND, "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.h()) {
            char c4 = '0';
            String str2 = (String) linkedHashMap.get(str);
            String f10 = z.a.f(str, "");
            if (f10 != null && f10.contains(str2)) {
                c4 = '1';
            }
            sb2.append(c4);
        }
        return sb2.toString();
    }

    public static String T() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list == null) {
                return "02:00:00:00:00:00";
            }
            for (NetworkInterface networkInterface : list) {
                if (networkInterface != null && networkInterface.getName() != null && networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "02:00:00:00:00:00";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b4 : hardwareAddress) {
                        sb2.append(String.format("%02X:", Integer.valueOf(b4 & 255)));
                    }
                    if (sb2.length() > 0) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Throwable unused) {
            return "02:00:00:00:00:00";
        }
    }

    public static String U() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileReader = null;
        }
        try {
            readLine = bufferedReader.readLine();
        } catch (Throwable unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            if (fileReader == null) {
                return "";
            }
            try {
                fileReader.close();
            } catch (Throwable unused5) {
                return "";
            }
        }
        if (!z.a.d(readLine)) {
            String trim = readLine.trim();
            try {
                bufferedReader.close();
            } catch (Throwable unused6) {
            }
            try {
                fileReader.close();
            } catch (Throwable unused7) {
            }
            return trim;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused8) {
        }
        fileReader.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r1 = r2[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003a, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004c, code lost:
    
        if (r0 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String V() {
        /*
            java.lang.String r0 = "/proc/cpuinfo"
            java.lang.String r1 = ""
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L44
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L44
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L41
            r4 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3, r4)     // Catch: java.lang.Throwable -> L41
        L11:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L3a
            boolean r4 = z.a.d(r2)     // Catch: java.lang.Throwable -> L42
            if (r4 != 0) goto L11
            java.lang.String r4 = ":"
            java.lang.String[] r2 = r2.split(r4)     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L11
            int r4 = r2.length     // Catch: java.lang.Throwable -> L42
            r5 = 1
            if (r4 <= r5) goto L11
            r4 = 0
            r4 = r2[r4]     // Catch: java.lang.Throwable -> L42
            java.lang.String r6 = "BogoMIPS"
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> L42
            if (r4 == 0) goto L11
            r2 = r2[r5]     // Catch: java.lang.Throwable -> L42
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Throwable -> L42
        L3a:
            r3.close()     // Catch: java.lang.Throwable -> L3d
        L3d:
            r0.close()     // Catch: java.lang.Throwable -> L4f
            goto L4f
        L41:
            r0 = r2
        L42:
            r2 = r3
            goto L45
        L44:
            r0 = r2
        L45:
            if (r2 == 0) goto L4c
            r2.close()     // Catch: java.lang.Throwable -> L4b
            goto L4c
        L4b:
        L4c:
            if (r0 == 0) goto L4f
            goto L3d
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b.V():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String W() {
        /*
            java.lang.String r0 = ""
            android.bluetooth.BluetoothAdapter r1 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto Lf
            boolean r2 = r1.isEnabled()     // Catch: java.lang.Throwable -> L15
            if (r2 != 0) goto Lf
            return r0
        Lf:
            java.lang.String r2 = r1.getAddress()     // Catch: java.lang.Throwable -> L15
            goto L16
        L14:
            r1 = 0
        L15:
            r2 = r0
        L16:
            if (r2 == 0) goto L20
            java.lang.String r3 = "00:00:00:00:00"
            boolean r3 = r2.endsWith(r3)
            if (r3 == 0) goto L26
        L20:
            java.lang.String r2 = c(r1)     // Catch: java.lang.Throwable -> L25
            goto L26
        L25:
        L26:
            if (r2 != 0) goto L29
            goto L2a
        L29:
            r0 = r2
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b.W():java.lang.String");
    }

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static b b() {
        return f1232a;
    }

    public static String c(BluetoothAdapter bluetoothAdapter) {
        Object obj;
        try {
            Field declaredField = BluetoothAdapter.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            obj = declaredField.get(bluetoothAdapter);
        } catch (Throwable unused) {
        }
        if (obj == null) {
            return null;
        }
        Method declaredMethod = obj.getClass().getDeclaredMethod("getAddress", new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(obj, new Object[0]);
        if (invoke != null && (invoke instanceof String)) {
            return (String) invoke;
        }
        return null;
    }

    public static String d(Context context) {
        if (e(context, g.f36117c)) {
            return "";
        }
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    public static boolean e(Context context, String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static String f() {
        long j10;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j10 = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            j10 = 0;
        }
        return String.valueOf(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(android.content.Context r2) {
        /*
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            boolean r0 = e(r2, r0)
            java.lang.String r1 = ""
            if (r0 == 0) goto Lb
            return r1
        Lb:
            if (r2 == 0) goto L1c
            java.lang.String r0 = "phone"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch: java.lang.Throwable -> L1c
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L1c
            java.lang.String r2 = r2.getSubscriberId()     // Catch: java.lang.Throwable -> L1c
            goto L1d
        L1c:
            r2 = r1
        L1d:
            if (r2 != 0) goto L20
            goto L21
        L20:
            r1 = r2
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b.g(android.content.Context):java.lang.String");
    }

    public static String h() {
        long j10 = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(z.a.a().getPath());
                j10 = statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(j10);
    }

    public static String i(Context context) {
        int i10 = 0;
        try {
            i10 = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i10 == 1 ? "1" : "0";
    }

    public static String j() {
        return "";
    }

    public static String k(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
            int i10 = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i10));
            jSONObject.put("call", String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        if (r2 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String l() {
        /*
            java.lang.String r0 = "0000000000000000"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L56
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L56
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L56
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L54
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L54
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L52
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L52
            r1 = 1
            r5 = 1
        L1b:
            r6 = 100
            if (r5 >= r6) goto L46
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L44
            if (r6 == 0) goto L46
            java.lang.String r7 = "Serial"
            int r7 = r6.indexOf(r7)     // Catch: java.lang.Throwable -> L44
            if (r7 < 0) goto L41
            java.lang.String r5 = ":"
            int r5 = r6.indexOf(r5)     // Catch: java.lang.Throwable -> L44
            int r5 = r5 + r1
            int r1 = r6.length()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = r6.substring(r5, r1)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L44
            goto L46
        L41:
            int r5 = r5 + 1
            goto L1b
        L44:
            r1 = r4
            goto L58
        L46:
            r4.close()     // Catch: java.lang.Throwable -> L49
        L49:
            r3.close()     // Catch: java.lang.Throwable -> L4c
        L4c:
            r2.close()     // Catch: java.lang.Throwable -> L50
            goto L69
        L50:
            goto L69
        L52:
            goto L58
        L54:
            r3 = r1
            goto L58
        L56:
            r2 = r1
            r3 = r2
        L58:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.lang.Throwable -> L5e
            goto L5f
        L5e:
        L5f:
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.lang.Throwable -> L65
            goto L66
        L65:
        L66:
            if (r2 == 0) goto L69
            goto L4c
        L69:
            if (r0 != 0) goto L6d
            java.lang.String r0 = ""
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b.l():java.lang.String");
    }

    public static String m(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getNetworkOperatorName();
                }
            } catch (Throwable unused) {
            }
        }
        return (str == null || "null".equals(str)) ? "" : str;
    }

    public static String o(Context context) {
        List<Sensor> sensorList;
        String str = null;
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (Sensor sensor : sensorList) {
                        sb2.append(sensor.getName());
                        sb2.append(sensor.getVersion());
                        sb2.append(sensor.getVendor());
                    }
                    str = z.a.j(sb2.toString());
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    public static String p() {
        String U = U();
        return !z.a.d(U) ? U : V();
    }

    public static String q(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put("version", sensor.getVersion());
                            jSONObject.put(Constant.LOGIN_ACTIVITY_VENDOR_KEY, sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    public static String r() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String[] split;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    split = bufferedReader.readLine().split(":\\s+", 2);
                } catch (Throwable unused) {
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused3) {
                        return "";
                    }
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        if (split != null && split.length > 1) {
            String str = split[1];
            try {
                fileReader.close();
            } catch (Throwable unused6) {
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused7) {
            }
            return str;
        }
        try {
            fileReader.close();
        } catch (Throwable unused8) {
        }
        bufferedReader.close();
    }

    public static String s(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + StringUtils.NO_PRINT_CODE + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0038, code lost:
    
        if (r0 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String t() {
        /*
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            r2 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L30
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L30
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2d
            r5 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = r0.readLine()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L26
            java.lang.String r5 = "\\s+"
            java.lang.String[] r1 = r1.split(r5)     // Catch: java.lang.Throwable -> L2e
            r5 = 1
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L2e
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L2e
            long r1 = (long) r1
            r2 = r1
        L26:
            r4.close()     // Catch: java.lang.Throwable -> L29
        L29:
            r0.close()     // Catch: java.lang.Throwable -> L3b
            goto L3b
        L2d:
            r0 = r1
        L2e:
            r1 = r4
            goto L31
        L30:
            r0 = r1
        L31:
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.lang.Throwable -> L37
            goto L38
        L37:
        L38:
            if (r0 == 0) goto L3b
            goto L29
        L3b:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b.t():java.lang.String");
    }

    public static String u(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(displayMetrics.widthPixels);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String v() {
        long j10;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j10 = statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable unused) {
            j10 = 0;
        }
        return String.valueOf(j10);
    }

    public static String w(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(displayMetrics.heightPixels);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String x() {
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

    public static String y(Context context) {
        String str = "";
        if (e(context, g.f36118d)) {
            return "";
        }
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (str == null || str.length() == 0 || "02:00:00:00:00:00".equals(str)) {
                return T();
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String z() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public final String n() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }
}
