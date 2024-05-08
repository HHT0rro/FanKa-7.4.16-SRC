package com.tencent.liteav.base.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.Attributes;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static final t<Boolean> f42886a = new t<>(k.a());

    /* renamed from: b, reason: collision with root package name */
    private volatile WeakReference<Activity> f42887b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f42888c;

    /* renamed from: d, reason: collision with root package name */
    private final Set<Integer> f42889d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<Integer> f42890e;

    /* renamed from: f, reason: collision with root package name */
    private Rotation f42891f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final j f42892a = new j(0);
    }

    public /* synthetic */ j(byte b4) {
        this();
    }

    public static void a(boolean z10) {
        f42886a.a(Boolean.valueOf(z10));
    }

    private static Display f() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 32) {
            return null;
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e("ProcessLifecycleOwner", "context is null.", new Object[0]);
            return null;
        }
        try {
            return ((DisplayManager) applicationContext.getSystemService(Attributes.Style.DISPLAY)).getDisplay(0);
        } catch (Throwable th) {
            Log.e("ProcessLifecycleOwner", "Throwable on getDisplayByDisplayManager", th);
            return null;
        }
    }

    private synchronized Display g() {
        Context h10 = h();
        if (h10 == null) {
            h10 = ContextUtils.getApplicationContext();
        }
        if (h10 == null) {
            Log.e("ProcessLifecycleOwner", "context is null.", new Object[0]);
            return null;
        }
        try {
            return ((WindowManager) h10.getSystemService("window")).getDefaultDisplay();
        } catch (Throwable th) {
            Log.e("ProcessLifecycleOwner", "Throwable on getDefaultDisplayByWindowManager", th);
            return null;
        }
    }

    private Activity h() {
        WeakReference<Activity> weakReference = this.f42887b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final synchronized boolean b() {
        return this.f42888c;
    }

    @NonNull
    public final synchronized Rotation c() {
        Rotation rotation = this.f42891f;
        if (rotation != null) {
            return rotation;
        }
        try {
            Display d10 = d();
            if (d10 != null) {
                int rotation2 = d10.getRotation();
                if (rotation2 == 1) {
                    return Rotation.ROTATION_90;
                }
                if (rotation2 == 2) {
                    return Rotation.ROTATION_180;
                }
                if (rotation2 != 3) {
                    return Rotation.NORMAL;
                }
                return Rotation.ROTATION_270;
            }
        } catch (Exception e2) {
            LiteavLog.e("ProcessLifecycleOwner", "get display rotation failed.", e2);
        }
        return Rotation.NORMAL;
    }

    public final Display d() {
        Display f10 = f();
        return f10 != null ? f10 : g();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityDestroyed(@NonNull Activity activity) {
        Log.i("ProcessLifecycleOwner", "onActivityDestroyed, activity=".concat(String.valueOf(activity)), new Object[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityPaused(@NonNull Activity activity) {
        this.f42890e.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityResumed(@NonNull Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStarted(@NonNull Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStopped(@NonNull Activity activity) {
        int hashCode = activity.hashCode();
        boolean z10 = true;
        if (this.f42889d.contains(Integer.valueOf(hashCode))) {
            this.f42889d.remove(Integer.valueOf(hashCode));
            if (this.f42889d.size() != 0) {
                z10 = false;
            }
            this.f42888c = z10;
        } else if (this.f42889d.size() == 0) {
            if (this.f42890e.contains(Integer.valueOf(hashCode))) {
                this.f42888c = true;
            }
        } else {
            this.f42888c = false;
        }
        this.f42890e.remove(Integer.valueOf(hashCode));
    }

    private j() {
        this.f42887b = null;
        this.f42889d = new HashSet();
        this.f42890e = new HashSet();
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e("ProcessLifecycleOwner", "ProcessStateOwner init failed. Context is null", new Object[0]);
        } else {
            ((Application) applicationContext.getApplicationContext()).registerActivityLifecycleCallbacks(this);
            this.f42888c = f42886a.a().booleanValue();
        }
    }

    public static j a() {
        return a.f42892a;
    }

    private void b(@NonNull Activity activity) {
        this.f42889d.add(Integer.valueOf(activity.hashCode()));
        this.f42887b = new WeakReference<>(activity);
        this.f42888c = false;
        Log.i("ProcessLifecycleOwner", "update activity to ".concat(String.valueOf(activity)), new Object[0]);
    }

    public final synchronized void a(Activity activity) {
        if (activity == null) {
            return;
        }
        if (h() != null) {
            Log.i("ProcessLifecycleOwner", "activity is exists, don't need activity from user", new Object[0]);
            return;
        }
        this.f42887b = new WeakReference<>(activity);
        Log.i("ProcessLifecycleOwner", "update activity to " + ((Object) activity) + " from user", new Object[0]);
    }

    public final synchronized void a(Rotation rotation) {
        this.f42891f = rotation;
        LiteavLog.i("ProcessLifecycleOwner", "set display rotation from user: " + ((Object) this.f42891f));
    }

    private static boolean a(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                Log.e("ProcessLifecycleOwner", "activityManager is null.", new Object[0]);
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                Log.e("ProcessLifecycleOwner", "processInfoList is null.", new Object[0]);
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && context.getPackageName().equals(runningAppProcessInfo.processName)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            Log.e("ProcessLifecycleOwner", "Get App background state failed. ".concat(String.valueOf(e2)), new Object[0]);
            return false;
        }
    }
}
