package io.grpc;

import com.google.common.base.o;
import io.grpc.ServerBuilder;
import io.grpc.ServerStreamTracer;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ServerBuilder<T extends ServerBuilder<T>> {
    public static ServerBuilder<?> forPort(int i10) {
        return ServerProvider.provider().builderForPort(i10);
    }

    private T thisT() {
        return this;
    }

    public abstract T addService(BindableService bindableService);

    public abstract T addService(ServerServiceDefinition serverServiceDefinition);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/7925")
    public final T addServices(List<ServerServiceDefinition> list) {
        o.s(list, "services");
        Iterator<ServerServiceDefinition> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            addService(iterator2.next());
        }
        return thisT();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
    public T addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2132")
    public T addTransportFilter(ServerTransportFilter serverTransportFilter) {
        throw new UnsupportedOperationException();
    }

    public abstract Server build();

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/8274")
    public T callExecutor(ServerCallExecutorSupplier serverCallExecutorSupplier) {
        return thisT();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T compressorRegistry(CompressorRegistry compressorRegistry);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T decompressorRegistry(DecompressorRegistry decompressorRegistry);

    public abstract T directExecutor();

    public abstract T executor(Executor executor);

    public abstract T fallbackHandlerRegistry(HandlerRegistry handlerRegistry);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3706")
    public T handshakeTimeout(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T intercept(ServerInterceptor serverInterceptor) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T keepAliveTime(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T keepAliveTimeout(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T maxConnectionAge(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T maxConnectionAgeGrace(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T maxConnectionIdle(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T maxInboundMessageSize(int i10) {
        o.e(i10 >= 0, "bytes must be >= 0");
        return thisT();
    }

    public T maxInboundMetadataSize(int i10) {
        o.e(i10 > 0, "maxInboundMetadataSize must be > 0");
        return thisT();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T permitKeepAliveTime(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T permitKeepAliveWithoutCalls(boolean z10) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4017")
    public T setBinaryLog(BinaryLog binaryLog) {
        throw new UnsupportedOperationException();
    }

    public abstract T useTransportSecurity(File file, File file2);

    public T useTransportSecurity(InputStream inputStream, InputStream inputStream2) {
        throw new UnsupportedOperationException();
    }
}
