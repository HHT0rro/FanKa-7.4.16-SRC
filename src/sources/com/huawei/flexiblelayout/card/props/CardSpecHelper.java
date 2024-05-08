package com.huawei.flexiblelayout.card.props;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardSpecHelper {

    /* renamed from: a, reason: collision with root package name */
    private int f27872a;

    /* renamed from: b, reason: collision with root package name */
    private int f27873b;

    /* renamed from: c, reason: collision with root package name */
    private int f27874c;

    /* renamed from: d, reason: collision with root package name */
    private List<WeakReference<ScreenChangedObserver>> f27875d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f27876e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ScreenChangedObserver {
        void update();
    }

    public CardSpecHelper(Context context) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.huawei.flexiblelayout.card.props.CardSpecHelper.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                Configuration configuration = activity.getApplication().getResources().getConfiguration();
                CardSpecHelper.this.f27874c = configuration.screenWidthDp;
                CardSpecHelper.this.f27872a = configuration.orientation;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
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
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity) {
            }
        };
        this.f27876e = activityLifecycleCallbacks;
        this.f27873b = context.getResources().getDisplayMetrics().densityDpi;
        this.f27874c = context.getResources().getConfiguration().screenWidthDp;
        this.f27872a = context.getResources().getConfiguration().orientation;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        context.registerComponentCallbacks(new ComponentCallbacks() { // from class: com.huawei.flexiblelayout.card.props.CardSpecHelper.1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(@NonNull Configuration configuration) {
                CardSpecHelper.this.f27873b = configuration.densityDpi;
                CardSpecHelper.this.f27874c = configuration.screenWidthDp;
                CardSpecHelper.this.f27872a = configuration.orientation;
                Iterator iterator2 = CardSpecHelper.this.f27875d.iterator2();
                while (iterator2.hasNext()) {
                    ScreenChangedObserver screenChangedObserver = (ScreenChangedObserver) ((WeakReference) iterator2.next()).get();
                    if (screenChangedObserver != null) {
                        screenChangedObserver.update();
                    }
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        });
    }

    public int getCardNumbers(FLCardProps fLCardProps) {
        DirectionProps a10;
        if (fLCardProps == null || (a10 = fLCardProps.a(this.f27874c, this.f27873b)) == null) {
            return 1;
        }
        if (this.f27872a == 1) {
            return a10.getPortrait();
        }
        return a10.getLandscape();
    }

    public void registerScreenChanged(ScreenChangedObserver screenChangedObserver) {
        this.f27875d.add(new WeakReference<>(screenChangedObserver));
    }

    public void unregisterScreenChanged(ScreenChangedObserver screenChangedObserver) {
        ListIterator<WeakReference<ScreenChangedObserver>> listIterator = this.f27875d.listIterator();
        while (listIterator.hasNext()) {
            WeakReference<ScreenChangedObserver> next = listIterator.next();
            if (next.get() == screenChangedObserver) {
                listIterator.remove();
                return;
            } else if (next.get() == null) {
                listIterator.remove();
            }
        }
    }
}
