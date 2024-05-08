package com.huawei.quickcard.base.bi;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.quickcard.base.grs.QuickCardServer;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.CardServerUtil;
import com.huawei.quickcard.base.utils.QuickCardPlatformUtils;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardReportHelper {
    public static final int CONFIG_TYPE_MAIN = 1;
    public static final String SERVICE_TAG = "quickCard";

    /* renamed from: a, reason: collision with root package name */
    private static final String f33305a = "CardReportHelper";

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f33306b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f33307c = false;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f33308d = true;

    /* renamed from: e, reason: collision with root package name */
    private static final LinkedHashSet<LazyReportBean> f33309e = new LinkedHashSet<>(1);

    private static void a(Context context) {
        if (context == null) {
            f33306b = true;
            f33307c = false;
            CardLogUtils.e(f33305a, "init HA SDK failed ctx is null");
            return;
        }
        String reportUri = QuickCardServer.getReportUri(context);
        if (TextUtils.isEmpty(reportUri)) {
            f33306b = true;
            f33307c = false;
            CardLogUtils.e(f33305a, "initSDK: get url from grs fail");
            return;
        }
        try {
            new HiAnalyticsInstance.Builder(context).setMaintConf(new HiAnalyticsConfig.Builder().setCollectURL(reportUri).build()).create("quickCard").setAppid(QuickCardPlatformUtils.getLibraryId());
            f33306b = true;
            f33307c = true;
        } catch (Throwable unused) {
            f33306b = true;
            f33307c = false;
            CardLogUtils.e(f33305a, "HA SDK not found");
        }
    }

    public static synchronized void clearLazyData() {
        synchronized (CardReportHelper.class) {
            f33309e.clear();
        }
    }

    public static synchronized LinkedHashSet<LazyReportBean> getLazyReportData() {
        LinkedHashSet<LazyReportBean> linkedHashSet;
        synchronized (CardReportHelper.class) {
            linkedHashSet = f33309e;
        }
        return linkedHashSet;
    }

    public static void onEvent(Context context, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (CardServerUtil.isNetworkAccess()) {
            if (!f33308d) {
                CardLogUtils.i(f33305a, "not allow report");
                return;
            }
            if (!f33306b) {
                a(context);
            }
            if (f33306b && f33307c) {
                HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("quickCard");
                if (instanceByTag == null) {
                    CardLogUtils.e(f33305a, "onEvent: instance is empty");
                    return;
                }
                instanceByTag.onEvent(1, str, linkedHashMap);
                CardLogUtils.d(f33305a, "eventId: " + str + " mapValue:" + ((Object) linkedHashMap));
                return;
            }
            CardLogUtils.d(f33305a, "onEvent: HA sdk init fail");
        }
    }

    public static synchronized void putLazyReportData(LazyReportBean lazyReportBean) {
        synchronized (CardReportHelper.class) {
            f33309e.add(lazyReportBean);
        }
    }

    public static void setAllowReport(boolean z10) {
        f33308d = z10;
    }
}
