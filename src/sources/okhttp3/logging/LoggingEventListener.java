package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LoggingEventListener.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    /* compiled from: LoggingEventListener.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public Factory(@NotNull HttpLoggingInterceptor.Logger logger) {
            s.j(logger, "logger");
            this.logger = logger;
        }

        @Override // okhttp3.EventListener.Factory
        @NotNull
        public EventListener create(@NotNull Call call) {
            s.j(call, "call");
            return new LoggingEventListener(this.logger, null);
        }

        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger);
        }
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger);
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        this.logger.log('[' + millis + " ms] " + str);
    }

    @Override // okhttp3.EventListener
    public void callEnd(@NotNull Call call) {
        s.j(call, "call");
        logWithTime("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        s.j(call, "call");
        s.j(ioe, "ioe");
        logWithTime("callFailed: " + ((Object) ioe));
    }

    @Override // okhttp3.EventListener
    public void callStart(@NotNull Call call) {
        s.j(call, "call");
        this.startNs = System.nanoTime();
        logWithTime("callStart: " + ((Object) call.request()));
    }

    @Override // okhttp3.EventListener
    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        s.j(call, "call");
        s.j(inetSocketAddress, "inetSocketAddress");
        s.j(proxy, "proxy");
        logWithTime("connectEnd: " + ((Object) protocol));
    }

    @Override // okhttp3.EventListener
    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        s.j(call, "call");
        s.j(inetSocketAddress, "inetSocketAddress");
        s.j(proxy, "proxy");
        s.j(ioe, "ioe");
        logWithTime("connectFailed: " + ((Object) protocol) + ' ' + ((Object) ioe));
    }

    @Override // okhttp3.EventListener
    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        s.j(call, "call");
        s.j(inetSocketAddress, "inetSocketAddress");
        s.j(proxy, "proxy");
        logWithTime("connectStart: " + ((Object) inetSocketAddress) + ' ' + ((Object) proxy));
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        s.j(call, "call");
        s.j(connection, "connection");
        logWithTime("connectionAcquired: " + ((Object) connection));
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        s.j(call, "call");
        s.j(connection, "connection");
        logWithTime("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<? extends InetAddress> inetAddressList) {
        s.j(call, "call");
        s.j(domainName, "domainName");
        s.j(inetAddressList, "inetAddressList");
        logWithTime("dnsEnd: " + ((Object) inetAddressList));
    }

    @Override // okhttp3.EventListener
    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        s.j(call, "call");
        s.j(domainName, "domainName");
        logWithTime("dnsStart: " + domainName);
    }

    @Override // okhttp3.EventListener
    public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List<? extends Proxy> proxies) {
        s.j(call, "call");
        s.j(url, "url");
        s.j(proxies, "proxies");
        logWithTime("proxySelectEnd: " + ((Object) proxies));
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
        s.j(call, "call");
        s.j(url, "url");
        logWithTime("proxySelectStart: " + ((Object) url));
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(@NotNull Call call, long j10) {
        s.j(call, "call");
        logWithTime("requestBodyEnd: byteCount=" + j10);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(@NotNull Call call) {
        s.j(call, "call");
        logWithTime("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
        s.j(call, "call");
        s.j(ioe, "ioe");
        logWithTime("requestFailed: " + ((Object) ioe));
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        s.j(call, "call");
        s.j(request, "request");
        logWithTime("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(@NotNull Call call) {
        s.j(call, "call");
        logWithTime("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(@NotNull Call call, long j10) {
        s.j(call, "call");
        logWithTime("responseBodyEnd: byteCount=" + j10);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(@NotNull Call call) {
        s.j(call, "call");
        logWithTime("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
        s.j(call, "call");
        s.j(ioe, "ioe");
        logWithTime("responseFailed: " + ((Object) ioe));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        s.j(call, "call");
        s.j(response, "response");
        logWithTime("responseHeadersEnd: " + ((Object) response));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(@NotNull Call call) {
        s.j(call, "call");
        logWithTime("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        s.j(call, "call");
        logWithTime("secureConnectEnd: " + ((Object) handshake));
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(@NotNull Call call) {
        s.j(call, "call");
        logWithTime("secureConnectStart");
    }

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }
}
