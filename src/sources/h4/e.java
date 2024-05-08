package h4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e extends FilterInputStream implements d {

    /* renamed from: b, reason: collision with root package name */
    public int f49499b;

    public e(InputStream inputStream) {
        super(inputStream);
        try {
            inputStream.reset();
        } catch (IOException unused) {
        }
    }

    @Override // h4.d
    public InputStream a() throws IOException {
        return this;
    }

    @Override // h4.d
    public int b() {
        return this.f49499b;
    }

    @Override // h4.d
    public byte peek() throws IOException {
        byte read = (byte) read();
        this.f49499b++;
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = super.read(bArr, i10, i11);
        this.f49499b += Math.max(0, read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f49499b = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long j11 = j10;
        while (j11 > 0) {
            long skip = super.skip(j11);
            if (skip > 0) {
                j11 -= skip;
            } else {
                if (super.read() == -1) {
                    break;
                }
                j11--;
            }
        }
        long j12 = j10 - j11;
        this.f49499b = (int) (this.f49499b + j12);
        return j12;
    }
}
