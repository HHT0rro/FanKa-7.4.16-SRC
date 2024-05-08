package com.amap.api.col.p0003l;

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
public final class hu implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f6300a = Charset.forName(CharEncoding.US_ASCII);

    /* renamed from: b, reason: collision with root package name */
    private final InputStream f6301b;

    /* renamed from: c, reason: collision with root package name */
    private final Charset f6302c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f6303d;

    /* renamed from: e, reason: collision with root package name */
    private int f6304e;

    /* renamed from: f, reason: collision with root package name */
    private int f6305f;

    public hu(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f6301b;
        byte[] bArr = this.f6303d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f6304e = 0;
            this.f6305f = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f6301b) {
            if (this.f6303d != null) {
                this.f6303d = null;
                this.f6301b.close();
            }
        }
    }

    private hu(InputStream inputStream, Charset charset, byte b4) {
        if (inputStream != null && charset != null) {
            if (charset.equals(f6300a)) {
                this.f6301b = inputStream;
                this.f6302c = charset;
                this.f6303d = new byte[8192];
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
        synchronized (this.f6301b) {
            if (this.f6303d != null) {
                if (this.f6304e >= this.f6305f) {
                    b();
                }
                for (int i12 = this.f6304e; i12 != this.f6305f; i12++) {
                    byte[] bArr2 = this.f6303d;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f6304e;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.f6302c.name());
                                this.f6304e = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.f6302c.name());
                        this.f6304e = i12 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f6305f - this.f6304e) + 80) { // from class: com.amap.api.col.3l.hu.1
                    @Override // java.io.ByteArrayOutputStream
                    public final String toString() {
                        int i14 = this.count;
                        if (i14 > 0 && this.buf[i14 - 1] == 13) {
                            i14--;
                        }
                        try {
                            return new String(this.buf, 0, i14, hu.this.f6302c.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.f6303d;
                    int i14 = this.f6304e;
                    byteArrayOutputStream.write(bArr3, i14, this.f6305f - i14);
                    this.f6305f = -1;
                    b();
                    i10 = this.f6304e;
                    while (i10 != this.f6305f) {
                        bArr = this.f6303d;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f6304e;
                if (i10 != i15) {
                    byteArrayOutputStream.write(bArr, i15, i10 - i15);
                }
                this.f6304e = i10 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }
}
