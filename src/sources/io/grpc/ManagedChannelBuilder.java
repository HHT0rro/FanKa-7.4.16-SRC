package io.grpc;

import com.google.common.base.o;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ManagedChannelBuilder<T extends ManagedChannelBuilder<T>> {
    public static ManagedChannelBuilder<?> forAddress(String str, int i10) {
        return ManagedChannelProvider.provider().builderForAddress(str, i10);
    }

    public static ManagedChannelBuilder<?> forTarget(String str) {
        return ManagedChannelProvider.provider().builderForTarget(str);
    }

    private T thisT() {
        return this;
    }

    public abstract ManagedChannel build();

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T compressorRegistry(CompressorRegistry compressorRegistry);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T decompressorRegistry(DecompressorRegistry decompressorRegistry);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    public T defaultLoadBalancingPolicy(String str) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5189")
    public T defaultServiceConfig(Map<String, ?> map) {
        throw new UnsupportedOperationException();
    }

    public abstract T directExecutor();

    public T disableRetry() {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5189")
    public T disableServiceConfigLookUp() {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3399")
    public T enableFullStreamDecompression() {
        throw new UnsupportedOperationException();
    }

    public T enableRetry() {
        throw new UnsupportedOperationException();
    }

    public abstract T executor(Executor executor);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2022")
    public abstract T idleTimeout(long j10, TimeUnit timeUnit);

    public abstract T intercept(List<ClientInterceptor> list);

    public abstract T intercept(ClientInterceptor... clientInterceptorArr);

    public T keepAliveTime(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T keepAliveTimeout(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T keepAliveWithoutCalls(boolean z10) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
    public T maxHedgedAttempts(int i10) {
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

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
    public T maxRetryAttempts(int i10) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4471")
    public T maxTraceEvents(int i10) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    @Deprecated
    public abstract T nameResolverFactory(NameResolver.Factory factory);

    public T offloadExecutor(Executor executor) {
        throw new UnsupportedOperationException();
    }

    public abstract T overrideAuthority(String str);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
    public T perRpcBufferLimit(long j10) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5113")
    public T proxyDetector(ProxyDetector proxyDetector) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
    public T retryBufferSize(long j10) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4017")
    public T setBinaryLog(BinaryLog binaryLog) {
        throw new UnsupportedOperationException();
    }

    public T usePlaintext() {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3713")
    public T useTransportSecurity() {
        throw new UnsupportedOperationException();
    }

    public abstract T userAgent(String str);
}
