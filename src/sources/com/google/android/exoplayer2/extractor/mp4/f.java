package com.google.android.exoplayer2.extractor.mp4;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.util.j0;
import com.huawei.openalliance.ad.constant.bb;
import java.io.IOException;
import java.io.ObjectStreamConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipUtils;

/* compiled from: FragmentedMp4Extractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class f implements Extractor {
    public static final d5.i I = new d5.i() { // from class: com.google.android.exoplayer2.extractor.mp4.e
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return d5.h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] l10;
            l10 = f.l();
            return l10;
        }
    };
    public static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, ObjectStreamConstants.TC_LONGSTRING, 100, -115, -12};
    public static final Format K = new Format.b().e0("application/x-emsg").E();
    public int A;
    public int B;
    public int C;
    public boolean D;
    public d5.e E;
    public TrackOutput[] F;
    public TrackOutput[] G;
    public boolean H;

    /* renamed from: a, reason: collision with root package name */
    public final int f20144a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final n f20145b;

    /* renamed from: c, reason: collision with root package name */
    public final List<Format> f20146c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray<b> f20147d;

    /* renamed from: e, reason: collision with root package name */
    public final ParsableByteArray f20148e;

    /* renamed from: f, reason: collision with root package name */
    public final ParsableByteArray f20149f;

    /* renamed from: g, reason: collision with root package name */
    public final ParsableByteArray f20150g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f20151h;

    /* renamed from: i, reason: collision with root package name */
    public final ParsableByteArray f20152i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final f0 f20153j;

    /* renamed from: k, reason: collision with root package name */
    public final p5.b f20154k;

    /* renamed from: l, reason: collision with root package name */
    public final ParsableByteArray f20155l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayDeque<a.C0188a> f20156m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayDeque<a> f20157n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public final TrackOutput f20158o;

    /* renamed from: p, reason: collision with root package name */
    public int f20159p;

    /* renamed from: q, reason: collision with root package name */
    public int f20160q;

    /* renamed from: r, reason: collision with root package name */
    public long f20161r;

    /* renamed from: s, reason: collision with root package name */
    public int f20162s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public ParsableByteArray f20163t;

    /* renamed from: u, reason: collision with root package name */
    public long f20164u;

    /* renamed from: v, reason: collision with root package name */
    public int f20165v;

    /* renamed from: w, reason: collision with root package name */
    public long f20166w;

    /* renamed from: x, reason: collision with root package name */
    public long f20167x;

    /* renamed from: y, reason: collision with root package name */
    public long f20168y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public b f20169z;

    /* compiled from: FragmentedMp4Extractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f20170a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20171b;

        public a(long j10, int i10) {
            this.f20170a = j10;
            this.f20171b = i10;
        }
    }

    /* compiled from: FragmentedMp4Extractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final TrackOutput f20172a;

        /* renamed from: d, reason: collision with root package name */
        public p f20175d;

        /* renamed from: e, reason: collision with root package name */
        public com.google.android.exoplayer2.extractor.mp4.b f20176e;

        /* renamed from: f, reason: collision with root package name */
        public int f20177f;

        /* renamed from: g, reason: collision with root package name */
        public int f20178g;

        /* renamed from: h, reason: collision with root package name */
        public int f20179h;

        /* renamed from: i, reason: collision with root package name */
        public int f20180i;

        /* renamed from: l, reason: collision with root package name */
        public boolean f20183l;

        /* renamed from: b, reason: collision with root package name */
        public final o f20173b = new o();

        /* renamed from: c, reason: collision with root package name */
        public final ParsableByteArray f20174c = new ParsableByteArray();

        /* renamed from: j, reason: collision with root package name */
        public final ParsableByteArray f20181j = new ParsableByteArray(1);

        /* renamed from: k, reason: collision with root package name */
        public final ParsableByteArray f20182k = new ParsableByteArray();

        public b(TrackOutput trackOutput, p pVar, com.google.android.exoplayer2.extractor.mp4.b bVar) {
            this.f20172a = trackOutput;
            this.f20175d = pVar;
            this.f20176e = bVar;
            j(pVar, bVar);
        }

        public int c() {
            int i10;
            if (!this.f20183l) {
                i10 = this.f20175d.f20264g[this.f20177f];
            } else {
                i10 = this.f20173b.f20250l[this.f20177f] ? 1 : 0;
            }
            return g() != null ? i10 | 1073741824 : i10;
        }

        public long d() {
            if (!this.f20183l) {
                return this.f20175d.f20260c[this.f20177f];
            }
            return this.f20173b.f20245g[this.f20179h];
        }

        public long e() {
            if (!this.f20183l) {
                return this.f20175d.f20263f[this.f20177f];
            }
            return this.f20173b.c(this.f20177f);
        }

        public int f() {
            if (!this.f20183l) {
                return this.f20175d.f20261d[this.f20177f];
            }
            return this.f20173b.f20247i[this.f20177f];
        }

        @Nullable
        public TrackEncryptionBox g() {
            if (!this.f20183l) {
                return null;
            }
            int i10 = ((com.google.android.exoplayer2.extractor.mp4.b) j0.j(this.f20173b.f20239a)).f20132a;
            TrackEncryptionBox trackEncryptionBox = this.f20173b.f20253o;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = this.f20175d.f20258a.a(i10);
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.f20122a) {
                return null;
            }
            return trackEncryptionBox;
        }

        public boolean h() {
            this.f20177f++;
            if (!this.f20183l) {
                return false;
            }
            int i10 = this.f20178g + 1;
            this.f20178g = i10;
            int[] iArr = this.f20173b.f20246h;
            int i11 = this.f20179h;
            if (i10 != iArr[i11]) {
                return true;
            }
            this.f20179h = i11 + 1;
            this.f20178g = 0;
            return false;
        }

        public int i(int i10, int i11) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox g3 = g();
            if (g3 == null) {
                return 0;
            }
            int i12 = g3.f20125d;
            if (i12 != 0) {
                parsableByteArray = this.f20173b.f20254p;
            } else {
                byte[] bArr = (byte[]) j0.j(g3.f20126e);
                this.f20182k.N(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.f20182k;
                i12 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean g10 = this.f20173b.g(this.f20177f);
            boolean z10 = g10 || i11 != 0;
            this.f20181j.d()[0] = (byte) ((z10 ? 128 : 0) | i12);
            this.f20181j.P(0);
            this.f20172a.f(this.f20181j, 1, 1);
            this.f20172a.f(parsableByteArray, i12, 1);
            if (!z10) {
                return i12 + 1;
            }
            if (!g10) {
                this.f20174c.L(8);
                byte[] d10 = this.f20174c.d();
                d10[0] = 0;
                d10[1] = 1;
                d10[2] = (byte) ((i11 >> 8) & 255);
                d10[3] = (byte) (i11 & 255);
                d10[4] = (byte) ((i10 >> 24) & 255);
                d10[5] = (byte) ((i10 >> 16) & 255);
                d10[6] = (byte) ((i10 >> 8) & 255);
                d10[7] = (byte) (i10 & 255);
                this.f20172a.f(this.f20174c, 8, 1);
                return i12 + 1 + 8;
            }
            ParsableByteArray parsableByteArray3 = this.f20173b.f20254p;
            int J = parsableByteArray3.J();
            parsableByteArray3.Q(-2);
            int i13 = (J * 6) + 2;
            if (i11 != 0) {
                this.f20174c.L(i13);
                byte[] d11 = this.f20174c.d();
                parsableByteArray3.j(d11, 0, i13);
                int i14 = (((d11[2] & 255) << 8) | (d11[3] & 255)) + i11;
                d11[2] = (byte) ((i14 >> 8) & 255);
                d11[3] = (byte) (i14 & 255);
                parsableByteArray3 = this.f20174c;
            }
            this.f20172a.f(parsableByteArray3, i13, 1);
            return i12 + 1 + i13;
        }

        public void j(p pVar, com.google.android.exoplayer2.extractor.mp4.b bVar) {
            this.f20175d = pVar;
            this.f20176e = bVar;
            this.f20172a.b(pVar.f20258a.f20233f);
            k();
        }

        public void k() {
            this.f20173b.f();
            this.f20177f = 0;
            this.f20179h = 0;
            this.f20178g = 0;
            this.f20180i = 0;
            this.f20183l = false;
        }

        public void l(long j10) {
            int i10 = this.f20177f;
            while (true) {
                o oVar = this.f20173b;
                if (i10 >= oVar.f20244f || oVar.c(i10) >= j10) {
                    return;
                }
                if (this.f20173b.f20250l[i10]) {
                    this.f20180i = i10;
                }
                i10++;
            }
        }

        public void m() {
            TrackEncryptionBox g3 = g();
            if (g3 == null) {
                return;
            }
            ParsableByteArray parsableByteArray = this.f20173b.f20254p;
            int i10 = g3.f20125d;
            if (i10 != 0) {
                parsableByteArray.Q(i10);
            }
            if (this.f20173b.g(this.f20177f)) {
                parsableByteArray.Q(parsableByteArray.J() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            TrackEncryptionBox a10 = this.f20175d.f20258a.a(((com.google.android.exoplayer2.extractor.mp4.b) j0.j(this.f20173b.f20239a)).f20132a);
            this.f20172a.b(this.f20175d.f20258a.f20233f.a().L(drmInitData.copyWithSchemeType(a10 != null ? a10.f20123b : null)).E());
        }
    }

    public f() {
        this(0);
    }

    public static Pair<Long, com.google.android.exoplayer2.extractor.b> A(ParsableByteArray parsableByteArray, long j10) throws ParserException {
        long I2;
        long I3;
        parsableByteArray.P(8);
        int c4 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        parsableByteArray.Q(4);
        long F = parsableByteArray.F();
        if (c4 == 0) {
            I2 = parsableByteArray.F();
            I3 = parsableByteArray.F();
        } else {
            I2 = parsableByteArray.I();
            I3 = parsableByteArray.I();
        }
        long j11 = I2;
        long j12 = j10 + I3;
        long H0 = j0.H0(j11, 1000000L, F);
        parsableByteArray.Q(2);
        int J2 = parsableByteArray.J();
        int[] iArr = new int[J2];
        long[] jArr = new long[J2];
        long[] jArr2 = new long[J2];
        long[] jArr3 = new long[J2];
        long j13 = j11;
        long j14 = H0;
        int i10 = 0;
        while (i10 < J2) {
            int n10 = parsableByteArray.n();
            if ((n10 & Integer.MIN_VALUE) == 0) {
                long F2 = parsableByteArray.F();
                iArr[i10] = n10 & Integer.MAX_VALUE;
                jArr[i10] = j12;
                jArr3[i10] = j14;
                long j15 = j13 + F2;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i11 = J2;
                long H02 = j0.H0(j15, 1000000L, F);
                jArr4[i10] = H02 - jArr5[i10];
                parsableByteArray.Q(4);
                j12 += r1[i10];
                i10++;
                iArr = iArr;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                J2 = i11;
                j13 = j15;
                j14 = H02;
            } else {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
        }
        return Pair.create(Long.valueOf(H0), new com.google.android.exoplayer2.extractor.b(iArr, jArr, jArr2, jArr3));
    }

    public static long B(ParsableByteArray parsableByteArray) {
        parsableByteArray.P(8);
        return com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n()) == 1 ? parsableByteArray.I() : parsableByteArray.F();
    }

    @Nullable
    public static b C(ParsableByteArray parsableByteArray, SparseArray<b> sparseArray, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        parsableByteArray.P(8);
        int b4 = com.google.android.exoplayer2.extractor.mp4.a.b(parsableByteArray.n());
        b valueAt = z10 ? sparseArray.valueAt(0) : sparseArray.get(parsableByteArray.n());
        if (valueAt == null) {
            return null;
        }
        if ((b4 & 1) != 0) {
            long I2 = parsableByteArray.I();
            o oVar = valueAt.f20173b;
            oVar.f20241c = I2;
            oVar.f20242d = I2;
        }
        com.google.android.exoplayer2.extractor.mp4.b bVar = valueAt.f20176e;
        if ((b4 & 2) != 0) {
            i10 = parsableByteArray.n() - 1;
        } else {
            i10 = bVar.f20132a;
        }
        if ((b4 & 8) != 0) {
            i11 = parsableByteArray.n();
        } else {
            i11 = bVar.f20133b;
        }
        if ((b4 & 16) != 0) {
            i12 = parsableByteArray.n();
        } else {
            i12 = bVar.f20134c;
        }
        if ((b4 & 32) != 0) {
            i13 = parsableByteArray.n();
        } else {
            i13 = bVar.f20135d;
        }
        valueAt.f20173b.f20239a = new com.google.android.exoplayer2.extractor.mp4.b(i10, i11, i12, i13);
        return valueAt;
    }

    public static void D(a.C0188a c0188a, SparseArray<b> sparseArray, boolean z10, int i10, byte[] bArr) throws ParserException {
        b C = C(((a.b) com.google.android.exoplayer2.util.a.e(c0188a.g(1952868452))).f20131b, sparseArray, z10);
        if (C == null) {
            return;
        }
        o oVar = C.f20173b;
        long j10 = oVar.f20256r;
        boolean z11 = oVar.f20257s;
        C.k();
        C.f20183l = true;
        a.b g3 = c0188a.g(1952867444);
        if (g3 != null && (i10 & 2) == 0) {
            oVar.f20256r = B(g3.f20131b);
            oVar.f20257s = true;
        } else {
            oVar.f20256r = j10;
            oVar.f20257s = z11;
        }
        G(c0188a, C, i10);
        TrackEncryptionBox a10 = C.f20175d.f20258a.a(((com.google.android.exoplayer2.extractor.mp4.b) com.google.android.exoplayer2.util.a.e(oVar.f20239a)).f20132a);
        a.b g10 = c0188a.g(1935763834);
        if (g10 != null) {
            w((TrackEncryptionBox) com.google.android.exoplayer2.util.a.e(a10), g10.f20131b, oVar);
        }
        a.b g11 = c0188a.g(1935763823);
        if (g11 != null) {
            v(g11.f20131b, oVar);
        }
        a.b g12 = c0188a.g(1936027235);
        if (g12 != null) {
            z(g12.f20131b, oVar);
        }
        x(c0188a, a10 != null ? a10.f20123b : null, oVar);
        int size = c0188a.f20129c.size();
        for (int i11 = 0; i11 < size; i11++) {
            a.b bVar = c0188a.f20129c.get(i11);
            if (bVar.f20127a == 1970628964) {
                H(bVar.f20131b, oVar, bArr);
            }
        }
    }

    public static Pair<Integer, com.google.android.exoplayer2.extractor.mp4.b> E(ParsableByteArray parsableByteArray) {
        parsableByteArray.P(12);
        return Pair.create(Integer.valueOf(parsableByteArray.n()), new com.google.android.exoplayer2.extractor.mp4.b(parsableByteArray.n() - 1, parsableByteArray.n(), parsableByteArray.n(), parsableByteArray.n()));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int F(com.google.android.exoplayer2.extractor.mp4.f.b r36, int r37, int r38, com.google.android.exoplayer2.util.ParsableByteArray r39, int r40) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.f.F(com.google.android.exoplayer2.extractor.mp4.f$b, int, int, com.google.android.exoplayer2.util.ParsableByteArray, int):int");
    }

    public static void G(a.C0188a c0188a, b bVar, int i10) throws ParserException {
        List<a.b> list = c0188a.f20129c;
        int size = list.size();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            a.b bVar2 = list.get(i13);
            if (bVar2.f20127a == 1953658222) {
                ParsableByteArray parsableByteArray = bVar2.f20131b;
                parsableByteArray.P(12);
                int H = parsableByteArray.H();
                if (H > 0) {
                    i12 += H;
                    i11++;
                }
            }
        }
        bVar.f20179h = 0;
        bVar.f20178g = 0;
        bVar.f20177f = 0;
        bVar.f20173b.e(i11, i12);
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            a.b bVar3 = list.get(i16);
            if (bVar3.f20127a == 1953658222) {
                i15 = F(bVar, i14, i10, bVar3.f20131b, i15);
                i14++;
            }
        }
    }

    public static void H(ParsableByteArray parsableByteArray, o oVar, byte[] bArr) throws ParserException {
        parsableByteArray.P(8);
        parsableByteArray.j(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            y(parsableByteArray, 16, oVar);
        }
    }

    public static boolean N(int i10) {
        return i10 == 1836019574 || i10 == 1953653099 || i10 == 1835297121 || i10 == 1835626086 || i10 == 1937007212 || i10 == 1836019558 || i10 == 1953653094 || i10 == 1836475768 || i10 == 1701082227;
    }

    public static boolean O(int i10) {
        return i10 == 1751411826 || i10 == 1835296868 || i10 == 1836476516 || i10 == 1936286840 || i10 == 1937011556 || i10 == 1937011827 || i10 == 1668576371 || i10 == 1937011555 || i10 == 1937011578 || i10 == 1937013298 || i10 == 1937007471 || i10 == 1668232756 || i10 == 1937011571 || i10 == 1952867444 || i10 == 1952868452 || i10 == 1953196132 || i10 == 1953654136 || i10 == 1953658222 || i10 == 1886614376 || i10 == 1935763834 || i10 == 1935763823 || i10 == 1936027235 || i10 == 1970628964 || i10 == 1935828848 || i10 == 1936158820 || i10 == 1701606260 || i10 == 1835362404 || i10 == 1701671783;
    }

    public static int d(int i10) throws ParserException {
        if (i10 >= 0) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("Unexpected negative value: ");
        sb2.append(i10);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    @Nullable
    public static DrmInitData i(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            a.b bVar = list.get(i10);
            if (bVar.f20127a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] d10 = bVar.f20131b.d();
                UUID f10 = k.f(d10);
                if (f10 == null) {
                    com.google.android.exoplayer2.util.m.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(f10, bb.Code, d10));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    @Nullable
    public static b j(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j10 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            b valueAt = sparseArray.valueAt(i10);
            if ((valueAt.f20183l || valueAt.f20177f != valueAt.f20175d.f20259b) && (!valueAt.f20183l || valueAt.f20179h != valueAt.f20173b.f20243e)) {
                long d10 = valueAt.d();
                if (d10 < j10) {
                    bVar = valueAt;
                    j10 = d10;
                }
            }
        }
        return bVar;
    }

    public static /* synthetic */ Extractor[] l() {
        return new Extractor[]{new f()};
    }

    public static long t(ParsableByteArray parsableByteArray) {
        parsableByteArray.P(8);
        return com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n()) == 0 ? parsableByteArray.F() : parsableByteArray.I();
    }

    public static void u(a.C0188a c0188a, SparseArray<b> sparseArray, boolean z10, int i10, byte[] bArr) throws ParserException {
        int size = c0188a.f20130d.size();
        for (int i11 = 0; i11 < size; i11++) {
            a.C0188a c0188a2 = c0188a.f20130d.get(i11);
            if (c0188a2.f20127a == 1953653094) {
                D(c0188a2, sparseArray, z10, i10, bArr);
            }
        }
    }

    public static void v(ParsableByteArray parsableByteArray, o oVar) throws ParserException {
        parsableByteArray.P(8);
        int n10 = parsableByteArray.n();
        if ((com.google.android.exoplayer2.extractor.mp4.a.b(n10) & 1) == 1) {
            parsableByteArray.Q(8);
        }
        int H = parsableByteArray.H();
        if (H == 1) {
            oVar.f20242d += com.google.android.exoplayer2.extractor.mp4.a.c(n10) == 0 ? parsableByteArray.F() : parsableByteArray.I();
        } else {
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Unexpected saio entry count: ");
            sb2.append(H);
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }
    }

    public static void w(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, o oVar) throws ParserException {
        int i10;
        int i11 = trackEncryptionBox.f20125d;
        parsableByteArray.P(8);
        if ((com.google.android.exoplayer2.extractor.mp4.a.b(parsableByteArray.n()) & 1) == 1) {
            parsableByteArray.Q(8);
        }
        int D = parsableByteArray.D();
        int H = parsableByteArray.H();
        int i12 = oVar.f20244f;
        if (H <= i12) {
            if (D == 0) {
                boolean[] zArr = oVar.f20252n;
                i10 = 0;
                for (int i13 = 0; i13 < H; i13++) {
                    int D2 = parsableByteArray.D();
                    i10 += D2;
                    zArr[i13] = D2 > i11;
                }
            } else {
                i10 = (D * H) + 0;
                Arrays.fill(oVar.f20252n, 0, H, D > i11);
            }
            Arrays.fill(oVar.f20252n, H, oVar.f20244f, false);
            if (i10 > 0) {
                oVar.d(i10);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder(78);
        sb2.append("Saiz sample count ");
        sb2.append(H);
        sb2.append(" is greater than fragment sample count");
        sb2.append(i12);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    public static void x(a.C0188a c0188a, @Nullable String str, o oVar) throws ParserException {
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i10 = 0; i10 < c0188a.f20129c.size(); i10++) {
            a.b bVar = c0188a.f20129c.get(i10);
            ParsableByteArray parsableByteArray3 = bVar.f20131b;
            int i11 = bVar.f20127a;
            if (i11 == 1935828848) {
                parsableByteArray3.P(12);
                if (parsableByteArray3.n() == 1936025959) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (i11 == 1936158820) {
                parsableByteArray3.P(12);
                if (parsableByteArray3.n() == 1936025959) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray == null || parsableByteArray2 == null) {
            return;
        }
        parsableByteArray.P(8);
        int c4 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        parsableByteArray.Q(4);
        if (c4 == 1) {
            parsableByteArray.Q(4);
        }
        if (parsableByteArray.n() == 1) {
            parsableByteArray2.P(8);
            int c10 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray2.n());
            parsableByteArray2.Q(4);
            if (c10 == 1) {
                if (parsableByteArray2.F() == 0) {
                    throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
                }
            } else if (c10 >= 2) {
                parsableByteArray2.Q(4);
            }
            if (parsableByteArray2.F() == 1) {
                parsableByteArray2.Q(1);
                int D = parsableByteArray2.D();
                int i12 = (D & 240) >> 4;
                int i13 = D & 15;
                boolean z10 = parsableByteArray2.D() == 1;
                if (z10) {
                    int D2 = parsableByteArray2.D();
                    byte[] bArr2 = new byte[16];
                    parsableByteArray2.j(bArr2, 0, 16);
                    if (D2 == 0) {
                        int D3 = parsableByteArray2.D();
                        bArr = new byte[D3];
                        parsableByteArray2.j(bArr, 0, D3);
                    }
                    oVar.f20251m = true;
                    oVar.f20253o = new TrackEncryptionBox(z10, str, D2, bArr2, i12, i13, bArr);
                    return;
                }
                return;
            }
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
    }

    public static void y(ParsableByteArray parsableByteArray, int i10, o oVar) throws ParserException {
        parsableByteArray.P(i10 + 8);
        int b4 = com.google.android.exoplayer2.extractor.mp4.a.b(parsableByteArray.n());
        if ((b4 & 1) == 0) {
            boolean z10 = (b4 & 2) != 0;
            int H = parsableByteArray.H();
            if (H == 0) {
                Arrays.fill(oVar.f20252n, 0, oVar.f20244f, false);
                return;
            }
            int i11 = oVar.f20244f;
            if (H == i11) {
                Arrays.fill(oVar.f20252n, 0, H, z10);
                oVar.d(parsableByteArray.a());
                oVar.a(parsableByteArray);
                return;
            } else {
                StringBuilder sb2 = new StringBuilder(80);
                sb2.append("Senc sample count ");
                sb2.append(H);
                sb2.append(" is different from fragment sample count");
                sb2.append(i11);
                throw ParserException.createForMalformedContainer(sb2.toString(), null);
            }
        }
        throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    public static void z(ParsableByteArray parsableByteArray, o oVar) throws ParserException {
        y(parsableByteArray, 0, oVar);
    }

    public final void I(long j10) throws ParserException {
        while (!this.f20156m.isEmpty() && this.f20156m.peek().f20128b == j10) {
            n(this.f20156m.pop());
        }
        e();
    }

    public final boolean J(d5.d dVar) throws IOException {
        if (this.f20162s == 0) {
            if (!dVar.f(this.f20155l.d(), 0, 8, true)) {
                return false;
            }
            this.f20162s = 8;
            this.f20155l.P(0);
            this.f20161r = this.f20155l.F();
            this.f20160q = this.f20155l.n();
        }
        long j10 = this.f20161r;
        if (j10 == 1) {
            dVar.readFully(this.f20155l.d(), 8, 8);
            this.f20162s += 8;
            this.f20161r = this.f20155l.I();
        } else if (j10 == 0) {
            long b4 = dVar.b();
            if (b4 == -1 && !this.f20156m.isEmpty()) {
                b4 = this.f20156m.peek().f20128b;
            }
            if (b4 != -1) {
                this.f20161r = (b4 - dVar.getPosition()) + this.f20162s;
            }
        }
        if (this.f20161r >= this.f20162s) {
            long position = dVar.getPosition() - this.f20162s;
            int i10 = this.f20160q;
            if ((i10 == 1836019558 || i10 == 1835295092) && !this.H) {
                this.E.r(new i.b(this.f20167x, position));
                this.H = true;
            }
            if (this.f20160q == 1836019558) {
                int size = this.f20147d.size();
                for (int i11 = 0; i11 < size; i11++) {
                    o oVar = this.f20147d.valueAt(i11).f20173b;
                    oVar.f20240b = position;
                    oVar.f20242d = position;
                    oVar.f20241c = position;
                }
            }
            int i12 = this.f20160q;
            if (i12 == 1835295092) {
                this.f20169z = null;
                this.f20164u = position + this.f20161r;
                this.f20159p = 2;
                return true;
            }
            if (N(i12)) {
                long position2 = (dVar.getPosition() + this.f20161r) - 8;
                this.f20156m.push(new a.C0188a(this.f20160q, position2));
                if (this.f20161r == this.f20162s) {
                    I(position2);
                } else {
                    e();
                }
            } else if (O(this.f20160q)) {
                if (this.f20162s == 8) {
                    long j11 = this.f20161r;
                    if (j11 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                        ParsableByteArray parsableByteArray = new ParsableByteArray((int) j11);
                        System.arraycopy((Object) this.f20155l.d(), 0, (Object) parsableByteArray.d(), 0, 8);
                        this.f20163t = parsableByteArray;
                        this.f20159p = 1;
                    } else {
                        throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.f20161r <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                this.f20163t = null;
                this.f20159p = 1;
            } else {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
    }

    public final void K(d5.d dVar) throws IOException {
        int i10 = ((int) this.f20161r) - this.f20162s;
        ParsableByteArray parsableByteArray = this.f20163t;
        if (parsableByteArray != null) {
            dVar.readFully(parsableByteArray.d(), 8, i10);
            p(new a.b(this.f20160q, parsableByteArray), dVar.getPosition());
        } else {
            dVar.r(i10);
        }
        I(dVar.getPosition());
    }

    public final void L(d5.d dVar) throws IOException {
        int size = this.f20147d.size();
        long j10 = Long.MAX_VALUE;
        b bVar = null;
        for (int i10 = 0; i10 < size; i10++) {
            o oVar = this.f20147d.valueAt(i10).f20173b;
            if (oVar.f20255q) {
                long j11 = oVar.f20242d;
                if (j11 < j10) {
                    bVar = this.f20147d.valueAt(i10);
                    j10 = j11;
                }
            }
        }
        if (bVar == null) {
            this.f20159p = 3;
            return;
        }
        int position = (int) (j10 - dVar.getPosition());
        if (position >= 0) {
            dVar.r(position);
            bVar.f20173b.b(dVar);
            return;
        }
        throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
    }

    public final boolean M(d5.d dVar) throws IOException {
        int c4;
        b bVar = this.f20169z;
        Throwable th = null;
        if (bVar == null) {
            bVar = j(this.f20147d);
            if (bVar == null) {
                int position = (int) (this.f20164u - dVar.getPosition());
                if (position >= 0) {
                    dVar.r(position);
                    e();
                    return false;
                }
                throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
            }
            int d10 = (int) (bVar.d() - dVar.getPosition());
            if (d10 < 0) {
                com.google.android.exoplayer2.util.m.h("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d10 = 0;
            }
            dVar.r(d10);
            this.f20169z = bVar;
        }
        int i10 = 4;
        int i11 = 1;
        if (this.f20159p == 3) {
            int f10 = bVar.f();
            this.A = f10;
            if (bVar.f20177f < bVar.f20180i) {
                dVar.r(f10);
                bVar.m();
                if (!bVar.h()) {
                    this.f20169z = null;
                }
                this.f20159p = 3;
                return true;
            }
            if (bVar.f20175d.f20258a.f20234g == 1) {
                this.A = f10 - 8;
                dVar.r(8);
            }
            if ("audio/ac4".equals(bVar.f20175d.f20258a.f20233f.f19544m)) {
                this.B = bVar.i(this.A, 7);
                x4.c.a(this.A, this.f20152i);
                bVar.f20172a.a(this.f20152i, 7);
                this.B += 7;
            } else {
                this.B = bVar.i(this.A, 0);
            }
            this.A += this.B;
            this.f20159p = 4;
            this.C = 0;
        }
        n nVar = bVar.f20175d.f20258a;
        TrackOutput trackOutput = bVar.f20172a;
        long e2 = bVar.e();
        f0 f0Var = this.f20153j;
        if (f0Var != null) {
            e2 = f0Var.a(e2);
        }
        long j10 = e2;
        if (nVar.f20237j == 0) {
            while (true) {
                int i12 = this.B;
                int i13 = this.A;
                if (i12 >= i13) {
                    break;
                }
                this.B += trackOutput.c(dVar, i13 - i12, false);
            }
        } else {
            byte[] d11 = this.f20149f.d();
            d11[0] = 0;
            d11[1] = 0;
            d11[2] = 0;
            int i14 = nVar.f20237j;
            int i15 = i14 + 1;
            int i16 = 4 - i14;
            while (this.B < this.A) {
                int i17 = this.C;
                if (i17 == 0) {
                    dVar.readFully(d11, i16, i15);
                    this.f20149f.P(0);
                    int n10 = this.f20149f.n();
                    if (n10 >= i11) {
                        this.C = n10 - 1;
                        this.f20148e.P(0);
                        trackOutput.a(this.f20148e, i10);
                        trackOutput.a(this.f20149f, i11);
                        this.D = this.G.length > 0 && NalUnitUtil.g(nVar.f20233f.f19544m, d11[i10]);
                        this.B += 5;
                        this.A += i16;
                    } else {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", th);
                    }
                } else {
                    if (this.D) {
                        this.f20150g.L(i17);
                        dVar.readFully(this.f20150g.d(), 0, this.C);
                        trackOutput.a(this.f20150g, this.C);
                        c4 = this.C;
                        int k10 = NalUnitUtil.k(this.f20150g.d(), this.f20150g.f());
                        this.f20150g.P("video/hevc".equals(nVar.f20233f.f19544m) ? 1 : 0);
                        this.f20150g.O(k10);
                        com.google.android.exoplayer2.extractor.a.a(j10, this.f20150g, this.G);
                    } else {
                        c4 = trackOutput.c(dVar, i17, false);
                    }
                    this.B += c4;
                    this.C -= c4;
                    th = null;
                    i10 = 4;
                    i11 = 1;
                }
            }
        }
        int c10 = bVar.c();
        TrackEncryptionBox g3 = bVar.g();
        trackOutput.d(j10, c10, this.A, 0, g3 != null ? g3.f20124c : null);
        s(j10);
        if (!bVar.h()) {
            this.f20169z = null;
        }
        this.f20159p = 3;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        int size = this.f20147d.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f20147d.valueAt(i10).k();
        }
        this.f20157n.clear();
        this.f20165v = 0;
        this.f20166w = j11;
        this.f20156m.clear();
        e();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.E = eVar;
        e();
        k();
        n nVar = this.f20145b;
        if (nVar != null) {
            this.f20147d.put(0, new b(eVar.c(0, nVar.f20229b), new p(this.f20145b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new com.google.android.exoplayer2.extractor.mp4.b(0, 0, 0, 0)));
            this.E.l();
        }
    }

    public final void e() {
        this.f20159p = 0;
        this.f20162s = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, d5.n nVar) throws IOException {
        while (true) {
            int i10 = this.f20159p;
            if (i10 != 0) {
                if (i10 == 1) {
                    K(dVar);
                } else if (i10 != 2) {
                    if (M(dVar)) {
                        return 0;
                    }
                } else {
                    L(dVar);
                }
            } else if (!J(dVar)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        return m.b(dVar);
    }

    public final com.google.android.exoplayer2.extractor.mp4.b h(SparseArray<com.google.android.exoplayer2.extractor.mp4.b> sparseArray, int i10) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (com.google.android.exoplayer2.extractor.mp4.b) com.google.android.exoplayer2.util.a.e(sparseArray.get(i10));
    }

    public final void k() {
        int i10;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.F = trackOutputArr;
        TrackOutput trackOutput = this.f20158o;
        int i11 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i12 = 100;
        if ((this.f20144a & 4) != 0) {
            trackOutputArr[i10] = this.E.c(100, 5);
            i10++;
            i12 = 101;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) j0.A0(this.F, i10);
        this.F = trackOutputArr2;
        for (TrackOutput trackOutput2 : trackOutputArr2) {
            trackOutput2.b(K);
        }
        this.G = new TrackOutput[this.f20146c.size()];
        while (i11 < this.G.length) {
            TrackOutput c4 = this.E.c(i12, 3);
            c4.b(this.f20146c.get(i11));
            this.G[i11] = c4;
            i11++;
            i12++;
        }
    }

    @Nullable
    public n m(@Nullable n nVar) {
        return nVar;
    }

    public final void n(a.C0188a c0188a) throws ParserException {
        int i10 = c0188a.f20127a;
        if (i10 == 1836019574) {
            r(c0188a);
        } else if (i10 == 1836019558) {
            q(c0188a);
        } else {
            if (this.f20156m.isEmpty()) {
                return;
            }
            this.f20156m.peek().d(c0188a);
        }
    }

    public final void o(ParsableByteArray parsableByteArray) {
        long H0;
        String str;
        long H02;
        String str2;
        long F;
        long j10;
        if (this.F.length == 0) {
            return;
        }
        parsableByteArray.P(8);
        int c4 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        if (c4 != 0) {
            if (c4 != 1) {
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Skipping unsupported emsg version: ");
                sb2.append(c4);
                com.google.android.exoplayer2.util.m.h("FragmentedMp4Extractor", sb2.toString());
                return;
            }
            long F2 = parsableByteArray.F();
            j10 = j0.H0(parsableByteArray.I(), 1000000L, F2);
            long H03 = j0.H0(parsableByteArray.F(), 1000L, F2);
            long F3 = parsableByteArray.F();
            str = (String) com.google.android.exoplayer2.util.a.e(parsableByteArray.x());
            H02 = H03;
            F = F3;
            str2 = (String) com.google.android.exoplayer2.util.a.e(parsableByteArray.x());
            H0 = -9223372036854775807L;
        } else {
            String str3 = (String) com.google.android.exoplayer2.util.a.e(parsableByteArray.x());
            String str4 = (String) com.google.android.exoplayer2.util.a.e(parsableByteArray.x());
            long F4 = parsableByteArray.F();
            H0 = j0.H0(parsableByteArray.F(), 1000000L, F4);
            long j11 = this.f20168y;
            long j12 = j11 != -9223372036854775807L ? j11 + H0 : -9223372036854775807L;
            str = str3;
            H02 = j0.H0(parsableByteArray.F(), 1000L, F4);
            str2 = str4;
            F = parsableByteArray.F();
            j10 = j12;
        }
        byte[] bArr = new byte[parsableByteArray.a()];
        parsableByteArray.j(bArr, 0, parsableByteArray.a());
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.f20154k.a(new EventMessage(str, str2, H02, F, bArr)));
        int a10 = parsableByteArray2.a();
        for (TrackOutput trackOutput : this.F) {
            parsableByteArray2.P(0);
            trackOutput.a(parsableByteArray2, a10);
        }
        if (j10 == -9223372036854775807L) {
            this.f20157n.addLast(new a(H0, a10));
            this.f20165v += a10;
            return;
        }
        f0 f0Var = this.f20153j;
        if (f0Var != null) {
            j10 = f0Var.a(j10);
        }
        for (TrackOutput trackOutput2 : this.F) {
            trackOutput2.d(j10, 1, a10, 0, null);
        }
    }

    public final void p(a.b bVar, long j10) throws ParserException {
        if (!this.f20156m.isEmpty()) {
            this.f20156m.peek().e(bVar);
            return;
        }
        int i10 = bVar.f20127a;
        if (i10 != 1936286840) {
            if (i10 == 1701671783) {
                o(bVar.f20131b);
            }
        } else {
            Pair<Long, com.google.android.exoplayer2.extractor.b> A = A(bVar.f20131b, j10);
            this.f20168y = ((Long) A.first).longValue();
            this.E.r((com.google.android.exoplayer2.extractor.i) A.second);
            this.H = true;
        }
    }

    public final void q(a.C0188a c0188a) throws ParserException {
        u(c0188a, this.f20147d, this.f20145b != null, this.f20144a, this.f20151h);
        DrmInitData i10 = i(c0188a.f20129c);
        if (i10 != null) {
            int size = this.f20147d.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f20147d.valueAt(i11).n(i10);
            }
        }
        if (this.f20166w != -9223372036854775807L) {
            int size2 = this.f20147d.size();
            for (int i12 = 0; i12 < size2; i12++) {
                this.f20147d.valueAt(i12).l(this.f20166w);
            }
            this.f20166w = -9223372036854775807L;
        }
    }

    public final void r(a.C0188a c0188a) throws ParserException {
        int i10 = 0;
        com.google.android.exoplayer2.util.a.h(this.f20145b == null, "Unexpected moov box.");
        DrmInitData i11 = i(c0188a.f20129c);
        a.C0188a c0188a2 = (a.C0188a) com.google.android.exoplayer2.util.a.e(c0188a.f(1836475768));
        SparseArray<com.google.android.exoplayer2.extractor.mp4.b> sparseArray = new SparseArray<>();
        int size = c0188a2.f20129c.size();
        long j10 = -9223372036854775807L;
        for (int i12 = 0; i12 < size; i12++) {
            a.b bVar = c0188a2.f20129c.get(i12);
            int i13 = bVar.f20127a;
            if (i13 == 1953654136) {
                Pair<Integer, com.google.android.exoplayer2.extractor.mp4.b> E = E(bVar.f20131b);
                sparseArray.put(((Integer) E.first).intValue(), (com.google.android.exoplayer2.extractor.mp4.b) E.second);
            } else if (i13 == 1835362404) {
                j10 = t(bVar.f20131b);
            }
        }
        List<p> z10 = AtomParsers.z(c0188a, new d5.l(), j10, i11, (this.f20144a & 16) != 0, false, new com.google.common.base.g() { // from class: com.google.android.exoplayer2.extractor.mp4.d
            @Override // com.google.common.base.g
            public final Object apply(Object obj) {
                return f.this.m((n) obj);
            }
        });
        int size2 = z10.size();
        if (this.f20147d.size() == 0) {
            while (i10 < size2) {
                p pVar = z10.get(i10);
                n nVar = pVar.f20258a;
                this.f20147d.put(nVar.f20228a, new b(this.E.c(i10, nVar.f20229b), pVar, h(sparseArray, nVar.f20228a)));
                this.f20167x = Math.max(this.f20167x, nVar.f20232e);
                i10++;
            }
            this.E.l();
            return;
        }
        com.google.android.exoplayer2.util.a.g(this.f20147d.size() == size2);
        while (i10 < size2) {
            p pVar2 = z10.get(i10);
            n nVar2 = pVar2.f20258a;
            this.f20147d.get(nVar2.f20228a).j(pVar2, h(sparseArray, nVar2.f20228a));
            i10++;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public final void s(long j10) {
        while (!this.f20157n.isEmpty()) {
            a removeFirst = this.f20157n.removeFirst();
            this.f20165v -= removeFirst.f20171b;
            long j11 = removeFirst.f20170a + j10;
            f0 f0Var = this.f20153j;
            if (f0Var != null) {
                j11 = f0Var.a(j11);
            }
            for (TrackOutput trackOutput : this.F) {
                trackOutput.d(j11, 1, removeFirst.f20171b, this.f20165v, null);
            }
        }
    }

    public f(int i10) {
        this(i10, null);
    }

    public f(int i10, @Nullable f0 f0Var) {
        this(i10, f0Var, null, Collections.emptyList());
    }

    public f(int i10, @Nullable f0 f0Var, @Nullable n nVar) {
        this(i10, f0Var, nVar, Collections.emptyList());
    }

    public f(int i10, @Nullable f0 f0Var, @Nullable n nVar, List<Format> list) {
        this(i10, f0Var, nVar, list, null);
    }

    public f(int i10, @Nullable f0 f0Var, @Nullable n nVar, List<Format> list, @Nullable TrackOutput trackOutput) {
        this.f20144a = i10;
        this.f20153j = f0Var;
        this.f20145b = nVar;
        this.f20146c = Collections.unmodifiableList(list);
        this.f20158o = trackOutput;
        this.f20154k = new p5.b();
        this.f20155l = new ParsableByteArray(16);
        this.f20148e = new ParsableByteArray(NalUnitUtil.f22925a);
        this.f20149f = new ParsableByteArray(5);
        this.f20150g = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.f20151h = bArr;
        this.f20152i = new ParsableByteArray(bArr);
        this.f20156m = new ArrayDeque<>();
        this.f20157n = new ArrayDeque<>();
        this.f20147d = new SparseArray<>();
        this.f20167x = -9223372036854775807L;
        this.f20166w = -9223372036854775807L;
        this.f20168y = -9223372036854775807L;
        this.E = d5.e.f48633z0;
        this.F = new TrackOutput[0];
        this.G = new TrackOutput[0];
    }
}
