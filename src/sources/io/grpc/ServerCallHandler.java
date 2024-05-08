package io.grpc;

import io.grpc.ServerCall;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ServerCallHandler<RequestT, ResponseT> {
    ServerCall.Listener<RequestT> startCall(ServerCall<RequestT, ResponseT> serverCall, Metadata metadata);
}
