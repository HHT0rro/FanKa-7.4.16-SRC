package com.tencent.liteav.base.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Debug;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.t;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LiteavSystemInfo {
    private static final int APP_SYSTEM_METHOD_DEFAULT_GET_INTERVAL_MS = 1000;
    private static final String EXT_KEY_APP_BACKGROUND = "isAppBackground";
    private static final String EXT_KEY_APP_NAME = "appName";
    private static final String EXT_KEY_APP_PACKAGE_NAME = "appPackageName";
    private static final String EXT_KEY_APP_VERSION = "appVersion";
    private static final String EXT_KEY_BUILD_BOARD = "buildBoard";
    private static final String EXT_KEY_BUILD_BRAND = "buildBrand";
    private static final String EXT_KEY_BUILD_HARDWARE = "buildHardware";
    private static final String EXT_KEY_BUILD_MANUFACTURER = "buildManufacturer";
    private static final String EXT_KEY_BUILD_MODEL = "buildModel";
    private static final String EXT_KEY_BUILD_VERSION = "buildVersion";
    private static final String EXT_KEY_BUILD_VERSION_INT = "buildVersionInt";
    private static final int GET_APP_MEMORY_INTERVAL_MS = 15000;
    private static final int NETWORK_TYPE_2G = 4;
    private static final int NETWORK_TYPE_3G = 3;
    private static final int NETWORK_TYPE_4G = 2;
    private static final int NETWORK_TYPE_5G = 6;
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = 1;
    private static final int NETWORK_TYPE_WIRED = 5;
    private static final String TAG = "LiteavBaseSystemInfo";
    private static final t<String> sModel = new t<>(g.a());
    private static final t<String> sBrand = new t<>(h.a());
    private static final t<String> sManufacturer = new t<>(i.a());
    private static final t<String> sHardware = new t<>(j.a());
    private static final t<String> sSystemOSVersion = new t<>(k.a());
    private static final t<Integer> sSystemOSVersionInt = new t<>(l.a());
    private static final t<String> sBoard = new t<>(m.a());
    private static final t<String> sAppPackageName = new t<>(n.a());
    private static final t<String> sAppName = new t<>(d.a());
    private static final t<String> sAppVersion = new t<>(e.a());
    private static final t<String> sUUID = new t<>(f.a());
    private static AtomicBoolean sIsGettingMemoryUsage = new AtomicBoolean(false);
    private static AtomicInteger sLastMemoryUsage = new AtomicInteger(0);
    private static final com.tencent.liteav.base.b.a sMemoryUsageThrottler = new com.tencent.liteav.base.b.a(15000);
    private static int sLastNetworkType = 0;
    private static final com.tencent.liteav.base.b.a sNetworkTypeThrottler = new com.tencent.liteav.base.b.a(1000);
    private static int sLastGateway = 0;
    private static final com.tencent.liteav.base.b.a sGatewayThrottler = new com.tencent.liteav.base.b.a(1000);
    private static boolean sLastMicPermission = false;
    private static final com.tencent.liteav.base.b.a sMicPermissionThrottler = new com.tencent.liteav.base.b.a(1000);

    @CalledByNative
    public static synchronized int getAppBackgroundState() {
        int i10;
        synchronized (LiteavSystemInfo.class) {
            i10 = com.tencent.liteav.base.util.j.a().b() ? 1 : 0;
        }
        return i10;
    }

    @CalledByNative
    public static synchronized int getAppMemoryUsage() {
        int i10;
        synchronized (LiteavSystemInfo.class) {
            if (sMemoryUsageThrottler.a()) {
                getAppMemoryUsageFromSystem();
            }
            i10 = sLastMemoryUsage.get();
        }
        return i10;
    }

    private static void getAppMemoryUsageFromSystem() {
        if (sIsGettingMemoryUsage.get()) {
            return;
        }
        sIsGettingMemoryUsage.set(true);
        AsyncTask.execute(c.a());
    }

    @CalledByNative
    public static String getAppName() {
        return sAppName.a();
    }

    @CalledByNative
    public static String getAppPackageName() {
        return sAppPackageName.a();
    }

    @CalledByNative
    public static String getAppVersion() {
        return sAppVersion.a();
    }

    @CalledByNative
    public static synchronized boolean getAudioRecordPermission() {
        boolean z10;
        synchronized (LiteavSystemInfo.class) {
            if (sMicPermissionThrottler.a()) {
                sLastMicPermission = getAudioRecordPermissionFromSystem();
            }
            z10 = sLastMicPermission;
        }
        return z10;
    }

    private static boolean getAudioRecordPermissionFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        return applicationContext != null && applicationContext.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0;
    }

    public static String getBoard() {
        return sBoard.a();
    }

    public static String getBrand() {
        return sBrand.a();
    }

    @CalledByNative
    public static String getDeviceUuid() {
        return sUUID.a();
    }

    @CalledByNative
    public static synchronized int getGateway() {
        int i10;
        synchronized (LiteavSystemInfo.class) {
            if (sGatewayThrottler.a()) {
                sLastGateway = getGatewayFromSystem();
            }
            i10 = sLastGateway;
        }
        return i10;
    }

    private static int getGatewayFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        try {
            return ((WifiManager) applicationContext.getSystemService("wifi")).getDhcpInfo().gateway;
        } catch (Throwable th) {
            Log.e(TAG, "getGateway error " + th.getMessage(), new Object[0]);
            return 0;
        }
    }

    public static String getHardware() {
        return sHardware.a();
    }

    @CalledByNative
    public static String getManufacturer() {
        return sManufacturer.a();
    }

    @CalledByNative
    public static String getModel() {
        return sModel.a();
    }

    @CalledByNative
    public static synchronized int getNetworkType() {
        int i10;
        synchronized (LiteavSystemInfo.class) {
            if (sNetworkTypeThrottler.a()) {
                sLastNetworkType = getNetworkTypeFromSystem();
            }
            i10 = sLastNetworkType;
        }
        return i10;
    }

    private static int getNetworkTypeFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        NetworkInfo networkInfo = null;
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            Log.e(TAG, "getNetworkType error occurred.", e2);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return 0;
        }
        if (networkInfo.getType() == 9) {
            return 5;
        }
        if (networkInfo.getType() == 1) {
            return 1;
        }
        if (networkInfo.getType() != 0) {
            return 0;
        }
        try {
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 4;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 2;
                default:
                    return (getSystemOSVersionInt() < 29 || networkType != 20) ? 2 : 6;
            }
        } catch (Exception e10) {
            Log.e(TAG, "getNetworkType error occurred.", e10);
            return 2;
        }
        Log.e(TAG, "getNetworkType error occurred.", e10);
        return 2;
    }

    @CalledByNative
    public static String getSystemOSVersion() {
        return sSystemOSVersion.a();
    }

    @CalledByNative
    public static int getSystemOSVersionInt() {
        return sSystemOSVersionInt.a().intValue();
    }

    public static /* synthetic */ void lambda$getAppMemoryUsageFromSystem$8() {
        int i10;
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            i10 = memoryInfo.getTotalPss();
        } catch (Exception e2) {
            Log.e(TAG, "Get App memory usage failed." + e2.getMessage(), new Object[0]);
            i10 = 0;
        }
        sLastMemoryUsage.set(i10 / 1024);
        sIsGettingMemoryUsage.set(false);
    }

    @CalledByNative
    public static void setAppDisplayRotation(int i10) {
        com.tencent.liteav.base.util.j.a().a(Rotation.a(i10));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x009e. Please report as an issue. */
    public static boolean setExtID(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str.hashCode();
            char c4 = 65535;
            switch (str.hashCode()) {
                case -1978299099:
                    if (str.equals(EXT_KEY_APP_BACKGROUND)) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -911706486:
                    if (str.equals(EXT_KEY_BUILD_VERSION)) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -794136500:
                    if (str.equals("appName")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -589756065:
                    if (str.equals(EXT_KEY_BUILD_MANUFACTURER)) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -497349352:
                    if (str.equals(EXT_KEY_BUILD_BOARD)) {
                        c4 = 4;
                        break;
                    }
                    break;
                case -497260103:
                    if (str.equals(EXT_KEY_BUILD_BRAND)) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -487188133:
                    if (str.equals(EXT_KEY_BUILD_MODEL)) {
                        c4 = 6;
                        break;
                    }
                    break;
                case -441921776:
                    if (str.equals("appPackageName")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case -391134602:
                    if (str.equals(EXT_KEY_BUILD_HARDWARE)) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case 725329157:
                    if (str.equals(EXT_KEY_BUILD_VERSION_INT)) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case 1484112759:
                    if (str.equals("appVersion")) {
                        c4 = '\n';
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    try {
                        com.tencent.liteav.base.util.j.a(Integer.parseInt(str2) == 1);
                        return true;
                    } catch (Exception e2) {
                        Log.e(TAG, "set app background state failed. ".concat(String.valueOf(e2)), new Object[0]);
                        break;
                    }
                case 1:
                    sSystemOSVersion.a(str2);
                    return true;
                case 2:
                    sAppName.a(str2);
                    return true;
                case 3:
                    sManufacturer.a(str2);
                    return true;
                case 4:
                    sBoard.a(str2);
                    return true;
                case 5:
                    sBrand.a(str2);
                    return true;
                case 6:
                    sModel.a(str2);
                    return true;
                case 7:
                    sAppPackageName.a(str2);
                    return true;
                case '\b':
                    sHardware.a(str2);
                    return true;
                case '\t':
                    try {
                        sSystemOSVersionInt.a(Integer.valueOf(Integer.parseInt(str2)));
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    return true;
                case '\n':
                    sAppVersion.a(str2);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }
}
