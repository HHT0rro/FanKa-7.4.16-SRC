package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

/* compiled from: H262Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n implements m {

    /* renamed from: q, reason: collision with root package name */
    public static final double[] f20517q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    public String f20518a;

    /* renamed from: b, reason: collision with root package name */
    public TrackOutput f20519b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final j0 f20520c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final ParsableByteArray f20521d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final t f20522e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f20523f;

    /* renamed from: g, reason: collision with root package name */
    public final a f20524g;

    /* renamed from: h, reason: collision with root package name */
    public long f20525h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20526i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20527j;

    /* renamed from: k, reason: collision with root package name */
    public long f20528k;

    /* renamed from: l, reason: collision with root package name */
    public long f20529l;

    /* renamed from: m, reason: collision with root package name */
    public long f20530m;

    /* renamed from: n, reason: collision with root package name */
    public long f20531n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20532o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20533p;

    /* compiled from: H262Reader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final byte[] f20534e = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        public boolean f20535a;

        /* renamed from: b, reason: collision with root package name */
        public int f20536b;

        /* renamed from: c, reason: collision with root package name */
        public int f20537c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f20538d;

        public a(int i10) {
            this.f20538d = new byte[i10];
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f20535a) {
                int i12 = i11 - i10;
                byte[] bArr2 = this.f20538d;
                int length = bArr2.length;
                int i13 = this.f20536b;
                if (length < i13 + i12) {
                    this.f20538d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
                }
                System.arraycopy((Object) bArr, i10, (Object) this.f20538d, this.f20536b, i12);
                this.f20536b += i12;
            }
        }

        public boolean b(int i10, int i11) {
            if (this.f20535a) {
                int i12 = this.f20536b - i11;
                this.f20536b = i12;
                if (this.f20537c == 0 && i10 == 181) {
                    this.f20537c = i12;
                } else {
                    this.f20535a = false;
                    return true;
                }
            } else if (i10 == 179) {
                this.f20535a = true;
            }
            byte[] bArr = f20534e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f20535a = false;
            this.f20536b = 0;
            this.f20537c = 0;
        }
    }

    public n() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> b(com.google.android.exoplayer2.extractor.ts.n.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f20538d
            int r1 = r8.f20536b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 6
            r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r6 = r4 >> 4
            r2 = r2 | r6
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r5
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3d
            r7 = 3
            if (r6 == r7) goto L37
            if (r6 == r1) goto L31
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L31:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
            goto L42
        L37:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L42
        L3d:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
        L42:
            float r6 = (float) r6
            float r1 = r1 / r6
        L44:
            com.google.android.exoplayer2.Format$b r6 = new com.google.android.exoplayer2.Format$b
            r6.<init>()
            com.google.android.exoplayer2.Format$b r9 = r6.S(r9)
            java.lang.String r6 = "video/mpeg2"
            com.google.android.exoplayer2.Format$b r9 = r9.e0(r6)
            com.google.android.exoplayer2.Format$b r9 = r9.j0(r2)
            com.google.android.exoplayer2.Format$b r9 = r9.Q(r4)
            com.google.android.exoplayer2.Format$b r9 = r9.a0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            com.google.android.exoplayer2.Format$b r9 = r9.T(r1)
            com.google.android.exoplayer2.Format r9 = r9.E()
            r1 = 0
            r4 = r0[r5]
            r4 = r4 & 15
            int r4 = r4 + (-1)
            if (r4 < 0) goto L9d
            double[] r5 = com.google.android.exoplayer2.extractor.ts.n.f20517q
            int r6 = r5.length
            if (r4 >= r6) goto L9d
            r1 = r5[r4]
            int r8 = r8.f20537c
            int r8 = r8 + 9
            r4 = r0[r8]
            r4 = r4 & 96
            int r3 = r4 >> 5
            r8 = r0[r8]
            r8 = r8 & 31
            if (r3 == r8) goto L96
            double r3 = (double) r3
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L96:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r1 = (long) r3
        L9d:
            java.lang.Long r8 = java.lang.Long.valueOf(r1)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.n.b(com.google.android.exoplayer2.extractor.ts.n$a, java.lang.String):android.util.Pair");
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        NalUnitUtil.a(this.f20523f);
        this.f20524g.c();
        t tVar = this.f20522e;
        if (tVar != null) {
            tVar.d();
        }
        this.f20525h = 0L;
        this.f20526i = false;
        this.f20529l = -9223372036854775807L;
        this.f20531n = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c  */
    @Override // com.google.android.exoplayer2.extractor.ts.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(com.google.android.exoplayer2.util.ParsableByteArray r21) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.n.c(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20518a = dVar.b();
        this.f20519b = eVar.c(dVar.c(), 2);
        j0 j0Var = this.f20520c;
        if (j0Var != null) {
            j0Var.b(eVar, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        this.f20529l = j10;
    }

    public n(@Nullable j0 j0Var) {
        this.f20520c = j0Var;
        this.f20523f = new boolean[4];
        this.f20524g = new a(128);
        if (j0Var != null) {
            this.f20522e = new t(178, 128);
            this.f20521d = new ParsableByteArray();
        } else {
            this.f20522e = null;
            this.f20521d = null;
        }
        this.f20529l = -9223372036854775807L;
        this.f20531n = -9223372036854775807L;
    }
}
