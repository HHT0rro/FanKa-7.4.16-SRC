package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: StrictLineReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dr implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f7732a = Charset.forName(CharEncoding.US_ASCII);

    /* renamed from: b, reason: collision with root package name */
    private final InputStream f7733b;

    /* renamed from: c, reason: collision with root package name */
    private final Charset f7734c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f7735d;

    /* renamed from: e, reason: collision with root package name */
    private int f7736e;

    /* renamed from: f, reason: collision with root package name */
    private int f7737f;

    public dr(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f7733b;
        byte[] bArr = this.f7735d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f7736e = 0;
            this.f7737f = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f7733b) {
            if (this.f7735d != null) {
                this.f7735d = null;
                this.f7733b.close();
            }
        }
    }

    private dr(InputStream inputStream, Charset charset, byte b4) {
        if (inputStream != null && charset != null) {
            if (charset.equals(f7732a)) {
                this.f7733b = inputStream;
                this.f7734c = charset;
                this.f7735d = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }

    public final String a() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f7733b) {
            if (this.f7735d != null) {
                if (this.f7736e >= this.f7737f) {
                    b();
                }
                for (int i12 = this.f7736e; i12 != this.f7737f; i12++) {
                    byte[] bArr2 = this.f7735d;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f7736e;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.f7734c.name());
                                this.f7736e = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.f7734c.name());
                        this.f7736e = i12 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f7737f - this.f7736e) + 80) { // from class: com.amap.api.col.s.dr.1
                    @Override // java.io.ByteArrayOutputStream
                    public final String toString() {
                        int i14 = this.count;
                        if (i14 > 0 && this.buf[i14 - 1] == 13) {
                            i14--;
                        }
                        try {
                            return new String(this.buf, 0, i14, dr.this.f7734c.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.f7735d;
                    int i14 = this.f7736e;
                    byteArrayOutputStream.write(bArr3, i14, this.f7737f - i14);
                    this.f7737f = -1;
                    b();
                    i10 = this.f7736e;
                    while (i10 != this.f7737f) {
                        bArr = this.f7735d;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f7736e;
                if (i10 != i15) {
                    byteArrayOutputStream.write(bArr, i15, i10 - i15);
                }
                this.f7736e = i10 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }
}
