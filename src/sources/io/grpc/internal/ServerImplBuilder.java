package io.grpc.internal;

import com.google.common.base.o;
import com.google.common.util.concurrent.p;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.quickcard.base.Attributes;
import io.grpc.BinaryLog;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCallExecutorSupplier;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerStreamTracer;
import io.grpc.ServerTransportFilter;
import io.grpc.internal.CallTracer;
import io.grpc.internal.InternalHandlerRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServerImplBuilder extends ServerBuilder<ServerImplBuilder> {
    public BinaryLog binlog;
    private final ClientTransportServersBuilder clientTransportServersBuilder;
    public ServerCallExecutorSupplier executorSupplier;
    private static final Logger log = Logger.getLogger(ServerImplBuilder.class.getName());
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final HandlerRegistry DEFAULT_FALLBACK_REGISTRY = new DefaultFallbackRegistry();
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();
    private static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(120);
    public final InternalHandlerRegistry.Builder registryBuilder = new InternalHandlerRegistry.Builder();
    public final List<ServerTransportFilter> transportFilters = new ArrayList();
    public final List<ServerInterceptor> interceptors = new ArrayList();
    private final List<ServerStreamTracer.Factory> streamTracerFactories = new ArrayList();
    public HandlerRegistry fallbackRegistry = DEFAULT_FALLBACK_REGISTRY;
    public ObjectPool<? extends Executor> executorPool = DEFAULT_EXECUTOR_POOL;
    public DecompressorRegistry decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
    public CompressorRegistry compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
    public long handshakeTimeoutMillis = DEFAULT_HANDSHAKE_TIMEOUT_MILLIS;
    public Deadline.Ticker ticker = Deadline.getSystemTicker();
    private boolean statsEnabled = true;
    private boolean recordStartedRpcs = true;
    private boolean recordFinishedRpcs = true;
    private boolean recordRealTimeMetrics = false;
    private boolean tracingEnabled = true;
    public InternalChannelz channelz = InternalChannelz.instance();
    public CallTracer.Factory callTracerFactory = CallTracer.getDefaultFactory();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ClientTransportServersBuilder {
        InternalServer buildClientTransportServers(List<? extends ServerStreamTracer.Factory> list);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DefaultFallbackRegistry extends HandlerRegistry {
        private DefaultFallbackRegistry() {
        }

        @Override // io.grpc.HandlerRegistry
        public List<ServerServiceDefinition> getServices() {
            return Collections.emptyList();
        }

        @Override // io.grpc.HandlerRegistry
        public ServerMethodDefinition<?, ?> lookupMethod(String str, String str2) {
            return null;
        }
    }

    public ServerImplBuilder(ClientTransportServersBuilder clientTransportServersBuilder) {
        this.clientTransportServersBuilder = (ClientTransportServersBuilder) o.s(clientTransportServersBuilder, "clientTransportServersBuilder");
    }

    public static ServerBuilder<?> forPort(int i10) {
        throw new UnsupportedOperationException("ClientTransportServersBuilder is required, use a constructor");
    }

    @Override // io.grpc.ServerBuilder
    public Server build() {
        return new ServerImpl(this, this.clientTransportServersBuilder.buildClientTransportServers(getTracerFactories()), Context.ROOT);
    }

    public InternalChannelz getChannelz() {
        return this.channelz;
    }

    public ObjectPool<? extends Executor> getExecutorPool() {
        return this.executorPool;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<? extends io.grpc.ServerStreamTracer.Factory> getTracerFactories() {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ServerImplBuilder.getTracerFactories():java.util.List");
    }

    public void setDeadlineTicker(Deadline.Ticker ticker) {
        this.ticker = (Deadline.Ticker) o.s(ticker, RemoteMessageConst.Notification.TICKER);
    }

    public void setStatsEnabled(boolean z10) {
        this.statsEnabled = z10;
    }

    public void setStatsRecordFinishedRpcs(boolean z10) {
        this.recordFinishedRpcs = z10;
    }

    public void setStatsRecordRealTimeMetrics(boolean z10) {
        this.recordRealTimeMetrics = z10;
    }

    public void setStatsRecordStartedRpcs(boolean z10) {
        this.recordStartedRpcs = z10;
    }

    public void setTracingEnabled(boolean z10) {
        this.tracingEnabled = z10;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        this.streamTracerFactories.add((ServerStreamTracer.Factory) o.s(factory, "factory"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addTransportFilter(ServerTransportFilter serverTransportFilter) {
        this.transportFilters.add((ServerTransportFilter) o.s(serverTransportFilter, Attributes.Style.FILTER));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder callExecutor(ServerCallExecutorSupplier serverCallExecutorSupplier) {
        this.executorSupplier = (ServerCallExecutorSupplier) o.r(serverCallExecutorSupplier);
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder compressorRegistry(CompressorRegistry compressorRegistry) {
        if (compressorRegistry == null) {
            compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        }
        this.compressorRegistry = compressorRegistry;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        if (decompressorRegistry == null) {
            decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        }
        this.decompressorRegistry = decompressorRegistry;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder directExecutor() {
        return executor(p.a());
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder executor(Executor executor) {
        this.executorPool = executor != null ? new FixedObjectPool<>(executor) : DEFAULT_EXECUTOR_POOL;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder fallbackHandlerRegistry(HandlerRegistry handlerRegistry) {
        if (handlerRegistry == null) {
            handlerRegistry = DEFAULT_FALLBACK_REGISTRY;
        }
        this.fallbackRegistry = handlerRegistry;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder handshakeTimeout(long j10, TimeUnit timeUnit) {
        o.j(j10 > 0, "handshake timeout is %s, but must be positive", j10);
        this.handshakeTimeoutMillis = ((TimeUnit) o.s(timeUnit, "unit")).toMillis(j10);
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder intercept(ServerInterceptor serverInterceptor) {
        this.interceptors.add((ServerInterceptor) o.s(serverInterceptor, "interceptor"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder setBinaryLog(BinaryLog binaryLog) {
        this.binlog = binaryLog;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder useTransportSecurity(File file, File file2) {
        throw new UnsupportedOperationException("TLS not supported in ServerImplBuilder");
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addService(ServerServiceDefinition serverServiceDefinition) {
        this.registryBuilder.addService((ServerServiceDefinition) o.s(serverServiceDefinition, "service"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addService(BindableService bindableService) {
        return addService(((BindableService) o.s(bindableService, "bindableService")).bindService());
    }
}
