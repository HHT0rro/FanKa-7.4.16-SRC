package io.grpc.inprocess;

import com.google.common.base.o;
import io.grpc.Deadline;
import io.grpc.ExperimentalApi;
import io.grpc.Internal;
import io.grpc.ServerBuilder;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InternalServer;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerImplBuilder;
import io.grpc.internal.SharedResourcePool;
import java.io.File;
import java.net.SocketAddress;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1783")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InProcessServerBuilder extends AbstractServerImplBuilder<InProcessServerBuilder> {
    public final SocketAddress listenAddress;
    public int maxInboundMetadataSize = Integer.MAX_VALUE;
    public ObjectPool<ScheduledExecutorService> schedulerPool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
    private final ServerImplBuilder serverImplBuilder;

    private InProcessServerBuilder(SocketAddress socketAddress) {
        this.listenAddress = (SocketAddress) o.s(socketAddress, "listenAddress");
        ServerImplBuilder serverImplBuilder = new ServerImplBuilder(new ServerImplBuilder.ClientTransportServersBuilder() { // from class: io.grpc.inprocess.InProcessServerBuilder.1InProcessClientTransportServersBuilder
            @Override // io.grpc.internal.ServerImplBuilder.ClientTransportServersBuilder
            public InternalServer buildClientTransportServers(List<? extends ServerStreamTracer.Factory> list) {
                return InProcessServerBuilder.this.buildTransportServers(list);
            }
        });
        this.serverImplBuilder = serverImplBuilder;
        serverImplBuilder.setStatsRecordStartedRpcs(false);
        serverImplBuilder.setStatsRecordFinishedRpcs(false);
        handshakeTimeout(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    public static InProcessServerBuilder forAddress(SocketAddress socketAddress) {
        return new InProcessServerBuilder(socketAddress);
    }

    public static InProcessServerBuilder forName(String str) {
        return forAddress(new InProcessSocketAddress((String) o.s(str, "name")));
    }

    public static InProcessServerBuilder forPort(int i10) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    public static String generateName() {
        return UUID.randomUUID().toString();
    }

    public InProcessServer buildTransportServers(List<? extends ServerStreamTracer.Factory> list) {
        return new InProcessServer(this, list);
    }

    public InProcessServerBuilder deadlineTicker(Deadline.Ticker ticker) {
        this.serverImplBuilder.setDeadlineTicker(ticker);
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder
    @Internal
    public ServerBuilder<?> delegate() {
        return this.serverImplBuilder;
    }

    public InProcessServerBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.schedulerPool = new FixedObjectPool((ScheduledExecutorService) o.s(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    public void setStatsEnabled(boolean z10) {
        this.serverImplBuilder.setStatsEnabled(z10);
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    public InProcessServerBuilder maxInboundMetadataSize(int i10) {
        o.e(i10 > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = i10;
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    public InProcessServerBuilder useTransportSecurity(File file, File file2) {
        throw new UnsupportedOperationException("TLS not supported in InProcessServer");
    }
}
