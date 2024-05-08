package com.huawei.flexiblelayout;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.analytics.Record;
import com.huawei.flexiblelayout.services.configuration.ConfigurationService;
import com.huawei.flexiblelayout.services.configuration.ServerUrlProvider;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;

/* compiled from: HiAnalyticsWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j1 {

    /* renamed from: d, reason: collision with root package name */
    private static final String f28158d = "HiAnalyticsWrapper";

    /* renamed from: e, reason: collision with root package name */
    private static final String f28159e = "FlexibleLayout";

    /* renamed from: f, reason: collision with root package name */
    private static final String f28160f = "com.huawei.flexiblelayout";

    /* renamed from: g, reason: collision with root package name */
    private static final int f28161g = 1;

    /* renamed from: a, reason: collision with root package name */
    private final Context f28162a;

    /* renamed from: b, reason: collision with root package name */
    private String f28163b;

    /* renamed from: c, reason: collision with root package name */
    private HiAnalyticsInstance f28164c;

    public j1(@NonNull Context context) {
        this.f28162a = context.getApplicationContext();
    }

    public void a(@NonNull Record record) {
        ServerUrlProvider serverUrlProvider;
        if (TextUtils.isEmpty(record.mEvent) || record.mParams == null || (serverUrlProvider = ((ConfigurationService) FLEngine.getInstance(this.f28162a).getService(ConfigurationService.class)).getServerUrlProvider(ConfigurationService.Alias.HI_ANALYTICS)) == null) {
            return;
        }
        a(serverUrlProvider.getUrl());
        HiAnalyticsInstance hiAnalyticsInstance = this.f28164c;
        if (hiAnalyticsInstance != null) {
            hiAnalyticsInstance.onEvent(1, record.mEvent, record.mParams);
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f28158d, "initHiAnalyticsIf, Empty serverUri.");
            return;
        }
        if (str.equals(this.f28163b)) {
            return;
        }
        this.f28163b = str;
        HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setCollectURL(str).setEnableUUID(true).setAutoReportThresholdSize(100).build();
        HiAnalyticsInstance create = new HiAnalyticsInstance.Builder(this.f28162a).setMaintConf(build).create(f28159e);
        this.f28164c = create;
        if (create == null) {
            this.f28164c = HiAnalyticsManager.getInstanceByTag(f28159e);
        }
        HiAnalyticsInstance hiAnalyticsInstance = this.f28164c;
        if (hiAnalyticsInstance != null) {
            hiAnalyticsInstance.refresh(1, build);
            this.f28164c.setAppid("com.huawei.flexiblelayout");
        }
    }
}
