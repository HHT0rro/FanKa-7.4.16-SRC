package io.grpc;

import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ManagedChannel extends Channel {
    public abstract boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException;

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4056")
    public void enterIdle() {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4359")
    public ConnectivityState getState(boolean z10) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public abstract boolean isShutdown();

    public abstract boolean isTerminated();

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4359")
    public void notifyWhenStateChanged(ConnectivityState connectivityState, Runnable runnable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4056")
    public void resetConnectBackoff() {
    }

    public abstract ManagedChannel shutdown();

    public abstract ManagedChannel shutdownNow();
}
