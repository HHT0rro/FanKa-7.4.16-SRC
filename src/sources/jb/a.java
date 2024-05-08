package jb;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends InputStream {

    /* renamed from: b, reason: collision with root package name */
    public final InputStream f50553b;

    /* renamed from: c, reason: collision with root package name */
    public final int f50554c;

    public a(InputStream inputStream, int i10) {
        this.f50553b = inputStream;
        this.f50554c = i10;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f50554c;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f50553b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f50553b.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f50553b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f50553b.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f50553b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        return this.f50553b.skip(j10);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f50553b.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.f50553b.read(bArr, i10, i11);
    }
}
