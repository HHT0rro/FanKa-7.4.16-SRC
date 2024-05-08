package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i<E> extends q implements o<E> {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final Throwable f51174e;

    public i(@Nullable Throwable th) {
        this.f51174e = th;
    }

    @Override // kotlinx.coroutines.channels.q
    public void P() {
    }

    @Override // kotlinx.coroutines.channels.q
    public void R(@NotNull i<?> iVar) {
    }

    @Override // kotlinx.coroutines.channels.q
    @NotNull
    public f0 S(@Nullable LockFreeLinkedListNode.c cVar) {
        f0 f0Var = kotlinx.coroutines.n.f51447a;
        if (cVar != null) {
            cVar.d();
        }
        return f0Var;
    }

    @Override // kotlinx.coroutines.channels.o
    @NotNull
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public i<E> a() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.q
    @NotNull
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public i<E> Q() {
        return this;
    }

    @NotNull
    public final Throwable W() {
        Throwable th = this.f51174e;
        return th == null ? new ClosedReceiveChannelException("Channel was closed") : th;
    }

    @NotNull
    public final Throwable X() {
        Throwable th = this.f51174e;
        return th == null ? new ClosedSendChannelException("Channel was closed") : th;
    }

    @Override // kotlinx.coroutines.channels.o
    public void e(E e2) {
    }

    @Override // kotlinx.coroutines.channels.o
    @NotNull
    public f0 i(E e2, @Nullable LockFreeLinkedListNode.c cVar) {
        f0 f0Var = kotlinx.coroutines.n.f51447a;
        if (cVar != null) {
            cVar.d();
        }
        return f0Var;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return "Closed@" + j0.b(this) + '[' + ((Object) this.f51174e) + ']';
    }
}
