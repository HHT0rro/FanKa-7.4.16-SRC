package io.grpc.okhttp;

import com.google.common.base.o;
import io.grpc.Attributes;
import io.grpc.InternalChannelz;
import java.io.IOException;
import java.net.Socket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
interface HandshakerSocketFactory {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class HandshakeResult {
        public final Attributes attributes;
        public final InternalChannelz.Security securityInfo;
        public final Socket socket;

        public HandshakeResult(Socket socket, Attributes attributes, InternalChannelz.Security security) {
            this.socket = (Socket) o.s(socket, "socket");
            this.attributes = (Attributes) o.s(attributes, "attributes");
            this.securityInfo = security;
        }
    }

    HandshakeResult handshake(Socket socket, Attributes attributes) throws IOException;
}
