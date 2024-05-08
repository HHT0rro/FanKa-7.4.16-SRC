package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LifecycleDispatcher.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LifecycleDispatcher {

    @NotNull
    public static final LifecycleDispatcher INSTANCE = new LifecycleDispatcher();

    @NotNull
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    /* compiled from: LifecycleDispatcher.kt */
    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            s.i(activity, "activity");
            ReportFragment.Companion.injectIfNeededIn(activity);
        }
    }

    private LifecycleDispatcher() {
    }

    public static final void init(@NotNull Context context) {
        s.i(context, "context");
        if (initialized.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        s.g(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }
}
