package com.huawei.appgallery.agd.core.impl.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.serverreq.BuildConfig;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.openalliance.ad.constant.u;
import java.util.LinkedHashMap;
import n9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HiAnalysisUtil {

    /* renamed from: a, reason: collision with root package name */
    public static HiAnalyticsInstance f27430a;

    public static String a() {
        Context context;
        String mediaPkgName = AgdAdManager.getConfig() != null ? AgdAdManager.getConfig().getMediaPkgName() : "";
        return (ApplicationWrapper.getInstance() == null || !TextUtils.isEmpty(mediaPkgName) || (context = ApplicationWrapper.getInstance().getContext()) == null) ? mediaPkgName : context.getPackageName();
    }

    public static void init(Context context, String str, String str2, boolean z10) {
        HiAnalyticsInstance hiAnalyticsInstance;
        a aVar = a.f52175d;
        aVar.d("HiAnalysisUtil", "Bi test url: " + str);
        if (TextUtils.isEmpty(str)) {
            aVar.e("HiAnalysisUtil", "initConfig, url is null !");
            return;
        }
        if (z10) {
            HiAnalyticTools.enableLog(context);
        }
        HiAnalyticsConfig.Builder collectURL = new HiAnalyticsConfig.Builder().setCollectURL(str);
        aVar.w("HiAnalysisUtil", "udid is null " + TextUtils.isEmpty(str2));
        if (!TextUtils.isEmpty(str2)) {
            collectURL.setUdid(str2);
        }
        HiAnalyticsConfig build = collectURL.build();
        HiAnalyticsInstance.Builder operConf = new HiAnalyticsInstance.Builder(context).setMaintConf(build).setOperConf(build);
        boolean initFlag = HiAnalyticsManager.getInitFlag("AGD_HA_TAG");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HiAnalytics InitFlag :");
        sb2.append(initFlag);
        sb2.append(" hiAnalyticsInstance is null ");
        sb2.append(f27430a == null);
        aVar.d("HiAnalysisUtil", sb2.toString());
        if (initFlag && (hiAnalyticsInstance = f27430a) != null) {
            hiAnalyticsInstance.refresh(0, build);
            f27430a.refresh(1, build);
        } else {
            HiAnalyticsInstance create = operConf.create("AGD_HA_TAG");
            f27430a = create;
            create.setAppid(u.W);
        }
    }

    public static void onEvent(int i10, @NonNull String str, @NonNull LinkedHashMap<String, String> linkedHashMap) {
        HiAnalyticsInstance hiAnalyticsInstance;
        linkedHashMap.put("mediaPkg", a());
        linkedHashMap.put(MaintKey.CLIENT_VERSION, String.valueOf(BuildConfig.VERSION_CODE));
        FlavorApi.getConfig().biLog(i10, str, linkedHashMap);
        if (!HiAnalyticsManager.getInitFlag("AGD_HA_TAG") || (hiAnalyticsInstance = f27430a) == null) {
            return;
        }
        hiAnalyticsInstance.onEvent(i10, str, linkedHashMap);
    }
}
