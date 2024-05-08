package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.e;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: OutcomeReceiver.kt */
@RequiresApi(31)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {

    @NotNull
    private final Continuation<R> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(@NotNull Continuation<? super R> continuation) {
        super(false);
        s.i(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(@NotNull E error) {
        s.i(error, "error");
        if (compareAndSet(false, true)) {
            Continuation<R> continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m3565constructorimpl(e.a(error)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(@NotNull R result) {
        s.i(result, "result");
        if (compareAndSet(false, true)) {
            Continuation<R> continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m3565constructorimpl(result));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
