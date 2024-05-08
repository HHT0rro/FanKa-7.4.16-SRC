package com.hifive.sdk.net;

import com.hifive.sdk.common.BaseConstance;
import com.hifive.sdk.utils.RxUtils;
import com.hifive.sdk.utils.TrustAllCerts;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.reflect.j;
import le.f;
import me.a;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.p;

/* compiled from: LiveRetrofitFactory.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class LiveRetrofitFactory {
    public static final Companion Companion = new Companion(null);
    private static final Lazy instance$delegate = c.b(new Function0<LiveRetrofitFactory>() { // from class: com.hifive.sdk.net.LiveRetrofitFactory$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final LiveRetrofitFactory invoke() {
            return new LiveRetrofitFactory(null);
        }
    });
    private final Interceptor encryptionInterceptor;
    private final p retrofit;

    /* compiled from: LiveRetrofitFactory.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Companion {
        public static final /* synthetic */ j[] $$delegatedProperties = {v.h(new PropertyReference1Impl(v.b(Companion.class), "instance", "getInstance()Lcom/hifive/sdk/net/LiveRetrofitFactory;"))};

        private Companion() {
        }

        private final LiveRetrofitFactory getInstance() {
            Lazy lazy = LiveRetrofitFactory.instance$delegate;
            Companion companion = LiveRetrofitFactory.Companion;
            j jVar = $$delegatedProperties[0];
            return (LiveRetrofitFactory) lazy.getValue();
        }

        @NotNull
        public final Api api() {
            return (Api) getInstance().createApi(Api.class);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private LiveRetrofitFactory() {
        this.encryptionInterceptor = new Interceptor() { // from class: com.hifive.sdk.net.LiveRetrofitFactory.1
            @Override // okhttp3.Interceptor
            @NotNull
            public Response intercept(@NotNull Interceptor.Chain chain) {
                s.j(chain, "chain");
                return chain.proceed(chain.request().newBuilder().addHeader("Content-Type", "application/x-www-form-urlencoded").build());
            }
        };
        p e2 = new p.b().c(BaseConstance.Companion.getBASE_URL_MUSIC()).g(initClient()).b(a.a()).a(f.d()).e();
        s.e(e2, "Retrofit\n               …\n                .build()");
        this.retrofit = e2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T createApi(Class<T> cls) {
        return (T) this.retrofit.b(cls);
    }

    private final OkHttpClient initClient() {
        OkHttpClient.Builder retryOnConnectionFailure = new OkHttpClient.Builder().addInterceptor(new DefaultHeaderInterceptor()).addInterceptor(this.encryptionInterceptor).addInterceptor(initLogInterceptor()).retryOnConnectionFailure(true);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder hostnameVerifier = retryOnConnectionFailure.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).hostnameVerifier(new RxUtils.TrustAllHostnameVerifier());
        SSLSocketFactory createSSLSocketFactory = RxUtils.createSSLSocketFactory();
        s.e(createSSLSocketFactory, "RxUtils.createSSLSocketFactory()");
        return hostnameVerifier.sslSocketFactory(createSSLSocketFactory, new TrustAllCerts()).retryOnConnectionFailure(true).build();
    }

    private final Interceptor initLogInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        return httpLoggingInterceptor;
    }

    public /* synthetic */ LiveRetrofitFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
