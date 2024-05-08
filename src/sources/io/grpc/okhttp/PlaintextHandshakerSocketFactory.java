package io.grpc.okhttp;

import io.grpc.Attributes;
import io.grpc.Grpc;
import io.grpc.SecurityLevel;
import io.grpc.internal.GrpcAttributes;
import io.grpc.okhttp.HandshakerSocketFactory;
import java.io.IOException;
import java.net.Socket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class PlaintextHandshakerSocketFactory implements HandshakerSocketFactory {
    @Override // io.grpc.okhttp.HandshakerSocketFactory
    public HandshakerSocketFactory.HandshakeResult handshake(Socket socket, Attributes attributes) throws IOException {
        return new HandshakerSocketFactory.HandshakeResult(socket, attributes.toBuilder().set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, socket.getLocalSocketAddress()).set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, socket.getRemoteSocketAddress()).set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.NONE).build(), null);
    }
}
