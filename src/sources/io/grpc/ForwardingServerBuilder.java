package io.grpc;

import com.google.common.base.j;
import io.grpc.ServerBuilder;
import io.grpc.ServerStreamTracer;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/7393")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingServerBuilder<T extends ServerBuilder<T>> extends ServerBuilder<T> {
    public static ServerBuilder<?> forPort(int i10) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    private T thisT() {
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public T addService(ServerServiceDefinition serverServiceDefinition) {
        delegate().addService(serverServiceDefinition);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        delegate().addStreamTracerFactory(factory);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addTransportFilter(ServerTransportFilter serverTransportFilter) {
        delegate().addTransportFilter(serverTransportFilter);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public Server build() {
        return delegate().build();
    }

    @Override // io.grpc.ServerBuilder
    public T callExecutor(ServerCallExecutorSupplier serverCallExecutorSupplier) {
        delegate().callExecutor(serverCallExecutorSupplier);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T compressorRegistry(CompressorRegistry compressorRegistry) {
        delegate().compressorRegistry(compressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delegate().decompressorRegistry(decompressorRegistry);
        return thisT();
    }

    public abstract ServerBuilder<?> delegate();

    @Override // io.grpc.ServerBuilder
    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T executor(Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T fallbackHandlerRegistry(HandlerRegistry handlerRegistry) {
        delegate().fallbackHandlerRegistry(handlerRegistry);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T handshakeTimeout(long j10, TimeUnit timeUnit) {
        delegate().handshakeTimeout(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T intercept(ServerInterceptor serverInterceptor) {
        delegate().intercept(serverInterceptor);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T keepAliveTime(long j10, TimeUnit timeUnit) {
        delegate().keepAliveTime(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T keepAliveTimeout(long j10, TimeUnit timeUnit) {
        delegate().keepAliveTimeout(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxConnectionAge(long j10, TimeUnit timeUnit) {
        delegate().maxConnectionAge(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxConnectionAgeGrace(long j10, TimeUnit timeUnit) {
        delegate().maxConnectionAgeGrace(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxConnectionIdle(long j10, TimeUnit timeUnit) {
        delegate().maxConnectionIdle(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxInboundMessageSize(int i10) {
        delegate().maxInboundMessageSize(i10);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxInboundMetadataSize(int i10) {
        delegate().maxInboundMetadataSize(i10);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T permitKeepAliveTime(long j10, TimeUnit timeUnit) {
        delegate().permitKeepAliveTime(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T permitKeepAliveWithoutCalls(boolean z10) {
        delegate().permitKeepAliveWithoutCalls(z10);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T setBinaryLog(BinaryLog binaryLog) {
        delegate().setBinaryLog(binaryLog);
        return thisT();
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }

    @Override // io.grpc.ServerBuilder
    public T useTransportSecurity(File file, File file2) {
        delegate().useTransportSecurity(file, file2);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addService(BindableService bindableService) {
        delegate().addService(bindableService);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T useTransportSecurity(InputStream inputStream, InputStream inputStream2) {
        delegate().useTransportSecurity(inputStream, inputStream2);
        return thisT();
    }
}
