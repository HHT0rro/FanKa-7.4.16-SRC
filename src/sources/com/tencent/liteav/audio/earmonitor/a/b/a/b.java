package com.tencent.liteav.audio.earmonitor.a.b.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f42617b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f42618c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f42619d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static final Object f42620e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static b f42621f;

    /* renamed from: a, reason: collision with root package name */
    public e f42622a = null;

    public static b a() {
        b bVar;
        synchronized (f42618c) {
            if (f42621f == null) {
                f42621f = new b();
            }
            bVar = f42621f;
        }
        return bVar;
    }

    public static <T extends a> T a(int i10, Context context) {
        if (context == null || i10 != 1) {
            return null;
        }
        c cVar = new c(context);
        cVar.a(context);
        return cVar;
    }

    public static void a(Context context, ServiceConnection serviceConnection, String str) {
        synchronized (f42619d) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.huawei.multimedia.audioengine", str);
            try {
                context.bindService(intent, serviceConnection, 1);
            } catch (SecurityException e2) {
                LiteavLog.e("HwAudioKit.FeatureKitManager", "bindService, SecurityException, %s", e2.getMessage());
            }
        }
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        synchronized (f42620e) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return true;
        }
        try {
            return packageManager.getPackageInfo("com.huawei.multimedia.audioengine", 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            LiteavLog.e("HwAudioKit.FeatureKitManager", "isAudioKitSupport ,NameNotFoundException");
            return false;
        }
    }

    public final void a(int i10) {
        synchronized (f42617b) {
            e eVar = this.f42622a;
            if (eVar != null) {
                eVar.a(i10);
            }
        }
    }
}
