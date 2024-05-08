package com.huawei.flexiblelayout.script;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.script.impl.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ScriptServiceManager {

    /* renamed from: d, reason: collision with root package name */
    private static final String f28445d = "ScriptServiceManager";

    /* renamed from: e, reason: collision with root package name */
    private static final String f28446e = "__service_hash__";

    /* renamed from: f, reason: collision with root package name */
    private static final ScriptServiceManager f28447f = new ScriptServiceManager();

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<IScriptService> f28448a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final Object f28449b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private ActivityLifecycleObserver f28450c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class ActivityLifecycleObserver implements Application.ActivityLifecycleCallbacks {
        private ActivityLifecycleObserver() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            if (activity.isFinishing()) {
                ScriptServiceManager.this.a(activity);
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
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    private ScriptServiceManager() {
    }

    @NonNull
    private IScriptService b(@NonNull Context context) {
        Activity a10 = a(context);
        IScriptService b4 = b(a10);
        if (b4 != null) {
            return b4;
        }
        c cVar = new c();
        a(cVar, a10);
        return cVar;
    }

    private void c(Context context) {
        if (this.f28450c == null) {
            this.f28450c = new ActivityLifecycleObserver();
            if (context instanceof Activity) {
                ((Activity) context).getApplication().registerActivityLifecycleCallbacks(this.f28450c);
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this.f28450c);
            } else {
                this.f28450c = null;
                Log.w(f28445d, "Failed to register ActivityLifecycleCallbacks");
            }
        }
    }

    public static ScriptServiceManager getInstance() {
        return f28447f;
    }

    @NonNull
    public IScriptService createService() {
        return new c();
    }

    private void a(@NonNull IScriptService iScriptService, @Nullable Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        int identityHashCode = System.identityHashCode(iScriptService);
        activity.getIntent().putExtra(f28446e, identityHashCode);
        synchronized (this.f28449b) {
            this.f28448a.put(identityHashCode, iScriptService);
        }
    }

    @NonNull
    public IScriptService createService(@NonNull Context context) {
        c(context);
        return b(context);
    }

    @Nullable
    private IScriptService b(@Nullable Activity activity) {
        IScriptService iScriptService;
        if (activity == null || activity.getIntent() == null) {
            return null;
        }
        int intExtra = activity.getIntent().getIntExtra(f28446e, 0);
        synchronized (this.f28449b) {
            iScriptService = this.f28448a.get(intExtra);
        }
        return iScriptService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Activity activity) {
        if (activity.getIntent() == null) {
            return;
        }
        int intExtra = activity.getIntent().getIntExtra(f28446e, 0);
        activity.getIntent().removeExtra(f28446e);
        synchronized (this.f28449b) {
            IScriptService iScriptService = this.f28448a.get(intExtra);
            if (iScriptService != null) {
                this.f28448a.delete(intExtra);
                iScriptService.close();
            }
        }
    }

    private static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
