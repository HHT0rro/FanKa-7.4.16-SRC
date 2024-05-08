package io.grpc;

import io.grpc.ClientCall;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingClientCallListener<RespT> extends PartialForwardingClientCallListener<RespT> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class SimpleForwardingClientCallListener<RespT> extends ForwardingClientCallListener<RespT> {
        private final ClientCall.Listener<RespT> delegate;

        public SimpleForwardingClientCallListener(ClientCall.Listener<RespT> listener) {
            this.delegate = listener;
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener
        public ClientCall.Listener<RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onClose(Status status, Metadata metadata) {
            super.onClose(status, metadata);
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onHeaders(Metadata metadata) {
            super.onHeaders(metadata);
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onReady() {
            super.onReady();
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // io.grpc.PartialForwardingClientCallListener
    public abstract ClientCall.Listener<RespT> delegate();

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onClose(Status status, Metadata metadata) {
        super.onClose(status, metadata);
    }

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onHeaders(Metadata metadata) {
        super.onHeaders(metadata);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onMessage(RespT respt) {
        delegate().onMessage(respt);
    }

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onReady() {
        super.onReady();
    }

    @Override // io.grpc.PartialForwardingClientCallListener
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
