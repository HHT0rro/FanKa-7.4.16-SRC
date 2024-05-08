package kotlin.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: Continuation.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Continuation<T> {
    @NotNull
    CoroutineContext getContext();

    void resumeWith(@NotNull Object obj);
}
