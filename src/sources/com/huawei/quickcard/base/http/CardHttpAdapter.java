package com.huawei.quickcard.base.http;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.okhttp.CardOkHttpClient;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardHttpAdapter {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33348a = "CardHttpAdapter";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33349b = "com.huawei.quickcard.okhttp.CardOkHttpClient";

    /* renamed from: c, reason: collision with root package name */
    private static volatile Class<? extends CardHttpClient> f33350c = null;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f33351d = true;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f33352e = new Object();

    public static Class<? extends CardHttpClient> getClient() {
        Class<? extends CardHttpClient> cls;
        synchronized (f33352e) {
            if (f33350c == null && f33351d) {
                try {
                    int i10 = CardOkHttpClient.f34149d;
                    f33350c = CardOkHttpClient.class;
                } catch (ClassNotFoundException unused) {
                    CardLogUtils.e(f33348a, "Neither the custom http implementation nor the default http implementation found");
                }
                f33351d = false;
            }
            cls = f33350c;
        }
        return cls;
    }

    public static void setClient(Class<? extends CardHttpClient> cls) {
        f33350c = cls;
    }
}
