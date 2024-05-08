package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import d5.n;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class StreamReader {

    /* renamed from: b, reason: collision with root package name */
    public TrackOutput f20267b;

    /* renamed from: c, reason: collision with root package name */
    public d5.e f20268c;

    /* renamed from: d, reason: collision with root package name */
    public OggSeeker f20269d;

    /* renamed from: e, reason: collision with root package name */
    public long f20270e;

    /* renamed from: f, reason: collision with root package name */
    public long f20271f;

    /* renamed from: g, reason: collision with root package name */
    public long f20272g;

    /* renamed from: h, reason: collision with root package name */
    public int f20273h;

    /* renamed from: i, reason: collision with root package name */
    public int f20274i;

    /* renamed from: k, reason: collision with root package name */
    public long f20276k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20277l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20278m;

    /* renamed from: a, reason: collision with root package name */
    public final e f20266a = new e();

    /* renamed from: j, reason: collision with root package name */
    public SetupData f20275j = new SetupData();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SetupData {
        public Format format;
        public OggSeeker oggSeeker;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements OggSeeker {
        public b() {
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long a(d5.d dVar) {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public i b() {
            return new i.b(-9223372036854775807L);
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void c(long j10) {
        }
    }

    public final void a() {
        com.google.android.exoplayer2.util.a.i(this.f20267b);
        j0.j(this.f20268c);
    }

    public long b(long j10) {
        return (j10 * 1000000) / this.f20274i;
    }

    public long c(long j10) {
        return (this.f20274i * j10) / 1000000;
    }

    public void d(d5.e eVar, TrackOutput trackOutput) {
        this.f20268c = eVar;
        this.f20267b = trackOutput;
        l(true);
    }

    public void e(long j10) {
        this.f20272g = j10;
    }

    public abstract long f(ParsableByteArray parsableByteArray);

    public final int g(d5.d dVar, n nVar) throws IOException {
        a();
        int i10 = this.f20273h;
        if (i10 == 0) {
            return j(dVar);
        }
        if (i10 == 1) {
            dVar.r((int) this.f20271f);
            this.f20273h = 2;
            return 0;
        }
        if (i10 == 2) {
            j0.j(this.f20269d);
            return k(dVar, nVar);
        }
        if (i10 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public abstract boolean h(ParsableByteArray parsableByteArray, long j10, SetupData setupData) throws IOException;

    public final boolean i(d5.d dVar) throws IOException {
        while (this.f20266a.d(dVar)) {
            this.f20276k = dVar.getPosition() - this.f20271f;
            if (!h(this.f20266a.c(), this.f20271f, this.f20275j)) {
                return true;
            }
            this.f20271f = dVar.getPosition();
        }
        this.f20273h = 3;
        return false;
    }

    public final int j(d5.d dVar) throws IOException {
        if (!i(dVar)) {
            return -1;
        }
        Format format = this.f20275j.format;
        this.f20274i = format.A;
        if (!this.f20278m) {
            this.f20267b.b(format);
            this.f20278m = true;
        }
        OggSeeker oggSeeker = this.f20275j.oggSeeker;
        if (oggSeeker != null) {
            this.f20269d = oggSeeker;
        } else if (dVar.b() == -1) {
            this.f20269d = new b();
        } else {
            f b4 = this.f20266a.b();
            this.f20269d = new com.google.android.exoplayer2.extractor.ogg.a(this, this.f20271f, dVar.b(), b4.f20315h + b4.f20316i, b4.f20310c, (b4.f20309b & 4) != 0);
        }
        this.f20273h = 2;
        this.f20266a.f();
        return 0;
    }

    public final int k(d5.d dVar, n nVar) throws IOException {
        long a10 = this.f20269d.a(dVar);
        if (a10 >= 0) {
            nVar.f48642a = a10;
            return 1;
        }
        if (a10 < -1) {
            e(-(a10 + 2));
        }
        if (!this.f20277l) {
            this.f20268c.r((i) com.google.android.exoplayer2.util.a.i(this.f20269d.b()));
            this.f20277l = true;
        }
        if (this.f20276k <= 0 && !this.f20266a.d(dVar)) {
            this.f20273h = 3;
            return -1;
        }
        this.f20276k = 0L;
        ParsableByteArray c4 = this.f20266a.c();
        long f10 = f(c4);
        if (f10 >= 0) {
            long j10 = this.f20272g;
            if (j10 + f10 >= this.f20270e) {
                long b4 = b(j10);
                this.f20267b.a(c4, c4.f());
                this.f20267b.d(b4, 1, c4.f(), 0, null);
                this.f20270e = -1L;
            }
        }
        this.f20272g += f10;
        return 0;
    }

    public void l(boolean z10) {
        if (z10) {
            this.f20275j = new SetupData();
            this.f20271f = 0L;
            this.f20273h = 0;
        } else {
            this.f20273h = 1;
        }
        this.f20270e = -1L;
        this.f20272g = 0L;
    }

    public final void m(long j10, long j11) {
        this.f20266a.e();
        if (j10 == 0) {
            l(!this.f20277l);
        } else if (this.f20273h != 0) {
            this.f20270e = c(j11);
            ((OggSeeker) j0.j(this.f20269d)).c(this.f20270e);
            this.f20273h = 2;
        }
    }
}
