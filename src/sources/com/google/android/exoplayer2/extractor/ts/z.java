package com.google.android.exoplayer2.extractor.ts;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Map;

/* compiled from: PsExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z implements Extractor {

    /* renamed from: l, reason: collision with root package name */
    public static final d5.i f20662l = new d5.i() { // from class: com.google.android.exoplayer2.extractor.ts.y
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return d5.h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] d10;
            d10 = z.d();
            return d10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.f0 f20663a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f20664b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f20665c;

    /* renamed from: d, reason: collision with root package name */
    public final x f20666d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20667e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20668f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20669g;

    /* renamed from: h, reason: collision with root package name */
    public long f20670h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public w f20671i;

    /* renamed from: j, reason: collision with root package name */
    public d5.e f20672j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20673k;

    /* compiled from: PsExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final m f20674a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.f0 f20675b;

        /* renamed from: c, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.u f20676c = new com.google.android.exoplayer2.util.u(new byte[64]);

        /* renamed from: d, reason: collision with root package name */
        public boolean f20677d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f20678e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f20679f;

        /* renamed from: g, reason: collision with root package name */
        public int f20680g;

        /* renamed from: h, reason: collision with root package name */
        public long f20681h;

        public a(m mVar, com.google.android.exoplayer2.util.f0 f0Var) {
            this.f20674a = mVar;
            this.f20675b = f0Var;
        }

        public void a(ParsableByteArray parsableByteArray) throws ParserException {
            parsableByteArray.j(this.f20676c.f23029a, 0, 3);
            this.f20676c.p(0);
            b();
            parsableByteArray.j(this.f20676c.f23029a, 0, this.f20680g);
            this.f20676c.p(0);
            c();
            this.f20674a.f(this.f20681h, 4);
            this.f20674a.c(parsableByteArray);
            this.f20674a.d();
        }

        public final void b() {
            this.f20676c.r(8);
            this.f20677d = this.f20676c.g();
            this.f20678e = this.f20676c.g();
            this.f20676c.r(6);
            this.f20680g = this.f20676c.h(8);
        }

        public final void c() {
            this.f20681h = 0L;
            if (this.f20677d) {
                this.f20676c.r(4);
                this.f20676c.r(1);
                this.f20676c.r(1);
                long h10 = (this.f20676c.h(3) << 30) | (this.f20676c.h(15) << 15) | this.f20676c.h(15);
                this.f20676c.r(1);
                if (!this.f20679f && this.f20678e) {
                    this.f20676c.r(4);
                    this.f20676c.r(1);
                    this.f20676c.r(1);
                    this.f20676c.r(1);
                    this.f20675b.b((this.f20676c.h(3) << 30) | (this.f20676c.h(15) << 15) | this.f20676c.h(15));
                    this.f20679f = true;
                }
                this.f20681h = this.f20675b.b(h10);
            }
        }

        public void d() {
            this.f20679f = false;
            this.f20674a.a();
        }
    }

    public z() {
        this(new com.google.android.exoplayer2.util.f0(0L));
    }

    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new z()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        boolean z10 = this.f20663a.e() == -9223372036854775807L;
        if (!z10) {
            long c4 = this.f20663a.c();
            z10 = (c4 == -9223372036854775807L || c4 == 0 || c4 == j11) ? false : true;
        }
        if (z10) {
            this.f20663a.g(j11);
        }
        w wVar = this.f20671i;
        if (wVar != null) {
            wVar.h(j11);
        }
        for (int i10 = 0; i10 < this.f20664b.size(); i10++) {
            this.f20664b.valueAt(i10).d();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f20672j = eVar;
    }

    public final void e(long j10) {
        if (this.f20673k) {
            return;
        }
        this.f20673k = true;
        if (this.f20666d.c() != -9223372036854775807L) {
            w wVar = new w(this.f20666d.d(), this.f20666d.c(), j10);
            this.f20671i = wVar;
            this.f20672j.r(wVar.b());
            return;
        }
        this.f20672j.r(new i.b(this.f20666d.c()));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, d5.n nVar) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f20672j);
        long b4 = dVar.b();
        if ((b4 != -1) && !this.f20666d.e()) {
            return this.f20666d.g(dVar, nVar);
        }
        e(b4);
        w wVar = this.f20671i;
        if (wVar != null && wVar.d()) {
            return this.f20671i.c(dVar, nVar);
        }
        dVar.m();
        long o10 = b4 != -1 ? b4 - dVar.o() : -1L;
        if ((o10 != -1 && o10 < 4) || !dVar.l(this.f20665c.d(), 0, 4, true)) {
            return -1;
        }
        this.f20665c.P(0);
        int n10 = this.f20665c.n();
        if (n10 == 441) {
            return -1;
        }
        if (n10 == 442) {
            dVar.j(this.f20665c.d(), 0, 10);
            this.f20665c.P(9);
            dVar.r((this.f20665c.D() & 7) + 14);
            return 0;
        }
        if (n10 == 443) {
            dVar.j(this.f20665c.d(), 0, 2);
            this.f20665c.P(0);
            dVar.r(this.f20665c.J() + 6);
            return 0;
        }
        if (((n10 & (-256)) >> 8) != 1) {
            dVar.r(1);
            return 0;
        }
        int i10 = n10 & 255;
        a aVar = this.f20664b.get(i10);
        if (!this.f20667e) {
            if (aVar == null) {
                m mVar = null;
                if (i10 == 189) {
                    mVar = new c();
                    this.f20668f = true;
                    this.f20670h = dVar.getPosition();
                } else if ((i10 & 224) == 192) {
                    mVar = new s();
                    this.f20668f = true;
                    this.f20670h = dVar.getPosition();
                } else if ((i10 & 240) == 224) {
                    mVar = new n();
                    this.f20669g = true;
                    this.f20670h = dVar.getPosition();
                }
                if (mVar != null) {
                    mVar.e(this.f20672j, new h0.d(i10, 256));
                    aVar = new a(mVar, this.f20663a);
                    this.f20664b.put(i10, aVar);
                }
            }
            if (dVar.getPosition() > ((this.f20668f && this.f20669g) ? this.f20670h + PlaybackStateCompat.ACTION_PLAY_FROM_URI : 1048576L)) {
                this.f20667e = true;
                this.f20672j.l();
            }
        }
        dVar.j(this.f20665c.d(), 0, 2);
        this.f20665c.P(0);
        int J = this.f20665c.J() + 6;
        if (aVar == null) {
            dVar.r(J);
        } else {
            this.f20665c.L(J);
            dVar.readFully(this.f20665c.d(), 0, J);
            this.f20665c.P(6);
            aVar.a(this.f20665c);
            ParsableByteArray parsableByteArray = this.f20665c;
            parsableByteArray.O(parsableByteArray.b());
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        byte[] bArr = new byte[14];
        dVar.j(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        dVar.q(bArr[13] & 7);
        dVar.j(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public z(com.google.android.exoplayer2.util.f0 f0Var) {
        this.f20663a = f0Var;
        this.f20665c = new ParsableByteArray(4096);
        this.f20664b = new SparseArray<>();
        this.f20666d = new x();
    }
}
