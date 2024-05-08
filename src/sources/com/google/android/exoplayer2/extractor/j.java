package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.m;
import d5.q;
import java.util.Arrays;

/* compiled from: VorbisUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j {

    /* compiled from: VorbisUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f20081a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20082b;

        /* renamed from: c, reason: collision with root package name */
        public final long[] f20083c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20084d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f20085e;

        public a(int i10, int i11, long[] jArr, int i12, boolean z10) {
            this.f20081a = i10;
            this.f20082b = i11;
            this.f20083c = jArr;
            this.f20084d = i12;
            this.f20085e = z10;
        }
    }

    /* compiled from: VorbisUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f20086a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f20087b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20088c;

        public b(String str, String[] strArr, int i10) {
            this.f20086a = str;
            this.f20087b = strArr;
            this.f20088c = i10;
        }
    }

    /* compiled from: VorbisUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f20089a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20090b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20091c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20092d;

        public c(boolean z10, int i10, int i11, int i12) {
            this.f20089a = z10;
            this.f20090b = i10;
            this.f20091c = i11;
            this.f20092d = i12;
        }
    }

    /* compiled from: VorbisUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f20093a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20094b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20095c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20096d;

        /* renamed from: e, reason: collision with root package name */
        public final int f20097e;

        /* renamed from: f, reason: collision with root package name */
        public final int f20098f;

        /* renamed from: g, reason: collision with root package name */
        public final int f20099g;

        /* renamed from: h, reason: collision with root package name */
        public final int f20100h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f20101i;

        /* renamed from: j, reason: collision with root package name */
        public final byte[] f20102j;

        public d(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10, byte[] bArr) {
            this.f20093a = i10;
            this.f20094b = i11;
            this.f20095c = i12;
            this.f20096d = i13;
            this.f20097e = i14;
            this.f20098f = i15;
            this.f20099g = i16;
            this.f20100h = i17;
            this.f20101i = z10;
            this.f20102j = bArr;
        }
    }

    public static int a(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i11++;
            i10 >>>= 1;
        }
        return i11;
    }

    public static long b(long j10, long j11) {
        return (long) Math.floor(Math.pow(j10, 1.0d / j11));
    }

    public static a c(q qVar) throws ParserException {
        if (qVar.d(24) == 5653314) {
            int d10 = qVar.d(16);
            int d11 = qVar.d(24);
            long[] jArr = new long[d11];
            boolean c4 = qVar.c();
            long j10 = 0;
            if (!c4) {
                boolean c10 = qVar.c();
                for (int i10 = 0; i10 < d11; i10++) {
                    if (c10) {
                        if (qVar.c()) {
                            jArr[i10] = qVar.d(5) + 1;
                        } else {
                            jArr[i10] = 0;
                        }
                    } else {
                        jArr[i10] = qVar.d(5) + 1;
                    }
                }
            } else {
                int d12 = qVar.d(5) + 1;
                int i11 = 0;
                while (i11 < d11) {
                    int d13 = qVar.d(a(d11 - i11));
                    for (int i12 = 0; i12 < d13 && i11 < d11; i12++) {
                        jArr[i11] = d12;
                        i11++;
                    }
                    d12++;
                }
            }
            int d14 = qVar.d(4);
            if (d14 <= 2) {
                if (d14 == 1 || d14 == 2) {
                    qVar.e(32);
                    qVar.e(32);
                    int d15 = qVar.d(4) + 1;
                    qVar.e(1);
                    if (d14 != 1) {
                        j10 = d11 * d10;
                    } else if (d10 != 0) {
                        j10 = b(d11, d10);
                    }
                    qVar.e((int) (j10 * d15));
                }
                return new a(d10, d11, jArr, d14, c4);
            }
            StringBuilder sb2 = new StringBuilder(53);
            sb2.append("lookup type greater than 2 not decodable: ");
            sb2.append(d14);
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }
        int b4 = qVar.b();
        StringBuilder sb3 = new StringBuilder(66);
        sb3.append("expected code book to start with [0x56, 0x43, 0x42] at ");
        sb3.append(b4);
        throw ParserException.createForMalformedContainer(sb3.toString(), null);
    }

    public static void d(q qVar) throws ParserException {
        int d10 = qVar.d(6) + 1;
        for (int i10 = 0; i10 < d10; i10++) {
            int d11 = qVar.d(16);
            if (d11 == 0) {
                qVar.e(8);
                qVar.e(16);
                qVar.e(16);
                qVar.e(6);
                qVar.e(8);
                int d12 = qVar.d(4) + 1;
                for (int i11 = 0; i11 < d12; i11++) {
                    qVar.e(8);
                }
            } else if (d11 == 1) {
                int d13 = qVar.d(5);
                int i12 = -1;
                int[] iArr = new int[d13];
                for (int i13 = 0; i13 < d13; i13++) {
                    iArr[i13] = qVar.d(4);
                    if (iArr[i13] > i12) {
                        i12 = iArr[i13];
                    }
                }
                int i14 = i12 + 1;
                int[] iArr2 = new int[i14];
                for (int i15 = 0; i15 < i14; i15++) {
                    iArr2[i15] = qVar.d(3) + 1;
                    int d14 = qVar.d(2);
                    if (d14 > 0) {
                        qVar.e(8);
                    }
                    for (int i16 = 0; i16 < (1 << d14); i16++) {
                        qVar.e(8);
                    }
                }
                qVar.e(2);
                int d15 = qVar.d(4);
                int i17 = 0;
                int i18 = 0;
                for (int i19 = 0; i19 < d13; i19++) {
                    i17 += iArr2[iArr[i19]];
                    while (i18 < i17) {
                        qVar.e(d15);
                        i18++;
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder(52);
                sb2.append("floor type greater than 1 not decodable: ");
                sb2.append(d11);
                throw ParserException.createForMalformedContainer(sb2.toString(), null);
            }
        }
    }

    public static void e(int i10, q qVar) throws ParserException {
        int d10 = qVar.d(6) + 1;
        for (int i11 = 0; i11 < d10; i11++) {
            int d11 = qVar.d(16);
            if (d11 != 0) {
                StringBuilder sb2 = new StringBuilder(52);
                sb2.append("mapping type other than 0 not supported: ");
                sb2.append(d11);
                m.c("VorbisUtil", sb2.toString());
            } else {
                int d12 = qVar.c() ? qVar.d(4) + 1 : 1;
                if (qVar.c()) {
                    int d13 = qVar.d(8) + 1;
                    for (int i12 = 0; i12 < d13; i12++) {
                        int i13 = i10 - 1;
                        qVar.e(a(i13));
                        qVar.e(a(i13));
                    }
                }
                if (qVar.d(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (d12 > 1) {
                    for (int i14 = 0; i14 < i10; i14++) {
                        qVar.e(4);
                    }
                }
                for (int i15 = 0; i15 < d12; i15++) {
                    qVar.e(8);
                    qVar.e(8);
                    qVar.e(8);
                }
            }
        }
    }

    public static c[] f(q qVar) {
        int d10 = qVar.d(6) + 1;
        c[] cVarArr = new c[d10];
        for (int i10 = 0; i10 < d10; i10++) {
            cVarArr[i10] = new c(qVar.c(), qVar.d(16), qVar.d(16), qVar.d(8));
        }
        return cVarArr;
    }

    public static void g(q qVar) throws ParserException {
        int d10 = qVar.d(6) + 1;
        for (int i10 = 0; i10 < d10; i10++) {
            if (qVar.d(16) <= 2) {
                qVar.e(24);
                qVar.e(24);
                qVar.e(24);
                int d11 = qVar.d(6) + 1;
                qVar.e(8);
                int[] iArr = new int[d11];
                for (int i11 = 0; i11 < d11; i11++) {
                    iArr[i11] = ((qVar.c() ? qVar.d(5) : 0) * 8) + qVar.d(3);
                }
                for (int i12 = 0; i12 < d11; i12++) {
                    for (int i13 = 0; i13 < 8; i13++) {
                        if ((iArr[i12] & (1 << i13)) != 0) {
                            qVar.e(8);
                        }
                    }
                }
            } else {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
        }
    }

    public static b h(ParsableByteArray parsableByteArray) throws ParserException {
        return i(parsableByteArray, true, true);
    }

    public static b i(ParsableByteArray parsableByteArray, boolean z10, boolean z11) throws ParserException {
        if (z10) {
            l(3, parsableByteArray, false);
        }
        String A = parsableByteArray.A((int) parsableByteArray.t());
        int length = 11 + A.length();
        long t2 = parsableByteArray.t();
        String[] strArr = new String[(int) t2];
        int i10 = length + 4;
        for (int i11 = 0; i11 < t2; i11++) {
            strArr[i11] = parsableByteArray.A((int) parsableByteArray.t());
            i10 = i10 + 4 + strArr[i11].length();
        }
        if (z11 && (parsableByteArray.D() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new b(A, strArr, i10 + 1);
    }

    public static d j(ParsableByteArray parsableByteArray) throws ParserException {
        l(1, parsableByteArray, false);
        int u10 = parsableByteArray.u();
        int D = parsableByteArray.D();
        int u11 = parsableByteArray.u();
        int q10 = parsableByteArray.q();
        if (q10 <= 0) {
            q10 = -1;
        }
        int q11 = parsableByteArray.q();
        if (q11 <= 0) {
            q11 = -1;
        }
        int q12 = parsableByteArray.q();
        if (q12 <= 0) {
            q12 = -1;
        }
        int D2 = parsableByteArray.D();
        return new d(u10, D, u11, q10, q11, q12, (int) Math.pow(2.0d, D2 & 15), (int) Math.pow(2.0d, (D2 & 240) >> 4), (parsableByteArray.D() & 1) > 0, Arrays.copyOf(parsableByteArray.d(), parsableByteArray.f()));
    }

    public static c[] k(ParsableByteArray parsableByteArray, int i10) throws ParserException {
        l(5, parsableByteArray, false);
        int D = parsableByteArray.D() + 1;
        q qVar = new q(parsableByteArray.d());
        qVar.e(parsableByteArray.e() * 8);
        for (int i11 = 0; i11 < D; i11++) {
            c(qVar);
        }
        int d10 = qVar.d(6) + 1;
        for (int i12 = 0; i12 < d10; i12++) {
            if (qVar.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        d(qVar);
        g(qVar);
        e(i10, qVar);
        c[] f10 = f(qVar);
        if (qVar.c()) {
            return f10;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }

    public static boolean l(int i10, ParsableByteArray parsableByteArray, boolean z10) throws ParserException {
        if (parsableByteArray.a() < 7) {
            if (z10) {
                return false;
            }
            int a10 = parsableByteArray.a();
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("too short header: ");
            sb2.append(a10);
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }
        if (parsableByteArray.D() != i10) {
            if (z10) {
                return false;
            }
            String valueOf = String.valueOf(Integer.toHexString(i10));
            throw ParserException.createForMalformedContainer(valueOf.length() != 0 ? "expected header type ".concat(valueOf) : new String("expected header type "), null);
        }
        if (parsableByteArray.D() == 118 && parsableByteArray.D() == 111 && parsableByteArray.D() == 114 && parsableByteArray.D() == 98 && parsableByteArray.D() == 105 && parsableByteArray.D() == 115) {
            return true;
        }
        if (z10) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
    }
}
