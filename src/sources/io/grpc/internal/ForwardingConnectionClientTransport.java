package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.util.concurrent.n;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ManagedClientTransport;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class ForwardingConnectionClientTransport implements ConnectionClientTransport {
    public abstract ConnectionClientTransport delegate();

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return delegate().getLogId();
    }

    @Override // io.grpc.InternalInstrumented
    public n<InternalChannelz.SocketStats> getStats() {
        return delegate().getStats();
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        return delegate().newStream(methodDescriptor, metadata, callOptions, clientStreamTracerArr);
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        delegate().ping(pingCallback, executor);
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdown(Status status) {
        delegate().shutdown(status);
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        delegate().shutdownNow(status);
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public Runnable start(ManagedClientTransport.Listener listener) {
        return delegate().start(listener);
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }
}
