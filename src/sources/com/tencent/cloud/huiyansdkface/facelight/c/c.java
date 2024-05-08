package com.tencent.cloud.huiyansdkface.facelight.c;

import com.tencent.cloud.huiyansdkface.facelight.net.tools.HttpEventListener;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private WeOkHttp f40646a;

    private static String a(String str, String str2, boolean z10) {
        return str;
    }

    public static String a(boolean z10, boolean z11, boolean z12) {
        WLogger.d("HttpManager", "configBaseUrl");
        if (!z12) {
            return z11 ? a("https://idasc-kyc.tencentcloudapi.com", "https://idasc-kyc-test.tencentcloudapi.com", z10) : a("https://miniprogram-kyc.tencentcloudapi.com", "https://miniprogram-kyc-test.tencentcloudapi.com", z10);
        }
        WLogger.d("HttpManager", "retry,updatePlanBUrl");
        return z11 ? a("https://miniprogram-kyc.tencentcloudapi.com", "https://miniprogram-kyc-test.tencentcloudapi.com", z10) : a("https://idasc-kyc.tencentcloudapi.com", "https://idasc-kyc-test.tencentcloudapi.com", z10);
    }

    public WeOkHttp a() {
        WeOkHttp weOkHttp = this.f40646a;
        if (weOkHttp != null) {
            return weOkHttp;
        }
        WeOkHttp a10 = a(false);
        b(false, false, false);
        return a10;
    }

    public WeOkHttp a(boolean z10) {
        this.f40646a = new WeOkHttp();
        this.f40646a.config().timeout(14L, 14L, 14L).log(new WeLog.Builder().setLevel(z10 ? WeLog.Level.BODY : WeLog.Level.NONE).setPrettyLog(true).setCutLongStr(true).setLogger(new WeLog.Logger() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.c.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.Logger
            public void log(String str) {
                WLogger.d("WeHttp", str);
            }
        }).setLogWithTag(true)).cookieMemory().baseUrl("https://miniprogram-kyc.tencentcloudapi.com").supportTls12Before5(true).clientConfig().eventListenerFactory(HttpEventListener.FACTORY);
        return this.f40646a;
    }

    public void b(boolean z10, boolean z11, boolean z12) {
        String a10 = a(z10, z11, z12);
        WLogger.d("HttpManager", "baseUrl=" + a10);
        this.f40646a.config().baseUrl(a10);
    }
}
