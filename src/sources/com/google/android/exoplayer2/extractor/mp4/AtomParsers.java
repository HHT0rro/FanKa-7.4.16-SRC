package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.alibaba.security.biometrics.service.build.ah;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AtomParsers {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f20103a = j0.i0("OpusHead");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;

        @Nullable
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i10) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i10];
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class TkhdData {
        private final long duration;

        /* renamed from: id, reason: collision with root package name */
        private final int f20104id;
        private final int rotationDegrees;

        public TkhdData(int i10, long j10, int i11) {
            this.f20104id = i10;
            this.duration = j10;
            this.rotationDegrees = i11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f20105a;

        /* renamed from: b, reason: collision with root package name */
        public int f20106b;

        /* renamed from: c, reason: collision with root package name */
        public int f20107c;

        /* renamed from: d, reason: collision with root package name */
        public long f20108d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f20109e;

        /* renamed from: f, reason: collision with root package name */
        public final ParsableByteArray f20110f;

        /* renamed from: g, reason: collision with root package name */
        public final ParsableByteArray f20111g;

        /* renamed from: h, reason: collision with root package name */
        public int f20112h;

        /* renamed from: i, reason: collision with root package name */
        public int f20113i;

        public a(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z10) throws ParserException {
            this.f20111g = parsableByteArray;
            this.f20110f = parsableByteArray2;
            this.f20109e = z10;
            parsableByteArray2.P(12);
            this.f20105a = parsableByteArray2.H();
            parsableByteArray.P(12);
            this.f20113i = parsableByteArray.H();
            d5.f.a(parsableByteArray.n() == 1, "first_chunk must be 1");
            this.f20106b = -1;
        }

        public boolean a() {
            long F;
            int i10 = this.f20106b + 1;
            this.f20106b = i10;
            if (i10 == this.f20105a) {
                return false;
            }
            if (this.f20109e) {
                F = this.f20110f.I();
            } else {
                F = this.f20110f.F();
            }
            this.f20108d = F;
            if (this.f20106b == this.f20112h) {
                this.f20107c = this.f20111g.H();
                this.f20111g.Q(4);
                int i11 = this.f20113i - 1;
                this.f20113i = i11;
                this.f20112h = i11 > 0 ? this.f20111g.H() - 1 : -1;
            }
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        int a();

        int b();

        int c();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final int f20114a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20115b;

        /* renamed from: c, reason: collision with root package name */
        public final ParsableByteArray f20116c;

        public c(a.b bVar, Format format) {
            ParsableByteArray parsableByteArray = bVar.f20131b;
            this.f20116c = parsableByteArray;
            parsableByteArray.P(12);
            int H = parsableByteArray.H();
            if ("audio/raw".equals(format.f19544m)) {
                int a02 = j0.a0(format.B, format.f19557z);
                if (H == 0 || H % a02 != 0) {
                    StringBuilder sb2 = new StringBuilder(88);
                    sb2.append("Audio sample size mismatch. stsd sample size: ");
                    sb2.append(a02);
                    sb2.append(", stsz sample size: ");
                    sb2.append(H);
                    com.google.android.exoplayer2.util.m.h("AtomParsers", sb2.toString());
                    H = a02;
                }
            }
            this.f20114a = H == 0 ? -1 : H;
            this.f20115b = parsableByteArray.H();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.b
        public int a() {
            int i10 = this.f20114a;
            return i10 == -1 ? this.f20116c.H() : i10;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.b
        public int b() {
            return this.f20115b;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.b
        public int c() {
            return this.f20114a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements b {

        /* renamed from: a, reason: collision with root package name */
        public final ParsableByteArray f20117a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20118b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20119c;

        /* renamed from: d, reason: collision with root package name */
        public int f20120d;

        /* renamed from: e, reason: collision with root package name */
        public int f20121e;

        public d(a.b bVar) {
            ParsableByteArray parsableByteArray = bVar.f20131b;
            this.f20117a = parsableByteArray;
            parsableByteArray.P(12);
            this.f20119c = parsableByteArray.H() & 255;
            this.f20118b = parsableByteArray.H();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.b
        public int a() {
            int i10 = this.f20119c;
            if (i10 == 8) {
                return this.f20117a.D();
            }
            if (i10 == 16) {
                return this.f20117a.J();
            }
            int i11 = this.f20120d;
            this.f20120d = i11 + 1;
            if (i11 % 2 == 0) {
                int D = this.f20117a.D();
                this.f20121e = D;
                return (D & 240) >> 4;
            }
            return this.f20121e & 15;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.b
        public int b() {
            return this.f20118b;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.b
        public int c() {
            return -1;
        }
    }

    public static Pair<Metadata, Metadata> A(a.b bVar) {
        ParsableByteArray parsableByteArray = bVar.f20131b;
        parsableByteArray.P(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (parsableByteArray.a() >= 8) {
            int e2 = parsableByteArray.e();
            int n10 = parsableByteArray.n();
            int n11 = parsableByteArray.n();
            if (n11 == 1835365473) {
                parsableByteArray.P(e2);
                metadata = B(parsableByteArray, e2 + n10);
            } else if (n11 == 1936553057) {
                parsableByteArray.P(e2);
                metadata2 = t(parsableByteArray, e2 + n10);
            }
            parsableByteArray.P(e2 + n10);
        }
        return Pair.create(metadata, metadata2);
    }

    @Nullable
    public static Metadata B(ParsableByteArray parsableByteArray, int i10) {
        parsableByteArray.Q(8);
        d(parsableByteArray);
        while (parsableByteArray.e() < i10) {
            int e2 = parsableByteArray.e();
            int n10 = parsableByteArray.n();
            if (parsableByteArray.n() == 1768715124) {
                parsableByteArray.P(e2);
                return k(parsableByteArray, e2 + n10);
            }
            parsableByteArray.P(e2 + n10);
        }
        return null;
    }

    public static void C(ParsableByteArray parsableByteArray, int i10, int i11, int i12, int i13, int i14, @Nullable DrmInitData drmInitData, StsdData stsdData, int i15) throws ParserException {
        DrmInitData drmInitData2;
        String str;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i16 = i11;
        int i17 = i12;
        DrmInitData drmInitData3 = drmInitData;
        parsableByteArray2.P(i16 + 8 + 8);
        parsableByteArray2.Q(16);
        int J = parsableByteArray.J();
        int J2 = parsableByteArray.J();
        parsableByteArray2.Q(50);
        int e2 = parsableByteArray.e();
        int i18 = i10;
        if (i18 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> r10 = r(parsableByteArray2, i16, i17);
            if (r10 != null) {
                i18 = ((Integer) r10.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((TrackEncryptionBox) r10.second).f20123b);
                stsdData.trackEncryptionBoxes[i15] = (TrackEncryptionBox) r10.second;
            }
            parsableByteArray2.P(e2);
        }
        String str2 = "video/3gpp";
        String str3 = i18 == 1831958048 ? "video/mpeg" : i18 == 1211250227 ? "video/3gpp" : null;
        int i19 = -1;
        float f10 = 1.0f;
        String str4 = null;
        List<byte[]> list = null;
        byte[] bArr = null;
        ColorInfo colorInfo = null;
        boolean z10 = false;
        while (true) {
            if (e2 - i16 >= i17) {
                drmInitData2 = drmInitData3;
                break;
            }
            parsableByteArray2.P(e2);
            int e10 = parsableByteArray.e();
            String str5 = str2;
            int n10 = parsableByteArray.n();
            if (n10 == 0) {
                drmInitData2 = drmInitData3;
                if (parsableByteArray.e() - i16 == i17) {
                    break;
                }
            } else {
                drmInitData2 = drmInitData3;
            }
            d5.f.a(n10 > 0, "childAtomSize must be positive");
            int n11 = parsableByteArray.n();
            if (n11 == 1635148611) {
                d5.f.a(str3 == null, null);
                parsableByteArray2.P(e10 + 8);
                q6.a b4 = q6.a.b(parsableByteArray);
                list = b4.f53031a;
                stsdData.nalUnitLengthFieldLength = b4.f53032b;
                if (!z10) {
                    f10 = b4.f53035e;
                }
                str4 = b4.f53036f;
                str = ah.f2598d;
            } else if (n11 == 1752589123) {
                d5.f.a(str3 == null, null);
                parsableByteArray2.P(e10 + 8);
                q6.d a10 = q6.d.a(parsableByteArray);
                list = a10.f53054a;
                stsdData.nalUnitLengthFieldLength = a10.f53055b;
                str4 = a10.f53056c;
                str = "video/hevc";
            } else {
                if (n11 == 1685480259 || n11 == 1685485123) {
                    q6.b a11 = q6.b.a(parsableByteArray);
                    if (a11 != null) {
                        str4 = a11.f53039c;
                        str3 = "video/dolby-vision";
                    }
                } else if (n11 == 1987076931) {
                    d5.f.a(str3 == null, null);
                    str = i18 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (n11 == 1635135811) {
                    d5.f.a(str3 == null, null);
                    str3 = "video/av01";
                } else if (n11 == 1681012275) {
                    d5.f.a(str3 == null, null);
                    str3 = str5;
                } else if (n11 == 1702061171) {
                    d5.f.a(str3 == null, null);
                    Pair<String, byte[]> h10 = h(parsableByteArray2, e10);
                    String str6 = (String) h10.first;
                    byte[] bArr2 = (byte[]) h10.second;
                    if (bArr2 != null) {
                        list = ImmutableList.of(bArr2);
                    }
                    str3 = str6;
                } else if (n11 == 1885434736) {
                    f10 = p(parsableByteArray2, e10);
                    z10 = true;
                } else if (n11 == 1937126244) {
                    bArr = q(parsableByteArray2, e10, n10);
                } else if (n11 == 1936995172) {
                    int D = parsableByteArray.D();
                    parsableByteArray2.Q(3);
                    if (D == 0) {
                        int D2 = parsableByteArray.D();
                        if (D2 == 0) {
                            i19 = 0;
                        } else if (D2 == 1) {
                            i19 = 1;
                        } else if (D2 == 2) {
                            i19 = 2;
                        } else if (D2 == 3) {
                            i19 = 3;
                        }
                    }
                } else if (n11 == 1668246642) {
                    int n12 = parsableByteArray.n();
                    boolean z11 = n12 == 1852009592;
                    if (!z11 && n12 != 1852009571) {
                        String valueOf = String.valueOf(com.google.android.exoplayer2.extractor.mp4.a.a(n12));
                        com.google.android.exoplayer2.util.m.h("AtomParsers", valueOf.length() != 0 ? "Unsupported color type: ".concat(valueOf) : new String("Unsupported color type: "));
                    } else {
                        int J3 = parsableByteArray.J();
                        int J4 = parsableByteArray.J();
                        parsableByteArray2.Q(2);
                        colorInfo = new ColorInfo(ColorInfo.a(J3), z11 && (parsableByteArray.D() & 128) != 0 ? 1 : 2, ColorInfo.b(J4), null);
                    }
                }
                e2 += n10;
                parsableByteArray2 = parsableByteArray;
                i16 = i11;
                i17 = i12;
                str2 = str5;
                drmInitData3 = drmInitData2;
            }
            str3 = str;
            e2 += n10;
            parsableByteArray2 = parsableByteArray;
            i16 = i11;
            i17 = i12;
            str2 = str5;
            drmInitData3 = drmInitData2;
        }
        if (str3 == null) {
            return;
        }
        stsdData.format = new Format.b().R(i13).e0(str3).I(str4).j0(J).Q(J2).a0(f10).d0(i14).b0(bArr).h0(i19).T(list).L(drmInitData2).J(colorInfo).E();
    }

    public static boolean a(long[] jArr, long j10, long j11, long j12) {
        int length = jArr.length - 1;
        return jArr[0] <= j11 && j11 < jArr[j0.r(4, 0, length)] && jArr[j0.r(jArr.length - 4, 0, length)] < j12 && j12 <= j10;
    }

    public static int b(ParsableByteArray parsableByteArray, int i10, int i11) throws ParserException {
        int e2 = parsableByteArray.e();
        while (e2 - i10 < i11) {
            parsableByteArray.P(e2);
            int n10 = parsableByteArray.n();
            d5.f.a(n10 > 0, "childAtomSize must be positive");
            if (parsableByteArray.n() == 1702061171) {
                return e2;
            }
            e2 += n10;
        }
        return -1;
    }

    public static int c(int i10) {
        if (i10 == 1936684398) {
            return 1;
        }
        if (i10 == 1986618469) {
            return 2;
        }
        if (i10 == 1952807028 || i10 == 1935832172 || i10 == 1937072756 || i10 == 1668047728) {
            return 3;
        }
        return i10 == 1835365473 ? 5 : -1;
    }

    public static void d(ParsableByteArray parsableByteArray) {
        int e2 = parsableByteArray.e();
        parsableByteArray.Q(4);
        if (parsableByteArray.n() != 1751411826) {
            e2 += 4;
        }
        parsableByteArray.P(e2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(com.google.android.exoplayer2.util.ParsableByteArray r20, int r21, int r22, int r23, int r24, java.lang.String r25, boolean r26, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData r27, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r28, int r29) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 767
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.e(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    @Nullable
    public static Pair<Integer, TrackEncryptionBox> f(ParsableByteArray parsableByteArray, int i10, int i11) throws ParserException {
        int i12 = i10 + 8;
        String str = null;
        Integer num = null;
        int i13 = -1;
        int i14 = 0;
        while (i12 - i10 < i11) {
            parsableByteArray.P(i12);
            int n10 = parsableByteArray.n();
            int n11 = parsableByteArray.n();
            if (n11 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.n());
            } else if (n11 == 1935894637) {
                parsableByteArray.Q(4);
                str = parsableByteArray.A(4);
            } else if (n11 == 1935894633) {
                i13 = i12;
                i14 = n10;
            }
            i12 += n10;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        d5.f.a(num != null, "frma atom is mandatory");
        d5.f.a(i13 != -1, "schi atom is mandatory");
        TrackEncryptionBox s2 = s(parsableByteArray, i13, i14, str);
        d5.f.a(s2 != null, "tenc atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) j0.j(s2));
    }

    @Nullable
    public static Pair<long[], long[]> g(a.C0188a c0188a) {
        a.b g3 = c0188a.g(1701606260);
        if (g3 == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = g3.f20131b;
        parsableByteArray.P(8);
        int c4 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        int H = parsableByteArray.H();
        long[] jArr = new long[H];
        long[] jArr2 = new long[H];
        for (int i10 = 0; i10 < H; i10++) {
            jArr[i10] = c4 == 1 ? parsableByteArray.I() : parsableByteArray.F();
            jArr2[i10] = c4 == 1 ? parsableByteArray.w() : parsableByteArray.n();
            if (parsableByteArray.z() == 1) {
                parsableByteArray.Q(2);
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    public static Pair<String, byte[]> h(ParsableByteArray parsableByteArray, int i10) {
        parsableByteArray.P(i10 + 8 + 4);
        parsableByteArray.Q(1);
        i(parsableByteArray);
        parsableByteArray.Q(2);
        int D = parsableByteArray.D();
        if ((D & 128) != 0) {
            parsableByteArray.Q(2);
        }
        if ((D & 64) != 0) {
            parsableByteArray.Q(parsableByteArray.J());
        }
        if ((D & 32) != 0) {
            parsableByteArray.Q(2);
        }
        parsableByteArray.Q(1);
        i(parsableByteArray);
        String h10 = q.h(parsableByteArray.D());
        if (!"audio/mpeg".equals(h10) && !"audio/vnd.dts".equals(h10) && !"audio/vnd.dts.hd".equals(h10)) {
            parsableByteArray.Q(12);
            parsableByteArray.Q(1);
            int i11 = i(parsableByteArray);
            byte[] bArr = new byte[i11];
            parsableByteArray.j(bArr, 0, i11);
            return Pair.create(h10, bArr);
        }
        return Pair.create(h10, null);
    }

    public static int i(ParsableByteArray parsableByteArray) {
        int D = parsableByteArray.D();
        int i10 = D & 127;
        while ((D & 128) == 128) {
            D = parsableByteArray.D();
            i10 = (i10 << 7) | (D & 127);
        }
        return i10;
    }

    public static int j(ParsableByteArray parsableByteArray) {
        parsableByteArray.P(16);
        return parsableByteArray.n();
    }

    @Nullable
    public static Metadata k(ParsableByteArray parsableByteArray, int i10) {
        parsableByteArray.Q(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.e() < i10) {
            Metadata.Entry c4 = g.c(parsableByteArray);
            if (c4 != null) {
                arrayList.add(c4);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Pair<Long, String> l(ParsableByteArray parsableByteArray) {
        parsableByteArray.P(8);
        int c4 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        parsableByteArray.Q(c4 == 0 ? 8 : 16);
        long F = parsableByteArray.F();
        parsableByteArray.Q(c4 == 0 ? 4 : 8);
        int J = parsableByteArray.J();
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append((char) (((J >> 10) & 31) + 96));
        sb2.append((char) (((J >> 5) & 31) + 96));
        sb2.append((char) ((J & 31) + 96));
        return Pair.create(Long.valueOf(F), sb2.toString());
    }

    @Nullable
    public static Metadata m(a.C0188a c0188a) {
        a.b g3 = c0188a.g(1751411826);
        a.b g10 = c0188a.g(1801812339);
        a.b g11 = c0188a.g(1768715124);
        if (g3 == null || g10 == null || g11 == null || j(g3.f20131b) != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray = g10.f20131b;
        parsableByteArray.P(12);
        int n10 = parsableByteArray.n();
        String[] strArr = new String[n10];
        for (int i10 = 0; i10 < n10; i10++) {
            int n11 = parsableByteArray.n();
            parsableByteArray.Q(4);
            strArr[i10] = parsableByteArray.A(n11 - 8);
        }
        ParsableByteArray parsableByteArray2 = g11.f20131b;
        parsableByteArray2.P(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.a() > 8) {
            int e2 = parsableByteArray2.e();
            int n12 = parsableByteArray2.n();
            int n13 = parsableByteArray2.n() - 1;
            if (n13 >= 0 && n13 < n10) {
                MdtaMetadataEntry f10 = g.f(parsableByteArray2, e2 + n12, strArr[n13]);
                if (f10 != null) {
                    arrayList.add(f10);
                }
            } else {
                StringBuilder sb2 = new StringBuilder(52);
                sb2.append("Skipped metadata with unknown key index: ");
                sb2.append(n13);
                com.google.android.exoplayer2.util.m.h("AtomParsers", sb2.toString());
            }
            parsableByteArray2.P(e2 + n12);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void n(ParsableByteArray parsableByteArray, int i10, int i11, int i12, StsdData stsdData) {
        parsableByteArray.P(i11 + 8 + 8);
        if (i10 == 1835365492) {
            parsableByteArray.x();
            String x10 = parsableByteArray.x();
            if (x10 != null) {
                stsdData.format = new Format.b().R(i12).e0(x10).E();
            }
        }
    }

    public static long o(ParsableByteArray parsableByteArray) {
        parsableByteArray.P(8);
        parsableByteArray.Q(com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n()) != 0 ? 16 : 8);
        return parsableByteArray.F();
    }

    public static float p(ParsableByteArray parsableByteArray, int i10) {
        parsableByteArray.P(i10 + 8);
        return parsableByteArray.H() / parsableByteArray.H();
    }

    @Nullable
    public static byte[] q(ParsableByteArray parsableByteArray, int i10, int i11) {
        int i12 = i10 + 8;
        while (i12 - i10 < i11) {
            parsableByteArray.P(i12);
            int n10 = parsableByteArray.n();
            if (parsableByteArray.n() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.d(), i12, n10 + i12);
            }
            i12 += n10;
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, TrackEncryptionBox> r(ParsableByteArray parsableByteArray, int i10, int i11) throws ParserException {
        Pair<Integer, TrackEncryptionBox> f10;
        int e2 = parsableByteArray.e();
        while (e2 - i10 < i11) {
            parsableByteArray.P(e2);
            int n10 = parsableByteArray.n();
            d5.f.a(n10 > 0, "childAtomSize must be positive");
            if (parsableByteArray.n() == 1936289382 && (f10 = f(parsableByteArray, e2, n10)) != null) {
                return f10;
            }
            e2 += n10;
        }
        return null;
    }

    @Nullable
    public static TrackEncryptionBox s(ParsableByteArray parsableByteArray, int i10, int i11, String str) {
        int i12;
        int i13;
        int i14 = i10 + 8;
        while (true) {
            byte[] bArr = null;
            if (i14 - i10 >= i11) {
                return null;
            }
            parsableByteArray.P(i14);
            int n10 = parsableByteArray.n();
            if (parsableByteArray.n() == 1952804451) {
                int c4 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
                parsableByteArray.Q(1);
                if (c4 == 0) {
                    parsableByteArray.Q(1);
                    i13 = 0;
                    i12 = 0;
                } else {
                    int D = parsableByteArray.D();
                    i12 = D & 15;
                    i13 = (D & 240) >> 4;
                }
                boolean z10 = parsableByteArray.D() == 1;
                int D2 = parsableByteArray.D();
                byte[] bArr2 = new byte[16];
                parsableByteArray.j(bArr2, 0, 16);
                if (z10 && D2 == 0) {
                    int D3 = parsableByteArray.D();
                    bArr = new byte[D3];
                    parsableByteArray.j(bArr, 0, D3);
                }
                return new TrackEncryptionBox(z10, str, D2, bArr2, i13, i12, bArr);
            }
            i14 += n10;
        }
    }

    @Nullable
    public static Metadata t(ParsableByteArray parsableByteArray, int i10) {
        parsableByteArray.Q(12);
        while (parsableByteArray.e() < i10) {
            int e2 = parsableByteArray.e();
            int n10 = parsableByteArray.n();
            if (parsableByteArray.n() == 1935766900) {
                if (n10 < 14) {
                    return null;
                }
                parsableByteArray.Q(5);
                int D = parsableByteArray.D();
                if (D != 12 && D != 13) {
                    return null;
                }
                float f10 = D == 12 ? 240.0f : 120.0f;
                parsableByteArray.Q(1);
                return new Metadata(new SmtaMetadataEntry(f10, parsableByteArray.D()));
            }
            parsableByteArray.P(e2 + n10);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x043c A[EDGE_INSN: B:97:0x043c->B:98:0x043c BREAK  A[LOOP:2: B:76:0x03d4->B:92:0x0434], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.extractor.mp4.p u(com.google.android.exoplayer2.extractor.mp4.n r37, com.google.android.exoplayer2.extractor.mp4.a.C0188a r38, d5.l r39) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 1318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.u(com.google.android.exoplayer2.extractor.mp4.n, com.google.android.exoplayer2.extractor.mp4.a$a, d5.l):com.google.android.exoplayer2.extractor.mp4.p");
    }

    public static StsdData v(ParsableByteArray parsableByteArray, int i10, int i11, String str, @Nullable DrmInitData drmInitData, boolean z10) throws ParserException {
        int i12;
        parsableByteArray.P(12);
        int n10 = parsableByteArray.n();
        StsdData stsdData = new StsdData(n10);
        for (int i13 = 0; i13 < n10; i13++) {
            int e2 = parsableByteArray.e();
            int n11 = parsableByteArray.n();
            d5.f.a(n11 > 0, "childAtomSize must be positive");
            int n12 = parsableByteArray.n();
            if (n12 == 1635148593 || n12 == 1635148595 || n12 == 1701733238 || n12 == 1831958048 || n12 == 1836070006 || n12 == 1752589105 || n12 == 1751479857 || n12 == 1932670515 || n12 == 1211250227 || n12 == 1987063864 || n12 == 1987063865 || n12 == 1635135537 || n12 == 1685479798 || n12 == 1685479729 || n12 == 1685481573 || n12 == 1685481521) {
                i12 = e2;
                C(parsableByteArray, n12, i12, n11, i10, i11, drmInitData, stsdData, i13);
            } else if (n12 == 1836069985 || n12 == 1701733217 || n12 == 1633889587 || n12 == 1700998451 || n12 == 1633889588 || n12 == 1685353315 || n12 == 1685353317 || n12 == 1685353320 || n12 == 1685353324 || n12 == 1685353336 || n12 == 1935764850 || n12 == 1935767394 || n12 == 1819304813 || n12 == 1936684916 || n12 == 1953984371 || n12 == 778924082 || n12 == 778924083 || n12 == 1835557169 || n12 == 1835560241 || n12 == 1634492771 || n12 == 1634492791 || n12 == 1970037111 || n12 == 1332770163 || n12 == 1716281667) {
                i12 = e2;
                e(parsableByteArray, n12, e2, n11, i10, str, z10, drmInitData, stsdData, i13);
            } else {
                if (n12 == 1414810956 || n12 == 1954034535 || n12 == 2004251764 || n12 == 1937010800 || n12 == 1664495672) {
                    w(parsableByteArray, n12, e2, n11, i10, str, stsdData);
                } else if (n12 == 1835365492) {
                    n(parsableByteArray, n12, e2, i10, stsdData);
                } else if (n12 == 1667329389) {
                    stsdData.format = new Format.b().R(i10).e0("application/x-camera-motion").E();
                }
                i12 = e2;
            }
            parsableByteArray.P(i12 + n11);
        }
        return stsdData;
    }

    public static void w(ParsableByteArray parsableByteArray, int i10, int i11, int i12, int i13, String str, StsdData stsdData) {
        parsableByteArray.P(i11 + 8 + 8);
        String str2 = "application/ttml+xml";
        ImmutableList immutableList = null;
        long j10 = Long.MAX_VALUE;
        if (i10 != 1414810956) {
            if (i10 == 1954034535) {
                int i14 = (i12 - 8) - 8;
                byte[] bArr = new byte[i14];
                parsableByteArray.j(bArr, 0, i14);
                immutableList = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i10 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i10 == 1937010800) {
                j10 = 0;
            } else if (i10 == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.b().R(i13).e0(str2).V(str).i0(j10).T(immutableList).E();
    }

    public static TkhdData x(ParsableByteArray parsableByteArray) {
        boolean z10;
        parsableByteArray.P(8);
        int c4 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        parsableByteArray.Q(c4 == 0 ? 8 : 16);
        int n10 = parsableByteArray.n();
        parsableByteArray.Q(4);
        int e2 = parsableByteArray.e();
        int i10 = c4 == 0 ? 4 : 8;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= i10) {
                z10 = true;
                break;
            }
            if (parsableByteArray.d()[e2 + i12] != -1) {
                z10 = false;
                break;
            }
            i12++;
        }
        long j10 = -9223372036854775807L;
        if (z10) {
            parsableByteArray.Q(i10);
        } else {
            long F = c4 == 0 ? parsableByteArray.F() : parsableByteArray.I();
            if (F != 0) {
                j10 = F;
            }
        }
        parsableByteArray.Q(16);
        int n11 = parsableByteArray.n();
        int n12 = parsableByteArray.n();
        parsableByteArray.Q(4);
        int n13 = parsableByteArray.n();
        int n14 = parsableByteArray.n();
        if (n11 == 0 && n12 == 65536 && n13 == -65536 && n14 == 0) {
            i11 = 90;
        } else if (n11 == 0 && n12 == -65536 && n13 == 65536 && n14 == 0) {
            i11 = 270;
        } else if (n11 == -65536 && n12 == 0 && n13 == 0 && n14 == -65536) {
            i11 = 180;
        }
        return new TkhdData(n10, j10, i11);
    }

    @Nullable
    public static n y(a.C0188a c0188a, a.b bVar, long j10, @Nullable DrmInitData drmInitData, boolean z10, boolean z11) throws ParserException {
        a.b bVar2;
        long j11;
        long[] jArr;
        long[] jArr2;
        a.C0188a f10;
        Pair<long[], long[]> g3;
        a.C0188a c0188a2 = (a.C0188a) com.google.android.exoplayer2.util.a.e(c0188a.f(1835297121));
        int c4 = c(j(((a.b) com.google.android.exoplayer2.util.a.e(c0188a2.g(1751411826))).f20131b));
        if (c4 == -1) {
            return null;
        }
        TkhdData x10 = x(((a.b) com.google.android.exoplayer2.util.a.e(c0188a.g(1953196132))).f20131b);
        if (j10 == -9223372036854775807L) {
            bVar2 = bVar;
            j11 = x10.duration;
        } else {
            bVar2 = bVar;
            j11 = j10;
        }
        long o10 = o(bVar2.f20131b);
        long H0 = j11 != -9223372036854775807L ? j0.H0(j11, 1000000L, o10) : -9223372036854775807L;
        a.C0188a c0188a3 = (a.C0188a) com.google.android.exoplayer2.util.a.e(((a.C0188a) com.google.android.exoplayer2.util.a.e(c0188a2.f(1835626086))).f(1937007212));
        Pair<Long, String> l10 = l(((a.b) com.google.android.exoplayer2.util.a.e(c0188a2.g(1835296868))).f20131b);
        StsdData v2 = v(((a.b) com.google.android.exoplayer2.util.a.e(c0188a3.g(1937011556))).f20131b, x10.f20104id, x10.rotationDegrees, (String) l10.second, drmInitData, z11);
        if (z10 || (f10 = c0188a.f(1701082227)) == null || (g3 = g(f10)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) g3.first;
            jArr2 = (long[]) g3.second;
            jArr = jArr3;
        }
        if (v2.format == null) {
            return null;
        }
        return new n(x10.f20104id, c4, ((Long) l10.first).longValue(), o10, H0, v2.format, v2.requiredSampleTransformation, v2.trackEncryptionBoxes, v2.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static List<p> z(a.C0188a c0188a, d5.l lVar, long j10, @Nullable DrmInitData drmInitData, boolean z10, boolean z11, com.google.common.base.g<n, n> gVar) throws ParserException {
        n apply;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < c0188a.f20130d.size(); i10++) {
            a.C0188a c0188a2 = c0188a.f20130d.get(i10);
            if (c0188a2.f20127a == 1953653099 && (apply = gVar.apply(y(c0188a2, (a.b) com.google.android.exoplayer2.util.a.e(c0188a.g(1836476516)), j10, drmInitData, z10, z11))) != null) {
                arrayList.add(u(apply, (a.C0188a) com.google.android.exoplayer2.util.a.e(((a.C0188a) com.google.android.exoplayer2.util.a.e(((a.C0188a) com.google.android.exoplayer2.util.a.e(c0188a2.f(1835297121))).f(1835626086))).f(1937007212)), lVar));
            }
        }
        return arrayList;
    }
}
