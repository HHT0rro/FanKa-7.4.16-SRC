package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.data.ConfigManager;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {
    public static com.huawei.hianalytics.framework.data.a a(String str) {
        return ConfigManager.getInstance().getHAFrameworkConfigInfo(str);
    }

    public static ICollectorConfig b(String str) {
        return ConfigManager.getInstance().getConfig(str);
    }

    public static IStorageHandler c(String str) {
        com.huawei.hianalytics.framework.data.a a10 = a(str);
        if (a10 != null) {
            return a10.a();
        }
        return null;
    }

    public static IStoragePolicy d(String str) {
        return ConfigManager.getInstance().getPolicy(str);
    }
}
