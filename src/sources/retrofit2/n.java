package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: RequestBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class n {

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f53497l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f53498m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    public final String f53499a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpUrl f53500b;

    /* renamed from: c, reason: collision with root package name */
    public String f53501c;

    /* renamed from: d, reason: collision with root package name */
    public HttpUrl.Builder f53502d;

    /* renamed from: e, reason: collision with root package name */
    public final Request.Builder f53503e = new Request.Builder();

    /* renamed from: f, reason: collision with root package name */
    public final Headers.Builder f53504f;

    /* renamed from: g, reason: collision with root package name */
    public MediaType f53505g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f53506h;

    /* renamed from: i, reason: collision with root package name */
    public MultipartBody.Builder f53507i;

    /* renamed from: j, reason: collision with root package name */
    public FormBody.Builder f53508j;

    /* renamed from: k, reason: collision with root package name */
    public RequestBody f53509k;

    /* compiled from: RequestBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        public final RequestBody f53510a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaType f53511b;

        public a(RequestBody requestBody, MediaType mediaType) {
            this.f53510a = requestBody;
            this.f53511b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f53510a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f53511b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.f53510a.writeTo(bufferedSink);
        }
    }

    public n(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z10, boolean z11, boolean z12) {
        this.f53499a = str;
        this.f53500b = httpUrl;
        this.f53501c = str2;
        this.f53505g = mediaType;
        this.f53506h = z10;
        if (headers != null) {
            this.f53504f = headers.newBuilder();
        } else {
            this.f53504f = new Headers.Builder();
        }
        if (z11) {
            this.f53508j = new FormBody.Builder();
        } else if (z12) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f53507i = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    public static String i(String str, boolean z10) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z10 || (codePointAt != 47 && codePointAt != 37))) {
                i10 += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i10);
                j(buffer, str, i10, length, z10);
                return buffer.readUtf8();
            }
        }
        return str;
    }

    public static void j(Buffer buffer, String str, int i10, int i11, boolean z10) {
        Buffer buffer2 = null;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (!z10 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z10 || (codePointAt != 47 && codePointAt != 37))) {
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = f53497l;
                        buffer.writeByte((int) cArr[(readByte >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                }
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    public void a(String str, String str2, boolean z10) {
        if (z10) {
            this.f53508j.addEncoded(str, str2);
        } else {
            this.f53508j.add(str, str2);
        }
    }

    public void b(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.f53505g = MediaType.get(str2);
                return;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        }
        this.f53504f.add(str, str2);
    }

    public void c(Headers headers) {
        this.f53504f.addAll(headers);
    }

    public void d(Headers headers, RequestBody requestBody) {
        this.f53507i.addPart(headers, requestBody);
    }

    public void e(MultipartBody.Part part) {
        this.f53507i.addPart(part);
    }

    public void f(String str, String str2, boolean z10) {
        if (this.f53501c != null) {
            String i10 = i(str2, z10);
            String replace = this.f53501c.replace("{" + str + com.alipay.sdk.util.i.f4738d, i10);
            if (!f53498m.matcher(replace).matches()) {
                this.f53501c = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    public void g(String str, String str2, boolean z10) {
        String str3 = this.f53501c;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.f53500b.newBuilder(str3);
            this.f53502d = newBuilder;
            if (newBuilder != null) {
                this.f53501c = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + ((Object) this.f53500b) + ", Relative: " + this.f53501c);
            }
        }
        if (z10) {
            this.f53502d.addEncodedQueryParameter(str, str2);
        } else {
            this.f53502d.addQueryParameter(str, str2);
        }
    }

    public <T> void h(Class<T> cls, T t2) {
        this.f53503e.tag(cls, t2);
    }

    public Request.Builder k() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.f53502d;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.f53500b.resolve(this.f53501c);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + ((Object) this.f53500b) + ", Relative: " + this.f53501c);
            }
        }
        RequestBody requestBody = this.f53509k;
        if (requestBody == null) {
            FormBody.Builder builder2 = this.f53508j;
            if (builder2 != null) {
                requestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f53507i;
                if (builder3 != null) {
                    requestBody = builder3.build();
                } else if (this.f53506h) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f53505g;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new a(requestBody, mediaType);
            } else {
                this.f53504f.add("Content-Type", mediaType.toString());
            }
        }
        return this.f53503e.url(resolve).headers(this.f53504f.build()).method(this.f53499a, requestBody);
    }

    public void l(RequestBody requestBody) {
        this.f53509k = requestBody;
    }

    public void m(Object obj) {
        this.f53501c = obj.toString();
    }
}
