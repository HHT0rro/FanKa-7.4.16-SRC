package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;

/* compiled from: Delay.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class FlowKt__DelayKt {
    @NotNull
    public static final ReceiveChannel<kotlin.p> a(@NotNull kotlinx.coroutines.h0 h0Var, long j10, long j11) {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j10 + " ms").toString());
        }
        if (j11 >= 0) {
            return ProduceKt.d(h0Var, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j11, j10, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j11 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel b(kotlinx.coroutines.h0 h0Var, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = j10;
        }
        return e.s(h0Var, j10, j11);
    }
}
