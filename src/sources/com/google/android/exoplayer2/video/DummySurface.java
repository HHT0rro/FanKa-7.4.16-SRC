package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.m;

@RequiresApi(17)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DummySurface extends Surface {

    /* renamed from: e, reason: collision with root package name */
    public static int f23046e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f23047f;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f23048b;

    /* renamed from: c, reason: collision with root package name */
    public final b f23049c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f23050d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b extends HandlerThread implements Handler.Callback {

        /* renamed from: b, reason: collision with root package name */
        public EGLSurfaceTexture f23051b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f23052c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public Error f23053d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public RuntimeException f23054e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public DummySurface f23055f;

        public b() {
            super("ExoPlayer:DummySurface");
        }

        public DummySurface a(int i10) {
            boolean z10;
            start();
            this.f23052c = new Handler(getLooper(), this);
            this.f23051b = new EGLSurfaceTexture(this.f23052c);
            synchronized (this) {
                z10 = false;
                this.f23052c.obtainMessage(1, i10, 0).sendToTarget();
                while (this.f23055f == null && this.f23054e == null && this.f23053d == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f23054e;
            if (runtimeException == null) {
                Error error = this.f23053d;
                if (error == null) {
                    return (DummySurface) com.google.android.exoplayer2.util.a.e(this.f23055f);
                }
                throw error;
            }
            throw runtimeException;
        }

        public final void b(int i10) {
            com.google.android.exoplayer2.util.a.e(this.f23051b);
            this.f23051b.h(i10);
            this.f23055f = new DummySurface(this, this.f23051b.g(), i10 != 0);
        }

        public void c() {
            com.google.android.exoplayer2.util.a.e(this.f23052c);
            this.f23052c.sendEmptyMessage(2);
        }

        public final void d() {
            com.google.android.exoplayer2.util.a.e(this.f23051b);
            this.f23051b.i();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            try {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    m.d("DummySurface", "Failed to initialize dummy surface", e2);
                    this.f23053d = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e10) {
                    m.d("DummySurface", "Failed to initialize dummy surface", e10);
                    this.f23054e = e10;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    public static int a(Context context) {
        if (i.h(context)) {
            return i.i() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean b(Context context) {
        boolean z10;
        synchronized (DummySurface.class) {
            if (!f23047f) {
                f23046e = a(context);
                f23047f = true;
            }
            z10 = f23046e != 0;
        }
        return z10;
    }

    public static DummySurface c(Context context, boolean z10) {
        com.google.android.exoplayer2.util.a.g(!z10 || b(context));
        return new b().a(z10 ? f23046e : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f23049c) {
            if (!this.f23050d) {
                this.f23049c.c();
                this.f23050d = true;
            }
        }
    }

    public DummySurface(b bVar, SurfaceTexture surfaceTexture, boolean z10) {
        super(surfaceTexture);
        this.f23049c = bVar;
        this.f23048b = z10;
    }
}
