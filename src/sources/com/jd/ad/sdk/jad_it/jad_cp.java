package com.jd.ad.sdk.jad_it;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_cp extends OutputStream {

    @NonNull
    public final OutputStream jad_an;
    public byte[] jad_bo;
    public com.jd.ad.sdk.jad_lw.jad_bo jad_cp;
    public int jad_dq;

    @VisibleForTesting
    public jad_cp(@NonNull OutputStream outputStream, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar, int i10) {
        this.jad_an = outputStream;
        this.jad_cp = jad_boVar;
        this.jad_bo = (byte[]) jad_boVar.jad_an(i10, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.jad_an.close();
            byte[] bArr = this.jad_bo;
            if (bArr != null) {
                this.jad_cp.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
                this.jad_bo = null;
            }
        } catch (Throwable th) {
            this.jad_an.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        int i10 = this.jad_dq;
        if (i10 > 0) {
            this.jad_an.write(this.jad_bo, 0, i10);
            this.jad_dq = 0;
        }
        this.jad_an.flush();
    }

    public final void jad_bo() {
        int i10 = this.jad_dq;
        byte[] bArr = this.jad_bo;
        if (i10 != bArr.length || i10 <= 0) {
            return;
        }
        this.jad_an.write(bArr, 0, i10);
        this.jad_dq = 0;
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        byte[] bArr = this.jad_bo;
        int i11 = this.jad_dq;
        this.jad_dq = i11 + 1;
        bArr[i11] = (byte) i10;
        jad_bo();
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i10, int i11) {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.jad_dq;
            if (i15 == 0 && i13 >= this.jad_bo.length) {
                this.jad_an.write(bArr, i14, i13);
                return;
            }
            int min = Math.min(i13, this.jad_bo.length - i15);
            System.arraycopy((Object) bArr, i14, (Object) this.jad_bo, this.jad_dq, min);
            this.jad_dq += min;
            i12 += min;
            jad_bo();
        } while (i12 < i11);
    }
}
