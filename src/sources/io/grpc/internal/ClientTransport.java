package io.grpc.internal;

import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ClientTransport extends InternalInstrumented<InternalChannelz.SocketStats> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface PingCallback {
        void onFailure(Throwable th);

        void onSuccess(long j10);
    }

    ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr);

    void ping(PingCallback pingCallback, Executor executor);
}
