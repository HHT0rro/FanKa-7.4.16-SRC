package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z10) {
        boolean c4 = c(coroutineContext);
        boolean c10 = c(coroutineContext2);
        if (!c4 && !c10) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new Function2<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final CoroutineContext mo1743invoke(@NotNull CoroutineContext coroutineContext4, @NotNull CoroutineContext.a aVar) {
                if (!(aVar instanceof b0)) {
                    return coroutineContext4.plus(aVar);
                }
                CoroutineContext.a aVar2 = ref$ObjectRef.element.get(aVar.getKey());
                if (aVar2 == null) {
                    b0 b0Var = (b0) aVar;
                    if (z10) {
                        b0Var = b0Var.j();
                    }
                    return coroutineContext4.plus(b0Var);
                }
                Ref$ObjectRef<CoroutineContext> ref$ObjectRef2 = ref$ObjectRef;
                ref$ObjectRef2.element = ref$ObjectRef2.element.minusKey(aVar.getKey());
                return coroutineContext4.plus(((b0) aVar).b(aVar2));
            }
        });
        if (c10) {
            ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).fold(emptyCoroutineContext, new Function2<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final CoroutineContext mo1743invoke(@NotNull CoroutineContext coroutineContext4, @NotNull CoroutineContext.a aVar) {
                    if (aVar instanceof b0) {
                        return coroutineContext4.plus(((b0) aVar).j());
                    }
                    return coroutineContext4.plus(aVar);
                }
            });
        }
        return coroutineContext3.plus((CoroutineContext) ref$ObjectRef.element);
    }

    @Nullable
    public static final String b(@NotNull CoroutineContext coroutineContext) {
        return null;
    }

    public static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, new Function2<Boolean, CoroutineContext.a, Boolean>() { // from class: kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1
            @NotNull
            public final Boolean invoke(boolean z10, @NotNull CoroutineContext.a aVar) {
                return Boolean.valueOf(z10 || (aVar instanceof b0));
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Boolean mo1743invoke(Boolean bool, CoroutineContext.a aVar) {
                return invoke(bool.booleanValue(), aVar);
            }
        })).booleanValue();
    }

    @NotNull
    public static final CoroutineContext d(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2) {
        return !c(coroutineContext2) ? coroutineContext.plus(coroutineContext2) : a(coroutineContext, coroutineContext2, false);
    }

    @NotNull
    public static final CoroutineContext e(@NotNull h0 h0Var, @NotNull CoroutineContext coroutineContext) {
        CoroutineContext a10 = a(h0Var.getCoroutineContext(), coroutineContext, true);
        return (a10 == r0.a() || a10.get(kotlin.coroutines.c.A0) != null) ? a10 : a10.plus(r0.a());
    }

    @Nullable
    public static final n2<?> f(@NotNull td.c cVar) {
        while (!(cVar instanceof n0) && (cVar = cVar.getCallerFrame()) != null) {
            if (cVar instanceof n2) {
                return (n2) cVar;
            }
        }
        return null;
    }

    @Nullable
    public static final n2<?> g(@NotNull Continuation<?> continuation, @NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (!(continuation instanceof td.c)) {
            return null;
        }
        if (!(coroutineContext.get(o2.f51452b) != null)) {
            return null;
        }
        n2<?> f10 = f((td.c) continuation);
        if (f10 != null) {
            f10.O0(coroutineContext, obj);
        }
        return f10;
    }
}
