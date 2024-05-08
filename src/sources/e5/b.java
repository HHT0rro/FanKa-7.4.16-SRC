package e5;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.c;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import d5.d;
import d5.e;
import d5.h;
import d5.n;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: AmrExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Extractor {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f48863r;

    /* renamed from: u, reason: collision with root package name */
    public static final int f48866u;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f48867a;

    /* renamed from: b, reason: collision with root package name */
    public final int f48868b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f48869c;

    /* renamed from: d, reason: collision with root package name */
    public long f48870d;

    /* renamed from: e, reason: collision with root package name */
    public int f48871e;

    /* renamed from: f, reason: collision with root package name */
    public int f48872f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f48873g;

    /* renamed from: h, reason: collision with root package name */
    public long f48874h;

    /* renamed from: i, reason: collision with root package name */
    public int f48875i;

    /* renamed from: j, reason: collision with root package name */
    public int f48876j;

    /* renamed from: k, reason: collision with root package name */
    public long f48877k;

    /* renamed from: l, reason: collision with root package name */
    public e f48878l;

    /* renamed from: m, reason: collision with root package name */
    public TrackOutput f48879m;

    /* renamed from: n, reason: collision with root package name */
    public i f48880n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f48881o;

    /* renamed from: p, reason: collision with root package name */
    public static final d5.i f48861p = new d5.i() { // from class: e5.a
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] m10;
            m10 = b.m();
            return m10;
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f48862q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: s, reason: collision with root package name */
    public static final byte[] f48864s = j0.i0("#!AMR\n");

    /* renamed from: t, reason: collision with root package name */
    public static final byte[] f48865t = j0.i0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f48863r = iArr;
        f48866u = iArr[8];
    }

    public b() {
        this(0);
    }

    public static int e(int i10, long j10) {
        return (int) (((i10 * 8) * 1000000) / j10);
    }

    public static /* synthetic */ Extractor[] m() {
        return new Extractor[]{new b()};
    }

    public static boolean p(d dVar, byte[] bArr) throws IOException {
        dVar.m();
        byte[] bArr2 = new byte[bArr.length];
        dVar.j(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        this.f48870d = 0L;
        this.f48871e = 0;
        this.f48872f = 0;
        if (j10 != 0) {
            i iVar = this.f48880n;
            if (iVar instanceof c) {
                this.f48877k = ((c) iVar).b(j10);
                return;
            }
        }
        this.f48877k = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(e eVar) {
        this.f48878l = eVar;
        this.f48879m = eVar.c(0, 1);
        eVar.l();
    }

    public final void d() {
        com.google.android.exoplayer2.util.a.i(this.f48879m);
        j0.j(this.f48878l);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d dVar, n nVar) throws IOException {
        d();
        if (dVar.getPosition() == 0 && !r(dVar)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        n();
        int s2 = s(dVar);
        o(dVar.b(), s2);
        return s2;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d dVar) throws IOException {
        return r(dVar);
    }

    public final i h(long j10) {
        return new c(j10, this.f48874h, e(this.f48875i, 20000L), this.f48875i);
    }

    public final int i(int i10) throws ParserException {
        if (k(i10)) {
            return this.f48869c ? f48863r[i10] : f48862q[i10];
        }
        String str = this.f48869c ? "WB" : "NB";
        StringBuilder sb2 = new StringBuilder(str.length() + 35);
        sb2.append("Illegal AMR ");
        sb2.append(str);
        sb2.append(" frame type ");
        sb2.append(i10);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    public final boolean j(int i10) {
        return !this.f48869c && (i10 < 12 || i10 > 14);
    }

    public final boolean k(int i10) {
        return i10 >= 0 && i10 <= 15 && (l(i10) || j(i10));
    }

    public final boolean l(int i10) {
        return this.f48869c && (i10 < 10 || i10 > 13);
    }

    public final void n() {
        if (this.f48881o) {
            return;
        }
        this.f48881o = true;
        boolean z10 = this.f48869c;
        this.f48879m.b(new Format.b().e0(z10 ? "audio/amr-wb" : "audio/3gpp").W(f48866u).H(1).f0(z10 ? 16000 : 8000).E());
    }

    public final void o(long j10, int i10) {
        int i11;
        if (this.f48873g) {
            return;
        }
        if ((this.f48868b & 1) != 0 && j10 != -1 && ((i11 = this.f48875i) == -1 || i11 == this.f48871e)) {
            if (this.f48876j >= 20 || i10 == -1) {
                i h10 = h(j10);
                this.f48880n = h10;
                this.f48878l.r(h10);
                this.f48873g = true;
                return;
            }
            return;
        }
        i.b bVar = new i.b(-9223372036854775807L);
        this.f48880n = bVar;
        this.f48878l.r(bVar);
        this.f48873g = true;
    }

    public final int q(d dVar) throws IOException {
        dVar.m();
        dVar.j(this.f48867a, 0, 1);
        byte b4 = this.f48867a[0];
        if ((b4 & 131) <= 0) {
            return i((b4 >> 3) & 15);
        }
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("Invalid padding bits for frame header ");
        sb2.append((int) b4);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    public final boolean r(d dVar) throws IOException {
        byte[] bArr = f48864s;
        if (p(dVar, bArr)) {
            this.f48869c = false;
            dVar.r(bArr.length);
            return true;
        }
        byte[] bArr2 = f48865t;
        if (!p(dVar, bArr2)) {
            return false;
        }
        this.f48869c = true;
        dVar.r(bArr2.length);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public final int s(d dVar) throws IOException {
        if (this.f48872f == 0) {
            try {
                int q10 = q(dVar);
                this.f48871e = q10;
                this.f48872f = q10;
                if (this.f48875i == -1) {
                    this.f48874h = dVar.getPosition();
                    this.f48875i = this.f48871e;
                }
                if (this.f48875i == this.f48871e) {
                    this.f48876j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int c4 = this.f48879m.c(dVar, this.f48872f, true);
        if (c4 == -1) {
            return -1;
        }
        int i10 = this.f48872f - c4;
        this.f48872f = i10;
        if (i10 > 0) {
            return 0;
        }
        this.f48879m.d(this.f48877k + this.f48870d, 1, this.f48871e, 0, null);
        this.f48870d += 20000;
        return 0;
    }

    public b(int i10) {
        this.f48868b = i10;
        this.f48867a = new byte[1];
        this.f48875i = -1;
    }
}
