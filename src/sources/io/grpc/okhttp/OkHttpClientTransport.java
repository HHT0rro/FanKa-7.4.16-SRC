package io.grpc.okhttp;

import android.view.textclassifier.TextClassifier;
import com.alibaba.security.realidentity.build.cs;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.base.o;
import com.google.common.base.r;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.t;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.constant.u;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Grpc;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.okhttp.OkHttpClientStream;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Credentials;
import io.grpc.okhttp.internal.StatusLine;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import io.grpc.okhttp.internal.framed.Variant;
import io.grpc.okhttp.internal.proxy.HttpUrl;
import io.grpc.okhttp.internal.proxy.Request;
import io.perfmark.PerfMark;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipUtils;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import okio.Timeout;
import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class OkHttpClientTransport implements ConnectionClientTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler, OutboundFlowController.Transport {
    private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = buildErrorCodeToStatusMap();
    private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    private final InetSocketAddress address;
    private Attributes attributes;
    private ClientFrameHandler clientFrameHandler;
    public t<Void> connectedFuture;
    public Runnable connectingCallback;
    private final ConnectionSpec connectionSpec;
    private int connectionUnacknowledgedBytesRead;
    private final String defaultAuthority;
    private boolean enableKeepAlive;
    private final Executor executor;
    private ExceptionHandlingFrameWriter frameWriter;
    private boolean goAwaySent;
    private Status goAwayStatus;
    private boolean hasStream;
    private HostnameVerifier hostnameVerifier;
    private final InUseStateAggregator<OkHttpClientStream> inUseState;
    private final int initialWindowSize;
    private KeepAliveManager keepAliveManager;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    private ManagedClientTransport.Listener listener;
    private final Object lock;
    private final InternalLogId logId;
    private int maxConcurrentStreams;
    private final int maxInboundMetadataSize;
    private final int maxMessageSize;
    private int nextStreamId;
    private OutboundFlowController outboundFlow;
    private final Deque<OkHttpClientStream> pendingStreams;
    private Http2Ping ping;
    public final HttpConnectProxiedSocketAddress proxiedAddr;
    public int proxySocketTimeout;
    private final Random random;
    private final ScheduledExecutorService scheduler;
    private InternalChannelz.Security securityInfo;
    private final SerializingExecutor serializingExecutor;
    private Socket socket;
    private final SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private boolean stopped;
    private final com.google.common.base.t<r> stopwatchFactory;
    private final Map<Integer, OkHttpClientStream> streams;
    private final Runnable tooManyPingsRunnable;
    private final TransportTracer transportTracer;
    private final boolean useGetForSafeMethods;
    private final String userAgent;
    private final Variant variant;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class ClientFrameHandler implements FrameReader.Handler, Runnable {
        public FrameReader frameReader;
        private final OkHttpFrameLogger logger = new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpClientTransport.class);
        public boolean firstSettings = true;

        public ClientFrameHandler(FrameReader frameReader) {
            this.frameReader = frameReader;
        }

        private int headerBlockSize(List<Header> list) {
            long j10 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                Header header = list.get(i10);
                j10 += header.name.size() + 32 + header.value.size();
            }
            return (int) Math.min(j10, ZipUtils.UPPER_UNIXTIME_BOUND);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i10, String str, ByteString byteString, String str2, int i11, long j10) {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z10, int i10, BufferedSource bufferedSource, int i11) throws IOException {
            this.logger.logData(OkHttpFrameLogger.Direction.INBOUND, i10, bufferedSource.getBuffer(), i11, z10);
            OkHttpClientStream stream = OkHttpClientTransport.this.getStream(i10);
            if (stream == null) {
                if (OkHttpClientTransport.this.mayHaveCreatedStream(i10)) {
                    synchronized (OkHttpClientTransport.this.lock) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i10, ErrorCode.STREAM_CLOSED);
                    }
                    bufferedSource.skip(i11);
                } else {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received data for unknown stream: " + i10);
                    return;
                }
            } else {
                long j10 = i11;
                bufferedSource.require(j10);
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.getBuffer(), j10);
                PerfMark.event("OkHttpClientTransport$ClientFrameHandler.data", stream.transportState().tag());
                synchronized (OkHttpClientTransport.this.lock) {
                    stream.transportState().transportDataReceived(buffer, z10);
                }
            }
            OkHttpClientTransport.access$2412(OkHttpClientTransport.this, i11);
            if (OkHttpClientTransport.this.connectionUnacknowledgedBytesRead >= OkHttpClientTransport.this.initialWindowSize * 0.5f) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.windowUpdate(0, OkHttpClientTransport.this.connectionUnacknowledgedBytesRead);
                }
                OkHttpClientTransport.this.connectionUnacknowledgedBytesRead = 0;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i10, ErrorCode errorCode, ByteString byteString) {
            this.logger.logGoAway(OkHttpFrameLogger.Direction.INBOUND, i10, errorCode, byteString);
            if (errorCode == ErrorCode.ENHANCE_YOUR_CALM) {
                String utf8 = byteString.utf8();
                OkHttpClientTransport.log.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, utf8));
                if ("too_many_pings".equals(utf8)) {
                    OkHttpClientTransport.this.tooManyPingsRunnable.run();
                }
            }
            Status augmentDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).augmentDescription("Received Goaway");
            if (byteString.size() > 0) {
                augmentDescription = augmentDescription.augmentDescription(byteString.utf8());
            }
            OkHttpClientTransport.this.startGoAway(i10, null, augmentDescription);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z10, boolean z11, int i10, int i11, List<Header> list, HeadersMode headersMode) {
            Status status;
            int headerBlockSize;
            this.logger.logHeaders(OkHttpFrameLogger.Direction.INBOUND, i10, list, z11);
            boolean z12 = true;
            if (OkHttpClientTransport.this.maxInboundMetadataSize == Integer.MAX_VALUE || (headerBlockSize = headerBlockSize(list)) <= OkHttpClientTransport.this.maxInboundMetadataSize) {
                status = null;
            } else {
                Status status2 = Status.RESOURCE_EXHAUSTED;
                Locale locale = Locale.US;
                Object[] objArr = new Object[3];
                objArr[0] = z11 ? "trailer" : "header";
                objArr[1] = Integer.valueOf(OkHttpClientTransport.this.maxInboundMetadataSize);
                objArr[2] = Integer.valueOf(headerBlockSize);
                status = status2.withDescription(String.format(locale, "Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i10));
                if (okHttpClientStream == null) {
                    if (OkHttpClientTransport.this.mayHaveCreatedStream(i10)) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i10, ErrorCode.STREAM_CLOSED);
                    }
                } else if (status == null) {
                    PerfMark.event("OkHttpClientTransport$ClientFrameHandler.headers", okHttpClientStream.transportState().tag());
                    okHttpClientStream.transportState().transportHeadersReceived(list, z11);
                } else {
                    if (!z11) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i10, ErrorCode.CANCEL);
                    }
                    okHttpClientStream.transportState().transportReportStatus(status, false, new Metadata());
                }
                z12 = false;
            }
            if (z12) {
                OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received header for unknown stream: " + i10);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z10, int i10, int i11) {
            Http2Ping http2Ping;
            long j10 = (i10 << 32) | (i11 & 4294967295L);
            this.logger.logPing(OkHttpFrameLogger.Direction.INBOUND, j10);
            if (!z10) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.ping(true, i10, i11);
                }
                return;
            }
            synchronized (OkHttpClientTransport.this.lock) {
                http2Ping = null;
                if (OkHttpClientTransport.this.ping == null) {
                    OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
                } else if (OkHttpClientTransport.this.ping.payload() == j10) {
                    Http2Ping http2Ping2 = OkHttpClientTransport.this.ping;
                    OkHttpClientTransport.this.ping = null;
                    http2Ping = http2Ping2;
                } else {
                    OkHttpClientTransport.log.log(Level.WARNING, String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(OkHttpClientTransport.this.ping.payload()), Long.valueOf(j10)));
                }
            }
            if (http2Ping != null) {
                http2Ping.complete();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i10, int i11, int i12, boolean z10) {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i10, int i11, List<Header> list) throws IOException {
            this.logger.logPushPromise(OkHttpFrameLogger.Direction.INBOUND, i10, i11, list);
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientTransport.this.frameWriter.rstStream(i10, ErrorCode.PROTOCOL_ERROR);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i10, ErrorCode errorCode) {
            this.logger.logRstStream(OkHttpFrameLogger.Direction.INBOUND, i10, errorCode);
            Status augmentDescription = OkHttpClientTransport.toGrpcStatus(errorCode).augmentDescription("Rst Stream");
            boolean z10 = augmentDescription.getCode() == Status.Code.CANCELLED || augmentDescription.getCode() == Status.Code.DEADLINE_EXCEEDED;
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i10));
                if (okHttpClientStream != null) {
                    PerfMark.event("OkHttpClientTransport$ClientFrameHandler.rstStream", okHttpClientStream.transportState().tag());
                    OkHttpClientTransport.this.finishStream(i10, augmentDescription, errorCode == ErrorCode.REFUSED_STREAM ? ClientStreamListener.RpcProgress.REFUSED : ClientStreamListener.RpcProgress.PROCESSED, z10, null, null);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Status status;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.frameReader.nextFrame(this)) {
                try {
                    if (OkHttpClientTransport.this.keepAliveManager != null) {
                        OkHttpClientTransport.this.keepAliveManager.onDataReceived();
                    }
                } catch (Throwable th) {
                    try {
                        OkHttpClientTransport.this.startGoAway(0, ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("error in frame handler").withCause(th));
                        try {
                            this.frameReader.close();
                        } catch (IOException e2) {
                            e = e2;
                            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                            OkHttpClientTransport.this.listener.transportTerminated();
                            Thread.currentThread().setName(name);
                        }
                    } catch (Throwable th2) {
                        try {
                            this.frameReader.close();
                        } catch (IOException e10) {
                            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e10);
                        }
                        OkHttpClientTransport.this.listener.transportTerminated();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            }
            synchronized (OkHttpClientTransport.this.lock) {
                status = OkHttpClientTransport.this.goAwayStatus;
            }
            if (status == null) {
                status = Status.UNAVAILABLE.withDescription("End of stream or IOException");
            }
            OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, status);
            try {
                this.frameReader.close();
            } catch (IOException e11) {
                e = e11;
                OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                OkHttpClientTransport.this.listener.transportTerminated();
                Thread.currentThread().setName(name);
            }
            OkHttpClientTransport.this.listener.transportTerminated();
            Thread.currentThread().setName(name);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z10, Settings settings) {
            boolean z11;
            this.logger.logSettings(OkHttpFrameLogger.Direction.INBOUND, settings);
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpSettingsUtil.isSet(settings, 4)) {
                    OkHttpClientTransport.this.maxConcurrentStreams = OkHttpSettingsUtil.get(settings, 4);
                }
                if (OkHttpSettingsUtil.isSet(settings, 7)) {
                    z11 = OkHttpClientTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                } else {
                    z11 = false;
                }
                if (this.firstSettings) {
                    OkHttpClientTransport.this.listener.transportReady();
                    this.firstSettings = false;
                }
                OkHttpClientTransport.this.frameWriter.ackSettings(settings);
                if (z11) {
                    OkHttpClientTransport.this.outboundFlow.writeStreams();
                }
                OkHttpClientTransport.this.startPendingStreams();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i10, long j10) {
            this.logger.logWindowsUpdate(OkHttpFrameLogger.Direction.INBOUND, i10, j10);
            if (j10 == 0) {
                if (i10 == 0) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                    return;
                } else {
                    OkHttpClientTransport.this.finishStream(i10, Status.INTERNAL.withDescription("Received 0 flow control window increment."), ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.PROTOCOL_ERROR, null);
                    return;
                }
            }
            boolean z10 = false;
            synchronized (OkHttpClientTransport.this.lock) {
                if (i10 == 0) {
                    OkHttpClientTransport.this.outboundFlow.windowUpdate(null, (int) j10);
                    return;
                }
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i10));
                if (okHttpClientStream != null) {
                    OkHttpClientTransport.this.outboundFlow.windowUpdate(okHttpClientStream.transportState().getOutboundFlowState(), (int) j10);
                } else if (!OkHttpClientTransport.this.mayHaveCreatedStream(i10)) {
                    z10 = true;
                }
                if (z10) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i10);
                }
            }
        }
    }

    public OkHttpClientTransport(OkHttpChannelBuilder.OkHttpTransportFactory okHttpTransportFactory, InetSocketAddress inetSocketAddress, String str, String str2, Attributes attributes, HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress, Runnable runnable) {
        this(okHttpTransportFactory, inetSocketAddress, str, str2, attributes, GrpcUtil.STOPWATCH_SUPPLIER, new Http2(), httpConnectProxiedSocketAddress, runnable);
    }

    public static /* synthetic */ int access$2412(OkHttpClientTransport okHttpClientTransport, int i10) {
        int i11 = okHttpClientTransport.connectionUnacknowledgedBytesRead + i10;
        okHttpClientTransport.connectionUnacknowledgedBytesRead = i11;
        return i11;
    }

    private static Map<ErrorCode, Status> buildErrorCodeToStatusMap() {
        EnumMap enumMap = new EnumMap(ErrorCode.class);
        ErrorCode errorCode = ErrorCode.NO_ERROR;
        Status status = Status.INTERNAL;
        enumMap.put((EnumMap) errorCode, (ErrorCode) status.withDescription("No error: A GRPC status of OK should have been sent"));
        enumMap.put((EnumMap) ErrorCode.PROTOCOL_ERROR, (ErrorCode) status.withDescription("Protocol error"));
        enumMap.put((EnumMap) ErrorCode.INTERNAL_ERROR, (ErrorCode) status.withDescription("Internal error"));
        enumMap.put((EnumMap) ErrorCode.FLOW_CONTROL_ERROR, (ErrorCode) status.withDescription("Flow control error"));
        enumMap.put((EnumMap) ErrorCode.STREAM_CLOSED, (ErrorCode) status.withDescription("Stream closed"));
        enumMap.put((EnumMap) ErrorCode.FRAME_TOO_LARGE, (ErrorCode) status.withDescription("Frame too large"));
        enumMap.put((EnumMap) ErrorCode.REFUSED_STREAM, (ErrorCode) Status.UNAVAILABLE.withDescription("Refused stream"));
        enumMap.put((EnumMap) ErrorCode.CANCEL, (ErrorCode) Status.CANCELLED.withDescription("Cancelled"));
        enumMap.put((EnumMap) ErrorCode.COMPRESSION_ERROR, (ErrorCode) status.withDescription("Compression error"));
        enumMap.put((EnumMap) ErrorCode.CONNECT_ERROR, (ErrorCode) status.withDescription("Connect error"));
        enumMap.put((EnumMap) ErrorCode.ENHANCE_YOUR_CALM, (ErrorCode) Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
        enumMap.put((EnumMap) ErrorCode.INADEQUATE_SECURITY, (ErrorCode) Status.PERMISSION_DENIED.withDescription("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    private Request createHttpProxyRequest(InetSocketAddress inetSocketAddress, String str, String str2) {
        HttpUrl build = new HttpUrl.Builder().scheme("https").host(inetSocketAddress.getHostName()).port(inetSocketAddress.getPort()).build();
        Request.Builder header = new Request.Builder().url(build).header(cs.U, build.host() + u.bD + build.port()).header("User-Agent", this.userAgent);
        if (str != null && str2 != null) {
            header.header("Proxy-Authorization", Credentials.basic(str, str2));
        }
        return header.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Socket createHttpProxySocket(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws StatusException {
        Socket createSocket;
        Socket socket = null;
        try {
            if (inetSocketAddress2.getAddress() != null) {
                createSocket = this.socketFactory.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort());
            } else {
                createSocket = this.socketFactory.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            }
            socket = createSocket;
            socket.setTcpNoDelay(true);
            socket.setSoTimeout(this.proxySocketTimeout);
            Source source = Okio.source(socket);
            BufferedSink buffer = Okio.buffer(Okio.sink(socket));
            Request createHttpProxyRequest = createHttpProxyRequest(inetSocketAddress, str, str2);
            HttpUrl httpUrl = createHttpProxyRequest.httpUrl();
            buffer.writeUtf8(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", httpUrl.host(), Integer.valueOf(httpUrl.port()))).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            int size = createHttpProxyRequest.headers().size();
            for (int i10 = 0; i10 < size; i10++) {
                buffer.writeUtf8(createHttpProxyRequest.headers().name(i10)).writeUtf8(": ").writeUtf8(createHttpProxyRequest.headers().value(i10)).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            buffer.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            buffer.flush();
            StatusLine parse = StatusLine.parse(readUtf8LineStrictUnbuffered(source));
            do {
            } while (!readUtf8LineStrictUnbuffered(source).equals(""));
            int i11 = parse.code;
            if (i11 >= 200 && i11 < 300) {
                socket.setSoTimeout(0);
                return socket;
            }
            Buffer buffer2 = new Buffer();
            try {
                socket.shutdownOutput();
                source.read(buffer2, 1024L);
            } catch (IOException e2) {
                buffer2.writeUtf8("Unable to read body: " + e2.toString());
            }
            try {
                socket.close();
            } catch (IOException unused) {
            }
            throw Status.UNAVAILABLE.withDescription(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(parse.code), parse.message, buffer2.readUtf8())).asException();
        } catch (IOException e10) {
            if (socket != null) {
                GrpcUtil.closeQuietly(socket);
            }
            throw Status.UNAVAILABLE.withDescription("Failed trying to connect with proxy").withCause(e10).asException();
        }
    }

    private Throwable getPingFailure() {
        synchronized (this.lock) {
            Status status = this.goAwayStatus;
            if (status != null) {
                return status.asException();
            }
            return Status.UNAVAILABLE.withDescription("Connection closed").asException();
        }
    }

    private void initTransportTracer() {
        synchronized (this.lock) {
            this.transportTracer.setFlowControlWindowReader(new TransportTracer.FlowControlReader() { // from class: io.grpc.okhttp.OkHttpClientTransport.2
                @Override // io.grpc.internal.TransportTracer.FlowControlReader
                public TransportTracer.FlowControlWindows read() {
                    TransportTracer.FlowControlWindows flowControlWindows;
                    synchronized (OkHttpClientTransport.this.lock) {
                        flowControlWindows = new TransportTracer.FlowControlWindows(OkHttpClientTransport.this.outboundFlow == null ? -1L : OkHttpClientTransport.this.outboundFlow.windowUpdate(null, 0), OkHttpClientTransport.this.initialWindowSize * 0.5f);
                    }
                    return flowControlWindows;
                }
            });
        }
    }

    private void maybeClearInUse(OkHttpClientStream okHttpClientStream) {
        if (this.hasStream && this.pendingStreams.isEmpty() && this.streams.isEmpty()) {
            this.hasStream = false;
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportIdle();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ErrorCode errorCode, String str) {
        startGoAway(0, errorCode, toGrpcStatus(errorCode).augmentDescription(str));
    }

    private static String readUtf8LineStrictUnbuffered(Source source) throws IOException {
        Buffer buffer = new Buffer();
        while (source.read(buffer, 1L) != -1) {
            if (buffer.getByte(buffer.size() - 1) == 10) {
                return buffer.readUtf8LineStrict();
            }
        }
        throw new EOFException("\\n not found: " + buffer.readByteString().hex());
    }

    private void sendConnectionPrefaceAndSettings() {
        synchronized (this.lock) {
            this.frameWriter.connectionPreface();
            Settings settings = new Settings();
            OkHttpSettingsUtil.set(settings, 7, this.initialWindowSize);
            this.frameWriter.settings(settings);
            if (this.initialWindowSize > 65535) {
                this.frameWriter.windowUpdate(0, r1 - 65535);
            }
        }
    }

    private void setInUse(OkHttpClientStream okHttpClientStream) {
        if (!this.hasStream) {
            this.hasStream = true;
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportActive();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGoAway(int i10, ErrorCode errorCode, Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus == null) {
                this.goAwayStatus = status;
                this.listener.transportShutdown(status);
            }
            if (errorCode != null && !this.goAwaySent) {
                this.goAwaySent = true;
                this.frameWriter.goAway(0, errorCode, new byte[0]);
            }
            Iterator<Map.Entry<Integer, OkHttpClientStream>> iterator2 = this.streams.entrySet().iterator2();
            while (iterator2.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> next = iterator2.next();
                if (next.getKey().intValue() > i10) {
                    iterator2.remove();
                    next.getValue().transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, false, new Metadata());
                    maybeClearInUse(next.getValue());
                }
            }
            for (OkHttpClientStream okHttpClientStream : this.pendingStreams) {
                okHttpClientStream.transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                maybeClearInUse(okHttpClientStream);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startPendingStreams() {
        boolean z10 = false;
        while (!this.pendingStreams.isEmpty() && this.streams.size() < this.maxConcurrentStreams) {
            startStream(this.pendingStreams.poll());
            z10 = true;
        }
        return z10;
    }

    private void startStream(OkHttpClientStream okHttpClientStream) {
        o.y(okHttpClientStream.transportState().id() == -1, "StreamId already assigned");
        this.streams.put(Integer.valueOf(this.nextStreamId), okHttpClientStream);
        setInUse(okHttpClientStream);
        okHttpClientStream.transportState().start(this.nextStreamId);
        if ((okHttpClientStream.getType() != MethodDescriptor.MethodType.UNARY && okHttpClientStream.getType() != MethodDescriptor.MethodType.SERVER_STREAMING) || okHttpClientStream.useGet()) {
            this.frameWriter.flush();
        }
        int i10 = this.nextStreamId;
        if (i10 >= 2147483645) {
            this.nextStreamId = Integer.MAX_VALUE;
            startGoAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
        } else {
            this.nextStreamId = i10 + 2;
        }
    }

    private void stopIfNecessary() {
        if (this.goAwayStatus == null || !this.streams.isEmpty() || !this.pendingStreams.isEmpty() || this.stopped) {
            return;
        }
        this.stopped = true;
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onTransportTermination();
        }
        Http2Ping http2Ping = this.ping;
        if (http2Ping != null) {
            http2Ping.failed(getPingFailure());
            this.ping = null;
        }
        if (!this.goAwaySent) {
            this.goAwaySent = true;
            this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
        }
        this.frameWriter.close();
    }

    public static Status toGrpcStatus(ErrorCode errorCode) {
        Status status = ERROR_CODE_TO_STATUS.get(errorCode);
        if (status != null) {
            return status;
        }
        return Status.UNKNOWN.withDescription("Unknown http2 error code: " + errorCode.httpCode);
    }

    public void enableKeepAlive(boolean z10, long j10, long j11, boolean z11) {
        this.enableKeepAlive = z10;
        this.keepAliveTimeNanos = j10;
        this.keepAliveTimeoutNanos = j11;
        this.keepAliveWithoutCalls = z11;
    }

    public void finishStream(int i10, Status status, ClientStreamListener.RpcProgress rpcProgress, boolean z10, ErrorCode errorCode, Metadata metadata) {
        synchronized (this.lock) {
            OkHttpClientStream remove = this.streams.remove(Integer.valueOf(i10));
            if (remove != null) {
                if (errorCode != null) {
                    this.frameWriter.rstStream(i10, ErrorCode.CANCEL);
                }
                if (status != null) {
                    OkHttpClientStream.TransportState transportState = remove.transportState();
                    if (metadata == null) {
                        metadata = new Metadata();
                    }
                    transportState.transportReportStatus(status, rpcProgress, z10, metadata);
                }
                if (!startPendingStreams()) {
                    stopIfNecessary();
                    maybeClearInUse(remove);
                }
            }
        }
    }

    @Override // io.grpc.okhttp.OutboundFlowController.Transport
    public OutboundFlowController.StreamState[] getActiveStreams() {
        OutboundFlowController.StreamState[] streamStateArr;
        synchronized (this.lock) {
            streamStateArr = new OutboundFlowController.StreamState[this.streams.size()];
            int i10 = 0;
            Iterator<OkHttpClientStream> iterator2 = this.streams.values().iterator2();
            while (iterator2.hasNext()) {
                streamStateArr[i10] = iterator2.next().transportState().getOutboundFlowState();
                i10++;
            }
        }
        return streamStateArr;
    }

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttributes() {
        return this.attributes;
    }

    public ClientFrameHandler getHandler() {
        return this.clientFrameHandler;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    public String getOverridenHost() {
        URI authorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        if (authorityToUri.getHost() != null) {
            return authorityToUri.getHost();
        }
        return this.defaultAuthority;
    }

    public int getOverridenPort() {
        URI authorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        if (authorityToUri.getPort() != -1) {
            return authorityToUri.getPort();
        }
        return this.address.getPort();
    }

    public int getPendingStreamSize() {
        int size;
        synchronized (this.lock) {
            size = this.pendingStreams.size();
        }
        return size;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    @Override // io.grpc.InternalInstrumented
    public n<InternalChannelz.SocketStats> getStats() {
        t a10 = t.a();
        synchronized (this.lock) {
            if (this.socket == null) {
                a10.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), null, null, new InternalChannelz.SocketOptions.Builder().build(), null));
            } else {
                a10.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), this.socket.getLocalSocketAddress(), this.socket.getRemoteSocketAddress(), Utils.getSocketOptions(this.socket), this.securityInfo));
            }
        }
        return a10;
    }

    public OkHttpClientStream getStream(int i10) {
        OkHttpClientStream okHttpClientStream;
        synchronized (this.lock) {
            okHttpClientStream = this.streams.get(Integer.valueOf(i10));
        }
        return okHttpClientStream;
    }

    public boolean isUsingPlaintext() {
        return this.sslSocketFactory == null;
    }

    public boolean mayHaveCreatedStream(int i10) {
        boolean z10;
        synchronized (this.lock) {
            z10 = true;
            if (i10 >= this.nextStreamId || (i10 & 1) != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // io.grpc.internal.ClientTransport
    public /* bridge */ /* synthetic */ ClientStream newStream(MethodDescriptor methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        return newStream((MethodDescriptor<?, ?>) methodDescriptor, metadata, callOptions, clientStreamTracerArr);
    }

    @Override // io.grpc.okhttp.ExceptionHandlingFrameWriter.TransportExceptionHandler
    public void onException(Throwable th) {
        o.s(th, "failureCause");
        startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withCause(th));
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        long nextLong;
        synchronized (this.lock) {
            boolean z10 = true;
            o.x(this.frameWriter != null);
            if (this.stopped) {
                Http2Ping.notifyFailed(pingCallback, executor, getPingFailure());
                return;
            }
            Http2Ping http2Ping = this.ping;
            if (http2Ping != null) {
                nextLong = 0;
                z10 = false;
            } else {
                nextLong = this.random.nextLong();
                r rVar = this.stopwatchFactory.get();
                rVar.h();
                Http2Ping http2Ping2 = new Http2Ping(nextLong, rVar);
                this.ping = http2Ping2;
                this.transportTracer.reportKeepAliveSent();
                http2Ping = http2Ping2;
            }
            if (z10) {
                this.frameWriter.ping(false, (int) (nextLong >>> 32), (int) nextLong);
            }
            http2Ping.addCallback(pingCallback, executor);
        }
    }

    public void removePendingStream(OkHttpClientStream okHttpClientStream) {
        this.pendingStreams.remove(okHttpClientStream);
        maybeClearInUse(okHttpClientStream);
    }

    public void setNextStreamId(int i10) {
        synchronized (this.lock) {
            this.nextStreamId = i10;
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdown(Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                return;
            }
            this.goAwayStatus = status;
            this.listener.transportShutdown(status);
            stopIfNecessary();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        shutdown(status);
        synchronized (this.lock) {
            Iterator<Map.Entry<Integer, OkHttpClientStream>> iterator2 = this.streams.entrySet().iterator2();
            while (iterator2.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> next = iterator2.next();
                iterator2.remove();
                next.getValue().transportState().transportReportStatus(status, false, new Metadata());
                maybeClearInUse(next.getValue());
            }
            for (OkHttpClientStream okHttpClientStream : this.pendingStreams) {
                okHttpClientStream.transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                maybeClearInUse(okHttpClientStream);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public Runnable start(ManagedClientTransport.Listener listener) {
        this.listener = (ManagedClientTransport.Listener) o.s(listener, bg.e.f32299p);
        if (this.enableKeepAlive) {
            KeepAliveManager keepAliveManager = new KeepAliveManager(new KeepAliveManager.ClientKeepAlivePinger(this), this.scheduler, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
            this.keepAliveManager = keepAliveManager;
            keepAliveManager.onTransportStarted();
        }
        final AsyncSink sink = AsyncSink.sink(this.serializingExecutor, this, 10000);
        FrameWriter limitControlFramesWriter = sink.limitControlFramesWriter(this.variant.newWriter(Okio.buffer(sink), true));
        synchronized (this.lock) {
            ExceptionHandlingFrameWriter exceptionHandlingFrameWriter = new ExceptionHandlingFrameWriter(this, limitControlFramesWriter);
            this.frameWriter = exceptionHandlingFrameWriter;
            this.outboundFlow = new OutboundFlowController(this, exceptionHandlingFrameWriter);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.3
            @Override // java.lang.Runnable
            public void run() {
                OkHttpClientTransport okHttpClientTransport;
                ClientFrameHandler clientFrameHandler;
                Socket createHttpProxySocket;
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                BufferedSource buffer = Okio.buffer(new Source() { // from class: io.grpc.okhttp.OkHttpClientTransport.3.1
                    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                    }

                    @Override // okio.Source
                    public long read(Buffer buffer2, long j10) {
                        return -1L;
                    }

                    @Override // okio.Source
                    public Timeout timeout() {
                        return Timeout.NONE;
                    }
                });
                SSLSession sSLSession = null;
                try {
                    try {
                        OkHttpClientTransport okHttpClientTransport2 = OkHttpClientTransport.this;
                        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress = okHttpClientTransport2.proxiedAddr;
                        if (httpConnectProxiedSocketAddress == null) {
                            createHttpProxySocket = okHttpClientTransport2.socketFactory.createSocket(OkHttpClientTransport.this.address.getAddress(), OkHttpClientTransport.this.address.getPort());
                        } else if (httpConnectProxiedSocketAddress.getProxyAddress() instanceof InetSocketAddress) {
                            OkHttpClientTransport okHttpClientTransport3 = OkHttpClientTransport.this;
                            createHttpProxySocket = okHttpClientTransport3.createHttpProxySocket(okHttpClientTransport3.proxiedAddr.getTargetAddress(), (InetSocketAddress) OkHttpClientTransport.this.proxiedAddr.getProxyAddress(), OkHttpClientTransport.this.proxiedAddr.getUsername(), OkHttpClientTransport.this.proxiedAddr.getPassword());
                        } else {
                            throw Status.INTERNAL.withDescription("Unsupported SocketAddress implementation " + ((Object) OkHttpClientTransport.this.proxiedAddr.getProxyAddress().getClass())).asException();
                        }
                        Socket socket = createHttpProxySocket;
                        Socket socket2 = socket;
                        if (OkHttpClientTransport.this.sslSocketFactory != null) {
                            SSLSocket upgrade = OkHttpTlsUpgrader.upgrade(OkHttpClientTransport.this.sslSocketFactory, OkHttpClientTransport.this.hostnameVerifier, socket, OkHttpClientTransport.this.getOverridenHost(), OkHttpClientTransport.this.getOverridenPort(), OkHttpClientTransport.this.connectionSpec);
                            sSLSession = upgrade.getSession();
                            socket2 = upgrade;
                        }
                        socket2.setTcpNoDelay(true);
                        BufferedSource buffer2 = Okio.buffer(Okio.source(socket2));
                        sink.becomeConnected(Okio.sink(socket2), socket2);
                        OkHttpClientTransport okHttpClientTransport4 = OkHttpClientTransport.this;
                        okHttpClientTransport4.attributes = okHttpClientTransport4.attributes.toBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, socket2.getRemoteSocketAddress()).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, socket2.getLocalSocketAddress()).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, sSLSession).set(GrpcAttributes.ATTR_SECURITY_LEVEL, sSLSession == null ? SecurityLevel.NONE : SecurityLevel.PRIVACY_AND_INTEGRITY).build();
                        OkHttpClientTransport okHttpClientTransport5 = OkHttpClientTransport.this;
                        okHttpClientTransport5.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport5.variant.newReader(buffer2, true));
                        synchronized (OkHttpClientTransport.this.lock) {
                            OkHttpClientTransport.this.socket = (Socket) o.s(socket2, "socket");
                            if (sSLSession != null) {
                                OkHttpClientTransport.this.securityInfo = new InternalChannelz.Security(new InternalChannelz.Tls(sSLSession));
                            }
                        }
                    } catch (StatusException e2) {
                        OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, e2.getStatus());
                        okHttpClientTransport = OkHttpClientTransport.this;
                        clientFrameHandler = new ClientFrameHandler(okHttpClientTransport.variant.newReader(buffer, true));
                        okHttpClientTransport.clientFrameHandler = clientFrameHandler;
                    } catch (Exception e10) {
                        OkHttpClientTransport.this.onException(e10);
                        okHttpClientTransport = OkHttpClientTransport.this;
                        clientFrameHandler = new ClientFrameHandler(okHttpClientTransport.variant.newReader(buffer, true));
                        okHttpClientTransport.clientFrameHandler = clientFrameHandler;
                    }
                } catch (Throwable th) {
                    OkHttpClientTransport okHttpClientTransport6 = OkHttpClientTransport.this;
                    okHttpClientTransport6.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport6.variant.newReader(buffer, true));
                    throw th;
                }
            }
        });
        try {
            sendConnectionPrefaceAndSettings();
            countDownLatch.countDown();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.4
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable = OkHttpClientTransport.this.connectingCallback;
                    if (runnable != null) {
                        runnable.run();
                    }
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                        OkHttpClientTransport.this.startPendingStreams();
                    }
                    t<Void> tVar = OkHttpClientTransport.this.connectedFuture;
                    if (tVar != null) {
                        tVar.set(null);
                    }
                }
            });
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    public void streamReadyToStart(OkHttpClientStream okHttpClientStream) {
        if (this.goAwayStatus != null) {
            okHttpClientStream.transportState().transportReportStatus(this.goAwayStatus, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
        } else if (this.streams.size() >= this.maxConcurrentStreams) {
            this.pendingStreams.add(okHttpClientStream);
            setInUse(okHttpClientStream);
        } else {
            startStream(okHttpClientStream);
        }
    }

    public String toString() {
        return com.google.common.base.j.c(this).c("logId", this.logId.getId()).d(TextClassifier.TYPE_ADDRESS, this.address).toString();
    }

    private OkHttpClientTransport(OkHttpChannelBuilder.OkHttpTransportFactory okHttpTransportFactory, InetSocketAddress inetSocketAddress, String str, String str2, Attributes attributes, com.google.common.base.t<r> tVar, Variant variant, HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress, Runnable runnable) {
        this.random = new Random();
        this.lock = new Object();
        this.streams = new HashMap();
        this.maxConcurrentStreams = 0;
        this.pendingStreams = new LinkedList();
        this.inUseState = new InUseStateAggregator<OkHttpClientStream>() { // from class: io.grpc.okhttp.OkHttpClientTransport.1
            @Override // io.grpc.internal.InUseStateAggregator
            public void handleInUse() {
                OkHttpClientTransport.this.listener.transportInUse(true);
            }

            @Override // io.grpc.internal.InUseStateAggregator
            public void handleNotInUse() {
                OkHttpClientTransport.this.listener.transportInUse(false);
            }
        };
        this.proxySocketTimeout = 30000;
        this.address = (InetSocketAddress) o.s(inetSocketAddress, TextClassifier.TYPE_ADDRESS);
        this.defaultAuthority = str;
        this.maxMessageSize = okHttpTransportFactory.maxMessageSize;
        this.initialWindowSize = okHttpTransportFactory.flowControlWindow;
        this.executor = (Executor) o.s(okHttpTransportFactory.executor, "executor");
        this.serializingExecutor = new SerializingExecutor(okHttpTransportFactory.executor);
        this.scheduler = (ScheduledExecutorService) o.s(okHttpTransportFactory.scheduledExecutorService, "scheduledExecutorService");
        this.nextStreamId = 3;
        SocketFactory socketFactory = okHttpTransportFactory.socketFactory;
        this.socketFactory = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.sslSocketFactory = okHttpTransportFactory.sslSocketFactory;
        this.hostnameVerifier = okHttpTransportFactory.hostnameVerifier;
        this.connectionSpec = (ConnectionSpec) o.s(okHttpTransportFactory.connectionSpec, "connectionSpec");
        this.stopwatchFactory = (com.google.common.base.t) o.s(tVar, "stopwatchFactory");
        this.variant = (Variant) o.s(variant, "variant");
        this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", str2);
        this.proxiedAddr = httpConnectProxiedSocketAddress;
        this.tooManyPingsRunnable = (Runnable) o.s(runnable, "tooManyPingsRunnable");
        this.maxInboundMetadataSize = okHttpTransportFactory.maxInboundMetadataSize;
        this.transportTracer = okHttpTransportFactory.transportTracerFactory.create();
        this.logId = InternalLogId.allocate(getClass(), inetSocketAddress.toString());
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes).build();
        this.useGetForSafeMethods = okHttpTransportFactory.useGetForSafeMethods;
        initTransportTracer();
    }

    @Override // io.grpc.internal.ClientTransport
    public OkHttpClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        o.s(methodDescriptor, "method");
        o.s(metadata, TTDownloadField.TT_HEADERS);
        StatsTraceContext newClientContext = StatsTraceContext.newClientContext(clientStreamTracerArr, getAttributes(), metadata);
        synchronized (this.lock) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                return new OkHttpClientStream(methodDescriptor, metadata, this.frameWriter, this, this.outboundFlow, this.lock, this.maxMessageSize, this.initialWindowSize, this.defaultAuthority, this.userAgent, newClientContext, this.transportTracer, callOptions, this.useGetForSafeMethods);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public OkHttpClientTransport(OkHttpChannelBuilder.OkHttpTransportFactory okHttpTransportFactory, String str, com.google.common.base.t<r> tVar, Variant variant, Runnable runnable, t<Void> tVar2, Runnable runnable2) {
        this(okHttpTransportFactory, new InetSocketAddress(HttpProxyCacheServer.PROXY_HOST, 80), "notarealauthority:80", str, Attributes.EMPTY, tVar, variant, null, runnable2);
        this.connectingCallback = runnable;
        this.connectedFuture = (t) o.s(tVar2, "connectedFuture");
    }
}
