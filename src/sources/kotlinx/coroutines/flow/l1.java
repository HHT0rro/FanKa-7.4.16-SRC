package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SharedFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l1 extends kotlinx.coroutines.flow.internal.c<SharedFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name */
    public long f51337a = -1;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Continuation<? super kotlin.p> f51338b;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull SharedFlowImpl<?> sharedFlowImpl) {
        if (this.f51337a >= 0) {
            return false;
        }
        this.f51337a = sharedFlowImpl.X();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Continuation<kotlin.p>[] b(@NotNull SharedFlowImpl<?> sharedFlowImpl) {
        long j10 = this.f51337a;
        this.f51337a = -1L;
        this.f51338b = null;
        return sharedFlowImpl.W(j10);
    }
}
