package com.google.android.exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import d5.j;
import java.util.Arrays;

/* compiled from: FlacReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends StreamReader {

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.extractor.g f20292n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public a f20293o;

    /* compiled from: FlacReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements OggSeeker {

        /* renamed from: a, reason: collision with root package name */
        public com.google.android.exoplayer2.extractor.g f20294a;

        /* renamed from: b, reason: collision with root package name */
        public g.a f20295b;

        /* renamed from: c, reason: collision with root package name */
        public long f20296c = -1;

        /* renamed from: d, reason: collision with root package name */
        public long f20297d = -1;

        public a(com.google.android.exoplayer2.extractor.g gVar, g.a aVar) {
            this.f20294a = gVar;
            this.f20295b = aVar;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long a(d5.d dVar) {
            long j10 = this.f20297d;
            if (j10 < 0) {
                return -1L;
            }
            long j11 = -(j10 + 2);
            this.f20297d = -1L;
            return j11;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public i b() {
            com.google.android.exoplayer2.util.a.g(this.f20296c != -1);
            return new com.google.android.exoplayer2.extractor.f(this.f20294a, this.f20296c);
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void c(long j10) {
            long[] jArr = this.f20295b.f20071a;
            this.f20297d = jArr[j0.i(jArr, j10, true, true)];
        }

        public void d(long j10) {
            this.f20296c = j10;
        }
    }

    public static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(ParsableByteArray parsableByteArray) {
        return parsableByteArray.a() >= 5 && parsableByteArray.D() == 127 && parsableByteArray.F() == 1179402563;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long f(ParsableByteArray parsableByteArray) {
        if (o(parsableByteArray.d())) {
            return n(parsableByteArray);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean h(ParsableByteArray parsableByteArray, long j10, StreamReader.SetupData setupData) {
        byte[] d10 = parsableByteArray.d();
        com.google.android.exoplayer2.extractor.g gVar = this.f20292n;
        if (gVar == null) {
            com.google.android.exoplayer2.extractor.g gVar2 = new com.google.android.exoplayer2.extractor.g(d10, 17);
            this.f20292n = gVar2;
            setupData.format = gVar2.h(Arrays.copyOfRange(d10, 9, parsableByteArray.f()), null);
            return true;
        }
        if ((d10[0] & Byte.MAX_VALUE) == 3) {
            g.a g3 = com.google.android.exoplayer2.extractor.e.g(parsableByteArray);
            com.google.android.exoplayer2.extractor.g c4 = gVar.c(g3);
            this.f20292n = c4;
            this.f20293o = new a(c4, g3);
            return true;
        }
        if (!o(d10)) {
            return true;
        }
        a aVar = this.f20293o;
        if (aVar != null) {
            aVar.d(j10);
            setupData.oggSeeker = this.f20293o;
        }
        com.google.android.exoplayer2.util.a.e(setupData.format);
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f20292n = null;
            this.f20293o = null;
        }
    }

    public final int n(ParsableByteArray parsableByteArray) {
        int i10 = (parsableByteArray.d()[2] & 255) >> 4;
        if (i10 == 6 || i10 == 7) {
            parsableByteArray.Q(4);
            parsableByteArray.K();
        }
        int j10 = j.j(parsableByteArray, i10);
        parsableByteArray.P(0);
        return j10;
    }
}
