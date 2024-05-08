package com.cupidapp.live.base.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityLifecycleCallbacksImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final C0135a f11763c = new C0135a(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static WeakReference<Activity> f11764d;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final ArrayList<Activity> f11765b = new ArrayList<>();

    /* compiled from: ActivityLifecycleCallbacksImpl.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.base.activity.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0135a {
        public C0135a() {
        }

        public /* synthetic */ C0135a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final WeakReference<Activity> a() {
            return a.f11764d;
        }
    }

    public final void b() {
        Iterator<Activity> iterator2 = this.f11765b.iterator2();
        s.h(iterator2, "activityList.iterator()");
        while (iterator2.hasNext()) {
            iterator2.next().finish();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        s.i(activity, "activity");
        this.f11765b.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        s.i(activity, "activity");
        this.f11765b.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        s.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        s.i(activity, "activity");
        f11764d = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        s.i(activity, "activity");
        s.i(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        s.i(activity, "activity");
        f11764d = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        s.i(activity, "activity");
    }
}
