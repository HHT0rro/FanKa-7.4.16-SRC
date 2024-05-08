package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import kotlin.d;
import kotlin.jvm.internal.s;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: internal.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Internal {
    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String line) {
        s.i(builder, "builder");
        s.i(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final void applyConnectionSpec(@NotNull ConnectionSpec connectionSpec, @NotNull SSLSocket sslSocket, boolean z10) {
        s.i(connectionSpec, "connectionSpec");
        s.i(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z10);
    }

    @Nullable
    public static final Response cacheGet(@NotNull Cache cache, @NotNull Request request) {
        s.i(cache, "cache");
        s.i(request, "request");
        return cache.get$okhttp(request);
    }

    @NotNull
    public static final String cookieToString(@NotNull Cookie cookie, boolean z10) {
        s.i(cookie, "cookie");
        return cookie.toString$okhttp(z10);
    }

    @Nullable
    public static final Cookie parseCookie(long j10, @NotNull HttpUrl url, @NotNull String setCookie) {
        s.i(url, "url");
        s.i(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j10, url, setCookie);
    }

    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        s.i(builder, "builder");
        s.i(name, "name");
        s.i(value, "value");
        return builder.addLenient$okhttp(name, value);
    }
}
