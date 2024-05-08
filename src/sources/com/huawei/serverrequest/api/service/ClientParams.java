package com.huawei.serverrequest.api.service;

import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ClientParams {
    ClientParams callTimeout(long j10, TimeUnit timeUnit);

    ClientParams connectTimeout(long j10, TimeUnit timeUnit);

    ClientParams hostnameVerifier(HostnameVerifier hostnameVerifier);

    ClientParams readTimeout(long j10, TimeUnit timeUnit);

    ClientParams sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager);

    ClientParams writeTimeout(long j10, TimeUnit timeUnit);
}
