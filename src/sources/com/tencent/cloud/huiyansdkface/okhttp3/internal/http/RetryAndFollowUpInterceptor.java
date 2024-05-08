package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.alibaba.security.realidentity.build.cs;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Address;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteException;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ConnectionShutdownException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final OkHttpClient f41779a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f41780b;

    /* renamed from: c, reason: collision with root package name */
    private volatile StreamAllocation f41781c;

    /* renamed from: d, reason: collision with root package name */
    private Object f41782d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f41783e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z10) {
        this.f41779a = okHttpClient;
        this.f41780b = z10;
    }

    private int a(Response response, int i10) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i10;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private Address a(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.f41779a.sslSocketFactory();
            hostnameVerifier = this.f41779a.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.f41779a.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.f41779a.dns(), this.f41779a.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f41779a.proxyAuthenticator(), this.f41779a.proxy(), this.f41779a.protocols(), this.f41779a.connectionSpecs(), this.f41779a.proxySelector());
    }

    private Request a(Response response, Route route) throws IOException {
        String header;
        HttpUrl resolve;
        if (response == null) {
            throw new IllegalStateException();
        }
        int code = response.code();
        String method = response.request().method();
        if (code == 307 || code == 308) {
            if (!method.equals("GET") && !method.equals("HEAD")) {
                return null;
            }
        } else {
            if (code == 401) {
                return this.f41779a.authenticator().authenticate(route, response);
            }
            if (code == 503) {
                if ((response.priorResponse() == null || response.priorResponse().code() != 503) && a(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (code == 407) {
                if ((route != null ? route.proxy() : this.f41779a.proxy()).type() == Proxy.Type.HTTP) {
                    return this.f41779a.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!this.f41779a.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                    return null;
                }
                if ((response.priorResponse() == null || response.priorResponse().code() != 408) && a(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f41779a.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
            return null;
        }
        if (!resolve.scheme().equals(response.request().url().scheme()) && !this.f41779a.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
            if (HttpMethod.redirectsToGet(method)) {
                newBuilder.method("GET", null);
            } else {
                newBuilder.method(method, redirectsWithBody ? response.request().body() : null);
            }
            if (!redirectsWithBody) {
                newBuilder.removeHeader(DownloadUtils.TRANSFER_ENCODING);
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!a(response, resolve)) {
            newBuilder.removeHeader(cs.K);
        }
        return newBuilder.url(resolve).build();
    }

    private boolean a(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    private boolean a(IOException iOException, StreamAllocation streamAllocation, boolean z10, Request request) {
        streamAllocation.streamFailed(iOException);
        if (this.f41779a.retryOnConnectionFailure()) {
            return !(z10 && (request.body() instanceof UnrepeatableRequestBody)) && a(iOException, z10) && streamAllocation.hasMoreRoutes();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public void cancel() {
        this.f41783e = true;
        StreamAllocation streamAllocation = this.f41781c;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed;
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.f41779a.connectionPool(), a(request.url()), call, eventListener, this.f41782d);
        this.f41781c = streamAllocation;
        Response response = null;
        int i10 = 0;
        while (!this.f41783e) {
            try {
                try {
                    proceed = realInterceptorChain.proceed(request, streamAllocation, null, null);
                    if (response != null) {
                        proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                    }
                } catch (RouteException e2) {
                    if (!a(e2.getLastConnectException(), streamAllocation, false, request)) {
                        throw e2.getFirstConnectException();
                    }
                } catch (IOException e10) {
                    if (!a(e10, streamAllocation, !(e10 instanceof ConnectionShutdownException), request)) {
                        throw e10;
                    }
                }
                try {
                    Request a10 = a(proceed, streamAllocation.route());
                    if (a10 == null) {
                        streamAllocation.release();
                        return proceed;
                    }
                    Util.closeQuietly(proceed.body());
                    int i11 = i10 + 1;
                    if (i11 > 20) {
                        streamAllocation.release();
                        throw new ProtocolException("Too many follow-up requests: " + i11);
                    }
                    if (a10.body() instanceof UnrepeatableRequestBody) {
                        streamAllocation.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                    }
                    if (!a(proceed, a10.url())) {
                        streamAllocation.release();
                        streamAllocation = new StreamAllocation(this.f41779a.connectionPool(), a(a10.url()), call, eventListener, this.f41782d);
                        this.f41781c = streamAllocation;
                    } else if (streamAllocation.codec() != null) {
                        throw new IllegalStateException("Closing the body of " + ((Object) proceed) + " didn't close its backing stream. Bad interceptor?");
                    }
                    response = proceed;
                    request = a10;
                    i10 = i11;
                } catch (IOException e11) {
                    streamAllocation.release();
                    throw e11;
                }
            } catch (Throwable th) {
                streamAllocation.streamFailed(null);
                streamAllocation.release();
                throw th;
            }
        }
        streamAllocation.release();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.f41783e;
    }

    public void setCallStackTrace(Object obj) {
        this.f41782d = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.f41781c;
    }
}
