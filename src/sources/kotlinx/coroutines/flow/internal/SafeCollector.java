package kotlinx.coroutines.flow.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.q1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SafeCollector.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.d<T> {

    @NotNull
    public final CoroutineContext collectContext;
    public final int collectContextSize;

    @NotNull
    public final kotlinx.coroutines.flow.d<T> collector;

    @Nullable
    private Continuation<? super kotlin.p> completion;

    @Nullable
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@NotNull kotlinx.coroutines.flow.d<? super T> dVar, @NotNull CoroutineContext coroutineContext) {
        super(l.f51327b, EmptyCoroutineContext.INSTANCE);
        this.collector = dVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, new Function2<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            @NotNull
            public final Integer invoke(int i10, @NotNull CoroutineContext.a aVar) {
                return Integer.valueOf(i10 + 1);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Integer mo1743invoke(Integer num, CoroutineContext.a aVar) {
                return invoke(num.intValue(), aVar);
            }
        })).intValue();
    }

    private final void checkContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t2) {
        if (coroutineContext2 instanceof g) {
            exceptionTransparencyViolated((g) coroutineContext2, t2);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
    }

    private final void exceptionTransparencyViolated(g gVar, Object obj) {
        throw new IllegalStateException(StringsKt__IndentKt.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((Object) gVar.f51325b) + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlinx.coroutines.flow.d
    @Nullable
    public Object emit(T t2, @NotNull Continuation<? super kotlin.p> continuation) {
        try {
            Object emit = emit(continuation, (Continuation<? super kotlin.p>) t2);
            if (emit == sd.a.d()) {
                td.f.c(continuation);
            }
            return emit == sd.a.d() ? emit : kotlin.p.f51048a;
        } catch (Throwable th) {
            this.lastEmissionContext = new g(th, continuation.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, td.c
    @Nullable
    public td.c getCallerFrame() {
        Continuation<? super kotlin.p> continuation = this.completion;
        if (continuation instanceof td.c) {
            return (td.c) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        return coroutineContext == null ? EmptyCoroutineContext.INSTANCE : coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, td.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public Object invokeSuspend(@NotNull Object obj) {
        Throwable m3568exceptionOrNullimpl = Result.m3568exceptionOrNullimpl(obj);
        if (m3568exceptionOrNullimpl != null) {
            this.lastEmissionContext = new g(m3568exceptionOrNullimpl, getContext());
        }
        Continuation<? super kotlin.p> continuation = this.completion;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return sd.a.d();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(Continuation<? super kotlin.p> continuation, T t2) {
        CoroutineContext context = continuation.getContext();
        q1.g(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            checkContext(context, coroutineContext, t2);
            this.lastEmissionContext = context;
        }
        this.completion = continuation;
        Object invoke = SafeCollectorKt.a().invoke(this.collector, t2, this);
        if (!s.d(invoke, sd.a.d())) {
            this.completion = null;
        }
        return invoke;
    }
}
