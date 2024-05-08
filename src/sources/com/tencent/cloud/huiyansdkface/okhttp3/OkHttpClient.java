package com.tencent.cloud.huiyansdkface.okhttp3;

import com.huawei.quickcard.base.Attributes;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.WebSocket;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteDatabase;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.proxy.NullProxySelector;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.OkHostnameVerifier;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.RealWebSocket;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.time.Duration;
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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OkHttpClient implements Call.Factory, WebSocket.Factory, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public static final List<Protocol> f41464a = Util.immutableList(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: b, reason: collision with root package name */
    public static final List<ConnectionSpec> f41465b = Util.immutableList(ConnectionSpec.f41353b, ConnectionSpec.f41355d);
    public final int A;
    public final int B;
    public final int C;
    public final int D;

    /* renamed from: c, reason: collision with root package name */
    public final Dispatcher f41466c;

    /* renamed from: d, reason: collision with root package name */
    public final Proxy f41467d;

    /* renamed from: e, reason: collision with root package name */
    public final List<Protocol> f41468e;

    /* renamed from: f, reason: collision with root package name */
    public final List<ConnectionSpec> f41469f;

    /* renamed from: g, reason: collision with root package name */
    public final List<Interceptor> f41470g;

    /* renamed from: h, reason: collision with root package name */
    public final List<Interceptor> f41471h;

    /* renamed from: i, reason: collision with root package name */
    public final EventListener.Factory f41472i;

    /* renamed from: j, reason: collision with root package name */
    public final ProxySelector f41473j;

    /* renamed from: k, reason: collision with root package name */
    public final CookieJar f41474k;

    /* renamed from: l, reason: collision with root package name */
    public final Cache f41475l;

    /* renamed from: m, reason: collision with root package name */
    public final InternalCache f41476m;

    /* renamed from: n, reason: collision with root package name */
    public final SocketFactory f41477n;

    /* renamed from: o, reason: collision with root package name */
    public final SSLSocketFactory f41478o;

    /* renamed from: p, reason: collision with root package name */
    public final CertificateChainCleaner f41479p;

    /* renamed from: q, reason: collision with root package name */
    public final HostnameVerifier f41480q;

    /* renamed from: r, reason: collision with root package name */
    public final CertificatePinner f41481r;

    /* renamed from: s, reason: collision with root package name */
    public final Authenticator f41482s;

    /* renamed from: t, reason: collision with root package name */
    public final Authenticator f41483t;

    /* renamed from: u, reason: collision with root package name */
    public final ConnectionPool f41484u;

    /* renamed from: v, reason: collision with root package name */
    public final Dns f41485v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f41486w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f41487x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f41488y;

    /* renamed from: z, reason: collision with root package name */
    public final int f41489z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {
        public int A;
        public int B;

        /* renamed from: a, reason: collision with root package name */
        public Dispatcher f41490a;

        /* renamed from: b, reason: collision with root package name */
        public Proxy f41491b;

        /* renamed from: c, reason: collision with root package name */
        public List<Protocol> f41492c;

        /* renamed from: d, reason: collision with root package name */
        public List<ConnectionSpec> f41493d;

        /* renamed from: e, reason: collision with root package name */
        public final List<Interceptor> f41494e;

        /* renamed from: f, reason: collision with root package name */
        public final List<Interceptor> f41495f;

        /* renamed from: g, reason: collision with root package name */
        public EventListener.Factory f41496g;

        /* renamed from: h, reason: collision with root package name */
        public ProxySelector f41497h;

        /* renamed from: i, reason: collision with root package name */
        public CookieJar f41498i;

        /* renamed from: j, reason: collision with root package name */
        public Cache f41499j;

        /* renamed from: k, reason: collision with root package name */
        public InternalCache f41500k;

        /* renamed from: l, reason: collision with root package name */
        public SocketFactory f41501l;

        /* renamed from: m, reason: collision with root package name */
        public SSLSocketFactory f41502m;

        /* renamed from: n, reason: collision with root package name */
        public CertificateChainCleaner f41503n;

        /* renamed from: o, reason: collision with root package name */
        public HostnameVerifier f41504o;

        /* renamed from: p, reason: collision with root package name */
        public CertificatePinner f41505p;

        /* renamed from: q, reason: collision with root package name */
        public Authenticator f41506q;

        /* renamed from: r, reason: collision with root package name */
        public Authenticator f41507r;

        /* renamed from: s, reason: collision with root package name */
        public ConnectionPool f41508s;

        /* renamed from: t, reason: collision with root package name */
        public Dns f41509t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f41510u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f41511v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f41512w;

        /* renamed from: x, reason: collision with root package name */
        public int f41513x;

        /* renamed from: y, reason: collision with root package name */
        public int f41514y;

        /* renamed from: z, reason: collision with root package name */
        public int f41515z;

        public Builder() {
            this.f41494e = new ArrayList();
            this.f41495f = new ArrayList();
            this.f41490a = new Dispatcher();
            this.f41492c = OkHttpClient.f41464a;
            this.f41493d = OkHttpClient.f41465b;
            this.f41496g = EventListener.a(EventListener.f41398a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f41497h = proxySelector;
            if (proxySelector == null) {
                this.f41497h = new NullProxySelector();
            }
            this.f41498i = CookieJar.f41388a;
            this.f41501l = SocketFactory.getDefault();
            this.f41504o = OkHostnameVerifier.f42022a;
            this.f41505p = CertificatePinner.f41294a;
            Authenticator authenticator = Authenticator.f41232a;
            this.f41506q = authenticator;
            this.f41507r = authenticator;
            this.f41508s = new ConnectionPool();
            this.f41509t = Dns.f41397a;
            this.f41510u = true;
            this.f41511v = true;
            this.f41512w = true;
            this.f41513x = 0;
            this.f41514y = 10000;
            this.f41515z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public Builder(OkHttpClient okHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.f41494e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f41495f = arrayList2;
            this.f41490a = okHttpClient.f41466c;
            this.f41491b = okHttpClient.f41467d;
            this.f41492c = okHttpClient.f41468e;
            this.f41493d = okHttpClient.f41469f;
            arrayList.addAll(okHttpClient.f41470g);
            arrayList2.addAll(okHttpClient.f41471h);
            this.f41496g = okHttpClient.f41472i;
            this.f41497h = okHttpClient.f41473j;
            this.f41498i = okHttpClient.f41474k;
            this.f41500k = okHttpClient.f41476m;
            this.f41499j = okHttpClient.f41475l;
            this.f41501l = okHttpClient.f41477n;
            this.f41502m = okHttpClient.f41478o;
            this.f41503n = okHttpClient.f41479p;
            this.f41504o = okHttpClient.f41480q;
            this.f41505p = okHttpClient.f41481r;
            this.f41506q = okHttpClient.f41482s;
            this.f41507r = okHttpClient.f41483t;
            this.f41508s = okHttpClient.f41484u;
            this.f41509t = okHttpClient.f41485v;
            this.f41510u = okHttpClient.f41486w;
            this.f41511v = okHttpClient.f41487x;
            this.f41512w = okHttpClient.f41488y;
            this.f41513x = okHttpClient.f41489z;
            this.f41514y = okHttpClient.A;
            this.f41515z = okHttpClient.B;
            this.A = okHttpClient.C;
            this.B = okHttpClient.D;
        }

        public void a(InternalCache internalCache) {
            this.f41500k = internalCache;
            this.f41499j = null;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f41494e.add(interceptor);
            return this;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f41495f.add(interceptor);
            return this;
        }

        public Builder authenticator(Authenticator authenticator) {
            Objects.requireNonNull(authenticator, "authenticator == null");
            this.f41507r = authenticator;
            return this;
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public Builder cache(Cache cache) {
            this.f41499j = cache;
            this.f41500k = null;
            return this;
        }

        public Builder callTimeout(long j10, TimeUnit timeUnit) {
            this.f41513x = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public Builder callTimeout(Duration duration) {
            this.f41513x = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            Objects.requireNonNull(certificatePinner, "certificatePinner == null");
            this.f41505p = certificatePinner;
            return this;
        }

        public Builder connectTimeout(long j10, TimeUnit timeUnit) {
            this.f41514y = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public Builder connectTimeout(Duration duration) {
            this.f41514y = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            Objects.requireNonNull(connectionPool, "connectionPool == null");
            this.f41508s = connectionPool;
            return this;
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.f41493d = Util.immutableList(list);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            Objects.requireNonNull(cookieJar, "cookieJar == null");
            this.f41498i = cookieJar;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.f41490a = dispatcher;
            return this;
        }

        public Builder dns(Dns dns) {
            Objects.requireNonNull(dns, "dns == null");
            this.f41509t = dns;
            return this;
        }

        public Builder eventListener(EventListener eventListener) {
            Objects.requireNonNull(eventListener, "eventListener == null");
            this.f41496g = EventListener.a(eventListener);
            return this;
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            Objects.requireNonNull(factory, "eventListenerFactory == null");
            this.f41496g = factory;
            return this;
        }

        public Builder followRedirects(boolean z10) {
            this.f41511v = z10;
            return this;
        }

        public Builder followSslRedirects(boolean z10) {
            this.f41510u = z10;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.f41504o = hostnameVerifier;
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.f41494e;
        }

        public List<Interceptor> networkInterceptors() {
            return this.f41495f;
        }

        public Builder pingInterval(long j10, TimeUnit timeUnit) {
            this.B = Util.checkDuration(Attributes.Style.INTERVAL, j10, timeUnit);
            return this;
        }

        public Builder pingInterval(Duration duration) {
            this.B = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
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
            if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + ((Object) arrayList));
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(Protocol.SPDY_3);
            this.f41492c = Collections.unmodifiableList(arrayList);
            return this;
        }

        public Builder proxy(Proxy proxy) {
            this.f41491b = proxy;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            Objects.requireNonNull(authenticator, "proxyAuthenticator == null");
            this.f41506q = authenticator;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            Objects.requireNonNull(proxySelector, "proxySelector == null");
            this.f41497h = proxySelector;
            return this;
        }

        public Builder readTimeout(long j10, TimeUnit timeUnit) {
            this.f41515z = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public Builder readTimeout(Duration duration) {
            this.f41515z = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z10) {
            this.f41512w = z10;
            return this;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            Objects.requireNonNull(socketFactory, "socketFactory == null");
            this.f41501l = socketFactory;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            this.f41502m = sSLSocketFactory;
            this.f41503n = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.f41502m = sSLSocketFactory;
            this.f41503n = CertificateChainCleaner.get(x509TrustManager);
            return this;
        }

        public Builder writeTimeout(long j10, TimeUnit timeUnit) {
            this.A = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public Builder writeTimeout(Duration duration) {
            this.A = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }
    }

    static {
        Internal.f41598a = new Internal() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str) {
                builder.a(str);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.a(str, str2);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z10) {
                connectionSpec.a(sSLSocket, z10);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public int code(Response.Builder builder) {
                return builder.f41570c;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.b(realConnection);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.a(address, streamAllocation);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public boolean equalsNonHost(Address address, Address address2) {
                return address.a(address2);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.a(address, streamAllocation, route);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                return RealCall.a(okHttpClient, request, true);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.a(realConnection);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.f41345a;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void setCache(Builder builder, InternalCache internalCache) {
                builder.a(internalCache);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).a();
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public IOException timeoutExit(Call call, IOException iOException) {
                return ((RealCall) call).a(iOException);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public OkHttpClient(Builder builder) {
        boolean z10;
        CertificateChainCleaner certificateChainCleaner;
        this.f41466c = builder.f41490a;
        this.f41467d = builder.f41491b;
        this.f41468e = builder.f41492c;
        List<ConnectionSpec> list = builder.f41493d;
        this.f41469f = list;
        this.f41470g = Util.immutableList(builder.f41494e);
        this.f41471h = Util.immutableList(builder.f41495f);
        this.f41472i = builder.f41496g;
        this.f41473j = builder.f41497h;
        this.f41474k = builder.f41498i;
        this.f41475l = builder.f41499j;
        this.f41476m = builder.f41500k;
        this.f41477n = builder.f41501l;
        Iterator<ConnectionSpec> iterator2 = list.iterator2();
        loop0: while (true) {
            while (iterator2.hasNext()) {
                z10 = z10 || iterator2.next().isTls();
            }
        }
        SSLSocketFactory sSLSocketFactory = builder.f41502m;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager platformTrustManager = Util.platformTrustManager();
            this.f41478o = a(platformTrustManager);
            certificateChainCleaner = CertificateChainCleaner.get(platformTrustManager);
        } else {
            this.f41478o = sSLSocketFactory;
            certificateChainCleaner = builder.f41503n;
        }
        this.f41479p = certificateChainCleaner;
        if (this.f41478o != null) {
            Platform.get().configureSslSocketFactory(this.f41478o);
        }
        this.f41480q = builder.f41504o;
        this.f41481r = builder.f41505p.a(this.f41479p);
        this.f41482s = builder.f41506q;
        this.f41483t = builder.f41507r;
        this.f41484u = builder.f41508s;
        this.f41485v = builder.f41509t;
        this.f41486w = builder.f41510u;
        this.f41487x = builder.f41511v;
        this.f41488y = builder.f41512w;
        this.f41489z = builder.f41513x;
        this.A = builder.f41514y;
        this.B = builder.f41515z;
        this.C = builder.A;
        this.D = builder.B;
        if (this.f41470g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + ((Object) this.f41470g));
        }
        if (this.f41471h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + ((Object) this.f41471h));
        }
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw Util.assertionError("No System TLS", e2);
        }
    }

    public InternalCache a() {
        Cache cache = this.f41475l;
        return cache != null ? cache.f41233a : this.f41476m;
    }

    public Authenticator authenticator() {
        return this.f41483t;
    }

    public Cache cache() {
        return this.f41475l;
    }

    public int callTimeoutMillis() {
        return this.f41489z;
    }

    public CertificatePinner certificatePinner() {
        return this.f41481r;
    }

    public int connectTimeoutMillis() {
        return this.A;
    }

    public ConnectionPool connectionPool() {
        return this.f41484u;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f41469f;
    }

    public CookieJar cookieJar() {
        return this.f41474k;
    }

    public Dispatcher dispatcher() {
        return this.f41466c;
    }

    public Dns dns() {
        return this.f41485v;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.f41472i;
    }

    public boolean followRedirects() {
        return this.f41487x;
    }

    public boolean followSslRedirects() {
        return this.f41486w;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f41480q;
    }

    public List<Interceptor> interceptors() {
        return this.f41470g;
    }

    public List<Interceptor> networkInterceptors() {
        return this.f41471h;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call.Factory
    public Call newCall(Request request) {
        return RealCall.a(this, request, false);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), this.D);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.D;
    }

    public List<Protocol> protocols() {
        return this.f41468e;
    }

    public Proxy proxy() {
        return this.f41467d;
    }

    public Authenticator proxyAuthenticator() {
        return this.f41482s;
    }

    public ProxySelector proxySelector() {
        return this.f41473j;
    }

    public int readTimeoutMillis() {
        return this.B;
    }

    public boolean retryOnConnectionFailure() {
        return this.f41488y;
    }

    public SocketFactory socketFactory() {
        return this.f41477n;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f41478o;
    }

    public int writeTimeoutMillis() {
        return this.C;
    }
}
