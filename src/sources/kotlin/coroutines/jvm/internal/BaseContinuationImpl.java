package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sd.a;
import td.c;
import td.e;
import td.f;

/* compiled from: ContinuationImpl.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseContinuationImpl implements Continuation<Object>, c, Serializable {

    @Nullable
    private final Continuation<Object> completion;

    public BaseContinuationImpl(@Nullable Continuation<Object> continuation) {
        this.completion = continuation;
    }

    @NotNull
    public Continuation<p> create(@NotNull Continuation<?> completion) {
        s.i(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // td.c
    @Nullable
    public c getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof c) {
            return (c) continuation;
        }
        return null;
    }

    @Nullable
    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public abstract /* synthetic */ CoroutineContext getContext();

    @Override // td.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return e.d(this);
    }

    @Nullable
    public abstract Object invokeSuspend(@NotNull Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(@NotNull Object obj) {
        Object invokeSuspend;
        Continuation continuation = this;
        while (true) {
            f.b(continuation);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) continuation;
            Continuation continuation2 = baseContinuationImpl.completion;
            s.f(continuation2);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.Companion companion = Result.Companion;
                obj = Result.m3565constructorimpl(kotlin.e.a(th));
            }
            if (invokeSuspend == a.d()) {
                return;
            }
            Result.Companion companion2 = Result.Companion;
            obj = Result.m3565constructorimpl(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (!(continuation2 instanceof BaseContinuationImpl)) {
                continuation2.resumeWith(obj);
                return;
            }
            continuation = continuation2;
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    @NotNull
    public Continuation<p> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        s.i(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
