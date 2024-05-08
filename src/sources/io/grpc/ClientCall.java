package io.grpc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ClientCall<ReqT, RespT> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Listener<T> {
        public void onClose(Status status, Metadata metadata) {
        }

        public void onHeaders(Metadata metadata) {
        }

        public void onMessage(T t2) {
        }

        public void onReady() {
        }
    }

    public abstract void cancel(String str, Throwable th);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2607")
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    public abstract void halfClose();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i10);

    public abstract void sendMessage(ReqT reqt);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
    public void setMessageCompression(boolean z10) {
    }

    public abstract void start(Listener<RespT> listener, Metadata metadata);
}
