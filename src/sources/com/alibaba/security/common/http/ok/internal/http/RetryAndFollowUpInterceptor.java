package com.alibaba.security.common.http.ok.internal.http;

import com.alibaba.security.common.http.ok.Address;
import com.alibaba.security.common.http.ok.CertificatePinner;
import com.alibaba.security.common.http.ok.EventListener;
import com.alibaba.security.common.http.ok.HttpUrl;
import com.alibaba.security.common.http.ok.Interceptor;
import com.alibaba.security.common.http.ok.RPCall;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.Route;
import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.connection.RouteException;
import com.alibaba.security.common.http.ok.internal.connection.StreamAllocation;
import com.alibaba.security.common.http.ok.internal.http2.ConnectionShutdownException;
import com.alibaba.security.realidentity.build.cs;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final RPHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(RPHttpClient rPHttpClient, boolean z10) {
        this.client = rPHttpClient;
        this.forWebSocket = z10;
    }

    private Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private RPRequest followUpRequest(Response response, Route route) throws IOException {
        String header;
        HttpUrl resolve;
        Proxy proxy;
        if (response != null) {
            int code = response.code();
            String method = response.request().method();
            if (code == 307 || code == 308) {
                if (!method.equals("GET") && !method.equals("HEAD")) {
                    return null;
                }
            } else {
                if (code == 401) {
                    return this.client.authenticator().authenticate(route, response);
                }
                if (code == 503) {
                    if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                        return response.request();
                    }
                    return null;
                }
                if (code == 407) {
                    if (route != null) {
                        proxy = route.proxy();
                    } else {
                        proxy = this.client.proxy();
                    }
                    if (proxy.type() == Proxy.Type.HTTP) {
                        return this.client.proxyAuthenticator().authenticate(route, response);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (code == 408) {
                    if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                        return null;
                    }
                    if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
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
            if (!this.client.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
                return null;
            }
            RPRequest.Builder newBuilder = response.request().newBuilder();
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
            if (!sameConnection(response, resolve)) {
                newBuilder.removeHeader(cs.K);
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    private boolean isRecoverable(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation, boolean z10, RPRequest rPRequest) {
        streamAllocation.streamFailed(iOException);
        if (this.client.retryOnConnectionFailure()) {
            return !(z10 && (rPRequest.body() instanceof UnrepeatableRequestBody)) && isRecoverable(iOException, z10) && streamAllocation.hasMoreRoutes();
        }
        return false;
    }

    private int retryAfter(Response response, int i10) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i10;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed;
        RPRequest request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        RPCall call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation;
        Response response = null;
        int i10 = 0;
        while (!this.canceled) {
            try {
                try {
                    proceed = realInterceptorChain.proceed(request, streamAllocation, null, null);
                    if (response != null) {
                        proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                    }
                } catch (RouteException e2) {
                    if (!recover(e2.getLastConnectException(), streamAllocation, false, request)) {
                        throw e2.getFirstConnectException();
                    }
                } catch (IOException e10) {
                    if (!recover(e10, streamAllocation, !(e10 instanceof ConnectionShutdownException), request)) {
                        throw e10;
                    }
                }
                try {
                    RPRequest followUpRequest = followUpRequest(proceed, streamAllocation.route());
                    if (followUpRequest == null) {
                        streamAllocation.release();
                        return proceed;
                    }
                    Util.closeQuietly(proceed.body());
                    int i11 = i10 + 1;
                    if (i11 <= 20) {
                        if (!(followUpRequest.body() instanceof UnrepeatableRequestBody)) {
                            if (!sameConnection(proceed, followUpRequest.url())) {
                                streamAllocation.release();
                                streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(followUpRequest.url()), call, eventListener, this.callStackTrace);
                                this.streamAllocation = streamAllocation;
                            } else if (streamAllocation.codec() != null) {
                                throw new IllegalStateException("Closing the body of " + ((Object) proceed) + " didn't close its backing stream. Bad interceptor?");
                            }
                            response = proceed;
                            request = followUpRequest;
                            i10 = i11;
                        } else {
                            streamAllocation.release();
                            throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                        }
                    } else {
                        streamAllocation.release();
                        throw new ProtocolException("Too many follow-up requests: " + i11);
                    }
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
        return this.canceled;
    }

    public void setCallStackTrace(Object obj) {
        this.callStackTrace = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
