package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class u2 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile u2 f48375b;

    /* renamed from: a, reason: collision with root package name */
    public Context f48376a;

    public u2(Context context) {
        this.f48376a = context;
    }

    public static u2 b(Context context) {
        if (f48375b == null) {
            synchronized (u2.class) {
                if (f48375b == null) {
                    f48375b = new u2(context);
                }
            }
        }
        return f48375b;
    }

    public final int a(int i10) {
        return Math.max(60, i10);
    }

    public void c() {
        n.c(this.f48376a).g(new v2(this));
    }

    public final void e(kc.j jVar, n nVar, boolean z10) {
        if (jVar.i(hv.UploadSwitch.a(), true)) {
            f3 f3Var = new f3(this.f48376a);
            if (z10) {
                nVar.k(f3Var, a(jVar.a(hv.UploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)));
            } else {
                nVar.j(f3Var);
            }
        }
    }

    public final boolean f() {
        try {
            Context context = this.f48376a;
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            ((Application) context).registerActivityLifecycleCallbacks(new k2(this.f48376a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e2) {
            fc.c.k(e2);
            return false;
        }
    }

    public final void g() {
        n c4 = n.c(this.f48376a);
        kc.j d10 = kc.j.d(this.f48376a);
        SharedPreferences sharedPreferences = this.f48376a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j10 == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j10) < bk.f9896e) {
            return;
        }
        e(d10, c4, false);
        if (d10.i(hv.StorageCollectionSwitch.a(), true)) {
            int a10 = a(d10.a(hv.StorageCollectionFrequency.a(), RemoteMessageConst.DEFAULT_TTL));
            c4.l(new d3(this.f48376a, a10), a10, 0);
        }
        boolean i10 = d10.i(hv.AppIsInstalledCollectionSwitch.a(), false);
        String c10 = d10.c(hv.AppIsInstalledList.a(), null);
        if (i10 && !TextUtils.isEmpty(c10)) {
            int a11 = a(d10.a(hv.AppIsInstalledCollectionFrequency.a(), RemoteMessageConst.DEFAULT_TTL));
            c4.l(new w2(this.f48376a, a11, c10), a11, 0);
        }
        if (d10.i(hv.LauncherAppListCollectionSwitch.a(), false)) {
            int a12 = a(d10.a(hv.LauncherAppListCollectionFrequency.a(), RemoteMessageConst.DEFAULT_TTL));
            c4.m(new x2(this.f48376a, a12), a12, 0, true);
        }
        boolean i11 = d10.i(hv.ScreenSizeCollectionSwitch.a(), true);
        boolean i12 = d10.i(hv.AndroidVnCollectionSwitch.a(), true);
        boolean i13 = d10.i(hv.AndroidVcCollectionSwitch.a(), true);
        boolean i14 = d10.i(hv.AndroidIdCollectionSwitch.a(), true);
        boolean i15 = d10.i(hv.OperatorSwitch.a(), true);
        if (i11 || i12 || i13 || i14 || i15) {
            int a13 = a(d10.a(hv.DeviceInfoCollectionFrequency.a(), 1209600));
            c4.l(new c3(this.f48376a, a13, i11, i12, i13, i14, i15), a13, 0);
        }
        boolean i16 = d10.i(hv.MacCollectionSwitch.a(), false);
        boolean i17 = d10.i(hv.IMSICollectionSwitch.a(), false);
        boolean i18 = d10.i(hv.IccidCollectionSwitch.a(), false);
        boolean i19 = d10.i(hv.DeviceIdSwitch.a(), false);
        if (i16 || i17 || i18 || i19) {
            int a14 = a(d10.a(hv.DeviceBaseInfoCollectionFrequency.a(), 1209600));
            c4.l(new b3(this.f48376a, a14, i16, i17, i18, i19), a14, 0);
        }
        if (d10.i(hv.TopAppCollectionSwitch.a(), false)) {
            int a15 = a(d10.a(hv.TopAppCollectionFrequency.a(), 300));
            c4.l(new e3(this.f48376a, a15), a15, 0);
        }
        if (d10.i(hv.BroadcastActionCollectionSwitch.a(), true)) {
            int a16 = a(d10.a(hv.BroadcastActionCollectionFrequency.a(), 900));
            c4.l(new z2(this.f48376a, a16), a16, 0);
        }
        if (d10.i(hv.ActivityTSSwitch.a(), false)) {
            f();
        }
        if (d10.i(hv.BatteryCollectionSwitch.a(), false)) {
            int a17 = a(d10.a(hv.BatteryCollectionFrequency.a(), SdkConfigData.DEFAULT_REQUEST_INTERVAL));
            c4.l(new y2(this.f48376a, a17), a17, 0);
        }
        e(d10, c4, true);
    }
}
