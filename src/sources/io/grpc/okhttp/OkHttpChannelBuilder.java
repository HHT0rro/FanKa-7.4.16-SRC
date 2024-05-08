package io.grpc.okhttp;

import com.google.common.base.o;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ChoiceChannelCredentials;
import io.grpc.CompositeCallCredentials;
import io.grpc.CompositeChannelCredentials;
import io.grpc.ExperimentalApi;
import io.grpc.InsecureChannelCredentials;
import io.grpc.Internal;
import io.grpc.ManagedChannelBuilder;
import io.grpc.TlsChannelCredentials;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.AtomicBackoff;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.SharedResourcePool;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.SslSocketFactoryChannelCredentials;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.TlsVersion;
import io.grpc.util.CertificateUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.security.auth.x500.X500Principal;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1785")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class OkHttpChannelBuilder extends AbstractManagedChannelImplBuilder<OkHttpChannelBuilder> {
    public static final int DEFAULT_FLOW_CONTROL_WINDOW = 65535;
    public static final ObjectPool<Executor> DEFAULT_TRANSPORT_EXECUTOR_POOL;
    private static final SharedResourceHolder.Resource<Executor> SHARED_EXECUTOR;
    private static final EnumSet<TlsChannelCredentials.Feature> understoodTlsFeatures;
    private ConnectionSpec connectionSpec;
    private int flowControlWindow;
    private final boolean freezeSecurityConfiguration;
    private HostnameVerifier hostnameVerifier;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    private final ManagedChannelImplBuilder managedChannelImplBuilder;
    private int maxInboundMetadataSize;
    private NegotiationType negotiationType;
    private ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private ObjectPool<Executor> transportExecutorPool;
    private TransportTracer.Factory transportTracerFactory;
    private final boolean useGetForSafeMethods;
    private static final Logger log = Logger.getLogger(OkHttpChannelBuilder.class.getName());
    public static final ConnectionSpec INTERNAL_DEFAULT_CONNECTION_SPEC = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).tlsVersions(TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
    private static final long AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000);

    /* renamed from: io.grpc.okhttp.OkHttpChannelBuilder$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$io$grpc$okhttp$NegotiationType;
        public static final /* synthetic */ int[] $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType;

        static {
            int[] iArr = new int[NegotiationType.values().length];
            $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType = iArr;
            try {
                iArr[NegotiationType.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[NegotiationType.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[io.grpc.okhttp.NegotiationType.values().length];
            $SwitchMap$io$grpc$okhttp$NegotiationType = iArr2;
            try {
                iArr2[io.grpc.okhttp.NegotiationType.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$grpc$okhttp$NegotiationType[io.grpc.okhttp.NegotiationType.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum NegotiationType {
        TLS,
        PLAINTEXT
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class OkHttpChannelDefaultPortProvider implements ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider {
        private OkHttpChannelDefaultPortProvider() {
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider
        public int getDefaultPort() {
            return OkHttpChannelBuilder.this.getDefaultPort();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class OkHttpChannelTransportFactoryBuilder implements ManagedChannelImplBuilder.ClientTransportFactoryBuilder {
        private OkHttpChannelTransportFactoryBuilder() {
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
        public ClientTransportFactory buildClientTransportFactory() {
            return OkHttpChannelBuilder.this.buildTransportFactory();
        }
    }

    @Internal
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class OkHttpTransportFactory implements ClientTransportFactory {
        private boolean closed;
        public final ConnectionSpec connectionSpec;
        private final boolean enableKeepAlive;
        public final Executor executor;
        private final ObjectPool<Executor> executorPool;
        public final int flowControlWindow;
        public final HostnameVerifier hostnameVerifier;
        private final AtomicBackoff keepAliveBackoff;
        private final long keepAliveTimeNanos;
        private final long keepAliveTimeoutNanos;
        private final boolean keepAliveWithoutCalls;
        public final int maxInboundMetadataSize;
        public final int maxMessageSize;
        public final ScheduledExecutorService scheduledExecutorService;
        private final ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool;
        public final SocketFactory socketFactory;
        public final SSLSocketFactory sslSocketFactory;
        public final TransportTracer.Factory transportTracerFactory;
        public final boolean useGetForSafeMethods;

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.executorPool.returnObject(this.executor);
            this.scheduledExecutorServicePool.returnObject(this.scheduledExecutorService);
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ScheduledExecutorService getScheduledExecutorService() {
            return this.scheduledExecutorService;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportFactory.ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger) {
            if (!this.closed) {
                final AtomicBackoff.State state = this.keepAliveBackoff.getState();
                OkHttpClientTransport okHttpClientTransport = new OkHttpClientTransport(this, (InetSocketAddress) socketAddress, clientTransportOptions.getAuthority(), clientTransportOptions.getUserAgent(), clientTransportOptions.getEagAttributes(), clientTransportOptions.getHttpConnectProxiedSocketAddress(), new Runnable() { // from class: io.grpc.okhttp.OkHttpChannelBuilder.OkHttpTransportFactory.1
                    @Override // java.lang.Runnable
                    public void run() {
                        state.backoff();
                    }
                });
                if (this.enableKeepAlive) {
                    okHttpClientTransport.enableKeepAlive(true, state.get(), this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
                }
                return okHttpClientTransport;
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCredentials) {
            SslSocketFactoryResult sslSocketFactoryFrom = OkHttpChannelBuilder.sslSocketFactoryFrom(channelCredentials);
            if (sslSocketFactoryFrom.error != null) {
                return null;
            }
            return new ClientTransportFactory.SwapChannelCredentialsResult(new OkHttpTransportFactory(this.executorPool, this.scheduledExecutorServicePool, this.socketFactory, sslSocketFactoryFrom.factory, this.hostnameVerifier, this.connectionSpec, this.maxMessageSize, this.enableKeepAlive, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.flowControlWindow, this.keepAliveWithoutCalls, this.maxInboundMetadataSize, this.transportTracerFactory, this.useGetForSafeMethods), sslSocketFactoryFrom.callCredentials);
        }

        private OkHttpTransportFactory(ObjectPool<Executor> objectPool, ObjectPool<ScheduledExecutorService> objectPool2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ConnectionSpec connectionSpec, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, TransportTracer.Factory factory, boolean z12) {
            this.executorPool = objectPool;
            this.executor = objectPool.getObject();
            this.scheduledExecutorServicePool = objectPool2;
            this.scheduledExecutorService = objectPool2.getObject();
            this.socketFactory = socketFactory;
            this.sslSocketFactory = sSLSocketFactory;
            this.hostnameVerifier = hostnameVerifier;
            this.connectionSpec = connectionSpec;
            this.maxMessageSize = i10;
            this.enableKeepAlive = z10;
            this.keepAliveTimeNanos = j10;
            this.keepAliveBackoff = new AtomicBackoff("keepalive time nanos", j10);
            this.keepAliveTimeoutNanos = j11;
            this.flowControlWindow = i11;
            this.keepAliveWithoutCalls = z11;
            this.maxInboundMetadataSize = i12;
            this.useGetForSafeMethods = z12;
            this.transportTracerFactory = (TransportTracer.Factory) o.s(factory, "transportTracerFactory");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SslSocketFactoryResult {
        public final CallCredentials callCredentials;
        public final String error;
        public final SSLSocketFactory factory;

        private SslSocketFactoryResult(SSLSocketFactory sSLSocketFactory, CallCredentials callCredentials, String str) {
            this.factory = sSLSocketFactory;
            this.callCredentials = callCredentials;
            this.error = str;
        }

        public static SslSocketFactoryResult error(String str) {
            return new SslSocketFactoryResult(null, null, (String) o.s(str, "error"));
        }

        public static SslSocketFactoryResult factory(SSLSocketFactory sSLSocketFactory) {
            return new SslSocketFactoryResult((SSLSocketFactory) o.s(sSLSocketFactory, "factory"), null, null);
        }

        public static SslSocketFactoryResult plaintext() {
            return new SslSocketFactoryResult(null, null, null);
        }

        public SslSocketFactoryResult withCallCredentials(CallCredentials callCredentials) {
            o.s(callCredentials, "callCreds");
            if (this.error != null) {
                return this;
            }
            CallCredentials callCredentials2 = this.callCredentials;
            if (callCredentials2 != null) {
                callCredentials = new CompositeCallCredentials(callCredentials2, callCredentials);
            }
            return new SslSocketFactoryResult(this.factory, callCredentials, null);
        }
    }

    static {
        SharedResourceHolder.Resource<Executor> resource = new SharedResourceHolder.Resource<Executor>() { // from class: io.grpc.okhttp.OkHttpChannelBuilder.1
            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public void close(Executor executor) {
                ((ExecutorService) executor).shutdown();
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public Executor create() {
                return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-okhttp-%d", true));
            }
        };
        SHARED_EXECUTOR = resource;
        DEFAULT_TRANSPORT_EXECUTOR_POOL = SharedResourcePool.forResource(resource);
        understoodTlsFeatures = EnumSet.of(TlsChannelCredentials.Feature.MTLS, TlsChannelCredentials.Feature.CUSTOM_MANAGERS);
    }

    private OkHttpChannelBuilder(String str, int i10) {
        this(GrpcUtil.authorityFromHostAndPort(str, i10));
    }

    public static KeyManager[] createKeyManager(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            X509Certificate[] x509Certificates = CertificateUtils.getX509Certificates(byteArrayInputStream);
            GrpcUtil.closeQuietly(byteArrayInputStream);
            byteArrayInputStream = new ByteArrayInputStream(bArr2);
            try {
                try {
                    PrivateKey privateKey = CertificateUtils.getPrivateKey(byteArrayInputStream);
                    GrpcUtil.closeQuietly(byteArrayInputStream);
                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    try {
                        keyStore.load(null, null);
                        keyStore.setKeyEntry("key", privateKey, new char[0], x509Certificates);
                        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                        keyManagerFactory.init(keyStore, new char[0]);
                        return keyManagerFactory.getKeyManagers();
                    } catch (IOException e2) {
                        throw new GeneralSecurityException(e2);
                    }
                } finally {
                }
            } catch (IOException e10) {
                throw new GeneralSecurityException("Unable to decode private key", e10);
            }
        } finally {
        }
    }

    public static TrustManager[] createTrustManager(byte[] bArr) throws GeneralSecurityException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            keyStore.load(null, null);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                X509Certificate[] x509Certificates = CertificateUtils.getX509Certificates(byteArrayInputStream);
                GrpcUtil.closeQuietly(byteArrayInputStream);
                for (X509Certificate x509Certificate : x509Certificates) {
                    keyStore.setCertificateEntry(x509Certificate.getSubjectX500Principal().getName(X500Principal.RFC2253), x509Certificate);
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (Throwable th) {
                GrpcUtil.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (IOException e2) {
            throw new GeneralSecurityException(e2);
        }
    }

    public static OkHttpChannelBuilder forAddress(String str, int i10) {
        return new OkHttpChannelBuilder(str, i10);
    }

    public static OkHttpChannelBuilder forTarget(String str) {
        return new OkHttpChannelBuilder(str);
    }

    public static SslSocketFactoryResult sslSocketFactoryFrom(ChannelCredentials channelCredentials) {
        KeyManager[] keyManagerArr;
        TrustManager[] createTrustManager;
        if (channelCredentials instanceof TlsChannelCredentials) {
            TlsChannelCredentials tlsChannelCredentials = (TlsChannelCredentials) channelCredentials;
            Set<TlsChannelCredentials.Feature> incomprehensible = tlsChannelCredentials.incomprehensible(understoodTlsFeatures);
            if (!incomprehensible.isEmpty()) {
                return SslSocketFactoryResult.error("TLS features not understood: " + ((Object) incomprehensible));
            }
            if (tlsChannelCredentials.getKeyManagers() != null) {
                keyManagerArr = (KeyManager[]) tlsChannelCredentials.getKeyManagers().toArray(new KeyManager[0]);
            } else if (tlsChannelCredentials.getPrivateKey() == null) {
                keyManagerArr = null;
            } else {
                if (tlsChannelCredentials.getPrivateKeyPassword() != null) {
                    return SslSocketFactoryResult.error("byte[]-based private key with password unsupported. Use unencrypted file or KeyManager");
                }
                try {
                    keyManagerArr = createKeyManager(tlsChannelCredentials.getCertificateChain(), tlsChannelCredentials.getPrivateKey());
                } catch (GeneralSecurityException e2) {
                    log.log(Level.FINE, "Exception loading private key from credential", (Throwable) e2);
                    return SslSocketFactoryResult.error("Unable to load private key: " + e2.getMessage());
                }
            }
            if (tlsChannelCredentials.getTrustManagers() != null) {
                createTrustManager = (TrustManager[]) tlsChannelCredentials.getTrustManagers().toArray(new TrustManager[0]);
            } else if (tlsChannelCredentials.getRootCertificates() != null) {
                try {
                    createTrustManager = createTrustManager(tlsChannelCredentials.getRootCertificates());
                } catch (GeneralSecurityException e10) {
                    log.log(Level.FINE, "Exception loading root certificates from credential", (Throwable) e10);
                    return SslSocketFactoryResult.error("Unable to load root certificates: " + e10.getMessage());
                }
            } else {
                createTrustManager = null;
            }
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS", Platform.get().getProvider());
                sSLContext.init(keyManagerArr, createTrustManager, null);
                return SslSocketFactoryResult.factory(sSLContext.getSocketFactory());
            } catch (GeneralSecurityException e11) {
                throw new RuntimeException("TLS Provider failure", e11);
            }
        }
        if (channelCredentials instanceof InsecureChannelCredentials) {
            return SslSocketFactoryResult.plaintext();
        }
        if (channelCredentials instanceof CompositeChannelCredentials) {
            CompositeChannelCredentials compositeChannelCredentials = (CompositeChannelCredentials) channelCredentials;
            return sslSocketFactoryFrom(compositeChannelCredentials.getChannelCredentials()).withCallCredentials(compositeChannelCredentials.getCallCredentials());
        }
        if (channelCredentials instanceof SslSocketFactoryChannelCredentials.ChannelCredentials) {
            return SslSocketFactoryResult.factory(((SslSocketFactoryChannelCredentials.ChannelCredentials) channelCredentials).getFactory());
        }
        if (channelCredentials instanceof ChoiceChannelCredentials) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<ChannelCredentials> iterator2 = ((ChoiceChannelCredentials) channelCredentials).getCredentialsList().iterator2();
            while (iterator2.hasNext()) {
                SslSocketFactoryResult sslSocketFactoryFrom = sslSocketFactoryFrom(iterator2.next());
                if (sslSocketFactoryFrom.error == null) {
                    return sslSocketFactoryFrom;
                }
                sb2.append(", ");
                sb2.append(sslSocketFactoryFrom.error);
            }
            return SslSocketFactoryResult.error(sb2.substring(2));
        }
        return SslSocketFactoryResult.error("Unsupported credential type: " + channelCredentials.getClass().getName());
    }

    public OkHttpTransportFactory buildTransportFactory() {
        return new OkHttpTransportFactory(this.transportExecutorPool, this.scheduledExecutorServicePool, this.socketFactory, createSslSocketFactory(), this.hostnameVerifier, this.connectionSpec, this.maxInboundMessageSize, this.keepAliveTimeNanos != Long.MAX_VALUE, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.flowControlWindow, this.keepAliveWithoutCalls, this.maxInboundMetadataSize, this.transportTracerFactory, false);
    }

    public OkHttpChannelBuilder connectionSpec(com.squareup.okhttp.ConnectionSpec connectionSpec) {
        o.y(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        o.e(connectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
        this.connectionSpec = Utils.convertSpec(connectionSpec);
        return this;
    }

    public SSLSocketFactory createSslSocketFactory() {
        int i10 = AnonymousClass2.$SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[this.negotiationType.ordinal()];
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            try {
                if (this.sslSocketFactory == null) {
                    this.sslSocketFactory = SSLContext.getInstance("Default", Platform.get().getProvider()).getSocketFactory();
                }
                return this.sslSocketFactory;
            } catch (GeneralSecurityException e2) {
                throw new RuntimeException("TLS Provider failure", e2);
            }
        }
        throw new RuntimeException("Unknown negotiation type: " + ((Object) this.negotiationType));
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    @Internal
    public ManagedChannelBuilder<?> delegate() {
        return this.managedChannelImplBuilder;
    }

    public OkHttpChannelBuilder disableCheckAuthority() {
        this.managedChannelImplBuilder.disableCheckAuthority();
        return this;
    }

    public OkHttpChannelBuilder enableCheckAuthority() {
        this.managedChannelImplBuilder.enableCheckAuthority();
        return this;
    }

    public OkHttpChannelBuilder flowControlWindow(int i10) {
        o.y(i10 > 0, "flowControlWindow must be positive");
        this.flowControlWindow = i10;
        return this;
    }

    public int getDefaultPort() {
        int i10 = AnonymousClass2.$SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[this.negotiationType.ordinal()];
        if (i10 == 1) {
            return 80;
        }
        if (i10 == 2) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        throw new AssertionError((Object) (((Object) this.negotiationType) + " not handled"));
    }

    public OkHttpChannelBuilder hostnameVerifier(HostnameVerifier hostnameVerifier) {
        o.y(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    @Deprecated
    public OkHttpChannelBuilder negotiationType(io.grpc.okhttp.NegotiationType negotiationType) {
        o.y(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        o.s(negotiationType, "type");
        int i10 = AnonymousClass2.$SwitchMap$io$grpc$okhttp$NegotiationType[negotiationType.ordinal()];
        if (i10 == 1) {
            this.negotiationType = NegotiationType.TLS;
        } else if (i10 == 2) {
            this.negotiationType = NegotiationType.PLAINTEXT;
        } else {
            throw new AssertionError((Object) ("Unknown negotiation type: " + ((Object) negotiationType)));
        }
        return this;
    }

    public OkHttpChannelBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorServicePool = new FixedObjectPool((ScheduledExecutorService) o.s(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    public void setStatsEnabled(boolean z10) {
        this.managedChannelImplBuilder.setStatsEnabled(z10);
    }

    public OkHttpChannelBuilder setTransportTracerFactory(TransportTracer.Factory factory) {
        this.transportTracerFactory = factory;
        return this;
    }

    public OkHttpChannelBuilder socketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
        return this;
    }

    public OkHttpChannelBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        o.y(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        this.sslSocketFactory = sSLSocketFactory;
        this.negotiationType = NegotiationType.TLS;
        return this;
    }

    public OkHttpChannelBuilder tlsConnectionSpec(String[] strArr, String[] strArr2) {
        o.y(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        o.s(strArr, "tls versions must not null");
        o.s(strArr2, "ciphers must not null");
        this.connectionSpec = new ConnectionSpec.Builder(true).supportsTlsExtensions(true).tlsVersions(strArr).cipherSuites(strArr2).build();
        return this;
    }

    public OkHttpChannelBuilder transportExecutor(Executor executor) {
        if (executor == null) {
            this.transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
        } else {
            this.transportExecutorPool = new FixedObjectPool(executor);
        }
        return this;
    }

    private OkHttpChannelBuilder(String str) {
        this.transportTracerFactory = TransportTracer.getDefaultFactory();
        this.transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
        this.scheduledExecutorServicePool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
        this.connectionSpec = INTERNAL_DEFAULT_CONNECTION_SPEC;
        this.negotiationType = NegotiationType.TLS;
        this.keepAliveTimeNanos = Long.MAX_VALUE;
        this.keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
        this.flowControlWindow = 65535;
        this.maxInboundMetadataSize = Integer.MAX_VALUE;
        this.useGetForSafeMethods = false;
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(str, new OkHttpChannelTransportFactoryBuilder(), new OkHttpChannelDefaultPortProvider());
        this.freezeSecurityConfiguration = false;
    }

    public static OkHttpChannelBuilder forAddress(String str, int i10, ChannelCredentials channelCredentials) {
        return forTarget(GrpcUtil.authorityFromHostAndPort(str, i10), channelCredentials);
    }

    public static OkHttpChannelBuilder forTarget(String str, ChannelCredentials channelCredentials) {
        SslSocketFactoryResult sslSocketFactoryFrom = sslSocketFactoryFrom(channelCredentials);
        if (sslSocketFactoryFrom.error == null) {
            return new OkHttpChannelBuilder(str, channelCredentials, sslSocketFactoryFrom.callCredentials, sslSocketFactoryFrom.factory);
        }
        throw new IllegalArgumentException(sslSocketFactoryFrom.error);
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder keepAliveTime(long j10, TimeUnit timeUnit) {
        o.e(j10 > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j10);
        this.keepAliveTimeNanos = nanos;
        long clampKeepAliveTimeInNanos = KeepAliveManager.clampKeepAliveTimeInNanos(nanos);
        this.keepAliveTimeNanos = clampKeepAliveTimeInNanos;
        if (clampKeepAliveTimeInNanos >= AS_LARGE_AS_INFINITE) {
            this.keepAliveTimeNanos = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder keepAliveTimeout(long j10, TimeUnit timeUnit) {
        o.e(j10 > 0, "keepalive timeout must be positive");
        long nanos = timeUnit.toNanos(j10);
        this.keepAliveTimeoutNanos = nanos;
        this.keepAliveTimeoutNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(nanos);
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder keepAliveWithoutCalls(boolean z10) {
        this.keepAliveWithoutCalls = z10;
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder maxInboundMessageSize(int i10) {
        o.e(i10 >= 0, "negative max");
        this.maxInboundMessageSize = i10;
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder maxInboundMetadataSize(int i10) {
        o.e(i10 > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = i10;
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder usePlaintext() {
        o.y(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        this.negotiationType = NegotiationType.PLAINTEXT;
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder useTransportSecurity() {
        o.y(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        this.negotiationType = NegotiationType.TLS;
        return this;
    }

    public OkHttpChannelBuilder(String str, ChannelCredentials channelCredentials, CallCredentials callCredentials, SSLSocketFactory sSLSocketFactory) {
        this.transportTracerFactory = TransportTracer.getDefaultFactory();
        this.transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
        this.scheduledExecutorServicePool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
        this.connectionSpec = INTERNAL_DEFAULT_CONNECTION_SPEC;
        NegotiationType negotiationType = NegotiationType.TLS;
        this.negotiationType = negotiationType;
        this.keepAliveTimeNanos = Long.MAX_VALUE;
        this.keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
        this.flowControlWindow = 65535;
        this.maxInboundMetadataSize = Integer.MAX_VALUE;
        this.useGetForSafeMethods = false;
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(str, channelCredentials, callCredentials, new OkHttpChannelTransportFactoryBuilder(), new OkHttpChannelDefaultPortProvider());
        this.sslSocketFactory = sSLSocketFactory;
        this.negotiationType = sSLSocketFactory == null ? NegotiationType.PLAINTEXT : negotiationType;
        this.freezeSecurityConfiguration = true;
    }
}
