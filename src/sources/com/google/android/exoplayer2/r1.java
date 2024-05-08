package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.android.internal.os.PowerProfile;

/* compiled from: StreamVolumeManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21121a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f21122b;

    /* renamed from: c, reason: collision with root package name */
    public final b f21123c;

    /* renamed from: d, reason: collision with root package name */
    public final AudioManager f21124d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public c f21125e;

    /* renamed from: f, reason: collision with root package name */
    public int f21126f;

    /* renamed from: g, reason: collision with root package name */
    public int f21127g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21128h;

    /* compiled from: StreamVolumeManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void g(int i10);

        void p(int i10, boolean z10);
    }

    /* compiled from: StreamVolumeManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = r1.this.f21122b;
            final r1 r1Var = r1.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.s1
                @Override // java.lang.Runnable
                public final void run() {
                    r1.b(r1.this);
                }
            });
        }
    }

    public r1(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f21121a = applicationContext;
        this.f21122b = handler;
        this.f21123c = bVar;
        AudioManager audioManager = (AudioManager) com.google.android.exoplayer2.util.a.i((AudioManager) applicationContext.getSystemService(PowerProfile.POWER_AUDIO));
        this.f21124d = audioManager;
        this.f21126f = 3;
        this.f21127g = f(audioManager, 3);
        this.f21128h = e(audioManager, this.f21126f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter(com.huawei.openalliance.ad.constant.u.f32364ca));
            this.f21125e = cVar;
        } catch (RuntimeException e2) {
            com.google.android.exoplayer2.util.m.i("StreamVolumeManager", "Error registering stream volume receiver", e2);
        }
    }

    public static /* synthetic */ void b(r1 r1Var) {
        r1Var.i();
    }

    public static boolean e(AudioManager audioManager, int i10) {
        if (com.google.android.exoplayer2.util.j0.f22990a >= 23) {
            return audioManager.isStreamMute(i10);
        }
        return f(audioManager, i10) == 0;
    }

    public static int f(AudioManager audioManager, int i10) {
        try {
            return audioManager.getStreamVolume(i10);
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder(60);
            sb2.append("Could not retrieve stream volume for stream type ");
            sb2.append(i10);
            com.google.android.exoplayer2.util.m.i("StreamVolumeManager", sb2.toString(), e2);
            return audioManager.getStreamMaxVolume(i10);
        }
    }

    public int c() {
        return this.f21124d.getStreamMaxVolume(this.f21126f);
    }

    public int d() {
        if (com.google.android.exoplayer2.util.j0.f22990a >= 28) {
            return this.f21124d.getStreamMinVolume(this.f21126f);
        }
        return 0;
    }

    public void g() {
        c cVar = this.f21125e;
        if (cVar != null) {
            try {
                this.f21121a.unregisterReceiver(cVar);
            } catch (RuntimeException e2) {
                com.google.android.exoplayer2.util.m.i("StreamVolumeManager", "Error unregistering stream volume receiver", e2);
            }
            this.f21125e = null;
        }
    }

    public void h(int i10) {
        if (this.f21126f == i10) {
            return;
        }
        this.f21126f = i10;
        i();
        this.f21123c.g(i10);
    }

    public final void i() {
        int f10 = f(this.f21124d, this.f21126f);
        boolean e2 = e(this.f21124d, this.f21126f);
        if (this.f21127g == f10 && this.f21128h == e2) {
            return;
        }
        this.f21127g = f10;
        this.f21128h = e2;
        this.f21123c.p(f10, e2);
    }
}
