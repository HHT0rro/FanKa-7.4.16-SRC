package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class BindingFailedResolveMgr {

    /* renamed from: b, reason: collision with root package name */
    public static final BindingFailedResolveMgr f29552b = new BindingFailedResolveMgr();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f29553c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public List<Activity> f29554a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f29553c) {
            for (Activity activity2 : this.f29554a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f29554a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f29553c) {
            this.f29554a.remove(activity);
        }
    }
}
