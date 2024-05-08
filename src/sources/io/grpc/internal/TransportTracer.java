package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.InternalChannelz;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TransportTracer {
    private static final Factory DEFAULT_FACTORY = new Factory(TimeProvider.SYSTEM_TIME_PROVIDER);
    private FlowControlReader flowControlWindowReader;
    private long keepAlivesSent;
    private long lastLocalStreamCreatedTimeNanos;
    private volatile long lastMessageReceivedTimeNanos;
    private long lastMessageSentTimeNanos;
    private long lastRemoteStreamCreatedTimeNanos;
    private final LongCounter messagesReceived;
    private long messagesSent;
    private long streamsFailed;
    private long streamsStarted;
    private long streamsSucceeded;
    private final TimeProvider timeProvider;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Factory {
        private final TimeProvider timeProvider;

        public Factory(TimeProvider timeProvider) {
            this.timeProvider = timeProvider;
        }

        public TransportTracer create() {
            return new TransportTracer(this.timeProvider);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FlowControlReader {
        FlowControlWindows read();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class FlowControlWindows {
        public final long localBytes;
        public final long remoteBytes;

        public FlowControlWindows(long j10, long j11) {
            this.localBytes = j10;
            this.remoteBytes = j11;
        }
    }

    public static Factory getDefaultFactory() {
        return DEFAULT_FACTORY;
    }

    public InternalChannelz.TransportStats getStats() {
        FlowControlReader flowControlReader = this.flowControlWindowReader;
        long j10 = flowControlReader == null ? -1L : flowControlReader.read().localBytes;
        FlowControlReader flowControlReader2 = this.flowControlWindowReader;
        return new InternalChannelz.TransportStats(this.streamsStarted, this.lastLocalStreamCreatedTimeNanos, this.lastRemoteStreamCreatedTimeNanos, this.streamsSucceeded, this.streamsFailed, this.messagesSent, this.messagesReceived.value(), this.keepAlivesSent, this.lastMessageSentTimeNanos, this.lastMessageReceivedTimeNanos, j10, flowControlReader2 != null ? flowControlReader2.read().remoteBytes : -1L);
    }

    public void reportKeepAliveSent() {
        this.keepAlivesSent++;
    }

    public void reportLocalStreamStarted() {
        this.streamsStarted++;
        this.lastLocalStreamCreatedTimeNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportMessageReceived() {
        this.messagesReceived.add(1L);
        this.lastMessageReceivedTimeNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportMessageSent(int i10) {
        if (i10 == 0) {
            return;
        }
        this.messagesSent += i10;
        this.lastMessageSentTimeNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportRemoteStreamStarted() {
        this.streamsStarted++;
        this.lastRemoteStreamCreatedTimeNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportStreamClosed(boolean z10) {
        if (z10) {
            this.streamsSucceeded++;
        } else {
            this.streamsFailed++;
        }
    }

    public void setFlowControlWindowReader(FlowControlReader flowControlReader) {
        this.flowControlWindowReader = (FlowControlReader) o.r(flowControlReader);
    }

    public TransportTracer() {
        this.messagesReceived = LongCounterFactory.create();
        this.timeProvider = TimeProvider.SYSTEM_TIME_PROVIDER;
    }

    private TransportTracer(TimeProvider timeProvider) {
        this.messagesReceived = LongCounterFactory.create();
        this.timeProvider = timeProvider;
    }
}
