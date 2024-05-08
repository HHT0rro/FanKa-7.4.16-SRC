package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DefaultImpls {
        @NotNull
        public static CoroutineContext a(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext context) {
            s.i(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) context.fold(coroutineContext, new Function2<CoroutineContext, a, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final CoroutineContext mo1743invoke(@NotNull CoroutineContext acc, @NotNull CoroutineContext.a element) {
                    CombinedContext combinedContext;
                    s.i(acc, "acc");
                    s.i(element, "element");
                    CoroutineContext minusKey = acc.minusKey(element.getKey());
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                    if (minusKey == emptyCoroutineContext) {
                        return element;
                    }
                    c.b bVar = c.A0;
                    c cVar = (c) minusKey.get(bVar);
                    if (cVar == null) {
                        combinedContext = new CombinedContext(minusKey, element);
                    } else {
                        CoroutineContext minusKey2 = minusKey.minusKey(bVar);
                        if (minusKey2 == emptyCoroutineContext) {
                            return new CombinedContext(element, cVar);
                        }
                        combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), cVar);
                    }
                    return combinedContext;
                }
            });
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.CoroutineContext$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class C0776a {
            public static <R> R a(@NotNull a aVar, R r10, @NotNull Function2<? super R, ? super a, ? extends R> operation) {
                s.i(operation, "operation");
                return operation.mo1743invoke(r10, aVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            public static <E extends a> E b(@NotNull a aVar, @NotNull b<E> key) {
                s.i(key, "key");
                if (!s.d(aVar.getKey(), key)) {
                    return null;
                }
                s.g(aVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return aVar;
            }

            @NotNull
            public static CoroutineContext c(@NotNull a aVar, @NotNull b<?> key) {
                s.i(key, "key");
                return s.d(aVar.getKey(), key) ? EmptyCoroutineContext.INSTANCE : aVar;
            }

            @NotNull
            public static CoroutineContext d(@NotNull a aVar, @NotNull CoroutineContext context) {
                s.i(context, "context");
                return DefaultImpls.a(aVar, context);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        @Nullable
        <E extends a> E get(@NotNull b<E> bVar);

        @NotNull
        b<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface b<E extends a> {
    }

    <R> R fold(R r10, @NotNull Function2<? super R, ? super a, ? extends R> function2);

    @Nullable
    <E extends a> E get(@NotNull b<E> bVar);

    @NotNull
    CoroutineContext minusKey(@NotNull b<?> bVar);

    @NotNull
    CoroutineContext plus(@NotNull CoroutineContext coroutineContext);
}
