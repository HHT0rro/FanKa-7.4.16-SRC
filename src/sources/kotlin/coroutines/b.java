package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class b<B extends CoroutineContext.a, E extends B> implements CoroutineContext.b<E> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function1<CoroutineContext.a, E> f50942b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final CoroutineContext.b<?> f50943c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$b<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$a, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$a, E extends B>, java.lang.Object] */
    public b(@NotNull CoroutineContext.b<B> baseKey, @NotNull Function1<? super CoroutineContext.a, ? extends E> safeCast) {
        s.i(baseKey, "baseKey");
        s.i(safeCast, "safeCast");
        this.f50942b = safeCast;
        this.f50943c = baseKey instanceof b ? (CoroutineContext.b<B>) ((b) baseKey).f50943c : baseKey;
    }

    public final boolean a(@NotNull CoroutineContext.b<?> key) {
        s.i(key, "key");
        return key == this || this.f50943c == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$a;)TE; */
    @Nullable
    public final CoroutineContext.a b(@NotNull CoroutineContext.a element) {
        s.i(element, "element");
        return (CoroutineContext.a) this.f50942b.invoke(element);
    }
}
