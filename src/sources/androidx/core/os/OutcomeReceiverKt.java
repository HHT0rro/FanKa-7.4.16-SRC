package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: OutcomeReceiver.kt */
@RequiresApi(31)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    @NotNull
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(@NotNull Continuation<? super R> continuation) {
        s.i(continuation, "<this>");
        return new ContinuationOutcomeReceiver(continuation);
    }
}
