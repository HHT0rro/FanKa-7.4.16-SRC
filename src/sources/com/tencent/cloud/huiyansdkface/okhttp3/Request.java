package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpMethod;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Request {

    /* renamed from: a, reason: collision with root package name */
    public final HttpUrl f41536a;

    /* renamed from: b, reason: collision with root package name */
    public final String f41537b;

    /* renamed from: c, reason: collision with root package name */
    public final Headers f41538c;

    /* renamed from: d, reason: collision with root package name */
    public final RequestBody f41539d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, Object> f41540e;

    /* renamed from: f, reason: collision with root package name */
    private volatile CacheControl f41541f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public HttpUrl f41542a;

        /* renamed from: b, reason: collision with root package name */
        public String f41543b;

        /* renamed from: c, reason: collision with root package name */
        public Headers.Builder f41544c;

        /* renamed from: d, reason: collision with root package name */
        public RequestBody f41545d;

        /* renamed from: e, reason: collision with root package name */
        public Map<Class<?>, Object> f41546e;

        public Builder() {
            this.f41546e = Collections.emptyMap();
            this.f41543b = "GET";
            this.f41544c = new Headers.Builder();
        }

        public Builder(Request request) {
            this.f41546e = Collections.emptyMap();
            this.f41542a = request.f41536a;
            this.f41543b = request.f41537b;
            this.f41545d = request.f41539d;
            this.f41546e = request.f41540e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(request.f41540e);
            this.f41544c = request.f41538c.newBuilder();
        }

        public Builder addHeader(String str, String str2) {
            this.f41544c.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.f41542a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public Builder delete() {
            return delete(Util.f41603d);
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            this.f41544c.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f41544c = headers.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.f41543b = str;
                this.f41545d = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            this.f41544c.removeAll(str);
            return this;
        }

        public <T> Builder tag(Class<? super T> cls, T t2) {
            Objects.requireNonNull(cls, "type == null");
            if (t2 == null) {
                this.f41546e.remove(cls);
            } else {
                if (this.f41546e.isEmpty()) {
                    this.f41546e = new LinkedHashMap();
                }
                this.f41546e.put(cls, cls.cast(t2));
            }
            return this;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Object tag() {
            return this.f41546e.get(Object.class);
        }

        public Builder url(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "url == null");
            this.f41542a = httpUrl;
            return this;
        }

        public Builder url(String str) {
            StringBuilder sb2;
            int i10;
            Objects.requireNonNull(str, "url == null");
            if (!str.regionMatches(true, 0, "ws:", 0, 3)) {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    sb2 = new StringBuilder();
                    sb2.append("https:");
                    i10 = 4;
                }
                return url(HttpUrl.get(str));
            }
            sb2 = new StringBuilder();
            sb2.append("http:");
            i10 = 3;
            sb2.append(str.substring(i10));
            str = sb2.toString();
            return url(HttpUrl.get(str));
        }

        public Builder url(URL url) {
            Objects.requireNonNull(url, "url == null");
            return url(HttpUrl.get(url.toString()));
        }
    }

    public Request(Builder builder) {
        this.f41536a = builder.f41542a;
        this.f41537b = builder.f41543b;
        this.f41538c = builder.f41544c.build();
        this.f41539d = builder.f41545d;
        this.f41540e = Util.immutableMap(builder.f41546e);
    }

    public RequestBody body() {
        return this.f41539d;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f41541f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f41538c);
        this.f41541f = parse;
        return parse;
    }

    public String header(String str) {
        return this.f41538c.get(str);
    }

    public Headers headers() {
        return this.f41538c;
    }

    public List<String> headers(String str) {
        return this.f41538c.values(str);
    }

    public boolean isHttps() {
        return this.f41536a.isHttps();
    }

    public String method() {
        return this.f41537b;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Object tag() {
        return tag(Object.class);
    }

    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.f41540e.get(cls));
    }

    public String toString() {
        return "Request{method=" + this.f41537b + ", url=" + ((Object) this.f41536a) + ", tags=" + ((Object) this.f41540e) + '}';
    }

    public HttpUrl url() {
        return this.f41536a;
    }
}
