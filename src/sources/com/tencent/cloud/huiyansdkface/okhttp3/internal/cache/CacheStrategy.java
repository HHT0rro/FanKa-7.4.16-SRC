package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache;

import com.tencent.cloud.huiyansdkface.okhttp3.CacheControl;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpDate;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class CacheStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final Request f41627a;

    /* renamed from: b, reason: collision with root package name */
    public final Response f41628b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Factory {

        /* renamed from: a, reason: collision with root package name */
        public final long f41629a;

        /* renamed from: b, reason: collision with root package name */
        public final Request f41630b;

        /* renamed from: c, reason: collision with root package name */
        public final Response f41631c;

        /* renamed from: d, reason: collision with root package name */
        private Date f41632d;

        /* renamed from: e, reason: collision with root package name */
        private String f41633e;

        /* renamed from: f, reason: collision with root package name */
        private Date f41634f;

        /* renamed from: g, reason: collision with root package name */
        private String f41635g;

        /* renamed from: h, reason: collision with root package name */
        private Date f41636h;

        /* renamed from: i, reason: collision with root package name */
        private long f41637i;

        /* renamed from: j, reason: collision with root package name */
        private long f41638j;

        /* renamed from: k, reason: collision with root package name */
        private String f41639k;

        /* renamed from: l, reason: collision with root package name */
        private int f41640l;

        public Factory(long j10, Request request, Response response) {
            this.f41640l = -1;
            this.f41629a = j10;
            this.f41630b = request;
            this.f41631c = response;
            if (response != null) {
                this.f41637i = response.sentRequestAtMillis();
                this.f41638j = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String name = headers.name(i10);
                    String value = headers.value(i10);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.f41632d = HttpDate.parse(value);
                        this.f41633e = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.f41636h = HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.f41634f = HttpDate.parse(value);
                        this.f41635g = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.f41639k = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.f41640l = HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        private CacheStrategy a() {
            if (this.f41631c == null) {
                return new CacheStrategy(this.f41630b, null);
            }
            if ((!this.f41630b.isHttps() || this.f41631c.handshake() != null) && CacheStrategy.isCacheable(this.f41631c, this.f41630b)) {
                CacheControl cacheControl = this.f41630b.cacheControl();
                if (cacheControl.noCache() || a(this.f41630b)) {
                    return new CacheStrategy(this.f41630b, null);
                }
                CacheControl cacheControl2 = this.f41631c.cacheControl();
                long c4 = c();
                long b4 = b();
                if (cacheControl.maxAgeSeconds() != -1) {
                    b4 = Math.min(b4, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                }
                long j10 = 0;
                long millis = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
                if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                    j10 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                }
                if (!cacheControl2.noCache()) {
                    long j11 = millis + c4;
                    if (j11 < j10 + b4) {
                        Response.Builder newBuilder = this.f41631c.newBuilder();
                        if (j11 >= b4) {
                            newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (c4 > 86400000 && d()) {
                            newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new CacheStrategy(null, newBuilder.build());
                    }
                }
                String str = this.f41639k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f41634f != null) {
                    str = this.f41635g;
                } else {
                    if (this.f41632d == null) {
                        return new CacheStrategy(this.f41630b, null);
                    }
                    str = this.f41633e;
                }
                Headers.Builder newBuilder2 = this.f41630b.headers().newBuilder();
                Internal.f41598a.addLenient(newBuilder2, str2, str);
                return new CacheStrategy(this.f41630b.newBuilder().headers(newBuilder2.build()).build(), this.f41631c);
            }
            return new CacheStrategy(this.f41630b, null);
        }

        private static boolean a(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private long b() {
            if (this.f41631c.cacheControl().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            if (this.f41636h != null) {
                Date date = this.f41632d;
                long time = this.f41636h.getTime() - (date != null ? date.getTime() : this.f41638j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f41634f == null || this.f41631c.request().url().query() != null) {
                return 0L;
            }
            Date date2 = this.f41632d;
            long time2 = (date2 != null ? date2.getTime() : this.f41637i) - this.f41634f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private long c() {
            Date date = this.f41632d;
            long max = date != null ? Math.max(0L, this.f41638j - date.getTime()) : 0L;
            int i10 = this.f41640l;
            if (i10 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f41638j;
            return max + (j10 - this.f41637i) + (this.f41629a - j10);
        }

        private boolean d() {
            return this.f41631c.cacheControl().maxAgeSeconds() == -1 && this.f41636h == null;
        }

        public CacheStrategy get() {
            CacheStrategy a10 = a();
            return (a10.f41627a == null || !this.f41630b.cacheControl().onlyIfCached()) ? a10 : new CacheStrategy(null, null);
        }
    }

    public CacheStrategy(Request request, Response response) {
        this.f41627a = request;
        this.f41628b = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.cacheControl().isPrivate() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCacheable(com.tencent.cloud.huiyansdkface.okhttp3.Response r3, com.tencent.cloud.huiyansdkface.okhttp3.Request r4) {
        /*
            int r0 = r3.code()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.header(r0)
            if (r0 != 0) goto L5a
            com.tencent.cloud.huiyansdkface.okhttp3.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L5a
            com.tencent.cloud.huiyansdkface.okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPublic()
            if (r0 != 0) goto L5a
            com.tencent.cloud.huiyansdkface.okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPrivate()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.tencent.cloud.huiyansdkface.okhttp3.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L6f
            com.tencent.cloud.huiyansdkface.okhttp3.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheStrategy.isCacheable(com.tencent.cloud.huiyansdkface.okhttp3.Response, com.tencent.cloud.huiyansdkface.okhttp3.Request):boolean");
    }
}
