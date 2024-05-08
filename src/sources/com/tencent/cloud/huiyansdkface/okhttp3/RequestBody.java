package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Source;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class RequestBody {
    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public long contentLength() throws IOException {
                return byteString.size();
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        Objects.requireNonNull(file, "file == null");
        return new RequestBody() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.3
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Source source = null;
                try {
                    source = Okio.source(file);
                    bufferedSink.writeAll(source);
                } finally {
                    Util.closeQuietly(source);
                }
            }
        };
    }

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.f41604e;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(((Object) mediaType) + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i10, final int i11) {
        Objects.requireNonNull(bArr, "content == null");
        Util.checkOffsetAndCount(bArr.length, i10, i11);
        return new RequestBody() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.2
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public long contentLength() {
                return i11;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(bArr, i10, i11);
            }
        };
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;
}
