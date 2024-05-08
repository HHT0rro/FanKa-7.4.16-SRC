package io.grpc.stub;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ClientResponseObserver<ReqT, RespT> extends StreamObserver<RespT> {
    void beforeStart(ClientCallStreamObserver<ReqT> clientCallStreamObserver);
}
