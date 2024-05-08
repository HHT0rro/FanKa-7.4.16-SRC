package io.grpc.internal;

import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface InternalServer {
    SocketAddress getListenSocketAddress();

    List<? extends SocketAddress> getListenSocketAddresses();

    InternalInstrumented<InternalChannelz.SocketStats> getListenSocketStats();

    List<InternalInstrumented<InternalChannelz.SocketStats>> getListenSocketStatsList();

    void shutdown();

    void start(ServerListener serverListener) throws IOException;
}
