package com.huawei.quickcard.base.http;

import android.content.Context;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardHttpClientManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33354a = "CardHttpClientManager";

    /* renamed from: b, reason: collision with root package name */
    private static final long f33355b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private static final long f33356c = 10000;

    /* renamed from: d, reason: collision with root package name */
    private static volatile CardHttpClient f33357d;

    public static CardHttpClient get(Context context) {
        if (f33357d == null) {
            Class<? extends CardHttpClient> client = CardHttpAdapter.getClient();
            if (client != null) {
                try {
                    f33357d = client.getConstructor(Context.class).newInstance(context);
                } catch (Exception unused) {
                    CardLogUtils.e(f33354a, "create http client fail !");
                }
            }
            if (f33357d != null) {
                CardHttpClient cardHttpClient = f33357d;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                cardHttpClient.writeTimeout(10000L, timeUnit);
                f33357d.readTimeout(10000L, timeUnit);
                f33357d.connectTimeout(10000L, timeUnit);
            }
        }
        return f33357d;
    }
}
