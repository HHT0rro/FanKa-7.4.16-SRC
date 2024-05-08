package com.tencent.liteav.videoproducer.capture;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.audio.SystemLoopbackRecorder;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.video.ScreenCaptureService;
import com.tencent.rtmp.video.TXScreenCapture;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VirtualDisplayManager {

    /* renamed from: a, reason: collision with root package name */
    private static volatile VirtualDisplayManager f44221a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f44222b;

    /* renamed from: g, reason: collision with root package name */
    private MediaProjection f44227g;

    /* renamed from: h, reason: collision with root package name */
    private ServiceConnection f44228h;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Surface, a> f44225e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private boolean f44226f = false;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f44229i = bg.a(this);

    /* renamed from: j, reason: collision with root package name */
    private final MediaProjection.Callback f44230j = new AnonymousClass1();

    /* renamed from: c, reason: collision with root package name */
    private final Handler f44223c = new CustomHandler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.liteav.base.util.l f44224d = new com.tencent.liteav.base.util.l();

    /* renamed from: com.tencent.liteav.videoproducer.capture.VirtualDisplayManager$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 extends MediaProjection.Callback {
        public AnonymousClass1() {
        }

        @Override // android.media.projection.MediaProjection.Callback
        public final void onStop() {
            LiteavLog.e("VirtualDisplayManager", "MediaProjection session is no longer valid");
            VirtualDisplayManager.this.f44224d.a(bk.a(VirtualDisplayManager.this));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface VirtualDisplayListener {
        void onCaptureError();

        void onStartFinish(boolean z10, boolean z11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Surface f44233a;

        /* renamed from: b, reason: collision with root package name */
        public int f44234b;

        /* renamed from: c, reason: collision with root package name */
        public int f44235c;

        /* renamed from: d, reason: collision with root package name */
        public VirtualDisplayListener f44236d;

        /* renamed from: e, reason: collision with root package name */
        public VirtualDisplay f44237e;

        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    private VirtualDisplayManager(Context context) {
        this.f44222b = context.getApplicationContext();
    }

    public static VirtualDisplayManager a(Context context) {
        if (f44221a == null) {
            synchronized (VirtualDisplayManager.class) {
                if (f44221a == null) {
                    f44221a = new VirtualDisplayManager(context);
                }
            }
        }
        return f44221a;
    }

    private void c() {
        LiteavLog.i("VirtualDisplayManager", "stopScreenCaptureService");
        try {
            ServiceConnection serviceConnection = this.f44228h;
            if (serviceConnection != null) {
                this.f44222b.unbindService(serviceConnection);
                this.f44228h = null;
            }
        } catch (Throwable unused) {
        }
    }

    private void b() {
        for (a aVar : this.f44225e.values()) {
            if (aVar.f44237e == null) {
                try {
                    aVar.f44237e = this.f44227g.createVirtualDisplay("TXCScreenCapture", aVar.f44234b, aVar.f44235c, 1, 1, aVar.f44233a, null, null);
                    LiteavLog.i("VirtualDisplayManager", "create VirtualDisplay " + ((Object) aVar.f44237e));
                    VirtualDisplayListener virtualDisplayListener = aVar.f44236d;
                    if (virtualDisplayListener != null) {
                        virtualDisplayListener.onStartFinish(true, false);
                    }
                } catch (Throwable th) {
                    LiteavLog.e("VirtualDisplayManager", "create VirtualDisplay error ", th);
                    VirtualDisplayListener virtualDisplayListener2 = aVar.f44236d;
                    if (virtualDisplayListener2 != null) {
                        virtualDisplayListener2.onStartFinish(false, false);
                    }
                }
            }
        }
    }

    public static /* synthetic */ void c(VirtualDisplayManager virtualDisplayManager) {
        HashMap hashMap = new HashMap(virtualDisplayManager.f44225e);
        virtualDisplayManager.f44225e.clear();
        for (a aVar : hashMap.values()) {
            VirtualDisplayListener virtualDisplayListener = aVar.f44236d;
            if (virtualDisplayListener != null) {
                if (aVar.f44237e != null) {
                    virtualDisplayListener.onCaptureError();
                } else {
                    virtualDisplayListener.onStartFinish(false, false);
                }
            }
        }
        virtualDisplayManager.a(false);
    }

    public final void a(Surface surface, int i10, int i11, MediaProjection mediaProjection, boolean z10, VirtualDisplayListener virtualDisplayListener) {
        LiteavLog.i("VirtualDisplayManager", "startVirtualDisplaySync, surface:" + ((Object) surface) + ", width:" + i10 + ", height:" + i11 + ", mediaProjection: " + ((Object) mediaProjection) + ", enableForegroundService: " + z10 + ", listener:" + ((Object) virtualDisplayListener));
        this.f44224d.b(bh.a(this, surface, i10, i11, mediaProjection, z10, virtualDisplayListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f44226f) {
            return;
        }
        this.f44226f = true;
        Intent intent = new Intent(this.f44222b, (Class<?>) TXScreenCapture.TXScreenCaptureAssistantActivity.class);
        intent.addFlags(268435456);
        this.f44222b.startActivity(intent);
    }

    private static void b(MediaProjection mediaProjection) {
        try {
            int i10 = SystemLoopbackRecorder.f42602a;
            SystemLoopbackRecorder.class.getMethod("notifyMediaProjectionState", MediaProjection.class).invoke(null, mediaProjection);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            LiteavLog.e("VirtualDisplayManager", "fail to send media projection session " + e2.getMessage());
        }
    }

    public final void a(Surface surface) {
        LiteavLog.i("VirtualDisplayManager", "stopVirtualDisplaySync, surface:".concat(String.valueOf(surface)));
        this.f44224d.b(bi.a(this, surface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10) {
        if (this.f44225e.isEmpty()) {
            if (z10) {
                this.f44224d.b(this.f44229i, TimeUnit.SECONDS.toMillis(1L));
                return;
            }
            LiteavLog.i("VirtualDisplayManager", "Stop media projection session " + ((Object) this.f44227g));
            if (this.f44227g != null) {
                b((MediaProjection) null);
                try {
                    this.f44227g.unregisterCallback(this.f44230j);
                    this.f44227g.stop();
                } catch (Throwable th) {
                    LiteavLog.w("VirtualDisplayManager", "stop media projection session with exception ", th);
                }
                this.f44227g = null;
            }
            c();
        }
    }

    public final void a(MediaProjection mediaProjection) {
        this.f44224d.a(bj.a(this, mediaProjection));
    }

    public static /* synthetic */ void a(VirtualDisplayManager virtualDisplayManager, MediaProjection mediaProjection) {
        virtualDisplayManager.f44226f = false;
        if (mediaProjection == null) {
            HashMap hashMap = new HashMap(virtualDisplayManager.f44225e);
            virtualDisplayManager.f44225e.clear();
            Iterator iterator2 = hashMap.values().iterator2();
            while (iterator2.hasNext()) {
                VirtualDisplayListener virtualDisplayListener = ((a) iterator2.next()).f44236d;
                if (virtualDisplayListener != null) {
                    virtualDisplayListener.onStartFinish(false, true);
                }
            }
            virtualDisplayManager.c();
            return;
        }
        LiteavLog.i("VirtualDisplayManager", "Got session ".concat(String.valueOf(mediaProjection)));
        virtualDisplayManager.f44227g = mediaProjection;
        mediaProjection.registerCallback(virtualDisplayManager.f44230j, virtualDisplayManager.f44223c);
        virtualDisplayManager.b();
        b(virtualDisplayManager.f44227g);
        virtualDisplayManager.a(true);
    }

    public static /* synthetic */ void a(VirtualDisplayManager virtualDisplayManager, Surface surface) {
        VirtualDisplay virtualDisplay;
        if (surface != null) {
            a remove = virtualDisplayManager.f44225e.remove(surface);
            if (remove != null && (virtualDisplay = remove.f44237e) != null) {
                virtualDisplay.release();
                LiteavLog.i("VirtualDisplayManager", "VirtualDisplay released, " + ((Object) remove.f44237e));
            }
            virtualDisplayManager.a(true);
        }
    }

    public static /* synthetic */ void a(VirtualDisplayManager virtualDisplayManager, Surface surface, int i10, int i11, MediaProjection mediaProjection, boolean z10, VirtualDisplayListener virtualDisplayListener) {
        boolean z11 = false;
        byte b4 = 0;
        if (surface == null) {
            LiteavLog.e("VirtualDisplayManager", "surface is null!");
            virtualDisplayListener.onStartFinish(false, false);
            return;
        }
        a aVar = new a(b4 == true ? 1 : 0);
        aVar.f44233a = surface;
        aVar.f44234b = i10;
        aVar.f44235c = i11;
        aVar.f44236d = virtualDisplayListener;
        aVar.f44237e = null;
        virtualDisplayManager.f44225e.put(surface, aVar);
        virtualDisplayManager.f44224d.c(virtualDisplayManager.f44229i);
        MediaProjection mediaProjection2 = virtualDisplayManager.f44227g;
        if (mediaProjection2 != null || mediaProjection != null) {
            if (mediaProjection != null && mediaProjection2 != mediaProjection) {
                LiteavLog.i("VirtualDisplayManager", "start capture with media projection from user:".concat(String.valueOf(mediaProjection)));
                virtualDisplayManager.a(mediaProjection);
                return;
            } else {
                virtualDisplayManager.b();
                return;
            }
        }
        if (!z10) {
            virtualDisplayManager.a();
            return;
        }
        if (virtualDisplayManager.f44228h != null) {
            LiteavLog.i("VirtualDisplayManager", "service is created");
            return;
        }
        virtualDisplayManager.f44228h = new ServiceConnection() { // from class: com.tencent.liteav.videoproducer.capture.VirtualDisplayManager.2
            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LiteavLog.i("VirtualDisplayManager", "screen capture service connected");
                VirtualDisplayManager.this.a();
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                LiteavLog.i("VirtualDisplayManager", "screen capture service disconnected");
            }
        };
        try {
            z11 = virtualDisplayManager.f44222b.bindService(new Intent(virtualDisplayManager.f44222b, (Class<?>) ScreenCaptureService.class), virtualDisplayManager.f44228h, 1);
        } catch (Throwable unused) {
        }
        if (z11) {
            return;
        }
        LiteavLog.w("VirtualDisplayManager", "Start foreground service failed, but also request permission");
        virtualDisplayManager.a();
    }
}
