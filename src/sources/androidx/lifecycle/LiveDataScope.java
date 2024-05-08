package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.p;
import kotlinx.coroutines.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface LiveDataScope<T> {
    @Nullable
    Object emit(T t2, @NotNull Continuation<? super p> continuation);

    @Nullable
    Object emitSource(@NotNull LiveData<T> liveData, @NotNull Continuation<? super t0> continuation);

    @Nullable
    T getLatestValue();
}
