package com.wangmai.okhttp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.wangmai.okhttp.cache.CacheMode;
import com.wangmai.okhttp.cookie.CookieJarImpl;
import com.wangmai.okhttp.https.HttpsUtils;
import com.wangmai.okhttp.interceptor.SameRequestFilterInterceptor;
import com.wangmai.okhttp.model.HttpHeaders;
import com.wangmai.okhttp.model.HttpParams;
import com.wangmai.okhttp.request.GetRequest;
import com.wangmai.okhttp.request.PostRequest;
import com.wangmai.okhttp.utils.HttpUtils;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OkHttp {
    public static final long DEFAULT_MILLISECONDS = 5000;
    public static long REFRESH_TIME = 300;
    public static final String TAG = "WM_OkHttp";
    public static String packageName;
    public Context context;
    public CacheMode mCacheMode;
    public long mCacheTime;
    public HttpHeaders mCommonHeaders;
    public HttpParams mCommonParams;
    public Handler mDelivery;
    public int mRetryCount;
    public OkHttpClient okHttpClient;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class OkHttpHolder {
        public static OkHttp holder = new OkHttp();
    }

    public static <T> GetRequest<T> get(String str) {
        return new GetRequest<>(str);
    }

    public static OkHttp getInstance() {
        return OkHttpHolder.holder;
    }

    public static <T> PostRequest<T> post(String str) {
        return new PostRequest<>(str);
    }

    public OkHttp addCommonHeaders(HttpHeaders httpHeaders) {
        if (this.mCommonHeaders == null) {
            this.mCommonHeaders = new HttpHeaders();
        }
        this.mCommonHeaders.put(httpHeaders);
        return this;
    }

    public OkHttp addCommonParams(HttpParams httpParams) {
        if (this.mCommonParams == null) {
            this.mCommonParams = new HttpParams();
        }
        this.mCommonParams.put(httpParams);
        return this;
    }

    public void cancelAll() {
        Iterator<Call> iterator2 = getOkHttpClient().dispatcher().queuedCalls().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().cancel();
        }
        Iterator<Call> iterator22 = getOkHttpClient().dispatcher().runningCalls().iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().cancel();
        }
    }

    public void cancelTag(Object obj) {
        if (obj == null) {
            return;
        }
        for (Call call : getOkHttpClient().dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : getOkHttpClient().dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    public CacheMode getCacheMode() {
        return this.mCacheMode;
    }

    public long getCacheTime() {
        return this.mCacheTime;
    }

    public HttpHeaders getCommonHeaders() {
        return this.mCommonHeaders;
    }

    public HttpParams getCommonParams() {
        return this.mCommonParams;
    }

    public Context getContext() {
        HttpUtils.checkNotNull(this.context, "please call OkHttp.getInstance().init() first in application!");
        return this.context;
    }

    public CookieJarImpl getCookieJar() {
        return (CookieJarImpl) this.okHttpClient.cookieJar();
    }

    public Handler getDelivery() {
        return this.mDelivery;
    }

    public OkHttpClient getOkHttpClient() {
        HttpUtils.checkNotNull(this.okHttpClient, "please call OkHttp.getInstance().setOkHttpClient() first in application!");
        return this.okHttpClient;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public OkHttp init(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        packageName = applicationContext.getPackageName();
        return this;
    }

    public OkHttp setCacheMode(CacheMode cacheMode) {
        this.mCacheMode = cacheMode;
        return this;
    }

    public OkHttp setCacheTime(long j10) {
        if (j10 <= -1) {
            j10 = -1;
        }
        this.mCacheTime = j10;
        return this;
    }

    public OkHttp setOkHttpClient(OkHttpClient okHttpClient) {
        HttpUtils.checkNotNull(okHttpClient, "okHttpClient == null");
        this.okHttpClient = okHttpClient;
        return this;
    }

    public OkHttp setRetryCount(int i10) {
        if (i10 >= 0) {
            this.mRetryCount = i10;
            return this;
        }
        throw new IllegalArgumentException("retryCount must >= 0");
    }

    public OkHttp() {
        this.mDelivery = new Handler(Looper.getMainLooper());
        this.mRetryCount = 3;
        this.mCacheTime = -1L;
        this.mCacheMode = CacheMode.NO_CACHE;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(5000L, timeUnit);
        builder.writeTimeout(5000L, timeUnit);
        builder.connectTimeout(5000L, timeUnit);
        HttpsUtils.SSLParams sslSocketFactory = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslSocketFactory.sSLSocketFactory, sslSocketFactory.trustManager);
        builder.hostnameVerifier(HttpsUtils.UnSafeHostnameVerifier);
        builder.addInterceptor(SameRequestFilterInterceptor.INTERCEPTOR);
        this.okHttpClient = builder.build();
    }
}
