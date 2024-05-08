package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RepeatOnLifecycle.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RepeatOnLifecycleKt {
    @Nullable
    public static final Object repeatOnLifecycle(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function2<? super h0, ? super Continuation<? super p>, ? extends Object> function2, @NotNull Continuation<? super p> continuation) {
        if (state != Lifecycle.State.INITIALIZED) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                return p.f51048a;
            }
            Object b4 = i0.b(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, function2, null), continuation);
            return b4 == sd.a.d() ? b4 : p.f51048a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    }

    @Nullable
    public static final Object repeatOnLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull Function2<? super h0, ? super Continuation<? super p>, ? extends Object> function2, @NotNull Continuation<? super p> continuation) {
        Object repeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, function2, continuation);
        return repeatOnLifecycle == sd.a.d() ? repeatOnLifecycle : p.f51048a;
    }
}
