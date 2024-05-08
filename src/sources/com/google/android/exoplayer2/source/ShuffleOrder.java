package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface ShuffleOrder {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a implements ShuffleOrder {

        /* renamed from: a, reason: collision with root package name */
        public final Random f21165a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f21166b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f21167c;

        public a(int i10) {
            this(i10, new Random());
        }

        public static int[] a(int i10, Random random) {
            int[] iArr = new int[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i11 + 1;
                int nextInt = random.nextInt(i12);
                iArr[i11] = iArr[nextInt];
                iArr[nextInt] = i11;
                i11 = i12;
            }
            return iArr;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int b() {
            return this.f21166b.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int c(int i10) {
            int i11 = this.f21167c[i10] - 1;
            if (i11 >= 0) {
                return this.f21166b[i11];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int d(int i10) {
            int i11 = this.f21167c[i10] + 1;
            int[] iArr = this.f21166b;
            if (i11 < iArr.length) {
                return iArr[i11];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int e() {
            int[] iArr = this.f21166b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder f() {
            return new a(0, new Random(this.f21165a.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int g() {
            int[] iArr = this.f21166b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder h(int i10, int i11) {
            int i12 = i11 - i10;
            int[] iArr = new int[this.f21166b.length - i12];
            int i13 = 0;
            int i14 = 0;
            while (true) {
                int[] iArr2 = this.f21166b;
                if (i13 < iArr2.length) {
                    if (iArr2[i13] < i10 || iArr2[i13] >= i11) {
                        iArr[i13 - i14] = iArr2[i13] >= i10 ? iArr2[i13] - i12 : iArr2[i13];
                    } else {
                        i14++;
                    }
                    i13++;
                } else {
                    return new a(iArr, new Random(this.f21165a.nextLong()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder i(int i10, int i11) {
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int i12 = 0;
            int i13 = 0;
            while (i13 < i11) {
                iArr[i13] = this.f21165a.nextInt(this.f21166b.length + 1);
                int i14 = i13 + 1;
                int nextInt = this.f21165a.nextInt(i14);
                iArr2[i13] = iArr2[nextInt];
                iArr2[nextInt] = i13 + i10;
                i13 = i14;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f21166b.length + i11];
            int i15 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr4 = this.f21166b;
                if (i12 < iArr4.length + i11) {
                    if (i15 < i11 && i16 == iArr[i15]) {
                        iArr3[i12] = iArr2[i15];
                        i15++;
                    } else {
                        int i17 = i16 + 1;
                        iArr3[i12] = iArr4[i16];
                        if (iArr3[i12] >= i10) {
                            iArr3[i12] = iArr3[i12] + i11;
                        }
                        i16 = i17;
                    }
                    i12++;
                } else {
                    return new a(iArr3, new Random(this.f21165a.nextLong()));
                }
            }
        }

        public a(int i10, Random random) {
            this(a(i10, random), random);
        }

        public a(int[] iArr, Random random) {
            this.f21166b = iArr;
            this.f21165a = random;
            this.f21167c = new int[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                this.f21167c[iArr[i10]] = i10;
            }
        }
    }

    int b();

    int c(int i10);

    int d(int i10);

    int e();

    ShuffleOrder f();

    int g();

    ShuffleOrder h(int i10, int i11);

    ShuffleOrder i(int i10, int i11);
}
