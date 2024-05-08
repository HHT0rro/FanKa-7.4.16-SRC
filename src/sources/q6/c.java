package q6;

import java.util.Arrays;

/* compiled from: FixedFrameRateEstimator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public boolean f53042c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f53043d;

    /* renamed from: f, reason: collision with root package name */
    public int f53045f;

    /* renamed from: a, reason: collision with root package name */
    public a f53040a = new a();

    /* renamed from: b, reason: collision with root package name */
    public a f53041b = new a();

    /* renamed from: e, reason: collision with root package name */
    public long f53044e = -9223372036854775807L;

    /* compiled from: FixedFrameRateEstimator.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f53046a;

        /* renamed from: b, reason: collision with root package name */
        public long f53047b;

        /* renamed from: c, reason: collision with root package name */
        public long f53048c;

        /* renamed from: d, reason: collision with root package name */
        public long f53049d;

        /* renamed from: e, reason: collision with root package name */
        public long f53050e;

        /* renamed from: f, reason: collision with root package name */
        public long f53051f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean[] f53052g = new boolean[15];

        /* renamed from: h, reason: collision with root package name */
        public int f53053h;

        public static int c(long j10) {
            return (int) (j10 % 15);
        }

        public long a() {
            long j10 = this.f53050e;
            if (j10 == 0) {
                return 0L;
            }
            return this.f53051f / j10;
        }

        public long b() {
            return this.f53051f;
        }

        public boolean d() {
            long j10 = this.f53049d;
            if (j10 == 0) {
                return false;
            }
            return this.f53052g[c(j10 - 1)];
        }

        public boolean e() {
            return this.f53049d > 15 && this.f53053h == 0;
        }

        public void f(long j10) {
            long j11 = this.f53049d;
            if (j11 == 0) {
                this.f53046a = j10;
            } else if (j11 == 1) {
                long j12 = j10 - this.f53046a;
                this.f53047b = j12;
                this.f53051f = j12;
                this.f53050e = 1L;
            } else {
                long j13 = j10 - this.f53048c;
                int c4 = c(j11);
                if (Math.abs(j13 - this.f53047b) <= 1000000) {
                    this.f53050e++;
                    this.f53051f += j13;
                    boolean[] zArr = this.f53052g;
                    if (zArr[c4]) {
                        zArr[c4] = false;
                        this.f53053h--;
                    }
                } else {
                    boolean[] zArr2 = this.f53052g;
                    if (!zArr2[c4]) {
                        zArr2[c4] = true;
                        this.f53053h++;
                    }
                }
            }
            this.f53049d++;
            this.f53048c = j10;
        }

        public void g() {
            this.f53049d = 0L;
            this.f53050e = 0L;
            this.f53051f = 0L;
            this.f53053h = 0;
            Arrays.fill(this.f53052g, false);
        }
    }

    public long a() {
        if (e()) {
            return this.f53040a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f53040a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f53045f;
    }

    public long d() {
        if (e()) {
            return this.f53040a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f53040a.e();
    }

    public void f(long j10) {
        this.f53040a.f(j10);
        if (this.f53040a.e() && !this.f53043d) {
            this.f53042c = false;
        } else if (this.f53044e != -9223372036854775807L) {
            if (!this.f53042c || this.f53041b.d()) {
                this.f53041b.g();
                this.f53041b.f(this.f53044e);
            }
            this.f53042c = true;
            this.f53041b.f(j10);
        }
        if (this.f53042c && this.f53041b.e()) {
            a aVar = this.f53040a;
            this.f53040a = this.f53041b;
            this.f53041b = aVar;
            this.f53042c = false;
            this.f53043d = false;
        }
        this.f53044e = j10;
        this.f53045f = this.f53040a.e() ? 0 : this.f53045f + 1;
    }

    public void g() {
        this.f53040a.g();
        this.f53041b.g();
        this.f53042c = false;
        this.f53044e = -9223372036854775807L;
        this.f53045f = 0;
    }
}
