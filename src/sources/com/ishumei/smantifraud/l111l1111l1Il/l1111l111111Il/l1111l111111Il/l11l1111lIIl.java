package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il;

import java.io.ByteArrayOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111lIIl extends ByteArrayOutputStream {
    private static final int l1111l111111Il = 256;
    private final l111l11111I1l l111l11111lIl;

    private l11l1111lIIl(l111l11111I1l l111l11111i1l) {
        this(l111l11111i1l, 256);
    }

    public l11l1111lIIl(l111l11111I1l l111l11111i1l, int i10) {
        this.l111l11111lIl = l111l11111i1l;
        this.buf = l111l11111i1l.l1111l111111Il(Math.max(i10, 256));
    }

    private void l1111l111111Il(int i10) {
        int i11 = this.count;
        if (i11 + i10 <= this.buf.length) {
            return;
        }
        byte[] l1111l111111Il2 = this.l111l11111lIl.l1111l111111Il((i11 + i10) << 1);
        System.arraycopy((Object) this.buf, 0, (Object) l1111l111111Il2, 0, this.count);
        this.l111l11111lIl.l1111l111111Il(this.buf);
        this.buf = l1111l111111Il2;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.l111l11111lIl.l1111l111111Il(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.l111l11111lIl.l1111l111111Il(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i10) {
        l1111l111111Il(1);
        super.write(i10);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i10, int i11) {
        l1111l111111Il(i11);
        super.write(bArr, i10, i11);
    }
}
