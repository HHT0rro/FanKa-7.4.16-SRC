package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements Closeable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private int aJP;
    private boolean aJQ;
    private long aJR;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    private void Jy() {
        if (this.aJP > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int read = this.stream.read(this.buf);
            this.aJP = read;
            if (read == 0) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.aJR += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException(e2));
        }
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public final int b(f fVar, int i10) {
        int i11 = 36;
        while (i11 > 0) {
            int a10 = a(fVar, i11);
            if (a10 <= 0) {
                return a10;
            }
            i11 -= a10;
        }
        return 36;
    }

    public final void bF(boolean z10) {
        this.aJQ = z10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.aJP = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.aJQ) {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
        this.stream = null;
    }

    private a(InputStream inputStream, int i10) {
        this.eof = false;
        this.aJQ = true;
        this.aJR = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    private int a(f fVar, int i10) {
        Jy();
        if (i10 <= 0 || i10 >= this.aJP) {
            i10 = this.aJP;
        }
        if (i10 > 0) {
            int b4 = fVar.b(this.buf, this.offset, i10);
            if (b4 > 0) {
                this.offset += b4;
                this.aJP -= b4;
            }
            if (b4 > 0) {
                return b4;
            }
            if (!fVar.isDone()) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen!"));
            }
            return -1;
        }
        if (!this.eof) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen"));
        }
        return fVar.isDone() ? -1 : 0;
    }
}
