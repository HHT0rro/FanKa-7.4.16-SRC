package io.grpc;

import java.io.Closeable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4017")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BinaryLog implements Closeable {
    public abstract Channel wrapChannel(Channel channel);

    public abstract <ReqT, RespT> ServerMethodDefinition<?, ?> wrapMethodDefinition(ServerMethodDefinition<ReqT, RespT> serverMethodDefinition);
}
