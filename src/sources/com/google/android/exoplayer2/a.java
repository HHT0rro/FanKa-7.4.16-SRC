package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;

/* compiled from: AbstractConcatenatedTimeline.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class a extends Timeline {

    /* renamed from: c, reason: collision with root package name */
    public final int f19684c;

    /* renamed from: d, reason: collision with root package name */
    public final ShuffleOrder f19685d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f19686e;

    public a(boolean z10, ShuffleOrder shuffleOrder) {
        this.f19686e = z10;
        this.f19685d = shuffleOrder;
        this.f19684c = shuffleOrder.b();
    }

    public static Object v(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object w(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object y(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public abstract int A(int i10);

    public final int B(int i10, boolean z10) {
        if (z10) {
            return this.f19685d.d(i10);
        }
        if (i10 < this.f19684c - 1) {
            return i10 + 1;
        }
        return -1;
    }

    public final int C(int i10, boolean z10) {
        if (z10) {
            return this.f19685d.c(i10);
        }
        if (i10 > 0) {
            return i10 - 1;
        }
        return -1;
    }

    public abstract Timeline D(int i10);

    @Override // com.google.android.exoplayer2.Timeline
    public int a(boolean z10) {
        if (this.f19684c == 0) {
            return -1;
        }
        if (this.f19686e) {
            z10 = false;
        }
        int g3 = z10 ? this.f19685d.g() : 0;
        while (D(g3).q()) {
            g3 = B(g3, z10);
            if (g3 == -1) {
                return -1;
            }
        }
        return A(g3) + D(g3).a(z10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int b(Object obj) {
        int b4;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object w3 = w(obj);
        Object v2 = v(obj);
        int s2 = s(w3);
        if (s2 == -1 || (b4 = D(s2).b(v2)) == -1) {
            return -1;
        }
        return z(s2) + b4;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int c(boolean z10) {
        int i10 = this.f19684c;
        if (i10 == 0) {
            return -1;
        }
        if (this.f19686e) {
            z10 = false;
        }
        int e2 = z10 ? this.f19685d.e() : i10 - 1;
        while (D(e2).q()) {
            e2 = C(e2, z10);
            if (e2 == -1) {
                return -1;
            }
        }
        return A(e2) + D(e2).c(z10);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int e(int i10, int i11, boolean z10) {
        if (this.f19686e) {
            if (i11 == 1) {
                i11 = 2;
            }
            z10 = false;
        }
        int u10 = u(i10);
        int A = A(u10);
        int e2 = D(u10).e(i10 - A, i11 != 2 ? i11 : 0, z10);
        if (e2 != -1) {
            return A + e2;
        }
        int B = B(u10, z10);
        while (B != -1 && D(B).q()) {
            B = B(B, z10);
        }
        if (B != -1) {
            return A(B) + D(B).a(z10);
        }
        if (i11 == 2) {
            return a(z10);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
        int t2 = t(i10);
        int A = A(t2);
        D(t2).g(i10 - z(t2), bVar, z10);
        bVar.f19658c += A;
        if (z10) {
            bVar.f19657b = y(x(t2), com.google.android.exoplayer2.util.a.e(bVar.f19657b));
        }
        return bVar;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.b h(Object obj, Timeline.b bVar) {
        Object w3 = w(obj);
        Object v2 = v(obj);
        int s2 = s(w3);
        int A = A(s2);
        D(s2).h(v2, bVar);
        bVar.f19658c += A;
        bVar.f19657b = obj;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int l(int i10, int i11, boolean z10) {
        if (this.f19686e) {
            if (i11 == 1) {
                i11 = 2;
            }
            z10 = false;
        }
        int u10 = u(i10);
        int A = A(u10);
        int l10 = D(u10).l(i10 - A, i11 != 2 ? i11 : 0, z10);
        if (l10 != -1) {
            return A + l10;
        }
        int C = C(u10, z10);
        while (C != -1 && D(C).q()) {
            C = C(C, z10);
        }
        if (C != -1) {
            return A(C) + D(C).c(z10);
        }
        if (i11 == 2) {
            return c(z10);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Object m(int i10) {
        int t2 = t(i10);
        return y(x(t2), D(t2).m(i10 - z(t2)));
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.c o(int i10, Timeline.c cVar, long j10) {
        int u10 = u(i10);
        int A = A(u10);
        int z10 = z(u10);
        D(u10).o(i10 - A, cVar, j10);
        Object x10 = x(u10);
        if (!Timeline.c.f19663r.equals(cVar.f19667a)) {
            x10 = y(x10, cVar.f19667a);
        }
        cVar.f19667a = x10;
        cVar.f19681o += z10;
        cVar.f19682p += z10;
        return cVar;
    }

    public abstract int s(Object obj);

    public abstract int t(int i10);

    public abstract int u(int i10);

    public abstract Object x(int i10);

    public abstract int z(int i10);
}
