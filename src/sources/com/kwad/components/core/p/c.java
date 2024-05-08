package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends InputStream {
    private InputStream Sm;
    private int Sn;
    private volatile float Sp;
    private volatile long Sq;
    private int Sj = -1;
    private int Sk = 10000;
    private long Sl = -1;
    private long So = -1;
    private int Sr = 20480;

    public c(@NonNull InputStream inputStream, int i10) {
        i10 = i10 < 20480 ? 20480 : i10;
        this.Sm = inputStream;
        this.Sp = i10 / 1000.0f;
    }

    @WorkerThread
    private static void H(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private static long g(long j10, long j11) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j11 <= 0) {
            return -1L;
        }
        return j10 / j11;
    }

    private void qF() {
        this.Sj = 0;
        this.Sl = System.currentTimeMillis();
    }

    private void qG() {
        if (this.Sj < this.Sk) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = currentTimeMillis - this.Sl;
        float f10 = this.Sj / this.Sp;
        this.Sq = g(this.Sn, currentTimeMillis - this.So);
        if (f10 > ((float) j10)) {
            H(f10 - r0);
        }
        qF();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.Sm.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.Sm.close();
        b.a(this);
        this.So = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i10) {
        this.Sm.mark(i10);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.Sm.markSupported();
    }

    public final long qE() {
        return this.Sq;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.So <= 0) {
            this.So = System.currentTimeMillis();
        }
        this.Sn++;
        if (!(b.Sh && b.Sg)) {
            return this.Sm.read();
        }
        if (this.Sj < 0) {
            qF();
        }
        int read = this.Sm.read();
        this.Sj++;
        qG();
        return read;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.Sm.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j10) {
        return this.Sm.skip(j10);
    }
}
