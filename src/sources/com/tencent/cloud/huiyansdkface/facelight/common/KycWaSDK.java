package com.tencent.cloud.huiyansdkface.facelight.common;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.analytics.WBSimpleAnalyticsService;
import com.tencent.cloud.huiyansdkface.analytics.WBSimpleStartParam;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KycWaSDK {

    /* renamed from: a, reason: collision with root package name */
    private static WBSimpleAnalyticsService f40685a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile KycWaSDK f40686b;

    static {
        WBSimpleAnalyticsService wBSimpleAnalyticsService = new WBSimpleAnalyticsService();
        f40685a = wBSimpleAnalyticsService;
        wBSimpleAnalyticsService.init("M188386620", "https://kycwa.tencentcloudapi.com/rcrm-codcs/mob-data-collect");
    }

    private KycWaSDK() {
    }

    public static KycWaSDK getInstance() {
        if (f40686b == null) {
            synchronized (KycWaSDK.class) {
                if (f40686b == null) {
                    f40686b = new KycWaSDK();
                }
            }
        }
        return f40686b;
    }

    public boolean startStatService(Context context, WBSimpleStartParam wBSimpleStartParam) {
        return f40685a.startStatService(context, wBSimpleStartParam);
    }

    public void trackCustomKVEvent(Context context, String str, String str2, Properties properties) {
        f40685a.trackCustomKVEvent(context, str, str2, properties);
    }

    public void trackIMSWarnVEvent(Context context, String str, String str2, Properties properties) {
        f40685a.trackIMSWarnVEvent(context, str, str2, properties);
    }

    public void updateEcifNo(String str) {
        f40685a.updateEcifNo(str);
    }

    public void updateEnableWBAService(boolean z10) {
        f40685a.updateEnableWBAService(z10);
    }

    public void updateFiled_y(String str, String str2) {
        f40685a.updateFieldValue(str, str2);
    }

    public void updateOpenId(String str) {
        f40685a.updateOpenId(str);
    }

    public void updateUnionId(String str) {
        f40685a.updateUnionId(str);
    }
}
