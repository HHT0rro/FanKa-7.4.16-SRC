package z5;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.j0;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* compiled from: SegmentBase.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final i f54948a;

    /* renamed from: b, reason: collision with root package name */
    public final long f54949b;

    /* renamed from: c, reason: collision with root package name */
    public final long f54950c;

    /* compiled from: SegmentBase.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class a extends k {

        /* renamed from: d, reason: collision with root package name */
        public final long f54951d;

        /* renamed from: e, reason: collision with root package name */
        public final long f54952e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public final List<d> f54953f;

        /* renamed from: g, reason: collision with root package name */
        public final long f54954g;

        /* renamed from: h, reason: collision with root package name */
        public final long f54955h;

        /* renamed from: i, reason: collision with root package name */
        @VisibleForTesting
        public final long f54956i;

        public a(@Nullable i iVar, long j10, long j11, long j12, long j13, @Nullable List<d> list, long j14, long j15, long j16) {
            super(iVar, j10, j11);
            this.f54951d = j12;
            this.f54952e = j13;
            this.f54953f = list;
            this.f54956i = j14;
            this.f54954g = j15;
            this.f54955h = j16;
        }

        public long c(long j10, long j11) {
            long g3 = g(j10);
            return g3 != -1 ? g3 : (int) (i((j11 - this.f54955h) + this.f54956i, j10) - d(j10, j11));
        }

        public long d(long j10, long j11) {
            if (g(j10) == -1) {
                long j12 = this.f54954g;
                if (j12 != -9223372036854775807L) {
                    return Math.max(e(), i((j11 - this.f54955h) - j12, j10));
                }
            }
            return e();
        }

        public long e() {
            return this.f54951d;
        }

        public long f(long j10, long j11) {
            if (this.f54953f != null) {
                return -9223372036854775807L;
            }
            long d10 = d(j10, j11) + c(j10, j11);
            return (j(d10) + h(d10, j10)) - this.f54956i;
        }

        public abstract long g(long j10);

        public final long h(long j10, long j11) {
            List<d> list = this.f54953f;
            if (list != null) {
                return (list.get((int) (j10 - this.f54951d)).f54962b * 1000000) / this.f54949b;
            }
            long g3 = g(j11);
            if (g3 != -1 && j10 == (e() + g3) - 1) {
                return j11 - j(j10);
            }
            return (this.f54952e * 1000000) / this.f54949b;
        }

        public long i(long j10, long j11) {
            long e2 = e();
            long g3 = g(j11);
            if (g3 == 0) {
                return e2;
            }
            if (this.f54953f == null) {
                long j12 = this.f54951d + (j10 / ((this.f54952e * 1000000) / this.f54949b));
                return j12 < e2 ? e2 : g3 == -1 ? j12 : Math.min(j12, (e2 + g3) - 1);
            }
            long j13 = (g3 + e2) - 1;
            long j14 = e2;
            while (j14 <= j13) {
                long j15 = ((j13 - j14) / 2) + j14;
                long j16 = j(j15);
                if (j16 < j10) {
                    j14 = j15 + 1;
                } else {
                    if (j16 <= j10) {
                        return j15;
                    }
                    j13 = j15 - 1;
                }
            }
            return j14 == e2 ? j14 : j13;
        }

        public final long j(long j10) {
            long j11;
            List<d> list = this.f54953f;
            if (list != null) {
                j11 = list.get((int) (j10 - this.f54951d)).f54961a - this.f54950c;
            } else {
                j11 = (j10 - this.f54951d) * this.f54952e;
            }
            return j0.H0(j11, 1000000L, this.f54949b);
        }

        public abstract i k(j jVar, long j10);

        public boolean l() {
            return this.f54953f != null;
        }
    }

    /* compiled from: SegmentBase.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends a {

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public final List<i> f54957j;

        public b(i iVar, long j10, long j11, long j12, long j13, @Nullable List<d> list, long j14, @Nullable List<i> list2, long j15, long j16) {
            super(iVar, j10, j11, j12, j13, list, j14, j15, j16);
            this.f54957j = list2;
        }

        @Override // z5.k.a
        public long g(long j10) {
            return this.f54957j.size();
        }

        @Override // z5.k.a
        public i k(j jVar, long j10) {
            return this.f54957j.get((int) (j10 - this.f54951d));
        }

        @Override // z5.k.a
        public boolean l() {
            return true;
        }
    }

    /* compiled from: SegmentBase.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends a {

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public final n f54958j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public final n f54959k;

        /* renamed from: l, reason: collision with root package name */
        public final long f54960l;

        public c(i iVar, long j10, long j11, long j12, long j13, long j14, @Nullable List<d> list, long j15, @Nullable n nVar, @Nullable n nVar2, long j16, long j17) {
            super(iVar, j10, j11, j12, j14, list, j15, j16, j17);
            this.f54958j = nVar;
            this.f54959k = nVar2;
            this.f54960l = j13;
        }

        @Override // z5.k
        @Nullable
        public i a(j jVar) {
            n nVar = this.f54958j;
            if (nVar != null) {
                Format format = jVar.f54937b;
                return new i(nVar.a(format.f19533b, 0L, format.f19540i, 0L), 0L, -1L);
            }
            return super.a(jVar);
        }

        @Override // z5.k.a
        public long g(long j10) {
            if (this.f54953f != null) {
                return r0.size();
            }
            long j11 = this.f54960l;
            if (j11 != -1) {
                return (j11 - this.f54951d) + 1;
            }
            if (j10 != -9223372036854775807L) {
                return com.google.common.math.a.a(BigInteger.valueOf(j10).multiply(BigInteger.valueOf(this.f54949b)), BigInteger.valueOf(this.f54952e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        @Override // z5.k.a
        public i k(j jVar, long j10) {
            long j11;
            List<d> list = this.f54953f;
            if (list != null) {
                j11 = list.get((int) (j10 - this.f54951d)).f54961a;
            } else {
                j11 = (j10 - this.f54951d) * this.f54952e;
            }
            long j12 = j11;
            n nVar = this.f54959k;
            Format format = jVar.f54937b;
            return new i(nVar.a(format.f19533b, j10, format.f19540i, j12), 0L, -1L);
        }
    }

    /* compiled from: SegmentBase.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f54961a;

        /* renamed from: b, reason: collision with root package name */
        public final long f54962b;

        public d(long j10, long j11) {
            this.f54961a = j10;
            this.f54962b = j11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f54961a == dVar.f54961a && this.f54962b == dVar.f54962b;
        }

        public int hashCode() {
            return (((int) this.f54961a) * 31) + ((int) this.f54962b);
        }
    }

    public k(@Nullable i iVar, long j10, long j11) {
        this.f54948a = iVar;
        this.f54949b = j10;
        this.f54950c = j11;
    }

    @Nullable
    public i a(j jVar) {
        return this.f54948a;
    }

    public long b() {
        return j0.H0(this.f54950c, 1000000L, this.f54949b);
    }

    /* compiled from: SegmentBase.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class e extends k {

        /* renamed from: d, reason: collision with root package name */
        public final long f54963d;

        /* renamed from: e, reason: collision with root package name */
        public final long f54964e;

        public e(@Nullable i iVar, long j10, long j11, long j12, long j13) {
            super(iVar, j10, j11);
            this.f54963d = j12;
            this.f54964e = j13;
        }

        @Nullable
        public i c() {
            long j10 = this.f54964e;
            if (j10 <= 0) {
                return null;
            }
            return new i(null, this.f54963d, j10);
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }
    }
}
