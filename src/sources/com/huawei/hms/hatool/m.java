package com.huawei.hms.hatool;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static m f30173b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f30174c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f30175a;

    private m() {
    }

    public static m a() {
        if (f30173b == null) {
            b();
        }
        return f30173b;
    }

    private static synchronized void b() {
        synchronized (m.class) {
            if (f30173b == null) {
                f30173b = new m();
            }
        }
    }

    public void a(Context context) {
        synchronized (f30174c) {
            if (this.f30175a != null) {
                v.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f30175a = context;
            s.c().b().a(this.f30175a);
            s.c().b().j(context.getPackageName());
            j.a().a(context);
        }
    }

    public void a(String str) {
        v.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f30175a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
        } else {
            s.c().b().i(e1.a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
