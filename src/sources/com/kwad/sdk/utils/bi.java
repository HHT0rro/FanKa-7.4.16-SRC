package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.internal.os.PowerProfile;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bi {
    private static boolean aQA = false;
    private static String aQF = null;
    private static String aQG = null;
    private static int aQO = 0;
    private static long aQP = 0;
    private static String aQs = null;
    private static String aQt = "";
    private static boolean aQu = false;
    private static String aQv = "";
    private static String aQw = "";
    private static int aQx;
    private static boolean aQy;
    private static int aQz;
    private static final String[] aQB = {"", ""};
    private static String aQC = "";
    private static String aQD = "";
    private static String aQE = "";
    private static int aQH = -1;
    private static boolean aQI = false;
    private static boolean aQJ = false;
    private static boolean aQK = false;
    private static boolean aQL = false;
    private static boolean aQM = false;
    private static boolean aQN = false;
    private static String aQQ = "";
    private static String aQR = "";
    public static String aQS = "";
    private static final List<String> aQT = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    private static long MQ() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long MS() {
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    public static long MT() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.J(Environment.getDataDirectory());
    }

    public static long MU() {
        long freeMemory;
        try {
            freeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (freeMemory > 0) {
            return freeMemory;
        }
        return 0L;
    }

    public static int MV() {
        int i10 = aQO;
        if (i10 > 0) {
            return i10;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aQO = availableProcessors;
        return availableProcessors;
    }

    public static String MW() {
        return Build.MODEL;
    }

    public static synchronized long MX() {
        long j10;
        synchronized (bi.class) {
            j10 = 0;
            if (au.usePhoneStateDisable() && (!TextUtils.isEmpty(au.Mj()) || au.Mk() != null)) {
                j10 = 1;
            }
            if (au.Mh() && au.Mi() != null) {
                j10 |= 64;
            }
            if (au.usePhoneStateDisable() && !TextUtils.isEmpty(au.Ml())) {
                j10 |= 2;
            }
            if (au.Mm() && !TextUtils.isEmpty(au.Mn())) {
                j10 |= 4;
            }
            if (au.Mo() && !TextUtils.isEmpty(au.Mp())) {
                j10 |= 2048;
            }
            if (au.Ms()) {
                if (au.Mt() != null) {
                    j10 |= 16;
                }
            }
        }
        return j10;
    }

    public static String MY() {
        return Build.BRAND;
    }

    public static synchronized long MZ() {
        long elapsedRealtime;
        synchronized (bi.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    public static synchronized long Na() {
        long j10;
        synchronized (bi.class) {
            j10 = Build.TIME;
        }
        return j10;
    }

    public static synchronized String Nb() {
        String str;
        synchronized (bi.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static synchronized String Nc() {
        synchronized (bi.class) {
            if (!TextUtils.isEmpty(aQs)) {
                return aQs;
            }
            String radioVersion = Build.getRadioVersion();
            aQs = radioVersion;
            return radioVersion;
        }
    }

    public static synchronized String Nd() {
        String name;
        synchronized (bi.class) {
            name = at.getName();
        }
        return name;
    }

    public static synchronized String Ne() {
        String version;
        synchronized (bi.class) {
            version = at.getVersion();
        }
        return version;
    }

    public static String Nf() {
        return Build.MANUFACTURER;
    }

    public static int Ng() {
        if (aQH == -1) {
            aQH = df(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) ? 4 : 3;
        }
        return aQH;
    }

    public static String Nh() {
        if (TextUtils.isEmpty(aQG)) {
            aQG = System.getProperty("os.arch");
        }
        return aQG;
    }

    public static int Ni() {
        return Build.VERSION.SDK_INT;
    }

    public static String Nj() {
        if (au.Mq() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(aQS)) {
            return aQS;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        aQS = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String Nk() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String Nl() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String j10 = y.j("ksadsdk_pref", "android_id", null);
        y.k(j10, "ksadsdk_pref", "android_id");
        return j10;
    }

    public static String Nm() {
        if (!TextUtils.isEmpty(aQQ)) {
            return aQQ;
        }
        try {
            String V = q.V(new File("/proc/sys/kernel/random/boot_id"));
            aQQ = TextUtils.isEmpty(V) ? "" : V.substring(0, V.indexOf("\n"));
        } catch (Throwable unused) {
        }
        return aQQ;
    }

    private static String a(String str, int i10, char c4) {
        StringBuilder sb2 = new StringBuilder();
        while (sb2.length() + str.length() < 16) {
            sb2.append('0');
        }
        sb2.append(str);
        return sb2.toString();
    }

    public static synchronized String cA(Context context) {
        synchronized (bi.class) {
            if (context != null) {
                if (!aQJ && TextUtils.isEmpty(aQC) && SystemUtil.cU(context) && !au.usePhoneStateDisable() && o.Lp()) {
                    try {
                        aQC = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                    } catch (Exception unused) {
                    }
                    aQJ = TextUtils.isEmpty(aQC);
                    return aQC;
                }
            }
            return aQC;
        }
    }

    public static long cV(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int cW(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(512L)) {
            return 0;
        }
        try {
            return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long cX(Context context) {
        long j10 = aQP;
        if (j10 > 0) {
            return j10;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j11 = memoryInfo.totalMem;
            if (j11 <= 0) {
                j11 = MQ();
            }
            aQP = j11;
            return j11;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static synchronized String cY(@Nullable Context context) {
        synchronized (bi.class) {
            if (au.usePhoneStateDisable() && !TextUtils.isEmpty(au.Mj())) {
                return au.Mj();
            }
            if (aQI) {
                return aQv;
            }
            if (TextUtils.isEmpty(aQv) && context != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return aQv;
                }
                if (au.usePhoneStateDisable()) {
                    return aQv;
                }
                if (!o.Lo()) {
                    return aQv;
                }
                boolean z10 = false;
                try {
                    z10 = SystemUtil.cU(context);
                    if (z10) {
                        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        aQv = deviceId;
                        if (TextUtils.isEmpty(deviceId)) {
                            aQI = true;
                        }
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.e.c.printStackTrace(e2);
                    if (z10) {
                        aQI = true;
                    }
                }
                return aQv;
            }
            return aQv;
        }
    }

    public static synchronized String cZ(@Nullable Context context) {
        TelephonyManager telephonyManager;
        synchronized (bi.class) {
            if (aQN) {
                return aQw;
            }
            if (TextUtils.isEmpty(aQw) && context != null) {
                if (au.usePhoneStateDisable()) {
                    return aQw;
                }
                if (!o.Ln()) {
                    return aQE;
                }
                boolean z10 = false;
                try {
                    z10 = SystemUtil.cU(context);
                    if (z10 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            String meid = telephonyManager.getMeid();
                            aQw = meid;
                            if (TextUtils.isEmpty(meid)) {
                                aQN = true;
                            }
                        } else if (telephonyManager.getPhoneType() == 2) {
                            String deviceId = telephonyManager.getDeviceId();
                            aQw = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                aQN = true;
                            }
                        } else {
                            aQw = null;
                            aQN = true;
                        }
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.e.c.printStackTrace(e2);
                    if (z10) {
                        aQN = true;
                    }
                }
                return aQw;
            }
            return aQw;
        }
    }

    public static String cd(boolean z10) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String bc2 = com.kwad.sdk.core.f.a.bc(context);
        return (TextUtils.isEmpty(bc2) && !z10 && TextUtils.isEmpty(cY(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yF() : bc2;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static String cw(Context context) {
        if (TextUtils.isEmpty(aQE) && context != null && !aQL) {
            if (au.usePhoneStateDisable()) {
                return au.Ml();
            }
            if (!o.Li()) {
                return aQE;
            }
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                aQE = string;
                if (!gY(string)) {
                    aQE = "";
                }
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(aQE)) {
                aQL = true;
            }
            return aQE;
        }
        return aQE;
    }

    public static synchronized String[] da(@Nullable Context context) {
        synchronized (bi.class) {
            if (au.usePhoneStateDisable() && au.Mk() != null) {
                return au.Mk();
            }
            if (aQM) {
                return aQB;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                return aQB;
            }
            String[] strArr = aQB;
            boolean z10 = false;
            if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
                if (au.usePhoneStateDisable()) {
                    return strArr;
                }
                if (!o.Lo()) {
                    return strArr;
                }
                try {
                    boolean cU = SystemUtil.cU(context);
                    if (cU) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (i10 >= 26) {
                                    int min = Math.min(db(context), 2);
                                    for (int i11 = 0; i11 < min; i11++) {
                                        aQB[i11] = telephonyManager.getImei(i11);
                                    }
                                    String[] strArr2 = aQB;
                                    if (TextUtils.isEmpty(strArr2[0]) && TextUtils.isEmpty(strArr2[1])) {
                                        aQM = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 1) {
                                    if (i10 >= 23) {
                                        int min2 = Math.min(db(context), 2);
                                        for (int i12 = 0; i12 < min2; i12++) {
                                            aQB[i12] = telephonyManager.getDeviceId(i12);
                                        }
                                    } else {
                                        strArr[0] = telephonyManager.getDeviceId();
                                        strArr[1] = null;
                                    }
                                    String[] strArr3 = aQB;
                                    if (TextUtils.isEmpty(strArr3[0]) && TextUtils.isEmpty(strArr3[1])) {
                                        aQM = true;
                                    }
                                } else {
                                    strArr[0] = null;
                                    strArr[1] = null;
                                    aQM = true;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            z10 = cU;
                            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                            if (z10) {
                                aQM = true;
                            }
                            return aQB;
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                }
                return aQB;
            }
            return strArr;
        }
    }

    public static synchronized int db(Context context) {
        synchronized (bi.class) {
            if (!aQy && aQx <= 0 && Build.VERSION.SDK_INT >= 23 && context != null && !au.usePhoneStateDisable()) {
                try {
                    aQx = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                } catch (Exception unused) {
                }
                int i10 = aQx;
                aQy = i10 == 0;
                return i10;
            }
            return aQx;
        }
    }

    public static int dc(Context context) {
        if (context != null && aQz <= 0 && !aQA && SystemUtil.cU(context) && !au.usePhoneStateDisable()) {
            try {
                aQz = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
            } catch (Throwable unused) {
            }
            int i10 = aQz;
            aQA = i10 != 0;
            return i10;
        }
        return aQz;
    }

    public static String dd(Context context) {
        if (TextUtils.isEmpty(aQD) && context != null) {
            if (aQK) {
                return aQD;
            }
            if (au.usePhoneStateDisable()) {
                return aQD;
            }
            if (!o.Lq()) {
                return aQD;
            }
            try {
                if (SystemUtil.cU(context)) {
                    aQD = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
                aQD = null;
            }
            if (TextUtils.isEmpty(aQD)) {
                aQK = true;
            }
            String str = TextUtils.isEmpty(aQD) ? "" : aQD;
            aQD = str;
            return str;
        }
        return aQD;
    }

    public static synchronized int de(Context context) {
        int ringerMode;
        synchronized (bi.class) {
            try {
                ringerMode = ((AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO)).getRingerMode();
            } catch (Exception unused) {
                return -1;
            }
        }
        return ringerMode;
    }

    private static boolean df(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static synchronized String dg(@Nullable Context context) {
        synchronized (bi.class) {
            if (TextUtils.isEmpty(aQt) && context != null && !aQu) {
                if (au.Mm()) {
                    String Mn = au.Mn();
                    aQt = Mn;
                    return Mn;
                }
                if (!o.Lj()) {
                    return aQt;
                }
                try {
                    WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        aQt = connectionInfo.getMacAddress();
                    }
                    if (gW(aQt)) {
                        Iterator<E> iterator2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator2();
                        while (true) {
                            if (!iterator2.hasNext()) {
                                break;
                            }
                            NetworkInterface networkInterface = (NetworkInterface) iterator2.next();
                            if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                if (hardwareAddress != null && hardwareAddress.length != 0) {
                                    StringBuilder sb2 = new StringBuilder();
                                    for (byte b4 : hardwareAddress) {
                                        sb2.append(String.format("%02X:", Byte.valueOf(b4)));
                                    }
                                    if (sb2.length() > 0) {
                                        sb2.deleteCharAt(sb2.length() - 1);
                                    }
                                    aQt = sb2.toString();
                                }
                            }
                        }
                    }
                    if (gW(aQt)) {
                        aQt = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                    }
                    if (!gW(aQt)) {
                        aQt = aQt.toUpperCase(Locale.US);
                    }
                } catch (Exception unused) {
                    aQu = true;
                }
                aQu = gW(aQt);
                return aQt;
            }
            return aQt;
        }
    }

    @Nullable
    public static List<String> dh(@NonNull Context context) {
        String[] list;
        if (c.bF(context)) {
            return new ArrayList();
        }
        if (!di(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean di(@NonNull Context context) {
        return context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f36124j) == 0;
    }

    private static boolean gW(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    private static boolean gX(String str) {
        return aQT.contains(str.toLowerCase(Locale.US));
    }

    private static boolean gY(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            try {
                if (str.charAt(i10) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void gZ(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        y.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
        if (!TextUtils.isEmpty(aQF)) {
            return aQF;
        }
        String Nl = Nl();
        if (!TextUtils.isEmpty(Nl)) {
            String str = "ANDROID_" + Nl;
            aQF = str;
            return str;
        }
        String cw = cw(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(cw) && !gX(cw) && gY(cw)) {
            String str2 = "ANDROID_" + cw;
            aQF = str2;
            return str2;
        }
        String Nk = Nk();
        if (!TextUtils.isEmpty(Nk)) {
            aQF = "ANDROID_" + Nk;
            gZ(Nk);
            return aQF;
        }
        return "ANDROID_";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String ha(String str) {
        StructStat stat;
        String valueOf;
        if (TextUtils.isEmpty(aQR) && !TextUtils.isEmpty(str)) {
            int i10 = Build.VERSION.SDK_INT;
            try {
                stat = Os.stat(str);
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
            if (stat == null) {
                return aQR;
            }
            String str2 = "";
            if (i10 >= 27) {
                StructTimespec structTimespec = stat.st_atim;
                if (structTimespec == null) {
                    valueOf = "";
                } else {
                    str2 = String.valueOf(structTimespec.tv_sec);
                    valueOf = String.valueOf(stat.st_atim.tv_nsec);
                }
                aQR = str2 + "." + valueOf;
            } else {
                long j10 = stat.st_atime;
                if (j10 != 0) {
                    str2 = String.valueOf(j10);
                }
                aQR = str2;
            }
            return aQR;
        }
        return aQR;
    }

    public static String u(@Nullable Context context, boolean z10) {
        if (au.usePhoneStateDisable() && !TextUtils.isEmpty(au.Mj())) {
            return au.Mj();
        }
        String cY = cY(context);
        return (TextUtils.isEmpty(cY) && !z10 && TextUtils.isEmpty(com.kwad.sdk.core.f.a.bc(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yE() : cY;
    }
}
