package io.grpc;

import io.grpc.ServerCall;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ServerInterceptor {
    <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler);
}
