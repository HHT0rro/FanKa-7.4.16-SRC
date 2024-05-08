package c6;

import b6.h;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.u;
import x4.b;

/* compiled from: RtpAc3Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final h f1541a;

    /* renamed from: c, reason: collision with root package name */
    public TrackOutput f1543c;

    /* renamed from: d, reason: collision with root package name */
    public int f1544d;

    /* renamed from: f, reason: collision with root package name */
    public long f1546f;

    /* renamed from: g, reason: collision with root package name */
    public long f1547g;

    /* renamed from: b, reason: collision with root package name */
    public final u f1542b = new u();

    /* renamed from: e, reason: collision with root package name */
    public long f1545e = -9223372036854775807L;

    public c(h hVar) {
        this.f1541a = hVar;
    }

    public static long j(long j10, long j11, long j12, int i10) {
        return j10 + j0.H0(j11 - j12, 1000000L, i10);
    }

    @Override // c6.e
    public void a(long j10, long j11) {
        this.f1545e = j10;
        this.f1547g = j11;
    }

    @Override // c6.e
    public void b(long j10, int i10) {
        com.google.android.exoplayer2.util.a.g(this.f1545e == -9223372036854775807L);
        this.f1545e = j10;
    }

    @Override // c6.e
    public void c(d5.e eVar, int i10) {
        TrackOutput c4 = eVar.c(i10, 1);
        this.f1543c = c4;
        c4.b(this.f1541a.f1342c);
    }

    @Override // c6.e
    public void d(ParsableByteArray parsableByteArray, long j10, int i10, boolean z10) {
        int D = parsableByteArray.D() & 3;
        int D2 = parsableByteArray.D() & 255;
        long j11 = j(this.f1547g, j10, this.f1545e, this.f1541a.f1341b);
        if (D != 0) {
            if (D == 1 || D == 2) {
                e();
            } else if (D != 3) {
                throw new IllegalArgumentException(String.valueOf(D));
            }
            g(parsableByteArray, z10, D, j11);
            return;
        }
        e();
        if (D2 == 1) {
            i(parsableByteArray, j11);
        } else {
            h(parsableByteArray, D2, j11);
        }
    }

    public final void e() {
        if (this.f1544d > 0) {
            f();
        }
    }

    public final void f() {
        ((TrackOutput) j0.j(this.f1543c)).d(this.f1546f, 1, this.f1544d, 0, null);
        this.f1544d = 0;
    }

    public final void g(ParsableByteArray parsableByteArray, boolean z10, int i10, long j10) {
        int a10 = parsableByteArray.a();
        ((TrackOutput) com.google.android.exoplayer2.util.a.e(this.f1543c)).a(parsableByteArray, a10);
        this.f1544d += a10;
        this.f1546f = j10;
        if (z10 && i10 == 3) {
            f();
        }
    }

    public final void h(ParsableByteArray parsableByteArray, int i10, long j10) {
        this.f1542b.n(parsableByteArray.d());
        this.f1542b.s(2);
        for (int i11 = 0; i11 < i10; i11++) {
            b.C0838b e2 = x4.b.e(this.f1542b);
            ((TrackOutput) com.google.android.exoplayer2.util.a.e(this.f1543c)).a(parsableByteArray, e2.f54376e);
            ((TrackOutput) j0.j(this.f1543c)).d(j10, 1, e2.f54376e, 0, null);
            j10 += (e2.f54377f / e2.f54374c) * 1000000;
            this.f1542b.s(e2.f54376e);
        }
    }

    public final void i(ParsableByteArray parsableByteArray, long j10) {
        int a10 = parsableByteArray.a();
        ((TrackOutput) com.google.android.exoplayer2.util.a.e(this.f1543c)).a(parsableByteArray, a10);
        ((TrackOutput) j0.j(this.f1543c)).d(j10, 1, a10, 0, null);
    }
}
