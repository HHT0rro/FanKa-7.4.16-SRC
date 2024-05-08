package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SafeCollector.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g implements CoroutineContext {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Throwable f51325b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f51326c;

    public g(@NotNull Throwable th, @NotNull CoroutineContext coroutineContext) {
        this.f51325b = th;
        this.f51326c = coroutineContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, @NotNull Function2<? super R, ? super CoroutineContext.a, ? extends R> function2) {
        return (R) this.f51326c.fold(r10, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.a> E get(@NotNull CoroutineContext.b<E> bVar) {
        return (E) this.f51326c.get(bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.b<?> bVar) {
        return this.f51326c.minusKey(bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return this.f51326c.plus(coroutineContext);
    }
}
