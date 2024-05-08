package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlowCollector.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface d<T> {
    @Nullable
    Object emit(T t2, @NotNull Continuation<? super kotlin.p> continuation);
}
