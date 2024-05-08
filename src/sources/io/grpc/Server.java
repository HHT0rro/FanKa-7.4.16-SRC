package io.grpc;

import io.grpc.Context;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class Server {
    public static final Context.Key<Server> SERVER_CONTEXT_KEY = Context.key("io.grpc.Server");

    public abstract void awaitTermination() throws InterruptedException;

    public abstract boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException;

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getImmutableServices() {
        return Collections.emptyList();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5332")
    public List<? extends SocketAddress> getListenSockets() {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.emptyList();
    }

    public int getPort() {
        return -1;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getServices() {
        return Collections.emptyList();
    }

    public abstract boolean isShutdown();

    public abstract boolean isTerminated();

    public abstract Server shutdown();

    public abstract Server shutdownNow();

    public abstract Server start() throws IOException;
}
