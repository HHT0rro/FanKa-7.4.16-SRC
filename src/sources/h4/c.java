package h4;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: FilterReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class c implements d {

    /* renamed from: b, reason: collision with root package name */
    public d f49498b;

    public c(d dVar) {
        this.f49498b = dVar;
    }

    @Override // h4.d
    public InputStream a() throws IOException {
        reset();
        return this.f49498b.a();
    }

    @Override // h4.d
    public int available() throws IOException {
        return this.f49498b.available();
    }

    @Override // h4.d
    public int b() {
        return this.f49498b.b();
    }

    @Override // h4.d
    public void close() throws IOException {
        this.f49498b.close();
    }

    @Override // h4.d
    public byte peek() throws IOException {
        return this.f49498b.peek();
    }

    @Override // h4.d
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.f49498b.read(bArr, i10, i11);
    }

    @Override // h4.d
    public void reset() throws IOException {
        this.f49498b.reset();
    }

    @Override // h4.d
    public long skip(long j10) throws IOException {
        return this.f49498b.skip(j10);
    }
}
