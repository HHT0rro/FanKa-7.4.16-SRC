package io.grpc;

import java.util.concurrent.Executor;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/8274")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ServerCallExecutorSupplier {
    <ReqT, RespT> Executor getExecutor(ServerCall<ReqT, RespT> serverCall, Metadata metadata);
}
