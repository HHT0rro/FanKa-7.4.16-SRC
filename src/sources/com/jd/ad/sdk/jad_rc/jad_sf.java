package com.jd.ad.sdk.jad_rc;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_sf extends FilterInputStream {
    public volatile byte[] jad_an;
    public int jad_bo;
    public int jad_cp;
    public int jad_dq;
    public int jad_er;
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_fs;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_an extends IOException {
        public jad_an(String str) {
            super(str);
        }
    }

    public jad_sf(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        this(inputStream, jad_boVar, 65536);
    }

    @VisibleForTesting
    public jad_sf(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar, int i10) {
        super(inputStream);
        this.jad_dq = -1;
        this.jad_fs = jad_boVar;
        this.jad_an = (byte[]) jad_boVar.jad_an(i10, byte[].class);
    }

    public static IOException jad_cp() {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = this.in;
        if (this.jad_an == null || inputStream == null) {
            jad_cp();
            throw null;
        }
        return inputStream.available() + (this.jad_bo - this.jad_er);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.jad_an != null) {
            this.jad_fs.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) this.jad_an);
            this.jad_an = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final int jad_an(InputStream inputStream, byte[] bArr) {
        int i10 = this.jad_dq;
        if (i10 != -1) {
            int i11 = this.jad_er - i10;
            int i12 = this.jad_cp;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.jad_bo == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.jad_fs.jad_an(i12, byte[].class);
                    System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
                    this.jad_an = bArr2;
                    this.jad_fs.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy((Object) bArr, i10, (Object) bArr, 0, bArr.length - i10);
                }
                int i13 = this.jad_er - this.jad_dq;
                this.jad_er = i13;
                this.jad_dq = 0;
                this.jad_bo = 0;
                int read = inputStream.read(bArr, i13, bArr.length - i13);
                int i14 = this.jad_er;
                if (read > 0) {
                    i14 += read;
                }
                this.jad_bo = i14;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.jad_dq = -1;
            this.jad_er = 0;
            this.jad_bo = read2;
        }
        return read2;
    }

    public synchronized void jad_bo() {
        if (this.jad_an != null) {
            this.jad_fs.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) this.jad_an);
            this.jad_an = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.jad_cp = Math.max(this.jad_cp, i10);
        this.jad_dq = this.jad_er;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.jad_an;
        InputStream inputStream = this.in;
        if (bArr == null || inputStream == null) {
            jad_cp();
            throw null;
        }
        if (this.jad_er >= this.jad_bo && jad_an(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.jad_an && (bArr = this.jad_an) == null) {
            jad_cp();
            throw null;
        }
        int i10 = this.jad_bo;
        int i11 = this.jad_er;
        if (i10 - i11 <= 0) {
            return -1;
        }
        this.jad_er = i11 + 1;
        return bArr[i11] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        byte[] bArr2 = this.jad_an;
        if (bArr2 == null) {
            jad_cp();
            throw null;
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            jad_cp();
            throw null;
        }
        int i14 = this.jad_er;
        int i15 = this.jad_bo;
        if (i14 < i15) {
            int i16 = i15 - i14;
            if (i16 >= i11) {
                i16 = i11;
            }
            System.arraycopy((Object) bArr2, i14, (Object) bArr, i10, i16);
            this.jad_er += i16;
            if (i16 == i11 || inputStream.available() == 0) {
                return i16;
            }
            i10 += i16;
            i12 = i11 - i16;
        } else {
            i12 = i11;
        }
        while (true) {
            if (this.jad_dq == -1 && i12 >= bArr2.length) {
                i13 = inputStream.read(bArr, i10, i12);
                if (i13 == -1) {
                    return i12 != i11 ? i11 - i12 : -1;
                }
            } else {
                if (jad_an(inputStream, bArr2) == -1) {
                    return i12 != i11 ? i11 - i12 : -1;
                }
                if (bArr2 != this.jad_an && (bArr2 = this.jad_an) == null) {
                    jad_cp();
                    throw null;
                }
                int i17 = this.jad_bo;
                int i18 = this.jad_er;
                i13 = i17 - i18;
                if (i13 >= i12) {
                    i13 = i12;
                }
                System.arraycopy((Object) bArr2, i18, (Object) bArr, i10, i13);
                this.jad_er += i13;
            }
            i12 -= i13;
            if (i12 == 0) {
                return i11;
            }
            if (inputStream.available() == 0) {
                return i11 - i12;
            }
            i10 += i13;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.jad_an == null) {
            throw new IOException("Stream is closed");
        }
        int i10 = this.jad_dq;
        if (-1 == i10) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Mark has been invalidated, pos: ");
            jad_an2.append(this.jad_er);
            jad_an2.append(" markLimit: ");
            jad_an2.append(this.jad_cp);
            throw new jad_an(jad_an2.toString());
        }
        this.jad_er = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.jad_an;
        if (bArr == null) {
            jad_cp();
            throw null;
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            jad_cp();
            throw null;
        }
        int i10 = this.jad_bo;
        int i11 = this.jad_er;
        if (i10 - i11 >= j10) {
            this.jad_er = (int) (i11 + j10);
            return j10;
        }
        long j11 = i10 - i11;
        this.jad_er = i10;
        if (this.jad_dq == -1 || j10 > this.jad_cp) {
            long skip = inputStream.skip(j10 - j11);
            if (skip > 0) {
                this.jad_dq = -1;
            }
            return j11 + skip;
        }
        if (jad_an(inputStream, bArr) == -1) {
            return j11;
        }
        int i12 = this.jad_bo;
        int i13 = this.jad_er;
        if (i12 - i13 >= j10 - j11) {
            this.jad_er = (int) ((i13 + j10) - j11);
            return j10;
        }
        long j12 = (j11 + i12) - i13;
        this.jad_er = i12;
        return j12;
    }
}
