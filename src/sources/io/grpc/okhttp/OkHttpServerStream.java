package io.grpc.okhttp;

import androidx.core.app.NotificationCompat;
import com.google.common.base.o;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractServerStream;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.OkHttpServerStream;
import io.grpc.okhttp.OkHttpServerTransport;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.util.List;
import okio.Buffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class OkHttpServerStream extends AbstractServerStream {
    private final Attributes attributes;
    private final String authority;
    private final Sink sink;
    private final TransportState state;
    private final TransportTracer transportTracer;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class Sink implements AbstractServerStream.Sink {
        public Sink() {
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void cancel(Status status) {
            PerfMark.startTask("OkHttpServerStream$Sink.cancel");
            try {
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.cancel(ErrorCode.CANCEL, status);
                }
            } finally {
                PerfMark.stopTask("OkHttpServerStream$Sink.cancel");
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeFrame(WritableBuffer writableBuffer, boolean z10, int i10) {
            PerfMark.startTask("OkHttpServerStream$Sink.writeFrame");
            Buffer buffer = ((OkHttpWritableBuffer) writableBuffer).buffer();
            int size = (int) buffer.size();
            if (size > 0) {
                OkHttpServerStream.this.onSendingBytes(size);
            }
            try {
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendBuffer(buffer, z10);
                    OkHttpServerStream.this.transportTracer.reportMessageSent(i10);
                }
            } finally {
                PerfMark.stopTask("OkHttpServerStream$Sink.writeFrame");
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeHeaders(Metadata metadata) {
            PerfMark.startTask("OkHttpServerStream$Sink.writeHeaders");
            try {
                List<Header> createResponseHeaders = Headers.createResponseHeaders(metadata);
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendHeaders(createResponseHeaders);
                }
            } finally {
                PerfMark.stopTask("OkHttpServerStream$Sink.writeHeaders");
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeTrailers(Metadata metadata, boolean z10, Status status) {
            PerfMark.startTask("OkHttpServerStream$Sink.writeTrailers");
            try {
                List<Header> createResponseTrailers = Headers.createResponseTrailers(metadata, z10);
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendTrailers(createResponseTrailers);
                }
            } finally {
                PerfMark.stopTask("OkHttpServerStream$Sink.writeTrailers");
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TransportState extends AbstractServerStream.TransportState implements OutboundFlowController.Stream, OkHttpServerTransport.StreamState {
        private boolean cancelSent;
        private final ExceptionHandlingFrameWriter frameWriter;
        private final int initialWindowSize;
        private final Object lock;
        private final OutboundFlowController outboundFlow;
        private final OutboundFlowController.StreamState outboundFlowState;
        private int processedWindow;
        private boolean receivedEndOfStream;
        private final int streamId;
        private final Tag tag;
        private final OkHttpServerTransport transport;
        private int window;

        public TransportState(OkHttpServerTransport okHttpServerTransport, int i10, int i11, StatsTraceContext statsTraceContext, Object obj, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OutboundFlowController outboundFlowController, int i12, TransportTracer transportTracer, String str) {
            super(i11, statsTraceContext, transportTracer);
            this.cancelSent = false;
            this.transport = (OkHttpServerTransport) o.s(okHttpServerTransport, NotificationCompat.CATEGORY_TRANSPORT);
            this.streamId = i10;
            this.lock = o.s(obj, "lock");
            this.frameWriter = exceptionHandlingFrameWriter;
            this.outboundFlow = outboundFlowController;
            this.window = i12;
            this.processedWindow = i12;
            this.initialWindowSize = i12;
            this.tag = PerfMark.createTag(str);
            this.outboundFlowState = outboundFlowController.createState(this, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancel(ErrorCode errorCode, Status status) {
            if (this.cancelSent) {
                return;
            }
            this.cancelSent = true;
            this.frameWriter.rstStream(this.streamId, errorCode);
            transportReportStatus(status);
            this.transport.streamClosed(this.streamId, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendBuffer(Buffer buffer, boolean z10) {
            if (this.cancelSent) {
                return;
            }
            this.outboundFlow.data(false, this.outboundFlowState, buffer, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendHeaders(List<Header> list) {
            this.frameWriter.synReply(false, this.streamId, list);
            this.frameWriter.flush();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendTrailers(final List<Header> list) {
            this.outboundFlow.notifyWhenNoPendingData(this.outboundFlowState, new Runnable() { // from class: io.grpc.okhttp.c
                @Override // java.lang.Runnable
                public final void run() {
                    OkHttpServerStream.TransportState.this.lambda$sendTrailers$0(list);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: sendTrailersAfterFlowControlled, reason: merged with bridge method [inline-methods] */
        public void lambda$sendTrailers$0(List<Header> list) {
            synchronized (this.lock) {
                this.frameWriter.synReply(true, this.streamId, list);
                if (!this.receivedEndOfStream) {
                    this.frameWriter.rstStream(this.streamId, ErrorCode.NO_ERROR);
                }
                this.transport.streamClosed(this.streamId, true);
                complete();
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void bytesRead(int i10) {
            int i11 = this.processedWindow - i10;
            this.processedWindow = i11;
            float f10 = i11;
            int i12 = this.initialWindowSize;
            if (f10 <= i12 * 0.5f) {
                int i13 = i12 - i11;
                this.window += i13;
                this.processedWindow = i11 + i13;
                this.frameWriter.windowUpdate(this.streamId, i13);
                this.frameWriter.flush();
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframeFailed(Throwable th) {
            cancel(ErrorCode.INTERNAL_ERROR, Status.fromThrowable(th));
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public OutboundFlowController.StreamState getOutboundFlowState() {
            return this.outboundFlowState;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public boolean hasReceivedEndOfStream() {
            boolean z10;
            synchronized (this.lock) {
                z10 = this.receivedEndOfStream;
            }
            return z10;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void inboundDataReceived(Buffer buffer, int i10, boolean z10) {
            synchronized (this.lock) {
                PerfMark.event("OkHttpServerTransport$FrameHandler.data", this.tag);
                if (z10) {
                    this.receivedEndOfStream = true;
                }
                this.window -= i10;
                super.inboundDataReceived(new OkHttpReadableBuffer(buffer), z10);
            }
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void inboundRstReceived(Status status) {
            PerfMark.event("OkHttpServerTransport$FrameHandler.rstStream", this.tag);
            transportReportStatus(status);
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public int inboundWindowAvailable() {
            int i10;
            synchronized (this.lock) {
                i10 = this.window;
            }
            return i10;
        }

        @Override // io.grpc.internal.ApplicationThreadDeframerListener.TransportExecutor
        public void runOnTransportThread(Runnable runnable) {
            synchronized (this.lock) {
                runnable.run();
            }
        }
    }

    public OkHttpServerStream(TransportState transportState, Attributes attributes, String str, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
        super(new OkHttpWritableBufferAllocator(), statsTraceContext);
        this.sink = new Sink();
        this.state = (TransportState) o.s(transportState, "state");
        this.attributes = (Attributes) o.s(attributes, "transportAttrs");
        this.authority = str;
        this.transportTracer = (TransportTracer) o.s(transportTracer, "transportTracer");
    }

    @Override // io.grpc.internal.AbstractServerStream, io.grpc.internal.ServerStream
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.internal.AbstractServerStream, io.grpc.internal.ServerStream
    public String getAuthority() {
        return this.authority;
    }

    @Override // io.grpc.internal.ServerStream
    public int streamId() {
        return this.state.streamId;
    }

    @Override // io.grpc.internal.AbstractServerStream
    public Sink abstractServerStreamSink() {
        return this.sink;
    }

    @Override // io.grpc.internal.AbstractServerStream, io.grpc.internal.AbstractStream
    public TransportState transportState() {
        return this.state;
    }
}
