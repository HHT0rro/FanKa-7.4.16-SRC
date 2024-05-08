package io.grpc.internal;

import com.google.common.base.l;
import io.grpc.Attributes;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ServerCallInfoImpl<ReqT, RespT> extends ServerStreamTracer.ServerCallInfo<ReqT, RespT> {
    private final Attributes attributes;
    private final String authority;
    private final MethodDescriptor<ReqT, RespT> methodDescriptor;

    public ServerCallInfoImpl(MethodDescriptor<ReqT, RespT> methodDescriptor, Attributes attributes, String str) {
        this.methodDescriptor = methodDescriptor;
        this.attributes = attributes;
        this.authority = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ServerCallInfoImpl)) {
            return false;
        }
        ServerCallInfoImpl serverCallInfoImpl = (ServerCallInfoImpl) obj;
        return l.a(this.methodDescriptor, serverCallInfoImpl.methodDescriptor) && l.a(this.attributes, serverCallInfoImpl.attributes) && l.a(this.authority, serverCallInfoImpl.authority);
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public String getAuthority() {
        return this.authority;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.methodDescriptor;
    }

    public int hashCode() {
        return l.b(this.methodDescriptor, this.attributes, this.authority);
    }
}
