package io.grpc.internal;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.packet.e;
import com.google.common.base.l;
import com.google.common.base.o;
import com.google.common.base.q;
import com.google.common.base.r;
import com.google.common.base.t;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.u;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalMetadata;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.StreamListener;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class GrpcUtil {
    public static final q ACCEPT_ENCODING_SPLITTER;
    public static final CallOptions.Key<Boolean> CALL_OPTIONS_RPC_OWNED_BY_BALANCER;
    public static final String CONTENT_ACCEPT_ENCODING = "accept-encoding";
    public static final Metadata.Key<byte[]> CONTENT_ACCEPT_ENCODING_KEY;
    public static final String CONTENT_ENCODING = "content-encoding";
    public static final Metadata.Key<String> CONTENT_ENCODING_KEY;
    public static final Metadata.Key<String> CONTENT_LENGTH_KEY;
    public static final String CONTENT_TYPE_GRPC = "application/grpc";
    public static final Metadata.Key<String> CONTENT_TYPE_KEY;
    public static final long DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
    public static final String DEFAULT_LB_POLICY = "pick_first";
    public static final int DEFAULT_MAX_HEADER_LIST_SIZE = 8192;
    public static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;
    public static final int DEFAULT_PORT_PLAINTEXT = 80;
    public static final int DEFAULT_PORT_SSL = 443;
    public static final ProxyDetector DEFAULT_PROXY_DETECTOR;
    public static final long DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS;
    public static final long DEFAULT_SERVER_KEEPALIVE_TIME_NANOS;
    public static final String HTTP_METHOD = "POST";
    private static final String IMPLEMENTATION_VERSION = "1.54.1";
    public static final long KEEPALIVE_TIME_NANOS_DISABLED = Long.MAX_VALUE;
    public static final String MESSAGE_ACCEPT_ENCODING = "grpc-accept-encoding";
    public static final Metadata.Key<byte[]> MESSAGE_ACCEPT_ENCODING_KEY;
    public static final String MESSAGE_ENCODING = "grpc-encoding";
    public static final Metadata.Key<String> MESSAGE_ENCODING_KEY;
    public static final ProxyDetector NOOP_PROXY_DETECTOR;
    private static final ClientStreamTracer NOOP_TRACER;
    public static final long SERVER_KEEPALIVE_TIME_NANOS_DISABLED = Long.MAX_VALUE;
    public static final SharedResourceHolder.Resource<Executor> SHARED_CHANNEL_EXECUTOR;
    public static final t<r> STOPWATCH_SUPPLIER;
    public static final Metadata.Key<String> TE_HEADER;
    public static final String TE_TRAILERS = "trailers";
    public static final SharedResourceHolder.Resource<ScheduledExecutorService> TIMER_SERVICE;
    public static final Metadata.Key<String> USER_AGENT_KEY;
    private static final Logger log = Logger.getLogger(GrpcUtil.class.getName());
    private static final Set<Status.Code> INAPPROPRIATE_CONTROL_PLANE_STATUS = Collections.unmodifiableSet(EnumSet.of(Status.Code.OK, Status.Code.INVALID_ARGUMENT, Status.Code.NOT_FOUND, Status.Code.ALREADY_EXISTS, Status.Code.FAILED_PRECONDITION, Status.Code.ABORTED, Status.Code.OUT_OF_RANGE, Status.Code.DATA_LOSS));
    public static final Charset US_ASCII = Charset.forName(CharEncoding.US_ASCII);
    public static final String TIMEOUT = "grpc-timeout";
    public static final Metadata.Key<Long> TIMEOUT_KEY = Metadata.Key.of(TIMEOUT, new TimeoutMarshaller());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AcceptEncodingMarshaller implements InternalMetadata.TrustedAsciiMarshaller<byte[]> {
        private AcceptEncodingMarshaller() {
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] parseAsciiString(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(byte[] bArr) {
            return bArr;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class GrpcBuildVersion {
        private final String implementationVersion;
        private final String userAgent;

        public String getImplementationVersion() {
            return this.implementationVersion;
        }

        public String getUserAgent() {
            return this.userAgent;
        }

        public String toString() {
            return this.userAgent + " " + this.implementationVersion;
        }

        private GrpcBuildVersion(String str, String str2) {
            this.userAgent = (String) o.s(str, "userAgentName");
            this.implementationVersion = (String) o.s(str2, "implementationVersion");
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NO_ERROR' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Http2Error {
        private static final /* synthetic */ Http2Error[] $VALUES;
        public static final Http2Error CANCEL;
        public static final Http2Error COMPRESSION_ERROR;
        public static final Http2Error CONNECT_ERROR;
        public static final Http2Error ENHANCE_YOUR_CALM;
        public static final Http2Error FLOW_CONTROL_ERROR;
        public static final Http2Error FRAME_SIZE_ERROR;
        public static final Http2Error HTTP_1_1_REQUIRED;
        public static final Http2Error INADEQUATE_SECURITY;
        public static final Http2Error INTERNAL_ERROR;
        public static final Http2Error NO_ERROR;
        public static final Http2Error PROTOCOL_ERROR;
        public static final Http2Error REFUSED_STREAM;
        public static final Http2Error SETTINGS_TIMEOUT;
        public static final Http2Error STREAM_CLOSED;
        private static final Http2Error[] codeMap;
        private final int code;
        private final Status status;

        static {
            Status status = Status.UNAVAILABLE;
            Http2Error http2Error = new Http2Error("NO_ERROR", 0, 0, status);
            NO_ERROR = http2Error;
            Status status2 = Status.INTERNAL;
            Http2Error http2Error2 = new Http2Error("PROTOCOL_ERROR", 1, 1, status2);
            PROTOCOL_ERROR = http2Error2;
            Http2Error http2Error3 = new Http2Error("INTERNAL_ERROR", 2, 2, status2);
            INTERNAL_ERROR = http2Error3;
            Http2Error http2Error4 = new Http2Error("FLOW_CONTROL_ERROR", 3, 3, status2);
            FLOW_CONTROL_ERROR = http2Error4;
            Http2Error http2Error5 = new Http2Error("SETTINGS_TIMEOUT", 4, 4, status2);
            SETTINGS_TIMEOUT = http2Error5;
            Http2Error http2Error6 = new Http2Error("STREAM_CLOSED", 5, 5, status2);
            STREAM_CLOSED = http2Error6;
            Http2Error http2Error7 = new Http2Error("FRAME_SIZE_ERROR", 6, 6, status2);
            FRAME_SIZE_ERROR = http2Error7;
            Http2Error http2Error8 = new Http2Error("REFUSED_STREAM", 7, 7, status);
            REFUSED_STREAM = http2Error8;
            Http2Error http2Error9 = new Http2Error("CANCEL", 8, 8, Status.CANCELLED);
            CANCEL = http2Error9;
            Http2Error http2Error10 = new Http2Error("COMPRESSION_ERROR", 9, 9, status2);
            COMPRESSION_ERROR = http2Error10;
            Http2Error http2Error11 = new Http2Error("CONNECT_ERROR", 10, 10, status2);
            CONNECT_ERROR = http2Error11;
            Http2Error http2Error12 = new Http2Error("ENHANCE_YOUR_CALM", 11, 11, Status.RESOURCE_EXHAUSTED.withDescription("Bandwidth exhausted"));
            ENHANCE_YOUR_CALM = http2Error12;
            Http2Error http2Error13 = new Http2Error("INADEQUATE_SECURITY", 12, 12, Status.PERMISSION_DENIED.withDescription("Permission denied as protocol is not secure enough to call"));
            INADEQUATE_SECURITY = http2Error13;
            Http2Error http2Error14 = new Http2Error("HTTP_1_1_REQUIRED", 13, 13, Status.UNKNOWN);
            HTTP_1_1_REQUIRED = http2Error14;
            $VALUES = new Http2Error[]{http2Error, http2Error2, http2Error3, http2Error4, http2Error5, http2Error6, http2Error7, http2Error8, http2Error9, http2Error10, http2Error11, http2Error12, http2Error13, http2Error14};
            codeMap = buildHttp2CodeMap();
        }

        private Http2Error(String str, int i10, int i11, Status status) {
            this.code = i11;
            String str2 = "HTTP/2 error code: " + name();
            if (status.getDescription() != null) {
                str2 = str2 + " (" + status.getDescription() + ")";
            }
            this.status = status.withDescription(str2);
        }

        private static Http2Error[] buildHttp2CodeMap() {
            Http2Error[] values = values();
            Http2Error[] http2ErrorArr = new Http2Error[((int) values[values.length - 1].code()) + 1];
            for (Http2Error http2Error : values) {
                http2ErrorArr[(int) http2Error.code()] = http2Error;
            }
            return http2ErrorArr;
        }

        public static Http2Error forCode(long j10) {
            Http2Error[] http2ErrorArr = codeMap;
            if (j10 >= http2ErrorArr.length || j10 < 0) {
                return null;
            }
            return http2ErrorArr[(int) j10];
        }

        public static Status statusForCode(long j10) {
            Http2Error forCode = forCode(j10);
            if (forCode == null) {
                return Status.fromCodeValue(INTERNAL_ERROR.status().getCode().value()).withDescription("Unrecognized HTTP/2 error code: " + j10);
            }
            return forCode.status();
        }

        public static Http2Error valueOf(String str) {
            return (Http2Error) Enum.valueOf(Http2Error.class, str);
        }

        public static Http2Error[] values() {
            return (Http2Error[]) $VALUES.clone();
        }

        public long code() {
            return this.code;
        }

        public Status status() {
            return this.status;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TimeoutMarshaller implements Metadata.AsciiMarshaller<Long> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.AsciiMarshaller
        public Long parseAsciiString(String str) {
            o.e(str.length() > 0, "empty timeout");
            o.e(str.length() <= 9, "bad timeout format");
            long parseLong = Long.parseLong(str.substring(0, str.length() - 1));
            char charAt = str.charAt(str.length() - 1);
            if (charAt == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(parseLong));
            }
            if (charAt == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(parseLong));
            }
            if (charAt == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(parseLong));
            }
            if (charAt == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(parseLong));
            }
            if (charAt == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(parseLong));
            }
            if (charAt == 'n') {
                return Long.valueOf(parseLong);
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(charAt)));
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(Long l10) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l10.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l10.longValue() < 100000000) {
                return ((Object) l10) + "n";
            }
            if (l10.longValue() < 100000000000L) {
                return timeUnit.toMicros(l10.longValue()) + com.kuaishou.weapon.p0.t.f36224i;
            }
            if (l10.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l10.longValue()) + "m";
            }
            if (l10.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l10.longValue()) + ExifInterface.LATITUDE_SOUTH;
            }
            if (l10.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l10.longValue()) + "M";
            }
            return timeUnit.toHours(l10.longValue()) + "H";
        }
    }

    static {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        MESSAGE_ENCODING_KEY = Metadata.Key.of(MESSAGE_ENCODING, asciiMarshaller);
        MESSAGE_ACCEPT_ENCODING_KEY = InternalMetadata.keyOf(MESSAGE_ACCEPT_ENCODING, new AcceptEncodingMarshaller());
        CONTENT_ENCODING_KEY = Metadata.Key.of(CONTENT_ENCODING, asciiMarshaller);
        CONTENT_ACCEPT_ENCODING_KEY = InternalMetadata.keyOf(CONTENT_ACCEPT_ENCODING, new AcceptEncodingMarshaller());
        CONTENT_LENGTH_KEY = Metadata.Key.of("content-length", asciiMarshaller);
        CONTENT_TYPE_KEY = Metadata.Key.of(e.f4632d, asciiMarshaller);
        TE_HEADER = Metadata.Key.of("te", asciiMarshaller);
        USER_AGENT_KEY = Metadata.Key.of("user-agent", asciiMarshaller);
        ACCEPT_ENCODING_SPLITTER = q.e(',').j();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        DEFAULT_KEEPALIVE_TIMEOUT_NANOS = timeUnit.toNanos(20L);
        DEFAULT_SERVER_KEEPALIVE_TIME_NANOS = TimeUnit.HOURS.toNanos(2L);
        DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS = timeUnit.toNanos(20L);
        DEFAULT_PROXY_DETECTOR = new ProxyDetectorImpl();
        NOOP_PROXY_DETECTOR = new ProxyDetector() { // from class: io.grpc.internal.GrpcUtil.1
            @Override // io.grpc.ProxyDetector
            public ProxiedSocketAddress proxyFor(SocketAddress socketAddress) {
                return null;
            }
        };
        CALL_OPTIONS_RPC_OWNED_BY_BALANCER = CallOptions.Key.create("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        NOOP_TRACER = new ClientStreamTracer() { // from class: io.grpc.internal.GrpcUtil.2
        };
        SHARED_CHANNEL_EXECUTOR = new SharedResourceHolder.Resource<Executor>() { // from class: io.grpc.internal.GrpcUtil.3
            private static final String NAME = "grpc-default-executor";

            public String toString() {
                return NAME;
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public void close(Executor executor) {
                ((ExecutorService) executor).shutdown();
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public Executor create() {
                return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-default-executor-%d", true));
            }
        };
        TIMER_SERVICE = new SharedResourceHolder.Resource<ScheduledExecutorService>() { // from class: io.grpc.internal.GrpcUtil.4
            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public void close(ScheduledExecutorService scheduledExecutorService) {
                scheduledExecutorService.shutdown();
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public ScheduledExecutorService create() {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, GrpcUtil.getThreadFactory("grpc-timer-%d", true));
                try {
                    newScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(newScheduledThreadPool, Boolean.TRUE);
                } catch (NoSuchMethodException unused) {
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e10) {
                    throw new RuntimeException(e10);
                }
                return Executors.unconfigurableScheduledExecutorService(newScheduledThreadPool);
            }
        };
        STOPWATCH_SUPPLIER = new t<r>() { // from class: io.grpc.internal.GrpcUtil.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.common.base.t
            public r get() {
                return r.d();
            }
        };
    }

    private GrpcUtil() {
    }

    public static String authorityFromHostAndPort(String str, int i10) {
        try {
            return new URI(null, null, str, i10, null, null, null).getAuthority();
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Invalid host or port: " + str + " " + i10, e2);
        }
    }

    public static URI authorityToUri(String str) {
        o.s(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Invalid authority: " + str, e2);
        }
    }

    public static String checkAuthority(String str) {
        URI authorityToUri = authorityToUri(str);
        o.m(authorityToUri.getHost() != null, "No host in authority '%s'", str);
        o.m(authorityToUri.getUserInfo() == null, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static void closeQuietly(StreamListener.MessageProducer messageProducer) {
        while (true) {
            InputStream next = messageProducer.next();
            if (next == null) {
                return;
            } else {
                closeQuietly(next);
            }
        }
    }

    public static void exhaust(InputStream inputStream) throws IOException {
        do {
        } while (inputStream.read(new byte[256]) != -1);
    }

    public static ClientStreamTracer[] getClientStreamTracers(CallOptions callOptions, Metadata metadata, int i10, boolean z10) {
        List<ClientStreamTracer.Factory> streamTracerFactories = callOptions.getStreamTracerFactories();
        int size = streamTracerFactories.size() + 1;
        ClientStreamTracer[] clientStreamTracerArr = new ClientStreamTracer[size];
        ClientStreamTracer.StreamInfo build = ClientStreamTracer.StreamInfo.newBuilder().setCallOptions(callOptions).setPreviousAttempts(i10).setIsTransparentRetry(z10).build();
        for (int i11 = 0; i11 < streamTracerFactories.size(); i11++) {
            clientStreamTracerArr[i11] = streamTracerFactories.get(i11).newClientStreamTracer(build, metadata);
        }
        clientStreamTracerArr[size - 1] = NOOP_TRACER;
        return clientStreamTracerArr;
    }

    public static GrpcBuildVersion getGrpcBuildVersion() {
        return new GrpcBuildVersion("gRPC Java", IMPLEMENTATION_VERSION);
    }

    public static String getGrpcUserAgent(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str2 != null) {
            sb2.append(str2);
            sb2.append(' ');
        }
        sb2.append("grpc-java-");
        sb2.append(str);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(IMPLEMENTATION_VERSION);
        return sb2.toString();
    }

    public static String getHost(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory getThreadFactory(String str, boolean z10) {
        return new u().e(z10).f(str).b();
    }

    public static ClientTransport getTransportFromPickResult(LoadBalancer.PickResult pickResult, boolean z10) {
        LoadBalancer.Subchannel subchannel = pickResult.getSubchannel();
        final ClientTransport obtainActiveTransport = subchannel != null ? ((TransportProvider) subchannel.getInternalSubchannel()).obtainActiveTransport() : null;
        if (obtainActiveTransport != null) {
            final ClientStreamTracer.Factory streamTracerFactory = pickResult.getStreamTracerFactory();
            return streamTracerFactory == null ? obtainActiveTransport : new ClientTransport() { // from class: io.grpc.internal.GrpcUtil.6
                @Override // io.grpc.InternalWithLogId
                public InternalLogId getLogId() {
                    return obtainActiveTransport.getLogId();
                }

                @Override // io.grpc.InternalInstrumented
                public n<InternalChannelz.SocketStats> getStats() {
                    return obtainActiveTransport.getStats();
                }

                @Override // io.grpc.internal.ClientTransport
                public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
                    ClientStreamTracer newClientStreamTracer = ClientStreamTracer.Factory.this.newClientStreamTracer(ClientStreamTracer.StreamInfo.newBuilder().setCallOptions(callOptions).build(), metadata);
                    o.y(clientStreamTracerArr[clientStreamTracerArr.length - 1] == GrpcUtil.NOOP_TRACER, "lb tracer already assigned");
                    clientStreamTracerArr[clientStreamTracerArr.length - 1] = newClientStreamTracer;
                    return obtainActiveTransport.newStream(methodDescriptor, metadata, callOptions, clientStreamTracerArr);
                }

                @Override // io.grpc.internal.ClientTransport
                public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
                    obtainActiveTransport.ping(pingCallback, executor);
                }
            };
        }
        if (!pickResult.getStatus().isOk()) {
            if (pickResult.isDrop()) {
                return new FailingClientTransport(replaceInappropriateControlPlaneStatus(pickResult.getStatus()), ClientStreamListener.RpcProgress.DROPPED);
            }
            if (!z10) {
                return new FailingClientTransport(replaceInappropriateControlPlaneStatus(pickResult.getStatus()), ClientStreamListener.RpcProgress.PROCESSED);
            }
        }
        return null;
    }

    private static Status.Code httpStatusToGrpcCode(int i10) {
        if (i10 >= 100 && i10 < 200) {
            return Status.Code.INTERNAL;
        }
        if (i10 != 400) {
            if (i10 == 401) {
                return Status.Code.UNAUTHENTICATED;
            }
            if (i10 == 403) {
                return Status.Code.PERMISSION_DENIED;
            }
            if (i10 != 404) {
                if (i10 != 429) {
                    if (i10 != 431) {
                        switch (i10) {
                            case 502:
                            case 503:
                            case 504:
                                break;
                            default:
                                return Status.Code.UNKNOWN;
                        }
                    }
                }
                return Status.Code.UNAVAILABLE;
            }
            return Status.Code.UNIMPLEMENTED;
        }
        return Status.Code.INTERNAL;
    }

    public static Status httpStatusToGrpcStatus(int i10) {
        return httpStatusToGrpcCode(i10).toStatus().withDescription("HTTP status code " + i10);
    }

    public static boolean isGrpcContentType(String str) {
        char charAt;
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith(CONTENT_TYPE_GRPC)) {
            return lowerCase.length() == 16 || (charAt = lowerCase.charAt(16)) == '+' || charAt == ';';
        }
        return false;
    }

    public static <T> boolean iterableContains(Iterable<T> iterable, T t2) {
        if (iterable instanceof Collection) {
            try {
                return ((Collection) iterable).contains(t2);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        Iterator<T> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            if (l.a(iterator2.next(), t2)) {
                return true;
            }
        }
        return false;
    }

    public static Status replaceInappropriateControlPlaneStatus(Status status) {
        o.d(status != null);
        if (!INAPPROPRIATE_CONTROL_PLANE_STATUS.contains(status.getCode())) {
            return status;
        }
        return Status.INTERNAL.withDescription("Inappropriate status code from control plane: " + ((Object) status.getCode()) + " " + status.getDescription()).withCause(status.getCause());
    }

    public static boolean shouldBeCountedForInUse(CallOptions callOptions) {
        return !Boolean.TRUE.equals(callOptions.getOption(CALL_OPTIONS_RPC_OWNED_BY_BALANCER));
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            log.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e2);
        }
    }
}
