package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.Nullable;

/* compiled from: CompletionHandler.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class z extends LockFreeLinkedListNode implements Function1<Throwable, kotlin.p> {
    public abstract void P(@Nullable Throwable th);
}
