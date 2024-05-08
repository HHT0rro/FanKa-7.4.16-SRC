package io.grpc.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.base.l;
import com.google.common.base.o;
import io.grpc.CallOptions;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class PickSubchannelArgsImpl extends LoadBalancer.PickSubchannelArgs {
    private final CallOptions callOptions;
    private final Metadata headers;
    private final MethodDescriptor<?, ?> method;

    public PickSubchannelArgsImpl(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        this.method = (MethodDescriptor) o.s(methodDescriptor, "method");
        this.headers = (Metadata) o.s(metadata, TTDownloadField.TT_HEADERS);
        this.callOptions = (CallOptions) o.s(callOptions, "callOptions");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PickSubchannelArgsImpl.class != obj.getClass()) {
            return false;
        }
        PickSubchannelArgsImpl pickSubchannelArgsImpl = (PickSubchannelArgsImpl) obj;
        return l.a(this.callOptions, pickSubchannelArgsImpl.callOptions) && l.a(this.headers, pickSubchannelArgsImpl.headers) && l.a(this.method, pickSubchannelArgsImpl.method);
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public CallOptions getCallOptions() {
        return this.callOptions;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public Metadata getHeaders() {
        return this.headers;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public MethodDescriptor<?, ?> getMethodDescriptor() {
        return this.method;
    }

    public int hashCode() {
        return l.b(this.callOptions, this.headers, this.method);
    }

    public final String toString() {
        return "[method=" + ((Object) this.method) + " headers=" + ((Object) this.headers) + " callOptions=" + ((Object) this.callOptions) + "]";
    }
}
