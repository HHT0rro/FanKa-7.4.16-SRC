package i5;

import java.io.IOException;

/* compiled from: VarintReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f49801d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f49802a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public int f49803b;

    /* renamed from: c, reason: collision with root package name */
    public int f49804c;

    public static long a(byte[] bArr, int i10, boolean z10) {
        long j10 = bArr[0] & 255;
        if (z10) {
            j10 &= ~f49801d[i10 - 1];
        }
        for (int i11 = 1; i11 < i10; i11++) {
            j10 = (j10 << 8) | (bArr[i11] & 255);
        }
        return j10;
    }

    public static int c(int i10) {
        int i11 = 0;
        while (true) {
            long[] jArr = f49801d;
            if (i11 >= jArr.length) {
                return -1;
            }
            if ((jArr[i11] & i10) != 0) {
                return i11 + 1;
            }
            i11++;
        }
    }

    public int b() {
        return this.f49804c;
    }

    public long d(d5.d dVar, boolean z10, boolean z11, int i10) throws IOException {
        if (this.f49803b == 0) {
            if (!dVar.f(this.f49802a, 0, 1, z10)) {
                return -1L;
            }
            int c4 = c(this.f49802a[0] & 255);
            this.f49804c = c4;
            if (c4 != -1) {
                this.f49803b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i11 = this.f49804c;
        if (i11 > i10) {
            this.f49803b = 0;
            return -2L;
        }
        if (i11 != 1) {
            dVar.readFully(this.f49802a, 1, i11 - 1);
        }
        this.f49803b = 0;
        return a(this.f49802a, this.f49804c, z11);
    }

    public void e() {
        this.f49803b = 0;
        this.f49804c = 0;
    }
}
