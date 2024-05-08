package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    private static PowerManager.WakeLock f40637c;

    /* renamed from: a, reason: collision with root package name */
    public Handler f40638a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private int f40639b;

    /* renamed from: d, reason: collision with root package name */
    private PowerManager f40640d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<PowerManager.WakeLock> f40641a;

        private a() {
            this.f40641a = new WeakReference<>(e.f40637c);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f40641a.get() == null || !this.f40641a.get().isHeld()) {
                return;
            }
            this.f40641a.get().release();
        }
    }

    public e(int i10) {
        this.f40639b = 60000;
        this.f40639b = i10;
    }

    public void a() {
        PowerManager.WakeLock wakeLock = f40637c;
        if (wakeLock != null && wakeLock.isHeld()) {
            f40637c.release();
            f40637c = null;
        }
        if (this.f40640d != null) {
            this.f40640d = null;
        }
    }

    public void a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        this.f40640d = powerManager;
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "cameraFace");
            f40637c = newWakeLock;
            newWakeLock.acquire();
            this.f40638a.postDelayed(new a(), this.f40639b);
        }
    }
}
