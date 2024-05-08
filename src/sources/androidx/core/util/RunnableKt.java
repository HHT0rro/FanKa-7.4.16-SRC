package androidx.core.util;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Runnable.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RunnableKt {
    @NotNull
    public static final Runnable asRunnable(@NotNull Continuation<? super p> continuation) {
        s.i(continuation, "<this>");
        return new ContinuationRunnable(continuation);
    }
}
