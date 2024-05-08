package io.grpc.internal;

import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.t;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ManagedClientTransport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DelayedClientTransport implements ManagedClientTransport {
    private final Executor defaultAppExecutor;
    private LoadBalancer.SubchannelPicker lastPicker;
    private long lastPickerVersion;
    private ManagedClientTransport.Listener listener;
    private Runnable reportTransportInUse;
    private Runnable reportTransportNotInUse;
    private Runnable reportTransportTerminated;
    private Status shutdownStatus;
    private final SynchronizationContext syncContext;
    private final InternalLogId logId = InternalLogId.allocate((Class<?>) DelayedClientTransport.class, (String) null);
    private final Object lock = new Object();
    private Collection<PendingStream> pendingStreams = new LinkedHashSet();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class PendingStream extends DelayedStream {
        private final LoadBalancer.PickSubchannelArgs args;
        private final Context context;
        private final ClientStreamTracer[] tracers;

        /* JADX INFO: Access modifiers changed from: private */
        public Runnable createRealStream(ClientTransport clientTransport) {
            Context attach = this.context.attach();
            try {
                ClientStream newStream = clientTransport.newStream(this.args.getMethodDescriptor(), this.args.getHeaders(), this.args.getCallOptions(), this.tracers);
                this.context.detach(attach);
                return setStream(newStream);
            } catch (Throwable th) {
                this.context.detach(attach);
                throw th;
            }
        }

        @Override // io.grpc.internal.DelayedStream, io.grpc.internal.ClientStream
        public void appendTimeoutInsight(InsightBuilder insightBuilder) {
            if (this.args.getCallOptions().isWaitForReady()) {
                insightBuilder.append("wait_for_ready");
            }
            super.appendTimeoutInsight(insightBuilder);
        }

        @Override // io.grpc.internal.DelayedStream, io.grpc.internal.ClientStream
        public void cancel(Status status) {
            super.cancel(status);
            synchronized (DelayedClientTransport.this.lock) {
                if (DelayedClientTransport.this.reportTransportTerminated != null) {
                    boolean remove = DelayedClientTransport.this.pendingStreams.remove(this);
                    if (!DelayedClientTransport.this.hasPendingStreams() && remove) {
                        DelayedClientTransport.this.syncContext.executeLater(DelayedClientTransport.this.reportTransportNotInUse);
                        if (DelayedClientTransport.this.shutdownStatus != null) {
                            DelayedClientTransport.this.syncContext.executeLater(DelayedClientTransport.this.reportTransportTerminated);
                            DelayedClientTransport.this.reportTransportTerminated = null;
                        }
                    }
                }
            }
            DelayedClientTransport.this.syncContext.drain();
        }

        @Override // io.grpc.internal.DelayedStream
        public void onEarlyCancellation(Status status) {
            for (ClientStreamTracer clientStreamTracer : this.tracers) {
                clientStreamTracer.streamClosed(status);
            }
        }

        private PendingStream(LoadBalancer.PickSubchannelArgs pickSubchannelArgs, ClientStreamTracer[] clientStreamTracerArr) {
            this.context = Context.current();
            this.args = pickSubchannelArgs;
            this.tracers = clientStreamTracerArr;
        }
    }

    public DelayedClientTransport(Executor executor, SynchronizationContext synchronizationContext) {
        this.defaultAppExecutor = executor;
        this.syncContext = synchronizationContext;
    }

    private PendingStream createPendingStream(LoadBalancer.PickSubchannelArgs pickSubchannelArgs, ClientStreamTracer[] clientStreamTracerArr) {
        PendingStream pendingStream = new PendingStream(pickSubchannelArgs, clientStreamTracerArr);
        this.pendingStreams.add(pendingStream);
        if (getPendingStreamsCount() == 1) {
            this.syncContext.executeLater(this.reportTransportInUse);
        }
        return pendingStream;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    public final int getPendingStreamsCount() {
        int size;
        synchronized (this.lock) {
            size = this.pendingStreams.size();
        }
        return size;
    }

    @Override // io.grpc.InternalInstrumented
    public n<InternalChannelz.SocketStats> getStats() {
        t a10 = t.a();
        a10.set(null);
        return a10;
    }

    public final boolean hasPendingStreams() {
        boolean z10;
        synchronized (this.lock) {
            z10 = !this.pendingStreams.isEmpty();
        }
        return z10;
    }

    @Override // io.grpc.internal.ClientTransport
    public final ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        ClientStream failingClientStream;
        try {
            PickSubchannelArgsImpl pickSubchannelArgsImpl = new PickSubchannelArgsImpl(methodDescriptor, metadata, callOptions);
            LoadBalancer.SubchannelPicker subchannelPicker = null;
            long j10 = -1;
            while (true) {
                synchronized (this.lock) {
                    if (this.shutdownStatus != null) {
                        failingClientStream = new FailingClientStream(this.shutdownStatus, clientStreamTracerArr);
                        break;
                    }
                    LoadBalancer.SubchannelPicker subchannelPicker2 = this.lastPicker;
                    if (subchannelPicker2 != null) {
                        if (subchannelPicker != null && j10 == this.lastPickerVersion) {
                            failingClientStream = createPendingStream(pickSubchannelArgsImpl, clientStreamTracerArr);
                            break;
                        }
                        j10 = this.lastPickerVersion;
                        ClientTransport transportFromPickResult = GrpcUtil.getTransportFromPickResult(subchannelPicker2.pickSubchannel(pickSubchannelArgsImpl), callOptions.isWaitForReady());
                        if (transportFromPickResult != null) {
                            failingClientStream = transportFromPickResult.newStream(pickSubchannelArgsImpl.getMethodDescriptor(), pickSubchannelArgsImpl.getHeaders(), pickSubchannelArgsImpl.getCallOptions(), clientStreamTracerArr);
                            break;
                        }
                        subchannelPicker = subchannelPicker2;
                    } else {
                        failingClientStream = createPendingStream(pickSubchannelArgsImpl, clientStreamTracerArr);
                        break;
                    }
                }
            }
            return failingClientStream;
        } finally {
            this.syncContext.drain();
        }
    }

    @Override // io.grpc.internal.ClientTransport
    public final void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        throw new UnsupportedOperationException("This method is not expected to be called");
    }

    public final void reprocess(LoadBalancer.SubchannelPicker subchannelPicker) {
        Runnable runnable;
        synchronized (this.lock) {
            this.lastPicker = subchannelPicker;
            this.lastPickerVersion++;
            if (subchannelPicker != null && hasPendingStreams()) {
                ArrayList arrayList = new ArrayList(this.pendingStreams);
                ArrayList arrayList2 = new ArrayList();
                Iterator iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    PendingStream pendingStream = (PendingStream) iterator2.next();
                    LoadBalancer.PickResult pickSubchannel = subchannelPicker.pickSubchannel(pendingStream.args);
                    CallOptions callOptions = pendingStream.args.getCallOptions();
                    ClientTransport transportFromPickResult = GrpcUtil.getTransportFromPickResult(pickSubchannel, callOptions.isWaitForReady());
                    if (transportFromPickResult != null) {
                        Executor executor = this.defaultAppExecutor;
                        if (callOptions.getExecutor() != null) {
                            executor = callOptions.getExecutor();
                        }
                        Runnable createRealStream = pendingStream.createRealStream(transportFromPickResult);
                        if (createRealStream != null) {
                            executor.execute(createRealStream);
                        }
                        arrayList2.add(pendingStream);
                    }
                }
                synchronized (this.lock) {
                    if (hasPendingStreams()) {
                        this.pendingStreams.removeAll(arrayList2);
                        if (this.pendingStreams.isEmpty()) {
                            this.pendingStreams = new LinkedHashSet();
                        }
                        if (!hasPendingStreams()) {
                            this.syncContext.executeLater(this.reportTransportNotInUse);
                            if (this.shutdownStatus != null && (runnable = this.reportTransportTerminated) != null) {
                                this.syncContext.executeLater(runnable);
                                this.reportTransportTerminated = null;
                            }
                        }
                        this.syncContext.drain();
                    }
                }
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public final void shutdown(final Status status) {
        Runnable runnable;
        synchronized (this.lock) {
            if (this.shutdownStatus != null) {
                return;
            }
            this.shutdownStatus = status;
            this.syncContext.executeLater(new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientTransport.this.listener.transportShutdown(status);
                }
            });
            if (!hasPendingStreams() && (runnable = this.reportTransportTerminated) != null) {
                this.syncContext.executeLater(runnable);
                this.reportTransportTerminated = null;
            }
            this.syncContext.drain();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public final void shutdownNow(Status status) {
        Collection<PendingStream> collection;
        Runnable runnable;
        shutdown(status);
        synchronized (this.lock) {
            collection = this.pendingStreams;
            runnable = this.reportTransportTerminated;
            this.reportTransportTerminated = null;
            if (!collection.isEmpty()) {
                this.pendingStreams = Collections.emptyList();
            }
        }
        if (runnable != null) {
            for (PendingStream pendingStream : collection) {
                Runnable stream = pendingStream.setStream(new FailingClientStream(status, ClientStreamListener.RpcProgress.REFUSED, pendingStream.tracers));
                if (stream != null) {
                    stream.run();
                }
            }
            this.syncContext.execute(runnable);
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public final Runnable start(final ManagedClientTransport.Listener listener) {
        this.listener = listener;
        this.reportTransportInUse = new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.1
            @Override // java.lang.Runnable
            public void run() {
                listener.transportInUse(true);
            }
        };
        this.reportTransportNotInUse = new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.2
            @Override // java.lang.Runnable
            public void run() {
                listener.transportInUse(false);
            }
        };
        this.reportTransportTerminated = new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.3
            @Override // java.lang.Runnable
            public void run() {
                listener.transportTerminated();
            }
        };
        return null;
    }
}
