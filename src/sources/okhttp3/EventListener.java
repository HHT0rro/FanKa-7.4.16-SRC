package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventListener.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* compiled from: EventListener.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EventListener.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Factory {
        @NotNull
        EventListener create(@NotNull Call call);
    }

    public void cacheConditionalHit(@NotNull Call call, @NotNull Response cachedResponse) {
        s.i(call, "call");
        s.i(cachedResponse, "cachedResponse");
    }

    public void cacheHit(@NotNull Call call, @NotNull Response response) {
        s.i(call, "call");
        s.i(response, "response");
    }

    public void cacheMiss(@NotNull Call call) {
        s.i(call, "call");
    }

    public void callEnd(@NotNull Call call) {
        s.i(call, "call");
    }

    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        s.i(call, "call");
        s.i(ioe, "ioe");
    }

    public void callStart(@NotNull Call call) {
        s.i(call, "call");
    }

    public void canceled(@NotNull Call call) {
        s.i(call, "call");
    }

    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        s.i(call, "call");
        s.i(inetSocketAddress, "inetSocketAddress");
        s.i(proxy, "proxy");
    }

    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        s.i(call, "call");
        s.i(inetSocketAddress, "inetSocketAddress");
        s.i(proxy, "proxy");
        s.i(ioe, "ioe");
    }

    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        s.i(call, "call");
        s.i(inetSocketAddress, "inetSocketAddress");
        s.i(proxy, "proxy");
    }

    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        s.i(call, "call");
        s.i(connection, "connection");
    }

    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        s.i(call, "call");
        s.i(connection, "connection");
    }

    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<InetAddress> inetAddressList) {
        s.i(call, "call");
        s.i(domainName, "domainName");
        s.i(inetAddressList, "inetAddressList");
    }

    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        s.i(call, "call");
        s.i(domainName, "domainName");
    }

    public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List<Proxy> proxies) {
        s.i(call, "call");
        s.i(url, "url");
        s.i(proxies, "proxies");
    }

    public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
        s.i(call, "call");
        s.i(url, "url");
    }

    public void requestBodyEnd(@NotNull Call call, long j10) {
        s.i(call, "call");
    }

    public void requestBodyStart(@NotNull Call call) {
        s.i(call, "call");
    }

    public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
        s.i(call, "call");
        s.i(ioe, "ioe");
    }

    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        s.i(call, "call");
        s.i(request, "request");
    }

    public void requestHeadersStart(@NotNull Call call) {
        s.i(call, "call");
    }

    public void responseBodyEnd(@NotNull Call call, long j10) {
        s.i(call, "call");
    }

    public void responseBodyStart(@NotNull Call call) {
        s.i(call, "call");
    }

    public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
        s.i(call, "call");
        s.i(ioe, "ioe");
    }

    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        s.i(call, "call");
        s.i(response, "response");
    }

    public void responseHeadersStart(@NotNull Call call) {
        s.i(call, "call");
    }

    public void satisfactionFailure(@NotNull Call call, @NotNull Response response) {
        s.i(call, "call");
        s.i(response, "response");
    }

    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        s.i(call, "call");
    }

    public void secureConnectStart(@NotNull Call call) {
        s.i(call, "call");
    }
}
