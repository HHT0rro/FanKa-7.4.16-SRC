package com.huawei.appgallery.agd.serverreq.http;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class OKHttpManager {
    public static final int KEEP_ALIVE_DURATION = 10;
    public static final int MAX_IDLE_CONNECTIONS = 8;

    /* renamed from: b, reason: collision with root package name */
    public static OkHttpClient f27529b;

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f27528a = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, OkHttpClient> f27530c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static SafeHttpsSetting f27531d = new SafeHttpsSetting();

    public static OkHttpClient.Builder createClientBuilder(OKHttpClientParams oKHttpClientParams) {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(64);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.dispatcher(dispatcher);
        builder.followRedirects(true);
        builder.followSslRedirects(true);
        builder.connectionPool(new ConnectionPool(oKHttpClientParams.getMaxIdleConnections(), oKHttpClientParams.getKeepAliveDuration(), TimeUnit.MINUTES));
        long connectTimeout = oKHttpClientParams.getConnectTimeout();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(connectTimeout, timeUnit);
        builder.readTimeout(oKHttpClientParams.getReadTimeout(), timeUnit);
        builder.writeTimeout(oKHttpClientParams.getWriteTimeout(), timeUnit);
        builder.hostnameVerifier(f27531d.getHostnameVerifier());
        builder.sslSocketFactory(f27531d.getSSLSocketFactory(), f27531d.getX509TrustManager());
        return builder;
    }

    public static OkHttpClient getOkHttpClient(String str) {
        return (TextUtils.isEmpty(str) || f27530c.isEmpty() || !f27530c.containsKey(str)) ? getStoreHttpClient() : f27530c.get(str);
    }

    public static OkHttpClient getStoreHttpClient() {
        OkHttpClient okHttpClient;
        synchronized (f27528a) {
            if (f27529b == null) {
                OKHttpClientParams oKHttpClientParams = new OKHttpClientParams();
                oKHttpClientParams.setMaxIdleConnections(8);
                oKHttpClientParams.setKeepAliveDuration(10);
                oKHttpClientParams.setConnectTimeout(6);
                oKHttpClientParams.setReadTimeout(6);
                oKHttpClientParams.setWriteTimeout(6);
                f27529b = createClientBuilder(oKHttpClientParams).build();
            }
            okHttpClient = f27529b;
        }
        return okHttpClient;
    }
}
