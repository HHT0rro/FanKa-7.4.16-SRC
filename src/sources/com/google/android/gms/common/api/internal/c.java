package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: f, reason: collision with root package name */
    public static final c f23417f = new c();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f23418b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f23419c = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f23420d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f23421e = false;

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(@RecentlyNonNull boolean z10);
    }

    @RecentlyNonNull
    public static c b() {
        return f23417f;
    }

    public static void c(@RecentlyNonNull Application application) {
        c cVar = f23417f;
        synchronized (cVar) {
            if (!cVar.f23421e) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f23421e = true;
            }
        }
    }

    public final void a(@RecentlyNonNull a aVar) {
        synchronized (f23417f) {
            this.f23420d.add(aVar);
        }
    }

    @RecentlyNonNull
    public final boolean d() {
        return this.f23418b.get();
    }

    @RecentlyNonNull
    public final boolean e(@RecentlyNonNull boolean z10) {
        if (!this.f23419c.get()) {
            if (!b7.k.b()) {
                return z10;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f23419c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f23418b.set(true);
            }
        }
        return d();
    }

    public final void f(boolean z10) {
        synchronized (f23417f) {
            ArrayList<a> arrayList = this.f23420d;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                a aVar = arrayList.get(i10);
                i10++;
                aVar.a(z10);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@RecentlyNonNull Activity activity, @Nullable Bundle bundle) {
        boolean compareAndSet = this.f23418b.compareAndSet(true, false);
        this.f23419c.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@RecentlyNonNull Activity activity) {
        boolean compareAndSet = this.f23418b.compareAndSet(true, false);
        this.f23419c.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@RecentlyNonNull Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(@RecentlyNonNull int i10) {
        if (i10 == 20 && this.f23418b.compareAndSet(false, true)) {
            this.f23419c.set(true);
            f(true);
        }
    }
}
