package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeHttp {

    /* renamed from: a, reason: collision with root package name */
    private static WeOkHttp f42382a = new WeOkHttp("WeHttp");

    public static void cancel(Object obj) {
        f42382a.cancel(obj);
    }

    public static OkHttpClient client() {
        return f42382a.client();
    }

    public static WeConfig config() {
        return f42382a.config();
    }

    public static BodyReq delete(String str) {
        return f42382a.delete(str);
    }

    public static SimpleReq get(String str) {
        return f42382a.get(str);
    }

    public static SimpleReq head(String str) {
        return f42382a.head(str);
    }

    public static WeConfig init() {
        return f42382a.init();
    }

    public static WeConfig init(Context context, boolean z10, String str, String... strArr) {
        if (context == null) {
            throw new IllegalArgumentException("ctx must not be null");
        }
        OkHttpClient.Builder clientConfig = config().clientConfig();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        clientConfig.connectTimeout(20L, timeUnit).readTimeout(20L, timeUnit);
        config().addPin4Host(HttpUrl.parse(str).host(), strArr).log(z10 ? WeLog.Level.BODY : WeLog.Level.NONE).cookieWebView(context.getApplicationContext()).adapter(new WeTypeAdapter()).baseUrl(str);
        return config();
    }

    public static BodyReq patch(String str) {
        return f42382a.patch(str);
    }

    public static BodyReq post(String str) {
        return f42382a.post(str);
    }

    public static BodyReq put(String str) {
        return f42382a.put(str);
    }
}
