package com.huawei.ok3httpservice;

import com.huawei.serverrequest.api.service.ClientParams;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/* compiled from: Ok3ClientBuilderWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements ClientParams {

    /* renamed from: a, reason: collision with root package name */
    private final OkHttpClient.Builder f32107a = new OkHttpClient.Builder();

    public OkHttpClient.Builder a() {
        return this.f32107a;
    }

    @Override // com.huawei.serverrequest.api.service.ClientParams
    public ClientParams callTimeout(long j10, TimeUnit timeUnit) {
        this.f32107a.callTimeout(j10, timeUnit);
        return this;
    }

    @Override // com.huawei.serverrequest.api.service.ClientParams
    public ClientParams connectTimeout(long j10, TimeUnit timeUnit) {
        this.f32107a.connectTimeout(j10, timeUnit);
        return this;
    }

    @Override // com.huawei.serverrequest.api.service.ClientParams
    public ClientParams hostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f32107a.hostnameVerifier(hostnameVerifier);
        return this;
    }

    @Override // com.huawei.serverrequest.api.service.ClientParams
    public ClientParams readTimeout(long j10, TimeUnit timeUnit) {
        this.f32107a.readTimeout(j10, timeUnit);
        return this;
    }

    @Override // com.huawei.serverrequest.api.service.ClientParams
    public ClientParams sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        this.f32107a.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        return this;
    }

    @Override // com.huawei.serverrequest.api.service.ClientParams
    public ClientParams writeTimeout(long j10, TimeUnit timeUnit) {
        this.f32107a.writeTimeout(j10, timeUnit);
        return this;
    }
}
