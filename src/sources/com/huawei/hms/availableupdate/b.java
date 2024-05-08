package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotInstalledHmsResolveMgr.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f29607b = new b();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f29608c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final List<Activity> f29609a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f29608c) {
            for (Activity activity2 : this.f29609a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f29609a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f29608c) {
            this.f29609a.remove(activity);
        }
    }
}
