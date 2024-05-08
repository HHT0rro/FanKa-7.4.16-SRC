package com.tencent.cloud.huiyansdkface.analytics;

import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f40457b;

    /* renamed from: a, reason: collision with root package name */
    public WeOkHttp f40458a;

    private b() {
        WeOkHttp weOkHttp = new WeOkHttp();
        this.f40458a = weOkHttp;
        weOkHttp.config().timeout(14L, 14L, 14L).log(WeLog.Level.BODY, new WeLog.Logger() { // from class: com.tencent.cloud.huiyansdkface.analytics.b.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.Logger
            public final void log(String str) {
                WBSLogger.d("ReportWBAEvents", str, new Object[0]);
            }
        });
    }

    public static b a() {
        if (f40457b == null) {
            synchronized (b.class) {
                if (f40457b == null) {
                    f40457b = new b();
                }
            }
        }
        return f40457b;
    }
}
