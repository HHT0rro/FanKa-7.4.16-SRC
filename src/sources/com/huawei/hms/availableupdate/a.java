package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AppSpoofResolveMgr.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f29603c = new a();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f29604d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f29605a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final List<Activity> f29606b = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f29604d) {
            for (Activity activity2 : this.f29606b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f29606b.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f29604d) {
            this.f29606b.remove(activity);
        }
    }

    public void a(boolean z10) {
        this.f29605a.set(z10);
    }

    public AtomicBoolean a() {
        return this.f29605a;
    }
}
