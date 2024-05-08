package io.grpc;

import io.grpc.ClientCall;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingClientCall<ReqT, RespT> extends PartialForwardingClientCall<ReqT, RespT> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class SimpleForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private final ClientCall<ReqT, RespT> delegate;

        public SimpleForwardingClientCall(ClientCall<ReqT, RespT> clientCall) {
            this.delegate = clientCall;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void cancel(String str, Throwable th) {
            super.cancel(str, th);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        public ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ Attributes getAttributes() {
            return super.getAttributes();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void halfClose() {
            super.halfClose();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ boolean isReady() {
            return super.isReady();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void request(int i10) {
            super.request(i10);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void setMessageCompression(boolean z10) {
            super.setMessageCompression(z10);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void cancel(String str, Throwable th) {
        super.cancel(str, th);
    }

    @Override // io.grpc.PartialForwardingClientCall
    public abstract ClientCall<ReqT, RespT> delegate();

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ Attributes getAttributes() {
        return super.getAttributes();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void halfClose() {
        super.halfClose();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void request(int i10) {
        super.request(i10);
    }

    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT reqt) {
        delegate().sendMessage(reqt);
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void setMessageCompression(boolean z10) {
        super.setMessageCompression(z10);
    }

    @Override // io.grpc.ClientCall
    public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
        delegate().start(listener, metadata);
    }

    @Override // io.grpc.PartialForwardingClientCall
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
