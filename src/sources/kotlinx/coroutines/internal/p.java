package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: LockFreeLinkedList.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p extends LockFreeLinkedListNode {
    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean J() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public /* bridge */ /* synthetic */ boolean K() {
        return ((Boolean) Q()).booleanValue();
    }

    public final boolean P() {
        return E() == this;
    }

    @NotNull
    public final Void Q() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
