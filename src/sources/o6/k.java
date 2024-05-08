package o6;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataSourceInputStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k extends InputStream {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f52305b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f52306c;

    /* renamed from: g, reason: collision with root package name */
    public long f52310g;

    /* renamed from: e, reason: collision with root package name */
    public boolean f52308e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f52309f = false;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f52307d = new byte[1];

    public k(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.f52305b = aVar;
        this.f52306c = bVar;
    }

    public final void a() throws IOException {
        if (this.f52308e) {
            return;
        }
        this.f52305b.a(this.f52306c);
        this.f52308e = true;
    }

    public void b() throws IOException {
        a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f52309f) {
            return;
        }
        this.f52305b.close();
        this.f52309f = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f52307d) == -1) {
            return -1;
        }
        return this.f52307d[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        com.google.android.exoplayer2.util.a.g(!this.f52309f);
        a();
        int read = this.f52305b.read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        this.f52310g += read;
        return read;
    }
}
