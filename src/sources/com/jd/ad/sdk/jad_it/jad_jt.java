package com.jd.ad.sdk.jad_it;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.ObjectStreamConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jt extends FilterInputStream {
    public static final byte[] jad_cp = {-1, ExifInterface.MARKER_APP1, 0, 28, 69, ObjectStreamConstants.TC_ENDBLOCKDATA, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    public final byte jad_an;
    public int jad_bo;

    public jad_jt(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 >= -1 && i10 <= 8) {
            this.jad_an = (byte) i10;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i10 = this.jad_bo;
        int read = (i10 < 2 || i10 > 31) ? super.read() : i10 == 31 ? this.jad_an : jad_cp[i10 - 2] & 255;
        if (read != -1) {
            this.jad_bo++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = this.jad_bo;
        if (i13 > 31) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == 31) {
            bArr[i10] = this.jad_an;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int min = Math.min(31 - i13, i11);
            System.arraycopy((Object) jad_cp, this.jad_bo - 2, (Object) bArr, i10, min);
            i12 = min;
        }
        if (i12 > 0) {
            this.jad_bo += i12;
        }
        return i12;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        long skip = super.skip(j10);
        if (skip > 0) {
            this.jad_bo = (int) (this.jad_bo + skip);
        }
        return skip;
    }
}
