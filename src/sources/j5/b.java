package j5;

import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.n;
import d5.o;

/* compiled from: IndexSeeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final long f50298a;

    /* renamed from: b, reason: collision with root package name */
    public final n f50299b;

    /* renamed from: c, reason: collision with root package name */
    public final n f50300c;

    /* renamed from: d, reason: collision with root package name */
    public long f50301d;

    public b(long j10, long j11, long j12) {
        this.f50301d = j10;
        this.f50298a = j12;
        n nVar = new n();
        this.f50299b = nVar;
        n nVar2 = new n();
        this.f50300c = nVar2;
        nVar.a(0L);
        nVar2.a(j11);
    }

    public boolean a(long j10) {
        n nVar = this.f50299b;
        return j10 - nVar.b(nVar.c() - 1) < 100000;
    }

    public void b(long j10, long j11) {
        if (a(j10)) {
            return;
        }
        this.f50299b.a(j10);
        this.f50300c.a(j11);
    }

    @Override // j5.g
    public long c(long j10) {
        return this.f50299b.b(j0.f(this.f50300c, j10, true, true));
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        int f10 = j0.f(this.f50299b, j10, true, true);
        o oVar = new o(this.f50299b.b(f10), this.f50300c.b(f10));
        if (oVar.f48644a != j10 && f10 != this.f50299b.c() - 1) {
            int i10 = f10 + 1;
            return new i.a(oVar, new o(this.f50299b.b(i10), this.f50300c.b(i10)));
        }
        return new i.a(oVar);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return true;
    }

    public void f(long j10) {
        this.f50301d = j10;
    }

    @Override // j5.g
    public long h() {
        return this.f50298a;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f50301d;
    }
}
