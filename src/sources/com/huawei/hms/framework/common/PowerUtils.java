package com.huawei.hms.framework.common;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;
import com.kuaishou.weapon.p0.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PowerUtils {
    private static final String TAG = "PowerUtils";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class PowerMode {
        public static final int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        public static final int POWER_SAVER_MODE = 4;
        public static final String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isAppIdleMode(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            int i10 = Build.VERSION.SDK_INT;
            Object systemService = context.getSystemService("usagestats");
            if (systemService instanceof UsageStatsManager) {
                UsageStatsManager usageStatsManager = (UsageStatsManager) systemService;
                if (usageStatsManager != null) {
                    if (i10 >= 23) {
                        return usageStatsManager.isAppInactive(packageName);
                    }
                    return false;
                }
                Logger.i(TAG, "isAppIdleMode statsManager is null!");
            }
            return false;
        }
        Logger.i(TAG, "isAppIdleMode Context is null!");
        return false;
    }

    public static boolean isDozeIdleMode(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            if (powerManager != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        return powerManager.isDeviceIdleMode();
                    } catch (RuntimeException e2) {
                        Logger.e(TAG, "dealType rethrowFromSystemServer:", e2);
                        return false;
                    }
                }
                Logger.i(TAG, "isDozeIdleMode is version control state!");
                return false;
            }
            Logger.i(TAG, "isDozeIdleMode powerManager is null!");
            return false;
        }
        Logger.i(TAG, "isDozeIdleMode Context is null!");
        return false;
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                try {
                    return ((PowerManager) systemService).isInteractive();
                } catch (RuntimeException e2) {
                    Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e2.getClass().getSimpleName() + e2.getMessage());
                }
            }
        }
        return false;
    }

    public static boolean isWhilteList(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            String packageName = context.getPackageName();
            if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
                try {
                    return powerManager.isIgnoringBatteryOptimizations(packageName);
                } catch (RuntimeException e2) {
                    Logger.e(TAG, "dealType rethrowFromSystemServer:", e2);
                }
            }
        }
        return false;
    }

    public static int readDataSaverMode(Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                int i10 = Build.VERSION.SDK_INT;
                if (ContextCompat.checkSelfPermission(context, g.f36116b)) {
                    return 0;
                }
                if (!connectivityManager.isActiveNetworkMetered()) {
                    Logger.v(TAG, "ConnectType is not Mobile Network!");
                    return 0;
                }
                if (i10 >= 24) {
                    return connectivityManager.getRestrictBackgroundStatus();
                }
                return 0;
            }
            Logger.i(TAG, "readDataSaverMode Context is null!");
            return 0;
        }
        Logger.i(TAG, "readDataSaverMode manager is null!");
        return 0;
    }

    public static int readPowerSaverMode(Context context) {
        if (context != null) {
            int systemInt = SettingUtil.getSystemInt(context.getContentResolver(), PowerMode.SMART_MODE_STATUS, 0);
            if (systemInt == 0) {
                Object systemService = ContextCompat.getSystemService(context, "power");
                PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
                if (powerManager != null) {
                    try {
                        return powerManager.isPowerSaveMode() ? 4 : 0;
                    } catch (RuntimeException e2) {
                        Logger.e(TAG, "dealType rethrowFromSystemServer:", e2);
                    }
                }
            }
            return systemInt;
        }
        Logger.i(TAG, "readPowerSaverMode Context is null!");
        return 0;
    }
}
