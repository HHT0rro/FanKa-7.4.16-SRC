package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class n<E> extends LockFreeLinkedListNode implements o<E> {
    @Override // kotlinx.coroutines.channels.o
    @NotNull
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public f0 a() {
        return a.f51155b;
    }

    @Nullable
    public Function1<Throwable, kotlin.p> Q(E e2) {
        return null;
    }

    public abstract void R(@NotNull i<?> iVar);
}
