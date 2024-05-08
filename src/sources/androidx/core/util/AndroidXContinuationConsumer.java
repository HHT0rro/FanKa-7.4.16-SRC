package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AndroidXConsumer.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {

    @NotNull
    private final Continuation<T> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidXContinuationConsumer(@NotNull Continuation<? super T> continuation) {
        super(false);
        s.i(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // androidx.core.util.Consumer
    public void accept(T t2) {
        if (compareAndSet(false, true)) {
            Continuation<T> continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m3565constructorimpl(t2));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
