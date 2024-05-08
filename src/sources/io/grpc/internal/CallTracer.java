package io.grpc.internal;

import io.grpc.InternalChannelz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CallTracer {
    public static final Factory DEFAULT_FACTORY = new Factory() { // from class: io.grpc.internal.CallTracer.1
        @Override // io.grpc.internal.CallTracer.Factory
        public CallTracer create() {
            return new CallTracer(TimeProvider.SYSTEM_TIME_PROVIDER);
        }
    };
    private volatile long lastCallStartedNanos;
    private final TimeProvider timeProvider;
    private final LongCounter callsStarted = LongCounterFactory.create();
    private final LongCounter callsSucceeded = LongCounterFactory.create();
    private final LongCounter callsFailed = LongCounterFactory.create();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Factory {
        CallTracer create();
    }

    public CallTracer(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public static Factory getDefaultFactory() {
        return DEFAULT_FACTORY;
    }

    public void reportCallEnded(boolean z10) {
        if (z10) {
            this.callsSucceeded.add(1L);
        } else {
            this.callsFailed.add(1L);
        }
    }

    public void reportCallStarted() {
        this.callsStarted.add(1L);
        this.lastCallStartedNanos = this.timeProvider.currentTimeNanos();
    }

    public void updateBuilder(InternalChannelz.ChannelStats.Builder builder) {
        builder.setCallsStarted(this.callsStarted.value()).setCallsSucceeded(this.callsSucceeded.value()).setCallsFailed(this.callsFailed.value()).setLastCallStartedNanos(this.lastCallStartedNanos);
    }

    public void updateBuilder(InternalChannelz.ServerStats.Builder builder) {
        builder.setCallsStarted(this.callsStarted.value()).setCallsSucceeded(this.callsSucceeded.value()).setCallsFailed(this.callsFailed.value()).setLastCallStartedNanos(this.lastCallStartedNanos);
    }
}
