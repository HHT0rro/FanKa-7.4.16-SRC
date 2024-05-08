package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.alibaba.security.biometrics.service.build.ah;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class H264Reader implements m {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f20331a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20332b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20333c;

    /* renamed from: g, reason: collision with root package name */
    public long f20337g;

    /* renamed from: i, reason: collision with root package name */
    public String f20339i;

    /* renamed from: j, reason: collision with root package name */
    public TrackOutput f20340j;

    /* renamed from: k, reason: collision with root package name */
    public SampleReader f20341k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20342l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20344n;

    /* renamed from: h, reason: collision with root package name */
    public final boolean[] f20338h = new boolean[3];

    /* renamed from: d, reason: collision with root package name */
    public final t f20334d = new t(7, 128);

    /* renamed from: e, reason: collision with root package name */
    public final t f20335e = new t(8, 128);

    /* renamed from: f, reason: collision with root package name */
    public final t f20336f = new t(6, 128);

    /* renamed from: m, reason: collision with root package name */
    public long f20343m = -9223372036854775807L;

    /* renamed from: o, reason: collision with root package name */
    public final ParsableByteArray f20345o = new ParsableByteArray();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class SampleReader {

        /* renamed from: a, reason: collision with root package name */
        public final TrackOutput f20346a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20347b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f20348c;

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray<NalUnitUtil.SpsData> f20349d = new SparseArray<>();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray<NalUnitUtil.PpsData> f20350e = new SparseArray<>();

        /* renamed from: f, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.v f20351f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f20352g;

        /* renamed from: h, reason: collision with root package name */
        public int f20353h;

        /* renamed from: i, reason: collision with root package name */
        public int f20354i;

        /* renamed from: j, reason: collision with root package name */
        public long f20355j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f20356k;

        /* renamed from: l, reason: collision with root package name */
        public long f20357l;

        /* renamed from: m, reason: collision with root package name */
        public SliceHeaderData f20358m;

        /* renamed from: n, reason: collision with root package name */
        public SliceHeaderData f20359n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f20360o;

        /* renamed from: p, reason: collision with root package name */
        public long f20361p;

        /* renamed from: q, reason: collision with root package name */
        public long f20362q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f20363r;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class SliceHeaderData {
            private static final int SLICE_TYPE_ALL_I = 7;
            private static final int SLICE_TYPE_I = 2;
            private boolean bottomFieldFlag;
            private boolean bottomFieldFlagPresent;
            private int deltaPicOrderCnt0;
            private int deltaPicOrderCnt1;
            private int deltaPicOrderCntBottom;
            private boolean fieldPicFlag;
            private int frameNum;
            private boolean hasSliceType;
            private boolean idrPicFlag;
            private int idrPicId;
            private boolean isComplete;
            private int nalRefIdc;
            private int picOrderCntLsb;
            private int picParameterSetId;
            private int sliceType;

            @Nullable
            private NalUnitUtil.SpsData spsData;

            private SliceHeaderData() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean isFirstVclNalUnitOfPicture(SliceHeaderData sliceHeaderData) {
                int i10;
                int i11;
                int i12;
                boolean z10;
                if (!this.isComplete) {
                    return false;
                }
                if (!sliceHeaderData.isComplete) {
                    return true;
                }
                NalUnitUtil.SpsData spsData = (NalUnitUtil.SpsData) com.google.android.exoplayer2.util.a.i(this.spsData);
                NalUnitUtil.SpsData spsData2 = (NalUnitUtil.SpsData) com.google.android.exoplayer2.util.a.i(sliceHeaderData.spsData);
                return (this.frameNum == sliceHeaderData.frameNum && this.picParameterSetId == sliceHeaderData.picParameterSetId && this.fieldPicFlag == sliceHeaderData.fieldPicFlag && (!this.bottomFieldFlagPresent || !sliceHeaderData.bottomFieldFlagPresent || this.bottomFieldFlag == sliceHeaderData.bottomFieldFlag) && (((i10 = this.nalRefIdc) == (i11 = sliceHeaderData.nalRefIdc) || (i10 != 0 && i11 != 0)) && (((i12 = spsData.picOrderCountType) != 0 || spsData2.picOrderCountType != 0 || (this.picOrderCntLsb == sliceHeaderData.picOrderCntLsb && this.deltaPicOrderCntBottom == sliceHeaderData.deltaPicOrderCntBottom)) && ((i12 != 1 || spsData2.picOrderCountType != 1 || (this.deltaPicOrderCnt0 == sliceHeaderData.deltaPicOrderCnt0 && this.deltaPicOrderCnt1 == sliceHeaderData.deltaPicOrderCnt1)) && (z10 = this.idrPicFlag) == sliceHeaderData.idrPicFlag && (!z10 || this.idrPicId == sliceHeaderData.idrPicId))))) ? false : true;
            }

            public void clear() {
                this.hasSliceType = false;
                this.isComplete = false;
            }

            public boolean isISlice() {
                int i10;
                return this.hasSliceType && ((i10 = this.sliceType) == 7 || i10 == 2);
            }

            public void setAll(NalUnitUtil.SpsData spsData, int i10, int i11, int i12, int i13, boolean z10, boolean z11, boolean z12, boolean z13, int i14, int i15, int i16, int i17, int i18) {
                this.spsData = spsData;
                this.nalRefIdc = i10;
                this.sliceType = i11;
                this.frameNum = i12;
                this.picParameterSetId = i13;
                this.fieldPicFlag = z10;
                this.bottomFieldFlagPresent = z11;
                this.bottomFieldFlag = z12;
                this.idrPicFlag = z13;
                this.idrPicId = i14;
                this.picOrderCntLsb = i15;
                this.deltaPicOrderCntBottom = i16;
                this.deltaPicOrderCnt0 = i17;
                this.deltaPicOrderCnt1 = i18;
                this.isComplete = true;
                this.hasSliceType = true;
            }

            public void setSliceType(int i10) {
                this.sliceType = i10;
                this.hasSliceType = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z10, boolean z11) {
            this.f20346a = trackOutput;
            this.f20347b = z10;
            this.f20348c = z11;
            this.f20358m = new SliceHeaderData();
            this.f20359n = new SliceHeaderData();
            byte[] bArr = new byte[128];
            this.f20352g = bArr;
            this.f20351f = new com.google.android.exoplayer2.util.v(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0102  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 408
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.a(byte[], int, int):void");
        }

        public boolean b(long j10, int i10, boolean z10, boolean z11) {
            boolean z12 = false;
            if (this.f20354i == 9 || (this.f20348c && this.f20359n.isFirstVclNalUnitOfPicture(this.f20358m))) {
                if (z10 && this.f20360o) {
                    d(i10 + ((int) (j10 - this.f20355j)));
                }
                this.f20361p = this.f20355j;
                this.f20362q = this.f20357l;
                this.f20363r = false;
                this.f20360o = true;
            }
            if (this.f20347b) {
                z11 = this.f20359n.isISlice();
            }
            boolean z13 = this.f20363r;
            int i11 = this.f20354i;
            if (i11 == 5 || (z11 && i11 == 1)) {
                z12 = true;
            }
            boolean z14 = z13 | z12;
            this.f20363r = z14;
            return z14;
        }

        public boolean c() {
            return this.f20348c;
        }

        public final void d(int i10) {
            long j10 = this.f20362q;
            if (j10 == -9223372036854775807L) {
                return;
            }
            boolean z10 = this.f20363r;
            this.f20346a.d(j10, z10 ? 1 : 0, (int) (this.f20355j - this.f20361p), i10, null);
        }

        public void e(NalUnitUtil.PpsData ppsData) {
            this.f20350e.append(ppsData.picParameterSetId, ppsData);
        }

        public void f(NalUnitUtil.SpsData spsData) {
            this.f20349d.append(spsData.seqParameterSetId, spsData);
        }

        public void g() {
            this.f20356k = false;
            this.f20360o = false;
            this.f20359n.clear();
        }

        public void h(long j10, int i10, long j11) {
            this.f20354i = i10;
            this.f20357l = j11;
            this.f20355j = j10;
            if (!this.f20347b || i10 != 1) {
                if (!this.f20348c) {
                    return;
                }
                if (i10 != 5 && i10 != 1 && i10 != 2) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.f20358m;
            this.f20358m = this.f20359n;
            this.f20359n = sliceHeaderData;
            sliceHeaderData.clear();
            this.f20353h = 0;
            this.f20356k = true;
        }
    }

    public H264Reader(c0 c0Var, boolean z10, boolean z11) {
        this.f20331a = c0Var;
        this.f20332b = z10;
        this.f20333c = z11;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20337g = 0L;
        this.f20344n = false;
        this.f20343m = -9223372036854775807L;
        NalUnitUtil.a(this.f20338h);
        this.f20334d.d();
        this.f20335e.d();
        this.f20336f.d();
        SampleReader sampleReader = this.f20341k;
        if (sampleReader != null) {
            sampleReader.g();
        }
    }

    public final void b() {
        com.google.android.exoplayer2.util.a.i(this.f20340j);
        com.google.android.exoplayer2.util.j0.j(this.f20341k);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        b();
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        byte[] d10 = parsableByteArray.d();
        this.f20337g += parsableByteArray.a();
        this.f20340j.a(parsableByteArray, parsableByteArray.a());
        while (true) {
            int c4 = NalUnitUtil.c(d10, e2, f10, this.f20338h);
            if (c4 == f10) {
                h(d10, e2, f10);
                return;
            }
            int f11 = NalUnitUtil.f(d10, c4);
            int i10 = c4 - e2;
            if (i10 > 0) {
                h(d10, e2, c4);
            }
            int i11 = f10 - c4;
            long j10 = this.f20337g - i11;
            g(j10, i11, i10 < 0 ? -i10 : 0, this.f20343m);
            i(j10, f11, this.f20343m);
            e2 = c4 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20339i = dVar.b();
        TrackOutput c4 = eVar.c(dVar.c(), 2);
        this.f20340j = c4;
        this.f20341k = new SampleReader(c4, this.f20332b, this.f20333c);
        this.f20331a.b(eVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20343m = j10;
        }
        this.f20344n |= (i10 & 2) != 0;
    }

    public final void g(long j10, int i10, int i11, long j11) {
        if (!this.f20342l || this.f20341k.c()) {
            this.f20334d.b(i11);
            this.f20335e.b(i11);
            if (!this.f20342l) {
                if (this.f20334d.c() && this.f20335e.c()) {
                    ArrayList arrayList = new ArrayList();
                    t tVar = this.f20334d;
                    arrayList.add(Arrays.copyOf(tVar.f20634d, tVar.f20635e));
                    t tVar2 = this.f20335e;
                    arrayList.add(Arrays.copyOf(tVar2.f20634d, tVar2.f20635e));
                    t tVar3 = this.f20334d;
                    NalUnitUtil.SpsData i12 = NalUnitUtil.i(tVar3.f20634d, 3, tVar3.f20635e);
                    t tVar4 = this.f20335e;
                    NalUnitUtil.PpsData h10 = NalUnitUtil.h(tVar4.f20634d, 3, tVar4.f20635e);
                    this.f20340j.b(new Format.b().S(this.f20339i).e0(ah.f2598d).I(com.google.android.exoplayer2.util.c.a(i12.profileIdc, i12.constraintsFlagsAndReservedZero2Bits, i12.levelIdc)).j0(i12.width).Q(i12.height).a0(i12.pixelWidthAspectRatio).T(arrayList).E());
                    this.f20342l = true;
                    this.f20341k.f(i12);
                    this.f20341k.e(h10);
                    this.f20334d.d();
                    this.f20335e.d();
                }
            } else if (this.f20334d.c()) {
                t tVar5 = this.f20334d;
                this.f20341k.f(NalUnitUtil.i(tVar5.f20634d, 3, tVar5.f20635e));
                this.f20334d.d();
            } else if (this.f20335e.c()) {
                t tVar6 = this.f20335e;
                this.f20341k.e(NalUnitUtil.h(tVar6.f20634d, 3, tVar6.f20635e));
                this.f20335e.d();
            }
        }
        if (this.f20336f.b(i11)) {
            t tVar7 = this.f20336f;
            this.f20345o.N(this.f20336f.f20634d, NalUnitUtil.k(tVar7.f20634d, tVar7.f20635e));
            this.f20345o.P(4);
            this.f20331a.a(j11, this.f20345o);
        }
        if (this.f20341k.b(j10, i10, this.f20342l, this.f20344n)) {
            this.f20344n = false;
        }
    }

    public final void h(byte[] bArr, int i10, int i11) {
        if (!this.f20342l || this.f20341k.c()) {
            this.f20334d.a(bArr, i10, i11);
            this.f20335e.a(bArr, i10, i11);
        }
        this.f20336f.a(bArr, i10, i11);
        this.f20341k.a(bArr, i10, i11);
    }

    public final void i(long j10, int i10, long j11) {
        if (!this.f20342l || this.f20341k.c()) {
            this.f20334d.e(i10);
            this.f20335e.e(i10);
        }
        this.f20336f.e(i10);
        this.f20341k.h(j10, i10, j11);
    }
}
