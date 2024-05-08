package io.grpc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ClientInterceptor {
    <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel);
}
