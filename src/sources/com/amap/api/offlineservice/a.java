package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* compiled from: ServiceModule.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public OfflineMapActivity f8328a = null;

    public abstract void a(View view);

    public final void a(OfflineMapActivity offlineMapActivity) {
        this.f8328a = offlineMapActivity;
    }

    public abstract void b();

    public boolean c() {
        return true;
    }

    public abstract RelativeLayout d();

    public abstract void e();

    public final void a() {
        this.f8328a.showScr();
    }

    public final int a(float f10) {
        return this.f8328a != null ? (int) ((f10 * (r0.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f10;
    }
}
