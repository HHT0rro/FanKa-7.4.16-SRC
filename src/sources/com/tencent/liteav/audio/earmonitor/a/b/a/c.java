package com.tencent.liteav.audio.earmonitor.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.liteav.audio.earmonitor.a.a.b;
import com.tencent.liteav.base.util.LiteavLog;
import com.zego.ve.HwAudioKit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends com.tencent.liteav.audio.earmonitor.a.b.a.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f42623a;

    /* renamed from: b, reason: collision with root package name */
    public b f42624b;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.liteav.audio.earmonitor.a.a.b f42626d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f42625c = false;

    /* renamed from: e, reason: collision with root package name */
    public IBinder f42627e = null;

    /* renamed from: g, reason: collision with root package name */
    private ServiceConnection f42629g = new ServiceConnection() { // from class: com.tencent.liteav.audio.earmonitor.a.b.a.c.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.f42626d = b.a.a(iBinder);
            c cVar = c.this;
            if (cVar.f42626d != null) {
                cVar.f42625c = true;
                cVar.f42624b.a(1000);
                c cVar2 = c.this;
                String packageName = cVar2.f42623a.getPackageName();
                try {
                    com.tencent.liteav.audio.earmonitor.a.a.b bVar = cVar2.f42626d;
                    if (bVar != null && cVar2.f42625c) {
                        bVar.a(packageName);
                    }
                } catch (RemoteException e2) {
                    LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "isFeatureSupported,RemoteException ex : %s", e2.getMessage());
                }
                c.a(c.this, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            c cVar = c.this;
            cVar.f42625c = false;
            b bVar = cVar.f42624b;
            if (bVar != null) {
                bVar.a(1001);
            }
        }
    };

    /* renamed from: f, reason: collision with root package name */
    public IBinder.DeathRecipient f42628f = new IBinder.DeathRecipient() { // from class: com.tencent.liteav.audio.earmonitor.a.b.a.c.2
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
            c cVar = c.this;
            cVar.f42627e.unlinkToDeath(cVar.f42628f, 0);
            c.this.f42624b.a(1003);
            c.this.f42627e = null;
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        CMD_SET_AUDIO_EFFECT_MODE_BASE("Karaoke_reverb_mode="),
        CMD_SET_VOCAL_VOLUME_BASE("Karaoke_volume="),
        CMD_SET_VOCAL_EQUALIZER_MODE("Karaoke_eq_mode=");

        public String mParameName;

        a(String str) {
            this.mParameName = str;
        }
    }

    public c(Context context) {
        this.f42624b = null;
        this.f42624b = b.a();
        this.f42623a = context;
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        if (!b.a(context)) {
            this.f42624b.a(2);
        } else {
            if (this.f42624b == null || this.f42625c) {
                return;
            }
            b.a(context, this.f42629g, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService");
        }
    }

    public final void a() {
        if (this.f42625c) {
            this.f42625c = false;
            b.a(this.f42623a, this.f42629g);
        }
    }

    public final int a(boolean z10) {
        try {
            com.tencent.liteav.audio.earmonitor.a.a.b bVar = this.f42626d;
            if (bVar == null || !this.f42625c) {
                return -2;
            }
            return bVar.a(z10);
        } catch (RemoteException e2) {
            LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature,RemoteException ex : %s", e2.getMessage());
            return -2;
        }
    }

    public final int a(a aVar, int i10) {
        if (aVar == null) {
            return HwAudioKit.PARAME_VALUE_ERROR;
        }
        try {
            com.tencent.liteav.audio.earmonitor.a.a.b bVar = this.f42626d;
            if (bVar == null || !this.f42625c) {
                return -2;
            }
            return bVar.a(aVar.mParameName, i10);
        } catch (RemoteException e2) {
            LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "setParameter,RemoteException ex : %s", e2.getMessage());
            return -2;
        }
    }

    public static /* synthetic */ void a(c cVar, IBinder iBinder) {
        cVar.f42627e = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(cVar.f42628f, 0);
            } catch (RemoteException unused) {
                cVar.f42624b.a(1002);
                LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "serviceLinkToDeath, RemoteException");
            }
        }
    }
}
