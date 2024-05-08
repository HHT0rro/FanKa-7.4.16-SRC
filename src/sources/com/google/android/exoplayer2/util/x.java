package com.google.android.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ReusableBufferedOutputStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x extends BufferedOutputStream {

    /* renamed from: b, reason: collision with root package name */
    public boolean f23037b;

    public x(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        a.g(this.f23037b);
        this.out = outputStream;
        this.count = 0;
        this.f23037b = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23037b = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            j0.K0(th);
        }
    }

    public x(OutputStream outputStream, int i10) {
        super(outputStream, i10);
    }
}
