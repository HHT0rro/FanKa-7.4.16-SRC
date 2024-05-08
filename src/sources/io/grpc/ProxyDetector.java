package io.grpc;

import java.io.IOException;
import java.net.SocketAddress;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/5279")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ProxyDetector {
    ProxiedSocketAddress proxyFor(SocketAddress socketAddress) throws IOException;
}
