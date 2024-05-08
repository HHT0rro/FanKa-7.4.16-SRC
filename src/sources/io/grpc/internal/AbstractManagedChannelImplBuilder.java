package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.o;
import io.grpc.BinaryLog;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.ProxyDetector;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractManagedChannelImplBuilder<T extends ManagedChannelBuilder<T>> extends ManagedChannelBuilder<T> {
    public int maxInboundMessageSize = 4194304;

    public static ManagedChannelBuilder<?> forAddress(String str, int i10) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public static ManagedChannelBuilder<?> forTarget(String str) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return delegate().build();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder defaultServiceConfig(Map map) {
        return defaultServiceConfig((Map<String, ?>) map);
    }

    public abstract ManagedChannelBuilder<?> delegate();

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder intercept(List list) {
        return intercept((List<ClientInterceptor>) list);
    }

    public final T thisT() {
        return this;
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T compressorRegistry(CompressorRegistry compressorRegistry) {
        delegate().compressorRegistry(compressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delegate().decompressorRegistry(decompressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T defaultLoadBalancingPolicy(String str) {
        delegate().defaultLoadBalancingPolicy(str);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T defaultServiceConfig(Map<String, ?> map) {
        delegate().defaultServiceConfig(map);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T disableRetry() {
        delegate().disableRetry();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T disableServiceConfigLookUp() {
        delegate().disableServiceConfigLookUp();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T enableFullStreamDecompression() {
        delegate().enableFullStreamDecompression();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T enableRetry() {
        delegate().enableRetry();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T executor(Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T idleTimeout(long j10, TimeUnit timeUnit) {
        delegate().idleTimeout(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveTime(long j10, TimeUnit timeUnit) {
        delegate().keepAliveTime(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveTimeout(long j10, TimeUnit timeUnit) {
        delegate().keepAliveTimeout(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveWithoutCalls(boolean z10) {
        delegate().keepAliveWithoutCalls(z10);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxHedgedAttempts(int i10) {
        delegate().maxHedgedAttempts(i10);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxInboundMessageSize(int i10) {
        o.e(i10 >= 0, "negative max");
        this.maxInboundMessageSize = i10;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxInboundMetadataSize(int i10) {
        delegate().maxInboundMetadataSize(i10);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxRetryAttempts(int i10) {
        delegate().maxRetryAttempts(i10);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxTraceEvents(int i10) {
        delegate().maxTraceEvents(i10);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    @Deprecated
    public T nameResolverFactory(NameResolver.Factory factory) {
        delegate().nameResolverFactory(factory);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T offloadExecutor(Executor executor) {
        delegate().offloadExecutor(executor);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T overrideAuthority(String str) {
        delegate().overrideAuthority(str);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T perRpcBufferLimit(long j10) {
        delegate().perRpcBufferLimit(j10);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T proxyDetector(ProxyDetector proxyDetector) {
        delegate().proxyDetector(proxyDetector);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T retryBufferSize(long j10) {
        delegate().retryBufferSize(j10);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T setBinaryLog(BinaryLog binaryLog) {
        delegate().setBinaryLog(binaryLog);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T usePlaintext() {
        delegate().usePlaintext();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T useTransportSecurity() {
        delegate().useTransportSecurity();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T userAgent(String str) {
        delegate().userAgent(str);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T intercept(List<ClientInterceptor> list) {
        delegate().intercept(list);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T intercept(ClientInterceptor... clientInterceptorArr) {
        delegate().intercept(clientInterceptorArr);
        return thisT();
    }
}
