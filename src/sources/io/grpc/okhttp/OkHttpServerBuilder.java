package io.grpc.okhttp;

import android.view.textclassifier.TextClassifier;
import com.google.common.base.o;
import io.grpc.ChoiceServerCredentials;
import io.grpc.ExperimentalApi;
import io.grpc.ForwardingServerBuilder;
import io.grpc.InsecureServerCredentials;
import io.grpc.Internal;
import io.grpc.ServerBuilder;
import io.grpc.ServerCredentials;
import io.grpc.ServerStreamTracer;
import io.grpc.TlsServerCredentials;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InternalServer;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerImplBuilder;
import io.grpc.internal.SharedResourcePool;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.SslSocketFactoryServerCredentials;
import io.grpc.okhttp.internal.Platform;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1785")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class OkHttpServerBuilder extends ForwardingServerBuilder<OkHttpServerBuilder> {
    private static final long AS_LARGE_AS_INFINITE;
    private static final int DEFAULT_FLOW_CONTROL_WINDOW = 65535;
    private static final ObjectPool<Executor> DEFAULT_TRANSPORT_EXECUTOR_POOL;
    public static final long MAX_CONNECTION_AGE_GRACE_NANOS_INFINITE = Long.MAX_VALUE;
    public static final long MAX_CONNECTION_AGE_NANOS_DISABLED = Long.MAX_VALUE;
    public static final long MAX_CONNECTION_IDLE_NANOS_DISABLED = Long.MAX_VALUE;
    private static final long MIN_MAX_CONNECTION_AGE_NANO;
    private static final long MIN_MAX_CONNECTION_IDLE_NANO;
    private static final Logger log = Logger.getLogger(OkHttpServerBuilder.class.getName());
    private static final EnumSet<TlsServerCredentials.Feature> understoodTlsFeatures;
    public final HandshakerSocketFactory handshakerSocketFactory;
    public final SocketAddress listenAddress;
    public boolean permitKeepAliveWithoutCalls;
    public final ServerImplBuilder serverImplBuilder = new ServerImplBuilder(new ServerImplBuilder.ClientTransportServersBuilder() { // from class: io.grpc.okhttp.b
        @Override // io.grpc.internal.ServerImplBuilder.ClientTransportServersBuilder
        public final InternalServer buildClientTransportServers(List list) {
            return OkHttpServerBuilder.this.buildTransportServers(list);
        }
    });
    public TransportTracer.Factory transportTracerFactory = TransportTracer.getDefaultFactory();
    public ObjectPool<Executor> transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
    public ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
    public ServerSocketFactory socketFactory = ServerSocketFactory.getDefault();
    public long keepAliveTimeNanos = GrpcUtil.DEFAULT_SERVER_KEEPALIVE_TIME_NANOS;
    public long keepAliveTimeoutNanos = GrpcUtil.DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS;
    public int flowControlWindow = 65535;
    public int maxInboundMetadataSize = 8192;
    public int maxInboundMessageSize = 4194304;
    public long maxConnectionIdleInNanos = Long.MAX_VALUE;
    public long permitKeepAliveTimeInNanos = TimeUnit.MINUTES.toNanos(5);
    public long maxConnectionAgeInNanos = Long.MAX_VALUE;
    public long maxConnectionAgeGraceInNanos = Long.MAX_VALUE;

    /* renamed from: io.grpc.okhttp.OkHttpServerBuilder$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$grpc$TlsServerCredentials$ClientAuth;

        static {
            int[] iArr = new int[TlsServerCredentials.ClientAuth.values().length];
            $SwitchMap$io$grpc$TlsServerCredentials$ClientAuth = iArr;
            try {
                iArr[TlsServerCredentials.ClientAuth.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$TlsServerCredentials$ClientAuth[TlsServerCredentials.ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$TlsServerCredentials$ClientAuth[TlsServerCredentials.ClientAuth.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ClientCertRequestingSocketFactory extends SSLSocketFactory {
        private final boolean required;
        private final SSLSocketFactory socketFactory;

        public ClientCertRequestingSocketFactory(SSLSocketFactory sSLSocketFactory, boolean z10) {
            this.socketFactory = (SSLSocketFactory) o.s(sSLSocketFactory, "socketFactory");
            this.required = z10;
        }

        private Socket apply(Socket socket) throws IOException {
            if (socket instanceof SSLSocket) {
                SSLSocket sSLSocket = (SSLSocket) socket;
                if (this.required) {
                    sSLSocket.setNeedClientAuth(true);
                } else {
                    sSLSocket.setWantClientAuth(true);
                }
                return sSLSocket;
            }
            throw new IOException("SocketFactory " + ((Object) this.socketFactory) + " did not produce an SSLSocket: " + ((Object) socket.getClass()));
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
            return apply(this.socketFactory.createSocket(socket, str, i10, z10));
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return this.socketFactory.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return this.socketFactory.getSupportedCipherSuites();
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i10) throws IOException {
            return apply(this.socketFactory.createSocket(str, i10));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException {
            return apply(this.socketFactory.createSocket(str, i10, inetAddress, i11));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
            return apply(this.socketFactory.createSocket(inetAddress, i10));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
            return apply(this.socketFactory.createSocket(inetAddress, i10, inetAddress2, i11));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class HandshakerSocketFactoryResult {
        public final String error;
        public final HandshakerSocketFactory factory;

        private HandshakerSocketFactoryResult(HandshakerSocketFactory handshakerSocketFactory, String str) {
            this.factory = handshakerSocketFactory;
            this.error = str;
        }

        public static HandshakerSocketFactoryResult error(String str) {
            return new HandshakerSocketFactoryResult(null, (String) o.s(str, "error"));
        }

        public static HandshakerSocketFactoryResult factory(HandshakerSocketFactory handshakerSocketFactory) {
            return new HandshakerSocketFactoryResult((HandshakerSocketFactory) o.s(handshakerSocketFactory, "factory"), null);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        MIN_MAX_CONNECTION_IDLE_NANO = timeUnit.toNanos(1L);
        MIN_MAX_CONNECTION_AGE_NANO = timeUnit.toNanos(1L);
        AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000L);
        DEFAULT_TRANSPORT_EXECUTOR_POOL = OkHttpChannelBuilder.DEFAULT_TRANSPORT_EXECUTOR_POOL;
        understoodTlsFeatures = EnumSet.of(TlsServerCredentials.Feature.MTLS, TlsServerCredentials.Feature.CUSTOM_MANAGERS);
    }

    public OkHttpServerBuilder(SocketAddress socketAddress, HandshakerSocketFactory handshakerSocketFactory) {
        this.listenAddress = (SocketAddress) o.s(socketAddress, TextClassifier.TYPE_ADDRESS);
        this.handshakerSocketFactory = (HandshakerSocketFactory) o.s(handshakerSocketFactory, "handshakerSocketFactory");
    }

    @Deprecated
    public static OkHttpServerBuilder forPort(int i10) {
        throw new UnsupportedOperationException();
    }

    public static HandshakerSocketFactoryResult handshakerSocketFactoryFrom(ServerCredentials serverCredentials) {
        KeyManager[] keyManagerArr;
        TrustManager[] createTrustManager;
        ClientCertRequestingSocketFactory clientCertRequestingSocketFactory;
        if (serverCredentials instanceof TlsServerCredentials) {
            TlsServerCredentials tlsServerCredentials = (TlsServerCredentials) serverCredentials;
            Set<TlsServerCredentials.Feature> incomprehensible = tlsServerCredentials.incomprehensible(understoodTlsFeatures);
            if (!incomprehensible.isEmpty()) {
                return HandshakerSocketFactoryResult.error("TLS features not understood: " + ((Object) incomprehensible));
            }
            if (tlsServerCredentials.getKeyManagers() != null) {
                keyManagerArr = (KeyManager[]) tlsServerCredentials.getKeyManagers().toArray(new KeyManager[0]);
            } else if (tlsServerCredentials.getPrivateKey() == null) {
                keyManagerArr = null;
            } else {
                if (tlsServerCredentials.getPrivateKeyPassword() != null) {
                    return HandshakerSocketFactoryResult.error("byte[]-based private key with password unsupported. Use unencrypted file or KeyManager");
                }
                try {
                    keyManagerArr = OkHttpChannelBuilder.createKeyManager(tlsServerCredentials.getCertificateChain(), tlsServerCredentials.getPrivateKey());
                } catch (GeneralSecurityException e2) {
                    log.log(Level.FINE, "Exception loading private key from credential", (Throwable) e2);
                    return HandshakerSocketFactoryResult.error("Unable to load private key: " + e2.getMessage());
                }
            }
            if (tlsServerCredentials.getTrustManagers() != null) {
                createTrustManager = (TrustManager[]) tlsServerCredentials.getTrustManagers().toArray(new TrustManager[0]);
            } else if (tlsServerCredentials.getRootCertificates() != null) {
                try {
                    createTrustManager = OkHttpChannelBuilder.createTrustManager(tlsServerCredentials.getRootCertificates());
                } catch (GeneralSecurityException e10) {
                    log.log(Level.FINE, "Exception loading root certificates from credential", (Throwable) e10);
                    return HandshakerSocketFactoryResult.error("Unable to load root certificates: " + e10.getMessage());
                }
            } else {
                createTrustManager = null;
            }
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS", Platform.get().getProvider());
                sSLContext.init(keyManagerArr, createTrustManager, null);
                SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                int i10 = AnonymousClass1.$SwitchMap$io$grpc$TlsServerCredentials$ClientAuth[tlsServerCredentials.getClientAuth().ordinal()];
                if (i10 == 1) {
                    clientCertRequestingSocketFactory = new ClientCertRequestingSocketFactory(socketFactory, false);
                } else if (i10 == 2) {
                    clientCertRequestingSocketFactory = new ClientCertRequestingSocketFactory(socketFactory, true);
                } else {
                    if (i10 != 3) {
                        return HandshakerSocketFactoryResult.error("Unknown TlsServerCredentials.ClientAuth value: " + ((Object) tlsServerCredentials.getClientAuth()));
                    }
                    return HandshakerSocketFactoryResult.factory(new TlsServerHandshakerSocketFactory(new SslSocketFactoryServerCredentials.ServerCredentials(socketFactory)));
                }
                socketFactory = clientCertRequestingSocketFactory;
                return HandshakerSocketFactoryResult.factory(new TlsServerHandshakerSocketFactory(new SslSocketFactoryServerCredentials.ServerCredentials(socketFactory)));
            } catch (GeneralSecurityException e11) {
                throw new RuntimeException("TLS Provider failure", e11);
            }
        }
        if (serverCredentials instanceof InsecureServerCredentials) {
            return HandshakerSocketFactoryResult.factory(new PlaintextHandshakerSocketFactory());
        }
        if (serverCredentials instanceof SslSocketFactoryServerCredentials.ServerCredentials) {
            return HandshakerSocketFactoryResult.factory(new TlsServerHandshakerSocketFactory((SslSocketFactoryServerCredentials.ServerCredentials) serverCredentials));
        }
        if (serverCredentials instanceof ChoiceServerCredentials) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<ServerCredentials> iterator2 = ((ChoiceServerCredentials) serverCredentials).getCredentialsList().iterator2();
            while (iterator2.hasNext()) {
                HandshakerSocketFactoryResult handshakerSocketFactoryFrom = handshakerSocketFactoryFrom(iterator2.next());
                if (handshakerSocketFactoryFrom.error == null) {
                    return handshakerSocketFactoryFrom;
                }
                sb2.append(", ");
                sb2.append(handshakerSocketFactoryFrom.error);
            }
            return HandshakerSocketFactoryResult.error(sb2.substring(2));
        }
        return HandshakerSocketFactoryResult.error("Unsupported credential type: " + serverCredentials.getClass().getName());
    }

    public InternalServer buildTransportServers(List<? extends ServerStreamTracer.Factory> list) {
        return new OkHttpServer(this, list, this.serverImplBuilder.getChannelz());
    }

    @Override // io.grpc.ForwardingServerBuilder
    @Internal
    public ServerBuilder<?> delegate() {
        return this.serverImplBuilder;
    }

    public OkHttpServerBuilder flowControlWindow(int i10) {
        o.y(i10 > 0, "flowControlWindow must be positive");
        this.flowControlWindow = i10;
        return this;
    }

    public OkHttpServerBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorServicePool = new FixedObjectPool((ScheduledExecutorService) o.s(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    public void setStatsEnabled(boolean z10) {
        this.serverImplBuilder.setStatsEnabled(z10);
    }

    public OkHttpServerBuilder setTransportTracerFactory(TransportTracer.Factory factory) {
        this.transportTracerFactory = factory;
        return this;
    }

    public OkHttpServerBuilder socketFactory(ServerSocketFactory serverSocketFactory) {
        if (serverSocketFactory == null) {
            this.socketFactory = ServerSocketFactory.getDefault();
        } else {
            this.socketFactory = serverSocketFactory;
        }
        return this;
    }

    public OkHttpServerBuilder transportExecutor(Executor executor) {
        if (executor == null) {
            this.transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
        } else {
            this.transportExecutorPool = new FixedObjectPool(executor);
        }
        return this;
    }

    public static OkHttpServerBuilder forPort(int i10, ServerCredentials serverCredentials) {
        return forPort(new InetSocketAddress(i10), serverCredentials);
    }

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder keepAliveTime(long j10, TimeUnit timeUnit) {
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

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder keepAliveTimeout(long j10, TimeUnit timeUnit) {
        o.e(j10 > 0, "keepalive timeout must be positive");
        long nanos = timeUnit.toNanos(j10);
        this.keepAliveTimeoutNanos = nanos;
        this.keepAliveTimeoutNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(nanos);
        return this;
    }

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder maxConnectionAge(long j10, TimeUnit timeUnit) {
        o.j(j10 > 0, "max connection age must be positive: %s", j10);
        long nanos = timeUnit.toNanos(j10);
        this.maxConnectionAgeInNanos = nanos;
        if (nanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionAgeInNanos = Long.MAX_VALUE;
        }
        long j11 = this.maxConnectionAgeInNanos;
        long j12 = MIN_MAX_CONNECTION_AGE_NANO;
        if (j11 < j12) {
            this.maxConnectionAgeInNanos = j12;
        }
        return this;
    }

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder maxConnectionAgeGrace(long j10, TimeUnit timeUnit) {
        o.j(j10 >= 0, "max connection age grace must be non-negative: %s", j10);
        long nanos = timeUnit.toNanos(j10);
        this.maxConnectionAgeGraceInNanos = nanos;
        if (nanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionAgeGraceInNanos = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder maxConnectionIdle(long j10, TimeUnit timeUnit) {
        o.j(j10 > 0, "max connection idle must be positive: %s", j10);
        long nanos = timeUnit.toNanos(j10);
        this.maxConnectionIdleInNanos = nanos;
        if (nanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionIdleInNanos = Long.MAX_VALUE;
        }
        long j11 = this.maxConnectionIdleInNanos;
        long j12 = MIN_MAX_CONNECTION_IDLE_NANO;
        if (j11 < j12) {
            this.maxConnectionIdleInNanos = j12;
        }
        return this;
    }

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder maxInboundMessageSize(int i10) {
        o.e(i10 >= 0, "negative max bytes");
        this.maxInboundMessageSize = i10;
        return this;
    }

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder maxInboundMetadataSize(int i10) {
        o.e(i10 > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = i10;
        return this;
    }

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder permitKeepAliveTime(long j10, TimeUnit timeUnit) {
        o.j(j10 >= 0, "permit keepalive time must be non-negative: %s", j10);
        this.permitKeepAliveTimeInNanos = timeUnit.toNanos(j10);
        return this;
    }

    @Override // io.grpc.ForwardingServerBuilder, io.grpc.ServerBuilder
    public OkHttpServerBuilder permitKeepAliveWithoutCalls(boolean z10) {
        this.permitKeepAliveWithoutCalls = z10;
        return this;
    }

    public static OkHttpServerBuilder forPort(SocketAddress socketAddress, ServerCredentials serverCredentials) {
        HandshakerSocketFactoryResult handshakerSocketFactoryFrom = handshakerSocketFactoryFrom(serverCredentials);
        if (handshakerSocketFactoryFrom.error == null) {
            return new OkHttpServerBuilder(socketAddress, handshakerSocketFactoryFrom.factory);
        }
        throw new IllegalArgumentException(handshakerSocketFactoryFrom.error);
    }
}
