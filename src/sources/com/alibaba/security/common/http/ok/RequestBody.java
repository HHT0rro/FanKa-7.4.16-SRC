package com.alibaba.security.common.http.ok;

import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.okio.BufferedSink;
import com.alibaba.security.common.http.okio.ByteString;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.common.http.okio.Source;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class RequestBody {
    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
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

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: com.alibaba.security.common.http.ok.RequestBody.1
            @Override // com.alibaba.security.common.http.ok.RequestBody
            public long contentLength() throws IOException {
                return byteString.size();
            }

            @Override // com.alibaba.security.common.http.ok.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.alibaba.security.common.http.ok.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i10, final int i11) {
        Objects.requireNonNull(bArr, "content == null");
        Util.checkOffsetAndCount(bArr.length, i10, i11);
        return new RequestBody() { // from class: com.alibaba.security.common.http.ok.RequestBody.2
            @Override // com.alibaba.security.common.http.ok.RequestBody
            public long contentLength() {
                return i11;
            }

            @Override // com.alibaba.security.common.http.ok.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.alibaba.security.common.http.ok.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(bArr, i10, i11);
            }
        };
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        Objects.requireNonNull(file, "file == null");
        return new RequestBody() { // from class: com.alibaba.security.common.http.ok.RequestBody.3
            @Override // com.alibaba.security.common.http.ok.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // com.alibaba.security.common.http.ok.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.alibaba.security.common.http.ok.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Source source = null;
                try {
                    source = RPOkio.source(file);
                    bufferedSink.writeAll(source);
                } finally {
                    Util.closeQuietly(source);
                }
            }
        };
    }
}
