package com.tencent.liteav.audio.earmonitor;

import android.content.Context;
import android.provider.Settings;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h extends SystemAudioKit {

    /* renamed from: a, reason: collision with root package name */
    private boolean f42656a;

    /* renamed from: b, reason: collision with root package name */
    private int f42657b;

    public h(long j10) {
        super(j10);
        this.f42656a = false;
        this.f42657b = 0;
    }

    private boolean a() {
        try {
            Context applicationContext = ContextUtils.getApplicationContext();
            this.f42656a = applicationContext.getPackageManager().hasSystemFeature("com.samsung.feature.audio_listenback");
            this.f42657b = Settings.System.getInt(applicationContext.getContentResolver(), "headphone_monitoring", 0);
        } catch (Exception unused) {
            Log.w("SamsungSystemAudioKit", "get ktv info failed", new Object[0]);
        }
        return this.f42656a && this.f42657b == 1;
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void initialize() {
        if (!a()) {
            Log.w("SamsungSystemAudioKit", "initialize failed. mHasKtvFeature : " + this.f42656a + " mKtvEnabled : " + this.f42657b, new Object[0]);
            notifyEarMonitoringInitialized(this, false);
            return;
        }
        notifyEarMonitoringInitialized(this, true);
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void setEarMonitoringVolume(int i10) {
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void startEarMonitoring() {
        if (a()) {
            return;
        }
        notifySystemError(this);
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void stopEarMonitoring() {
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void terminate() {
    }
}
