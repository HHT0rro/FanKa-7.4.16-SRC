package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.o;
import io.grpc.NameResolver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class ForwardingNameResolver extends NameResolver {
    private final NameResolver delegate;

    public ForwardingNameResolver(NameResolver nameResolver) {
        o.s(nameResolver, "delegate can not be null");
        this.delegate = nameResolver;
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.delegate.getServiceAuthority();
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        this.delegate.refresh();
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override // io.grpc.NameResolver
    @Deprecated
    public void start(NameResolver.Listener listener) {
        this.delegate.start(listener);
    }

    public String toString() {
        return j.c(this).d("delegate", this.delegate).toString();
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        this.delegate.start(listener2);
    }
}
