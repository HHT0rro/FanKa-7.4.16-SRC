package io.grpc.internal;

import com.google.common.base.o;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.t;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FailingClientTransport implements ClientTransport {
    public final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;

    public FailingClientTransport(Status status, ClientStreamListener.RpcProgress rpcProgress) {
        o.e(!status.isOk(), "error must not be OK");
        this.error = status;
        this.rpcProgress = rpcProgress;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        throw new UnsupportedOperationException("Not a real transport");
    }

    @Override // io.grpc.InternalInstrumented
    public n<InternalChannelz.SocketStats> getStats() {
        t a10 = t.a();
        a10.set(null);
        return a10;
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        return new FailingClientStream(this.error, this.rpcProgress, clientStreamTracerArr);
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(final ClientTransport.PingCallback pingCallback, Executor executor) {
        executor.execute(new Runnable() { // from class: io.grpc.internal.FailingClientTransport.1
            @Override // java.lang.Runnable
            public void run() {
                pingCallback.onFailure(FailingClientTransport.this.error.asException());
            }
        });
    }
}
