package f5;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import d5.e;
import d5.h;
import d5.i;
import d5.j;
import d5.n;
import java.io.IOException;
import java.util.Map;

/* compiled from: FlacExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements Extractor {

    /* renamed from: o, reason: collision with root package name */
    public static final i f49118o = new i() { // from class: f5.c
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] j10;
            j10 = d.j();
            return j10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f49119a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f49120b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f49121c;

    /* renamed from: d, reason: collision with root package name */
    public final j.a f49122d;

    /* renamed from: e, reason: collision with root package name */
    public e f49123e;

    /* renamed from: f, reason: collision with root package name */
    public TrackOutput f49124f;

    /* renamed from: g, reason: collision with root package name */
    public int f49125g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Metadata f49126h;

    /* renamed from: i, reason: collision with root package name */
    public g f49127i;

    /* renamed from: j, reason: collision with root package name */
    public int f49128j;

    /* renamed from: k, reason: collision with root package name */
    public int f49129k;

    /* renamed from: l, reason: collision with root package name */
    public b f49130l;

    /* renamed from: m, reason: collision with root package name */
    public int f49131m;

    /* renamed from: n, reason: collision with root package name */
    public long f49132n;

    public d() {
        this(0);
    }

    public static /* synthetic */ Extractor[] j() {
        return new Extractor[]{new d()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        if (j10 == 0) {
            this.f49125g = 0;
        } else {
            b bVar = this.f49130l;
            if (bVar != null) {
                bVar.h(j11);
            }
        }
        this.f49132n = j11 != 0 ? -1L : 0L;
        this.f49131m = 0;
        this.f49120b.L(0);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(e eVar) {
        this.f49123e = eVar;
        this.f49124f = eVar.c(0, 1);
        eVar.l();
    }

    public final long d(ParsableByteArray parsableByteArray, boolean z10) {
        boolean z11;
        com.google.android.exoplayer2.util.a.e(this.f49127i);
        int e2 = parsableByteArray.e();
        while (e2 <= parsableByteArray.f() - 16) {
            parsableByteArray.P(e2);
            if (j.d(parsableByteArray, this.f49127i, this.f49129k, this.f49122d)) {
                parsableByteArray.P(e2);
                return this.f49122d.f48636a;
            }
            e2++;
        }
        if (z10) {
            while (e2 <= parsableByteArray.f() - this.f49128j) {
                parsableByteArray.P(e2);
                try {
                    z11 = j.d(parsableByteArray, this.f49127i, this.f49129k, this.f49122d);
                } catch (IndexOutOfBoundsException unused) {
                    z11 = false;
                }
                if (parsableByteArray.e() <= parsableByteArray.f() ? z11 : false) {
                    parsableByteArray.P(e2);
                    return this.f49122d.f48636a;
                }
                e2++;
            }
            parsableByteArray.P(parsableByteArray.f());
            return -1L;
        }
        parsableByteArray.P(e2);
        return -1L;
    }

    public final void e(d5.d dVar) throws IOException {
        this.f49129k = com.google.android.exoplayer2.extractor.e.b(dVar);
        ((e) j0.j(this.f49123e)).r(h(dVar.getPosition(), dVar.b()));
        this.f49125g = 5;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, n nVar) throws IOException {
        int i10 = this.f49125g;
        if (i10 == 0) {
            m(dVar);
            return 0;
        }
        if (i10 == 1) {
            i(dVar);
            return 0;
        }
        if (i10 == 2) {
            o(dVar);
            return 0;
        }
        if (i10 == 3) {
            n(dVar);
            return 0;
        }
        if (i10 == 4) {
            e(dVar);
            return 0;
        }
        if (i10 == 5) {
            return l(dVar, nVar);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        com.google.android.exoplayer2.extractor.e.c(dVar, false);
        return com.google.android.exoplayer2.extractor.e.a(dVar);
    }

    public final com.google.android.exoplayer2.extractor.i h(long j10, long j11) {
        com.google.android.exoplayer2.util.a.e(this.f49127i);
        g gVar = this.f49127i;
        if (gVar.f20069k != null) {
            return new f(gVar, j10);
        }
        if (j11 != -1 && gVar.f20068j > 0) {
            b bVar = new b(gVar, this.f49129k, j10, j11);
            this.f49130l = bVar;
            return bVar.b();
        }
        return new i.b(gVar.g());
    }

    public final void i(d5.d dVar) throws IOException {
        byte[] bArr = this.f49119a;
        dVar.j(bArr, 0, bArr.length);
        dVar.m();
        this.f49125g = 2;
    }

    public final void k() {
        ((TrackOutput) j0.j(this.f49124f)).d((this.f49132n * 1000000) / ((g) j0.j(this.f49127i)).f20063e, 1, this.f49131m, 0, null);
    }

    public final int l(d5.d dVar, n nVar) throws IOException {
        boolean z10;
        com.google.android.exoplayer2.util.a.e(this.f49124f);
        com.google.android.exoplayer2.util.a.e(this.f49127i);
        b bVar = this.f49130l;
        if (bVar != null && bVar.d()) {
            return this.f49130l.c(dVar, nVar);
        }
        if (this.f49132n == -1) {
            this.f49132n = j.i(dVar, this.f49127i);
            return 0;
        }
        int f10 = this.f49120b.f();
        if (f10 < 32768) {
            int read = dVar.read(this.f49120b.d(), f10, 32768 - f10);
            z10 = read == -1;
            if (!z10) {
                this.f49120b.O(f10 + read);
            } else if (this.f49120b.a() == 0) {
                k();
                return -1;
            }
        } else {
            z10 = false;
        }
        int e2 = this.f49120b.e();
        int i10 = this.f49131m;
        int i11 = this.f49128j;
        if (i10 < i11) {
            ParsableByteArray parsableByteArray = this.f49120b;
            parsableByteArray.Q(Math.min(i11 - i10, parsableByteArray.a()));
        }
        long d10 = d(this.f49120b, z10);
        int e10 = this.f49120b.e() - e2;
        this.f49120b.P(e2);
        this.f49124f.a(this.f49120b, e10);
        this.f49131m += e10;
        if (d10 != -1) {
            k();
            this.f49131m = 0;
            this.f49132n = d10;
        }
        if (this.f49120b.a() < 16) {
            int a10 = this.f49120b.a();
            System.arraycopy((Object) this.f49120b.d(), this.f49120b.e(), (Object) this.f49120b.d(), 0, a10);
            this.f49120b.P(0);
            this.f49120b.O(a10);
        }
        return 0;
    }

    public final void m(d5.d dVar) throws IOException {
        this.f49126h = com.google.android.exoplayer2.extractor.e.d(dVar, !this.f49121c);
        this.f49125g = 1;
    }

    public final void n(d5.d dVar) throws IOException {
        e.a aVar = new e.a(this.f49127i);
        boolean z10 = false;
        while (!z10) {
            z10 = com.google.android.exoplayer2.extractor.e.e(dVar, aVar);
            this.f49127i = (g) j0.j(aVar.f20045a);
        }
        com.google.android.exoplayer2.util.a.e(this.f49127i);
        this.f49128j = Math.max(this.f49127i.f20061c, 6);
        ((TrackOutput) j0.j(this.f49124f)).b(this.f49127i.h(this.f49119a, this.f49126h));
        this.f49125g = 4;
    }

    public final void o(d5.d dVar) throws IOException {
        com.google.android.exoplayer2.extractor.e.j(dVar);
        this.f49125g = 3;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public d(int i10) {
        this.f49119a = new byte[42];
        this.f49120b = new ParsableByteArray(new byte[32768], 0);
        this.f49121c = (i10 & 1) != 0;
        this.f49122d = new j.a();
        this.f49125g = 0;
    }
}
