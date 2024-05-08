package com.tencent.liteav.audio.earmonitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.earmonitor.a.b.a.c;
import com.tencent.liteav.audio.earmonitor.a.b.a.d;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.w;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends SystemAudioKit implements com.tencent.liteav.audio.earmonitor.a.b.a.e, w.a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f42606a = (int) TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    private final Context f42607b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f42608c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.liteav.audio.earmonitor.a.b.a.d f42609d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.liteav.audio.earmonitor.a.b.a.c f42610e;

    /* renamed from: f, reason: collision with root package name */
    private w f42611f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f42612g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f42613h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f42614i;

    public a(long j10, Context context) {
        super(j10);
        this.f42608c = new Handler(Looper.getMainLooper());
        this.f42612g = false;
        this.f42613h = false;
        this.f42614i = false;
        this.f42607b = context.getApplicationContext();
    }

    public static /* synthetic */ void b(a aVar, int i10) {
        if (aVar.f42610e == null) {
            return;
        }
        if (aVar.f42610e.a(c.a.CMD_SET_VOCAL_VOLUME_BASE, com.tencent.liteav.base.util.h.a(i10, 0, 100)) != 0) {
            aVar.notifySystemError(aVar);
        }
    }

    public static /* synthetic */ void c(a aVar) {
        com.tencent.liteav.audio.earmonitor.a.b.a.c cVar = aVar.f42610e;
        if (cVar != null) {
            cVar.a();
            aVar.f42610e = null;
        }
        com.tencent.liteav.audio.earmonitor.a.b.a.d dVar = aVar.f42609d;
        if (dVar != null) {
            dVar.b();
            aVar.f42609d = null;
        }
        aVar.f42612g = false;
    }

    public static /* synthetic */ void d(a aVar) {
        if (aVar.f42609d != null) {
            return;
        }
        aVar.f42612g = true;
        com.tencent.liteav.audio.earmonitor.a.b.a.d dVar = new com.tencent.liteav.audio.earmonitor.a.b.a.d(aVar.f42607b, aVar);
        aVar.f42609d = dVar;
        dVar.a();
    }

    @Override // com.tencent.liteav.audio.earmonitor.a.b.a.e
    public final void a(int i10) {
        a(g.a(this, i10));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void initialize() {
        a(b.a(this));
    }

    @Override // com.tencent.liteav.base.util.w.a
    public final void onTimeout() {
        boolean z10 = LiteavSystemInfo.getAppBackgroundState() == 1;
        if (this.f42614i && this.f42613h && !z10) {
            LiteavLog.i("HwSystemAudioKit", "app return to foreground.");
            b();
            a();
        } else if (z10 && !this.f42613h) {
            LiteavLog.i("HwSystemAudioKit", "app has gone to background.");
        }
        this.f42613h = z10;
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void setEarMonitoringVolume(int i10) {
        a(f.a(this, i10));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void startEarMonitoring() {
        a(d.a(this));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void stopEarMonitoring() {
        a(e.a(this));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void terminate() {
        a(c.a(this));
    }

    private void a() {
        com.tencent.liteav.audio.earmonitor.a.b.a.c cVar = this.f42610e;
        if (cVar == null) {
            return;
        }
        int a10 = cVar.a(true);
        if (a10 != 0 && a10 != 1805) {
            notifySystemError(this);
        } else {
            this.f42614i = true;
        }
    }

    private void b() {
        com.tencent.liteav.audio.earmonitor.a.b.a.c cVar = this.f42610e;
        if (cVar == null) {
            return;
        }
        cVar.a(false);
        this.f42614i = false;
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() == this.f42608c.getLooper()) {
            runnable.run();
        } else {
            this.f42608c.post(runnable);
        }
    }

    public static /* synthetic */ void b(a aVar) {
        if (aVar.f42611f == null) {
            w wVar = new w(Looper.getMainLooper(), aVar);
            aVar.f42611f = wVar;
            wVar.a(0, f42606a);
        }
        aVar.a();
    }

    public static /* synthetic */ void a(a aVar, int i10) {
        LiteavLog.i("HwSystemAudioKit", "on audio kit callback: %d", Integer.valueOf(i10));
        if (i10 != 0) {
            if (i10 != 2 && i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
                switch (i10) {
                    case 1000:
                        aVar.notifyEarMonitoringInitialized(aVar, true);
                        return;
                    case 1001:
                    case 1002:
                    case 1003:
                        break;
                    default:
                        return;
                }
            }
            if (aVar.f42612g) {
                aVar.f42612g = false;
                aVar.notifyEarMonitoringInitialized(aVar, false);
                return;
            } else {
                aVar.notifySystemError(aVar);
                return;
            }
        }
        aVar.f42612g = false;
        com.tencent.liteav.audio.earmonitor.a.b.a.d dVar = aVar.f42609d;
        if (dVar != null) {
            d.a aVar2 = d.a.HWAUDIO_FEATURE_KARAOKE;
            if (dVar.a(aVar2)) {
                aVar.f42610e = (com.tencent.liteav.audio.earmonitor.a.b.a.c) aVar.f42609d.b(aVar2);
                return;
            }
        }
        aVar.notifyEarMonitoringInitialized(aVar, false);
    }

    public static /* synthetic */ void a(a aVar) {
        w wVar = aVar.f42611f;
        if (wVar != null) {
            wVar.a();
            aVar.f42611f = null;
        }
        aVar.b();
    }
}
