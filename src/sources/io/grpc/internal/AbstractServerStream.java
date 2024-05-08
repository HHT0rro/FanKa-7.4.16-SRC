package io.grpc.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.base.o;
import com.huawei.openalliance.ad.constant.bg;
import io.grpc.Attributes;
import io.grpc.Decompressor;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.MessageFramer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractServerStream extends AbstractStream implements ServerStream, MessageFramer.Sink {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final MessageFramer framer;
    private boolean headersSent;
    private boolean outboundClosed;
    private final StatsTraceContext statsTraceCtx;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Sink {
        void cancel(Status status);

        void writeFrame(WritableBuffer writableBuffer, boolean z10, int i10);

        void writeHeaders(Metadata metadata);

        void writeTrailers(Metadata metadata, boolean z10, Status status);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class TransportState extends AbstractStream.TransportState {
        private Status closedStatus;
        private boolean deframerClosed;
        private Runnable deframerClosedTask;
        private boolean endOfStream;
        private boolean immediateCloseRequested;
        private ServerStreamListener listener;
        private boolean listenerClosed;
        private final StatsTraceContext statsTraceCtx;

        public TransportState(int i10, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            super(i10, statsTraceContext, (TransportTracer) o.s(transportTracer, "transportTracer"));
            this.endOfStream = false;
            this.deframerClosed = false;
            this.immediateCloseRequested = false;
            this.statsTraceCtx = (StatsTraceContext) o.s(statsTraceContext, "statsTraceCtx");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeListener(Status status) {
            o.x((status.isOk() && this.closedStatus == null) ? false : true);
            if (this.listenerClosed) {
                return;
            }
            if (!status.isOk()) {
                this.statsTraceCtx.streamClosed(status);
                getTransportTracer().reportStreamClosed(false);
            } else {
                this.statsTraceCtx.streamClosed(this.closedStatus);
                getTransportTracer().reportStreamClosed(this.closedStatus.isOk());
            }
            this.listenerClosed = true;
            onStreamDeallocated();
            listener().closed(status);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClosedStatus(Status status) {
            o.y(this.closedStatus == null, "closedStatus can only be set once");
            this.closedStatus = status;
        }

        public void complete() {
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(Status.OK);
            } else {
                this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractServerStream.TransportState.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TransportState.this.closeListener(Status.OK);
                    }
                };
                this.immediateCloseRequested = true;
                closeDeframer(true);
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean z10) {
            this.deframerClosed = true;
            if (this.endOfStream && !this.immediateCloseRequested) {
                if (z10) {
                    deframeFailed(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame").asRuntimeException());
                    this.deframerClosedTask = null;
                    return;
                }
                this.listener.halfClosed();
            }
            Runnable runnable = this.deframerClosedTask;
            if (runnable != null) {
                runnable.run();
                this.deframerClosedTask = null;
            }
        }

        public void inboundDataReceived(ReadableBuffer readableBuffer, boolean z10) {
            o.y(!this.endOfStream, "Past end of stream");
            deframe(readableBuffer);
            if (z10) {
                this.endOfStream = true;
                closeDeframer(false);
            }
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public final void onStreamAllocated() {
            super.onStreamAllocated();
            getTransportTracer().reportRemoteStreamStarted();
        }

        public final void setListener(ServerStreamListener serverStreamListener) {
            o.y(this.listener == null, "setListener should be called only once");
            this.listener = (ServerStreamListener) o.s(serverStreamListener, bg.e.f32299p);
        }

        public final void transportReportStatus(final Status status) {
            o.e(!status.isOk(), "status must not be OK");
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(status);
            } else {
                this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractServerStream.TransportState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TransportState.this.closeListener(status);
                    }
                };
                this.immediateCloseRequested = true;
                closeDeframer(true);
            }
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public ServerStreamListener listener() {
            return this.listener;
        }
    }

    public AbstractServerStream(WritableBufferAllocator writableBufferAllocator, StatsTraceContext statsTraceContext) {
        this.statsTraceCtx = (StatsTraceContext) o.s(statsTraceContext, "statsTraceCtx");
        this.framer = new MessageFramer(this, writableBufferAllocator, statsTraceContext);
    }

    private void addStatusToTrailers(Metadata metadata, Status status) {
        Metadata.Key<Status> key = InternalStatus.CODE_KEY;
        metadata.discardAll(key);
        Metadata.Key<String> key2 = InternalStatus.MESSAGE_KEY;
        metadata.discardAll(key2);
        metadata.put(key, status);
        if (status.getDescription() != null) {
            metadata.put(key2, status.getDescription());
        }
    }

    public abstract Sink abstractServerStreamSink();

    @Override // io.grpc.internal.ServerStream
    public final void cancel(Status status) {
        abstractServerStreamSink().cancel(status);
    }

    @Override // io.grpc.internal.ServerStream
    public final void close(Status status, Metadata metadata) {
        o.s(status, "status");
        o.s(metadata, GrpcUtil.TE_TRAILERS);
        if (this.outboundClosed) {
            return;
        }
        this.outboundClosed = true;
        endOfMessages();
        addStatusToTrailers(metadata, status);
        transportState().setClosedStatus(status);
        abstractServerStreamSink().writeTrailers(metadata, this.headersSent, status);
    }

    @Override // io.grpc.internal.MessageFramer.Sink
    public final void deliverFrame(WritableBuffer writableBuffer, boolean z10, boolean z11, int i10) {
        if (writableBuffer == null) {
            return;
        }
        if (z10) {
            z11 = false;
        }
        abstractServerStreamSink().writeFrame(writableBuffer, z11, i10);
    }

    @Override // io.grpc.internal.ServerStream
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ServerStream
    public String getAuthority() {
        return null;
    }

    @Override // io.grpc.internal.AbstractStream, io.grpc.internal.Stream
    public final boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.internal.ServerStream
    public final void setDecompressor(Decompressor decompressor) {
        transportState().setDecompressor((Decompressor) o.s(decompressor, "decompressor"));
    }

    @Override // io.grpc.internal.ServerStream
    public final void setListener(ServerStreamListener serverStreamListener) {
        transportState().setListener(serverStreamListener);
    }

    @Override // io.grpc.internal.ServerStream
    public StatsTraceContext statsTraceContext() {
        return this.statsTraceCtx;
    }

    @Override // io.grpc.internal.AbstractStream
    public abstract TransportState transportState();

    @Override // io.grpc.internal.ServerStream
    public final void writeHeaders(Metadata metadata) {
        o.s(metadata, TTDownloadField.TT_HEADERS);
        this.headersSent = true;
        abstractServerStreamSink().writeHeaders(metadata);
    }

    @Override // io.grpc.internal.AbstractStream
    public final MessageFramer framer() {
        return this.framer;
    }
}
