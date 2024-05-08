package io.grpc.okhttp;

import com.google.common.base.o;
import com.google.common.io.BaseEncoding;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Http2ClientStreamTransportState;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.util.List;
import okio.Buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class OkHttpClientStream extends AbstractClientStream {
    public static final int ABSENT_ID = -1;
    private static final Buffer EMPTY_BUFFER = new Buffer();
    private final Attributes attributes;
    private String authority;
    private final MethodDescriptor<?, ?> method;
    private final Sink sink;
    private final TransportState state;
    private final StatsTraceContext statsTraceCtx;
    private boolean useGet;
    private final String userAgent;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class Sink implements AbstractClientStream.Sink {
        public Sink() {
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void cancel(Status status) {
            PerfMark.startTask("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (OkHttpClientStream.this.state.lock) {
                    OkHttpClientStream.this.state.cancel(status, true, null);
                }
            } finally {
                PerfMark.stopTask("OkHttpClientStream$Sink.cancel");
            }
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeFrame(WritableBuffer writableBuffer, boolean z10, boolean z11, int i10) {
            Buffer buffer;
            PerfMark.startTask("OkHttpClientStream$Sink.writeFrame");
            if (writableBuffer == null) {
                buffer = OkHttpClientStream.EMPTY_BUFFER;
            } else {
                buffer = ((OkHttpWritableBuffer) writableBuffer).buffer();
                int size = (int) buffer.size();
                if (size > 0) {
                    OkHttpClientStream.this.onSendingBytes(size);
                }
            }
            try {
                synchronized (OkHttpClientStream.this.state.lock) {
                    OkHttpClientStream.this.state.sendBuffer(buffer, z10, z11);
                    OkHttpClientStream.this.getTransportTracer().reportMessageSent(i10);
                }
            } finally {
                PerfMark.stopTask("OkHttpClientStream$Sink.writeFrame");
            }
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeHeaders(Metadata metadata, byte[] bArr) {
            PerfMark.startTask("OkHttpClientStream$Sink.writeHeaders");
            String str = "/" + OkHttpClientStream.this.method.getFullMethodName();
            if (bArr != null) {
                OkHttpClientStream.this.useGet = true;
                str = str + SymbolValues.QUESTION_EN_SYMBOL + BaseEncoding.a().e(bArr);
            }
            try {
                synchronized (OkHttpClientStream.this.state.lock) {
                    OkHttpClientStream.this.state.streamReady(metadata, str);
                }
            } finally {
                PerfMark.stopTask("OkHttpClientStream$Sink.writeHeaders");
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class TransportState extends Http2ClientStreamTransportState implements OutboundFlowController.Stream {
        private boolean canStart;
        private boolean cancelSent;
        private boolean flushPendingData;
        private final ExceptionHandlingFrameWriter frameWriter;

        /* renamed from: id, reason: collision with root package name */
        private int f50075id;
        private final int initialWindowSize;
        private final Object lock;
        private final OutboundFlowController outboundFlow;
        private OutboundFlowController.StreamState outboundFlowState;
        private Buffer pendingData;
        private boolean pendingDataHasEndOfStream;
        private int processedWindow;
        private List<Header> requestHeaders;
        private final Tag tag;
        private final OkHttpClientTransport transport;
        private int window;

        public TransportState(int i10, StatsTraceContext statsTraceContext, Object obj, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OutboundFlowController outboundFlowController, OkHttpClientTransport okHttpClientTransport, int i11, String str) {
            super(i10, statsTraceContext, OkHttpClientStream.this.getTransportTracer());
            this.pendingData = new Buffer();
            this.pendingDataHasEndOfStream = false;
            this.flushPendingData = false;
            this.cancelSent = false;
            this.canStart = true;
            this.f50075id = -1;
            this.lock = o.s(obj, "lock");
            this.frameWriter = exceptionHandlingFrameWriter;
            this.outboundFlow = outboundFlowController;
            this.transport = okHttpClientTransport;
            this.window = i11;
            this.processedWindow = i11;
            this.initialWindowSize = i11;
            this.tag = PerfMark.createTag(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancel(Status status, boolean z10, Metadata metadata) {
            if (this.cancelSent) {
                return;
            }
            this.cancelSent = true;
            if (this.canStart) {
                this.transport.removePendingStream(OkHttpClientStream.this);
                this.requestHeaders = null;
                this.pendingData.clear();
                this.canStart = false;
                if (metadata == null) {
                    metadata = new Metadata();
                }
                transportReportStatus(status, true, metadata);
                return;
            }
            this.transport.finishStream(id(), status, ClientStreamListener.RpcProgress.PROCESSED, z10, ErrorCode.CANCEL, metadata);
        }

        private void onEndOfStream() {
            if (!isOutboundClosed()) {
                this.transport.finishStream(id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.CANCEL, null);
            } else {
                this.transport.finishStream(id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendBuffer(Buffer buffer, boolean z10, boolean z11) {
            if (this.cancelSent) {
                return;
            }
            if (this.canStart) {
                this.pendingData.write(buffer, (int) buffer.size());
                this.pendingDataHasEndOfStream |= z10;
                this.flushPendingData |= z11;
            } else {
                o.y(id() != -1, "streamId should be set");
                this.outboundFlow.data(z10, this.outboundFlowState, buffer, z11);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void streamReady(Metadata metadata, String str) {
            this.requestHeaders = Headers.createRequestHeaders(metadata, str, OkHttpClientStream.this.authority, OkHttpClientStream.this.userAgent, OkHttpClientStream.this.useGet, this.transport.isUsingPlaintext());
            this.transport.streamReadyToStart(OkHttpClientStream.this);
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
                this.frameWriter.windowUpdate(id(), i13);
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframeFailed(Throwable th) {
            http2ProcessingFailed(Status.fromThrowable(th), true, new Metadata());
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState, io.grpc.internal.AbstractClientStream.TransportState, io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean z10) {
            onEndOfStream();
            super.deframerClosed(z10);
        }

        public OutboundFlowController.StreamState getOutboundFlowState() {
            OutboundFlowController.StreamState streamState;
            synchronized (this.lock) {
                streamState = this.outboundFlowState;
            }
            return streamState;
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState
        public void http2ProcessingFailed(Status status, boolean z10, Metadata metadata) {
            cancel(status, z10, metadata);
        }

        public int id() {
            return this.f50075id;
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public void onStreamAllocated() {
            super.onStreamAllocated();
            getTransportTracer().reportLocalStreamStarted();
        }

        @Override // io.grpc.internal.ApplicationThreadDeframerListener.TransportExecutor
        public void runOnTransportThread(Runnable runnable) {
            synchronized (this.lock) {
                runnable.run();
            }
        }

        public void start(int i10) {
            o.z(this.f50075id == -1, "the stream has been started with id %s", i10);
            this.f50075id = i10;
            this.outboundFlowState = this.outboundFlow.createState(this, i10);
            OkHttpClientStream.this.state.onStreamAllocated();
            if (this.canStart) {
                this.frameWriter.synStream(OkHttpClientStream.this.useGet, false, this.f50075id, 0, this.requestHeaders);
                OkHttpClientStream.this.statsTraceCtx.clientOutboundHeaders();
                this.requestHeaders = null;
                if (this.pendingData.size() > 0) {
                    this.outboundFlow.data(this.pendingDataHasEndOfStream, this.outboundFlowState, this.pendingData, this.flushPendingData);
                }
                this.canStart = false;
            }
        }

        public Tag tag() {
            return this.tag;
        }

        public void transportDataReceived(Buffer buffer, boolean z10) {
            int size = this.window - ((int) buffer.size());
            this.window = size;
            if (size < 0) {
                this.frameWriter.rstStream(id(), ErrorCode.FLOW_CONTROL_ERROR);
                this.transport.finishStream(id(), Status.INTERNAL.withDescription("Received data size exceeded our receiving window size"), ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            } else {
                super.transportDataReceived(new OkHttpReadableBuffer(buffer), z10);
            }
        }

        public void transportHeadersReceived(List<Header> list, boolean z10) {
            if (z10) {
                transportTrailersReceived(Utils.convertTrailers(list));
            } else {
                transportHeadersReceived(Utils.convertHeaders(list));
            }
        }
    }

    public OkHttpClientStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OkHttpClientTransport okHttpClientTransport, OutboundFlowController outboundFlowController, Object obj, int i10, int i11, String str, String str2, StatsTraceContext statsTraceContext, TransportTracer transportTracer, CallOptions callOptions, boolean z10) {
        super(new OkHttpWritableBufferAllocator(), statsTraceContext, transportTracer, metadata, callOptions, z10 && methodDescriptor.isSafe());
        this.sink = new Sink();
        this.useGet = false;
        this.statsTraceCtx = (StatsTraceContext) o.s(statsTraceContext, "statsTraceCtx");
        this.method = methodDescriptor;
        this.authority = str;
        this.userAgent = str2;
        this.attributes = okHttpClientTransport.getAttributes();
        this.state = new TransportState(i10, statsTraceContext, obj, exceptionHandlingFrameWriter, outboundFlowController, okHttpClientTransport, i11, methodDescriptor.getFullMethodName());
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return this.attributes;
    }

    public MethodDescriptor.MethodType getType() {
        return this.method.getType();
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
        this.authority = (String) o.s(str, "authority");
    }

    public boolean useGet() {
        return this.useGet;
    }

    @Override // io.grpc.internal.AbstractClientStream
    public Sink abstractClientStreamSink() {
        return this.sink;
    }

    @Override // io.grpc.internal.AbstractClientStream, io.grpc.internal.AbstractStream
    public TransportState transportState() {
        return this.state;
    }
}
