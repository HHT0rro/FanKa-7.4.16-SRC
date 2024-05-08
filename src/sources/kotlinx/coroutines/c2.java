package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c2 extends e {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final LockFreeLinkedListNode f51135b;

    public c2(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f51135b = lockFreeLinkedListNode;
    }

    @Override // kotlinx.coroutines.k
    public void a(@Nullable Throwable th) {
        this.f51135b.K();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        a(th);
        return kotlin.p.f51048a;
    }

    @NotNull
    public String toString() {
        return "RemoveOnCancel[" + ((Object) this.f51135b) + ']';
    }
}
