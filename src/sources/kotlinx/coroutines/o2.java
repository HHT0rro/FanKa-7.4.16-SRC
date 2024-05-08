package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class o2 implements CoroutineContext.a, CoroutineContext.b<o2> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final o2 f51452b = new o2();

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, @NotNull Function2<? super R, ? super CoroutineContext.a, ? extends R> function2) {
        return (R) CoroutineContext.a.C0776a.a(this, r10, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.a> E get(@NotNull CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0776a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @NotNull
    public CoroutineContext.b<?> getKey() {
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0776a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0776a.d(this, coroutineContext);
    }
}
