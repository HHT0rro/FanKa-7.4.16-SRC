package com.jd.ad.sdk.jad_gp;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_iv extends FilterInputStream {
    public int jad_an;

    public jad_iv(@NonNull InputStream inputStream) {
        super(inputStream);
        this.jad_an = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i10 = this.jad_an;
        return i10 == Integer.MIN_VALUE ? super.available() : Math.min(i10, super.available());
    }

    public final long jad_bo(long j10) {
        int i10 = this.jad_an;
        if (i10 == 0) {
            return -1L;
        }
        if (i10 != Integer.MIN_VALUE) {
            long j11 = i10;
            if (j10 > j11) {
                return j11;
            }
        }
        return j10;
    }

    public final void jad_cp(long j10) {
        int i10 = this.jad_an;
        if (i10 == Integer.MIN_VALUE || j10 == -1) {
            return;
        }
        this.jad_an = (int) (i10 - j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        super.mark(i10);
        this.jad_an = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (jad_bo(1L) == -1) {
            return -1;
        }
        int read = super.read();
        jad_cp(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i10, int i11) {
        int jad_bo = (int) jad_bo(i11);
        if (jad_bo == -1) {
            return -1;
        }
        int read = super.read(bArr, i10, jad_bo);
        jad_cp(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.jad_an = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        long jad_bo = jad_bo(j10);
        if (jad_bo == -1) {
            return 0L;
        }
        long skip = super.skip(jad_bo);
        jad_cp(skip);
        return skip;
    }
}
