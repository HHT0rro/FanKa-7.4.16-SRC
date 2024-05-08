package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class q extends LockFreeLinkedListNode {
    public abstract void P();

    @Nullable
    public abstract Object Q();

    public abstract void R(@NotNull i<?> iVar);

    @Nullable
    public abstract f0 S(@Nullable LockFreeLinkedListNode.c cVar);

    public void T() {
    }
}
