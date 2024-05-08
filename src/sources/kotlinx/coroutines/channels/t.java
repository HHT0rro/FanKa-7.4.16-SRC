package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class t<E> extends s<E> {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Function1<E, kotlin.p> f51179g;

    /* JADX WARN: Multi-variable type inference failed */
    public t(E e2, @NotNull kotlinx.coroutines.l<? super kotlin.p> lVar, @NotNull Function1<? super E, kotlin.p> function1) {
        super(e2, lVar);
        this.f51179g = function1;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean K() {
        if (!super.K()) {
            return false;
        }
        T();
        return true;
    }

    @Override // kotlinx.coroutines.channels.q
    public void T() {
        OnUndeliveredElementKt.b(this.f51179g, Q(), this.f51178f.getContext());
    }
}
