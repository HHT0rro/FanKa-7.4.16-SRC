package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class MultipartBody extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    public static final MediaType f41446a = MediaType.get("multipart/mixed");

    /* renamed from: b, reason: collision with root package name */
    public static final MediaType f41447b = MediaType.get("multipart/alternative");

    /* renamed from: c, reason: collision with root package name */
    public static final MediaType f41448c = MediaType.get("multipart/digest");

    /* renamed from: d, reason: collision with root package name */
    public static final MediaType f41449d = MediaType.get("multipart/parallel");

    /* renamed from: e, reason: collision with root package name */
    public static final MediaType f41450e = MediaType.get("multipart/form-data");

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f41451f = {58, 32};

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f41452g = {13, 10};

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f41453h = {45, 45};

    /* renamed from: i, reason: collision with root package name */
    private final ByteString f41454i;

    /* renamed from: j, reason: collision with root package name */
    private final MediaType f41455j;

    /* renamed from: k, reason: collision with root package name */
    private final MediaType f41456k;

    /* renamed from: l, reason: collision with root package name */
    private final List<Part> f41457l;

    /* renamed from: m, reason: collision with root package name */
    private long f41458m = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final ByteString f41459a;

        /* renamed from: b, reason: collision with root package name */
        private MediaType f41460b;

        /* renamed from: c, reason: collision with root package name */
        private final List<Part> f41461c;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.f41460b = MultipartBody.f41446a;
            this.f41461c = new ArrayList();
            this.f41459a = ByteString.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            Objects.requireNonNull(part, "part == null");
            this.f41461c.add(part);
            return this;
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (this.f41461c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.f41459a, this.f41460b, this.f41461c);
        }

        public Builder setType(MediaType mediaType) {
            Objects.requireNonNull(mediaType, "type == null");
            if (mediaType.type().equals("multipart")) {
                this.f41460b = mediaType;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + ((Object) mediaType));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Part {

        /* renamed from: a, reason: collision with root package name */
        public final Headers f41462a;

        /* renamed from: b, reason: collision with root package name */
        public final RequestBody f41463b;

        private Part(Headers headers, RequestBody requestBody) {
            this.f41462a = headers;
            this.f41463b = requestBody;
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            Objects.requireNonNull(requestBody, "body == null");
            if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers == null || headers.get("Content-Length") == null) {
                return new Part(headers, requestBody);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create((MediaType) null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb2 = new StringBuilder("form-data; name=");
            MultipartBody.a(sb2, str);
            if (str2 != null) {
                sb2.append("; filename=");
                MultipartBody.a(sb2, str2);
            }
            return create(Headers.of("Content-Disposition", sb2.toString()), requestBody);
        }

        public RequestBody body() {
            return this.f41463b;
        }

        public Headers headers() {
            return this.f41462a;
        }
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.f41454i = byteString;
        this.f41455j = mediaType;
        this.f41456k = MediaType.get(((Object) mediaType) + "; boundary=" + byteString.utf8());
        this.f41457l = Util.immutableList(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(BufferedSink bufferedSink, boolean z10) throws IOException {
        Buffer buffer;
        if (z10) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.f41457l.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Part part = this.f41457l.get(i10);
            Headers headers = part.f41462a;
            RequestBody requestBody = part.f41463b;
            bufferedSink.write(f41453h);
            bufferedSink.write(this.f41454i);
            bufferedSink.write(f41452g);
            if (headers != null) {
                int size2 = headers.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    bufferedSink.writeUtf8(headers.name(i11)).write(f41451f).writeUtf8(headers.value(i11)).write(f41452g);
                }
            }
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(f41452g);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(f41452g);
            } else if (z10) {
                buffer.clear();
                return -1L;
            }
            byte[] bArr = f41452g;
            bufferedSink.write(bArr);
            if (z10) {
                j10 += contentLength;
            } else {
                requestBody.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        byte[] bArr2 = f41453h;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.f41454i);
        bufferedSink.write(bArr2);
        bufferedSink.write(f41452g);
        if (!z10) {
            return j10;
        }
        long size3 = j10 + buffer.size();
        buffer.clear();
        return size3;
    }

    public static StringBuilder a(StringBuilder sb2, String str) {
        String str2;
        sb2.append('\"');
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '\n') {
                str2 = "%0A";
            } else if (charAt == '\r') {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb2.append(charAt);
            } else {
                str2 = "%22";
            }
            sb2.append(str2);
        }
        sb2.append('\"');
        return sb2;
    }

    public String boundary() {
        return this.f41454i.utf8();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j10 = this.f41458m;
        if (j10 != -1) {
            return j10;
        }
        long a10 = a((BufferedSink) null, true);
        this.f41458m = a10;
        return a10;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public MediaType contentType() {
        return this.f41456k;
    }

    public Part part(int i10) {
        return this.f41457l.get(i10);
    }

    public List<Part> parts() {
        return this.f41457l;
    }

    public int size() {
        return this.f41457l.size();
    }

    public MediaType type() {
        return this.f41455j;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        a(bufferedSink, false);
    }
}
