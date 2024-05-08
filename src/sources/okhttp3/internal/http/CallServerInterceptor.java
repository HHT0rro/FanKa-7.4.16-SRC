package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

/* compiled from: CallServerInterceptor.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z10) {
        this.forWebSocket = z10;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Response.Builder builder;
        boolean z10;
        Response build;
        s.i(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        s.f(exchange$okhttp);
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody body = request$okhttp.body();
        long currentTimeMillis = System.currentTimeMillis();
        exchange$okhttp.writeRequestHeaders(request$okhttp);
        if (HttpMethod.permitsRequestBody(request$okhttp.method()) && body != null) {
            if (p.r("100-continue", request$okhttp.header("Expect"), true)) {
                exchange$okhttp.flushRequest();
                builder = exchange$okhttp.readResponseHeaders(true);
                exchange$okhttp.responseHeadersStart();
                z10 = false;
            } else {
                builder = null;
                z10 = true;
            }
            if (builder == null) {
                if (body.isDuplex()) {
                    exchange$okhttp.flushRequest();
                    body.writeTo(Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, true)));
                } else {
                    BufferedSink buffer = Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, false));
                    body.writeTo(buffer);
                    buffer.close();
                }
            } else {
                exchange$okhttp.noRequestBody();
                if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                    exchange$okhttp.noNewExchangesOnConnection();
                }
            }
        } else {
            exchange$okhttp.noRequestBody();
            builder = null;
            z10 = true;
        }
        if (body == null || !body.isDuplex()) {
            exchange$okhttp.finishRequest();
        }
        if (builder == null) {
            builder = exchange$okhttp.readResponseHeaders(false);
            s.f(builder);
            if (z10) {
                exchange$okhttp.responseHeadersStart();
                z10 = false;
            }
        }
        Response build2 = builder.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build2.code();
        if (code == 100) {
            Response.Builder readResponseHeaders = exchange$okhttp.readResponseHeaders(false);
            s.f(readResponseHeaders);
            if (z10) {
                exchange$okhttp.responseHeadersStart();
            }
            build2 = readResponseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build2.code();
        }
        exchange$okhttp.responseHeadersEnd(build2);
        if (this.forWebSocket && code == 101) {
            build = build2.newBuilder().body(Util.EMPTY_RESPONSE).build();
        } else {
            build = build2.newBuilder().body(exchange$okhttp.openResponseBody(build2)).build();
        }
        if (p.r("close", build.request().header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_CONNECTION), true) || p.r("close", Response.header$default(build, com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_CONNECTION, null, 2, null), true)) {
            exchange$okhttp.noNewExchangesOnConnection();
        }
        if (code == 204 || code == 205) {
            ResponseBody body2 = build.body();
            if ((body2 != null ? body2.contentLength() : -1L) > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("HTTP ");
                sb2.append(code);
                sb2.append(" had non-zero Content-Length: ");
                ResponseBody body3 = build.body();
                sb2.append((Object) (body3 != null ? Long.valueOf(body3.contentLength()) : null));
                throw new ProtocolException(sb2.toString());
            }
        }
        return build;
    }
}
