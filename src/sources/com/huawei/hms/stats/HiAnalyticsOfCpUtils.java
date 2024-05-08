package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HiAnalyticsOfCpUtils {

    /* renamed from: a, reason: collision with root package name */
    private static HiAnalyticsInstance f31805a;

    private static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f31805a = analyticsInstance;
        return analyticsInstance;
    }

    public static void onEvent(Context context, String str, String str2) {
        if (a(context) != null) {
            f31805a.onEvent(context, str, str2);
        }
    }

    public static void onReport(Context context, int i10) {
        if (a(context) != null) {
            f31805a.onReport(i10);
        }
    }

    public static void onStreamEvent(Context context, int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f31805a.onStreamEvent(i10, str, linkedHashMap);
        }
    }

    public static void onEvent(Context context, int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f31805a.onEvent(i10, str, linkedHashMap);
        }
    }
}
