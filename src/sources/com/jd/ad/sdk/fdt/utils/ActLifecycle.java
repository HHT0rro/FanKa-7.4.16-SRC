package com.jd.ad.sdk.fdt.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ActLifecycle implements Application.ActivityLifecycleCallbacks {
    public static final CopyOnWriteArrayList<jad_an> jad_bo = new CopyOnWriteArrayList<>();
    public static final CopyOnWriteArrayList<OnLifecycleChangeListener> jad_cp = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<WeakReference<Activity>> jad_an = new CopyOnWriteArrayList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface OnLifecycleChangeListener {
        void onActivityDestroyed(@NonNull Activity activity);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface jad_an {
        void jad_an();

        void jad_bo();
    }

    public static void addLifecycleListener(OnLifecycleChangeListener onLifecycleChangeListener) {
        if (onLifecycleChangeListener == null) {
            return;
        }
        jad_cp.add(onLifecycleChangeListener);
    }

    public static void removeLifecycleListener(OnLifecycleChangeListener onLifecycleChangeListener) {
        if (onLifecycleChangeListener == null) {
            return;
        }
        jad_cp.remove(onLifecycleChangeListener);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        CopyOnWriteArrayList<OnLifecycleChangeListener> copyOnWriteArrayList = jad_cp;
        if (copyOnWriteArrayList.size() > 0) {
            Iterator<OnLifecycleChangeListener> iterator2 = copyOnWriteArrayList.iterator2();
            while (iterator2.hasNext()) {
                OnLifecycleChangeListener next = iterator2.next();
                if (next != null) {
                    next.onActivityDestroyed(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if (this.jad_an.size() == 0) {
            CopyOnWriteArrayList<jad_an> copyOnWriteArrayList = jad_bo;
            if (copyOnWriteArrayList.size() > 0) {
                Iterator<jad_an> iterator2 = copyOnWriteArrayList.iterator2();
                while (iterator2.hasNext()) {
                    jad_an next = iterator2.next();
                    if (next != null) {
                        next.jad_an();
                    }
                }
            }
        }
        if (activity == null) {
            return;
        }
        this.jad_an.add(new WeakReference<>(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        if (this.jad_an.size() > 0) {
            Iterator<WeakReference<Activity>> iterator2 = this.jad_an.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = iterator2.next();
                if (next.get() == activity) {
                    this.jad_an.remove(next);
                    break;
                }
            }
        }
        if (this.jad_an.size() == 0) {
            CopyOnWriteArrayList<jad_an> copyOnWriteArrayList = jad_bo;
            if (copyOnWriteArrayList.size() > 0) {
                Iterator<jad_an> iterator22 = copyOnWriteArrayList.iterator2();
                while (iterator22.hasNext()) {
                    jad_an next2 = iterator22.next();
                    if (next2 != null) {
                        next2.jad_bo();
                    }
                }
            }
        }
    }
}
