package androidx.core.util;

import androidx.annotation.RequiresApi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Consumer.kt */
@RequiresApi(24)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ConsumerKt {
    @RequiresApi(24)
    @NotNull
    public static final <T> java.util.function.Consumer<T> asConsumer(@NotNull Continuation<? super T> continuation) {
        s.i(continuation, "<this>");
        return new ContinuationConsumer(continuation);
    }
}
