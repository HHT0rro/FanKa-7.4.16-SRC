package td;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: DebugProbes.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Continuation<T> a(@NotNull Continuation<? super T> completion) {
        s.i(completion, "completion");
        return completion;
    }

    public static final void b(@NotNull Continuation<?> frame) {
        s.i(frame, "frame");
    }

    public static final void c(@NotNull Continuation<?> frame) {
        s.i(frame, "frame");
    }
}
