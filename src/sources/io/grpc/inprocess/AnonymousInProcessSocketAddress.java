package io.grpc.inprocess;

import com.google.common.base.o;
import io.grpc.ExperimentalApi;
import java.io.IOException;
import java.net.SocketAddress;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/8626")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class AnonymousInProcessSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -8567592561863414695L;
    private InProcessServer server;

    public synchronized void clearServer(InProcessServer inProcessServer) {
        o.x(this.server == inProcessServer);
        this.server = null;
    }

    public synchronized InProcessServer getServer() {
        return this.server;
    }

    public synchronized void setServer(InProcessServer inProcessServer) throws IOException {
        if (this.server == null) {
            this.server = inProcessServer;
        } else {
            throw new IOException("Server instance already registered");
        }
    }
}
