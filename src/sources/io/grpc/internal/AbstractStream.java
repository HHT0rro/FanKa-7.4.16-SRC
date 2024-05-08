package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframer;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractStream implements Stream {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class TransportState implements ApplicationThreadDeframer.TransportExecutor, MessageDeframer.Listener {
        public static final int DEFAULT_ONREADY_THRESHOLD = 32768;
        private boolean allocated;
        private boolean deallocated;
        private Deframer deframer;
        private int numSentBytesQueued;
        private final Object onReadyLock = new Object();
        private final MessageDeframer rawDeframer;
        private final StatsTraceContext statsTraceCtx;
        private final TransportTracer transportTracer;

        public TransportState(int i10, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            this.statsTraceCtx = (StatsTraceContext) o.s(statsTraceContext, "statsTraceCtx");
            this.transportTracer = (TransportTracer) o.s(transportTracer, "transportTracer");
            MessageDeframer messageDeframer = new MessageDeframer(this, Codec.Identity.NONE, i10, statsTraceContext, transportTracer);
            this.rawDeframer = messageDeframer;
            this.deframer = messageDeframer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isReady() {
            boolean z10;
            synchronized (this.onReadyLock) {
                z10 = this.allocated && this.numSentBytesQueued < 32768 && !this.deallocated;
            }
            return z10;
        }

        private void notifyIfReady() {
            boolean isReady;
            synchronized (this.onReadyLock) {
                isReady = isReady();
            }
            if (isReady) {
                listener().onReady();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendingBytes(int i10) {
            synchronized (this.onReadyLock) {
                this.numSentBytesQueued += i10;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestMessagesFromDeframer(final int i10) {
            if (this.deframer instanceof ThreadOptimizedDeframer) {
                PerfMark.startTask("AbstractStream.request");
                try {
                    this.deframer.request(i10);
                    return;
                } finally {
                    PerfMark.stopTask("AbstractStream.request");
                }
            }
            final Link linkOut = PerfMark.linkOut();
            runOnTransportThread(new Runnable() { // from class: io.grpc.internal.AbstractStream.TransportState.1RequestRunnable
                @Override // java.lang.Runnable
                public void run() {
                    PerfMark.startTask("AbstractStream.request");
                    PerfMark.linkIn(linkOut);
                    try {
                        TransportState.this.deframer.request(i10);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }

        public final void closeDeframer(boolean z10) {
            if (z10) {
                this.deframer.close();
            } else {
                this.deframer.closeWhenComplete();
            }
        }

        public final void deframe(ReadableBuffer readableBuffer) {
            try {
                this.deframer.deframe(readableBuffer);
            } catch (Throwable th) {
                deframeFailed(th);
            }
        }

        public final StatsTraceContext getStatsTraceContext() {
            return this.statsTraceCtx;
        }

        public TransportTracer getTransportTracer() {
            return this.transportTracer;
        }

        public abstract StreamListener listener();

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            listener().messagesAvailable(messageProducer);
        }

        public final void onSentBytes(int i10) {
            boolean z10;
            synchronized (this.onReadyLock) {
                o.y(this.allocated, "onStreamAllocated was not called, but it seems the stream is active");
                int i11 = this.numSentBytesQueued;
                z10 = true;
                boolean z11 = i11 < 32768;
                int i12 = i11 - i10;
                this.numSentBytesQueued = i12;
                boolean z12 = i12 < 32768;
                if (z11 || !z12) {
                    z10 = false;
                }
            }
            if (z10) {
                notifyIfReady();
            }
        }

        public void onStreamAllocated() {
            o.x(listener() != null);
            synchronized (this.onReadyLock) {
                o.y(this.allocated ? false : true, "Already allocated");
                this.allocated = true;
            }
            notifyIfReady();
        }

        public final void onStreamDeallocated() {
            synchronized (this.onReadyLock) {
                this.deallocated = true;
            }
        }

        public final void optimizeForDirectExecutor() {
            this.rawDeframer.setListener(this);
            this.deframer = this.rawDeframer;
        }

        public final void requestMessagesFromDeframerForTesting(int i10) {
            requestMessagesFromDeframer(i10);
        }

        public final void setDecompressor(Decompressor decompressor) {
            this.deframer.setDecompressor(decompressor);
        }

        public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
            this.rawDeframer.setFullStreamDecompressor(gzipInflatingBuffer);
            this.deframer = new ApplicationThreadDeframer(this, this, this.rawDeframer);
        }

        public final void setMaxInboundMessageSize(int i10) {
            this.deframer.setMaxInboundMessageSize(i10);
        }
    }

    public final void endOfMessages() {
        framer().close();
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        if (framer().isClosed()) {
            return;
        }
        framer().flush();
    }

    public abstract Framer framer();

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        return transportState().isReady();
    }

    public final void onSendingBytes(int i10) {
        transportState().onSendingBytes(i10);
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        transportState().optimizeForDirectExecutor();
    }

    @Override // io.grpc.internal.Stream
    public final void request(int i10) {
        transportState().requestMessagesFromDeframer(i10);
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(Compressor compressor) {
        framer().setCompressor((Compressor) o.s(compressor, "compressor"));
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(boolean z10) {
        framer().setMessageCompression(z10);
    }

    public abstract TransportState transportState();

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        o.s(inputStream, "message");
        try {
            if (!framer().isClosed()) {
                framer().writePayload(inputStream);
            }
        } finally {
            GrpcUtil.closeQuietly(inputStream);
        }
    }
}
