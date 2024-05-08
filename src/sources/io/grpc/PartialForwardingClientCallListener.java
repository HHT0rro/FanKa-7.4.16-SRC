package io.grpc;

import com.google.common.base.j;
import io.grpc.ClientCall;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class PartialForwardingClientCallListener<RespT> extends ClientCall.Listener<RespT> {
    public abstract ClientCall.Listener<?> delegate();

    @Override // io.grpc.ClientCall.Listener
    public void onClose(Status status, Metadata metadata) {
        delegate().onClose(status, metadata);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onHeaders(Metadata metadata) {
        delegate().onHeaders(metadata);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onReady() {
        delegate().onReady();
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }
}
