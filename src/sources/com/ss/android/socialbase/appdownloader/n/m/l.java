package com.ss.android.socialbase.appdownloader.n.m;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private boolean dk;
    private int ej;

    /* renamed from: m, reason: collision with root package name */
    private InputStream f38932m;

    public l() {
    }

    public final int dk() throws IOException {
        return m(4);
    }

    public final void ej(int i10) throws IOException {
        if (i10 > 0) {
            long j10 = i10;
            long skip = this.f38932m.skip(j10);
            this.ej = (int) (this.ej + skip);
            if (skip != j10) {
                throw new EOFException();
            }
        }
    }

    public final void m(InputStream inputStream, boolean z10) {
        this.f38932m = inputStream;
        this.dk = z10;
        this.ej = 0;
    }

    public l(InputStream inputStream, boolean z10) {
        m(inputStream, z10);
    }

    public final int[] dk(int i10) throws IOException {
        int[] iArr = new int[i10];
        m(iArr, 0, i10);
        return iArr;
    }

    public final void ej() throws IOException {
        ej(4);
    }

    public final void m() {
        InputStream inputStream = this.f38932m;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            m(null, false);
        }
    }

    public final int m(int i10) throws IOException {
        if (i10 >= 0 && i10 <= 4) {
            int i11 = 0;
            if (this.dk) {
                for (int i12 = (i10 - 1) * 8; i12 >= 0; i12 -= 8) {
                    int read = this.f38932m.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.ej++;
                    i11 |= read << i12;
                }
                return i11;
            }
            int i13 = i10 * 8;
            int i14 = 0;
            while (i11 != i13) {
                int read2 = this.f38932m.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.ej++;
                i14 |= read2 << i11;
                i11 += 8;
            }
            return i14;
        }
        throw new IllegalArgumentException();
    }

    public final void m(int[] iArr, int i10, int i11) throws IOException {
        while (i11 > 0) {
            iArr[i10] = dk();
            i11--;
            i10++;
        }
    }
}
