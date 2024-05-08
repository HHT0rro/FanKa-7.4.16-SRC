package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlowExceptions.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class AbortFlowException extends CancellationException {

    @NotNull
    public final transient kotlinx.coroutines.flow.d<?> owner;

    public AbortFlowException(@NotNull kotlinx.coroutines.flow.d<?> dVar) {
        super("Flow was aborted, no more elements needed");
        this.owner = dVar;
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
