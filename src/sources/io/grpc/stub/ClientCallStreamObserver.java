package io.grpc.stub;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ClientCallStreamObserver<ReqT> extends CallStreamObserver<ReqT> {
    public abstract void cancel(String str, Throwable th);

    public void disableAutoRequestWithInitial(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.stub.CallStreamObserver
    public abstract boolean isReady();

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void request(int i10);

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void setMessageCompression(boolean z10);

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void setOnReadyHandler(Runnable runnable);
}
