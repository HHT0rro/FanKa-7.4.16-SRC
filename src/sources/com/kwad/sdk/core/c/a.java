package com.kwad.sdk.core.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    private final List<WeakReference<Activity>> avb;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mEnable;
    private boolean mIsInBackground;
    private final List<c> mListeners;

    /* renamed from: com.kwad.sdk.core.c.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0517a {
        public static final a avc = new a(0);
    }

    public /* synthetic */ a(byte b4) {
        this();
    }

    public static a DB() {
        return C0517a.avc;
    }

    private boolean DC() {
        return b.DE() || !this.mEnable;
    }

    private void f(Activity activity) {
        Iterator<WeakReference<Activity>> iterator2 = this.avb.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().get() == activity) {
                return;
            }
        }
        this.avb.add(new WeakReference<>(activity));
    }

    private void g(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        Iterator<WeakReference<Activity>> iterator2 = this.avb.iterator2();
        while (iterator2.hasNext()) {
            WeakReference<Activity> next = iterator2.next();
            if (next != null && ((activity2 = next.get()) == activity || activity2 == null)) {
                iterator2.remove();
            }
        }
    }

    public final void a(c cVar) {
        this.mListeners.add(cVar);
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void init(@NonNull Context context) {
        try {
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public final boolean isEnable() {
        return this.mEnable;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.mEnable = true;
        if (DC()) {
            return;
        }
        try {
            Iterator<c> iterator2 = this.mListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(activity, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (DC()) {
            return;
        }
        try {
            Iterator<c> iterator2 = this.mListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().b(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (DC()) {
            return;
        }
        try {
            Iterator<c> iterator2 = this.mListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().c(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (DC()) {
            return;
        }
        try {
            this.currentActivity = new WeakReference<>(activity);
            Iterator<c> iterator2 = this.mListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().d(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (DC()) {
            return;
        }
        try {
            f(activity);
            if (this.avb.size() == 1) {
                this.mIsInBackground = false;
                Iterator<c> iterator2 = this.mListeners.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onBackToForeground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (DC()) {
            return;
        }
        try {
            g(activity);
            if (this.avb.size() == 0) {
                this.mIsInBackground = true;
                Iterator<c> iterator2 = this.mListeners.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onBackToBackground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a() {
        this.mIsInBackground = true;
        this.mListeners = new CopyOnWriteArrayList();
        this.avb = new ArrayList();
        this.mEnable = false;
    }
}
