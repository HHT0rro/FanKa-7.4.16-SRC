package kotlinx.coroutines.flow.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: FlowExceptions.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j {
    public static final void a(@NotNull AbortFlowException abortFlowException, @NotNull kotlinx.coroutines.flow.d<?> dVar) {
        if (abortFlowException.owner != dVar) {
            throw abortFlowException;
        }
    }
}
