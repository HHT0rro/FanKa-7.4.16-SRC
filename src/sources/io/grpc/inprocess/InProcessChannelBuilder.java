package io.grpc.inprocess;

import android.view.textclassifier.TextClassifier;
import com.google.common.base.o;
import com.huawei.quickcard.base.Attributes;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ExperimentalApi;
import io.grpc.Internal;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.SharedResourceHolder;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1783")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InProcessChannelBuilder extends AbstractManagedChannelImplBuilder<InProcessChannelBuilder> {
    private final ManagedChannelImplBuilder managedChannelImplBuilder;
    private ScheduledExecutorService scheduledExecutorService;
    private int maxInboundMetadataSize = Integer.MAX_VALUE;
    private boolean transportIncludeStatusCause = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class InProcessClientTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final boolean includeCauseWithStatus;
        private final int maxInboundMetadataSize;
        private final ScheduledExecutorService timerService;
        private final boolean useSharedTimer;

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.useSharedTimer) {
                SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timerService);
            }
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timerService;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportFactory.ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger) {
            if (!this.closed) {
                return new InProcessTransport(socketAddress, this.maxInboundMetadataSize, clientTransportOptions.getAuthority(), clientTransportOptions.getUserAgent(), clientTransportOptions.getEagAttributes(), this.includeCauseWithStatus);
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCredentials) {
            return null;
        }

        private InProcessClientTransportFactory(ScheduledExecutorService scheduledExecutorService, int i10, boolean z10) {
            boolean z11 = scheduledExecutorService == null;
            this.useSharedTimer = z11;
            this.timerService = z11 ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : scheduledExecutorService;
            this.maxInboundMetadataSize = i10;
            this.includeCauseWithStatus = z10;
        }
    }

    private InProcessChannelBuilder(SocketAddress socketAddress, String str) {
        if (socketAddress != null) {
            this.managedChannelImplBuilder = new ManagedChannelImplBuilder(socketAddress, "localhost", new ManagedChannelImplBuilder.ClientTransportFactoryBuilder() { // from class: io.grpc.inprocess.InProcessChannelBuilder.1InProcessChannelTransportFactoryBuilder
                @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
                public ClientTransportFactory buildClientTransportFactory() {
                    return InProcessChannelBuilder.this.buildTransportFactory();
                }
            }, null);
        } else {
            this.managedChannelImplBuilder = new ManagedChannelImplBuilder(str, new ManagedChannelImplBuilder.ClientTransportFactoryBuilder() { // from class: io.grpc.inprocess.InProcessChannelBuilder.1InProcessChannelTransportFactoryBuilder
                @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
                public ClientTransportFactory buildClientTransportFactory() {
                    return InProcessChannelBuilder.this.buildTransportFactory();
                }
            }, null);
        }
        this.managedChannelImplBuilder.setStatsRecordStartedRpcs(false);
        this.managedChannelImplBuilder.setStatsRecordFinishedRpcs(false);
        this.managedChannelImplBuilder.setStatsRecordRetryMetrics(false);
        this.managedChannelImplBuilder.disableRetry();
    }

    public static InProcessChannelBuilder forAddress(SocketAddress socketAddress) {
        return new InProcessChannelBuilder((SocketAddress) o.s(socketAddress, TextClassifier.TYPE_ADDRESS), null);
    }

    public static InProcessChannelBuilder forName(String str) {
        return forAddress(new InProcessSocketAddress((String) o.s(str, "name")));
    }

    public static InProcessChannelBuilder forTarget(String str) {
        return new InProcessChannelBuilder(null, (String) o.s(str, Attributes.Style.TARGET));
    }

    public ClientTransportFactory buildTransportFactory() {
        return new InProcessClientTransportFactory(this.scheduledExecutorService, this.maxInboundMetadataSize, this.transportIncludeStatusCause);
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    @Internal
    public ManagedChannelBuilder<?> delegate() {
        return this.managedChannelImplBuilder;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder keepAliveTime(long j10, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder keepAliveTimeout(long j10, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder keepAliveWithoutCalls(boolean z10) {
        return this;
    }

    public InProcessChannelBuilder propagateCauseWithStatus(boolean z10) {
        this.transportIncludeStatusCause = z10;
        return this;
    }

    public InProcessChannelBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = (ScheduledExecutorService) o.s(scheduledExecutorService, "scheduledExecutorService");
        return this;
    }

    public void setStatsEnabled(boolean z10) {
        this.managedChannelImplBuilder.setStatsEnabled(z10);
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder usePlaintext() {
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder useTransportSecurity() {
        return this;
    }

    public static InProcessChannelBuilder forAddress(String str, int i10) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder maxInboundMessageSize(int i10) {
        return (InProcessChannelBuilder) super.maxInboundMessageSize(i10);
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder maxInboundMetadataSize(int i10) {
        o.e(i10 > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = i10;
        return this;
    }
}
