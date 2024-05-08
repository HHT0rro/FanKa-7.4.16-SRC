package com.huawei.hianalytics.process;

import android.content.Context;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.data.HiAnalyticsDataManager;
import com.huawei.hianalytics.log.LogTag;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HiAnalyticsManager {
    public static final String TAG = LogTag.get(HiAnalyticsManager.class, new Class[0]);

    public static void clearCachedData() {
        HiAnalyticsDataManager.getInstance().clearCachedData();
    }

    public static String createUUID(Context context) {
        return HiAnalyticsDataManager.getInstance().createUUID(context);
    }

    public static List<String> getAllTags() {
        return HiAnalyticsDataManager.getInstance().getAllTags();
    }

    public static boolean getInitFlag(String str) {
        return HiAnalyticsDataManager.getInstance().getInitFlag(str);
    }

    public static HiAnalyticsInstance getInstanceByTag(String str) {
        return HiAnalyticsDataManager.getInstance().getInstanceByTag(str);
    }

    public static HiAnalyticsInstanceEx getInstanceEx() {
        return HiAnalyticsDataManager.getInstance().getInstanceEx();
    }

    @Deprecated
    public static void openAegisRandom(boolean z10) {
        HiLog.sw(TAG, "HiAnalyticsManager.openAegisRandom is Deprecated");
    }

    public static void setAppid(String str) {
        HiAnalyticsDataManager.getInstance().setAppid(str);
    }

    public static void setCacheSize(int i10) {
        HiAnalyticsDataManager.getInstance().setSPCacheSize(i10);
    }

    public static void setCustomPkgName(String str) {
        HiAnalyticsDataManager.getInstance().setCustomPkgName(str);
    }

    @Deprecated
    public static void setUnusualDataIgnored(boolean z10) {
        HiAnalyticsDataManager.getInstance().setUnusualDataIgnored(z10);
    }
}
