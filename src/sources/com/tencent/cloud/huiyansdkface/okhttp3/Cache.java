package com.tencent.cloud.huiyansdkface.okhttp3;

import com.huawei.hms.feature.dynamic.f.e;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheRequest;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheStrategy;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpMethod;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.StatusLine;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.io.FileSystem;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.ForwardingSink;
import com.tencent.cloud.huiyansdkface.okio.ForwardingSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Cache implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    public final InternalCache f41233a;

    /* renamed from: b, reason: collision with root package name */
    public final DiskLruCache f41234b;

    /* renamed from: c, reason: collision with root package name */
    public int f41235c;

    /* renamed from: d, reason: collision with root package name */
    public int f41236d;

    /* renamed from: e, reason: collision with root package name */
    private int f41237e;

    /* renamed from: f, reason: collision with root package name */
    private int f41238f;

    /* renamed from: g, reason: collision with root package name */
    private int f41239g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class CacheRequestImpl implements CacheRequest {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41245a;

        /* renamed from: c, reason: collision with root package name */
        private final DiskLruCache.Editor f41247c;

        /* renamed from: d, reason: collision with root package name */
        private Sink f41248d;

        /* renamed from: e, reason: collision with root package name */
        private Sink f41249e;

        public CacheRequestImpl(final DiskLruCache.Editor editor) {
            this.f41247c = editor;
            Sink newSink = editor.newSink(1);
            this.f41248d = newSink;
            this.f41249e = new ForwardingSink(newSink) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Cache.CacheRequestImpl.1
                @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        CacheRequestImpl cacheRequestImpl = CacheRequestImpl.this;
                        if (cacheRequestImpl.f41245a) {
                            return;
                        }
                        cacheRequestImpl.f41245a = true;
                        Cache.this.f41235c++;
                        super.close();
                        editor.commit();
                    }
                }
            };
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (Cache.this) {
                if (this.f41245a) {
                    return;
                }
                this.f41245a = true;
                Cache.this.f41236d++;
                Util.closeQuietly(this.f41248d);
                try {
                    this.f41247c.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.f41249e;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class CacheResponseBody extends ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        public final DiskLruCache.Snapshot f41253a;

        /* renamed from: b, reason: collision with root package name */
        private final BufferedSource f41254b;

        /* renamed from: c, reason: collision with root package name */
        private final String f41255c;

        /* renamed from: d, reason: collision with root package name */
        private final String f41256d;

        public CacheResponseBody(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f41253a = snapshot;
            this.f41255c = str;
            this.f41256d = str2;
            this.f41254b = Okio.buffer(new ForwardingSource(snapshot.getSource(1)) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Cache.CacheResponseBody.1
                @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSource, com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
        public long contentLength() {
            try {
                String str = this.f41256d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.f41255c;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
        public BufferedSource source() {
            return this.f41254b;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Entry {

        /* renamed from: a, reason: collision with root package name */
        private static final String f41259a = Platform.get().getPrefix() + "-Sent-Millis";

        /* renamed from: b, reason: collision with root package name */
        private static final String f41260b = Platform.get().getPrefix() + "-Received-Millis";

        /* renamed from: c, reason: collision with root package name */
        private final String f41261c;

        /* renamed from: d, reason: collision with root package name */
        private final Headers f41262d;

        /* renamed from: e, reason: collision with root package name */
        private final String f41263e;

        /* renamed from: f, reason: collision with root package name */
        private final Protocol f41264f;

        /* renamed from: g, reason: collision with root package name */
        private final int f41265g;

        /* renamed from: h, reason: collision with root package name */
        private final String f41266h;

        /* renamed from: i, reason: collision with root package name */
        private final Headers f41267i;

        /* renamed from: j, reason: collision with root package name */
        private final Handshake f41268j;

        /* renamed from: k, reason: collision with root package name */
        private final long f41269k;

        /* renamed from: l, reason: collision with root package name */
        private final long f41270l;

        public Entry(Response response) {
            this.f41261c = response.request().url().toString();
            this.f41262d = HttpHeaders.varyHeaders(response);
            this.f41263e = response.request().method();
            this.f41264f = response.protocol();
            this.f41265g = response.code();
            this.f41266h = response.message();
            this.f41267i = response.headers();
            this.f41268j = response.handshake();
            this.f41269k = response.sentRequestAtMillis();
            this.f41270l = response.receivedResponseAtMillis();
        }

        public Entry(Source source) throws IOException {
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.f41261c = buffer.readUtf8LineStrict();
                this.f41263e = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int a10 = Cache.a(buffer);
                for (int i10 = 0; i10 < a10; i10++) {
                    builder.a(buffer.readUtf8LineStrict());
                }
                this.f41262d = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.f41264f = parse.f41784a;
                this.f41265g = parse.f41785b;
                this.f41266h = parse.f41786c;
                Headers.Builder builder2 = new Headers.Builder();
                int a11 = Cache.a(buffer);
                for (int i11 = 0; i11 < a11; i11++) {
                    builder2.a(buffer.readUtf8LineStrict());
                }
                String str = f41259a;
                String str2 = builder2.get(str);
                String str3 = f41260b;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.f41269k = str2 != null ? Long.parseLong(str2) : 0L;
                this.f41270l = str4 != null ? Long.parseLong(str4) : 0L;
                this.f41267i = builder2.build();
                if (a()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                    this.f41268j = Handshake.get(!buffer.exhausted() ? TlsVersion.forJavaName(buffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, CipherSuite.forJavaName(buffer.readUtf8LineStrict()), a(buffer), a(buffer));
                } else {
                    this.f41268j = null;
                }
            } finally {
                source.close();
            }
        }

        private List<Certificate> a(BufferedSource bufferedSource) throws IOException {
            int a10 = Cache.a(bufferedSource);
            if (a10 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(e.f29912b);
                ArrayList arrayList = new ArrayList(a10);
                for (int i10 = 0; i10 < a10; i10++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void a(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    bufferedSink.writeUtf8(ByteString.of(list.get(i10).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private boolean a() {
            return this.f41261c.startsWith("https://");
        }

        public boolean matches(Request request, Response response) {
            return this.f41261c.equals(request.url().toString()) && this.f41263e.equals(request.method()) && HttpHeaders.varyMatches(response, this.f41262d, request);
        }

        public Response response(DiskLruCache.Snapshot snapshot) {
            String str = this.f41267i.get("Content-Type");
            String str2 = this.f41267i.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.f41261c).method(this.f41263e, null).headers(this.f41262d).build()).protocol(this.f41264f).code(this.f41265g).message(this.f41266h).headers(this.f41267i).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.f41268j).sentRequestAtMillis(this.f41269k).receivedResponseAtMillis(this.f41270l).build();
        }

        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.f41261c).writeByte(10);
            buffer.writeUtf8(this.f41263e).writeByte(10);
            buffer.writeDecimalLong(this.f41262d.size()).writeByte(10);
            int size = this.f41262d.size();
            for (int i10 = 0; i10 < size; i10++) {
                buffer.writeUtf8(this.f41262d.name(i10)).writeUtf8(": ").writeUtf8(this.f41262d.value(i10)).writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.f41264f, this.f41265g, this.f41266h).toString()).writeByte(10);
            buffer.writeDecimalLong(this.f41267i.size() + 2).writeByte(10);
            int size2 = this.f41267i.size();
            for (int i11 = 0; i11 < size2; i11++) {
                buffer.writeUtf8(this.f41267i.name(i11)).writeUtf8(": ").writeUtf8(this.f41267i.value(i11)).writeByte(10);
            }
            buffer.writeUtf8(f41259a).writeUtf8(": ").writeDecimalLong(this.f41269k).writeByte(10);
            buffer.writeUtf8(f41260b).writeUtf8(": ").writeDecimalLong(this.f41270l).writeByte(10);
            if (a()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.f41268j.cipherSuite().javaName()).writeByte(10);
                a(buffer, this.f41268j.peerCertificates());
                a(buffer, this.f41268j.localCertificates());
                buffer.writeUtf8(this.f41268j.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }
    }

    public Cache(File file, long j10) {
        this(file, j10, FileSystem.f41986a);
    }

    public Cache(File file, long j10, FileSystem fileSystem) {
        this.f41233a = new InternalCache() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Cache.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public Response get(Request request) throws IOException {
                return Cache.this.a(request);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public CacheRequest put(Response response) throws IOException {
                return Cache.this.a(response);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public void remove(Request request) throws IOException {
                Cache.this.b(request);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public void trackConditionalCacheHit() {
                Cache.this.a();
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.a(cacheStrategy);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public void update(Response response, Response response2) {
                Cache.this.a(response, response2);
            }
        };
        this.f41234b = DiskLruCache.create(fileSystem, file, 201105, 2, j10);
    }

    public static int a(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= ZipUtils.UPPER_UNIXTIME_BOUND && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    public Response a(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.f41234b.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public CacheRequest a(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                b(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editor = this.f41234b.edit(key(response.request().url()));
            if (editor == null) {
                return null;
            }
            try {
                entry.writeTo(editor);
                return new CacheRequestImpl(editor);
            } catch (IOException unused2) {
                a(editor);
                return null;
            }
        } catch (IOException unused3) {
            editor = null;
        }
    }

    public synchronized void a() {
        this.f41238f++;
    }

    public void a(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).f41253a.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                    a(editor);
                }
            }
        } catch (IOException unused2) {
            editor = null;
        }
    }

    public synchronized void a(CacheStrategy cacheStrategy) {
        this.f41239g++;
        if (cacheStrategy.f41627a != null) {
            this.f41237e++;
        } else if (cacheStrategy.f41628b != null) {
            this.f41238f++;
        }
    }

    public void b(Request request) throws IOException {
        this.f41234b.remove(key(request.url()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f41234b.close();
    }

    public void delete() throws IOException {
        this.f41234b.delete();
    }

    public File directory() {
        return this.f41234b.getDirectory();
    }

    public void evictAll() throws IOException {
        this.f41234b.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f41234b.flush();
    }

    public synchronized int hitCount() {
        return this.f41238f;
    }

    public void initialize() throws IOException {
        this.f41234b.initialize();
    }

    public boolean isClosed() {
        return this.f41234b.isClosed();
    }

    public long maxSize() {
        return this.f41234b.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.f41237e;
    }

    public synchronized int requestCount() {
        return this.f41239g;
    }

    public long size() throws IOException {
        return this.f41234b.size();
    }

    public Iterator<String> urls() throws IOException {
        return new Iterator<String>() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Cache.2

            /* renamed from: a, reason: collision with root package name */
            public final Iterator<DiskLruCache.Snapshot> f41241a;

            /* renamed from: b, reason: collision with root package name */
            public String f41242b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f41243c;

            {
                this.f41241a = Cache.this.f41234b.snapshots();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f41242b != null) {
                    return true;
                }
                this.f41243c = false;
                while (this.f41241a.hasNext()) {
                    DiskLruCache.Snapshot next = this.f41241a.next();
                    try {
                        this.f41242b = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String str = this.f41242b;
                this.f41242b = null;
                this.f41243c = true;
                return str;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.f41243c) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.f41241a.remove();
            }
        };
    }

    public synchronized int writeAbortCount() {
        return this.f41236d;
    }

    public synchronized int writeSuccessCount() {
        return this.f41235c;
    }
}
