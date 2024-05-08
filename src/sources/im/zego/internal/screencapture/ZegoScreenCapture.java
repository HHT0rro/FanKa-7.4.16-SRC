package im.zego.internal.screencapture;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.media.projection.MediaProjection;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.zego.zegoavkit2.screencapture.ZegoScreenCaptureFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoScreenCapture {

    /* renamed from: j, reason: collision with root package name */
    public static long f49907j;

    /* renamed from: a, reason: collision with root package name */
    public final Context f49908a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaProjection f49909b;

    /* renamed from: c, reason: collision with root package name */
    public final ZegoScreenCaptureFactory f49910c;

    /* renamed from: d, reason: collision with root package name */
    public ComponentCallbacks f49911d;

    /* renamed from: e, reason: collision with root package name */
    public Display f49912e;

    /* renamed from: f, reason: collision with root package name */
    public int f49913f;

    /* renamed from: g, reason: collision with root package name */
    public final int f49914g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f49915h;

    /* renamed from: i, reason: collision with root package name */
    public final od.a f49916i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements ComponentCallbacks {
        public a() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            int rotation = ZegoScreenCapture.this.f49912e.getRotation();
            if (rotation == ZegoScreenCapture.this.f49913f) {
                return;
            }
            ZegoScreenCapture.this.f49913f = rotation;
            ZegoScreenCapture.this.k();
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            ZegoScreenCapture.this.f49916i.j();
            ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(ZegoScreenCapture.f49907j, 9);
        }
    }

    public ZegoScreenCapture(Context context, ZegoScreenCaptureFactory zegoScreenCaptureFactory, MediaProjection mediaProjection, int i10, od.a aVar) {
        this.f49908a = context;
        this.f49909b = mediaProjection;
        this.f49910c = zegoScreenCaptureFactory;
        this.f49914g = i10;
        this.f49916i = aVar;
    }

    private static native void setCaptureResolution(int i10, int i11, int i12);

    public final boolean g() {
        if (this.f49912e != null) {
            this.f49916i.i();
            ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49907j, 6);
            return false;
        }
        this.f49912e = ((WindowManager) this.f49908a.getSystemService("window")).getDefaultDisplay();
        this.f49913f = -1;
        k();
        a aVar = new a();
        this.f49911d = aVar;
        this.f49908a.registerComponentCallbacks(aVar);
        return true;
    }

    public void h(long j10) {
        f49907j = j10;
    }

    public boolean i() {
        if (!g()) {
            return false;
        }
        ZegoScreenCaptureFactory zegoScreenCaptureFactory = this.f49910c;
        if (zegoScreenCaptureFactory == null) {
            this.f49916i.c();
            ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49907j, 8);
            return false;
        }
        zegoScreenCaptureFactory.setMediaProjection(this.f49909b);
        this.f49915h = true;
        return true;
    }

    public void j() {
        this.f49915h = false;
        ZegoScreenCaptureFactory zegoScreenCaptureFactory = this.f49910c;
        if (zegoScreenCaptureFactory != null) {
            zegoScreenCaptureFactory.setMediaProjection(null);
        }
        ComponentCallbacks componentCallbacks = this.f49911d;
        if (componentCallbacks != null) {
            this.f49908a.unregisterComponentCallbacks(componentCallbacks);
            this.f49911d = null;
        }
        if (this.f49912e != null) {
            this.f49912e = null;
        }
    }

    public final void k() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f49912e.getRealMetrics(displayMetrics);
        setCaptureResolution(displayMetrics.widthPixels, displayMetrics.heightPixels, this.f49914g);
    }

    public void l(boolean z10) {
        if (z10 && !this.f49915h) {
            i();
        } else {
            if (z10 || !this.f49915h) {
                return;
            }
            j();
        }
    }
}
