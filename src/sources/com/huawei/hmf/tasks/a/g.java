package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class g extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<g>> f28881b = new WeakHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final List<WeakReference<ExecuteResult<?>>> f28882a = new ArrayList();

    private static g a(Activity activity) {
        g gVar;
        WeakHashMap<Activity, WeakReference<g>> weakHashMap = f28881b;
        WeakReference<g> weakReference = weakHashMap.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            g gVar2 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar2 == null) {
                try {
                    gVar = a(fragmentManager);
                } catch (ClassCastException e2) {
                    e = e2;
                    gVar = gVar2;
                    new StringBuilder("found LifecycleCallbackFragment but the type do not match. ").append(e.getMessage());
                    return gVar;
                }
            } else {
                gVar = gVar2;
            }
        } catch (ClassCastException e10) {
            e = e10;
            gVar = null;
        }
        try {
            weakHashMap.put(activity, new WeakReference<>(gVar));
        } catch (ClassCastException e11) {
            e = e11;
            new StringBuilder("found LifecycleCallbackFragment but the type do not match. ").append(e.getMessage());
            return gVar;
        }
        return gVar;
    }

    private static g a(FragmentManager fragmentManager) {
        g gVar = null;
        try {
            g gVar2 = new g();
            try {
                fragmentManager.beginTransaction().add(gVar2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                return gVar2;
            } catch (Exception e2) {
                e = e2;
                gVar = gVar2;
                new StringBuilder("create fragment failed.").append(e.getMessage());
                return gVar;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        g a10 = a(activity);
        if (a10 != null) {
            synchronized (a10.f28882a) {
                a10.f28882a.add(new WeakReference<>(executeResult));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.f28882a) {
            Iterator<WeakReference<ExecuteResult<?>>> iterator2 = this.f28882a.iterator2();
            while (iterator2.hasNext()) {
                ExecuteResult<?> executeResult = iterator2.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f28882a.clear();
        }
    }
}
