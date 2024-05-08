package com.jd.ad.sdk.jad_gp;

import androidx.annotation.GuardedBy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_dq extends InputStream {

    @GuardedBy("POOL")
    public static final Queue<jad_dq> jad_cp;
    public InputStream jad_an;
    public IOException jad_bo;

    static {
        char[] cArr = jad_ly.jad_an;
        jad_cp = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.jad_an.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_an.close();
    }

    public void jad_bo() {
        this.jad_bo = null;
        this.jad_an = null;
        Queue<jad_dq> queue = jad_cp;
        synchronized (queue) {
            ((ArrayDeque) queue).offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.jad_an.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.jad_an.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.jad_an.read();
        } catch (IOException e2) {
            this.jad_bo = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.jad_an.read(bArr);
        } catch (IOException e2) {
            this.jad_bo = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        try {
            return this.jad_an.read(bArr, i10, i11);
        } catch (IOException e2) {
            this.jad_bo = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.jad_an.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        try {
            return this.jad_an.skip(j10);
        } catch (IOException e2) {
            this.jad_bo = e2;
            throw e2;
        }
    }
}
