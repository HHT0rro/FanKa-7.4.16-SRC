package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Runnable.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {

    @NotNull
    private final Continuation<p> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(@NotNull Continuation<? super p> continuation) {
        super(false);
        s.i(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            Continuation<p> continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m3565constructorimpl(p.f51048a));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
