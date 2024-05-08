package com.huawei.quickcard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import com.huawei.quickcard.activitymanager.IConfigurationCallback;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h1 implements ComponentCallbacks {

    /* renamed from: c, reason: collision with root package name */
    private static final String f34010c = "QuickCardActivityMgr";

    /* renamed from: d, reason: collision with root package name */
    public static final h1 f34011d = new h1();

    /* renamed from: a, reason: collision with root package name */
    private Application f34012a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, IConfigurationCallback> f34013b = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements IConfigurationCallback {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QuickCardView> f34014a;

        public a(QuickCardView quickCardView) {
            this.f34014a = new WeakReference<>(quickCardView);
        }

        @Override // com.huawei.quickcard.activitymanager.IConfigurationCallback
        public void onActivityConfigurationChanged(@NonNull Configuration configuration) {
            QuickCardView quickCardView = this.f34014a.get();
            if (quickCardView != null) {
                quickCardView.onActivityConfigurationChanged(configuration);
            }
        }
    }

    private h1() {
    }

    public boolean a(Context context) {
        CardLogUtils.d(f34010c, "init");
        if (context == null) {
            CardLogUtils.d(f34010c, "init fail: context is null");
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            return a((Application) applicationContext);
        }
        return false;
    }

    public void b() {
        CardLogUtils.d(f34010c, "release");
        Application application = this.f34012a;
        if (application != null) {
            application.unregisterComponentCallbacks(this);
        }
        a();
        this.f34012a = null;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        CardLogUtils.d(f34010c, "onConfigurationChanged");
        Iterator<Map.Entry<Integer, IConfigurationCallback>> iterator2 = this.f34013b.entrySet().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().getValue().onActivityConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public boolean a(Activity activity) {
        CardLogUtils.d(f34010c, "init");
        if (activity == null) {
            CardLogUtils.d(f34010c, "init fail: activity is null");
            return false;
        }
        return a(activity.getApplication());
    }

    public void b(@NonNull QuickCardView quickCardView) {
        this.f34013b.remove(Integer.valueOf(quickCardView.hashCode()));
    }

    public boolean a(Application application) {
        if (application == null) {
            CardLogUtils.d(f34010c, "init fail: app is null");
            return false;
        }
        CardLogUtils.d(f34010c, "register callbacks");
        Application application2 = this.f34012a;
        if (application2 != null) {
            application2.unregisterComponentCallbacks(this);
        }
        this.f34012a = application;
        application.registerComponentCallbacks(this);
        return true;
    }

    public void a(@NonNull QuickCardView quickCardView) {
        int hashCode = quickCardView.hashCode();
        if (this.f34013b.containsKey(Integer.valueOf(hashCode))) {
            return;
        }
        this.f34013b.put(Integer.valueOf(hashCode), new a(quickCardView));
    }

    public void a() {
        CardLogUtils.d(f34010c, "clearConfigurationCallback");
        this.f34013b.clear();
    }
}
