package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.p0003l.s;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* compiled from: AuthProTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class r extends Thread {

    /* renamed from: c, reason: collision with root package name */
    private static int f6901c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static int f6902d = 3;

    /* renamed from: e, reason: collision with root package name */
    private static long f6903e = 30000;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f6904g;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f6905a;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f6906b;

    /* renamed from: f, reason: collision with root package name */
    private a f6907f = null;

    /* renamed from: h, reason: collision with root package name */
    private Handler f6908h = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.col.3l.r.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (r.f6904g) {
                return;
            }
            if (r.this.f6907f == null) {
                r rVar = r.this;
                rVar.f6907f = new a(rVar.f6906b, r.this.f6905a == null ? null : (Context) r.this.f6905a.get());
            }
            dv.a().a(r.this.f6907f);
        }
    };

    /* compiled from: AuthProTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends je {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IAMapDelegate> f6910a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<Context> f6911b;

        /* renamed from: c, reason: collision with root package name */
        private s f6912c;

        public a(IAMapDelegate iAMapDelegate, Context context) {
            this.f6910a = null;
            this.f6911b = null;
            this.f6910a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.f6911b = new WeakReference<>(context);
            }
        }

        @Override // com.amap.api.col.p0003l.je
        public final void runTask() {
            s.a d10;
            WeakReference<Context> weakReference;
            try {
                if (r.f6904g) {
                    return;
                }
                if (this.f6912c == null && (weakReference = this.f6911b) != null && weakReference.get() != null) {
                    this.f6912c = new s(this.f6911b.get(), "");
                }
                r.b();
                if (r.f6901c > r.f6902d) {
                    r.e();
                    a();
                    return;
                }
                s sVar = this.f6912c;
                if (sVar == null || (d10 = sVar.d()) == null) {
                    return;
                }
                if (!d10.f6920d) {
                    a();
                }
                r.e();
            } catch (Throwable th) {
                gy.b(th, "authForPro", "loadConfigData_uploadException");
                dz.b(dy.f5399e, "auth exception get data " + th.getMessage());
            }
        }

        private void a() {
            final IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.f6910a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.f6910a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.amap.api.col.3l.r.a.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    IAMapDelegate iAMapDelegate2 = iAMapDelegate;
                    if (iAMapDelegate2 == null || iAMapDelegate2.getMapConfig() == null) {
                        return;
                    }
                    MapConfig mapConfig = iAMapDelegate.getMapConfig();
                    mapConfig.setProFunctionAuthEnable(false);
                    if (mapConfig.isUseProFunction()) {
                        iAMapDelegate.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                        iAMapDelegate.reloadMapCustomStyle();
                        dd.a(a.this.f6911b == null ? null : (Context) a.this.f6911b.get(), "鉴权失败，当前key没有自定义纹理的使用权限，自定义纹理相关内容，将不会呈现！");
                    }
                }
            });
        }
    }

    public r(Context context, IAMapDelegate iAMapDelegate) {
        this.f6905a = null;
        if (context != null) {
            this.f6905a = new WeakReference<>(context);
        }
        this.f6906b = iAMapDelegate;
        f();
    }

    public static /* synthetic */ int b() {
        int i10 = f6901c;
        f6901c = i10 + 1;
        return i10;
    }

    public static /* synthetic */ boolean e() {
        f6904g = true;
        return true;
    }

    private static void f() {
        f6901c = 0;
        f6904g = false;
    }

    private void g() {
        if (f6904g) {
            return;
        }
        int i10 = 0;
        while (i10 <= f6902d) {
            i10++;
            this.f6908h.sendEmptyMessageDelayed(0, i10 * f6903e);
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        this.f6906b = null;
        this.f6905a = null;
        Handler handler = this.f6908h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f6908h = null;
        this.f6907f = null;
        f();
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            g();
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
            dz.b(dy.f5399e, "auth pro exception " + th.getMessage());
        }
    }
}
