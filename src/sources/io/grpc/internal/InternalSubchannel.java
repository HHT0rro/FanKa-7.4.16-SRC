package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.o;
import com.google.common.base.r;
import com.google.common.base.t;
import com.google.common.util.concurrent.n;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ChannelLogger;
import io.grpc.ClientStreamTracer;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ManagedClientTransport;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalSubchannel implements InternalInstrumented<InternalChannelz.ChannelStats>, TransportProvider {
    private volatile ManagedClientTransport activeTransport;
    private volatile List<EquivalentAddressGroup> addressGroups;
    private final Index addressIndex;
    private final String authority;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    private final Callback callback;
    private final CallTracer callsTracer;
    private final ChannelLogger channelLogger;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final r connectingTimer;
    private final InternalLogId logId;
    private ConnectionClientTransport pendingTransport;
    private BackoffPolicy reconnectPolicy;
    private SynchronizationContext.ScheduledHandle reconnectTask;
    private final ScheduledExecutorService scheduledExecutor;
    private SynchronizationContext.ScheduledHandle shutdownDueToUpdateTask;
    private ManagedClientTransport shutdownDueToUpdateTransport;
    private Status shutdownReason;
    private final SynchronizationContext syncContext;
    private final ClientTransportFactory transportFactory;
    private final String userAgent;
    private final Collection<ConnectionClientTransport> transports = new ArrayList();
    private final InUseStateAggregator<ConnectionClientTransport> inUseStateAggregator = new InUseStateAggregator<ConnectionClientTransport>() { // from class: io.grpc.internal.InternalSubchannel.1
        @Override // io.grpc.internal.InUseStateAggregator
        public void handleInUse() {
            InternalSubchannel.this.callback.onInUse(InternalSubchannel.this);
        }

        @Override // io.grpc.internal.InUseStateAggregator
        public void handleNotInUse() {
            InternalSubchannel.this.callback.onNotInUse(InternalSubchannel.this);
        }
    };
    private volatile ConnectivityStateInfo state = ConnectivityStateInfo.forNonError(ConnectivityState.IDLE);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CallTracingTransport extends ForwardingConnectionClientTransport {
        private final CallTracer callTracer;
        private final ConnectionClientTransport delegate;

        @Override // io.grpc.internal.ForwardingConnectionClientTransport
        public ConnectionClientTransport delegate() {
            return this.delegate;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ClientTransport
        public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
            final ClientStream newStream = super.newStream(methodDescriptor, metadata, callOptions, clientStreamTracerArr);
            return new ForwardingClientStream() { // from class: io.grpc.internal.InternalSubchannel.CallTracingTransport.1
                @Override // io.grpc.internal.ForwardingClientStream
                public ClientStream delegate() {
                    return newStream;
                }

                @Override // io.grpc.internal.ForwardingClientStream, io.grpc.internal.ClientStream
                public void start(final ClientStreamListener clientStreamListener) {
                    CallTracingTransport.this.callTracer.reportCallStarted();
                    super.start(new ForwardingClientStreamListener() { // from class: io.grpc.internal.InternalSubchannel.CallTracingTransport.1.1
                        @Override // io.grpc.internal.ForwardingClientStreamListener, io.grpc.internal.ClientStreamListener
                        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata2) {
                            CallTracingTransport.this.callTracer.reportCallEnded(status.isOk());
                            super.closed(status, rpcProgress, metadata2);
                        }

                        @Override // io.grpc.internal.ForwardingClientStreamListener
                        public ClientStreamListener delegate() {
                            return clientStreamListener;
                        }
                    });
                }
            };
        }

        private CallTracingTransport(ConnectionClientTransport connectionClientTransport, CallTracer callTracer) {
            this.delegate = connectionClientTransport;
            this.callTracer = callTracer;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Callback {
        public void onInUse(InternalSubchannel internalSubchannel) {
        }

        public void onNotInUse(InternalSubchannel internalSubchannel) {
        }

        public void onStateChange(InternalSubchannel internalSubchannel, ConnectivityStateInfo connectivityStateInfo) {
        }

        public void onTerminated(InternalSubchannel internalSubchannel) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Index {
        private List<EquivalentAddressGroup> addressGroups;
        private int addressIndex;
        private int groupIndex;

        public Index(List<EquivalentAddressGroup> list) {
            this.addressGroups = list;
        }

        public SocketAddress getCurrentAddress() {
            return this.addressGroups.get(this.groupIndex).getAddresses().get(this.addressIndex);
        }

        public Attributes getCurrentEagAttributes() {
            return this.addressGroups.get(this.groupIndex).getAttributes();
        }

        public List<EquivalentAddressGroup> getGroups() {
            return this.addressGroups;
        }

        public void increment() {
            EquivalentAddressGroup equivalentAddressGroup = this.addressGroups.get(this.groupIndex);
            int i10 = this.addressIndex + 1;
            this.addressIndex = i10;
            if (i10 >= equivalentAddressGroup.getAddresses().size()) {
                this.groupIndex++;
                this.addressIndex = 0;
            }
        }

        public boolean isAtBeginning() {
            return this.groupIndex == 0 && this.addressIndex == 0;
        }

        public boolean isValid() {
            return this.groupIndex < this.addressGroups.size();
        }

        public void reset() {
            this.groupIndex = 0;
            this.addressIndex = 0;
        }

        public boolean seekTo(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.addressGroups.size(); i10++) {
                int indexOf = this.addressGroups.get(i10).getAddresses().indexOf(socketAddress);
                if (indexOf != -1) {
                    this.groupIndex = i10;
                    this.addressIndex = indexOf;
                    return true;
                }
            }
            return false;
        }

        public void updateGroups(List<EquivalentAddressGroup> list) {
            this.addressGroups = list;
            reset();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class TransportListener implements ManagedClientTransport.Listener {
        public boolean shutdownInitiated = false;
        public final ConnectionClientTransport transport;

        public TransportListener(ConnectionClientTransport connectionClientTransport) {
            this.transport = connectionClientTransport;
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportInUse(boolean z10) {
            InternalSubchannel.this.handleTransportInUseState(this.transport, z10);
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportReady() {
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "READY");
            InternalSubchannel.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.TransportListener.1
                @Override // java.lang.Runnable
                public void run() {
                    InternalSubchannel.this.reconnectPolicy = null;
                    if (InternalSubchannel.this.shutdownReason != null) {
                        o.y(InternalSubchannel.this.activeTransport == null, "Unexpected non-null activeTransport");
                        TransportListener transportListener = TransportListener.this;
                        transportListener.transport.shutdown(InternalSubchannel.this.shutdownReason);
                        return;
                    }
                    ConnectionClientTransport connectionClientTransport = InternalSubchannel.this.pendingTransport;
                    TransportListener transportListener2 = TransportListener.this;
                    ConnectionClientTransport connectionClientTransport2 = transportListener2.transport;
                    if (connectionClientTransport == connectionClientTransport2) {
                        InternalSubchannel.this.activeTransport = connectionClientTransport2;
                        InternalSubchannel.this.pendingTransport = null;
                        InternalSubchannel.this.gotoNonErrorState(ConnectivityState.READY);
                    }
                }
            });
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportShutdown(final Status status) {
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "{0} SHUTDOWN with {1}", this.transport.getLogId(), InternalSubchannel.this.printShortStatus(status));
            this.shutdownInitiated = true;
            InternalSubchannel.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.TransportListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN) {
                        return;
                    }
                    ManagedClientTransport managedClientTransport = InternalSubchannel.this.activeTransport;
                    TransportListener transportListener = TransportListener.this;
                    if (managedClientTransport == transportListener.transport) {
                        InternalSubchannel.this.activeTransport = null;
                        InternalSubchannel.this.addressIndex.reset();
                        InternalSubchannel.this.gotoNonErrorState(ConnectivityState.IDLE);
                        return;
                    }
                    ConnectionClientTransport connectionClientTransport = InternalSubchannel.this.pendingTransport;
                    TransportListener transportListener2 = TransportListener.this;
                    if (connectionClientTransport == transportListener2.transport) {
                        o.B(InternalSubchannel.this.state.getState() == ConnectivityState.CONNECTING, "Expected state is CONNECTING, actual state is %s", InternalSubchannel.this.state.getState());
                        InternalSubchannel.this.addressIndex.increment();
                        if (!InternalSubchannel.this.addressIndex.isValid()) {
                            InternalSubchannel.this.pendingTransport = null;
                            InternalSubchannel.this.addressIndex.reset();
                            InternalSubchannel.this.scheduleBackoff(status);
                            return;
                        }
                        InternalSubchannel.this.startNewTransport();
                    }
                }
            });
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportTerminated() {
            o.y(this.shutdownInitiated, "transportShutdown() must be called before transportTerminated().");
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "{0} Terminated", this.transport.getLogId());
            InternalSubchannel.this.channelz.removeClientSocket(this.transport);
            InternalSubchannel.this.handleTransportInUseState(this.transport, false);
            InternalSubchannel.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.TransportListener.3
                @Override // java.lang.Runnable
                public void run() {
                    InternalSubchannel.this.transports.remove(TransportListener.this.transport);
                    if (InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN && InternalSubchannel.this.transports.isEmpty()) {
                        InternalSubchannel.this.handleTermination();
                    }
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TransportLogger extends ChannelLogger {
        public InternalLogId logId;

        @Override // io.grpc.ChannelLogger
        public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
            ChannelLoggerImpl.logOnly(this.logId, channelLogLevel, str);
        }

        @Override // io.grpc.ChannelLogger
        public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
            ChannelLoggerImpl.logOnly(this.logId, channelLogLevel, str, objArr);
        }
    }

    public InternalSubchannel(List<EquivalentAddressGroup> list, String str, String str2, BackoffPolicy.Provider provider, ClientTransportFactory clientTransportFactory, ScheduledExecutorService scheduledExecutorService, t<r> tVar, SynchronizationContext synchronizationContext, Callback callback, InternalChannelz internalChannelz, CallTracer callTracer, ChannelTracer channelTracer, InternalLogId internalLogId, ChannelLogger channelLogger) {
        o.s(list, "addressGroups");
        o.e(!list.isEmpty(), "addressGroups is empty");
        checkListHasNoNulls(list, "addressGroups contains null entry");
        List<EquivalentAddressGroup> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.addressGroups = unmodifiableList;
        this.addressIndex = new Index(unmodifiableList);
        this.authority = str;
        this.userAgent = str2;
        this.backoffPolicyProvider = provider;
        this.transportFactory = clientTransportFactory;
        this.scheduledExecutor = scheduledExecutorService;
        this.connectingTimer = tVar.get();
        this.syncContext = synchronizationContext;
        this.callback = callback;
        this.channelz = internalChannelz;
        this.callsTracer = callTracer;
        this.channelTracer = (ChannelTracer) o.s(channelTracer, "channelTracer");
        this.logId = (InternalLogId) o.s(internalLogId, "logId");
        this.channelLogger = (ChannelLogger) o.s(channelLogger, "channelLogger");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelReconnectTask() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        SynchronizationContext.ScheduledHandle scheduledHandle = this.reconnectTask;
        if (scheduledHandle != null) {
            scheduledHandle.cancel();
            this.reconnectTask = null;
            this.reconnectPolicy = null;
        }
    }

    private static void checkListHasNoNulls(List<?> list, String str) {
        Iterator<?> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            o.s(iterator2.next(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoNonErrorState(ConnectivityState connectivityState) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        gotoState(ConnectivityStateInfo.forNonError(connectivityState));
    }

    private void gotoState(ConnectivityStateInfo connectivityStateInfo) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.state.getState() != connectivityStateInfo.getState()) {
            o.y(this.state.getState() != ConnectivityState.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + ((Object) connectivityStateInfo));
            this.state = connectivityStateInfo;
            this.callback.onStateChange(this, connectivityStateInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTermination() {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.6
            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
                InternalSubchannel.this.callback.onTerminated(InternalSubchannel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTransportInUseState(final ConnectionClientTransport connectionClientTransport, final boolean z10) {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.7
            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.inUseStateAggregator.updateObjectInUse(connectionClientTransport, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printShortStatus(Status status) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) status.getCode());
        if (status.getDescription() != null) {
            sb2.append("(");
            sb2.append(status.getDescription());
            sb2.append(")");
        }
        if (status.getCause() != null) {
            sb2.append("[");
            sb2.append((Object) status.getCause());
            sb2.append("]");
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleBackoff(Status status) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        gotoState(ConnectivityStateInfo.forTransientFailure(status));
        if (this.reconnectPolicy == null) {
            this.reconnectPolicy = this.backoffPolicyProvider.get();
        }
        long nextBackoffNanos = this.reconnectPolicy.nextBackoffNanos();
        r rVar = this.connectingTimer;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long e2 = nextBackoffNanos - rVar.e(timeUnit);
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", printShortStatus(status), Long.valueOf(e2));
        o.y(this.reconnectTask == null, "previous reconnectTask is not done");
        this.reconnectTask = this.syncContext.schedule(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.1EndOfCurrentBackoff
            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.reconnectTask = null;
                InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING after backoff");
                InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
                InternalSubchannel.this.startNewTransport();
            }
        }, e2, timeUnit, this.scheduledExecutor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNewTransport() {
        SocketAddress socketAddress;
        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress;
        this.syncContext.throwIfNotInThisSynchronizationContext();
        o.y(this.reconnectTask == null, "Should have no reconnectTask scheduled");
        if (this.addressIndex.isAtBeginning()) {
            this.connectingTimer.g().h();
        }
        SocketAddress currentAddress = this.addressIndex.getCurrentAddress();
        if (currentAddress instanceof HttpConnectProxiedSocketAddress) {
            httpConnectProxiedSocketAddress = (HttpConnectProxiedSocketAddress) currentAddress;
            socketAddress = httpConnectProxiedSocketAddress.getTargetAddress();
        } else {
            socketAddress = currentAddress;
            httpConnectProxiedSocketAddress = null;
        }
        Attributes currentEagAttributes = this.addressIndex.getCurrentEagAttributes();
        String str = (String) currentEagAttributes.get(EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE);
        ClientTransportFactory.ClientTransportOptions clientTransportOptions = new ClientTransportFactory.ClientTransportOptions();
        if (str == null) {
            str = this.authority;
        }
        ClientTransportFactory.ClientTransportOptions httpConnectProxiedSocketAddress2 = clientTransportOptions.setAuthority(str).setEagAttributes(currentEagAttributes).setUserAgent(this.userAgent).setHttpConnectProxiedSocketAddress(httpConnectProxiedSocketAddress);
        TransportLogger transportLogger = new TransportLogger();
        transportLogger.logId = getLogId();
        CallTracingTransport callTracingTransport = new CallTracingTransport(this.transportFactory.newClientTransport(socketAddress, httpConnectProxiedSocketAddress2, transportLogger), this.callsTracer);
        transportLogger.logId = callTracingTransport.getLogId();
        this.channelz.addClientSocket(callTracingTransport);
        this.pendingTransport = callTracingTransport;
        this.transports.add(callTracingTransport);
        Runnable start = callTracingTransport.start(new TransportListener(callTracingTransport));
        if (start != null) {
            this.syncContext.executeLater(start);
        }
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Started transport {0}", transportLogger.logId);
    }

    public List<EquivalentAddressGroup> getAddressGroups() {
        return this.addressGroups;
    }

    public String getAuthority() {
        return this.authority;
    }

    public ChannelLogger getChannelLogger() {
        return this.channelLogger;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    public ConnectivityState getState() {
        return this.state.getState();
    }

    @Override // io.grpc.InternalInstrumented
    public n<InternalChannelz.ChannelStats> getStats() {
        final com.google.common.util.concurrent.t a10 = com.google.common.util.concurrent.t.a();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.9
            @Override // java.lang.Runnable
            public void run() {
                InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
                List<EquivalentAddressGroup> groups = InternalSubchannel.this.addressIndex.getGroups();
                ArrayList arrayList = new ArrayList(InternalSubchannel.this.transports);
                builder.setTarget(groups.toString()).setState(InternalSubchannel.this.getState());
                builder.setSockets(arrayList);
                InternalSubchannel.this.callsTracer.updateBuilder(builder);
                InternalSubchannel.this.channelTracer.updateBuilder(builder);
                a10.set(builder.build());
            }
        });
        return a10;
    }

    public ClientTransport getTransport() {
        return this.activeTransport;
    }

    @Override // io.grpc.internal.TransportProvider
    public ClientTransport obtainActiveTransport() {
        ManagedClientTransport managedClientTransport = this.activeTransport;
        if (managedClientTransport != null) {
            return managedClientTransport;
        }
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.2
            @Override // java.lang.Runnable
            public void run() {
                if (InternalSubchannel.this.state.getState() == ConnectivityState.IDLE) {
                    InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING as requested");
                    InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
                    InternalSubchannel.this.startNewTransport();
                }
            }
        });
        return null;
    }

    public void resetConnectBackoff() {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.3
            @Override // java.lang.Runnable
            public void run() {
                if (InternalSubchannel.this.state.getState() != ConnectivityState.TRANSIENT_FAILURE) {
                    return;
                }
                InternalSubchannel.this.cancelReconnectTask();
                InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING; backoff interrupted");
                InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
                InternalSubchannel.this.startNewTransport();
            }
        });
    }

    public void shutdown(final Status status) {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.5
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityState state = InternalSubchannel.this.state.getState();
                ConnectivityState connectivityState = ConnectivityState.SHUTDOWN;
                if (state == connectivityState) {
                    return;
                }
                InternalSubchannel.this.shutdownReason = status;
                ManagedClientTransport managedClientTransport = InternalSubchannel.this.activeTransport;
                ConnectionClientTransport connectionClientTransport = InternalSubchannel.this.pendingTransport;
                InternalSubchannel.this.activeTransport = null;
                InternalSubchannel.this.pendingTransport = null;
                InternalSubchannel.this.gotoNonErrorState(connectivityState);
                InternalSubchannel.this.addressIndex.reset();
                if (InternalSubchannel.this.transports.isEmpty()) {
                    InternalSubchannel.this.handleTermination();
                }
                InternalSubchannel.this.cancelReconnectTask();
                if (InternalSubchannel.this.shutdownDueToUpdateTask != null) {
                    InternalSubchannel.this.shutdownDueToUpdateTask.cancel();
                    InternalSubchannel.this.shutdownDueToUpdateTransport.shutdown(status);
                    InternalSubchannel.this.shutdownDueToUpdateTask = null;
                    InternalSubchannel.this.shutdownDueToUpdateTransport = null;
                }
                if (managedClientTransport != null) {
                    managedClientTransport.shutdown(status);
                }
                if (connectionClientTransport != null) {
                    connectionClientTransport.shutdown(status);
                }
            }
        });
    }

    public void shutdownNow(final Status status) {
        shutdown(status);
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.8
            @Override // java.lang.Runnable
            public void run() {
                Iterator<E> iterator2 = new ArrayList(InternalSubchannel.this.transports).iterator2();
                while (iterator2.hasNext()) {
                    ((ManagedClientTransport) iterator2.next()).shutdownNow(status);
                }
            }
        });
    }

    public String toString() {
        return j.c(this).c("logId", this.logId.getId()).d("addressGroups", this.addressGroups).toString();
    }

    public void updateAddresses(List<EquivalentAddressGroup> list) {
        o.s(list, "newAddressGroups");
        checkListHasNoNulls(list, "newAddressGroups contains null entry");
        o.e(!list.isEmpty(), "newAddressGroups is empty");
        final List unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.4
            /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0094  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r7 = this;
                    io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel$Index r0 = io.grpc.internal.InternalSubchannel.access$800(r0)
                    java.net.SocketAddress r0 = r0.getCurrentAddress()
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel$Index r1 = io.grpc.internal.InternalSubchannel.access$800(r1)
                    java.util.List r2 = r2
                    r1.updateGroups(r2)
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    java.util.List r2 = r2
                    io.grpc.internal.InternalSubchannel.access$902(r1, r2)
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.ConnectivityStateInfo r1 = io.grpc.internal.InternalSubchannel.access$100(r1)
                    io.grpc.ConnectivityState r1 = r1.getState()
                    io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.READY
                    r3 = 0
                    if (r1 == r2) goto L39
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.ConnectivityStateInfo r1 = io.grpc.internal.InternalSubchannel.access$100(r1)
                    io.grpc.ConnectivityState r1 = r1.getState()
                    io.grpc.ConnectivityState r4 = io.grpc.ConnectivityState.CONNECTING
                    if (r1 != r4) goto L91
                L39:
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel$Index r1 = io.grpc.internal.InternalSubchannel.access$800(r1)
                    boolean r0 = r1.seekTo(r0)
                    if (r0 != 0) goto L91
                    io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.ConnectivityStateInfo r0 = io.grpc.internal.InternalSubchannel.access$100(r0)
                    io.grpc.ConnectivityState r0 = r0.getState()
                    if (r0 != r2) goto L6d
                    io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.ManagedClientTransport r0 = io.grpc.internal.InternalSubchannel.access$1000(r0)
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel.access$1002(r1, r3)
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel$Index r1 = io.grpc.internal.InternalSubchannel.access$800(r1)
                    r1.reset()
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.IDLE
                    io.grpc.internal.InternalSubchannel.access$300(r1, r2)
                    goto L92
                L6d:
                    io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.ConnectionClientTransport r0 = io.grpc.internal.InternalSubchannel.access$1100(r0)
                    io.grpc.Status r1 = io.grpc.Status.UNAVAILABLE
                    java.lang.String r2 = "InternalSubchannel closed pending transport due to address change"
                    io.grpc.Status r1 = r1.withDescription(r2)
                    r0.shutdown(r1)
                    io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel.access$1102(r0, r3)
                    io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel$Index r0 = io.grpc.internal.InternalSubchannel.access$800(r0)
                    r0.reset()
                    io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel.access$400(r0)
                L91:
                    r0 = r3
                L92:
                    if (r0 == 0) goto Le1
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.SynchronizationContext$ScheduledHandle r1 = io.grpc.internal.InternalSubchannel.access$1200(r1)
                    if (r1 == 0) goto Lc0
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.ManagedClientTransport r1 = io.grpc.internal.InternalSubchannel.access$1300(r1)
                    io.grpc.Status r2 = io.grpc.Status.UNAVAILABLE
                    java.lang.String r4 = "InternalSubchannel closed transport early due to address change"
                    io.grpc.Status r2 = r2.withDescription(r4)
                    r1.shutdown(r2)
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.SynchronizationContext$ScheduledHandle r1 = io.grpc.internal.InternalSubchannel.access$1200(r1)
                    r1.cancel()
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel.access$1202(r1, r3)
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel.access$1302(r1, r3)
                Lc0:
                    io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.internal.InternalSubchannel.access$1302(r1, r0)
                    io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                    io.grpc.SynchronizationContext r1 = io.grpc.internal.InternalSubchannel.access$1500(r0)
                    io.grpc.internal.InternalSubchannel$4$1 r2 = new io.grpc.internal.InternalSubchannel$4$1
                    r2.<init>()
                    r3 = 5
                    java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
                    io.grpc.internal.InternalSubchannel r6 = io.grpc.internal.InternalSubchannel.this
                    java.util.concurrent.ScheduledExecutorService r6 = io.grpc.internal.InternalSubchannel.access$1400(r6)
                    io.grpc.SynchronizationContext$ScheduledHandle r1 = r1.schedule(r2, r3, r5, r6)
                    io.grpc.internal.InternalSubchannel.access$1202(r0, r1)
                Le1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.InternalSubchannel.AnonymousClass4.run():void");
            }
        });
    }
}
