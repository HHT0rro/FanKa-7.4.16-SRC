package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.InternalConfigSelector;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ClientStreamListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SubchannelChannel extends Channel {
    public static final Status NOT_READY_ERROR;
    public static final Status WAIT_FOR_READY_ERROR;
    private static final FailingClientTransport notReadyTransport;
    private final CallTracer callsTracer;
    private final AtomicReference<InternalConfigSelector> configSelector;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final Executor executor;
    private final InternalSubchannel subchannel;
    private final ClientCallImpl.ClientStreamProvider transportProvider = new ClientCallImpl.ClientStreamProvider() { // from class: io.grpc.internal.SubchannelChannel.1
        @Override // io.grpc.internal.ClientCallImpl.ClientStreamProvider
        public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context) {
            ClientTransport transport = SubchannelChannel.this.subchannel.getTransport();
            if (transport == null) {
                transport = SubchannelChannel.notReadyTransport;
            }
            ClientStreamTracer[] clientStreamTracers = GrpcUtil.getClientStreamTracers(callOptions, metadata, 0, false);
            Context attach = context.attach();
            try {
                return transport.newStream(methodDescriptor, metadata, callOptions, clientStreamTracers);
            } finally {
                context.detach(attach);
            }
        }
    };

    static {
        Status status = Status.UNAVAILABLE;
        Status withDescription = status.withDescription("Subchannel is NOT READY");
        NOT_READY_ERROR = withDescription;
        WAIT_FOR_READY_ERROR = status.withDescription("wait-for-ready RPC is not supported on Subchannel.asChannel()");
        notReadyTransport = new FailingClientTransport(withDescription, ClientStreamListener.RpcProgress.MISCARRIED);
    }

    public SubchannelChannel(InternalSubchannel internalSubchannel, Executor executor, ScheduledExecutorService scheduledExecutorService, CallTracer callTracer, AtomicReference<InternalConfigSelector> atomicReference) {
        this.subchannel = (InternalSubchannel) o.s(internalSubchannel, "subchannel");
        this.executor = (Executor) o.s(executor, "executor");
        this.deadlineCancellationExecutor = (ScheduledExecutorService) o.s(scheduledExecutorService, "deadlineCancellationExecutor");
        this.callsTracer = (CallTracer) o.s(callTracer, "callsTracer");
        this.configSelector = (AtomicReference) o.s(atomicReference, "configSelector");
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.subchannel.getAuthority();
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        final Executor executor = callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor();
        if (callOptions.isWaitForReady()) {
            return new ClientCall<RequestT, ResponseT>() { // from class: io.grpc.internal.SubchannelChannel.2
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
                public void sendMessage(RequestT requestt) {
                }

                @Override // io.grpc.ClientCall
                public void start(final ClientCall.Listener<ResponseT> listener, Metadata metadata) {
                    executor.execute(new Runnable() { // from class: io.grpc.internal.SubchannelChannel.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            listener.onClose(SubchannelChannel.WAIT_FOR_READY_ERROR, new Metadata());
                        }
                    });
                }
            };
        }
        return new ClientCallImpl(methodDescriptor, executor, callOptions.withOption(GrpcUtil.CALL_OPTIONS_RPC_OWNED_BY_BALANCER, Boolean.TRUE), this.transportProvider, this.deadlineCancellationExecutor, this.callsTracer, this.configSelector.get());
    }
}
