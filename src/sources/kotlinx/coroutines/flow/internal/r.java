package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.p1;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractSharedFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class r extends SharedFlowImpl<Integer> implements p1<Integer> {
    public r(int i10) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        k(Integer.valueOf(i10));
    }

    @Override // kotlinx.coroutines.flow.p1
    @NotNull
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(L().intValue());
        }
        return valueOf;
    }

    public final boolean Z(int i10) {
        boolean k10;
        synchronized (this) {
            k10 = k(Integer.valueOf(L().intValue() + i10));
        }
        return k10;
    }
}
