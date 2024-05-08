package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {

    @NotNull
    private final CoroutineContext coroutineContext;

    @NotNull
    private CoroutineLiveData<T> target;

    public LiveDataScopeImpl(@NotNull CoroutineLiveData<T> target, @NotNull CoroutineContext context) {
        s.i(target, "target");
        s.i(context, "context");
        this.target = target;
        this.coroutineContext = context.plus(r0.c().x());
    }

    @Override // androidx.lifecycle.LiveDataScope
    @Nullable
    public Object emit(T t2, @NotNull Continuation<? super p> continuation) {
        Object c4 = kotlinx.coroutines.g.c(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, t2, null), continuation);
        return c4 == sd.a.d() ? c4 : p.f51048a;
    }

    @Override // androidx.lifecycle.LiveDataScope
    @Nullable
    public Object emitSource(@NotNull LiveData<T> liveData, @NotNull Continuation<? super t0> continuation) {
        return kotlinx.coroutines.g.c(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, liveData, null), continuation);
    }

    @Override // androidx.lifecycle.LiveDataScope
    @Nullable
    public T getLatestValue() {
        return this.target.getValue();
    }

    @NotNull
    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(@NotNull CoroutineLiveData<T> coroutineLiveData) {
        s.i(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
