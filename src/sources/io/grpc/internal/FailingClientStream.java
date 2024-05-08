package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FailingClientStream extends NoopClientStream {
    private final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;
    private boolean started;
    private final ClientStreamTracer[] tracers;

    public FailingClientStream(Status status, ClientStreamTracer[] clientStreamTracerArr) {
        this(status, ClientStreamListener.RpcProgress.PROCESSED, clientStreamTracerArr);
    }

    @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        insightBuilder.appendKeyValue("error", this.error).appendKeyValue("progress", this.rpcProgress);
    }

    public Status getError() {
        return this.error;
    }

    @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        o.y(!this.started, "already started");
        this.started = true;
        for (ClientStreamTracer clientStreamTracer : this.tracers) {
            clientStreamTracer.streamClosed(this.error);
        }
        clientStreamListener.closed(this.error, this.rpcProgress, new Metadata());
    }

    public FailingClientStream(Status status, ClientStreamListener.RpcProgress rpcProgress, ClientStreamTracer[] clientStreamTracerArr) {
        o.e(!status.isOk(), "error must not be OK");
        this.error = status;
        this.rpcProgress = rpcProgress;
        this.tracers = clientStreamTracerArr;
    }
}
