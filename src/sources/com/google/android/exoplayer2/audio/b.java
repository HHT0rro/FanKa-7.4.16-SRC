package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import java.lang.reflect.Method;
import x4.r;

/* compiled from: AudioTrackPositionTracker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;

    /* renamed from: a, reason: collision with root package name */
    public final a f19763a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f19764b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AudioTrack f19765c;

    /* renamed from: d, reason: collision with root package name */
    public int f19766d;

    /* renamed from: e, reason: collision with root package name */
    public int f19767e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public r f19768f;

    /* renamed from: g, reason: collision with root package name */
    public int f19769g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f19770h;

    /* renamed from: i, reason: collision with root package name */
    public long f19771i;

    /* renamed from: j, reason: collision with root package name */
    public float f19772j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f19773k;

    /* renamed from: l, reason: collision with root package name */
    public long f19774l;

    /* renamed from: m, reason: collision with root package name */
    public long f19775m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public Method f19776n;

    /* renamed from: o, reason: collision with root package name */
    public long f19777o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f19778p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19779q;

    /* renamed from: r, reason: collision with root package name */
    public long f19780r;

    /* renamed from: s, reason: collision with root package name */
    public long f19781s;

    /* renamed from: t, reason: collision with root package name */
    public long f19782t;

    /* renamed from: u, reason: collision with root package name */
    public long f19783u;

    /* renamed from: v, reason: collision with root package name */
    public int f19784v;

    /* renamed from: w, reason: collision with root package name */
    public int f19785w;

    /* renamed from: x, reason: collision with root package name */
    public long f19786x;

    /* renamed from: y, reason: collision with root package name */
    public long f19787y;

    /* renamed from: z, reason: collision with root package name */
    public long f19788z;

    /* compiled from: AudioTrackPositionTracker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(long j10);

        void b(long j10, long j11, long j12, long j13);

        void c(long j10, long j11, long j12, long j13);

        void d(int i10, long j10);

        void e(long j10);
    }

    public b(a aVar) {
        this.f19763a = (a) com.google.android.exoplayer2.util.a.e(aVar);
        if (j0.f22990a >= 18) {
            try {
                this.f19776n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f19764b = new long[10];
    }

    public static boolean p(int i10) {
        return j0.f22990a < 23 && (i10 == 5 || i10 == 6);
    }

    public final boolean a() {
        return this.f19770h && ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f19765c)).getPlayState() == 2 && f() == 0;
    }

    public final long b(long j10) {
        return (j10 * 1000000) / this.f19769g;
    }

    public int c(long j10) {
        return this.f19767e - ((int) (j10 - (f() * this.f19766d)));
    }

    public long d(boolean z10) {
        long j10;
        if (((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f19765c)).getPlayState() == 3) {
            n();
        }
        long nanoTime = System.nanoTime() / 1000;
        r rVar = (r) com.google.android.exoplayer2.util.a.e(this.f19768f);
        boolean d10 = rVar.d();
        if (d10) {
            j10 = b(rVar.b()) + j0.W(nanoTime - rVar.c(), this.f19772j);
        } else {
            if (this.f19785w == 0) {
                j10 = g();
            } else {
                j10 = this.f19774l + nanoTime;
            }
            if (!z10) {
                j10 = Math.max(0L, j10 - this.f19777o);
            }
        }
        if (this.D != d10) {
            this.F = this.C;
            this.E = this.B;
        }
        long j11 = nanoTime - this.F;
        if (j11 < 1000000) {
            long W = this.E + j0.W(j11, this.f19772j);
            long j12 = (j11 * 1000) / 1000000;
            j10 = ((j10 * j12) + ((1000 - j12) * W)) / 1000;
        }
        if (!this.f19773k) {
            long j13 = this.B;
            if (j10 > j13) {
                this.f19773k = true;
                this.f19763a.a(System.currentTimeMillis() - com.google.android.exoplayer2.h.e(j0.b0(com.google.android.exoplayer2.h.e(j10 - j13), this.f19772j)));
            }
        }
        this.C = nanoTime;
        this.B = j10;
        this.D = d10;
        return j10;
    }

    public long e(long j10) {
        return com.google.android.exoplayer2.h.e(b(j10 - f()));
    }

    public final long f() {
        AudioTrack audioTrack = (AudioTrack) com.google.android.exoplayer2.util.a.e(this.f19765c);
        if (this.f19786x != -9223372036854775807L) {
            return Math.min(this.A, this.f19788z + ((((SystemClock.elapsedRealtime() * 1000) - this.f19786x) * this.f19769g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & audioTrack.getPlaybackHeadPosition();
        if (this.f19770h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f19783u = this.f19781s;
            }
            playbackHeadPosition += this.f19783u;
        }
        if (j0.f22990a <= 29) {
            if (playbackHeadPosition == 0 && this.f19781s > 0 && playState == 3) {
                if (this.f19787y == -9223372036854775807L) {
                    this.f19787y = SystemClock.elapsedRealtime();
                }
                return this.f19781s;
            }
            this.f19787y = -9223372036854775807L;
        }
        if (this.f19781s > playbackHeadPosition) {
            this.f19782t++;
        }
        this.f19781s = playbackHeadPosition;
        return playbackHeadPosition + (this.f19782t << 32);
    }

    public final long g() {
        return b(f());
    }

    public void h(long j10) {
        this.f19788z = f();
        this.f19786x = SystemClock.elapsedRealtime() * 1000;
        this.A = j10;
    }

    public boolean i(long j10) {
        return j10 > f() || a();
    }

    public boolean j() {
        return ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f19765c)).getPlayState() == 3;
    }

    public boolean k(long j10) {
        return this.f19787y != -9223372036854775807L && j10 > 0 && SystemClock.elapsedRealtime() - this.f19787y >= 200;
    }

    public boolean l(long j10) {
        int playState = ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f19765c)).getPlayState();
        if (this.f19770h) {
            if (playState == 2) {
                this.f19778p = false;
                return false;
            }
            if (playState == 1 && f() == 0) {
                return false;
            }
        }
        boolean z10 = this.f19778p;
        boolean i10 = i(j10);
        this.f19778p = i10;
        if (z10 && !i10 && playState != 1) {
            this.f19763a.d(this.f19767e, com.google.android.exoplayer2.h.e(this.f19771i));
        }
        return true;
    }

    public final void m(long j10, long j11) {
        r rVar = (r) com.google.android.exoplayer2.util.a.e(this.f19768f);
        if (rVar.e(j10)) {
            long c4 = rVar.c();
            long b4 = rVar.b();
            if (Math.abs(c4 - j10) > 5000000) {
                this.f19763a.c(b4, c4, j10, j11);
                rVar.f();
            } else if (Math.abs(b(b4) - j11) > 5000000) {
                this.f19763a.b(b4, c4, j10, j11);
                rVar.f();
            } else {
                rVar.a();
            }
        }
    }

    public final void n() {
        long g3 = g();
        if (g3 == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.f19775m >= 30000) {
            long[] jArr = this.f19764b;
            int i10 = this.f19784v;
            jArr[i10] = g3 - nanoTime;
            this.f19784v = (i10 + 1) % 10;
            int i11 = this.f19785w;
            if (i11 < 10) {
                this.f19785w = i11 + 1;
            }
            this.f19775m = nanoTime;
            this.f19774l = 0L;
            int i12 = 0;
            while (true) {
                int i13 = this.f19785w;
                if (i12 >= i13) {
                    break;
                }
                this.f19774l += this.f19764b[i12] / i13;
                i12++;
            }
        }
        if (this.f19770h) {
            return;
        }
        m(nanoTime, g3);
        o(nanoTime);
    }

    public final void o(long j10) {
        Method method;
        if (!this.f19779q || (method = this.f19776n) == null || j10 - this.f19780r < 500000) {
            return;
        }
        try {
            long intValue = (((Integer) j0.j((Integer) method.invoke(com.google.android.exoplayer2.util.a.e(this.f19765c), new Object[0]))).intValue() * 1000) - this.f19771i;
            this.f19777o = intValue;
            long max = Math.max(intValue, 0L);
            this.f19777o = max;
            if (max > 5000000) {
                this.f19763a.e(max);
                this.f19777o = 0L;
            }
        } catch (Exception unused) {
            this.f19776n = null;
        }
        this.f19780r = j10;
    }

    public boolean q() {
        s();
        if (this.f19786x != -9223372036854775807L) {
            return false;
        }
        ((r) com.google.android.exoplayer2.util.a.e(this.f19768f)).g();
        return true;
    }

    public void r() {
        s();
        this.f19765c = null;
        this.f19768f = null;
    }

    public final void s() {
        this.f19774l = 0L;
        this.f19785w = 0;
        this.f19784v = 0;
        this.f19775m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f19773k = false;
    }

    public void t(AudioTrack audioTrack, boolean z10, int i10, int i11, int i12) {
        this.f19765c = audioTrack;
        this.f19766d = i11;
        this.f19767e = i12;
        this.f19768f = new r(audioTrack);
        this.f19769g = audioTrack.getSampleRate();
        this.f19770h = z10 && p(i10);
        boolean o02 = j0.o0(i10);
        this.f19779q = o02;
        this.f19771i = o02 ? b(i12 / i11) : -9223372036854775807L;
        this.f19781s = 0L;
        this.f19782t = 0L;
        this.f19783u = 0L;
        this.f19778p = false;
        this.f19786x = -9223372036854775807L;
        this.f19787y = -9223372036854775807L;
        this.f19780r = 0L;
        this.f19777o = 0L;
        this.f19772j = 1.0f;
    }

    public void u(float f10) {
        this.f19772j = f10;
        r rVar = this.f19768f;
        if (rVar != null) {
            rVar.g();
        }
    }

    public void v() {
        ((r) com.google.android.exoplayer2.util.a.e(this.f19768f)).g();
    }
}
