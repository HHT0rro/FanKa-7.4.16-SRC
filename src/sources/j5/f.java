package j5;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import d5.l;
import d5.m;
import d5.n;
import j5.g;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import r5.b;
import x4.v;

/* compiled from: Mp3Extractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements Extractor {

    /* renamed from: u, reason: collision with root package name */
    public static final d5.i f50307u = new d5.i() { // from class: j5.d
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return d5.h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] o10;
            o10 = f.o();
            return o10;
        }
    };

    /* renamed from: v, reason: collision with root package name */
    public static final b.a f50308v = new b.a() { // from class: j5.e
        @Override // r5.b.a
        public final boolean a(int i10, int i11, int i12, int i13, int i14) {
            boolean p10;
            p10 = f.p(i10, i11, i12, i13, i14);
            return p10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f50309a;

    /* renamed from: b, reason: collision with root package name */
    public final long f50310b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f50311c;

    /* renamed from: d, reason: collision with root package name */
    public final v.a f50312d;

    /* renamed from: e, reason: collision with root package name */
    public final l f50313e;

    /* renamed from: f, reason: collision with root package name */
    public final m f50314f;

    /* renamed from: g, reason: collision with root package name */
    public final TrackOutput f50315g;

    /* renamed from: h, reason: collision with root package name */
    public d5.e f50316h;

    /* renamed from: i, reason: collision with root package name */
    public TrackOutput f50317i;

    /* renamed from: j, reason: collision with root package name */
    public TrackOutput f50318j;

    /* renamed from: k, reason: collision with root package name */
    public int f50319k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Metadata f50320l;

    /* renamed from: m, reason: collision with root package name */
    public long f50321m;

    /* renamed from: n, reason: collision with root package name */
    public long f50322n;

    /* renamed from: o, reason: collision with root package name */
    public long f50323o;

    /* renamed from: p, reason: collision with root package name */
    public int f50324p;

    /* renamed from: q, reason: collision with root package name */
    public g f50325q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f50326r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f50327s;

    /* renamed from: t, reason: collision with root package name */
    public long f50328t;

    public f() {
        this(0);
    }

    public static long l(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int d10 = metadata.d();
        for (int i10 = 0; i10 < d10; i10++) {
            Metadata.Entry c4 = metadata.c(i10);
            if (c4 instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) c4;
                if (textInformationFrame.f20903b.equals("TLEN")) {
                    return com.google.android.exoplayer2.h.d(Long.parseLong(textInformationFrame.f20915d));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static int m(ParsableByteArray parsableByteArray, int i10) {
        if (parsableByteArray.f() >= i10 + 4) {
            parsableByteArray.P(i10);
            int n10 = parsableByteArray.n();
            if (n10 == 1483304551 || n10 == 1231971951) {
                return n10;
            }
        }
        if (parsableByteArray.f() < 40) {
            return 0;
        }
        parsableByteArray.P(36);
        return parsableByteArray.n() == 1447187017 ? 1447187017 : 0;
    }

    public static boolean n(int i10, long j10) {
        return ((long) (i10 & (-128000))) == (j10 & (-128000));
    }

    public static /* synthetic */ Extractor[] o() {
        return new Extractor[]{new f()};
    }

    public static /* synthetic */ boolean p(int i10, int i11, int i12, int i13, int i14) {
        return (i11 == 67 && i12 == 79 && i13 == 77 && (i14 == 77 || i10 == 2)) || (i11 == 77 && i12 == 76 && i13 == 76 && (i14 == 84 || i10 == 2));
    }

    @Nullable
    public static c q(@Nullable Metadata metadata, long j10) {
        if (metadata == null) {
            return null;
        }
        int d10 = metadata.d();
        for (int i10 = 0; i10 < d10; i10++) {
            Metadata.Entry c4 = metadata.c(i10);
            if (c4 instanceof MlltFrame) {
                return c.a(j10, (MlltFrame) c4, l(metadata));
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        this.f50319k = 0;
        this.f50321m = -9223372036854775807L;
        this.f50322n = 0L;
        this.f50324p = 0;
        this.f50328t = j11;
        g gVar = this.f50325q;
        if (!(gVar instanceof b) || ((b) gVar).a(j11)) {
            return;
        }
        this.f50327s = true;
        this.f50318j = this.f50315g;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f50316h = eVar;
        TrackOutput c4 = eVar.c(0, 1);
        this.f50317i = c4;
        this.f50318j = c4;
        this.f50316h.l();
    }

    public final void e() {
        com.google.android.exoplayer2.util.a.i(this.f50317i);
        j0.j(this.f50316h);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, n nVar) throws IOException {
        e();
        int t2 = t(dVar);
        if (t2 == -1 && (this.f50325q instanceof b)) {
            long i10 = i(this.f50322n);
            if (this.f50325q.i() != i10) {
                ((b) this.f50325q).f(i10);
                this.f50316h.r(this.f50325q);
            }
        }
        return t2;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        return v(dVar, true);
    }

    public final g h(d5.d dVar) throws IOException {
        long l10;
        long j10;
        long i10;
        long h10;
        g r10 = r(dVar);
        c q10 = q(this.f50320l, dVar.getPosition());
        if (this.f50326r) {
            return new g.a();
        }
        if ((this.f50309a & 2) != 0) {
            if (q10 != null) {
                i10 = q10.i();
                h10 = q10.h();
            } else if (r10 != null) {
                i10 = r10.i();
                h10 = r10.h();
            } else {
                l10 = l(this.f50320l);
                j10 = -1;
                r10 = new b(l10, dVar.getPosition(), j10);
            }
            j10 = h10;
            l10 = i10;
            r10 = new b(l10, dVar.getPosition(), j10);
        } else if (q10 != null) {
            r10 = q10;
        } else if (r10 == null) {
            r10 = null;
        }
        return (r10 == null || !(r10.e() || (this.f50309a & 1) == 0)) ? k(dVar) : r10;
    }

    public final long i(long j10) {
        return this.f50321m + ((j10 * 1000000) / this.f50312d.f54452d);
    }

    public void j() {
        this.f50326r = true;
    }

    public final g k(d5.d dVar) throws IOException {
        dVar.j(this.f50311c.d(), 0, 4);
        this.f50311c.P(0);
        this.f50312d.a(this.f50311c.n());
        return new a(dVar.b(), dVar.getPosition(), this.f50312d);
    }

    @Nullable
    public final g r(d5.d dVar) throws IOException {
        int i10;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f50312d.f54451c);
        dVar.j(parsableByteArray.d(), 0, this.f50312d.f54451c);
        v.a aVar = this.f50312d;
        if ((aVar.f54449a & 1) != 0) {
            if (aVar.f54453e != 1) {
                i10 = 36;
            }
            i10 = 21;
        } else {
            if (aVar.f54453e == 1) {
                i10 = 13;
            }
            i10 = 21;
        }
        int m10 = m(parsableByteArray, i10);
        if (m10 != 1483304551 && m10 != 1231971951) {
            if (m10 == 1447187017) {
                h a10 = h.a(dVar.b(), dVar.getPosition(), this.f50312d, parsableByteArray);
                dVar.r(this.f50312d.f54451c);
                return a10;
            }
            dVar.m();
            return null;
        }
        i a11 = i.a(dVar.b(), dVar.getPosition(), this.f50312d, parsableByteArray);
        if (a11 != null && !this.f50313e.a()) {
            dVar.m();
            dVar.q(i10 + 141);
            dVar.j(this.f50311c.d(), 0, 3);
            this.f50311c.P(0);
            this.f50313e.d(this.f50311c.G());
        }
        dVar.r(this.f50312d.f54451c);
        return (a11 == null || a11.e() || m10 != 1231971951) ? a11 : k(dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public final boolean s(d5.d dVar) throws IOException {
        g gVar = this.f50325q;
        if (gVar != null) {
            long h10 = gVar.h();
            if (h10 != -1 && dVar.o() > h10 - 4) {
                return true;
            }
        }
        try {
            return !dVar.l(this.f50311c.d(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final int t(d5.d dVar) throws IOException {
        if (this.f50319k == 0) {
            try {
                v(dVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f50325q == null) {
            g h10 = h(dVar);
            this.f50325q = h10;
            this.f50316h.r(h10);
            this.f50318j.b(new Format.b().e0(this.f50312d.f54450b).W(4096).H(this.f50312d.f54453e).f0(this.f50312d.f54452d).M(this.f50313e.f48639a).N(this.f50313e.f48640b).X((this.f50309a & 4) != 0 ? null : this.f50320l).E());
            this.f50323o = dVar.getPosition();
        } else if (this.f50323o != 0) {
            long position = dVar.getPosition();
            long j10 = this.f50323o;
            if (position < j10) {
                dVar.r((int) (j10 - position));
            }
        }
        return u(dVar);
    }

    public final int u(d5.d dVar) throws IOException {
        if (this.f50324p == 0) {
            dVar.m();
            if (s(dVar)) {
                return -1;
            }
            this.f50311c.P(0);
            int n10 = this.f50311c.n();
            if (n(n10, this.f50319k) && v.j(n10) != -1) {
                this.f50312d.a(n10);
                if (this.f50321m == -9223372036854775807L) {
                    this.f50321m = this.f50325q.c(dVar.getPosition());
                    if (this.f50310b != -9223372036854775807L) {
                        this.f50321m += this.f50310b - this.f50325q.c(0L);
                    }
                }
                this.f50324p = this.f50312d.f54451c;
                g gVar = this.f50325q;
                if (gVar instanceof b) {
                    b bVar = (b) gVar;
                    bVar.b(i(this.f50322n + r0.f54455g), dVar.getPosition() + this.f50312d.f54451c);
                    if (this.f50327s && bVar.a(this.f50328t)) {
                        this.f50327s = false;
                        this.f50318j = this.f50317i;
                    }
                }
            } else {
                dVar.r(1);
                this.f50319k = 0;
                return 0;
            }
        }
        int c4 = this.f50318j.c(dVar, this.f50324p, true);
        if (c4 == -1) {
            return -1;
        }
        int i10 = this.f50324p - c4;
        this.f50324p = i10;
        if (i10 > 0) {
            return 0;
        }
        this.f50318j.d(i(this.f50322n), 1, this.f50312d.f54451c, 0, null);
        this.f50322n += this.f50312d.f54455g;
        this.f50324p = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
    
        if (r14 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
    
        r13.r(r2 + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a7, code lost:
    
        r12.f50319k = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a9, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        r13.m();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean v(d5.d r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L6
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L8
        L6:
            r0 = 131072(0x20000, float:1.83671E-40)
        L8:
            r13.m()
            long r1 = r13.getPosition()
            r3 = 0
            r5 = 0
            r6 = 4
            r7 = 1
            r8 = 0
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 != 0) goto L42
            int r1 = r12.f50309a
            r1 = r1 & r6
            if (r1 != 0) goto L20
            r1 = 1
            goto L21
        L20:
            r1 = 0
        L21:
            if (r1 == 0) goto L25
            r1 = r5
            goto L27
        L25:
            r5.b$a r1 = j5.f.f50308v
        L27:
            d5.m r2 = r12.f50314f
            com.google.android.exoplayer2.metadata.Metadata r1 = r2.a(r13, r1)
            r12.f50320l = r1
            if (r1 == 0) goto L36
            d5.l r2 = r12.f50313e
            r2.c(r1)
        L36:
            long r1 = r13.o()
            int r2 = (int) r1
            if (r14 != 0) goto L40
            r13.r(r2)
        L40:
            r1 = 0
            goto L44
        L42:
            r1 = 0
            r2 = 0
        L44:
            r3 = 0
            r4 = 0
        L46:
            boolean r9 = r12.s(r13)
            if (r9 == 0) goto L55
            if (r3 <= 0) goto L4f
            goto L9d
        L4f:
            java.io.EOFException r13 = new java.io.EOFException
            r13.<init>()
            throw r13
        L55:
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r12.f50311c
            r9.P(r8)
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r12.f50311c
            int r9 = r9.n()
            if (r1 == 0) goto L69
            long r10 = (long) r1
            boolean r10 = n(r9, r10)
            if (r10 == 0) goto L70
        L69:
            int r10 = x4.v.j(r9)
            r11 = -1
            if (r10 != r11) goto L90
        L70:
            int r1 = r4 + 1
            if (r4 != r0) goto L7e
            if (r14 == 0) goto L77
            return r8
        L77:
            java.lang.String r13 = "Searched too many bytes."
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedContainer(r13, r5)
            throw r13
        L7e:
            if (r14 == 0) goto L89
            r13.m()
            int r3 = r2 + r1
            r13.q(r3)
            goto L8c
        L89:
            r13.r(r7)
        L8c:
            r4 = r1
            r1 = 0
            r3 = 0
            goto L46
        L90:
            int r3 = r3 + 1
            if (r3 != r7) goto L9b
            x4.v$a r1 = r12.f50312d
            r1.a(r9)
            r1 = r9
            goto Laa
        L9b:
            if (r3 != r6) goto Laa
        L9d:
            if (r14 == 0) goto La4
            int r2 = r2 + r4
            r13.r(r2)
            goto La7
        La4:
            r13.m()
        La7:
            r12.f50319k = r1
            return r7
        Laa:
            int r10 = r10 + (-4)
            r13.q(r10)
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.f.v(d5.d, boolean):boolean");
    }

    public f(int i10) {
        this(i10, -9223372036854775807L);
    }

    public f(int i10, long j10) {
        this.f50309a = i10;
        this.f50310b = j10;
        this.f50311c = new ParsableByteArray(10);
        this.f50312d = new v.a();
        this.f50313e = new l();
        this.f50321m = -9223372036854775807L;
        this.f50314f = new m();
        com.google.android.exoplayer2.extractor.d dVar = new com.google.android.exoplayer2.extractor.d();
        this.f50315g = dVar;
        this.f50318j = dVar;
    }
}
