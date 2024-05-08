package com.huawei.quickcard.base.grs;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.quickcard.base.log.CardLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardServer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33339a = "QuickCardServer";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33340b = "BIROOTV2";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33341c = "STORE";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33342d = "AGCSERVER";

    /* renamed from: e, reason: collision with root package name */
    private static final String f33343e = "com.huawei.cloud.quickcard";

    public static String getAgcUri(@NonNull Context context) {
        try {
            GrsClient grsClient = CardGrsClientHelper.getGrsClient(context);
            return grsClient != null ? grsClient.synGetGrsUrl(f33343e, f33342d) : "";
        } catch (Throwable th) {
            CardLogUtils.e(f33339a, "getStoreUri no grs sdk found: " + th.getMessage());
            return "";
        }
    }

    public static String getReportUri(@NonNull Context context) {
        try {
            String hAUrl = CardServerConfig.getHAUrl();
            if (!TextUtils.isEmpty(hAUrl)) {
                return hAUrl;
            }
            GrsClient grsClient = CardGrsClientHelper.getGrsClient(context);
            return grsClient != null ? grsClient.synGetGrsUrl(f33343e, f33340b) : "";
        } catch (Throwable th) {
            CardLogUtils.e(f33339a, "getReportUri no grs sdk found: " + th.getMessage());
            return "";
        }
    }

    public static String getStoreUri(@NonNull Context context) {
        try {
            GrsClient grsClient = CardGrsClientHelper.getGrsClient(context);
            return grsClient != null ? grsClient.synGetGrsUrl(f33343e, "STORE") : "";
        } catch (Throwable th) {
            CardLogUtils.e(f33339a, "getStoreUri no grs sdk found: " + th.getMessage());
            return "";
        }
    }
}
