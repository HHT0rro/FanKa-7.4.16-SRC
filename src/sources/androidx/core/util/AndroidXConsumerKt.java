package androidx.core.util;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AndroidXConsumer.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class AndroidXConsumerKt {
    @NotNull
    public static final <T> Consumer<T> asAndroidXConsumer(@NotNull Continuation<? super T> continuation) {
        s.i(continuation, "<this>");
        return new AndroidXContinuationConsumer(continuation);
    }
}
