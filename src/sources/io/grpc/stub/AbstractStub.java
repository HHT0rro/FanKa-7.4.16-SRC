package io.grpc.stub;

import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.google.common.base.o;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Deadline;
import io.grpc.ExperimentalApi;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractStub<S extends AbstractStub<S>> {
    private final CallOptions callOptions;
    private final Channel channel;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface StubFactory<T extends AbstractStub<T>> {
        T newStub(Channel channel, CallOptions callOptions);
    }

    public AbstractStub(Channel channel) {
        this(channel, CallOptions.DEFAULT);
    }

    public static <T extends AbstractStub<T>> T newStub(StubFactory<T> stubFactory, Channel channel) {
        return (T) newStub(stubFactory, channel, CallOptions.DEFAULT);
    }

    public abstract S build(Channel channel, CallOptions callOptions);

    public final CallOptions getCallOptions() {
        return this.callOptions;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final S withCallCredentials(CallCredentials callCredentials) {
        return build(this.channel, this.callOptions.withCallCredentials(callCredentials));
    }

    @Deprecated
    public final S withChannel(Channel channel) {
        return build(channel, this.callOptions);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public final S withCompression(String str) {
        return build(this.channel, this.callOptions.withCompression(str));
    }

    public final S withDeadline(Deadline deadline) {
        return build(this.channel, this.callOptions.withDeadline(deadline));
    }

    public final S withDeadlineAfter(long j10, TimeUnit timeUnit) {
        return build(this.channel, this.callOptions.withDeadlineAfter(j10, timeUnit));
    }

    public final S withExecutor(Executor executor) {
        return build(this.channel, this.callOptions.withExecutor(executor));
    }

    public final S withInterceptors(ClientInterceptor... clientInterceptorArr) {
        return build(ClientInterceptors.intercept(this.channel, clientInterceptorArr), this.callOptions);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public final S withMaxInboundMessageSize(int i10) {
        return build(this.channel, this.callOptions.withMaxInboundMessageSize(i10));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public final S withMaxOutboundMessageSize(int i10) {
        return build(this.channel, this.callOptions.withMaxOutboundMessageSize(i10));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
    public final <T> S withOption(CallOptions.Key<T> key, T t2) {
        return build(this.channel, this.callOptions.withOption(key, t2));
    }

    public final S withWaitForReady() {
        return build(this.channel, this.callOptions.withWaitForReady());
    }

    public AbstractStub(Channel channel, CallOptions callOptions) {
        this.channel = (Channel) o.s(channel, TTLiveConstants.INIT_CHANNEL);
        this.callOptions = (CallOptions) o.s(callOptions, "callOptions");
    }

    public static <T extends AbstractStub<T>> T newStub(StubFactory<T> stubFactory, Channel channel, CallOptions callOptions) {
        return stubFactory.newStub(channel, callOptions);
    }
}
