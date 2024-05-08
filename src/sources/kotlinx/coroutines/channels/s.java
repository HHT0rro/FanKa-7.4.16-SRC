package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s<E> extends q {

    /* renamed from: e, reason: collision with root package name */
    public final E f51177e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final kotlinx.coroutines.l<kotlin.p> f51178f;

    /* JADX WARN: Multi-variable type inference failed */
    public s(E e2, @NotNull kotlinx.coroutines.l<? super kotlin.p> lVar) {
        this.f51177e = e2;
        this.f51178f = lVar;
    }

    @Override // kotlinx.coroutines.channels.q
    public void P() {
        this.f51178f.s(kotlinx.coroutines.n.f51447a);
    }

    @Override // kotlinx.coroutines.channels.q
    public E Q() {
        return this.f51177e;
    }

    @Override // kotlinx.coroutines.channels.q
    public void R(@NotNull i<?> iVar) {
        kotlinx.coroutines.l<kotlin.p> lVar = this.f51178f;
        Result.Companion companion = Result.Companion;
        lVar.resumeWith(Result.m3565constructorimpl(kotlin.e.a(iVar.X())));
    }

    @Override // kotlinx.coroutines.channels.q
    @Nullable
    public f0 S(@Nullable LockFreeLinkedListNode.c cVar) {
        if (this.f51178f.t(kotlin.p.f51048a, cVar != null ? cVar.f51360c : null) == null) {
            return null;
        }
        if (cVar != null) {
            cVar.d();
        }
        return kotlinx.coroutines.n.f51447a;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return j0.a(this) + '@' + j0.b(this) + '(' + ((Object) Q()) + ')';
    }
}
