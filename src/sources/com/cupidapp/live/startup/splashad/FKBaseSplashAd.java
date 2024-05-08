package com.cupidapp.live.startup.splashad;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.c;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.view.b;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class FKBaseSplashAd implements DefaultLifecycleObserver {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f18467e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final int f18468b = 5;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public b f18469c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public WeakReference<FragmentActivity> f18470d;

    /* compiled from: FKBaseSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract int c();

    public final int d() {
        return this.f18468b;
    }

    @Nullable
    public final WeakReference<FragmentActivity> e() {
        return this.f18470d;
    }

    @Nullable
    public final b f() {
        return this.f18469c;
    }

    @NotNull
    public abstract FKAdType g();

    public final void h(@NotNull String msg) {
        s.i(msg, "msg");
        com.cupidapp.live.startup.helper.b.f18418a.a(((Object) g()) + " " + msg);
    }

    public final void i(@Nullable LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(this);
    }

    public abstract void j(@NotNull Function2<? super Boolean, ? super String, p> function2);

    public final void k(@Nullable b bVar) {
        this.f18469c = bVar;
    }

    public final void l(@Nullable WeakReference<FragmentActivity> weakReference) {
        this.f18470d = weakReference;
    }

    public abstract void m(@NotNull ViewGroup viewGroup);

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        c.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        c.f(this, lifecycleOwner);
    }
}
