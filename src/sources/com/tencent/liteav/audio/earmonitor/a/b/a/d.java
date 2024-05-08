package com.tencent.liteav.audio.earmonitor.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.liteav.audio.earmonitor.a.a.a;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Integer> f42636a = new ArrayList(0);

    /* renamed from: b, reason: collision with root package name */
    private Context f42637b;

    /* renamed from: e, reason: collision with root package name */
    private b f42640e;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.liteav.audio.earmonitor.a.a.a f42638c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f42639d = false;

    /* renamed from: f, reason: collision with root package name */
    private IBinder f42641f = null;

    /* renamed from: g, reason: collision with root package name */
    private ServiceConnection f42642g = new ServiceConnection() { // from class: com.tencent.liteav.audio.earmonitor.a.b.a.d.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f42638c = a.AbstractBinderC0632a.a(iBinder);
            if (d.this.f42638c != null) {
                d.this.f42639d = true;
                d.this.f42640e.a(0);
                d dVar = d.this;
                d.a(dVar, dVar.f42637b.getPackageName(), "1.0.1");
                d.a(d.this, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.f42638c = null;
            d.this.f42639d = false;
            d.this.f42640e.a(4);
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private IBinder.DeathRecipient f42643h = new IBinder.DeathRecipient() { // from class: com.tencent.liteav.audio.earmonitor.a.b.a.d.2
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            d.this.f42641f.unlinkToDeath(d.this.f42643h, 0);
            d.this.f42640e.a(6);
            LiteavLog.e("HwAudioKit.HwAudioKit", "service binder died");
            d.f(d.this);
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        HWAUDIO_FEATURE_KARAOKE;

        public int mFeatureType = 1;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        a(String str) {
        }
    }

    public d(Context context, e eVar) {
        this.f42637b = null;
        b a10 = b.a();
        this.f42640e = a10;
        a10.f42622a = eVar;
        this.f42637b = context;
    }

    public static /* synthetic */ IBinder f(d dVar) {
        dVar.f42641f = null;
        return null;
    }

    public final void b() {
        if (this.f42639d) {
            this.f42639d = false;
            b.a(this.f42637b, this.f42642g);
        }
    }

    public final void a() {
        Context context = this.f42637b;
        if (context == null) {
            this.f42640e.a(7);
            return;
        }
        if (!b.a(context)) {
            this.f42640e.a(2);
            return;
        }
        Context context2 = this.f42637b;
        if (this.f42640e == null || this.f42639d) {
            return;
        }
        b.a(context2, this.f42642g, "com.huawei.multimedia.audioengine.HwAudioEngineService");
    }

    public final <T extends com.tencent.liteav.audio.earmonitor.a.b.a.a> T b(a aVar) {
        if (this.f42640e == null || aVar == null) {
            return null;
        }
        return (T) b.a(aVar.mFeatureType, this.f42637b);
    }

    public final boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        try {
            com.tencent.liteav.audio.earmonitor.a.a.a aVar2 = this.f42638c;
            if (aVar2 != null && this.f42639d) {
                return aVar2.a(aVar.mFeatureType);
            }
        } catch (RemoteException e2) {
            LiteavLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", e2.getMessage());
        }
        return false;
    }

    public static /* synthetic */ void a(d dVar, String str, String str2) {
        try {
            com.tencent.liteav.audio.earmonitor.a.a.a aVar = dVar.f42638c;
            if (aVar == null || !dVar.f42639d) {
                return;
            }
            aVar.a(str, str2);
        } catch (RemoteException e2) {
            LiteavLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", e2.getMessage());
        }
    }

    public static /* synthetic */ void a(d dVar, IBinder iBinder) {
        dVar.f42641f = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(dVar.f42643h, 0);
            } catch (RemoteException unused) {
                dVar.f42640e.a(5);
                LiteavLog.e("HwAudioKit.HwAudioKit", "serviceLinkToDeath, RemoteException");
            }
        }
    }
}
