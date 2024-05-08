package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class ResponseBody implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private Reader f41580a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class BomAwareReader extends Reader {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedSource f41584a;

        /* renamed from: b, reason: collision with root package name */
        private final Charset f41585b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f41586c;

        /* renamed from: d, reason: collision with root package name */
        private Reader f41587d;

        public BomAwareReader(BufferedSource bufferedSource, Charset charset) {
            this.f41584a = bufferedSource;
            this.f41585b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f41586c = true;
            Reader reader = this.f41587d;
            if (reader != null) {
                reader.close();
            } else {
                this.f41584a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) throws IOException {
            if (this.f41586c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f41587d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f41584a.inputStream(), Util.bomAwareCharset(this.f41584a, this.f41585b));
                this.f41587d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i10, i11);
        }
    }

    private Charset a() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.f41604e) : Util.f41604e;
    }

    public static ResponseBody create(final MediaType mediaType, final long j10, final BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        return new ResponseBody() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
            public long contentLength() {
                return j10;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
            public BufferedSource source() {
                return bufferedSource;
            }
        };
    }

    public static ResponseBody create(MediaType mediaType, ByteString byteString) {
        return create(mediaType, byteString.size(), new Buffer().write(byteString));
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.f41604e;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(((Object) mediaType) + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        Buffer writeString = new Buffer().writeString(str, charset);
        return create(mediaType, writeString.size(), writeString);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new Buffer().write(bArr));
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        BufferedSource source = source();
        try {
            byte[] readByteArray = source.readByteArray();
            Util.closeQuietly(source);
            if (contentLength == -1 || contentLength == readByteArray.length) {
                return readByteArray;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + readByteArray.length + ") disagree");
        } catch (Throwable th) {
            Util.closeQuietly(source);
            throw th;
        }
    }

    public final Reader charStream() {
        Reader reader = this.f41580a;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), a());
        this.f41580a = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        BufferedSource source = source();
        try {
            return source.readString(Util.bomAwareCharset(source, a()));
        } finally {
            Util.closeQuietly(source);
        }
    }
}
