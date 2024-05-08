package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Response implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final Request f41555a;

    /* renamed from: b, reason: collision with root package name */
    public final Protocol f41556b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41557c;

    /* renamed from: d, reason: collision with root package name */
    public final String f41558d;

    /* renamed from: e, reason: collision with root package name */
    public final Handshake f41559e;

    /* renamed from: f, reason: collision with root package name */
    public final Headers f41560f;

    /* renamed from: g, reason: collision with root package name */
    public final ResponseBody f41561g;

    /* renamed from: h, reason: collision with root package name */
    public final Response f41562h;

    /* renamed from: i, reason: collision with root package name */
    public final Response f41563i;

    /* renamed from: j, reason: collision with root package name */
    public final Response f41564j;

    /* renamed from: k, reason: collision with root package name */
    public final long f41565k;

    /* renamed from: l, reason: collision with root package name */
    public final long f41566l;

    /* renamed from: m, reason: collision with root package name */
    private volatile CacheControl f41567m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Request f41568a;

        /* renamed from: b, reason: collision with root package name */
        public Protocol f41569b;

        /* renamed from: c, reason: collision with root package name */
        public int f41570c;

        /* renamed from: d, reason: collision with root package name */
        public String f41571d;

        /* renamed from: e, reason: collision with root package name */
        public Handshake f41572e;

        /* renamed from: f, reason: collision with root package name */
        public Headers.Builder f41573f;

        /* renamed from: g, reason: collision with root package name */
        public ResponseBody f41574g;

        /* renamed from: h, reason: collision with root package name */
        public Response f41575h;

        /* renamed from: i, reason: collision with root package name */
        public Response f41576i;

        /* renamed from: j, reason: collision with root package name */
        public Response f41577j;

        /* renamed from: k, reason: collision with root package name */
        public long f41578k;

        /* renamed from: l, reason: collision with root package name */
        public long f41579l;

        public Builder() {
            this.f41570c = -1;
            this.f41573f = new Headers.Builder();
        }

        public Builder(Response response) {
            this.f41570c = -1;
            this.f41568a = response.f41555a;
            this.f41569b = response.f41556b;
            this.f41570c = response.f41557c;
            this.f41571d = response.f41558d;
            this.f41572e = response.f41559e;
            this.f41573f = response.f41560f.newBuilder();
            this.f41574g = response.f41561g;
            this.f41575h = response.f41562h;
            this.f41576i = response.f41563i;
            this.f41577j = response.f41564j;
            this.f41578k = response.f41565k;
            this.f41579l = response.f41566l;
        }

        private void a(Response response) {
            if (response.f41561g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void a(String str, Response response) {
            if (response.f41561g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (response.f41562h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.f41563i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.f41564j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public Builder addHeader(String str, String str2) {
            this.f41573f.add(str, str2);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.f41574g = responseBody;
            return this;
        }

        public Response build() {
            if (this.f41568a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f41569b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f41570c >= 0) {
                if (this.f41571d != null) {
                    return new Response(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f41570c);
        }

        public Builder cacheResponse(Response response) {
            if (response != null) {
                a("cacheResponse", response);
            }
            this.f41576i = response;
            return this;
        }

        public Builder code(int i10) {
            this.f41570c = i10;
            return this;
        }

        public Builder handshake(Handshake handshake) {
            this.f41572e = handshake;
            return this;
        }

        public Builder header(String str, String str2) {
            this.f41573f.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f41573f = headers.newBuilder();
            return this;
        }

        public Builder message(String str) {
            this.f41571d = str;
            return this;
        }

        public Builder networkResponse(Response response) {
            if (response != null) {
                a("networkResponse", response);
            }
            this.f41575h = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            if (response != null) {
                a(response);
            }
            this.f41577j = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.f41569b = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j10) {
            this.f41579l = j10;
            return this;
        }

        public Builder removeHeader(String str) {
            this.f41573f.removeAll(str);
            return this;
        }

        public Builder request(Request request) {
            this.f41568a = request;
            return this;
        }

        public Builder sentRequestAtMillis(long j10) {
            this.f41578k = j10;
            return this;
        }
    }

    public Response(Builder builder) {
        this.f41555a = builder.f41568a;
        this.f41556b = builder.f41569b;
        this.f41557c = builder.f41570c;
        this.f41558d = builder.f41571d;
        this.f41559e = builder.f41572e;
        this.f41560f = builder.f41573f.build();
        this.f41561g = builder.f41574g;
        this.f41562h = builder.f41575h;
        this.f41563i = builder.f41576i;
        this.f41564j = builder.f41577j;
        this.f41565k = builder.f41578k;
        this.f41566l = builder.f41579l;
    }

    public ResponseBody body() {
        return this.f41561g;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f41567m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f41560f);
        this.f41567m = parse;
        return parse;
    }

    public Response cacheResponse() {
        return this.f41563i;
    }

    public List<Challenge> challenges() {
        String str;
        int i10 = this.f41557c;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i10 != 407) {
                return Collections.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers(), str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.f41561g;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public int code() {
        return this.f41557c;
    }

    public Handshake handshake() {
        return this.f41559e;
    }

    public String header(String str) {
        return header(str, null);
    }

    public String header(String str, String str2) {
        String str3 = this.f41560f.get(str);
        return str3 != null ? str3 : str2;
    }

    public Headers headers() {
        return this.f41560f;
    }

    public List<String> headers(String str) {
        return this.f41560f.values(str);
    }

    public boolean isRedirect() {
        int i10 = this.f41557c;
        if (i10 == 307 || i10 == 308) {
            return true;
        }
        switch (i10) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i10 = this.f41557c;
        return i10 >= 200 && i10 < 300;
    }

    public String message() {
        return this.f41558d;
    }

    public Response networkResponse() {
        return this.f41562h;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public ResponseBody peekBody(long j10) throws IOException {
        BufferedSource source = this.f41561g.source();
        source.request(j10);
        Buffer m2929clone = source.buffer().m2929clone();
        if (m2929clone.size() > j10) {
            Buffer buffer = new Buffer();
            buffer.write(m2929clone, j10);
            m2929clone.clear();
            m2929clone = buffer;
        }
        return ResponseBody.create(this.f41561g.contentType(), m2929clone.size(), m2929clone);
    }

    public Response priorResponse() {
        return this.f41564j;
    }

    public Protocol protocol() {
        return this.f41556b;
    }

    public long receivedResponseAtMillis() {
        return this.f41566l;
    }

    public Request request() {
        return this.f41555a;
    }

    public long sentRequestAtMillis() {
        return this.f41565k;
    }

    public String toString() {
        return "Response{protocol=" + ((Object) this.f41556b) + ", code=" + this.f41557c + ", message=" + this.f41558d + ", url=" + ((Object) this.f41555a.url()) + '}';
    }
}
