package okhttp3.internal.http;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: HttpMethod.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(@NotNull String method) {
        s.i(method, "method");
        return (s.d(method, "GET") || s.d(method, "HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(@NotNull String method) {
        s.i(method, "method");
        return s.d(method, "POST") || s.d(method, "PUT") || s.d(method, "PATCH") || s.d(method, "PROPPATCH") || s.d(method, "REPORT");
    }

    public final boolean invalidatesCache(@NotNull String method) {
        s.i(method, "method");
        return s.d(method, "POST") || s.d(method, "PATCH") || s.d(method, "PUT") || s.d(method, "DELETE") || s.d(method, "MOVE");
    }

    public final boolean redirectsToGet(@NotNull String method) {
        s.i(method, "method");
        return !s.d(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String method) {
        s.i(method, "method");
        return s.d(method, "PROPFIND");
    }
}
