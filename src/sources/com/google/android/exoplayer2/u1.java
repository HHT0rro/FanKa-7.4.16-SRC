package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;

/* compiled from: WifiLockManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final WifiManager f22348a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public WifiManager.WifiLock f22349b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22350c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22351d;

    public u1(Context context) {
        this.f22348a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public void a(boolean z10) {
        if (z10 && this.f22349b == null) {
            WifiManager wifiManager = this.f22348a;
            if (wifiManager == null) {
                com.google.android.exoplayer2.util.m.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.f22349b = createWifiLock;
                createWifiLock.setReferenceCounted(false);
            }
        }
        this.f22350c = z10;
        c();
    }

    public void b(boolean z10) {
        this.f22351d = z10;
        c();
    }

    public final void c() {
        WifiManager.WifiLock wifiLock = this.f22349b;
        if (wifiLock == null) {
            return;
        }
        if (this.f22350c && this.f22351d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
