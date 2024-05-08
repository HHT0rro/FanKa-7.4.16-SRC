package x4;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.j0;

/* compiled from: AudioTimestampPoller.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f54425a;

    /* renamed from: b, reason: collision with root package name */
    public int f54426b;

    /* renamed from: c, reason: collision with root package name */
    public long f54427c;

    /* renamed from: d, reason: collision with root package name */
    public long f54428d;

    /* renamed from: e, reason: collision with root package name */
    public long f54429e;

    /* renamed from: f, reason: collision with root package name */
    public long f54430f;

    /* compiled from: AudioTimestampPoller.java */
    @RequiresApi(19)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final AudioTrack f54431a;

        /* renamed from: b, reason: collision with root package name */
        public final AudioTimestamp f54432b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        public long f54433c;

        /* renamed from: d, reason: collision with root package name */
        public long f54434d;

        /* renamed from: e, reason: collision with root package name */
        public long f54435e;

        public a(AudioTrack audioTrack) {
            this.f54431a = audioTrack;
        }

        public long a() {
            return this.f54435e;
        }

        public long b() {
            return this.f54432b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f54431a.getTimestamp(this.f54432b);
            if (timestamp) {
                long j10 = this.f54432b.framePosition;
                if (this.f54434d > j10) {
                    this.f54433c++;
                }
                this.f54434d = j10;
                this.f54435e = j10 + (this.f54433c << 32);
            }
            return timestamp;
        }
    }

    public r(AudioTrack audioTrack) {
        if (j0.f22990a >= 19) {
            this.f54425a = new a(audioTrack);
            g();
        } else {
            this.f54425a = null;
            h(3);
        }
    }

    public void a() {
        if (this.f54426b == 4) {
            g();
        }
    }

    public long b() {
        a aVar = this.f54425a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    public long c() {
        a aVar = this.f54425a;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        return this.f54426b == 2;
    }

    public boolean e(long j10) {
        a aVar = this.f54425a;
        if (aVar == null || j10 - this.f54429e < this.f54428d) {
            return false;
        }
        this.f54429e = j10;
        boolean c4 = aVar.c();
        int i10 = this.f54426b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (c4) {
                        g();
                    }
                } else if (!c4) {
                    g();
                }
            } else if (!c4) {
                g();
            } else if (this.f54425a.a() > this.f54430f) {
                h(2);
            }
        } else if (c4) {
            if (this.f54425a.b() < this.f54427c) {
                return false;
            }
            this.f54430f = this.f54425a.a();
            h(1);
        } else if (j10 - this.f54427c > 500000) {
            h(3);
        }
        return c4;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.f54425a != null) {
            h(0);
        }
    }

    public final void h(int i10) {
        this.f54426b = i10;
        if (i10 == 0) {
            this.f54429e = 0L;
            this.f54430f = -1L;
            this.f54427c = System.nanoTime() / 1000;
            this.f54428d = 10000L;
            return;
        }
        if (i10 == 1) {
            this.f54428d = 10000L;
            return;
        }
        if (i10 == 2 || i10 == 3) {
            this.f54428d = 10000000L;
        } else {
            if (i10 == 4) {
                this.f54428d = 500000L;
                return;
            }
            throw new IllegalStateException();
        }
    }
}
