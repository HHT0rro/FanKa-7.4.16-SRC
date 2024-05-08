package io.grpc.okhttp;

import com.google.common.base.o;
import com.google.common.util.concurrent.n;
import com.huawei.flexiblelayout.card.FLPNode;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.quickcard.base.http.ContentType;
import io.grpc.Attributes;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveEnforcer;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.LogExceptionRunnable;
import io.grpc.internal.MaxConnectionIdleManager;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.HandshakerSocketFactory;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.OkHttpServerStream;
import io.grpc.okhttp.OkHttpServerTransport;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import io.grpc.okhttp.internal.framed.Variant;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipUtils;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class OkHttpServerTransport implements ServerTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler, OutboundFlowController.Transport {
    private static final int GRACEFUL_SHUTDOWN_PING = 4369;
    private static final int KEEPALIVE_PING = 57005;
    private boolean abruptShutdown;
    private Attributes attributes;
    private final Socket bareSocket;
    private final Config config;
    private ScheduledFuture<?> forcefulCloseTimer;
    private ExceptionHandlingFrameWriter frameWriter;
    private Status goAwayStatus;
    private boolean gracefulShutdown;
    private boolean handshakeShutdown;
    private final KeepAliveEnforcer keepAliveEnforcer;
    private KeepAliveManager keepAliveManager;
    private int lastStreamId;
    private ServerTransportListener listener;
    private final InternalLogId logId;
    private ScheduledFuture<?> maxConnectionAgeMonitor;
    private MaxConnectionIdleManager maxConnectionIdleManager;
    private OutboundFlowController outboundFlow;
    private ScheduledExecutorService scheduledExecutorService;
    private ScheduledFuture<?> secondGoawayTimer;
    private InternalChannelz.Security securityInfo;
    private final TransportTracer tracer;
    private Executor transportExecutor;
    private static final Logger log = Logger.getLogger(OkHttpServerTransport.class.getName());
    private static final ByteString HTTP_METHOD = ByteString.encodeUtf8(":method");
    private static final ByteString CONNECT_METHOD = ByteString.encodeUtf8("CONNECT");
    private static final ByteString POST_METHOD = ByteString.encodeUtf8("POST");
    private static final ByteString SCHEME = ByteString.encodeUtf8(":scheme");
    private static final ByteString PATH = ByteString.encodeUtf8(":path");
    private static final ByteString AUTHORITY = ByteString.encodeUtf8(":authority");
    private static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
    private static final ByteString HOST = ByteString.encodeUtf8("host");
    private static final ByteString TE = ByteString.encodeUtf8("te");
    private static final ByteString TE_TRAILERS = ByteString.encodeUtf8(GrpcUtil.TE_TRAILERS);
    private static final ByteString CONTENT_TYPE = ByteString.encodeUtf8(com.alipay.sdk.packet.e.f4632d);
    private static final ByteString CONTENT_LENGTH = ByteString.encodeUtf8("content-length");
    private final Variant variant = new Http2();
    private final Object lock = new Object();
    private final Map<Integer, StreamState> streams = new TreeMap();
    private int goAwayStreamId = Integer.MAX_VALUE;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Config {
        public final int flowControlWindow;
        public final HandshakerSocketFactory handshakerSocketFactory;
        public final long keepAliveTimeNanos;
        public final long keepAliveTimeoutNanos;
        public final long maxConnectionAgeGraceInNanos;
        public final long maxConnectionAgeInNanos;
        public final long maxConnectionIdleNanos;
        public final int maxInboundMessageSize;
        public final int maxInboundMetadataSize;
        public final long permitKeepAliveTimeInNanos;
        public final boolean permitKeepAliveWithoutCalls;
        public final ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool;
        public final List<? extends ServerStreamTracer.Factory> streamTracerFactories;
        public final ObjectPool<Executor> transportExecutorPool;
        public final TransportTracer.Factory transportTracerFactory;

        public Config(OkHttpServerBuilder okHttpServerBuilder, List<? extends ServerStreamTracer.Factory> list) {
            this.streamTracerFactories = (List) o.s(list, "streamTracerFactories");
            this.transportExecutorPool = (ObjectPool) o.s(okHttpServerBuilder.transportExecutorPool, "transportExecutorPool");
            this.scheduledExecutorServicePool = (ObjectPool) o.s(okHttpServerBuilder.scheduledExecutorServicePool, "scheduledExecutorServicePool");
            this.transportTracerFactory = (TransportTracer.Factory) o.s(okHttpServerBuilder.transportTracerFactory, "transportTracerFactory");
            this.handshakerSocketFactory = (HandshakerSocketFactory) o.s(okHttpServerBuilder.handshakerSocketFactory, "handshakerSocketFactory");
            this.keepAliveTimeNanos = okHttpServerBuilder.keepAliveTimeNanos;
            this.keepAliveTimeoutNanos = okHttpServerBuilder.keepAliveTimeoutNanos;
            this.flowControlWindow = okHttpServerBuilder.flowControlWindow;
            this.maxInboundMessageSize = okHttpServerBuilder.maxInboundMessageSize;
            this.maxInboundMetadataSize = okHttpServerBuilder.maxInboundMetadataSize;
            this.maxConnectionIdleNanos = okHttpServerBuilder.maxConnectionIdleInNanos;
            this.permitKeepAliveWithoutCalls = okHttpServerBuilder.permitKeepAliveWithoutCalls;
            this.permitKeepAliveTimeInNanos = okHttpServerBuilder.permitKeepAliveTimeInNanos;
            this.maxConnectionAgeInNanos = okHttpServerBuilder.maxConnectionAgeInNanos;
            this.maxConnectionAgeGraceInNanos = okHttpServerBuilder.maxConnectionAgeGraceInNanos;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class FrameHandler implements FrameReader.Handler, Runnable {
        private int connectionUnacknowledgedBytesRead;
        private final OkHttpFrameLogger frameLogger = new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpServerTransport.class);
        private final FrameReader frameReader;
        private boolean receivedSettings;

        public FrameHandler(FrameReader frameReader) {
            this.frameReader = frameReader;
        }

        private void connectionError(ErrorCode errorCode, String str) {
            OkHttpServerTransport.this.abruptShutdown(errorCode, str, GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).withDescription(String.format("HTTP2 connection error: %s '%s'", errorCode, str)), false);
        }

        private int headerBlockSize(List<Header> list) {
            long j10 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                Header header = list.get(i10);
                j10 += header.name.size() + 32 + header.value.size();
            }
            return (int) Math.min(j10, ZipUtils.UPPER_UNIXTIME_BOUND);
        }

        private void respondWithGrpcError(int i10, boolean z10, Status.Code code, String str) {
            Metadata metadata = new Metadata();
            metadata.put(InternalStatus.CODE_KEY, code.toStatus());
            metadata.put(InternalStatus.MESSAGE_KEY, str);
            List<Header> createResponseTrailers = Headers.createResponseTrailers(metadata, false);
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.frameWriter.synReply(true, i10, createResponseTrailers);
                if (!z10) {
                    OkHttpServerTransport.this.frameWriter.rstStream(i10, ErrorCode.NO_ERROR);
                }
                OkHttpServerTransport.this.frameWriter.flush();
            }
        }

        private void respondWithHttpError(int i10, boolean z10, int i11, Status.Code code, String str) {
            Metadata metadata = new Metadata();
            metadata.put(InternalStatus.CODE_KEY, code.toStatus());
            metadata.put(InternalStatus.MESSAGE_KEY, str);
            List<Header> createHttpResponseHeaders = Headers.createHttpResponseHeaders(i11, ContentType.TEXT_PLAIN_UTF8, metadata);
            Buffer writeUtf8 = new Buffer().writeUtf8(str);
            synchronized (OkHttpServerTransport.this.lock) {
                final Http2ErrorStreamState http2ErrorStreamState = new Http2ErrorStreamState(i10, OkHttpServerTransport.this.lock, OkHttpServerTransport.this.outboundFlow, OkHttpServerTransport.this.config.flowControlWindow);
                if (OkHttpServerTransport.this.streams.isEmpty()) {
                    OkHttpServerTransport.this.keepAliveEnforcer.onTransportActive();
                    if (OkHttpServerTransport.this.maxConnectionIdleManager != null) {
                        OkHttpServerTransport.this.maxConnectionIdleManager.onTransportActive();
                    }
                }
                OkHttpServerTransport.this.streams.put(Integer.valueOf(i10), http2ErrorStreamState);
                if (z10) {
                    http2ErrorStreamState.inboundDataReceived(new Buffer(), 0, true);
                }
                OkHttpServerTransport.this.frameWriter.headers(i10, createHttpResponseHeaders);
                OkHttpServerTransport.this.outboundFlow.data(true, http2ErrorStreamState.getOutboundFlowState(), writeUtf8, true);
                OkHttpServerTransport.this.outboundFlow.notifyWhenNoPendingData(http2ErrorStreamState.getOutboundFlowState(), new Runnable() { // from class: io.grpc.okhttp.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        OkHttpServerTransport.FrameHandler.this.lambda$respondWithHttpError$0(http2ErrorStreamState);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: rstOkAtEndOfHttpError, reason: merged with bridge method [inline-methods] */
        public void lambda$respondWithHttpError$0(Http2ErrorStreamState http2ErrorStreamState) {
            synchronized (OkHttpServerTransport.this.lock) {
                if (!http2ErrorStreamState.hasReceivedEndOfStream()) {
                    OkHttpServerTransport.this.frameWriter.rstStream(http2ErrorStreamState.streamId, ErrorCode.NO_ERROR);
                }
                OkHttpServerTransport.this.streamClosed(http2ErrorStreamState.streamId, true);
            }
        }

        private void streamError(int i10, ErrorCode errorCode, String str) {
            if (errorCode == ErrorCode.PROTOCOL_ERROR) {
                OkHttpServerTransport.log.log(Level.FINE, "Responding with RST_STREAM {0}: {1}", new Object[]{errorCode, str});
            }
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.frameWriter.rstStream(i10, errorCode);
                OkHttpServerTransport.this.frameWriter.flush();
                StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i10));
                if (streamState != null) {
                    streamState.transportReportStatus(Status.INTERNAL.withDescription(String.format("Responded with RST_STREAM %s: %s", errorCode, str)));
                    OkHttpServerTransport.this.streamClosed(i10, false);
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i10, String str, ByteString byteString, String str2, int i11, long j10) {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z10, int i10, BufferedSource bufferedSource, int i11) throws IOException {
            this.frameLogger.logData(OkHttpFrameLogger.Direction.INBOUND, i10, bufferedSource.getBuffer(), i11, z10);
            if (i10 == 0) {
                connectionError(ErrorCode.PROTOCOL_ERROR, "Stream 0 is reserved for control messages. RFC7540 section 5.1.1");
                return;
            }
            if ((i10 & 1) == 0) {
                connectionError(ErrorCode.PROTOCOL_ERROR, "Clients cannot open even numbered streams. RFC7540 section 5.1.1");
                return;
            }
            long j10 = i11;
            bufferedSource.require(j10);
            synchronized (OkHttpServerTransport.this.lock) {
                StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i10));
                if (streamState == null) {
                    bufferedSource.skip(j10);
                    streamError(i10, ErrorCode.STREAM_CLOSED, "Received data for closed stream");
                    return;
                }
                if (streamState.hasReceivedEndOfStream()) {
                    bufferedSource.skip(j10);
                    streamError(i10, ErrorCode.STREAM_CLOSED, "Received DATA for half-closed (remote) stream. RFC7540 section 5.1");
                    return;
                }
                if (streamState.inboundWindowAvailable() < i11) {
                    bufferedSource.skip(j10);
                    streamError(i10, ErrorCode.FLOW_CONTROL_ERROR, "Received DATA size exceeded window size. RFC7540 section 6.9");
                    return;
                }
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.getBuffer(), j10);
                streamState.inboundDataReceived(buffer, i11, z10);
                int i12 = this.connectionUnacknowledgedBytesRead + i11;
                this.connectionUnacknowledgedBytesRead = i12;
                if (i12 >= OkHttpServerTransport.this.config.flowControlWindow * 0.5f) {
                    synchronized (OkHttpServerTransport.this.lock) {
                        OkHttpServerTransport.this.frameWriter.windowUpdate(0, this.connectionUnacknowledgedBytesRead);
                        OkHttpServerTransport.this.frameWriter.flush();
                    }
                    this.connectionUnacknowledgedBytesRead = 0;
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i10, ErrorCode errorCode, ByteString byteString) {
            this.frameLogger.logGoAway(OkHttpFrameLogger.Direction.INBOUND, i10, errorCode, byteString);
            Status withDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).withDescription(String.format("Received GOAWAY: %s '%s'", errorCode, byteString.utf8()));
            if (!ErrorCode.NO_ERROR.equals(errorCode)) {
                OkHttpServerTransport.log.log(Level.WARNING, "Received GOAWAY: {0} {1}", new Object[]{errorCode, byteString.utf8()});
            }
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.goAwayStatus = withDescription;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z10, boolean z11, int i10, int i11, List<Header> list, HeadersMode headersMode) {
            int headerFind;
            this.frameLogger.logHeaders(OkHttpFrameLogger.Direction.INBOUND, i10, list, z11);
            if ((i10 & 1) == 0) {
                connectionError(ErrorCode.PROTOCOL_ERROR, "Clients cannot open even numbered streams. RFC7540 section 5.1.1");
                return;
            }
            synchronized (OkHttpServerTransport.this.lock) {
                if (i10 > OkHttpServerTransport.this.goAwayStreamId) {
                    return;
                }
                boolean z12 = i10 > OkHttpServerTransport.this.lastStreamId;
                if (z12) {
                    OkHttpServerTransport.this.lastStreamId = i10;
                }
                int headerBlockSize = headerBlockSize(list);
                if (headerBlockSize > OkHttpServerTransport.this.config.maxInboundMetadataSize) {
                    respondWithHttpError(i10, z11, 431, Status.Code.RESOURCE_EXHAUSTED, String.format(Locale.US, "Request metadata larger than %d: %d", Integer.valueOf(OkHttpServerTransport.this.config.maxInboundMetadataSize), Integer.valueOf(headerBlockSize)));
                    return;
                }
                OkHttpServerTransport.headerRemove(list, ByteString.EMPTY);
                String str = null;
                ByteString byteString = null;
                ByteString byteString2 = null;
                ByteString byteString3 = null;
                ByteString byteString4 = null;
                while (list.size() > 0 && list.get(0).name.getByte(0) == 58) {
                    Header remove = list.remove(0);
                    if (OkHttpServerTransport.HTTP_METHOD.equals(remove.name) && byteString == null) {
                        byteString = remove.value;
                    } else if (OkHttpServerTransport.SCHEME.equals(remove.name) && byteString2 == null) {
                        byteString2 = remove.value;
                    } else if (OkHttpServerTransport.PATH.equals(remove.name) && byteString3 == null) {
                        byteString3 = remove.value;
                    } else if (OkHttpServerTransport.AUTHORITY.equals(remove.name) && byteString4 == null) {
                        byteString4 = remove.value;
                    } else {
                        streamError(i10, ErrorCode.PROTOCOL_ERROR, "Unexpected pseudo header. RFC7540 section 8.1.2.1");
                        return;
                    }
                }
                for (int i12 = 0; i12 < list.size(); i12++) {
                    if (list.get(i12).name.getByte(0) == 58) {
                        streamError(i10, ErrorCode.PROTOCOL_ERROR, "Pseudo header not before regular headers. RFC7540 section 8.1.2.1");
                        return;
                    }
                }
                if (!OkHttpServerTransport.CONNECT_METHOD.equals(byteString) && z12 && (byteString == null || byteString2 == null || byteString3 == null)) {
                    streamError(i10, ErrorCode.PROTOCOL_ERROR, "Missing required pseudo header. RFC7540 section 8.1.2.3");
                    return;
                }
                if (OkHttpServerTransport.headerContains(list, OkHttpServerTransport.CONNECTION)) {
                    streamError(i10, ErrorCode.PROTOCOL_ERROR, "Connection-specific headers not permitted. RFC7540 section 8.1.2.2");
                    return;
                }
                if (!z12) {
                    if (z11) {
                        synchronized (OkHttpServerTransport.this.lock) {
                            StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i10));
                            if (streamState == null) {
                                streamError(i10, ErrorCode.STREAM_CLOSED, "Received headers for closed stream");
                                return;
                            } else if (streamState.hasReceivedEndOfStream()) {
                                streamError(i10, ErrorCode.STREAM_CLOSED, "Received HEADERS for half-closed (remote) stream. RFC7540 section 5.1");
                                return;
                            } else {
                                streamState.inboundDataReceived(new Buffer(), 0, true);
                                return;
                            }
                        }
                    }
                    streamError(i10, ErrorCode.PROTOCOL_ERROR, "Headers disallowed in the middle of the stream. RFC7540 section 8.1");
                    return;
                }
                if (byteString4 == null && (headerFind = OkHttpServerTransport.headerFind(list, OkHttpServerTransport.HOST, 0)) != -1) {
                    if (OkHttpServerTransport.headerFind(list, OkHttpServerTransport.HOST, headerFind + 1) != -1) {
                        respondWithHttpError(i10, z11, 400, Status.Code.INTERNAL, "Multiple host headers disallowed. RFC7230 section 5.4");
                        return;
                    }
                    byteString4 = list.get(headerFind).value;
                }
                ByteString byteString5 = byteString4;
                OkHttpServerTransport.headerRemove(list, OkHttpServerTransport.HOST);
                if (byteString3.size() != 0 && byteString3.getByte(0) == 47) {
                    String substring = OkHttpServerTransport.asciiString(byteString3).substring(1);
                    ByteString headerGetRequiredSingle = OkHttpServerTransport.headerGetRequiredSingle(list, OkHttpServerTransport.CONTENT_TYPE);
                    if (headerGetRequiredSingle == null) {
                        respondWithHttpError(i10, z11, 415, Status.Code.INTERNAL, "Content-Type is missing or duplicated");
                        return;
                    }
                    String asciiString = OkHttpServerTransport.asciiString(headerGetRequiredSingle);
                    if (!GrpcUtil.isGrpcContentType(asciiString)) {
                        respondWithHttpError(i10, z11, 415, Status.Code.INTERNAL, "Content-Type is not supported: " + asciiString);
                        return;
                    }
                    if (!OkHttpServerTransport.POST_METHOD.equals(byteString)) {
                        respondWithHttpError(i10, z11, 405, Status.Code.INTERNAL, "HTTP Method is not supported: " + OkHttpServerTransport.asciiString(byteString));
                        return;
                    }
                    ByteString headerGetRequiredSingle2 = OkHttpServerTransport.headerGetRequiredSingle(list, OkHttpServerTransport.TE);
                    if (!OkHttpServerTransport.TE_TRAILERS.equals(headerGetRequiredSingle2)) {
                        Status.Code code = Status.Code.INTERNAL;
                        Object[] objArr = new Object[2];
                        objArr[0] = OkHttpServerTransport.asciiString(OkHttpServerTransport.TE_TRAILERS);
                        objArr[1] = headerGetRequiredSingle2 == null ? "<missing>" : OkHttpServerTransport.asciiString(headerGetRequiredSingle2);
                        respondWithGrpcError(i10, z11, code, String.format("Expected header TE: %s, but %s is received. Some intermediate proxy may not support trailers", objArr));
                        return;
                    }
                    OkHttpServerTransport.headerRemove(list, OkHttpServerTransport.CONTENT_LENGTH);
                    Metadata convertHeaders = Utils.convertHeaders(list);
                    StatsTraceContext newServerContext = StatsTraceContext.newServerContext(OkHttpServerTransport.this.config.streamTracerFactories, substring, convertHeaders);
                    synchronized (OkHttpServerTransport.this.lock) {
                        OkHttpServerTransport okHttpServerTransport = OkHttpServerTransport.this;
                        OkHttpServerStream.TransportState transportState = new OkHttpServerStream.TransportState(okHttpServerTransport, i10, okHttpServerTransport.config.maxInboundMessageSize, newServerContext, OkHttpServerTransport.this.lock, OkHttpServerTransport.this.frameWriter, OkHttpServerTransport.this.outboundFlow, OkHttpServerTransport.this.config.flowControlWindow, OkHttpServerTransport.this.tracer, substring);
                        Attributes attributes = OkHttpServerTransport.this.attributes;
                        if (byteString5 != null) {
                            str = OkHttpServerTransport.asciiString(byteString5);
                        }
                        OkHttpServerStream okHttpServerStream = new OkHttpServerStream(transportState, attributes, str, newServerContext, OkHttpServerTransport.this.tracer);
                        if (OkHttpServerTransport.this.streams.isEmpty()) {
                            OkHttpServerTransport.this.keepAliveEnforcer.onTransportActive();
                            if (OkHttpServerTransport.this.maxConnectionIdleManager != null) {
                                OkHttpServerTransport.this.maxConnectionIdleManager.onTransportActive();
                            }
                        }
                        OkHttpServerTransport.this.streams.put(Integer.valueOf(i10), transportState);
                        OkHttpServerTransport.this.listener.streamCreated(okHttpServerStream, substring, convertHeaders);
                        transportState.onStreamAllocated();
                        if (z11) {
                            transportState.inboundDataReceived(new Buffer(), 0, z11);
                        }
                    }
                    return;
                }
                respondWithHttpError(i10, z11, 404, Status.Code.UNIMPLEMENTED, "Expected path to start with /: " + OkHttpServerTransport.asciiString(byteString3));
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z10, int i10, int i11) {
            if (!OkHttpServerTransport.this.keepAliveEnforcer.pingAcceptable()) {
                OkHttpServerTransport.this.abruptShutdown(ErrorCode.ENHANCE_YOUR_CALM, "too_many_pings", Status.RESOURCE_EXHAUSTED.withDescription("Too many pings from client"), false);
                return;
            }
            long j10 = (i10 << 32) | (i11 & 4294967295L);
            if (!z10) {
                this.frameLogger.logPing(OkHttpFrameLogger.Direction.INBOUND, j10);
                synchronized (OkHttpServerTransport.this.lock) {
                    OkHttpServerTransport.this.frameWriter.ping(true, i10, i11);
                    OkHttpServerTransport.this.frameWriter.flush();
                }
                return;
            }
            this.frameLogger.logPingAck(OkHttpFrameLogger.Direction.INBOUND, j10);
            if (57005 == j10) {
                return;
            }
            if (4369 == j10) {
                OkHttpServerTransport.this.triggerGracefulSecondGoaway();
                return;
            }
            OkHttpServerTransport.log.log(Level.INFO, "Received unexpected ping ack: " + j10);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i10, int i11, int i12, boolean z10) {
            this.frameLogger.logPriority(OkHttpFrameLogger.Direction.INBOUND, i10, i11, i12, z10);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i10, int i11, List<Header> list) throws IOException {
            this.frameLogger.logPushPromise(OkHttpFrameLogger.Direction.INBOUND, i10, i11, list);
            connectionError(ErrorCode.PROTOCOL_ERROR, "PUSH_PROMISE only allowed on peer-initiated streams. RFC7540 section 6.6");
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i10, ErrorCode errorCode) {
            this.frameLogger.logRstStream(OkHttpFrameLogger.Direction.INBOUND, i10, errorCode);
            if (!ErrorCode.NO_ERROR.equals(errorCode) && !ErrorCode.CANCEL.equals(errorCode) && !ErrorCode.STREAM_CLOSED.equals(errorCode)) {
                OkHttpServerTransport.log.log(Level.INFO, "Received RST_STREAM: " + ((Object) errorCode));
            }
            Status withDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).withDescription("RST_STREAM");
            synchronized (OkHttpServerTransport.this.lock) {
                StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i10));
                if (streamState != null) {
                    streamState.inboundRstReceived(withDescription);
                    OkHttpServerTransport.this.streamClosed(i10, false);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            InputStream inputStream;
            Status status;
            InputStream inputStream2;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpServerTransport");
            try {
                try {
                    this.frameReader.readConnectionPreface();
                } catch (Throwable th) {
                    try {
                        OkHttpServerTransport.log.log(Level.WARNING, "Error decoding HTTP/2 frames", th);
                        OkHttpServerTransport.this.abruptShutdown(ErrorCode.INTERNAL_ERROR, "Error in frame decoder", Status.INTERNAL.withDescription("Error decoding HTTP/2 frames").withCause(th), false);
                        inputStream = OkHttpServerTransport.this.bareSocket.getInputStream();
                    } catch (Throwable th2) {
                        try {
                            GrpcUtil.exhaust(OkHttpServerTransport.this.bareSocket.getInputStream());
                        } catch (IOException unused) {
                        }
                        GrpcUtil.closeQuietly(OkHttpServerTransport.this.bareSocket);
                        OkHttpServerTransport.this.terminated();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            } catch (IOException unused2) {
            }
            if (!this.frameReader.nextFrame(this)) {
                connectionError(ErrorCode.INTERNAL_ERROR, "Failed to read initial SETTINGS");
                inputStream2 = OkHttpServerTransport.this.bareSocket.getInputStream();
            } else if (!this.receivedSettings) {
                connectionError(ErrorCode.PROTOCOL_ERROR, "First HTTP/2 frame must be SETTINGS. RFC7540 section 3.5");
                inputStream2 = OkHttpServerTransport.this.bareSocket.getInputStream();
            } else {
                while (this.frameReader.nextFrame(this)) {
                    if (OkHttpServerTransport.this.keepAliveManager != null) {
                        OkHttpServerTransport.this.keepAliveManager.onDataReceived();
                    }
                }
                synchronized (OkHttpServerTransport.this.lock) {
                    status = OkHttpServerTransport.this.goAwayStatus;
                }
                if (status == null) {
                    status = Status.UNAVAILABLE.withDescription("TCP connection closed or IOException");
                }
                OkHttpServerTransport.this.abruptShutdown(ErrorCode.INTERNAL_ERROR, "I/O failure", status, false);
                inputStream = OkHttpServerTransport.this.bareSocket.getInputStream();
                GrpcUtil.exhaust(inputStream);
                GrpcUtil.closeQuietly(OkHttpServerTransport.this.bareSocket);
                OkHttpServerTransport.this.terminated();
                Thread.currentThread().setName(name);
                return;
            }
            GrpcUtil.exhaust(inputStream2);
            GrpcUtil.closeQuietly(OkHttpServerTransport.this.bareSocket);
            OkHttpServerTransport.this.terminated();
            Thread.currentThread().setName(name);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z10, Settings settings) {
            this.frameLogger.logSettings(OkHttpFrameLogger.Direction.INBOUND, settings);
            synchronized (OkHttpServerTransport.this.lock) {
                boolean z11 = false;
                if (OkHttpSettingsUtil.isSet(settings, 7)) {
                    z11 = OkHttpServerTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                }
                OkHttpServerTransport.this.frameWriter.ackSettings(settings);
                OkHttpServerTransport.this.frameWriter.flush();
                if (!this.receivedSettings) {
                    this.receivedSettings = true;
                    OkHttpServerTransport okHttpServerTransport = OkHttpServerTransport.this;
                    okHttpServerTransport.attributes = okHttpServerTransport.listener.transportReady(OkHttpServerTransport.this.attributes);
                }
                if (z11) {
                    OkHttpServerTransport.this.outboundFlow.writeStreams();
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i10, long j10) {
            this.frameLogger.logWindowsUpdate(OkHttpFrameLogger.Direction.INBOUND, i10, j10);
            synchronized (OkHttpServerTransport.this.lock) {
                if (i10 == 0) {
                    OkHttpServerTransport.this.outboundFlow.windowUpdate(null, (int) j10);
                } else {
                    StreamState streamState = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(i10));
                    if (streamState != null) {
                        OkHttpServerTransport.this.outboundFlow.windowUpdate(streamState.getOutboundFlowState(), (int) j10);
                    }
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Http2ErrorStreamState implements StreamState, OutboundFlowController.Stream {
        private final Object lock;
        private final OutboundFlowController.StreamState outboundFlowState;
        private boolean receivedEndOfStream;
        private final int streamId;
        private int window;

        public Http2ErrorStreamState(int i10, Object obj, OutboundFlowController outboundFlowController, int i11) {
            this.streamId = i10;
            this.lock = obj;
            this.outboundFlowState = outboundFlowController.createState(this, i10);
            this.window = i11;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public OutboundFlowController.StreamState getOutboundFlowState() {
            OutboundFlowController.StreamState streamState;
            synchronized (this.lock) {
                streamState = this.outboundFlowState;
            }
            return streamState;
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
                if (z10) {
                    this.receivedEndOfStream = true;
                }
                this.window -= i10;
                try {
                    buffer.skip(buffer.size());
                } catch (IOException e2) {
                    throw new AssertionError(e2);
                }
            }
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void inboundRstReceived(Status status) {
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public int inboundWindowAvailable() {
            int i10;
            synchronized (this.lock) {
                i10 = this.window;
            }
            return i10;
        }

        @Override // io.grpc.okhttp.OutboundFlowController.Stream
        public void onSentBytes(int i10) {
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void transportReportStatus(Status status) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class KeepAlivePinger implements KeepAliveManager.KeepAlivePinger {
        private KeepAlivePinger() {
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void onPingTimeout() {
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.goAwayStatus = Status.UNAVAILABLE.withDescription("Keepalive failed. Considering connection dead");
                GrpcUtil.closeQuietly(OkHttpServerTransport.this.bareSocket);
            }
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void ping() {
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.frameWriter.ping(false, 0, OkHttpServerTransport.KEEPALIVE_PING);
                OkHttpServerTransport.this.frameWriter.flush();
            }
            OkHttpServerTransport.this.tracer.reportKeepAliveSent();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface StreamState {
        OutboundFlowController.StreamState getOutboundFlowState();

        boolean hasReceivedEndOfStream();

        void inboundDataReceived(Buffer buffer, int i10, boolean z10);

        void inboundRstReceived(Status status);

        int inboundWindowAvailable();

        void transportReportStatus(Status status);
    }

    public OkHttpServerTransport(Config config, Socket socket) {
        this.config = (Config) o.s(config, FLPNode.KEY_CONFIG);
        this.bareSocket = (Socket) o.s(socket, "bareSocket");
        TransportTracer create = config.transportTracerFactory.create();
        this.tracer = create;
        create.setFlowControlWindowReader(new TransportTracer.FlowControlReader() { // from class: io.grpc.okhttp.d
            @Override // io.grpc.internal.TransportTracer.FlowControlReader
            public final TransportTracer.FlowControlWindows read() {
                TransportTracer.FlowControlWindows readFlowControlWindow;
                readFlowControlWindow = OkHttpServerTransport.this.readFlowControlWindow();
                return readFlowControlWindow;
            }
        });
        this.logId = InternalLogId.allocate((Class<?>) OkHttpServerTransport.class, socket.getRemoteSocketAddress().toString());
        this.transportExecutor = config.transportExecutorPool.getObject();
        this.scheduledExecutorService = config.scheduledExecutorServicePool.getObject();
        this.keepAliveEnforcer = new KeepAliveEnforcer(config.permitKeepAliveWithoutCalls, config.permitKeepAliveTimeInNanos, TimeUnit.NANOSECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abruptShutdown(ErrorCode errorCode, String str, Status status, boolean z10) {
        synchronized (this.lock) {
            if (this.abruptShutdown) {
                return;
            }
            this.abruptShutdown = true;
            this.goAwayStatus = status;
            ScheduledFuture<?> scheduledFuture = this.secondGoawayTimer;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.secondGoawayTimer = null;
            }
            for (Map.Entry<Integer, StreamState> entry : this.streams.entrySet()) {
                if (z10) {
                    this.frameWriter.rstStream(entry.getKey().intValue(), ErrorCode.CANCEL);
                }
                entry.getValue().transportReportStatus(status);
            }
            this.streams.clear();
            this.frameWriter.goAway(this.lastStreamId, errorCode, str.getBytes(GrpcUtil.US_ASCII));
            this.goAwayStreamId = this.lastStreamId;
            this.frameWriter.close();
            this.forcefulCloseTimer = this.scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.okhttp.h
                @Override // java.lang.Runnable
                public final void run() {
                    OkHttpServerTransport.this.triggerForcefulClose();
                }
            }, 1L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String asciiString(ByteString byteString) {
        for (int i10 = 0; i10 < byteString.size(); i10++) {
            if (byteString.getByte(i10) >= 128) {
                return byteString.string(GrpcUtil.US_ASCII);
            }
        }
        return byteString.utf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean headerContains(List<Header> list, ByteString byteString) {
        return headerFind(list, byteString, 0) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int headerFind(List<Header> list, ByteString byteString, int i10) {
        while (i10 < list.size()) {
            if (list.get(i10).name.equals(byteString)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString headerGetRequiredSingle(List<Header> list, ByteString byteString) {
        int headerFind = headerFind(list, byteString, 0);
        if (headerFind != -1 && headerFind(list, byteString, headerFind + 1) == -1) {
            return list.get(headerFind).value;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void headerRemove(List<Header> list, ByteString byteString) {
        int i10 = 0;
        while (true) {
            i10 = headerFind(list, byteString, i10);
            if (i10 == -1) {
                return;
            } else {
                list.remove(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startIo$1() {
        shutdown(Long.valueOf(this.config.maxConnectionAgeGraceInNanos));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TransportTracer.FlowControlWindows readFlowControlWindow() {
        TransportTracer.FlowControlWindows flowControlWindows;
        synchronized (this.lock) {
            flowControlWindows = new TransportTracer.FlowControlWindows(this.outboundFlow == null ? -1L : r1.windowUpdate(null, 0), this.config.flowControlWindow * 0.5f);
        }
        return flowControlWindows;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startIo, reason: merged with bridge method [inline-methods] */
    public void lambda$start$0(SerializingExecutor serializingExecutor) {
        try {
            this.bareSocket.setTcpNoDelay(true);
            HandshakerSocketFactory.HandshakeResult handshake = this.config.handshakerSocketFactory.handshake(this.bareSocket, Attributes.EMPTY);
            Socket socket = handshake.socket;
            this.attributes = handshake.attributes;
            AsyncSink sink = AsyncSink.sink(serializingExecutor, this, 10000);
            sink.becomeConnected(Okio.sink(socket), socket);
            ForwardingFrameWriter forwardingFrameWriter = new ForwardingFrameWriter(sink.limitControlFramesWriter(this.variant.newWriter(Okio.buffer(sink), false))) { // from class: io.grpc.okhttp.OkHttpServerTransport.1
                @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
                public void data(boolean z10, int i10, Buffer buffer, int i11) throws IOException {
                    OkHttpServerTransport.this.keepAliveEnforcer.resetCounters();
                    super.data(z10, i10, buffer, i11);
                }

                @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
                public void headers(int i10, List<Header> list) throws IOException {
                    OkHttpServerTransport.this.keepAliveEnforcer.resetCounters();
                    super.headers(i10, list);
                }

                @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
                public void synReply(boolean z10, int i10, List<Header> list) throws IOException {
                    OkHttpServerTransport.this.keepAliveEnforcer.resetCounters();
                    super.synReply(z10, i10, list);
                }
            };
            synchronized (this.lock) {
                this.securityInfo = handshake.securityInfo;
                ExceptionHandlingFrameWriter exceptionHandlingFrameWriter = new ExceptionHandlingFrameWriter(this, forwardingFrameWriter);
                this.frameWriter = exceptionHandlingFrameWriter;
                this.outboundFlow = new OutboundFlowController(this, exceptionHandlingFrameWriter);
                this.frameWriter.connectionPreface();
                Settings settings = new Settings();
                OkHttpSettingsUtil.set(settings, 7, this.config.flowControlWindow);
                OkHttpSettingsUtil.set(settings, 6, this.config.maxInboundMetadataSize);
                this.frameWriter.settings(settings);
                if (this.config.flowControlWindow > 65535) {
                    this.frameWriter.windowUpdate(0, r0 - 65535);
                }
                this.frameWriter.flush();
            }
            if (this.config.keepAliveTimeNanos != Long.MAX_VALUE) {
                KeepAlivePinger keepAlivePinger = new KeepAlivePinger();
                ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
                Config config = this.config;
                KeepAliveManager keepAliveManager = new KeepAliveManager(keepAlivePinger, scheduledExecutorService, config.keepAliveTimeNanos, config.keepAliveTimeoutNanos, true);
                this.keepAliveManager = keepAliveManager;
                keepAliveManager.onTransportStarted();
            }
            if (this.config.maxConnectionIdleNanos != Long.MAX_VALUE) {
                MaxConnectionIdleManager maxConnectionIdleManager = new MaxConnectionIdleManager(this.config.maxConnectionIdleNanos);
                this.maxConnectionIdleManager = maxConnectionIdleManager;
                maxConnectionIdleManager.start(new Runnable() { // from class: io.grpc.okhttp.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        OkHttpServerTransport.this.shutdown();
                    }
                }, this.scheduledExecutorService);
            }
            if (this.config.maxConnectionAgeInNanos != Long.MAX_VALUE) {
                this.maxConnectionAgeMonitor = this.scheduledExecutorService.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.okhttp.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        OkHttpServerTransport.this.lambda$startIo$1();
                    }
                }), (long) (((Math.random() * 0.2d) + 0.9d) * this.config.maxConnectionAgeInNanos), TimeUnit.NANOSECONDS);
            }
            this.transportExecutor.execute(new FrameHandler(this.variant.newReader(Okio.buffer(Okio.source(socket)), false)));
        } catch (IOException | Error | RuntimeException e2) {
            synchronized (this.lock) {
                if (!this.handshakeShutdown) {
                    log.log(Level.INFO, "Socket failed to handshake", e2);
                }
            }
            GrpcUtil.closeQuietly(this.bareSocket);
            terminated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void terminated() {
        synchronized (this.lock) {
            ScheduledFuture<?> scheduledFuture = this.forcefulCloseTimer;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.forcefulCloseTimer = null;
            }
        }
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onTransportTermination();
        }
        MaxConnectionIdleManager maxConnectionIdleManager = this.maxConnectionIdleManager;
        if (maxConnectionIdleManager != null) {
            maxConnectionIdleManager.onTransportTermination();
        }
        ScheduledFuture<?> scheduledFuture2 = this.maxConnectionAgeMonitor;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
        }
        this.transportExecutor = this.config.transportExecutorPool.returnObject(this.transportExecutor);
        this.scheduledExecutorService = this.config.scheduledExecutorServicePool.returnObject(this.scheduledExecutorService);
        this.listener.transportTerminated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerForcefulClose() {
        GrpcUtil.closeQuietly(this.bareSocket);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerGracefulSecondGoaway() {
        synchronized (this.lock) {
            ScheduledFuture<?> scheduledFuture = this.secondGoawayTimer;
            if (scheduledFuture == null) {
                return;
            }
            scheduledFuture.cancel(false);
            this.secondGoawayTimer = null;
            this.frameWriter.goAway(this.lastStreamId, ErrorCode.NO_ERROR, new byte[0]);
            this.goAwayStreamId = this.lastStreamId;
            if (this.streams.isEmpty()) {
                this.frameWriter.close();
            } else {
                this.frameWriter.flush();
            }
        }
    }

    @Override // io.grpc.okhttp.OutboundFlowController.Transport
    public OutboundFlowController.StreamState[] getActiveStreams() {
        OutboundFlowController.StreamState[] streamStateArr;
        synchronized (this.lock) {
            streamStateArr = new OutboundFlowController.StreamState[this.streams.size()];
            int i10 = 0;
            Iterator<StreamState> iterator2 = this.streams.values().iterator2();
            while (iterator2.hasNext()) {
                streamStateArr[i10] = iterator2.next().getOutboundFlowState();
                i10++;
            }
        }
        return streamStateArr;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.internal.ServerTransport
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.scheduledExecutorService;
    }

    @Override // io.grpc.InternalInstrumented
    public n<InternalChannelz.SocketStats> getStats() {
        n<InternalChannelz.SocketStats> c4;
        synchronized (this.lock) {
            c4 = com.google.common.util.concurrent.i.c(new InternalChannelz.SocketStats(this.tracer.getStats(), this.bareSocket.getLocalSocketAddress(), this.bareSocket.getRemoteSocketAddress(), Utils.getSocketOptions(this.bareSocket), this.securityInfo));
        }
        return c4;
    }

    @Override // io.grpc.okhttp.ExceptionHandlingFrameWriter.TransportExceptionHandler
    public void onException(Throwable th) {
        o.s(th, "failureCause");
        abruptShutdown(ErrorCode.INTERNAL_ERROR, "I/O failure", Status.UNAVAILABLE.withCause(th), false);
    }

    @Override // io.grpc.internal.ServerTransport
    public void shutdown() {
        shutdown(Long.valueOf(TimeUnit.SECONDS.toNanos(1L)));
    }

    @Override // io.grpc.internal.ServerTransport, io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        synchronized (this.lock) {
            if (this.frameWriter == null) {
                this.handshakeShutdown = true;
                GrpcUtil.closeQuietly(this.bareSocket);
            } else {
                abruptShutdown(ErrorCode.NO_ERROR, "", status, true);
            }
        }
    }

    public void start(ServerTransportListener serverTransportListener) {
        this.listener = (ServerTransportListener) o.s(serverTransportListener, bg.e.f32299p);
        final SerializingExecutor serializingExecutor = new SerializingExecutor(this.transportExecutor);
        serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.i
            @Override // java.lang.Runnable
            public final void run() {
                OkHttpServerTransport.this.lambda$start$0(serializingExecutor);
            }
        });
    }

    public void streamClosed(int i10, boolean z10) {
        synchronized (this.lock) {
            this.streams.remove(Integer.valueOf(i10));
            if (this.streams.isEmpty()) {
                this.keepAliveEnforcer.onTransportIdle();
                MaxConnectionIdleManager maxConnectionIdleManager = this.maxConnectionIdleManager;
                if (maxConnectionIdleManager != null) {
                    maxConnectionIdleManager.onTransportIdle();
                }
            }
            if (this.gracefulShutdown && this.streams.isEmpty()) {
                this.frameWriter.close();
            } else if (z10) {
                this.frameWriter.flush();
            }
        }
    }

    private void shutdown(Long l10) {
        synchronized (this.lock) {
            if (!this.gracefulShutdown && !this.abruptShutdown) {
                this.gracefulShutdown = true;
                if (this.frameWriter == null) {
                    this.handshakeShutdown = true;
                    GrpcUtil.closeQuietly(this.bareSocket);
                } else {
                    this.secondGoawayTimer = this.scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.okhttp.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            OkHttpServerTransport.this.triggerGracefulSecondGoaway();
                        }
                    }, l10.longValue(), TimeUnit.NANOSECONDS);
                    this.frameWriter.goAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, new byte[0]);
                    this.frameWriter.ping(false, 0, GRACEFUL_SHUTDOWN_PING);
                    this.frameWriter.flush();
                }
            }
        }
    }
}
