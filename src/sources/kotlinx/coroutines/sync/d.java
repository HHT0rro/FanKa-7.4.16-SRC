package kotlinx.coroutines.sync;

import kotlin.coroutines.Continuation;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface d {
    @Nullable
    Object a(@NotNull Continuation<? super p> continuation);

    void release();
}
