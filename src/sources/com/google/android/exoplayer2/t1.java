package com.google.android.exoplayer2;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* compiled from: WakeLockManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final PowerManager f22164a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public PowerManager.WakeLock f22165b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22166c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22167d;

    public t1(Context context) {
        this.f22164a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void a(boolean z10) {
        if (z10 && this.f22165b == null) {
            PowerManager powerManager = this.f22164a;
            if (powerManager == null) {
                com.google.android.exoplayer2.util.m.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.f22165b = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
        }
        this.f22166c = z10;
        c();
    }

    public void b(boolean z10) {
        this.f22167d = z10;
        c();
    }

    public final void c() {
        PowerManager.WakeLock wakeLock = this.f22165b;
        if (wakeLock == null) {
            return;
        }
        if (this.f22166c && this.f22167d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
