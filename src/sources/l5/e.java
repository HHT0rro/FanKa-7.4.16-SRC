package l5;

import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import d5.o;

/* compiled from: WavSeekMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements i {

    /* renamed from: a, reason: collision with root package name */
    public final c f51664a;

    /* renamed from: b, reason: collision with root package name */
    public final int f51665b;

    /* renamed from: c, reason: collision with root package name */
    public final long f51666c;

    /* renamed from: d, reason: collision with root package name */
    public final long f51667d;

    /* renamed from: e, reason: collision with root package name */
    public final long f51668e;

    public e(c cVar, int i10, long j10, long j11) {
        this.f51664a = cVar;
        this.f51665b = i10;
        this.f51666c = j10;
        long j12 = (j11 - j10) / cVar.f51659e;
        this.f51667d = j12;
        this.f51668e = a(j12);
    }

    public final long a(long j10) {
        return j0.H0(j10 * this.f51665b, 1000000L, this.f51664a.f51657c);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        long s2 = j0.s((this.f51664a.f51657c * j10) / (this.f51665b * 1000000), 0L, this.f51667d - 1);
        long j11 = this.f51666c + (this.f51664a.f51659e * s2);
        long a10 = a(s2);
        o oVar = new o(a10, j11);
        if (a10 < j10 && s2 != this.f51667d - 1) {
            long j12 = s2 + 1;
            return new i.a(oVar, new o(a(j12), this.f51666c + (this.f51664a.f51659e * j12)));
        }
        return new i.a(oVar);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f51668e;
    }
}
