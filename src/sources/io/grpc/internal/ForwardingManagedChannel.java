package io.grpc.internal;

import com.google.common.base.j;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class ForwardingManagedChannel extends ManagedChannel {
    private final ManagedChannel delegate;

    public ForwardingManagedChannel(ManagedChannel managedChannel) {
        this.delegate = managedChannel;
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.delegate.authority();
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j10, timeUnit);
    }

    @Override // io.grpc.ManagedChannel
    public void enterIdle() {
        this.delegate.enterIdle();
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean z10) {
        return this.delegate.getState(z10);
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return this.delegate.newCall(methodDescriptor, callOptions);
    }

    @Override // io.grpc.ManagedChannel
    public void notifyWhenStateChanged(ConnectivityState connectivityState, Runnable runnable) {
        this.delegate.notifyWhenStateChanged(connectivityState, runnable);
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.delegate.resetConnectBackoff();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        return this.delegate.shutdown();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public String toString() {
        return j.c(this).d("delegate", this.delegate).toString();
    }
}
