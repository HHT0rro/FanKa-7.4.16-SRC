package td;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContinuationImpl.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b implements Continuation<Object> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f53808b = new b();

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @NotNull
    public String toString() {
        return "This continuation is already complete";
    }
}
