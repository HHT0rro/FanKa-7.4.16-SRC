package fb;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public final InputStream f49281b;

    /* renamed from: c, reason: collision with root package name */
    public final Charset f49282c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f49283d;

    /* renamed from: e, reason: collision with root package name */
    public int f49284e;

    /* renamed from: f, reason: collision with root package name */
    public int f49285f;

    /* compiled from: StrictLineReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = this.count;
            if (i10 > 0 && this.buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(this.buf, 0, i10, c.this.f49282c.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void b() throws IOException {
        InputStream inputStream = this.f49281b;
        byte[] bArr = this.f49283d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f49284e = 0;
            this.f49285f = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f49281b) {
            if (this.f49283d != null) {
                this.f49283d = null;
                this.f49281b.close();
            }
        }
    }

    public String d() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f49281b) {
            if (this.f49283d != null) {
                if (this.f49284e >= this.f49285f) {
                    b();
                }
                for (int i12 = this.f49284e; i12 != this.f49285f; i12++) {
                    byte[] bArr2 = this.f49283d;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f49284e;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.f49282c.name());
                                this.f49284e = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.f49282c.name());
                        this.f49284e = i12 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f49285f - this.f49284e) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f49283d;
                    int i14 = this.f49284e;
                    aVar.write(bArr3, i14, this.f49285f - i14);
                    this.f49285f = -1;
                    b();
                    i10 = this.f49284e;
                    while (i10 != this.f49285f) {
                        bArr = this.f49283d;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f49284e;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f49284e = i10 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public c(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 >= 0) {
            if (charset.equals(d.f49287a)) {
                this.f49281b = inputStream;
                this.f49282c = charset;
                this.f49283d = new byte[i10];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
