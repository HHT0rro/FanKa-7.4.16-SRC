package io.grpc;

import com.google.common.base.j;
import io.grpc.ServerCall;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class PartialForwardingServerCallListener<ReqT> extends ServerCall.Listener<ReqT> {
    public abstract ServerCall.Listener<?> delegate();

    @Override // io.grpc.ServerCall.Listener
    public void onCancel() {
        delegate().onCancel();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onComplete() {
        delegate().onComplete();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onHalfClose() {
        delegate().onHalfClose();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onReady() {
        delegate().onReady();
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }
}
