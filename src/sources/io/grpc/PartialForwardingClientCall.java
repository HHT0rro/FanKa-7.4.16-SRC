package io.grpc;

import com.google.common.base.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class PartialForwardingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    @Override // io.grpc.ClientCall
    public void cancel(String str, Throwable th) {
        delegate().cancel(str, th);
    }

    public abstract ClientCall<?, ?> delegate();

    @Override // io.grpc.ClientCall
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        delegate().halfClose();
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.ClientCall
    public void request(int i10) {
        delegate().request(i10);
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean z10) {
        delegate().setMessageCompression(z10);
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }
}
