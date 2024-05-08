package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.j0;

/* compiled from: FixedSampleSizeRechunker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* compiled from: FixedSampleSizeRechunker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f20136a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f20137b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20138c;

        /* renamed from: d, reason: collision with root package name */
        public final long[] f20139d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f20140e;

        /* renamed from: f, reason: collision with root package name */
        public final long f20141f;

        public b(long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2, long j10) {
            this.f20136a = jArr;
            this.f20137b = iArr;
            this.f20138c = i10;
            this.f20139d = jArr2;
            this.f20140e = iArr2;
            this.f20141f = j10;
        }
    }

    public static b a(int i10, long[] jArr, int[] iArr, long j10) {
        int i11 = 8192 / i10;
        int i12 = 0;
        for (int i13 : iArr) {
            i12 += j0.l(i13, i11);
        }
        long[] jArr2 = new long[i12];
        int[] iArr2 = new int[i12];
        long[] jArr3 = new long[i12];
        int[] iArr3 = new int[i12];
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < iArr.length; i17++) {
            int i18 = iArr[i17];
            long j11 = jArr[i17];
            while (i18 > 0) {
                int min = Math.min(i11, i18);
                jArr2[i15] = j11;
                iArr2[i15] = i10 * min;
                i16 = Math.max(i16, iArr2[i15]);
                jArr3[i15] = i14 * j10;
                iArr3[i15] = 1;
                j11 += iArr2[i15];
                i14 += min;
                i18 -= min;
                i15++;
            }
        }
        return new b(jArr2, iArr2, i16, jArr3, iArr3, j10 * i14);
    }
}
