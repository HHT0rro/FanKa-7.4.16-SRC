package com.huawei.hianalytics.v2;

import android.content.Context;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.l0;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import java.util.LinkedHashMap;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class HiAnalytics {
    public static final String TAG = LogTag.get(HiAnalytics.class, new Class[0]);
    public static HiAnalyticsInstance defaultInstance = null;

    public static void clearCachedData() {
        HiAnalyticsManager.clearCachedData();
    }

    public static synchronized HiAnalyticsInstance getDefaultInstance() {
        HiAnalyticsInstance hiAnalyticsInstance;
        synchronized (HiAnalytics.class) {
            if (defaultInstance == null) {
                defaultInstance = HiAnalyticsManager.getInstanceByTag("_default_config_tag");
            }
            hiAnalyticsInstance = defaultInstance;
        }
        return hiAnalyticsInstance;
    }

    public static boolean getInitFlag() {
        return HiAnalyticsManager.getInitFlag("_default_config_tag");
    }

    @Deprecated
    public static void handleV1Cache() {
        HiLog.w(TAG, " handleV1Cache is Deprecated...");
    }

    public static void newInstanceUUID() {
        if (getDefaultInstance() != null) {
            defaultInstance.newInstanceUUID();
        }
    }

    public static void onBackground(long j10) {
        if (getDefaultInstance() != null) {
            defaultInstance.onBackground(j10);
        }
    }

    @Deprecated
    public static void onEvent(Context context, String str, String str2) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onEvent(context, str, str2);
    }

    public static void onForeground(long j10) {
        if (getDefaultInstance() != null) {
            defaultInstance.onForeground(j10);
        }
    }

    public static void onPause(Context context) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onPause(context);
    }

    public static void onReport() {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onReport(-1);
    }

    public static void onResume(Context context) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onResume(context);
    }

    public static void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onStreamEvent(i10, str, linkedHashMap);
    }

    public static void setIsOaidTracking(boolean z10) {
        if (getDefaultInstance() != null) {
            defaultInstance.setOAIDTrackingFlag(1, z10);
            defaultInstance.setOAIDTrackingFlag(0, z10);
            defaultInstance.setOAIDTrackingFlag(3, z10);
            defaultInstance.setOAIDTrackingFlag(2, z10);
        }
    }

    public static void setOAID(String str) {
        if (getDefaultInstance() != null) {
            defaultInstance.setOAID(1, str);
            defaultInstance.setOAID(0, str);
            defaultInstance.setOAID(3, str);
            defaultInstance.setOAID(2, str);
        }
    }

    public static void setUPID(String str) {
        if (getDefaultInstance() != null) {
            defaultInstance.setUpid(1, str);
            defaultInstance.setUpid(0, str);
            defaultInstance.setUpid(3, str);
            defaultInstance.setUpid(2, str);
        }
    }

    public static void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onEvent(i10, str, linkedHashMap);
    }

    public static void onPause(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onPause(context, linkedHashMap);
    }

    @Deprecated
    public static void onReport(Context context) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onReport(context, -1);
    }

    public static void onResume(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onResume(context, linkedHashMap);
    }

    public static void onEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onEvent(0, str, linkedHashMap);
    }

    public static void onPause(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onPause(str, linkedHashMap);
    }

    public static void onResume(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !l0.ijk.lmn()) {
            return;
        }
        defaultInstance.onResume(str, linkedHashMap);
    }
}
