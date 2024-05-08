package com.alibaba.security.common.http.ok.internal.connection;

import com.alibaba.security.common.http.ok.Address;
import com.alibaba.security.common.http.ok.CertificatePinner;
import com.alibaba.security.common.http.ok.Connection;
import com.alibaba.security.common.http.ok.ConnectionPool;
import com.alibaba.security.common.http.ok.ConnectionSpec;
import com.alibaba.security.common.http.ok.EventListener;
import com.alibaba.security.common.http.ok.Handshake;
import com.alibaba.security.common.http.ok.HttpUrl;
import com.alibaba.security.common.http.ok.Interceptor;
import com.alibaba.security.common.http.ok.Protocol;
import com.alibaba.security.common.http.ok.RPCall;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.Route;
import com.alibaba.security.common.http.ok.internal.HttpVersion;
import com.alibaba.security.common.http.ok.internal.Internal;
import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.http.HttpCodec;
import com.alibaba.security.common.http.ok.internal.http.HttpHeaders;
import com.alibaba.security.common.http.ok.internal.http1.Http1Codec;
import com.alibaba.security.common.http.ok.internal.http2.ErrorCode;
import com.alibaba.security.common.http.ok.internal.http2.Http2Codec;
import com.alibaba.security.common.http.ok.internal.http2.Http2Connection;
import com.alibaba.security.common.http.ok.internal.http2.Http2Stream;
import com.alibaba.security.common.http.ok.internal.platform.Platform;
import com.alibaba.security.common.http.ok.internal.tls.OkHostnameVerifier;
import com.alibaba.security.common.http.ok.internal.ws.RealWebSocket;
import com.alibaba.security.common.http.okio.BufferedSink;
import com.alibaba.security.common.http.okio.BufferedSource;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.common.http.okio.Source;
import com.alibaba.security.common.http.okio.Timeout;
import com.alibaba.security.realidentity.build.cs;
import com.huawei.openalliance.ad.constant.u;
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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    public int successCount;
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public long idleAtNanos = Long.MAX_VALUE;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.connectionPool = connectionPool;
        this.route = route;
    }

    private void connectSocket(int i10, int i11, RPCall rPCall, EventListener eventListener) throws IOException {
        Proxy proxy = this.route.proxy();
        this.rawSocket = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.route.address().socketFactory().createSocket() : new Socket(proxy);
        eventListener.connectStart(rPCall, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i11);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i10);
            try {
                this.source = RPOkio.buffer(RPOkio.source(this.rawSocket));
                this.sink = RPOkio.buffer(RPOkio.sink(this.rawSocket));
            } catch (NullPointerException e2) {
                if (NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e10) {
            ConnectException connectException = new ConnectException("Failed to connect to " + ((Object) this.route.socketAddress()));
            connectException.initCause(e10);
            throw connectException;
        }
    }

    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Address address = this.route.address();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
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
                        this.socket = sSLSocket2;
                        this.source = RPOkio.buffer(RPOkio.source(sSLSocket2));
                        this.sink = RPOkio.buffer(RPOkio.sink(this.socket));
                        this.handshake = handshake;
                        this.protocol = selectedProtocol != null ? Protocol.get(selectedProtocol) : Protocol.HTTP_1_1;
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
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e10) {
            e = e10;
        }
    }

    private void connectTunnel(int i10, int i11, int i12, RPCall rPCall, EventListener eventListener) throws IOException {
        RPRequest createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        for (int i13 = 0; i13 < 21; i13++) {
            connectSocket(i10, i11, rPCall, eventListener);
            createTunnelRequest = createTunnel(i11, i12, createTunnelRequest, url);
            if (createTunnelRequest == null) {
                return;
            }
            Util.closeQuietly(this.rawSocket);
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.connectEnd(rPCall, this.route.socketAddress(), this.route.proxy(), null);
        }
    }

    private RPRequest createTunnel(int i10, int i11, RPRequest rPRequest, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.source, this.sink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.source.timeout().timeout(i10, timeUnit);
            this.sink.timeout().timeout(i11, timeUnit);
            http1Codec.writeRequest(rPRequest.headers(), str);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(rPRequest).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, timeUnit);
            newFixedLengthSource.close();
            int code = build.code();
            if (code == 200) {
                if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (code == 407) {
                RPRequest authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                if (authenticate != null) {
                    if ("close".equalsIgnoreCase(build.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_CONNECTION))) {
                        return authenticate;
                    }
                    rPRequest = authenticate;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
        }
    }

    private RPRequest createTunnelRequest() throws IOException {
        RPRequest build = new RPRequest.Builder().url(this.route.address().url()).method("CONNECT", null).header(cs.U, Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", HttpVersion.userAgent()).build();
        RPRequest authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate != null ? authenticate : build;
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i10, RPCall rPCall, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() == null) {
            List<Protocol> protocols = this.route.address().protocols();
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (protocols.contains(protocol)) {
                this.socket = this.rawSocket;
                this.protocol = protocol;
                startHttp2(i10);
                return;
            } else {
                this.socket = this.rawSocket;
                this.protocol = Protocol.HTTP_1_1;
                return;
            }
        }
        eventListener.secureConnectStart(rPCall);
        connectTls(connectionSpecSelector);
        eventListener.secureConnectEnd(rPCall, this.handshake);
        if (this.protocol == Protocol.HTTP_2) {
            startHttp2(i10);
        }
    }

    private void startHttp2(int i10) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i10).build();
        this.http2Connection = build;
        build.start();
    }

    public static RealConnection testConnection(ConnectionPool connectionPool, Route route, Socket socket, long j10) {
        RealConnection realConnection = new RealConnection(connectionPool, route);
        realConnection.socket = socket;
        realConnection.idleAtNanos = j10;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
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
    public void connect(int r17, int r18, int r19, int r20, boolean r21, com.alibaba.security.common.http.ok.RPCall r22, com.alibaba.security.common.http.ok.EventListener r23) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.http.ok.internal.connection.RealConnection.connect(int, int, int, int, boolean, com.alibaba.security.common.http.ok.RPCall, com.alibaba.security.common.http.ok.EventListener):void");
    }

    @Override // com.alibaba.security.common.http.ok.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isEligible(Address address, Route route) {
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || route == null || route.proxy().type() != Proxy.Type.DIRECT || this.route.proxy().type() != Proxy.Type.DIRECT || !this.route.socketAddress().equals(route.socketAddress()) || route.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
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
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.http2Connection != null) {
            return !r0.isShutdown();
        }
        if (z10) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    return !this.source.exhausted();
                } finally {
                    this.socket.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public HttpCodec newCodec(RPHttpClient rPHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        if (this.http2Connection != null) {
            return new Http2Codec(rPHttpClient, chain, streamAllocation, this.http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        Timeout timeout = this.source.timeout();
        long readTimeoutMillis = chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis, timeUnit);
        this.sink.timeout().timeout(chain.writeTimeoutMillis(), timeUnit);
        return new Http1Codec(rPHttpClient, streamAllocation, this.source, this.sink);
    }

    public RealWebSocket.Streams newWebSocketStreams(final StreamAllocation streamAllocation) {
        return new RealWebSocket.Streams(true, this.source, this.sink) { // from class: com.alibaba.security.common.http.ok.internal.connection.RealConnection.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                StreamAllocation streamAllocation2 = streamAllocation;
                streamAllocation2.streamFinished(true, streamAllocation2.codec(), -1L, null);
            }
        };
    }

    @Override // com.alibaba.security.common.http.ok.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection http2Connection) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // com.alibaba.security.common.http.ok.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    @Override // com.alibaba.security.common.http.ok.Connection
    public Protocol protocol() {
        return this.protocol;
    }

    @Override // com.alibaba.security.common.http.ok.Connection
    public Route route() {
        return this.route;
    }

    @Override // com.alibaba.security.common.http.ok.Connection
    public Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.route.address().url().host())) {
            return true;
        }
        return this.handshake != null && OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.route.address().url().host());
        sb2.append(u.bD);
        sb2.append(this.route.address().url().port());
        sb2.append(", proxy=");
        sb2.append((Object) this.route.proxy());
        sb2.append(" hostAddress=");
        sb2.append((Object) this.route.socketAddress());
        sb2.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        sb2.append(handshake != null ? handshake.cipherSuite() : "none");
        sb2.append(" protocol=");
        sb2.append((Object) this.protocol);
        sb2.append('}');
        return sb2.toString();
    }
}
