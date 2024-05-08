package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.alibaba.security.realidentity.build.cs;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.okhttp3.Address;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner;
import com.tencent.cloud.huiyansdkface.okhttp3.Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool;
import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionSpec;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Handshake;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Version;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http1.Http1Codec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Codec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.OkHostnameVerifier;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.RealWebSocket;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f41711a;

    /* renamed from: b, reason: collision with root package name */
    public int f41712b;

    /* renamed from: c, reason: collision with root package name */
    public int f41713c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final List<Reference<StreamAllocation>> f41714d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public long f41715e = Long.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    private final ConnectionPool f41716g;

    /* renamed from: h, reason: collision with root package name */
    private final Route f41717h;

    /* renamed from: i, reason: collision with root package name */
    private Socket f41718i;

    /* renamed from: j, reason: collision with root package name */
    private Socket f41719j;

    /* renamed from: k, reason: collision with root package name */
    private Handshake f41720k;

    /* renamed from: l, reason: collision with root package name */
    private Protocol f41721l;

    /* renamed from: m, reason: collision with root package name */
    private Http2Connection f41722m;

    /* renamed from: n, reason: collision with root package name */
    private BufferedSource f41723n;

    /* renamed from: o, reason: collision with root package name */
    private BufferedSink f41724o;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f41716g = connectionPool;
        this.f41717h = route;
    }

    private Request a() throws IOException {
        Request build = new Request.Builder().url(this.f41717h.address().url()).method("CONNECT", null).header(cs.U, Util.hostHeader(this.f41717h.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
        Request authenticate = this.f41717h.address().proxyAuthenticator().authenticate(this.f41717h, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.f41602c).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate != null ? authenticate : build;
    }

    private Request a(int i10, int i11, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.f41723n, this.f41724o);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f41723n.timeout().timeout(i10, timeUnit);
            this.f41724o.timeout().timeout(i11, timeUnit);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, timeUnit);
            newFixedLengthSource.close();
            int code = build.code();
            if (code == 200) {
                if (this.f41723n.buffer().exhausted() && this.f41724o.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (code != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
            Request authenticate = this.f41717h.address().proxyAuthenticator().authenticate(this.f41717h, build);
            if (authenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(build.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_CONNECTION))) {
                return authenticate;
            }
            request = authenticate;
        }
    }

    private void a(int i10) throws IOException {
        this.f41719j.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(this.f41719j, this.f41717h.address().url().host(), this.f41723n, this.f41724o).listener(this).pingIntervalMillis(i10).build();
        this.f41722m = build;
        build.start();
    }

    private void a(int i10, int i11, int i12, Call call, EventListener eventListener) throws IOException {
        Request a10 = a();
        HttpUrl url = a10.url();
        for (int i13 = 0; i13 < 21; i13++) {
            a(i10, i11, call, eventListener);
            a10 = a(i11, i12, a10, url);
            if (a10 == null) {
                return;
            }
            Util.closeQuietly(this.f41718i);
            this.f41718i = null;
            this.f41724o = null;
            this.f41723n = null;
            eventListener.connectEnd(call, this.f41717h.socketAddress(), this.f41717h.proxy(), null);
        }
    }

    private void a(int i10, int i11, Call call, EventListener eventListener) throws IOException {
        Proxy proxy = this.f41717h.proxy();
        this.f41718i = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.f41717h.address().socketFactory().createSocket() : new Socket(proxy);
        eventListener.connectStart(call, this.f41717h.socketAddress(), proxy);
        this.f41718i.setSoTimeout(i11);
        try {
            Platform.get().connectSocket(this.f41718i, this.f41717h.socketAddress(), i10);
            try {
                this.f41723n = Okio.buffer(Okio.source(this.f41718i));
                this.f41724o = Okio.buffer(Okio.sink(this.f41718i));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e10) {
            ConnectException connectException = new ConnectException("Failed to connect to " + ((Object) this.f41717h.socketAddress()));
            connectException.initCause(e10);
            throw connectException;
        }
    }

    private void a(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Address address = this.f41717h.address();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) address.sslSocketFactory().createSocket(this.f41718i, address.url().host(), address.url().port(), true);
                try {
                    ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        Platform.get().configureTlsExtensions(sSLSocket2, address.url().host(), address.protocols());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    Handshake handshake = Handshake.get(session);
                    if (address.hostnameVerifier().verify(address.url().host(), session)) {
                        address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                        String selectedProtocol = configureSecureSocket.supportsTlsExtensions() ? Platform.get().getSelectedProtocol(sSLSocket2) : null;
                        this.f41719j = sSLSocket2;
                        this.f41723n = Okio.buffer(Okio.source(sSLSocket2));
                        this.f41724o = Okio.buffer(Okio.sink(this.f41719j));
                        this.f41720k = handshake;
                        this.f41721l = selectedProtocol != null ? Protocol.get(selectedProtocol) : Protocol.HTTP_1_1;
                        Platform.get().afterHandshake(sSLSocket2);
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + ((Object) OkHostnameVerifier.allSubjectAltNames(x509Certificate)));
                } catch (AssertionError e2) {
                    e = e2;
                    if (!Util.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        Platform.get().afterHandshake(sSLSocket);
                    }
                    Util.closeQuietly((Socket) sSLSocket);
                    throw th;
                }
            } catch (AssertionError e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(ConnectionSpecSelector connectionSpecSelector, int i10, Call call, EventListener eventListener) throws IOException {
        if (this.f41717h.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            a(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.f41720k);
            if (this.f41721l == Protocol.HTTP_2) {
                a(i10);
                return;
            }
            return;
        }
        List<Protocol> protocols = this.f41717h.address().protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!protocols.contains(protocol)) {
            this.f41719j = this.f41718i;
            this.f41721l = Protocol.HTTP_1_1;
        } else {
            this.f41719j = this.f41718i;
            this.f41721l = protocol;
            a(i10);
        }
    }

    public static RealConnection testConnection(ConnectionPool connectionPool, Route route, Socket socket, long j10) {
        RealConnection realConnection = new RealConnection(connectionPool, route);
        realConnection.f41719j = socket;
        realConnection.f41715e = j10;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.f41718i);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connect(int r17, int r18, int r19, int r20, boolean r21, com.tencent.cloud.huiyansdkface.okhttp3.Call r22, com.tencent.cloud.huiyansdkface.okhttp3.EventListener r23) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, com.tencent.cloud.huiyansdkface.okhttp3.Call, com.tencent.cloud.huiyansdkface.okhttp3.EventListener):void");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Connection
    public Handshake handshake() {
        return this.f41720k;
    }

    public boolean isEligible(Address address, Route route) {
        if (this.f41714d.size() >= this.f41713c || this.f41711a || !Internal.f41598a.equalsNonHost(this.f41717h.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.f41722m == null || route == null || route.proxy().type() != Proxy.Type.DIRECT || this.f41717h.proxy().type() != Proxy.Type.DIRECT || !this.f41717h.socketAddress().equals(route.socketAddress()) || route.address().hostnameVerifier() != OkHostnameVerifier.f42022a || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean isHealthy(boolean z10) {
        if (this.f41719j.isClosed() || this.f41719j.isInputShutdown() || this.f41719j.isOutputShutdown()) {
            return false;
        }
        if (this.f41722m != null) {
            return !r0.isShutdown();
        }
        if (z10) {
            try {
                int soTimeout = this.f41719j.getSoTimeout();
                try {
                    this.f41719j.setSoTimeout(1);
                    return !this.f41723n.exhausted();
                } finally {
                    this.f41719j.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.f41722m != null;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        if (this.f41722m != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, this.f41722m);
        }
        this.f41719j.setSoTimeout(chain.readTimeoutMillis());
        Timeout timeout = this.f41723n.timeout();
        long readTimeoutMillis = chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis, timeUnit);
        this.f41724o.timeout().timeout(chain.writeTimeoutMillis(), timeUnit);
        return new Http1Codec(okHttpClient, streamAllocation, this.f41723n, this.f41724o);
    }

    public RealWebSocket.Streams newWebSocketStreams(final StreamAllocation streamAllocation) {
        return new RealWebSocket.Streams(true, this.f41723n, this.f41724o) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                StreamAllocation streamAllocation2 = streamAllocation;
                streamAllocation2.streamFinished(true, streamAllocation2.codec(), -1L, null);
            }
        };
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection http2Connection) {
        synchronized (this.f41716g) {
            this.f41713c = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Connection
    public Protocol protocol() {
        return this.f41721l;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Connection
    public Route route() {
        return this.f41717h;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Connection
    public Socket socket() {
        return this.f41719j;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.f41717h.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.f41717h.address().url().host())) {
            return true;
        }
        return this.f41720k != null && OkHostnameVerifier.f42022a.verify(httpUrl.host(), (X509Certificate) this.f41720k.peerCertificates().get(0));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f41717h.address().url().host());
        sb2.append(u.bD);
        sb2.append(this.f41717h.address().url().port());
        sb2.append(", proxy=");
        sb2.append((Object) this.f41717h.proxy());
        sb2.append(" hostAddress=");
        sb2.append((Object) this.f41717h.socketAddress());
        sb2.append(" cipherSuite=");
        Handshake handshake = this.f41720k;
        sb2.append(handshake != null ? handshake.cipherSuite() : "none");
        sb2.append(" protocol=");
        sb2.append((Object) this.f41721l);
        sb2.append('}');
        return sb2.toString();
    }
}
