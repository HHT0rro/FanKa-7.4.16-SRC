package io.grpc.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.base.o;
import com.huawei.openalliance.ad.constant.bg;
import io.grpc.CallOptions;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.MessageFramer;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractClientStream extends AbstractStream implements ClientStream, MessageFramer.Sink {
    private static final Logger log = Logger.getLogger(AbstractClientStream.class.getName());
    private volatile boolean cancelled;
    private final Framer framer;
    private Metadata headers;
    private boolean shouldBeCountedForInUse;
    private final TransportTracer transportTracer;
    private boolean useGet;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class GetFramer implements Framer {
        private boolean closed;
        private Metadata headers;
        private byte[] payload;
        private final StatsTraceContext statsTraceCtx;

        public GetFramer(Metadata metadata, StatsTraceContext statsTraceContext) {
            this.headers = (Metadata) o.s(metadata, TTDownloadField.TT_HEADERS);
            this.statsTraceCtx = (StatsTraceContext) o.s(statsTraceContext, "statsTraceCtx");
        }

        @Override // io.grpc.internal.Framer
        public void close() {
            this.closed = true;
            o.y(this.payload != null, "Lack of request message. GET request is only supported for unary requests");
            AbstractClientStream.this.abstractClientStreamSink().writeHeaders(this.headers, this.payload);
            this.payload = null;
            this.headers = null;
        }

        @Override // io.grpc.internal.Framer
        public void dispose() {
            this.closed = true;
            this.payload = null;
            this.headers = null;
        }

        @Override // io.grpc.internal.Framer
        public void flush() {
        }

        @Override // io.grpc.internal.Framer
        public boolean isClosed() {
            return this.closed;
        }

        @Override // io.grpc.internal.Framer
        public Framer setCompressor(Compressor compressor) {
            return this;
        }

        @Override // io.grpc.internal.Framer
        public void setMaxOutboundMessageSize(int i10) {
        }

        @Override // io.grpc.internal.Framer
        public Framer setMessageCompression(boolean z10) {
            return this;
        }

        @Override // io.grpc.internal.Framer
        public void writePayload(InputStream inputStream) {
            o.y(this.payload == null, "writePayload should not be called multiple times");
            try {
                this.payload = com.google.common.io.a.d(inputStream);
                this.statsTraceCtx.outboundMessage(0);
                StatsTraceContext statsTraceContext = this.statsTraceCtx;
                byte[] bArr = this.payload;
                statsTraceContext.outboundMessageSent(0, bArr.length, bArr.length);
                this.statsTraceCtx.outboundUncompressedSize(this.payload.length);
                this.statsTraceCtx.outboundWireSize(this.payload.length);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Sink {
        void cancel(Status status);

        void writeFrame(WritableBuffer writableBuffer, boolean z10, boolean z11, int i10);

        void writeHeaders(Metadata metadata, byte[] bArr);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class TransportState extends AbstractStream.TransportState {
        private DecompressorRegistry decompressorRegistry;
        private boolean deframerClosed;
        private Runnable deframerClosedTask;
        private boolean fullStreamDecompression;
        private ClientStreamListener listener;
        private boolean listenerClosed;
        private volatile boolean outboundClosed;
        private final StatsTraceContext statsTraceCtx;
        private boolean statusReported;
        private boolean statusReportedIsOk;

        public TransportState(int i10, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            super(i10, statsTraceContext, transportTracer);
            this.decompressorRegistry = DecompressorRegistry.getDefaultInstance();
            this.deframerClosed = false;
            this.statsTraceCtx = (StatsTraceContext) o.s(statsTraceContext, "statsTraceCtx");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeListener(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            if (this.listenerClosed) {
                return;
            }
            this.listenerClosed = true;
            this.statsTraceCtx.streamClosed(status);
            listener().closed(status, rpcProgress, metadata);
            if (getTransportTracer() != null) {
                getTransportTracer().reportStreamClosed(status.isOk());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
            o.y(this.listener == null, "Already called start");
            this.decompressorRegistry = (DecompressorRegistry) o.s(decompressorRegistry, "decompressorRegistry");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFullStreamDecompression(boolean z10) {
            this.fullStreamDecompression = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setOutboundClosed() {
            this.outboundClosed = true;
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean z10) {
            o.y(this.statusReported, "status should have been reported on deframer closed");
            this.deframerClosed = true;
            if (this.statusReportedIsOk && z10) {
                transportReportStatus(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame"), true, new Metadata());
            }
            Runnable runnable = this.deframerClosedTask;
            if (runnable != null) {
                runnable.run();
                this.deframerClosedTask = null;
            }
        }

        public void inboundDataReceived(ReadableBuffer readableBuffer) {
            o.s(readableBuffer, "frame");
            try {
                if (this.statusReported) {
                    AbstractClientStream.log.log(Level.INFO, "Received data on closed stream");
                    readableBuffer.close();
                } else {
                    deframe(readableBuffer);
                }
            } catch (Throwable th) {
                if (1 != 0) {
                    readableBuffer.close();
                }
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void inboundHeadersReceived(io.grpc.Metadata r6) {
            /*
                r5 = this;
                boolean r0 = r5.statusReported
                r1 = 1
                r0 = r0 ^ r1
                java.lang.String r2 = "Received headers on closed stream"
                com.google.common.base.o.y(r0, r2)
                io.grpc.internal.StatsTraceContext r0 = r5.statsTraceCtx
                r0.clientInboundHeaders()
                io.grpc.Metadata$Key<java.lang.String> r0 = io.grpc.internal.GrpcUtil.CONTENT_ENCODING_KEY
                java.lang.Object r0 = r6.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                boolean r2 = r5.fullStreamDecompression
                r3 = 0
                if (r2 == 0) goto L4f
                if (r0 == 0) goto L4f
                java.lang.String r2 = "gzip"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 == 0) goto L2f
                io.grpc.internal.GzipInflatingBuffer r0 = new io.grpc.internal.GzipInflatingBuffer
                r0.<init>()
                r5.setFullStreamDecompressor(r0)
                r0 = 1
                goto L50
            L2f:
                java.lang.String r2 = "identity"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 != 0) goto L4f
                io.grpc.Status r6 = io.grpc.Status.INTERNAL
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r3] = r0
                java.lang.String r0 = "Can't find full stream decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r0, r1)
                io.grpc.Status r6 = r6.withDescription(r0)
                io.grpc.StatusRuntimeException r6 = r6.asRuntimeException()
                r5.deframeFailed(r6)
                return
            L4f:
                r0 = 0
            L50:
                io.grpc.Metadata$Key<java.lang.String> r2 = io.grpc.internal.GrpcUtil.MESSAGE_ENCODING_KEY
                java.lang.Object r2 = r6.get(r2)
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto L93
                io.grpc.DecompressorRegistry r4 = r5.decompressorRegistry
                io.grpc.Decompressor r4 = r4.lookupDecompressor(r2)
                if (r4 != 0) goto L7a
                io.grpc.Status r6 = io.grpc.Status.INTERNAL
                java.lang.Object[] r0 = new java.lang.Object[r1]
                r0[r3] = r2
                java.lang.String r1 = "Can't find decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                io.grpc.Status r6 = r6.withDescription(r0)
                io.grpc.StatusRuntimeException r6 = r6.asRuntimeException()
                r5.deframeFailed(r6)
                return
            L7a:
                io.grpc.Codec r1 = io.grpc.Codec.Identity.NONE
                if (r4 == r1) goto L93
                if (r0 == 0) goto L90
                io.grpc.Status r6 = io.grpc.Status.INTERNAL
                java.lang.String r0 = "Full stream and gRPC message encoding cannot both be set"
                io.grpc.Status r6 = r6.withDescription(r0)
                io.grpc.StatusRuntimeException r6 = r6.asRuntimeException()
                r5.deframeFailed(r6)
                return
            L90:
                r5.setDecompressor(r4)
            L93:
                io.grpc.internal.ClientStreamListener r0 = r5.listener()
                r0.headersRead(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.AbstractClientStream.TransportState.inboundHeadersReceived(io.grpc.Metadata):void");
        }

        public void inboundTrailersReceived(Metadata metadata, Status status) {
            o.s(status, "status");
            o.s(metadata, GrpcUtil.TE_TRAILERS);
            if (this.statusReported) {
                AbstractClientStream.log.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{status, metadata});
            } else {
                this.statsTraceCtx.clientInboundTrailers(metadata);
                transportReportStatus(status, false, metadata);
            }
        }

        public final boolean isOutboundClosed() {
            return this.outboundClosed;
        }

        public final void setListener(ClientStreamListener clientStreamListener) {
            o.y(this.listener == null, "Already called setListener");
            this.listener = (ClientStreamListener) o.s(clientStreamListener, bg.e.f32299p);
        }

        public final void transportReportStatus(Status status, boolean z10, Metadata metadata) {
            transportReportStatus(status, ClientStreamListener.RpcProgress.PROCESSED, z10, metadata);
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public final ClientStreamListener listener() {
            return this.listener;
        }

        public final void transportReportStatus(final Status status, final ClientStreamListener.RpcProgress rpcProgress, boolean z10, final Metadata metadata) {
            o.s(status, "status");
            o.s(metadata, GrpcUtil.TE_TRAILERS);
            if (!this.statusReported || z10) {
                this.statusReported = true;
                this.statusReportedIsOk = status.isOk();
                onStreamDeallocated();
                if (this.deframerClosed) {
                    this.deframerClosedTask = null;
                    closeListener(status, rpcProgress, metadata);
                } else {
                    this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractClientStream.TransportState.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TransportState.this.closeListener(status, rpcProgress, metadata);
                        }
                    };
                    closeDeframer(z10);
                }
            }
        }
    }

    public AbstractClientStream(WritableBufferAllocator writableBufferAllocator, StatsTraceContext statsTraceContext, TransportTracer transportTracer, Metadata metadata, CallOptions callOptions, boolean z10) {
        o.s(metadata, TTDownloadField.TT_HEADERS);
        this.transportTracer = (TransportTracer) o.s(transportTracer, "transportTracer");
        this.shouldBeCountedForInUse = GrpcUtil.shouldBeCountedForInUse(callOptions);
        this.useGet = z10;
        if (!z10) {
            this.framer = new MessageFramer(this, writableBufferAllocator, statsTraceContext);
            this.headers = metadata;
        } else {
            this.framer = new GetFramer(metadata, statsTraceContext);
        }
    }

    public abstract Sink abstractClientStreamSink();

    @Override // io.grpc.internal.ClientStream
    public final void appendTimeoutInsight(InsightBuilder insightBuilder) {
        insightBuilder.appendKeyValue("remote_addr", getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR));
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status status) {
        o.e(!status.isOk(), "Should not cancel with OK status");
        this.cancelled = true;
        abstractClientStreamSink().cancel(status);
    }

    @Override // io.grpc.internal.MessageFramer.Sink
    public final void deliverFrame(WritableBuffer writableBuffer, boolean z10, boolean z11, int i10) {
        o.e(writableBuffer != null || z10, "null frame before EOS");
        abstractClientStreamSink().writeFrame(writableBuffer, z10, z11, i10);
    }

    @Override // io.grpc.internal.AbstractStream
    public final Framer framer() {
        return this.framer;
    }

    public TransportTracer getTransportTracer() {
        return this.transportTracer;
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        if (transportState().isOutboundClosed()) {
            return;
        }
        transportState().setOutboundClosed();
        endOfMessages();
    }

    @Override // io.grpc.internal.AbstractStream, io.grpc.internal.Stream
    public final boolean isReady() {
        return super.isReady() && !this.cancelled;
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(Deadline deadline) {
        Metadata metadata = this.headers;
        Metadata.Key<Long> key = GrpcUtil.TIMEOUT_KEY;
        metadata.discardAll(key);
        this.headers.put(key, Long.valueOf(Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS))));
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        transportState().setDecompressorRegistry(decompressorRegistry);
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(boolean z10) {
        transportState().setFullStreamDecompression(z10);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(int i10) {
        transportState().setMaxInboundMessageSize(i10);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(int i10) {
        this.framer.setMaxOutboundMessageSize(i10);
    }

    public final boolean shouldBeCountedForInUse() {
        return this.shouldBeCountedForInUse;
    }

    @Override // io.grpc.internal.ClientStream
    public final void start(ClientStreamListener clientStreamListener) {
        transportState().setListener(clientStreamListener);
        if (this.useGet) {
            return;
        }
        abstractClientStreamSink().writeHeaders(this.headers, null);
        this.headers = null;
    }

    @Override // io.grpc.internal.AbstractStream
    public abstract TransportState transportState();
}
