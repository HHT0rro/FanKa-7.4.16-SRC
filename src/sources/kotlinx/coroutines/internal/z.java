package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: LockFreeLinkedList.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final LockFreeLinkedListNode f51425a;

    public z(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f51425a = lockFreeLinkedListNode;
    }

    @NotNull
    public String toString() {
        return "Removed[" + ((Object) this.f51425a) + ']';
    }
}
