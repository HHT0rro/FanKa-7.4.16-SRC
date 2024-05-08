package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.o;
import com.google.common.base.r;
import com.google.common.base.t;
import com.google.common.util.concurrent.n;
import com.huawei.quickcard.base.Attributes;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ClientStreamTracer;
import io.grpc.CompressorRegistry;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.ForwardingChannelBuilder;
import io.grpc.ForwardingClientCall;
import io.grpc.Grpc;
import io.grpc.InternalChannelz;
import io.grpc.InternalConfigSelector;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.AutoConfiguredLoadBalancerFactory;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.CallTracer;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ExponentialBackoffPolicy;
import io.grpc.internal.InternalSubchannel;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.ManagedChannelServiceConfig;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.RetriableStream;
import io.grpc.internal.RetryingNameResolver;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ManagedChannelImpl extends ManagedChannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    private static final ManagedChannelServiceConfig EMPTY_SERVICE_CONFIG;
    public static final long IDLE_TIMEOUT_MILLIS_DISABLE = -1;
    private static final InternalConfigSelector INITIAL_PENDING_SELECTOR;
    private static final ClientCall<Object, Object> NOOP_CALL;
    public static final Status SHUTDOWN_NOW_STATUS;
    public static final Status SHUTDOWN_STATUS;
    public static final long SUBCHANNEL_SHUTDOWN_DELAY_SECONDS = 5;
    public static final Status SUBCHANNEL_SHUTDOWN_STATUS;
    private final String authorityOverride;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    private final ExecutorHolder balancerRpcExecutorHolder;
    private final ObjectPool<? extends Executor> balancerRpcExecutorPool;
    private final CallTracer.Factory callTracerFactory;
    private final long channelBufferLimit;
    private final RetriableStream.ChannelBufferMeter channelBufferUsed;
    private final CallTracer channelCallTracer;
    private final ChannelLogger channelLogger;
    private final ConnectivityStateManager channelStateManager;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;
    private final ManagedChannelServiceConfig defaultServiceConfig;
    private final DelayedClientTransport delayedTransport;
    private final ManagedClientTransport.Listener delayedTransportListener;
    private final Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private boolean fullStreamDecompression;
    private final long idleTimeoutMillis;
    private final Rescheduler idleTimer;
    public final InUseStateAggregator<Object> inUseStateAggregator;
    private final Channel interceptorChannel;
    private ResolutionState lastResolutionState;
    private ManagedChannelServiceConfig lastServiceConfig;
    private LbHelperImpl lbHelper;
    private final AutoConfiguredLoadBalancerFactory loadBalancerFactory;
    private final InternalLogId logId;
    private final boolean lookUpServiceConfig;
    private final int maxTraceEvents;
    private NameResolver nameResolver;
    private final NameResolver.Args nameResolverArgs;
    private final NameResolver.Factory nameResolverFactory;
    private final NameResolverRegistry nameResolverRegistry;
    private boolean nameResolverStarted;
    private final ExecutorHolder offloadExecutorHolder;
    private final Set<OobChannel> oobChannels;
    private final ClientTransportFactory oobTransportFactory;
    private final ChannelCredentials originalChannelCreds;
    private final ClientTransportFactory originalTransportFactory;
    private boolean panicMode;
    private Collection<RealChannel.PendingCall<?, ?>> pendingCalls;
    private final Object pendingCallsInUseObject;
    private final long perRpcBufferLimit;
    private final RealChannel realChannel;
    private final boolean retryEnabled;
    private final RestrictedScheduledExecutor scheduledExecutor;
    private boolean serviceConfigUpdated;
    private final AtomicBoolean shutdown;
    private boolean shutdownNowed;
    private final t<r> stopwatchSupplier;
    private volatile LoadBalancer.SubchannelPicker subchannelPicker;
    private final Set<InternalSubchannel> subchannels;
    public final SynchronizationContext syncContext;
    private final String target;
    private volatile boolean terminated;
    private final CountDownLatch terminatedLatch;
    private boolean terminating;
    private final TimeProvider timeProvider;
    private final ClientTransportFactory transportFactory;
    private final ChannelStreamProvider transportProvider;
    private final UncommittedRetriableStreamsRegistry uncommittedRetriableStreamsRegistry;
    private final String userAgent;
    public static final Logger logger = Logger.getLogger(ManagedChannelImpl.class.getName());
    public static final Pattern URI_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class ChannelStreamProvider implements ClientCallImpl.ClientStreamProvider {
        public volatile RetriableStream.Throttle throttle;

        private ChannelStreamProvider() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ClientTransport getTransport(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            LoadBalancer.SubchannelPicker subchannelPicker = ManagedChannelImpl.this.subchannelPicker;
            if (ManagedChannelImpl.this.shutdown.get()) {
                return ManagedChannelImpl.this.delayedTransport;
            }
            if (subchannelPicker == null) {
                ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.ChannelStreamProvider.1ExitIdleModeForTransport
                    @Override // java.lang.Runnable
                    public void run() {
                        ManagedChannelImpl.this.exitIdleMode();
                    }
                });
                return ManagedChannelImpl.this.delayedTransport;
            }
            ClientTransport transportFromPickResult = GrpcUtil.getTransportFromPickResult(subchannelPicker.pickSubchannel(pickSubchannelArgs), pickSubchannelArgs.getCallOptions().isWaitForReady());
            return transportFromPickResult != null ? transportFromPickResult : ManagedChannelImpl.this.delayedTransport;
        }

        @Override // io.grpc.internal.ClientCallImpl.ClientStreamProvider
        public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context) {
            if (!ManagedChannelImpl.this.retryEnabled) {
                ClientTransport transport = getTransport(new PickSubchannelArgsImpl(methodDescriptor, metadata, callOptions));
                Context attach = context.attach();
                try {
                    return transport.newStream(methodDescriptor, metadata, callOptions, GrpcUtil.getClientStreamTracers(callOptions, metadata, 0, false));
                } finally {
                    context.detach(attach);
                }
            }
            ManagedChannelServiceConfig.MethodInfo methodInfo = (ManagedChannelServiceConfig.MethodInfo) callOptions.getOption(ManagedChannelServiceConfig.MethodInfo.KEY);
            return new RetriableStream<ReqT>(methodDescriptor, metadata, callOptions, methodInfo == null ? null : methodInfo.retryPolicy, methodInfo != null ? methodInfo.hedgingPolicy : null, context) { // from class: io.grpc.internal.ManagedChannelImpl.ChannelStreamProvider.1RetryStream
                public final /* synthetic */ CallOptions val$callOptions;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ Metadata val$headers;
                public final /* synthetic */ HedgingPolicy val$hedgingPolicy;
                public final /* synthetic */ MethodDescriptor val$method;
                public final /* synthetic */ RetryPolicy val$retryPolicy;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(methodDescriptor, metadata, ManagedChannelImpl.this.channelBufferUsed, ManagedChannelImpl.this.perRpcBufferLimit, ManagedChannelImpl.this.channelBufferLimit, ManagedChannelImpl.this.getCallExecutor(callOptions), ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), r20, r21, ChannelStreamProvider.this.throttle);
                    this.val$method = methodDescriptor;
                    this.val$headers = metadata;
                    this.val$callOptions = callOptions;
                    this.val$retryPolicy = r20;
                    this.val$hedgingPolicy = r21;
                    this.val$context = context;
                }

                @Override // io.grpc.internal.RetriableStream
                public ClientStream newSubstream(Metadata metadata2, ClientStreamTracer.Factory factory, int i10, boolean z10) {
                    CallOptions withStreamTracerFactory = this.val$callOptions.withStreamTracerFactory(factory);
                    ClientStreamTracer[] clientStreamTracers = GrpcUtil.getClientStreamTracers(withStreamTracerFactory, metadata2, i10, z10);
                    ClientTransport transport2 = ChannelStreamProvider.this.getTransport(new PickSubchannelArgsImpl(this.val$method, metadata2, withStreamTracerFactory));
                    Context attach2 = this.val$context.attach();
                    try {
                        return transport2.newStream(this.val$method, metadata2, withStreamTracerFactory, clientStreamTracers);
                    } finally {
                        this.val$context.detach(attach2);
                    }
                }

                @Override // io.grpc.internal.RetriableStream
                public void postCommit() {
                    ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.remove(this);
                }

                @Override // io.grpc.internal.RetriableStream
                public Status prestart() {
                    return ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.add(this);
                }
            };
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ConfigSelectingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private final Executor callExecutor;
        private CallOptions callOptions;
        private final Channel channel;
        private final InternalConfigSelector configSelector;
        private final Context context;
        private ClientCall<ReqT, RespT> delegate;
        private final MethodDescriptor<ReqT, RespT> method;

        public ConfigSelectingClientCall(InternalConfigSelector internalConfigSelector, Channel channel, Executor executor, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            this.configSelector = internalConfigSelector;
            this.channel = channel;
            this.method = methodDescriptor;
            executor = callOptions.getExecutor() != null ? callOptions.getExecutor() : executor;
            this.callExecutor = executor;
            this.callOptions = callOptions.withExecutor(executor);
            this.context = Context.current();
        }

        private void executeCloseObserverInContext(final ClientCall.Listener<RespT> listener, final Status status) {
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ManagedChannelImpl.ConfigSelectingClientCall.1CloseInContext
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ConfigSelectingClientCall.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    listener.onClose(status, new Metadata());
                }
            });
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
            ClientCall<ReqT, RespT> clientCall = this.delegate;
            if (clientCall != null) {
                clientCall.cancel(str, th);
            }
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        public ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
        public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
            InternalConfigSelector.Result selectConfig = this.configSelector.selectConfig(new PickSubchannelArgsImpl(this.method, metadata, this.callOptions));
            Status status = selectConfig.getStatus();
            if (!status.isOk()) {
                executeCloseObserverInContext(listener, GrpcUtil.replaceInappropriateControlPlaneStatus(status));
                this.delegate = ManagedChannelImpl.NOOP_CALL;
                return;
            }
            ClientInterceptor interceptor = selectConfig.getInterceptor();
            ManagedChannelServiceConfig.MethodInfo methodConfig = ((ManagedChannelServiceConfig) selectConfig.getConfig()).getMethodConfig(this.method);
            if (methodConfig != null) {
                this.callOptions = this.callOptions.withOption(ManagedChannelServiceConfig.MethodInfo.KEY, methodConfig);
            }
            if (interceptor != null) {
                this.delegate = interceptor.interceptCall(this.method, this.callOptions, this.channel);
            } else {
                this.delegate = this.channel.newCall(this.method, this.callOptions);
            }
            this.delegate.start(listener, metadata);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class DelayedTransportListener implements ManagedClientTransport.Listener {
        private DelayedTransportListener() {
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportInUse(boolean z10) {
            ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
            managedChannelImpl.inUseStateAggregator.updateObjectInUse(managedChannelImpl.delayedTransport, z10);
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportReady() {
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportShutdown(Status status) {
            o.y(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportTerminated() {
            o.y(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
            ManagedChannelImpl.this.terminating = true;
            ManagedChannelImpl.this.shutdownNameResolverAndLoadBalancer(false);
            ManagedChannelImpl.this.maybeShutdownNowSubchannels();
            ManagedChannelImpl.this.maybeTerminateChannel();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ExecutorHolder implements Executor {
        private Executor executor;
        private final ObjectPool<? extends Executor> pool;

        public ExecutorHolder(ObjectPool<? extends Executor> objectPool) {
            this.pool = (ObjectPool) o.s(objectPool, "executorPool");
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            getExecutor().execute(runnable);
        }

        public synchronized Executor getExecutor() {
            if (this.executor == null) {
                this.executor = (Executor) o.t(this.pool.getObject(), "%s.getObject()", this.executor);
            }
            return this.executor;
        }

        public synchronized void release() {
            Executor executor = this.executor;
            if (executor != null) {
                this.executor = this.pool.returnObject(executor);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class IdleModeStateAggregator extends InUseStateAggregator<Object> {
        private IdleModeStateAggregator() {
        }

        @Override // io.grpc.internal.InUseStateAggregator
        public void handleInUse() {
            ManagedChannelImpl.this.exitIdleMode();
        }

        @Override // io.grpc.internal.InUseStateAggregator
        public void handleNotInUse() {
            if (ManagedChannelImpl.this.shutdown.get()) {
                return;
            }
            ManagedChannelImpl.this.rescheduleIdleTimer();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class IdleModeTimer implements Runnable {
        private IdleModeTimer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ManagedChannelImpl.this.lbHelper == null) {
                return;
            }
            ManagedChannelImpl.this.enterIdleMode();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class LbHelperImpl extends LoadBalancer.Helper {

        /* renamed from: lb, reason: collision with root package name */
        public AutoConfiguredLoadBalancerFactory.AutoConfiguredLoadBalancer f50071lb;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class DefaultChannelCreds extends ChannelCredentials {
            public DefaultChannelCreds() {
            }

            @Override // io.grpc.ChannelCredentials
            public ChannelCredentials withoutBearerTokens() {
                return this;
            }
        }

        private LbHelperImpl() {
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str) {
            return createOobChannel(Collections.singletonList(equivalentAddressGroup), str);
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [io.grpc.ManagedChannelBuilder, io.grpc.ManagedChannelBuilder<?>] */
        @Override // io.grpc.LoadBalancer.Helper
        @Deprecated
        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String str) {
            return createResolvingOobChannelBuilder(str, new DefaultChannelCreds()).overrideAuthority(getAuthority());
        }

        @Override // io.grpc.LoadBalancer.Helper
        public String getAuthority() {
            return ManagedChannelImpl.this.authority();
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ChannelLogger getChannelLogger() {
            return ManagedChannelImpl.this.channelLogger;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public NameResolver.Args getNameResolverArgs() {
            return ManagedChannelImpl.this.nameResolverArgs;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public NameResolverRegistry getNameResolverRegistry() {
            return ManagedChannelImpl.this.nameResolverRegistry;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ScheduledExecutorService getScheduledExecutorService() {
            return ManagedChannelImpl.this.scheduledExecutor;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public SynchronizationContext getSynchronizationContext() {
            return ManagedChannelImpl.this.syncContext;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ChannelCredentials getUnsafeChannelCredentials() {
            if (ManagedChannelImpl.this.originalChannelCreds == null) {
                return new DefaultChannelCreds();
            }
            return ManagedChannelImpl.this.originalChannelCreds;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void refreshNameResolution() {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1LoadBalancerRefreshNameResolution
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelImpl.this.refreshNameResolution();
                }
            });
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void updateBalancingState(final ConnectivityState connectivityState, final LoadBalancer.SubchannelPicker subchannelPicker) {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            o.s(connectivityState, "newState");
            o.s(subchannelPicker, "newPicker");
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1UpdateBalancingState
                @Override // java.lang.Runnable
                public void run() {
                    LbHelperImpl lbHelperImpl = LbHelperImpl.this;
                    if (lbHelperImpl != ManagedChannelImpl.this.lbHelper) {
                        return;
                    }
                    ManagedChannelImpl.this.updateSubchannelPicker(subchannelPicker);
                    if (connectivityState != ConnectivityState.SHUTDOWN) {
                        ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering {0} state with picker: {1}", connectivityState, subchannelPicker);
                        ManagedChannelImpl.this.channelStateManager.gotoState(connectivityState);
                    }
                }
            });
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void updateOobChannelAddresses(ManagedChannel managedChannel, EquivalentAddressGroup equivalentAddressGroup) {
            updateOobChannelAddresses(managedChannel, Collections.singletonList(equivalentAddressGroup));
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ManagedChannel createOobChannel(List<EquivalentAddressGroup> list, String str) {
            o.y(!ManagedChannelImpl.this.terminated, "Channel is terminated");
            long currentTimeNanos = ManagedChannelImpl.this.timeProvider.currentTimeNanos();
            InternalLogId allocate = InternalLogId.allocate("OobChannel", (String) null);
            InternalLogId allocate2 = InternalLogId.allocate("Subchannel-OOB", str);
            ChannelTracer channelTracer = new ChannelTracer(allocate, ManagedChannelImpl.this.maxTraceEvents, currentTimeNanos, "OobChannel for " + ((Object) list));
            ObjectPool objectPool = ManagedChannelImpl.this.balancerRpcExecutorPool;
            ScheduledExecutorService scheduledExecutorService = ManagedChannelImpl.this.oobTransportFactory.getScheduledExecutorService();
            ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
            final OobChannel oobChannel = new OobChannel(str, objectPool, scheduledExecutorService, managedChannelImpl.syncContext, managedChannelImpl.callTracerFactory.create(), channelTracer, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.timeProvider);
            ChannelTracer channelTracer2 = ManagedChannelImpl.this.channelTracer;
            InternalChannelz.ChannelTrace.Event.Builder description = new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child OobChannel created");
            InternalChannelz.ChannelTrace.Event.Severity severity = InternalChannelz.ChannelTrace.Event.Severity.CT_INFO;
            channelTracer2.reportEvent(description.setSeverity(severity).setTimestampNanos(currentTimeNanos).setChannelRef(oobChannel).build());
            ChannelTracer channelTracer3 = new ChannelTracer(allocate2, ManagedChannelImpl.this.maxTraceEvents, currentTimeNanos, "Subchannel for " + ((Object) list));
            InternalSubchannel internalSubchannel = new InternalSubchannel(list, str, ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.oobTransportFactory, ManagedChannelImpl.this.oobTransportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.syncContext, new InternalSubchannel.Callback() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1ManagedOobChannelCallback
                @Override // io.grpc.internal.InternalSubchannel.Callback
                public void onStateChange(InternalSubchannel internalSubchannel2, ConnectivityStateInfo connectivityStateInfo) {
                    ManagedChannelImpl.this.handleInternalSubchannelState(connectivityStateInfo);
                    oobChannel.handleSubchannelStateChange(connectivityStateInfo);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                public void onTerminated(InternalSubchannel internalSubchannel2) {
                    ManagedChannelImpl.this.oobChannels.remove(oobChannel);
                    ManagedChannelImpl.this.channelz.removeSubchannel(internalSubchannel2);
                    oobChannel.handleSubchannelTerminated();
                    ManagedChannelImpl.this.maybeTerminateChannel();
                }
            }, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.callTracerFactory.create(), channelTracer3, allocate2, new ChannelLoggerImpl(channelTracer3, ManagedChannelImpl.this.timeProvider));
            channelTracer.reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child Subchannel created").setSeverity(severity).setTimestampNanos(currentTimeNanos).setSubchannelRef(internalSubchannel).build());
            ManagedChannelImpl.this.channelz.addSubchannel(oobChannel);
            ManagedChannelImpl.this.channelz.addSubchannel(internalSubchannel);
            oobChannel.setSubchannel(internalSubchannel);
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1AddOobChannel
                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.terminating) {
                        oobChannel.shutdown();
                    }
                    if (ManagedChannelImpl.this.terminated) {
                        return;
                    }
                    ManagedChannelImpl.this.oobChannels.add(oobChannel);
                }
            });
            return oobChannel;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public AbstractSubchannel createSubchannel(LoadBalancer.CreateSubchannelArgs createSubchannelArgs) {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            o.y(!ManagedChannelImpl.this.terminating, "Channel is being terminated");
            return new SubchannelImpl(createSubchannelArgs);
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void updateOobChannelAddresses(ManagedChannel managedChannel, List<EquivalentAddressGroup> list) {
            o.e(managedChannel instanceof OobChannel, "channel must have been returned from createOobChannel");
            ((OobChannel) managedChannel).updateAddresses(list);
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String str, ChannelCredentials channelCredentials) {
            o.s(channelCredentials, "channelCreds");
            o.y(!ManagedChannelImpl.this.terminated, "Channel is terminated");
            return new ForwardingChannelBuilder<C1ResolvingOobChannelBuilder>(channelCredentials, str) { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1ResolvingOobChannelBuilder
                public final ManagedChannelBuilder<?> delegate;
                public final /* synthetic */ ChannelCredentials val$channelCreds;
                public final /* synthetic */ String val$target;

                {
                    CallCredentials callCredentials;
                    final ClientTransportFactory clientTransportFactory;
                    this.val$channelCreds = channelCredentials;
                    this.val$target = str;
                    if (channelCredentials instanceof DefaultChannelCreds) {
                        clientTransportFactory = ManagedChannelImpl.this.originalTransportFactory;
                        callCredentials = null;
                    } else {
                        ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials = ManagedChannelImpl.this.originalTransportFactory.swapChannelCredentials(channelCredentials);
                        if (swapChannelCredentials == null) {
                            this.delegate = Grpc.newChannelBuilder(str, channelCredentials);
                            return;
                        } else {
                            ClientTransportFactory clientTransportFactory2 = swapChannelCredentials.transportFactory;
                            callCredentials = swapChannelCredentials.callCredentials;
                            clientTransportFactory = clientTransportFactory2;
                        }
                    }
                    this.delegate = new ManagedChannelImplBuilder(str, channelCredentials, callCredentials, new ManagedChannelImplBuilder.ClientTransportFactoryBuilder() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1ResolvingOobChannelBuilder.1
                        @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
                        public ClientTransportFactory buildClientTransportFactory() {
                            return clientTransportFactory;
                        }
                    }, new ManagedChannelImplBuilder.FixedPortProvider(ManagedChannelImpl.this.nameResolverArgs.getDefaultPort()));
                }

                @Override // io.grpc.ForwardingChannelBuilder
                public ManagedChannelBuilder<?> delegate() {
                    return this.delegate;
                }
            }.nameResolverFactory(ManagedChannelImpl.this.nameResolverFactory).executor(ManagedChannelImpl.this.executor).offloadExecutor(ManagedChannelImpl.this.offloadExecutorHolder.getExecutor()).maxTraceEvents(ManagedChannelImpl.this.maxTraceEvents).proxyDetector(ManagedChannelImpl.this.nameResolverArgs.getProxyDetector()).userAgent(ManagedChannelImpl.this.userAgent);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class NameResolverListener extends NameResolver.Listener2 {
        public final LbHelperImpl helper;
        public final NameResolver resolver;

        public NameResolverListener(LbHelperImpl lbHelperImpl, NameResolver nameResolver) {
            this.helper = (LbHelperImpl) o.s(lbHelperImpl, "helperImpl");
            this.resolver = (NameResolver) o.s(nameResolver, "resolver");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleErrorInSyncContext(Status status) {
            ManagedChannelImpl.logger.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{ManagedChannelImpl.this.getLogId(), status});
            ManagedChannelImpl.this.realChannel.onConfigError();
            ResolutionState resolutionState = ManagedChannelImpl.this.lastResolutionState;
            ResolutionState resolutionState2 = ResolutionState.ERROR;
            if (resolutionState != resolutionState2) {
                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.WARNING, "Failed to resolve name: {0}", status);
                ManagedChannelImpl.this.lastResolutionState = resolutionState2;
            }
            if (this.helper != ManagedChannelImpl.this.lbHelper) {
                return;
            }
            this.helper.f50071lb.handleNameResolutionError(status);
        }

        @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
        public void onError(final Status status) {
            o.e(!status.isOk(), "the error status must not be OK");
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.NameResolverListener.1NameResolverErrorHandler
                @Override // java.lang.Runnable
                public void run() {
                    NameResolverListener.this.handleErrorInSyncContext(status);
                }
            });
        }

        @Override // io.grpc.NameResolver.Listener2
        public void onResult(final NameResolver.ResolutionResult resolutionResult) {
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.NameResolverListener.1NamesResolved
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelServiceConfig managedChannelServiceConfig;
                    if (ManagedChannelImpl.this.nameResolver != NameResolverListener.this.resolver) {
                        return;
                    }
                    List<EquivalentAddressGroup> addresses = resolutionResult.getAddresses();
                    ChannelLogger channelLogger = ManagedChannelImpl.this.channelLogger;
                    ChannelLogger.ChannelLogLevel channelLogLevel = ChannelLogger.ChannelLogLevel.DEBUG;
                    channelLogger.log(channelLogLevel, "Resolved address: {0}, config={1}", addresses, resolutionResult.getAttributes());
                    ResolutionState resolutionState = ManagedChannelImpl.this.lastResolutionState;
                    ResolutionState resolutionState2 = ResolutionState.SUCCESS;
                    if (resolutionState != resolutionState2) {
                        ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Address resolved: {0}", addresses);
                        ManagedChannelImpl.this.lastResolutionState = resolutionState2;
                    }
                    NameResolver.ConfigOrError serviceConfig = resolutionResult.getServiceConfig();
                    RetryingNameResolver.ResolutionResultListener resolutionResultListener = (RetryingNameResolver.ResolutionResultListener) resolutionResult.getAttributes().get(RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY);
                    InternalConfigSelector internalConfigSelector = (InternalConfigSelector) resolutionResult.getAttributes().get(InternalConfigSelector.KEY);
                    ManagedChannelServiceConfig managedChannelServiceConfig2 = (serviceConfig == null || serviceConfig.getConfig() == null) ? null : (ManagedChannelServiceConfig) serviceConfig.getConfig();
                    Status error = serviceConfig != null ? serviceConfig.getError() : null;
                    if (!ManagedChannelImpl.this.lookUpServiceConfig) {
                        if (managedChannelServiceConfig2 != null) {
                            ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Service config from name resolver discarded by channel settings");
                        }
                        managedChannelServiceConfig = ManagedChannelImpl.this.defaultServiceConfig == null ? ManagedChannelImpl.EMPTY_SERVICE_CONFIG : ManagedChannelImpl.this.defaultServiceConfig;
                        if (internalConfigSelector != null) {
                            ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Config selector from name resolver discarded by channel settings");
                        }
                        ManagedChannelImpl.this.realChannel.updateConfigSelector(managedChannelServiceConfig.getDefaultConfigSelector());
                    } else {
                        if (managedChannelServiceConfig2 != null) {
                            if (internalConfigSelector != null) {
                                ManagedChannelImpl.this.realChannel.updateConfigSelector(internalConfigSelector);
                                if (managedChannelServiceConfig2.getDefaultConfigSelector() != null) {
                                    ManagedChannelImpl.this.channelLogger.log(channelLogLevel, "Method configs in service config will be discarded due to presence ofconfig-selector");
                                }
                            } else {
                                ManagedChannelImpl.this.realChannel.updateConfigSelector(managedChannelServiceConfig2.getDefaultConfigSelector());
                            }
                        } else if (ManagedChannelImpl.this.defaultServiceConfig != null) {
                            managedChannelServiceConfig2 = ManagedChannelImpl.this.defaultServiceConfig;
                            ManagedChannelImpl.this.realChannel.updateConfigSelector(managedChannelServiceConfig2.getDefaultConfigSelector());
                            ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Received no service config, using default service config");
                        } else if (error != null) {
                            if (!ManagedChannelImpl.this.serviceConfigUpdated) {
                                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Fallback to error due to invalid first service config without default config");
                                NameResolverListener.this.onError(serviceConfig.getError());
                                if (resolutionResultListener != null) {
                                    resolutionResultListener.resolutionAttempted(false);
                                    return;
                                }
                                return;
                            }
                            managedChannelServiceConfig2 = ManagedChannelImpl.this.lastServiceConfig;
                        } else {
                            managedChannelServiceConfig2 = ManagedChannelImpl.EMPTY_SERVICE_CONFIG;
                            ManagedChannelImpl.this.realChannel.updateConfigSelector(null);
                        }
                        if (!managedChannelServiceConfig2.equals(ManagedChannelImpl.this.lastServiceConfig)) {
                            ChannelLogger channelLogger2 = ManagedChannelImpl.this.channelLogger;
                            ChannelLogger.ChannelLogLevel channelLogLevel2 = ChannelLogger.ChannelLogLevel.INFO;
                            Object[] objArr = new Object[1];
                            objArr[0] = managedChannelServiceConfig2 == ManagedChannelImpl.EMPTY_SERVICE_CONFIG ? " to empty" : "";
                            channelLogger2.log(channelLogLevel2, "Service config changed{0}", objArr);
                            ManagedChannelImpl.this.lastServiceConfig = managedChannelServiceConfig2;
                            ManagedChannelImpl.this.transportProvider.throttle = managedChannelServiceConfig2.getRetryThrottling();
                        }
                        try {
                            ManagedChannelImpl.this.serviceConfigUpdated = true;
                        } catch (RuntimeException e2) {
                            ManagedChannelImpl.logger.log(Level.WARNING, "[" + ((Object) ManagedChannelImpl.this.getLogId()) + "] Unexpected exception from parsing service config", (Throwable) e2);
                        }
                        managedChannelServiceConfig = managedChannelServiceConfig2;
                    }
                    Attributes attributes = resolutionResult.getAttributes();
                    NameResolverListener nameResolverListener = NameResolverListener.this;
                    if (nameResolverListener.helper == ManagedChannelImpl.this.lbHelper) {
                        Attributes.Builder discard = attributes.toBuilder().discard(InternalConfigSelector.KEY);
                        Map<String, ?> healthCheckingConfig = managedChannelServiceConfig.getHealthCheckingConfig();
                        if (healthCheckingConfig != null) {
                            discard.set(LoadBalancer.ATTR_HEALTH_CHECKING_CONFIG, healthCheckingConfig).build();
                        }
                        boolean tryAcceptResolvedAddresses = NameResolverListener.this.helper.f50071lb.tryAcceptResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(addresses).setAttributes(discard.build()).setLoadBalancingPolicyConfig(managedChannelServiceConfig.getLoadBalancingConfig()).build());
                        if (resolutionResultListener != null) {
                            resolutionResultListener.resolutionAttempted(tryAcceptResolvedAddresses);
                        }
                    }
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class RealChannel extends Channel {
        private final String authority;
        private final Channel clientCallImplChannel;
        private final AtomicReference<InternalConfigSelector> configSelector;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class PendingCall<ReqT, RespT> extends DelayedClientCall<ReqT, RespT> {
            public final CallOptions callOptions;
            public final Context context;
            public final MethodDescriptor<ReqT, RespT> method;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public final class PendingCallRemoval implements Runnable {
                public PendingCallRemoval() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.pendingCalls != null) {
                        ManagedChannelImpl.this.pendingCalls.remove(PendingCall.this);
                        if (ManagedChannelImpl.this.pendingCalls.isEmpty()) {
                            ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
                            managedChannelImpl.inUseStateAggregator.updateObjectInUse(managedChannelImpl.pendingCallsInUseObject, false);
                            ManagedChannelImpl.this.pendingCalls = null;
                            if (ManagedChannelImpl.this.shutdown.get()) {
                                ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.onShutdown(ManagedChannelImpl.SHUTDOWN_STATUS);
                            }
                        }
                    }
                }
            }

            public PendingCall(Context context, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
                super(ManagedChannelImpl.this.getCallExecutor(callOptions), ManagedChannelImpl.this.scheduledExecutor, callOptions.getDeadline());
                this.context = context;
                this.method = methodDescriptor;
                this.callOptions = callOptions;
            }

            @Override // io.grpc.internal.DelayedClientCall
            public void callCancelled() {
                super.callCancelled();
                ManagedChannelImpl.this.syncContext.execute(new PendingCallRemoval());
            }

            public void reprocess() {
                Context attach = this.context.attach();
                try {
                    ClientCall<ReqT, RespT> newClientCall = RealChannel.this.newClientCall(this.method, this.callOptions);
                    this.context.detach(attach);
                    final Runnable call = setCall(newClientCall);
                    if (call == null) {
                        ManagedChannelImpl.this.syncContext.execute(new PendingCallRemoval());
                    } else {
                        ManagedChannelImpl.this.getCallExecutor(this.callOptions).execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.PendingCall.1
                            @Override // java.lang.Runnable
                            public void run() {
                                call.run();
                                PendingCall pendingCall = PendingCall.this;
                                ManagedChannelImpl.this.syncContext.execute(new PendingCallRemoval());
                            }
                        });
                    }
                } catch (Throwable th) {
                    this.context.detach(attach);
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <ReqT, RespT> ClientCall<ReqT, RespT> newClientCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            InternalConfigSelector internalConfigSelector = this.configSelector.get();
            if (internalConfigSelector == null) {
                return this.clientCallImplChannel.newCall(methodDescriptor, callOptions);
            }
            if (internalConfigSelector instanceof ManagedChannelServiceConfig.ServiceConfigConvertedSelector) {
                ManagedChannelServiceConfig.MethodInfo methodConfig = ((ManagedChannelServiceConfig.ServiceConfigConvertedSelector) internalConfigSelector).config.getMethodConfig(methodDescriptor);
                if (methodConfig != null) {
                    callOptions = callOptions.withOption(ManagedChannelServiceConfig.MethodInfo.KEY, methodConfig);
                }
                return this.clientCallImplChannel.newCall(methodDescriptor, callOptions);
            }
            return new ConfigSelectingClientCall(internalConfigSelector, this.clientCallImplChannel, ManagedChannelImpl.this.executor, methodDescriptor, callOptions);
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.authority;
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            if (this.configSelector.get() != ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                return newClientCall(methodDescriptor, callOptions);
            }
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelImpl.this.exitIdleMode();
                }
            });
            if (this.configSelector.get() != ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                return newClientCall(methodDescriptor, callOptions);
            }
            if (ManagedChannelImpl.this.shutdown.get()) {
                return new ClientCall<ReqT, RespT>() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.3
                    @Override // io.grpc.ClientCall
                    public void cancel(String str, Throwable th) {
                    }

                    @Override // io.grpc.ClientCall
                    public void halfClose() {
                    }

                    @Override // io.grpc.ClientCall
                    public void request(int i10) {
                    }

                    @Override // io.grpc.ClientCall
                    public void sendMessage(ReqT reqt) {
                    }

                    @Override // io.grpc.ClientCall
                    public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                        listener.onClose(ManagedChannelImpl.SHUTDOWN_STATUS, new Metadata());
                    }
                };
            }
            final PendingCall pendingCall = new PendingCall(Context.current(), methodDescriptor, callOptions);
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.4
                @Override // java.lang.Runnable
                public void run() {
                    if (RealChannel.this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                        if (ManagedChannelImpl.this.pendingCalls == null) {
                            ManagedChannelImpl.this.pendingCalls = new LinkedHashSet();
                            ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
                            managedChannelImpl.inUseStateAggregator.updateObjectInUse(managedChannelImpl.pendingCallsInUseObject, true);
                        }
                        ManagedChannelImpl.this.pendingCalls.add(pendingCall);
                        return;
                    }
                    pendingCall.reprocess();
                }
            });
            return pendingCall;
        }

        public void onConfigError() {
            if (this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                updateConfigSelector(null);
            }
        }

        public void shutdown() {
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.1RealChannelShutdown
                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.pendingCalls == null) {
                        if (RealChannel.this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                            RealChannel.this.configSelector.set(null);
                        }
                        ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.onShutdown(ManagedChannelImpl.SHUTDOWN_STATUS);
                    }
                }
            });
        }

        public void shutdownNow() {
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.1RealChannelShutdownNow
                @Override // java.lang.Runnable
                public void run() {
                    if (RealChannel.this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                        RealChannel.this.configSelector.set(null);
                    }
                    if (ManagedChannelImpl.this.pendingCalls != null) {
                        Iterator iterator2 = ManagedChannelImpl.this.pendingCalls.iterator2();
                        while (iterator2.hasNext()) {
                            ((PendingCall) iterator2.next()).cancel("Channel is forcefully shutdown", (Throwable) null);
                        }
                    }
                    ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.onShutdownNow(ManagedChannelImpl.SHUTDOWN_NOW_STATUS);
                }
            });
        }

        public void updateConfigSelector(InternalConfigSelector internalConfigSelector) {
            InternalConfigSelector internalConfigSelector2 = this.configSelector.get();
            this.configSelector.set(internalConfigSelector);
            if (internalConfigSelector2 != ManagedChannelImpl.INITIAL_PENDING_SELECTOR || ManagedChannelImpl.this.pendingCalls == null) {
                return;
            }
            Iterator iterator2 = ManagedChannelImpl.this.pendingCalls.iterator2();
            while (iterator2.hasNext()) {
                ((PendingCall) iterator2.next()).reprocess();
            }
        }

        private RealChannel(String str) {
            this.configSelector = new AtomicReference<>(ManagedChannelImpl.INITIAL_PENDING_SELECTOR);
            this.clientCallImplChannel = new Channel() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.1
                @Override // io.grpc.Channel
                public String authority() {
                    return RealChannel.this.authority;
                }

                @Override // io.grpc.Channel
                public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
                    return new ClientCallImpl(methodDescriptor, ManagedChannelImpl.this.getCallExecutor(callOptions), callOptions, ManagedChannelImpl.this.transportProvider, ManagedChannelImpl.this.terminated ? null : ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.channelCallTracer, null).setFullStreamDecompression(ManagedChannelImpl.this.fullStreamDecompression).setDecompressorRegistry(ManagedChannelImpl.this.decompressorRegistry).setCompressorRegistry(ManagedChannelImpl.this.compressorRegistry);
                }
            };
            this.authority = (String) o.s(str, "authority");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum ResolutionState {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class RestrictedScheduledExecutor implements ScheduledExecutorService {
        public final ScheduledExecutorService delegate;

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.awaitTermination(j10, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.delegate.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.delegate.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            return (T) this.delegate.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
            return this.delegate.schedule(callable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.delegate.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.delegate.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.delegate.submit(callable);
        }

        private RestrictedScheduledExecutor(ScheduledExecutorService scheduledExecutorService) {
            this.delegate = (ScheduledExecutorService) o.s(scheduledExecutorService, "delegate");
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.invokeAll(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (T) this.delegate.invokeAny(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.delegate.schedule(runnable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.delegate.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t2) {
            return this.delegate.submit(runnable, t2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class SubchannelImpl extends AbstractSubchannel {
        public List<EquivalentAddressGroup> addressGroups;
        public final LoadBalancer.CreateSubchannelArgs args;
        public SynchronizationContext.ScheduledHandle delayedShutdownTask;
        public boolean shutdown;
        public boolean started;
        public InternalSubchannel subchannel;
        public final InternalLogId subchannelLogId;
        public final ChannelLoggerImpl subchannelLogger;
        public final ChannelTracer subchannelTracer;

        public SubchannelImpl(LoadBalancer.CreateSubchannelArgs createSubchannelArgs) {
            o.s(createSubchannelArgs, "args");
            this.addressGroups = createSubchannelArgs.getAddresses();
            if (ManagedChannelImpl.this.authorityOverride != null) {
                createSubchannelArgs = createSubchannelArgs.toBuilder().setAddresses(stripOverrideAuthorityAttributes(createSubchannelArgs.getAddresses())).build();
            }
            this.args = createSubchannelArgs;
            InternalLogId allocate = InternalLogId.allocate("Subchannel", ManagedChannelImpl.this.authority());
            this.subchannelLogId = allocate;
            ChannelTracer channelTracer = new ChannelTracer(allocate, ManagedChannelImpl.this.maxTraceEvents, ManagedChannelImpl.this.timeProvider.currentTimeNanos(), "Subchannel for " + ((Object) createSubchannelArgs.getAddresses()));
            this.subchannelTracer = channelTracer;
            this.subchannelLogger = new ChannelLoggerImpl(channelTracer, ManagedChannelImpl.this.timeProvider);
        }

        private List<EquivalentAddressGroup> stripOverrideAuthorityAttributes(List<EquivalentAddressGroup> list) {
            ArrayList arrayList = new ArrayList();
            for (EquivalentAddressGroup equivalentAddressGroup : list) {
                arrayList.add(new EquivalentAddressGroup(equivalentAddressGroup.getAddresses(), equivalentAddressGroup.getAttributes().toBuilder().discard(EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE).build()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public Channel asChannel() {
            o.y(this.started, "not started");
            return new SubchannelChannel(this.subchannel, ManagedChannelImpl.this.balancerRpcExecutorHolder.getExecutor(), ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.callTracerFactory.create(), new AtomicReference(null));
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public List<EquivalentAddressGroup> getAllAddresses() {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            o.y(this.started, "not started");
            return this.addressGroups;
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public Attributes getAttributes() {
            return this.args.getAttributes();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public ChannelLogger getChannelLogger() {
            return this.subchannelLogger;
        }

        @Override // io.grpc.internal.AbstractSubchannel
        public InternalInstrumented<InternalChannelz.ChannelStats> getInstrumentedInternalSubchannel() {
            o.y(this.started, "not started");
            return this.subchannel;
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public Object getInternalSubchannel() {
            o.y(this.started, "Subchannel is not started");
            return this.subchannel;
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void requestConnection() {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            o.y(this.started, "not started");
            this.subchannel.obtainActiveTransport();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void shutdown() {
            SynchronizationContext.ScheduledHandle scheduledHandle;
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            if (this.subchannel == null) {
                this.shutdown = true;
                return;
            }
            if (this.shutdown) {
                if (!ManagedChannelImpl.this.terminating || (scheduledHandle = this.delayedShutdownTask) == null) {
                    return;
                }
                scheduledHandle.cancel();
                this.delayedShutdownTask = null;
            } else {
                this.shutdown = true;
            }
            if (!ManagedChannelImpl.this.terminating) {
                this.delayedShutdownTask = ManagedChannelImpl.this.syncContext.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.SubchannelImpl.1ShutdownSubchannel
                    @Override // java.lang.Runnable
                    public void run() {
                        SubchannelImpl.this.subchannel.shutdown(ManagedChannelImpl.SUBCHANNEL_SHUTDOWN_STATUS);
                    }
                }), 5L, TimeUnit.SECONDS, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService());
            } else {
                this.subchannel.shutdown(ManagedChannelImpl.SHUTDOWN_STATUS);
            }
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void start(final LoadBalancer.SubchannelStateListener subchannelStateListener) {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            o.y(!this.started, "already started");
            o.y(!this.shutdown, "already shutdown");
            o.y(!ManagedChannelImpl.this.terminating, "Channel is being terminated");
            this.started = true;
            InternalSubchannel internalSubchannel = new InternalSubchannel(this.args.getAddresses(), ManagedChannelImpl.this.authority(), ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.syncContext, new InternalSubchannel.Callback() { // from class: io.grpc.internal.ManagedChannelImpl.SubchannelImpl.1ManagedInternalSubchannelCallback
                @Override // io.grpc.internal.InternalSubchannel.Callback
                public void onInUse(InternalSubchannel internalSubchannel2) {
                    ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(internalSubchannel2, true);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                public void onNotInUse(InternalSubchannel internalSubchannel2) {
                    ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(internalSubchannel2, false);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                public void onStateChange(InternalSubchannel internalSubchannel2, ConnectivityStateInfo connectivityStateInfo) {
                    o.y(subchannelStateListener != null, "listener is null");
                    subchannelStateListener.onSubchannelState(connectivityStateInfo);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                public void onTerminated(InternalSubchannel internalSubchannel2) {
                    ManagedChannelImpl.this.subchannels.remove(internalSubchannel2);
                    ManagedChannelImpl.this.channelz.removeSubchannel(internalSubchannel2);
                    ManagedChannelImpl.this.maybeTerminateChannel();
                }
            }, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.callTracerFactory.create(), this.subchannelTracer, this.subchannelLogId, this.subchannelLogger);
            ManagedChannelImpl.this.channelTracer.reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child Subchannel started").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(ManagedChannelImpl.this.timeProvider.currentTimeNanos()).setSubchannelRef(internalSubchannel).build());
            this.subchannel = internalSubchannel;
            ManagedChannelImpl.this.channelz.addSubchannel(internalSubchannel);
            ManagedChannelImpl.this.subchannels.add(internalSubchannel);
        }

        public String toString() {
            return this.subchannelLogId.toString();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void updateAddresses(List<EquivalentAddressGroup> list) {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            this.addressGroups = list;
            if (ManagedChannelImpl.this.authorityOverride != null) {
                list = stripOverrideAuthorityAttributes(list);
            }
            this.subchannel.updateAddresses(list);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class UncommittedRetriableStreamsRegistry {
        public final Object lock;
        public Status shutdownStatus;
        public Collection<ClientStream> uncommittedRetriableStreams;

        private UncommittedRetriableStreamsRegistry() {
            this.lock = new Object();
            this.uncommittedRetriableStreams = new HashSet();
        }

        public Status add(RetriableStream<?> retriableStream) {
            synchronized (this.lock) {
                Status status = this.shutdownStatus;
                if (status != null) {
                    return status;
                }
                this.uncommittedRetriableStreams.add(retriableStream);
                return null;
            }
        }

        public void onShutdown(Status status) {
            synchronized (this.lock) {
                if (this.shutdownStatus != null) {
                    return;
                }
                this.shutdownStatus = status;
                boolean isEmpty = this.uncommittedRetriableStreams.isEmpty();
                if (isEmpty) {
                    ManagedChannelImpl.this.delayedTransport.shutdown(status);
                }
            }
        }

        public void onShutdownNow(Status status) {
            ArrayList arrayList;
            onShutdown(status);
            synchronized (this.lock) {
                arrayList = new ArrayList(this.uncommittedRetriableStreams);
            }
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                ((ClientStream) iterator2.next()).cancel(status);
            }
            ManagedChannelImpl.this.delayedTransport.shutdownNow(status);
        }

        public void remove(RetriableStream<?> retriableStream) {
            Status status;
            synchronized (this.lock) {
                this.uncommittedRetriableStreams.remove(retriableStream);
                if (this.uncommittedRetriableStreams.isEmpty()) {
                    status = this.shutdownStatus;
                    this.uncommittedRetriableStreams = new HashSet();
                } else {
                    status = null;
                }
            }
            if (status != null) {
                ManagedChannelImpl.this.delayedTransport.shutdown(status);
            }
        }
    }

    static {
        Status status = Status.UNAVAILABLE;
        SHUTDOWN_NOW_STATUS = status.withDescription("Channel shutdownNow invoked");
        SHUTDOWN_STATUS = status.withDescription("Channel shutdown invoked");
        SUBCHANNEL_SHUTDOWN_STATUS = status.withDescription("Subchannel shutdown invoked");
        EMPTY_SERVICE_CONFIG = ManagedChannelServiceConfig.empty();
        INITIAL_PENDING_SELECTOR = new InternalConfigSelector() { // from class: io.grpc.internal.ManagedChannelImpl.1
            @Override // io.grpc.InternalConfigSelector
            public InternalConfigSelector.Result selectConfig(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
                throw new IllegalStateException("Resolution is pending");
            }
        };
        NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.internal.ManagedChannelImpl.4
            @Override // io.grpc.ClientCall
            public void cancel(String str, Throwable th) {
            }

            @Override // io.grpc.ClientCall
            public void halfClose() {
            }

            @Override // io.grpc.ClientCall
            public boolean isReady() {
                return false;
            }

            @Override // io.grpc.ClientCall
            public void request(int i10) {
            }

            @Override // io.grpc.ClientCall
            public void sendMessage(Object obj) {
            }

            @Override // io.grpc.ClientCall
            public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [io.grpc.Channel] */
    public ManagedChannelImpl(ManagedChannelImplBuilder managedChannelImplBuilder, ClientTransportFactory clientTransportFactory, BackoffPolicy.Provider provider, ObjectPool<? extends Executor> objectPool, t<r> tVar, List<ClientInterceptor> list, final TimeProvider timeProvider) {
        AnonymousClass1 anonymousClass1;
        SynchronizationContext synchronizationContext = new SynchronizationContext(new Thread.UncaughtExceptionHandler() { // from class: io.grpc.internal.ManagedChannelImpl.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                ManagedChannelImpl.logger.log(Level.SEVERE, "[" + ((Object) ManagedChannelImpl.this.getLogId()) + "] Uncaught exception in the SynchronizationContext. Panic!", th);
                ManagedChannelImpl.this.panic(th);
            }
        });
        this.syncContext = synchronizationContext;
        this.channelStateManager = new ConnectivityStateManager();
        this.subchannels = new HashSet(16, 0.75f);
        this.pendingCallsInUseObject = new Object();
        this.oobChannels = new HashSet(1, 0.75f);
        this.uncommittedRetriableStreamsRegistry = new UncommittedRetriableStreamsRegistry();
        this.shutdown = new AtomicBoolean(false);
        this.terminatedLatch = new CountDownLatch(1);
        this.lastResolutionState = ResolutionState.NO_RESOLUTION;
        this.lastServiceConfig = EMPTY_SERVICE_CONFIG;
        this.serviceConfigUpdated = false;
        this.channelBufferUsed = new RetriableStream.ChannelBufferMeter();
        DelayedTransportListener delayedTransportListener = new DelayedTransportListener();
        this.delayedTransportListener = delayedTransportListener;
        this.inUseStateAggregator = new IdleModeStateAggregator();
        this.transportProvider = new ChannelStreamProvider();
        String str = (String) o.s(managedChannelImplBuilder.target, Attributes.Style.TARGET);
        this.target = str;
        InternalLogId allocate = InternalLogId.allocate("Channel", str);
        this.logId = allocate;
        this.timeProvider = (TimeProvider) o.s(timeProvider, "timeProvider");
        ObjectPool<? extends Executor> objectPool2 = (ObjectPool) o.s(managedChannelImplBuilder.executorPool, "executorPool");
        this.executorPool = objectPool2;
        Executor executor = (Executor) o.s(objectPool2.getObject(), "executor");
        this.executor = executor;
        this.originalChannelCreds = managedChannelImplBuilder.channelCredentials;
        this.originalTransportFactory = clientTransportFactory;
        ExecutorHolder executorHolder = new ExecutorHolder((ObjectPool) o.s(managedChannelImplBuilder.offloadExecutorPool, "offloadExecutorPool"));
        this.offloadExecutorHolder = executorHolder;
        CallCredentialsApplyingTransportFactory callCredentialsApplyingTransportFactory = new CallCredentialsApplyingTransportFactory(clientTransportFactory, managedChannelImplBuilder.callCredentials, executorHolder);
        this.transportFactory = callCredentialsApplyingTransportFactory;
        this.oobTransportFactory = new CallCredentialsApplyingTransportFactory(clientTransportFactory, null, executorHolder);
        RestrictedScheduledExecutor restrictedScheduledExecutor = new RestrictedScheduledExecutor(callCredentialsApplyingTransportFactory.getScheduledExecutorService());
        this.scheduledExecutor = restrictedScheduledExecutor;
        this.maxTraceEvents = managedChannelImplBuilder.maxTraceEvents;
        ChannelTracer channelTracer = new ChannelTracer(allocate, managedChannelImplBuilder.maxTraceEvents, timeProvider.currentTimeNanos(), "Channel for '" + str + "'");
        this.channelTracer = channelTracer;
        ChannelLoggerImpl channelLoggerImpl = new ChannelLoggerImpl(channelTracer, timeProvider);
        this.channelLogger = channelLoggerImpl;
        ProxyDetector proxyDetector = managedChannelImplBuilder.proxyDetector;
        proxyDetector = proxyDetector == null ? GrpcUtil.DEFAULT_PROXY_DETECTOR : proxyDetector;
        boolean z10 = managedChannelImplBuilder.retryEnabled;
        this.retryEnabled = z10;
        AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory = new AutoConfiguredLoadBalancerFactory(managedChannelImplBuilder.defaultLbPolicy);
        this.loadBalancerFactory = autoConfiguredLoadBalancerFactory;
        this.nameResolverRegistry = managedChannelImplBuilder.nameResolverRegistry;
        ScParser scParser = new ScParser(z10, managedChannelImplBuilder.maxRetryAttempts, managedChannelImplBuilder.maxHedgedAttempts, autoConfiguredLoadBalancerFactory);
        String str2 = managedChannelImplBuilder.authorityOverride;
        this.authorityOverride = str2;
        NameResolver.Args build = NameResolver.Args.newBuilder().setDefaultPort(managedChannelImplBuilder.getDefaultPort()).setProxyDetector(proxyDetector).setSynchronizationContext(synchronizationContext).setScheduledExecutorService(restrictedScheduledExecutor).setServiceConfigParser(scParser).setChannelLogger(channelLoggerImpl).setOffloadExecutor(executorHolder).setOverrideAuthority(str2).build();
        this.nameResolverArgs = build;
        NameResolver.Factory factory = managedChannelImplBuilder.nameResolverFactory;
        this.nameResolverFactory = factory;
        this.nameResolver = getNameResolver(str, str2, factory, build);
        this.balancerRpcExecutorPool = (ObjectPool) o.s(objectPool, "balancerRpcExecutorPool");
        this.balancerRpcExecutorHolder = new ExecutorHolder(objectPool);
        DelayedClientTransport delayedClientTransport = new DelayedClientTransport(executor, synchronizationContext);
        this.delayedTransport = delayedClientTransport;
        delayedClientTransport.start(delayedTransportListener);
        this.backoffPolicyProvider = provider;
        Map<String, ?> map = managedChannelImplBuilder.defaultServiceConfig;
        if (map != null) {
            NameResolver.ConfigOrError parseServiceConfig = scParser.parseServiceConfig(map);
            o.B(parseServiceConfig.getError() == null, "Default config is invalid: %s", parseServiceConfig.getError());
            ManagedChannelServiceConfig managedChannelServiceConfig = (ManagedChannelServiceConfig) parseServiceConfig.getConfig();
            this.defaultServiceConfig = managedChannelServiceConfig;
            this.lastServiceConfig = managedChannelServiceConfig;
            anonymousClass1 = null;
        } else {
            anonymousClass1 = null;
            this.defaultServiceConfig = null;
        }
        boolean z11 = managedChannelImplBuilder.lookUpServiceConfig;
        this.lookUpServiceConfig = z11;
        RealChannel realChannel = new RealChannel(this.nameResolver.getServiceAuthority());
        this.realChannel = realChannel;
        BinaryLog binaryLog = managedChannelImplBuilder.binlog;
        this.interceptorChannel = ClientInterceptors.intercept(binaryLog != null ? binaryLog.wrapChannel(realChannel) : realChannel, list);
        this.stopwatchSupplier = (t) o.s(tVar, "stopwatchSupplier");
        long j10 = managedChannelImplBuilder.idleTimeoutMillis;
        if (j10 == -1) {
            this.idleTimeoutMillis = j10;
        } else {
            o.j(j10 >= ManagedChannelImplBuilder.IDLE_MODE_MIN_TIMEOUT_MILLIS, "invalid idleTimeoutMillis %s", j10);
            this.idleTimeoutMillis = managedChannelImplBuilder.idleTimeoutMillis;
        }
        this.idleTimer = new Rescheduler(new IdleModeTimer(), synchronizationContext, callCredentialsApplyingTransportFactory.getScheduledExecutorService(), tVar.get());
        this.fullStreamDecompression = managedChannelImplBuilder.fullStreamDecompression;
        this.decompressorRegistry = (DecompressorRegistry) o.s(managedChannelImplBuilder.decompressorRegistry, "decompressorRegistry");
        this.compressorRegistry = (CompressorRegistry) o.s(managedChannelImplBuilder.compressorRegistry, "compressorRegistry");
        this.userAgent = managedChannelImplBuilder.userAgent;
        this.channelBufferLimit = managedChannelImplBuilder.retryBufferSize;
        this.perRpcBufferLimit = managedChannelImplBuilder.perRpcBufferLimit;
        CallTracer.Factory factory2 = new CallTracer.Factory() { // from class: io.grpc.internal.ManagedChannelImpl.1ChannelCallTracerFactory
            @Override // io.grpc.internal.CallTracer.Factory
            public CallTracer create() {
                return new CallTracer(timeProvider);
            }
        };
        this.callTracerFactory = factory2;
        this.channelCallTracer = factory2.create();
        InternalChannelz internalChannelz = (InternalChannelz) o.r(managedChannelImplBuilder.channelz);
        this.channelz = internalChannelz;
        internalChannelz.addRootChannel(this);
        if (z11) {
            return;
        }
        if (this.defaultServiceConfig != null) {
            channelLoggerImpl.log(ChannelLogger.ChannelLogLevel.INFO, "Service config look-up disabled, using default service config");
        }
        this.serviceConfigUpdated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelIdleTimer(boolean z10) {
        this.idleTimer.cancel(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterIdleMode() {
        shutdownNameResolverAndLoadBalancer(true);
        this.delayedTransport.reprocess(null);
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering IDLE state");
        this.channelStateManager.gotoState(ConnectivityState.IDLE);
        if (this.inUseStateAggregator.anyObjectInUse(this.pendingCallsInUseObject, this.delayedTransport)) {
            exitIdleMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Executor getCallExecutor(CallOptions callOptions) {
        Executor executor = callOptions.getExecutor();
        return executor == null ? this.executor : executor;
    }

    private static NameResolver getNameResolver(String str, NameResolver.Factory factory, NameResolver.Args args) {
        URI uri;
        NameResolver newNameResolver;
        StringBuilder sb2 = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e2) {
            sb2.append(e2.getMessage());
            uri = null;
        }
        if (uri != null && (newNameResolver = factory.newNameResolver(uri, args)) != null) {
            return newNameResolver;
        }
        String str2 = "";
        if (!URI_PATTERN.matcher(str).matches()) {
            try {
                NameResolver newNameResolver2 = factory.newNameResolver(new URI(factory.getDefaultScheme(), "", "/" + str, null), args);
                if (newNameResolver2 != null) {
                    return newNameResolver2;
                }
            } catch (URISyntaxException e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (sb2.length() > 0) {
            str2 = " (" + ((Object) sb2) + ")";
        }
        objArr[1] = str2;
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInternalSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
        if (connectivityStateInfo.getState() == ConnectivityState.TRANSIENT_FAILURE || connectivityStateInfo.getState() == ConnectivityState.IDLE) {
            refreshNameResolution();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeShutdownNowSubchannels() {
        if (this.shutdownNowed) {
            Iterator<InternalSubchannel> iterator2 = this.subchannels.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().shutdownNow(SHUTDOWN_NOW_STATUS);
            }
            Iterator<OobChannel> iterator22 = this.oobChannels.iterator2();
            while (iterator22.hasNext()) {
                iterator22.next().getInternalSubchannel().shutdownNow(SHUTDOWN_NOW_STATUS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeTerminateChannel() {
        if (!this.terminated && this.shutdown.get() && this.subchannels.isEmpty() && this.oobChannels.isEmpty()) {
            this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
            this.channelz.removeRootChannel(this);
            this.executorPool.returnObject(this.executor);
            this.balancerRpcExecutorHolder.release();
            this.offloadExecutorHolder.release();
            this.transportFactory.close();
            this.terminated = true;
            this.terminatedLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshNameResolution() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.nameResolverStarted) {
            this.nameResolver.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rescheduleIdleTimer() {
        long j10 = this.idleTimeoutMillis;
        if (j10 == -1) {
            return;
        }
        this.idleTimer.reschedule(j10, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownNameResolverAndLoadBalancer(boolean z10) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (z10) {
            o.y(this.nameResolverStarted, "nameResolver is not started");
            o.y(this.lbHelper != null, "lbHelper is null");
        }
        NameResolver nameResolver = this.nameResolver;
        if (nameResolver != null) {
            nameResolver.shutdown();
            this.nameResolverStarted = false;
            if (z10) {
                this.nameResolver = getNameResolver(this.target, this.authorityOverride, this.nameResolverFactory, this.nameResolverArgs);
            } else {
                this.nameResolver = null;
            }
        }
        LbHelperImpl lbHelperImpl = this.lbHelper;
        if (lbHelperImpl != null) {
            lbHelperImpl.f50071lb.shutdown();
            this.lbHelper = null;
        }
        this.subchannelPicker = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubchannelPicker(LoadBalancer.SubchannelPicker subchannelPicker) {
        this.subchannelPicker = subchannelPicker;
        this.delayedTransport.reprocess(subchannelPicker);
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.interceptorChannel.authority();
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.terminatedLatch.await(j10, timeUnit);
    }

    @Override // io.grpc.ManagedChannel
    public void enterIdle() {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1PrepareToLoseNetworkRunnable
            @Override // java.lang.Runnable
            public void run() {
                if (ManagedChannelImpl.this.shutdown.get() || ManagedChannelImpl.this.lbHelper == null) {
                    return;
                }
                ManagedChannelImpl.this.cancelIdleTimer(false);
                ManagedChannelImpl.this.enterIdleMode();
            }
        });
    }

    public void exitIdleMode() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.shutdown.get() || this.panicMode) {
            return;
        }
        if (this.inUseStateAggregator.isInUse()) {
            cancelIdleTimer(false);
        } else {
            rescheduleIdleTimer();
        }
        if (this.lbHelper != null) {
            return;
        }
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Exiting idle mode");
        LbHelperImpl lbHelperImpl = new LbHelperImpl();
        lbHelperImpl.f50071lb = this.loadBalancerFactory.newLoadBalancer(lbHelperImpl);
        this.lbHelper = lbHelperImpl;
        this.nameResolver.start((NameResolver.Listener2) new NameResolverListener(lbHelperImpl, this.nameResolver));
        this.nameResolverStarted = true;
    }

    public InternalConfigSelector getConfigSelector() {
        return (InternalConfigSelector) this.realChannel.configSelector.get();
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean z10) {
        ConnectivityState state = this.channelStateManager.getState();
        if (z10 && state == ConnectivityState.IDLE) {
            this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1RequestConnection
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelImpl.this.exitIdleMode();
                    if (ManagedChannelImpl.this.subchannelPicker != null) {
                        ManagedChannelImpl.this.subchannelPicker.requestConnection();
                    }
                    if (ManagedChannelImpl.this.lbHelper != null) {
                        ManagedChannelImpl.this.lbHelper.f50071lb.requestConnection();
                    }
                }
            });
        }
        return state;
    }

    @Override // io.grpc.InternalInstrumented
    public n<InternalChannelz.ChannelStats> getStats() {
        final com.google.common.util.concurrent.t a10 = com.google.common.util.concurrent.t.a();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1StatsFetcher
            @Override // java.lang.Runnable
            public void run() {
                InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
                ManagedChannelImpl.this.channelCallTracer.updateBuilder(builder);
                ManagedChannelImpl.this.channelTracer.updateBuilder(builder);
                builder.setTarget(ManagedChannelImpl.this.target).setState(ManagedChannelImpl.this.channelStateManager.getState());
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(ManagedChannelImpl.this.subchannels);
                arrayList.addAll(ManagedChannelImpl.this.oobChannels);
                builder.setSubchannels(arrayList);
                a10.set(builder.build());
            }
        });
        return a10;
    }

    public boolean isInPanicMode() {
        return this.panicMode;
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.shutdown.get();
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.terminated;
    }

    @Override // io.grpc.Channel
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
        return this.interceptorChannel.newCall(methodDescriptor, callOptions);
    }

    @Override // io.grpc.ManagedChannel
    public void notifyWhenStateChanged(final ConnectivityState connectivityState, final Runnable runnable) {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1NotifyStateChanged
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.channelStateManager.notifyWhenStateChanged(runnable, ManagedChannelImpl.this.executor, connectivityState);
            }
        });
    }

    public void panic(Throwable th) {
        if (this.panicMode) {
            return;
        }
        this.panicMode = true;
        cancelIdleTimer(true);
        shutdownNameResolverAndLoadBalancer(false);
        updateSubchannelPicker(new LoadBalancer.SubchannelPicker(th) { // from class: io.grpc.internal.ManagedChannelImpl.1PanicSubchannelPicker
            private final LoadBalancer.PickResult panicPickResult;
            public final /* synthetic */ Throwable val$t;

            {
                this.val$t = th;
                this.panicPickResult = LoadBalancer.PickResult.withDrop(Status.INTERNAL.withDescription("Panic! This is a bug!").withCause(th));
            }

            @Override // io.grpc.LoadBalancer.SubchannelPicker
            public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
                return this.panicPickResult;
            }

            public String toString() {
                return j.b(C1PanicSubchannelPicker.class).d("panicPickResult", this.panicPickResult).toString();
            }
        });
        this.realChannel.updateConfigSelector(null);
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.channelStateManager.gotoState(ConnectivityState.TRANSIENT_FAILURE);
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1ResetConnectBackoff
            @Override // java.lang.Runnable
            public void run() {
                if (ManagedChannelImpl.this.shutdown.get()) {
                    return;
                }
                if (ManagedChannelImpl.this.nameResolverStarted) {
                    ManagedChannelImpl.this.refreshNameResolution();
                }
                Iterator iterator2 = ManagedChannelImpl.this.subchannels.iterator2();
                while (iterator2.hasNext()) {
                    ((InternalSubchannel) iterator2.next()).resetConnectBackoff();
                }
                Iterator iterator22 = ManagedChannelImpl.this.oobChannels.iterator2();
                while (iterator22.hasNext()) {
                    ((OobChannel) iterator22.next()).resetConnectBackoff();
                }
            }
        });
    }

    public String toString() {
        return j.c(this).c("logId", this.logId.getId()).d(Attributes.Style.TARGET, this.target).toString();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannelImpl shutdown() {
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "shutdown() called");
        if (!this.shutdown.compareAndSet(false, true)) {
            return this;
        }
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1Shutdown
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering SHUTDOWN state");
                ManagedChannelImpl.this.channelStateManager.gotoState(ConnectivityState.SHUTDOWN);
            }
        });
        this.realChannel.shutdown();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1CancelIdleTimer
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.cancelIdleTimer(true);
            }
        });
        return this;
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannelImpl shutdownNow() {
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "shutdownNow() called");
        shutdown();
        this.realChannel.shutdownNow();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1ShutdownNow
            @Override // java.lang.Runnable
            public void run() {
                if (ManagedChannelImpl.this.shutdownNowed) {
                    return;
                }
                ManagedChannelImpl.this.shutdownNowed = true;
                ManagedChannelImpl.this.maybeShutdownNowSubchannels();
            }
        });
        return this;
    }

    public static NameResolver getNameResolver(String str, final String str2, NameResolver.Factory factory, NameResolver.Args args) {
        NameResolver nameResolver = getNameResolver(str, factory, args);
        if (str2 == null) {
            return nameResolver;
        }
        if (!(nameResolver instanceof RetryingNameResolver)) {
            nameResolver = new RetryingNameResolver(nameResolver, new BackoffPolicyRetryScheduler(new ExponentialBackoffPolicy.Provider(), args.getScheduledExecutorService(), args.getSynchronizationContext()), args.getSynchronizationContext());
        }
        return new ForwardingNameResolver(nameResolver) { // from class: io.grpc.internal.ManagedChannelImpl.3
            @Override // io.grpc.internal.ForwardingNameResolver, io.grpc.NameResolver
            public String getServiceAuthority() {
                return str2;
            }
        };
    }
}
