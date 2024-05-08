package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.r;
import kotlinx.coroutines.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Produce.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l<E> extends f<E> implements m<E> {
    public l(@NotNull CoroutineContext coroutineContext, @NotNull e<E> eVar) {
        super(coroutineContext, eVar, true, true);
    }

    @Override // kotlinx.coroutines.a
    public void J0(@NotNull Throwable th, boolean z10) {
        if (N0().D(th) || z10) {
            return;
        }
        e0.a(getContext(), th);
    }

    @Override // kotlinx.coroutines.a
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public void K0(@NotNull kotlin.p pVar) {
        r.a.a(N0(), null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.m
    public /* bridge */ /* synthetic */ r getChannel() {
        return M0();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.u1, kotlinx.coroutines.n1
    public boolean isActive() {
        return super.isActive();
    }
}
