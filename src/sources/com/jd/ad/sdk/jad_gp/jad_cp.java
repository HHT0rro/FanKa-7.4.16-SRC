package com.jd.ad.sdk.jad_gp;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_cp extends FilterInputStream {
    public final long jad_an;
    public int jad_bo;

    public jad_cp(@NonNull InputStream inputStream, long j10) {
        super(inputStream);
        this.jad_an = j10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.jad_an - this.jad_bo, this.in.available());
    }

    public final int jad_an(int i10) {
        if (i10 >= 0) {
            this.jad_bo += i10;
        } else if (this.jad_an - this.jad_bo > 0) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Failed to read all expected data, expected: ");
            jad_an.append(this.jad_an);
            jad_an.append(", but read: ");
            jad_an.append(this.jad_bo);
            throw new IOException(jad_an.toString());
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        jad_an(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int jad_an;
        int length = bArr.length;
        synchronized (this) {
            jad_an = jad_an(super.read(bArr, 0, length));
        }
        return jad_an;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) {
        return jad_an(super.read(bArr, i10, i11));
    }
}
