package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Lifecycle.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class LifecycleCoroutineScope implements h0 {
    @Override // kotlinx.coroutines.h0
    @NotNull
    public abstract /* synthetic */ CoroutineContext getCoroutineContext();

    @NotNull
    public abstract Lifecycle getLifecycle$lifecycle_common();

    @NotNull
    public final n1 launchWhenCreated(@NotNull Function2<? super h0, ? super Continuation<? super p>, ? extends Object> block) {
        n1 b4;
        s.i(block, "block");
        b4 = kotlinx.coroutines.h.b(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, block, null), 3, null);
        return b4;
    }

    @NotNull
    public final n1 launchWhenResumed(@NotNull Function2<? super h0, ? super Continuation<? super p>, ? extends Object> block) {
        n1 b4;
        s.i(block, "block");
        b4 = kotlinx.coroutines.h.b(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, block, null), 3, null);
        return b4;
    }

    @NotNull
    public final n1 launchWhenStarted(@NotNull Function2<? super h0, ? super Continuation<? super p>, ? extends Object> block) {
        n1 b4;
        s.i(block, "block");
        b4 = kotlinx.coroutines.h.b(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, block, null), 3, null);
        return b4;
    }
}
