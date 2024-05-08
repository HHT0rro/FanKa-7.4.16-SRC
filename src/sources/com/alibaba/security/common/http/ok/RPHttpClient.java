package com.alibaba.security.common.http.ok;

import com.alibaba.security.common.http.ok.EventListener;
import com.alibaba.security.common.http.ok.Headers;
import com.alibaba.security.common.http.ok.RPCall;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.WebSocket;
import com.alibaba.security.common.http.ok.internal.Internal;
import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.cache.InternalCache;
import com.alibaba.security.common.http.ok.internal.connection.RealConnection;
import com.alibaba.security.common.http.ok.internal.connection.RouteDatabase;
import com.alibaba.security.common.http.ok.internal.connection.StreamAllocation;
import com.alibaba.security.common.http.ok.internal.platform.Platform;
import com.alibaba.security.common.http.ok.internal.proxy.NullProxySelector;
import com.alibaba.security.common.http.ok.internal.tls.CertificateChainCleaner;
import com.alibaba.security.common.http.ok.internal.tls.OkHostnameVerifier;
import com.alibaba.security.common.http.ok.internal.ws.RealWebSocket;
import com.huawei.quickcard.base.Attributes;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPHttpClient implements Cloneable, RPCall.Factory, WebSocket.Factory {
    public final Authenticator authenticator;
    public final Cache cache;
    public final int callTimeout;
    public final CertificateChainCleaner certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeout;
    public final ConnectionPool connectionPool;
    public final List<ConnectionSpec> connectionSpecs;
    public final CookieJar cookieJar;
    public final RPDispatcher dispatcher;
    public final Dns dns;
    public final EventListener.Factory eventListenerFactory;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final HostnameVerifier hostnameVerifier;
    public final List<Interceptor> interceptors;
    public final InternalCache internalCache;
    public final List<Interceptor> networkInterceptors;
    public final int pingInterval;
    public final List<Protocol> protocols;
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeout;
    public final boolean retryOnConnectionFailure;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactory;
    public final int writeTimeout;
    public static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    static {
        Internal.instance = new Internal() { // from class: com.alibaba.security.common.http.ok.RPHttpClient.1
            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public void addLenient(Headers.Builder builder, String str) {
                builder.addLenient(str);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z10) {
                connectionSpec.apply(sSLSocket, z10);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public int code(Response.Builder builder) {
                return builder.code;
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.connectionBecameIdle(realConnection);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.deduplicate(address, streamAllocation);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public boolean equalsNonHost(Address address, Address address2) {
                return address.equalsNonHost(address2);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.get(address, streamAllocation, route);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public RPCall newWebSocketCall(RPHttpClient rPHttpClient, RPRequest rPRequest) {
                return RealCall.newRealCall(rPHttpClient, rPRequest, true);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.put(realConnection);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.routeDatabase;
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public void setCache(Builder builder, InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public StreamAllocation streamAllocation(RPCall rPCall) {
                return ((RealCall) rPCall).streamAllocation();
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public IOException timeoutExit(RPCall rPCall, IOException iOException) {
                return ((RealCall) rPCall).timeoutExit(iOException);
            }

            @Override // com.alibaba.security.common.http.ok.internal.Internal
            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.addLenient(str, str2);
            }
        };
    }

    public RPHttpClient() {
        this(new Builder());
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw Util.assertionError("No System TLS", e2);
        }
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    public Cache cache() {
        return this.cache;
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public RPDispatcher dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public InternalCache internalCache() {
        Cache cache = this.cache;
        return cache != null ? cache.internalCache : this.internalCache;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // com.alibaba.security.common.http.ok.RPCall.Factory
    public RPCall newCall(RPRequest rPRequest) {
        return RealCall.newRealCall(this, rPRequest, false);
    }

    @Override // com.alibaba.security.common.http.ok.WebSocket.Factory
    public WebSocket newWebSocket(RPRequest rPRequest, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(rPRequest, webSocketListener, new Random(), this.pingInterval);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public RPHttpClient(Builder builder) {
        boolean z10;
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        List<ConnectionSpec> list = builder.connectionSpecs;
        this.connectionSpecs = list;
        this.interceptors = Util.immutableList(builder.interceptors);
        this.networkInterceptors = Util.immutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.internalCache = builder.internalCache;
        this.socketFactory = builder.socketFactory;
        Iterator<ConnectionSpec> iterator2 = list.iterator2();
        loop0: while (true) {
            while (iterator2.hasNext()) {
                z10 = z10 || iterator2.next().isTls();
            }
        }
        SSLSocketFactory sSLSocketFactory = builder.sslSocketFactory;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager platformTrustManager = Util.platformTrustManager();
            this.sslSocketFactory = newSslSocketFactory(platformTrustManager);
            this.certificateChainCleaner = CertificateChainCleaner.get(platformTrustManager);
        } else {
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = builder.certificateChainCleaner;
        }
        if (this.sslSocketFactory != null) {
            Platform.get().configureSslSocketFactory(this.sslSocketFactory);
        }
        this.hostnameVerifier = builder.hostnameVerifier;
        this.certificatePinner = builder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.authenticator = builder.authenticator;
        this.connectionPool = builder.connectionPool;
        this.dns = builder.dns;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.callTimeout = builder.callTimeout;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        if (!this.interceptors.contains(null)) {
            if (this.networkInterceptors.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + ((Object) this.networkInterceptors));
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + ((Object) this.interceptors));
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Builder {
        public Authenticator authenticator;
        public Cache cache;
        public int callTimeout;
        public CertificateChainCleaner certificateChainCleaner;
        public CertificatePinner certificatePinner;
        public int connectTimeout;
        public ConnectionPool connectionPool;
        public List<ConnectionSpec> connectionSpecs;
        public CookieJar cookieJar;
        public RPDispatcher dispatcher;
        public Dns dns;
        public EventListener.Factory eventListenerFactory;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public HostnameVerifier hostnameVerifier;
        public final List<Interceptor> interceptors;
        public InternalCache internalCache;
        public final List<Interceptor> networkInterceptors;
        public int pingInterval;
        public List<Protocol> protocols;
        public Proxy proxy;
        public Authenticator proxyAuthenticator;
        public ProxySelector proxySelector;
        public int readTimeout;
        public boolean retryOnConnectionFailure;
        public SocketFactory socketFactory;
        public SSLSocketFactory sslSocketFactory;
        public int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new RPDispatcher();
            this.protocols = RPHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = RPHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = EventListener.factory(EventListener.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.proxySelector = proxySelector;
            if (proxySelector == null) {
                this.proxySelector = new NullProxySelector();
            }
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            Authenticator authenticator = Authenticator.NONE;
            this.proxyAuthenticator = authenticator;
            this.authenticator = authenticator;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.interceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder authenticator(Authenticator authenticator) {
            Objects.requireNonNull(authenticator, "authenticator == null");
            this.authenticator = authenticator;
            return this;
        }

        public RPHttpClient build() {
            return new RPHttpClient(this);
        }

        public Builder cache(Cache cache) {
            this.cache = cache;
            this.internalCache = null;
            return this;
        }

        public Builder callTimeout(long j10, TimeUnit timeUnit) {
            this.callTimeout = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            Objects.requireNonNull(certificatePinner, "certificatePinner == null");
            this.certificatePinner = certificatePinner;
            return this;
        }

        public Builder connectTimeout(long j10, TimeUnit timeUnit) {
            this.connectTimeout = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            Objects.requireNonNull(connectionPool, "connectionPool == null");
            this.connectionPool = connectionPool;
            return this;
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = Util.immutableList(list);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            Objects.requireNonNull(cookieJar, "cookieJar == null");
            this.cookieJar = cookieJar;
            return this;
        }

        public Builder dispatcher(RPDispatcher rPDispatcher) {
            if (rPDispatcher != null) {
                this.dispatcher = rPDispatcher;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder dns(Dns dns) {
            Objects.requireNonNull(dns, "dns == null");
            this.dns = dns;
            return this;
        }

        public Builder eventListener(EventListener eventListener) {
            Objects.requireNonNull(eventListener, "eventListener == null");
            this.eventListenerFactory = EventListener.factory(eventListener);
            return this;
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            Objects.requireNonNull(factory, "eventListenerFactory == null");
            this.eventListenerFactory = factory;
            return this;
        }

        public Builder followRedirects(boolean z10) {
            this.followRedirects = z10;
            return this;
        }

        public Builder followSslRedirects(boolean z10) {
            this.followSslRedirects = z10;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder pingInterval(long j10, TimeUnit timeUnit) {
            this.pingInterval = Util.checkDuration(Attributes.Style.INTERVAL, j10, timeUnit);
            return this;
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + ((Object) arrayList));
            }
            if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + ((Object) arrayList));
            }
            if (!arrayList.contains(Protocol.HTTP_1_0)) {
                if (!arrayList.contains(null)) {
                    arrayList.remove(Protocol.SPDY_3);
                    this.protocols = Collections.unmodifiableList(arrayList);
                    return this;
                }
                throw new IllegalArgumentException("protocols must not contain null");
            }
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + ((Object) arrayList));
        }

        public Builder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            Objects.requireNonNull(authenticator, "proxyAuthenticator == null");
            this.proxyAuthenticator = authenticator;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            Objects.requireNonNull(proxySelector, "proxySelector == null");
            this.proxySelector = proxySelector;
            return this;
        }

        public Builder readTimeout(long j10, TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z10) {
            this.retryOnConnectionFailure = z10;
            return this;
        }

        public void setInternalCache(InternalCache internalCache) {
            this.internalCache = internalCache;
            this.cache = null;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            Objects.requireNonNull(socketFactory, "socketFactory == null");
            this.socketFactory = socketFactory;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
            return this;
        }

        public Builder writeTimeout(long j10, TimeUnit timeUnit) {
            this.writeTimeout = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
            return this;
        }

        public Builder(RPHttpClient rPHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.interceptors = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.networkInterceptors = arrayList2;
            this.dispatcher = rPHttpClient.dispatcher;
            this.proxy = rPHttpClient.proxy;
            this.protocols = rPHttpClient.protocols;
            this.connectionSpecs = rPHttpClient.connectionSpecs;
            arrayList.addAll(rPHttpClient.interceptors);
            arrayList2.addAll(rPHttpClient.networkInterceptors);
            this.eventListenerFactory = rPHttpClient.eventListenerFactory;
            this.proxySelector = rPHttpClient.proxySelector;
            this.cookieJar = rPHttpClient.cookieJar;
            this.internalCache = rPHttpClient.internalCache;
            this.cache = rPHttpClient.cache;
            this.socketFactory = rPHttpClient.socketFactory;
            this.sslSocketFactory = rPHttpClient.sslSocketFactory;
            this.certificateChainCleaner = rPHttpClient.certificateChainCleaner;
            this.hostnameVerifier = rPHttpClient.hostnameVerifier;
            this.certificatePinner = rPHttpClient.certificatePinner;
            this.proxyAuthenticator = rPHttpClient.proxyAuthenticator;
            this.authenticator = rPHttpClient.authenticator;
            this.connectionPool = rPHttpClient.connectionPool;
            this.dns = rPHttpClient.dns;
            this.followSslRedirects = rPHttpClient.followSslRedirects;
            this.followRedirects = rPHttpClient.followRedirects;
            this.retryOnConnectionFailure = rPHttpClient.retryOnConnectionFailure;
            this.callTimeout = rPHttpClient.callTimeout;
            this.connectTimeout = rPHttpClient.connectTimeout;
            this.readTimeout = rPHttpClient.readTimeout;
            this.writeTimeout = rPHttpClient.writeTimeout;
            this.pingInterval = rPHttpClient.pingInterval;
        }
    }
}
