package q6;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.video.DummySurface;
import com.huawei.quickcard.base.Attributes;

/* compiled from: VideoFrameReleaseHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final q6.c f53093a = new q6.c();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final a f53094b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final d f53095c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f53096d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Surface f53097e;

    /* renamed from: f, reason: collision with root package name */
    public float f53098f;

    /* renamed from: g, reason: collision with root package name */
    public float f53099g;

    /* renamed from: h, reason: collision with root package name */
    public float f53100h;

    /* renamed from: i, reason: collision with root package name */
    public float f53101i;

    /* renamed from: j, reason: collision with root package name */
    public long f53102j;

    /* renamed from: k, reason: collision with root package name */
    public long f53103k;

    /* renamed from: l, reason: collision with root package name */
    public long f53104l;

    /* renamed from: m, reason: collision with root package name */
    public long f53105m;

    /* renamed from: n, reason: collision with root package name */
    public long f53106n;

    /* renamed from: o, reason: collision with root package name */
    public long f53107o;

    /* renamed from: p, reason: collision with root package name */
    public long f53108p;

    /* compiled from: VideoFrameReleaseHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {

        /* compiled from: VideoFrameReleaseHelper.java */
        /* renamed from: q6.j$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public interface InterfaceC0808a {
            void a(@Nullable Display display);
        }

        void a();

        void b(InterfaceC0808a interfaceC0808a);
    }

    /* compiled from: VideoFrameReleaseHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final WindowManager f53109a;

        public b(WindowManager windowManager) {
            this.f53109a = windowManager;
        }

        @Nullable
        public static a c(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new b(windowManager);
            }
            return null;
        }

        @Override // q6.j.a
        public void a() {
        }

        @Override // q6.j.a
        public void b(a.InterfaceC0808a interfaceC0808a) {
            interfaceC0808a.a(this.f53109a.getDefaultDisplay());
        }
    }

    /* compiled from: VideoFrameReleaseHelper.java */
    @RequiresApi(17)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements a, DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        public final DisplayManager f53110a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public a.InterfaceC0808a f53111b;

        public c(DisplayManager displayManager) {
            this.f53110a = displayManager;
        }

        @Nullable
        public static a d(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(Attributes.Style.DISPLAY);
            if (displayManager != null) {
                return new c(displayManager);
            }
            return null;
        }

        @Override // q6.j.a
        public void a() {
            this.f53110a.unregisterDisplayListener(this);
            this.f53111b = null;
        }

        @Override // q6.j.a
        public void b(a.InterfaceC0808a interfaceC0808a) {
            this.f53111b = interfaceC0808a;
            this.f53110a.registerDisplayListener(this, j0.x());
            interfaceC0808a.a(c());
        }

        public final Display c() {
            return this.f53110a.getDisplay(0);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
            a.InterfaceC0808a interfaceC0808a = this.f53111b;
            if (interfaceC0808a == null || i10 != 0) {
                return;
            }
            interfaceC0808a.a(c());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
        }
    }

    /* compiled from: VideoFrameReleaseHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: g, reason: collision with root package name */
        public static final d f53112g = new d();

        /* renamed from: b, reason: collision with root package name */
        public volatile long f53113b = -9223372036854775807L;

        /* renamed from: c, reason: collision with root package name */
        public final Handler f53114c;

        /* renamed from: d, reason: collision with root package name */
        public final HandlerThread f53115d;

        /* renamed from: e, reason: collision with root package name */
        public Choreographer f53116e;

        /* renamed from: f, reason: collision with root package name */
        public int f53117f;

        public d() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f53115d = handlerThread;
            handlerThread.start();
            Handler w3 = j0.w(handlerThread.getLooper(), this);
            this.f53114c = w3;
            w3.sendEmptyMessage(0);
        }

        public static d d() {
            return f53112g;
        }

        public void a() {
            this.f53114c.sendEmptyMessage(1);
        }

        public final void b() {
            int i10 = this.f53117f + 1;
            this.f53117f = i10;
            if (i10 == 1) {
                ((Choreographer) com.google.android.exoplayer2.util.a.e(this.f53116e)).postFrameCallback(this);
            }
        }

        public final void c() {
            this.f53116e = Choreographer.getInstance();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            this.f53113b = j10;
            ((Choreographer) com.google.android.exoplayer2.util.a.e(this.f53116e)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f53114c.sendEmptyMessage(2);
        }

        public final void f() {
            int i10 = this.f53117f - 1;
            this.f53117f = i10;
            if (i10 == 0) {
                ((Choreographer) com.google.android.exoplayer2.util.a.e(this.f53116e)).removeFrameCallback(this);
                this.f53113b = -9223372036854775807L;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c();
                return true;
            }
            if (i10 == 1) {
                b();
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public j(@Nullable Context context) {
        a f10 = f(context);
        this.f53094b = f10;
        this.f53095c = f10 != null ? d.d() : null;
        this.f53102j = -9223372036854775807L;
        this.f53103k = -9223372036854775807L;
        this.f53098f = -1.0f;
        this.f53101i = 1.0f;
    }

    public static boolean c(long j10, long j11) {
        return Math.abs(j10 - j11) <= 20000000;
    }

    public static long e(long j10, long j11, long j12) {
        long j13;
        long j14 = j11 + (((j10 - j11) / j12) * j12);
        if (j10 <= j14) {
            j13 = j14 - j12;
        } else {
            j14 = j12 + j14;
            j13 = j14;
        }
        return j14 - j10 < j10 - j13 ? j14 : j13;
    }

    @Nullable
    public static a f(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        a d10 = j0.f22990a >= 17 ? c.d(applicationContext) : null;
        return d10 == null ? b.c(applicationContext) : d10;
    }

    @RequiresApi(30)
    public static void q(Surface surface, float f10) {
        try {
            surface.setFrameRate(f10, f10 == 0.0f ? 0 : 1);
        } catch (IllegalStateException e2) {
            com.google.android.exoplayer2.util.m.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e2);
        }
    }

    public long b(long j10) {
        long j11;
        d dVar;
        if (this.f53107o != -1 && this.f53093a.e()) {
            long a10 = this.f53108p + (((float) (this.f53093a.a() * (this.f53104l - this.f53107o))) / this.f53101i);
            if (!c(j10, a10)) {
                p();
            } else {
                j11 = a10;
                this.f53105m = this.f53104l;
                this.f53106n = j11;
                dVar = this.f53095c;
                if (dVar != null || this.f53102j == -9223372036854775807L) {
                    return j11;
                }
                long j12 = dVar.f53113b;
                return j12 == -9223372036854775807L ? j11 : e(j11, j12, this.f53102j) - this.f53103k;
            }
        }
        j11 = j10;
        this.f53105m = this.f53104l;
        this.f53106n = j11;
        dVar = this.f53095c;
        if (dVar != null) {
        }
        return j11;
    }

    public final void d() {
        Surface surface;
        if (j0.f22990a < 30 || (surface = this.f53097e) == null || this.f53100h == 0.0f) {
            return;
        }
        this.f53100h = 0.0f;
        q(surface, 0.0f);
    }

    public void g() {
        a aVar = this.f53094b;
        if (aVar != null) {
            aVar.a();
            ((d) com.google.android.exoplayer2.util.a.e(this.f53095c)).e();
        }
    }

    public void h() {
        if (this.f53094b != null) {
            ((d) com.google.android.exoplayer2.util.a.e(this.f53095c)).a();
            this.f53094b.b(new a.InterfaceC0808a() { // from class: q6.i
                @Override // q6.j.a.InterfaceC0808a
                public final void a(Display display) {
                    j.this.r(display);
                }
            });
        }
    }

    public void i(float f10) {
        this.f53098f = f10;
        this.f53093a.g();
        s();
    }

    public void j(long j10) {
        long j11 = this.f53105m;
        if (j11 != -1) {
            this.f53107o = j11;
            this.f53108p = this.f53106n;
        }
        this.f53104l++;
        this.f53093a.f(j10 * 1000);
        s();
    }

    public void k(float f10) {
        this.f53101i = f10;
        p();
        t(false);
    }

    public void l() {
        p();
    }

    public void m() {
        this.f53096d = true;
        p();
        t(false);
    }

    public void n() {
        this.f53096d = false;
        d();
    }

    public void o(@Nullable Surface surface) {
        if (surface instanceof DummySurface) {
            surface = null;
        }
        if (this.f53097e == surface) {
            return;
        }
        d();
        this.f53097e = surface;
        t(true);
    }

    public final void p() {
        this.f53104l = 0L;
        this.f53107o = -1L;
        this.f53105m = -1L;
    }

    public final void r(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            this.f53102j = refreshRate;
            this.f53103k = (refreshRate * 80) / 100;
        } else {
            com.google.android.exoplayer2.util.m.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f53102j = -9223372036854775807L;
            this.f53103k = -9223372036854775807L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (java.lang.Math.abs(r0 - r8.f53099g) >= (r8.f53093a.e() && (r8.f53093a.d() > 5000000000L ? 1 : (r8.f53093a.d() == 5000000000L ? 0 : -1)) >= 0 ? 0.02f : 1.0f)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
    
        if (r8.f53093a.c() >= 30) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s() {
        /*
            r8 = this;
            int r0 = com.google.android.exoplayer2.util.j0.f22990a
            r1 = 30
            if (r0 < r1) goto L73
            android.view.Surface r0 = r8.f53097e
            if (r0 != 0) goto Lc
            goto L73
        Lc:
            q6.c r0 = r8.f53093a
            boolean r0 = r0.e()
            if (r0 == 0) goto L1b
            q6.c r0 = r8.f53093a
            float r0 = r0.b()
            goto L1d
        L1b:
            float r0 = r8.f53098f
        L1d:
            float r2 = r8.f53099g
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L24
            return
        L24:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L61
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L61
            q6.c r1 = r8.f53093a
            boolean r1 = r1.e()
            if (r1 == 0) goto L49
            q6.c r1 = r8.f53093a
            long r1 = r1.d()
            r6 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 < 0) goto L49
            r1 = 1
            goto L4a
        L49:
            r1 = 0
        L4a:
            if (r1 == 0) goto L50
            r1 = 1017370378(0x3ca3d70a, float:0.02)
            goto L52
        L50:
            r1 = 1065353216(0x3f800000, float:1.0)
        L52:
            float r2 = r8.f53099g
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L5f
            goto L6c
        L5f:
            r5 = 0
            goto L6c
        L61:
            if (r6 == 0) goto L64
            goto L6c
        L64:
            q6.c r2 = r8.f53093a
            int r2 = r2.c()
            if (r2 < r1) goto L5f
        L6c:
            if (r5 == 0) goto L73
            r8.f53099g = r0
            r8.t(r4)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.j.s():void");
    }

    public final void t(boolean z10) {
        Surface surface;
        if (j0.f22990a < 30 || (surface = this.f53097e) == null) {
            return;
        }
        float f10 = 0.0f;
        if (this.f53096d) {
            float f11 = this.f53099g;
            if (f11 != -1.0f) {
                f10 = this.f53101i * f11;
            }
        }
        if (z10 || this.f53100h != f10) {
            this.f53100h = f10;
            q(surface, f10);
        }
    }
}
