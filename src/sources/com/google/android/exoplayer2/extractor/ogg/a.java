package com.google.android.exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import d5.o;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: DefaultOggSeeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements OggSeeker {

    /* renamed from: a, reason: collision with root package name */
    public final f f20279a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20280b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20281c;

    /* renamed from: d, reason: collision with root package name */
    public final StreamReader f20282d;

    /* renamed from: e, reason: collision with root package name */
    public int f20283e;

    /* renamed from: f, reason: collision with root package name */
    public long f20284f;

    /* renamed from: g, reason: collision with root package name */
    public long f20285g;

    /* renamed from: h, reason: collision with root package name */
    public long f20286h;

    /* renamed from: i, reason: collision with root package name */
    public long f20287i;

    /* renamed from: j, reason: collision with root package name */
    public long f20288j;

    /* renamed from: k, reason: collision with root package name */
    public long f20289k;

    /* renamed from: l, reason: collision with root package name */
    public long f20290l;

    /* compiled from: DefaultOggSeeker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements i {
        public b() {
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public i.a d(long j10) {
            return new i.a(new o(j10, j0.s((a.this.f20280b + ((a.this.f20282d.c(j10) * (a.this.f20281c - a.this.f20280b)) / a.this.f20284f)) - 30000, a.this.f20280b, a.this.f20281c - 1)));
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public boolean e() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public long i() {
            return a.this.f20282d.b(a.this.f20284f);
        }
    }

    public a(StreamReader streamReader, long j10, long j11, long j12, long j13, boolean z10) {
        com.google.android.exoplayer2.util.a.a(j10 >= 0 && j11 > j10);
        this.f20282d = streamReader;
        this.f20280b = j10;
        this.f20281c = j11;
        if (j12 != j11 - j10 && !z10) {
            this.f20283e = 0;
        } else {
            this.f20284f = j13;
            this.f20283e = 4;
        }
        this.f20279a = new f();
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long a(d5.d dVar) throws IOException {
        int i10 = this.f20283e;
        if (i10 == 0) {
            long position = dVar.getPosition();
            this.f20285g = position;
            this.f20283e = 1;
            long j10 = this.f20281c - 65307;
            if (j10 > position) {
                return j10;
            }
        } else if (i10 != 1) {
            if (i10 == 2) {
                long i11 = i(dVar);
                if (i11 != -1) {
                    return i11;
                }
                this.f20283e = 3;
            } else if (i10 != 3) {
                if (i10 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            k(dVar);
            this.f20283e = 4;
            return -(this.f20289k + 2);
        }
        this.f20284f = j(dVar);
        this.f20283e = 4;
        return this.f20285g;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public void c(long j10) {
        this.f20286h = j0.s(j10, 0L, this.f20284f - 1);
        this.f20283e = 2;
        this.f20287i = this.f20280b;
        this.f20288j = this.f20281c;
        this.f20289k = 0L;
        this.f20290l = this.f20284f;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    @Nullable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b b() {
        if (this.f20284f != 0) {
            return new b();
        }
        return null;
    }

    public final long i(d5.d dVar) throws IOException {
        if (this.f20287i == this.f20288j) {
            return -1L;
        }
        long position = dVar.getPosition();
        if (!this.f20279a.d(dVar, this.f20288j)) {
            long j10 = this.f20287i;
            if (j10 != position) {
                return j10;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f20279a.a(dVar, false);
        dVar.m();
        long j11 = this.f20286h;
        f fVar = this.f20279a;
        long j12 = fVar.f20310c;
        long j13 = j11 - j12;
        int i10 = fVar.f20315h + fVar.f20316i;
        if (0 <= j13 && j13 < 72000) {
            return -1L;
        }
        if (j13 < 0) {
            this.f20288j = position;
            this.f20290l = j12;
        } else {
            this.f20287i = dVar.getPosition() + i10;
            this.f20289k = this.f20279a.f20310c;
        }
        long j14 = this.f20288j;
        long j15 = this.f20287i;
        if (j14 - j15 < 100000) {
            this.f20288j = j15;
            return j15;
        }
        long position2 = dVar.getPosition() - (i10 * (j13 <= 0 ? 2L : 1L));
        long j16 = this.f20288j;
        long j17 = this.f20287i;
        return j0.s(position2 + ((j13 * (j16 - j17)) / (this.f20290l - this.f20289k)), j17, j16 - 1);
    }

    @VisibleForTesting
    public long j(d5.d dVar) throws IOException {
        this.f20279a.b();
        if (this.f20279a.c(dVar)) {
            this.f20279a.a(dVar, false);
            f fVar = this.f20279a;
            dVar.r(fVar.f20315h + fVar.f20316i);
            long j10 = this.f20279a.f20310c;
            while (true) {
                f fVar2 = this.f20279a;
                if ((fVar2.f20309b & 4) == 4 || !fVar2.c(dVar) || dVar.getPosition() >= this.f20281c || !this.f20279a.a(dVar, true)) {
                    break;
                }
                f fVar3 = this.f20279a;
                if (!d5.f.e(dVar, fVar3.f20315h + fVar3.f20316i)) {
                    break;
                }
                j10 = this.f20279a.f20310c;
            }
            return j10;
        }
        throw new EOFException();
    }

    public final void k(d5.d dVar) throws IOException {
        while (true) {
            this.f20279a.c(dVar);
            this.f20279a.a(dVar, false);
            f fVar = this.f20279a;
            if (fVar.f20310c > this.f20286h) {
                dVar.m();
                return;
            } else {
                dVar.r(fVar.f20315h + fVar.f20316i);
                this.f20287i = dVar.getPosition();
                this.f20289k = this.f20279a.f20310c;
            }
        }
    }
}
