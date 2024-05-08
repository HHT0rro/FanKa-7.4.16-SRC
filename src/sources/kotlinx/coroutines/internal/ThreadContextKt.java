package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.i2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadContext.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ThreadContextKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f0 f51364a = new f0("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Function2<Object, CoroutineContext.a, Object> f51365b = new Function2<Object, CoroutineContext.a, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo1743invoke(@Nullable Object obj, @NotNull CoroutineContext.a aVar) {
            if (!(aVar instanceof i2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? aVar : Integer.valueOf(intValue + 1);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Function2<i2<?>, CoroutineContext.a, i2<?>> f51366c = new Function2<i2<?>, CoroutineContext.a, i2<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final i2<?> mo1743invoke(@Nullable i2<?> i2Var, @NotNull CoroutineContext.a aVar) {
            if (i2Var != null) {
                return i2Var;
            }
            if (aVar instanceof i2) {
                return (i2) aVar;
            }
            return null;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Function2<l0, CoroutineContext.a, l0> f51367d = new Function2<l0, CoroutineContext.a, l0>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final l0 mo1743invoke(@NotNull l0 l0Var, @NotNull CoroutineContext.a aVar) {
            if (aVar instanceof i2) {
                i2<?> i2Var = (i2) aVar;
                l0Var.a(i2Var, i2Var.F(l0Var.f51397a));
            }
            return l0Var;
        }
    };

    public static final void a(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == f51364a) {
            return;
        }
        if (obj instanceof l0) {
            ((l0) obj).b(coroutineContext);
            return;
        }
        Object fold = coroutineContext.fold(null, f51366c);
        Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((i2) fold).f(coroutineContext, obj);
    }

    @NotNull
    public static final Object b(@NotNull CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f51365b);
        kotlin.jvm.internal.s.f(fold);
        return fold;
    }

    @Nullable
    public static final Object c(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f51364a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new l0(coroutineContext, ((Number) obj).intValue()), f51367d);
        }
        return ((i2) obj).F(coroutineContext);
    }
}
