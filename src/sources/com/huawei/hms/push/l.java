package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.ad.constant.as;
import com.vivo.push.PushClientConstants;

/* compiled from: PushAnalyticsUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f30419a = "l";

    public static void a(Context context, String str, String str2, String str3) {
        PushBaseAnalytics pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushAnalytics == null) {
            return;
        }
        Bundle a10 = a(context, str, str2);
        HMSLog.i(f30419a, "eventId:" + str3);
        pushAnalytics.report(context, str3, a10);
    }

    private static Bundle a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(as.aJ, String.valueOf(61200300));
        bundle.putString(PushClientConstants.TAG_PKG_NAME, context.getPackageName());
        bundle.putString("aaid", HmsInstanceId.getInstance(context).getId());
        PushProxy proxy = ProxyCenter.getProxy();
        if (proxy != null) {
            bundle.putString("proxyType", proxy.getProxyType());
        }
        bundle.putString(RemoteMessageConst.MSGID, str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(RemoteMessageConst.ANALYTIC_INFO, str2);
        }
        return bundle;
    }

    public static void a(Context context, Bundle bundle, String str) {
        PushBaseAnalytics pushAnalytics;
        if (bundle == null || (pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics()) == null) {
            return;
        }
        bundle.putString("sdk_version", String.valueOf(61200300));
        HMSLog.i(f30419a, "eventId:" + str);
        pushAnalytics.report(context, str, bundle);
    }
}
