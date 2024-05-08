package com.google.android.exoplayer2.extractor;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import d5.n;
import d5.o;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class BinarySearchSeeker {

    /* renamed from: a, reason: collision with root package name */
    public final a f20013a;

    /* renamed from: b, reason: collision with root package name */
    public final e f20014b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public c f20015c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20016d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class TimestampSearchResult {
        public static final TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = new TimestampSearchResult(-3, -9223372036854775807L, -1);
        public static final int TYPE_NO_TIMESTAMP = -3;
        public static final int TYPE_POSITION_OVERESTIMATED = -1;
        public static final int TYPE_POSITION_UNDERESTIMATED = -2;
        public static final int TYPE_TARGET_TIMESTAMP_FOUND = 0;
        private final long bytePositionToUpdate;
        private final long timestampToUpdate;
        private final int type;

        private TimestampSearchResult(int i10, long j10, long j11) {
            this.type = i10;
            this.timestampToUpdate = j10;
            this.bytePositionToUpdate = j11;
        }

        public static TimestampSearchResult overestimatedResult(long j10, long j11) {
            return new TimestampSearchResult(-1, j10, j11);
        }

        public static TimestampSearchResult targetFoundResult(long j10) {
            return new TimestampSearchResult(0, -9223372036854775807L, j10);
        }

        public static TimestampSearchResult underestimatedResult(long j10, long j11) {
            return new TimestampSearchResult(-2, j10, j11);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final d f20017a;

        /* renamed from: b, reason: collision with root package name */
        public final long f20018b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20019c;

        /* renamed from: d, reason: collision with root package name */
        public final long f20020d;

        /* renamed from: e, reason: collision with root package name */
        public final long f20021e;

        /* renamed from: f, reason: collision with root package name */
        public final long f20022f;

        /* renamed from: g, reason: collision with root package name */
        public final long f20023g;

        public a(d dVar, long j10, long j11, long j12, long j13, long j14, long j15) {
            this.f20017a = dVar;
            this.f20018b = j10;
            this.f20019c = j11;
            this.f20020d = j12;
            this.f20021e = j13;
            this.f20022f = j14;
            this.f20023g = j15;
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public i.a d(long j10) {
            return new i.a(new o(j10, c.h(this.f20017a.a(j10), this.f20019c, this.f20020d, this.f20021e, this.f20022f, this.f20023g)));
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public boolean e() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public long i() {
            return this.f20018b;
        }

        public long k(long j10) {
            return this.f20017a.a(j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements d {
        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.d
        public long a(long j10) {
            return j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f20024a;

        /* renamed from: b, reason: collision with root package name */
        public final long f20025b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20026c;

        /* renamed from: d, reason: collision with root package name */
        public long f20027d;

        /* renamed from: e, reason: collision with root package name */
        public long f20028e;

        /* renamed from: f, reason: collision with root package name */
        public long f20029f;

        /* renamed from: g, reason: collision with root package name */
        public long f20030g;

        /* renamed from: h, reason: collision with root package name */
        public long f20031h;

        public c(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.f20024a = j10;
            this.f20025b = j11;
            this.f20027d = j12;
            this.f20028e = j13;
            this.f20029f = j14;
            this.f20030g = j15;
            this.f20026c = j16;
            this.f20031h = h(j11, j12, j13, j14, j15, j16);
        }

        public static long h(long j10, long j11, long j12, long j13, long j14, long j15) {
            if (j13 + 1 >= j14 || j11 + 1 >= j12) {
                return j13;
            }
            long j16 = ((float) (j10 - j11)) * (((float) (j14 - j13)) / ((float) (j12 - j11)));
            return j0.s(((j16 + j13) - j15) - (j16 / 20), j13, j14 - 1);
        }

        public final long i() {
            return this.f20030g;
        }

        public final long j() {
            return this.f20029f;
        }

        public final long k() {
            return this.f20031h;
        }

        public final long l() {
            return this.f20024a;
        }

        public final long m() {
            return this.f20025b;
        }

        public final void n() {
            this.f20031h = h(this.f20025b, this.f20027d, this.f20028e, this.f20029f, this.f20030g, this.f20026c);
        }

        public final void o(long j10, long j11) {
            this.f20028e = j10;
            this.f20030g = j11;
            n();
        }

        public final void p(long j10, long j11) {
            this.f20027d = j10;
            this.f20029f = j11;
            n();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d {
        long a(long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface e {
        TimestampSearchResult a(d5.d dVar, long j10) throws IOException;

        void b();
    }

    public BinarySearchSeeker(d dVar, e eVar, long j10, long j11, long j12, long j13, long j14, long j15, int i10) {
        this.f20014b = eVar;
        this.f20016d = i10;
        this.f20013a = new a(dVar, j10, j11, j12, j13, j14, j15);
    }

    public c a(long j10) {
        return new c(j10, this.f20013a.k(j10), this.f20013a.f20019c, this.f20013a.f20020d, this.f20013a.f20021e, this.f20013a.f20022f, this.f20013a.f20023g);
    }

    public final i b() {
        return this.f20013a;
    }

    public int c(d5.d dVar, n nVar) throws IOException {
        while (true) {
            c cVar = (c) com.google.android.exoplayer2.util.a.i(this.f20015c);
            long j10 = cVar.j();
            long i10 = cVar.i();
            long k10 = cVar.k();
            if (i10 - j10 <= this.f20016d) {
                e(false, j10);
                return g(dVar, j10, nVar);
            }
            if (!i(dVar, k10)) {
                return g(dVar, k10, nVar);
            }
            dVar.m();
            TimestampSearchResult a10 = this.f20014b.a(dVar, cVar.m());
            int i11 = a10.type;
            if (i11 == -3) {
                e(false, k10);
                return g(dVar, k10, nVar);
            }
            if (i11 == -2) {
                cVar.p(a10.timestampToUpdate, a10.bytePositionToUpdate);
            } else {
                if (i11 != -1) {
                    if (i11 == 0) {
                        i(dVar, a10.bytePositionToUpdate);
                        e(true, a10.bytePositionToUpdate);
                        return g(dVar, a10.bytePositionToUpdate, nVar);
                    }
                    throw new IllegalStateException("Invalid case");
                }
                cVar.o(a10.timestampToUpdate, a10.bytePositionToUpdate);
            }
        }
    }

    public final boolean d() {
        return this.f20015c != null;
    }

    public final void e(boolean z10, long j10) {
        this.f20015c = null;
        this.f20014b.b();
        f(z10, j10);
    }

    public void f(boolean z10, long j10) {
    }

    public final int g(d5.d dVar, long j10, n nVar) {
        if (j10 == dVar.getPosition()) {
            return 0;
        }
        nVar.f48642a = j10;
        return 1;
    }

    public final void h(long j10) {
        c cVar = this.f20015c;
        if (cVar == null || cVar.l() != j10) {
            this.f20015c = a(j10);
        }
    }

    public final boolean i(d5.d dVar, long j10) throws IOException {
        long position = j10 - dVar.getPosition();
        if (position < 0 || position > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        dVar.r((int) position);
        return true;
    }
}
