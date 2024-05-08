package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlowExt.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FlowExtKt {
    @NotNull
    public static final <T> kotlinx.coroutines.flow.c<T> flowWithLifecycle(@NotNull kotlinx.coroutines.flow.c<? extends T> cVar, @NotNull Lifecycle lifecycle, @NotNull Lifecycle.State minActiveState) {
        s.i(cVar, "<this>");
        s.i(lifecycle, "lifecycle");
        s.i(minActiveState, "minActiveState");
        return kotlinx.coroutines.flow.e.d(new FlowExtKt$flowWithLifecycle$1(lifecycle, minActiveState, cVar, null));
    }

    public static /* synthetic */ kotlinx.coroutines.flow.c flowWithLifecycle$default(kotlinx.coroutines.flow.c cVar, Lifecycle lifecycle, Lifecycle.State state, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(cVar, lifecycle, state);
    }
}
