package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q<T> implements Continuation<T>, td.c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Continuation<T> f51334b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final CoroutineContext f51335c;

    /* JADX WARN: Multi-variable type inference failed */
    public q(@NotNull Continuation<? super T> continuation, @NotNull CoroutineContext coroutineContext) {
        this.f51334b = continuation;
        this.f51335c = coroutineContext;
    }

    @Override // td.c
    @Nullable
    public td.c getCallerFrame() {
        Continuation<T> continuation = this.f51334b;
        if (continuation instanceof td.c) {
            return (td.c) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.f51335c;
    }

    @Override // td.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        this.f51334b.resumeWith(obj);
    }
}
