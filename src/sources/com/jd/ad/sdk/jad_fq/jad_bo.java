package com.jd.ad.sdk.jad_fq;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo implements Closeable {
    public final InputStream jad_an;
    public final Charset jad_bo;
    public byte[] jad_cp;
    public int jad_dq;
    public int jad_er;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an extends ByteArrayOutputStream {
        public jad_an(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = this.count;
            if (i10 > 0) {
                int i11 = i10 - 1;
                if (this.buf[i11] == 13) {
                    i10 = i11;
                }
            }
            try {
                return new String(this.buf, 0, i10, jad_bo.this.jad_bo.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public jad_bo(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(jad_cp.jad_an)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.jad_an = inputStream;
        this.jad_bo = charset;
        this.jad_cp = new byte[i10];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.jad_an) {
            if (this.jad_cp != null) {
                this.jad_cp = null;
                this.jad_an.close();
            }
        }
    }

    public final void jad_bo() {
        InputStream inputStream = this.jad_an;
        byte[] bArr = this.jad_cp;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.jad_dq = 0;
        this.jad_er = read;
    }

    public String jad_cp() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.jad_an) {
            if (this.jad_cp == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.jad_dq >= this.jad_er) {
                jad_bo();
            }
            for (int i12 = this.jad_dq; i12 != this.jad_er; i12++) {
                byte[] bArr2 = this.jad_cp;
                if (bArr2[i12] == 10) {
                    int i13 = this.jad_dq;
                    if (i12 != i13) {
                        i11 = i12 - 1;
                        if (bArr2[i11] == 13) {
                            String str = new String(bArr2, i13, i11 - i13, this.jad_bo.name());
                            this.jad_dq = i12 + 1;
                            return str;
                        }
                    }
                    i11 = i12;
                    String str2 = new String(bArr2, i13, i11 - i13, this.jad_bo.name());
                    this.jad_dq = i12 + 1;
                    return str2;
                }
            }
            jad_an jad_anVar = new jad_an((this.jad_er - this.jad_dq) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.jad_cp;
                int i14 = this.jad_dq;
                jad_anVar.write(bArr3, i14, this.jad_er - i14);
                this.jad_er = -1;
                jad_bo();
                i10 = this.jad_dq;
                while (i10 != this.jad_er) {
                    bArr = this.jad_cp;
                    if (bArr[i10] == 10) {
                        break loop1;
                    }
                    i10++;
                }
            }
            int i15 = this.jad_dq;
            if (i10 != i15) {
                jad_anVar.write(bArr, i15, i10 - i15);
            }
            this.jad_dq = i10 + 1;
            return jad_anVar.toString();
        }
    }
}
