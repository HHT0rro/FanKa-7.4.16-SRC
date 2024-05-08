package okhttp3.logging;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.collections.m0;
import kotlin.collections.x;
import kotlin.d;
import kotlin.io.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.text.p;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.jetbrains.annotations.NotNull;

/* compiled from: HttpLoggingInterceptor.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;

    @NotNull
    private volatile Level level;
    private final Logger logger;

    /* compiled from: HttpLoggingInterceptor.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Logger {
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final Logger DEFAULT = new Logger() { // from class: okhttp3.logging.HttpLoggingInterceptor$Logger$Companion$DEFAULT$1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(@NotNull String message) {
                s.j(message, "message");
                Platform.Companion.get().log(4, message, (Throwable) null);
            }
        };

        /* compiled from: HttpLoggingInterceptor.kt */
        @d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = null;

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        void log(@NotNull String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HttpLoggingInterceptor(@NotNull Logger logger) {
        s.j(logger, "logger");
        this.logger = logger;
        this.headersToRedact = m0.d();
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || p.r(str, "identity", true) || p.r(str, "gzip", true)) ? false : true;
    }

    private final void logHeader(Headers headers, int i10) {
        String value = this.headersToRedact.contains(headers.name(i10)) ? "██" : headers.value(i10);
        this.logger.log(headers.name(i10) + ": " + value);
    }

    @NotNull
    /* renamed from: -deprecated_level, reason: not valid java name */
    public final Level m3727deprecated_level() {
        return this.level;
    }

    @NotNull
    public final Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        String str;
        String sb2;
        Charset UTF_8;
        Charset UTF_82;
        s.j(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z10 = level == Level.BODY;
        boolean z11 = z10 || level == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("--> ");
        sb3.append(request.method());
        sb3.append(' ');
        sb3.append((Object) request.url());
        sb3.append(connection != null ? " " + ((Object) connection.protocol()) : "");
        String sb4 = sb3.toString();
        if (!z11 && body != null) {
            sb4 = sb4 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(sb4);
        if (z11) {
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    this.logger.log("Content-Type: " + ((Object) contentType));
                }
                if (body.contentLength() != -1) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i10 = 0;
            while (i10 < size) {
                String name = headers.name(i10);
                int i11 = size;
                if (!p.r("Content-Type", name, true) && !p.r("Content-Length", name, true)) {
                    logHeader(headers, i10);
                }
                i10++;
                size = i11;
            }
            if (z10 && body != null) {
                if (bodyHasUnknownEncoding(request.headers())) {
                    this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                } else if (body.isDuplex()) {
                    this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
                } else {
                    Buffer buffer = new Buffer();
                    body.writeTo(buffer);
                    MediaType contentType2 = body.contentType();
                    if (contentType2 == null || (UTF_82 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                        UTF_82 = StandardCharsets.UTF_8;
                        s.e(UTF_82, "UTF_8");
                    }
                    this.logger.log("");
                    if (Utf8Kt.isProbablyUtf8(buffer)) {
                        this.logger.log(buffer.readString(UTF_82));
                        this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                    } else {
                        this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                    }
                }
            } else {
                this.logger.log("--> END " + request.method());
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            if (body2 == null) {
                s.u();
            }
            long contentLength = body2.contentLength();
            String str2 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("<-- ");
            sb5.append(proceed.code());
            if (proceed.message().length() == 0) {
                str = "-byte body omitted)";
                sb2 = "";
            } else {
                String message = proceed.message();
                StringBuilder sb6 = new StringBuilder();
                str = "-byte body omitted)";
                sb6.append(String.valueOf(' '));
                sb6.append(message);
                sb2 = sb6.toString();
            }
            sb5.append(sb2);
            sb5.append(' ');
            sb5.append((Object) proceed.request().url());
            sb5.append(" (");
            sb5.append(millis);
            sb5.append("ms");
            sb5.append(z11 ? "" : ", " + str2 + " body");
            sb5.append(')');
            logger.log(sb5.toString());
            if (z11) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    logHeader(headers2, i12);
                }
                if (z10 && HttpHeaders.promisesBody(proceed)) {
                    if (bodyHasUnknownEncoding(proceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        BufferedSource source = body2.source();
                        source.request(Long.MAX_VALUE);
                        Buffer buffer2 = source.getBuffer();
                        Long l10 = null;
                        if (p.r("gzip", headers2.get("Content-Encoding"), true)) {
                            Long valueOf = Long.valueOf(buffer2.size());
                            GzipSource gzipSource = new GzipSource(buffer2.clone());
                            try {
                                buffer2 = new Buffer();
                                buffer2.writeAll(gzipSource);
                                b.a(gzipSource, null);
                                l10 = valueOf;
                            } finally {
                            }
                        }
                        MediaType contentType3 = body2.contentType();
                        if (contentType3 == null || (UTF_8 = contentType3.charset(StandardCharsets.UTF_8)) == null) {
                            UTF_8 = StandardCharsets.UTF_8;
                            s.e(UTF_8, "UTF_8");
                        }
                        if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                            this.logger.log("");
                            this.logger.log("<-- END HTTP (binary " + buffer2.size() + str);
                            return proceed;
                        }
                        if (contentLength != 0) {
                            this.logger.log("");
                            this.logger.log(buffer2.clone().readString(UTF_8));
                        }
                        if (l10 != null) {
                            this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + ((Object) l10) + "-gzipped-byte body)");
                        } else {
                            this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                        }
                    }
                } else {
                    this.logger.log("<-- END HTTP");
                }
            }
            return proceed;
        } catch (Exception e2) {
            this.logger.log("<-- HTTP FAILED: " + ((Object) e2));
            throw e2;
        }
    }

    public final void level(@NotNull Level level) {
        s.j(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(@NotNull String name) {
        s.j(name, "name");
        TreeSet treeSet = new TreeSet(p.s(y.f51038a));
        x.x(treeSet, this.headersToRedact);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    @NotNull
    public final HttpLoggingInterceptor setLevel(@NotNull Level level) {
        s.j(level, "level");
        this.level = level;
        return this;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
