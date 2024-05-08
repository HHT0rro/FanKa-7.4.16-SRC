package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.u;
import d5.m;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: FlacMetadataReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* compiled from: FlacMetadataReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public g f20045a;

        public a(@Nullable g gVar) {
            this.f20045a = gVar;
        }
    }

    public static boolean a(d5.d dVar) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        dVar.j(parsableByteArray.d(), 0, 4);
        return parsableByteArray.F() == 1716281667;
    }

    public static int b(d5.d dVar) throws IOException {
        dVar.m();
        ParsableByteArray parsableByteArray = new ParsableByteArray(2);
        dVar.j(parsableByteArray.d(), 0, 2);
        int J = parsableByteArray.J();
        if ((J >> 2) == 16382) {
            dVar.m();
            return J;
        }
        dVar.m();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    @Nullable
    public static Metadata c(d5.d dVar, boolean z10) throws IOException {
        Metadata a10 = new m().a(dVar, z10 ? null : r5.b.f53290b);
        if (a10 == null || a10.d() == 0) {
            return null;
        }
        return a10;
    }

    @Nullable
    public static Metadata d(d5.d dVar, boolean z10) throws IOException {
        dVar.m();
        long o10 = dVar.o();
        Metadata c4 = c(dVar, z10);
        dVar.r((int) (dVar.o() - o10));
        return c4;
    }

    public static boolean e(d5.d dVar, a aVar) throws IOException {
        dVar.m();
        u uVar = new u(new byte[4]);
        dVar.j(uVar.f23029a, 0, 4);
        boolean g3 = uVar.g();
        int h10 = uVar.h(7);
        int h11 = uVar.h(24) + 4;
        if (h10 == 0) {
            aVar.f20045a = i(dVar);
        } else {
            g gVar = aVar.f20045a;
            if (gVar == null) {
                throw new IllegalArgumentException();
            }
            if (h10 == 3) {
                aVar.f20045a = gVar.c(h(dVar, h11));
            } else if (h10 == 4) {
                aVar.f20045a = gVar.d(k(dVar, h11));
            } else if (h10 == 6) {
                aVar.f20045a = gVar.b(Collections.singletonList(f(dVar, h11)));
            } else {
                dVar.r(h11);
            }
        }
        return g3;
    }

    public static PictureFrame f(d5.d dVar, int i10) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i10);
        dVar.readFully(parsableByteArray.d(), 0, i10);
        parsableByteArray.Q(4);
        int n10 = parsableByteArray.n();
        String B = parsableByteArray.B(parsableByteArray.n(), com.google.common.base.c.f25959a);
        String A = parsableByteArray.A(parsableByteArray.n());
        int n11 = parsableByteArray.n();
        int n12 = parsableByteArray.n();
        int n13 = parsableByteArray.n();
        int n14 = parsableByteArray.n();
        int n15 = parsableByteArray.n();
        byte[] bArr = new byte[n15];
        parsableByteArray.j(bArr, 0, n15);
        return new PictureFrame(n10, B, A, n11, n12, n13, n14, bArr);
    }

    public static g.a g(ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(1);
        int G = parsableByteArray.G();
        long e2 = parsableByteArray.e() + G;
        int i10 = G / 18;
        long[] jArr = new long[i10];
        long[] jArr2 = new long[i10];
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            long w3 = parsableByteArray.w();
            if (w3 == -1) {
                jArr = Arrays.copyOf(jArr, i11);
                jArr2 = Arrays.copyOf(jArr2, i11);
                break;
            }
            jArr[i11] = w3;
            jArr2[i11] = parsableByteArray.w();
            parsableByteArray.Q(2);
            i11++;
        }
        parsableByteArray.Q((int) (e2 - parsableByteArray.e()));
        return new g.a(jArr, jArr2);
    }

    public static g.a h(d5.d dVar, int i10) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i10);
        dVar.readFully(parsableByteArray.d(), 0, i10);
        return g(parsableByteArray);
    }

    public static g i(d5.d dVar) throws IOException {
        byte[] bArr = new byte[38];
        dVar.readFully(bArr, 0, 38);
        return new g(bArr, 4);
    }

    public static void j(d5.d dVar) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        dVar.readFully(parsableByteArray.d(), 0, 4);
        if (parsableByteArray.F() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }

    public static List<String> k(d5.d dVar, int i10) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i10);
        dVar.readFully(parsableByteArray.d(), 0, i10);
        parsableByteArray.Q(4);
        return Arrays.asList(j.i(parsableByteArray, false, false).f20087b);
    }
}
