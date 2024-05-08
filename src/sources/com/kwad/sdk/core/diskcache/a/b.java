package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements Closeable {
    private final Charset auf;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void Db() {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(this.in);
            }
        }
    }

    public final String readLine() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.in) {
            if (this.buf != null) {
                if (this.pos >= this.end) {
                    Db();
                }
                for (int i12 = this.pos; i12 != this.end; i12++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i12] == 10) {
                        int i13 = this.pos;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.auf.name());
                                this.pos = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.auf.name());
                        this.pos = i12 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public final String toString() {
                        int i14 = this.count;
                        if (i14 > 0 && this.buf[i14 - 1] == 13) {
                            i14--;
                        }
                        try {
                            return new String(this.buf, 0, i14, b.this.auf.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.buf;
                    int i14 = this.pos;
                    byteArrayOutputStream.write(bArr3, i14, this.end - i14);
                    this.end = -1;
                    Db();
                    i10 = this.pos;
                    while (i10 != this.end) {
                        bArr = this.buf;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.pos;
                if (i10 != i15) {
                    byteArrayOutputStream.write(bArr, i15, i10 - i15);
                }
                this.pos = i10 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    private b(InputStream inputStream, int i10, Charset charset) {
        if (inputStream != null && charset != null) {
            if (charset.equals(com.kwad.sdk.crash.utils.a.US_ASCII)) {
                this.in = inputStream;
                this.auf = charset;
                this.buf = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }
}
