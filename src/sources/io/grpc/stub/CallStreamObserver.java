package io.grpc.stub;

import io.grpc.ExperimentalApi;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/8499")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class CallStreamObserver<V> implements StreamObserver<V> {
    public abstract void disableAutoInboundFlowControl();

    public abstract boolean isReady();

    public abstract void request(int i10);

    public abstract void setMessageCompression(boolean z10);

    public abstract void setOnReadyHandler(Runnable runnable);
}
