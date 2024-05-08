package com.android.internal.os;

import android.os.SystemProperties;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ZygoteConfig {
    public static final String PROPERTY_PREFIX_DEVICE_CONFIG = "persist.device_config";
    public static final String PROPERTY_PREFIX_SYSTEM = "dalvik.vm.";
    public static final String USAP_POOL_ENABLED = "usap_pool_enabled";
    public static final boolean USAP_POOL_ENABLED_DEFAULT = false;
    public static final String USAP_POOL_REFILL_DELAY_MS = "usap_pool_refill_delay_ms";
    public static final int USAP_POOL_REFILL_DELAY_MS_DEFAULT = 1000;
    public static final String USAP_POOL_REFILL_THRESHOLD = "usap_refill_threshold";
    public static final int USAP_POOL_REFILL_THRESHOLD_DEFAULT = 1;
    public static final String USAP_POOL_SIZE_MAX = "usap_pool_size_max";
    public static final int USAP_POOL_SIZE_MAX_DEFAULT = 2;
    public static final int USAP_POOL_SIZE_MAX_LIMIT = 100;
    public static final String USAP_POOL_SIZE_MIN = "usap_pool_size_min";
    public static final int USAP_POOL_SIZE_MIN_DEFAULT = 1;
    public static final int USAP_POOL_SIZE_MIN_LIMIT = 1;

    private static String getDeviceConfig(String name) {
        return SystemProperties.get(String.join(".", PROPERTY_PREFIX_DEVICE_CONFIG, "runtime_native", name));
    }

    public static int getInt(String name, int defaultValue) {
        String propString = getDeviceConfig(name);
        if (!propString.isEmpty()) {
            return Integer.parseInt(propString);
        }
        return SystemProperties.getInt(PROPERTY_PREFIX_SYSTEM + name, defaultValue);
    }

    public static boolean getBool(String name, boolean defaultValue) {
        String propString = getDeviceConfig(name);
        if (!propString.isEmpty()) {
            return Boolean.parseBoolean(propString);
        }
        return SystemProperties.getBoolean(PROPERTY_PREFIX_SYSTEM + name, defaultValue);
    }
}
