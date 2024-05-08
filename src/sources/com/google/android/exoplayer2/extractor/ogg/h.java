package com.google.android.exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: VorbisReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h extends StreamReader {

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public a f20321n;

    /* renamed from: o, reason: collision with root package name */
    public int f20322o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20323p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public j.d f20324q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public j.b f20325r;

    /* compiled from: VorbisReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final j.d f20326a;

        /* renamed from: b, reason: collision with root package name */
        public final j.b f20327b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f20328c;

        /* renamed from: d, reason: collision with root package name */
        public final j.c[] f20329d;

        /* renamed from: e, reason: collision with root package name */
        public final int f20330e;

        public a(j.d dVar, j.b bVar, byte[] bArr, j.c[] cVarArr, int i10) {
            this.f20326a = dVar;
            this.f20327b = bVar;
            this.f20328c = bArr;
            this.f20329d = cVarArr;
            this.f20330e = i10;
        }
    }

    @VisibleForTesting
    public static void n(ParsableByteArray parsableByteArray, long j10) {
        if (parsableByteArray.b() < parsableByteArray.f() + 4) {
            parsableByteArray.M(Arrays.copyOf(parsableByteArray.d(), parsableByteArray.f() + 4));
        } else {
            parsableByteArray.O(parsableByteArray.f() + 4);
        }
        byte[] d10 = parsableByteArray.d();
        d10[parsableByteArray.f() - 4] = (byte) (j10 & 255);
        d10[parsableByteArray.f() - 3] = (byte) ((j10 >>> 8) & 255);
        d10[parsableByteArray.f() - 2] = (byte) ((j10 >>> 16) & 255);
        d10[parsableByteArray.f() - 1] = (byte) ((j10 >>> 24) & 255);
    }

    public static int o(byte b4, a aVar) {
        if (!aVar.f20329d[p(b4, aVar.f20330e, 1)].f20089a) {
            return aVar.f20326a.f20099g;
        }
        return aVar.f20326a.f20100h;
    }

    @VisibleForTesting
    public static int p(byte b4, int i10, int i11) {
        return (b4 >> i11) & (255 >>> (8 - i10));
    }

    public static boolean r(ParsableByteArray parsableByteArray) {
        try {
            return j.l(1, parsableByteArray, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void e(long j10) {
        super.e(j10);
        this.f20323p = j10 != 0;
        j.d dVar = this.f20324q;
        this.f20322o = dVar != null ? dVar.f20099g : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long f(ParsableByteArray parsableByteArray) {
        if ((parsableByteArray.d()[0] & 1) == 1) {
            return -1L;
        }
        int o10 = o(parsableByteArray.d()[0], (a) com.google.android.exoplayer2.util.a.i(this.f20321n));
        long j10 = this.f20323p ? (this.f20322o + o10) / 4 : 0;
        n(parsableByteArray, j10);
        this.f20323p = true;
        this.f20322o = o10;
        return j10;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean h(ParsableByteArray parsableByteArray, long j10, StreamReader.SetupData setupData) throws IOException {
        if (this.f20321n != null) {
            com.google.android.exoplayer2.util.a.e(setupData.format);
            return false;
        }
        a q10 = q(parsableByteArray);
        this.f20321n = q10;
        if (q10 == null) {
            return true;
        }
        j.d dVar = q10.f20326a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f20102j);
        arrayList.add(q10.f20328c);
        setupData.format = new Format.b().e0("audio/vorbis").G(dVar.f20097e).Z(dVar.f20096d).H(dVar.f20094b).f0(dVar.f20095c).T(arrayList).E();
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f20321n = null;
            this.f20324q = null;
            this.f20325r = null;
        }
        this.f20322o = 0;
        this.f20323p = false;
    }

    @Nullable
    @VisibleForTesting
    public a q(ParsableByteArray parsableByteArray) throws IOException {
        j.d dVar = this.f20324q;
        if (dVar == null) {
            this.f20324q = j.j(parsableByteArray);
            return null;
        }
        j.b bVar = this.f20325r;
        if (bVar == null) {
            this.f20325r = j.h(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.f()];
        System.arraycopy((Object) parsableByteArray.d(), 0, (Object) bArr, 0, parsableByteArray.f());
        return new a(dVar, bVar, bArr, j.k(parsableByteArray, dVar.f20094b), j.a(r4.length - 1));
    }
}
