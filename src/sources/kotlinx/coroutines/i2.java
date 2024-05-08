package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: ThreadContextElement.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface i2<S> extends CoroutineContext.a {
    S F(@NotNull CoroutineContext coroutineContext);

    void f(@NotNull CoroutineContext coroutineContext, S s2);
}
