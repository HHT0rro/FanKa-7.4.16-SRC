package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SafeCollector.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SafeCollector_commonKt {
    public static final void a(@NotNull final SafeCollector<?> safeCollector, @NotNull CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new Function2<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Integer mo1743invoke(Integer num, CoroutineContext.a aVar) {
                return invoke(num.intValue(), aVar);
            }

            @NotNull
            public final Integer invoke(int i10, @NotNull CoroutineContext.a aVar) {
                CoroutineContext.b<?> key = aVar.getKey();
                CoroutineContext.a aVar2 = safeCollector.collectContext.get(key);
                if (key != n1.C0) {
                    return Integer.valueOf(aVar != aVar2 ? Integer.MIN_VALUE : i10 + 1);
                }
                n1 n1Var = (n1) aVar2;
                n1 b4 = SafeCollector_commonKt.b((n1) aVar, n1Var);
                if (b4 == n1Var) {
                    if (n1Var != null) {
                        i10++;
                    }
                    return Integer.valueOf(i10);
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + ((Object) b4) + ", expected child of " + ((Object) n1Var) + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + ((Object) safeCollector.collectContext) + ",\n\t\tbut emission happened in " + ((Object) coroutineContext) + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @Nullable
    public static final n1 b(@Nullable n1 n1Var, @Nullable n1 n1Var2) {
        while (n1Var != null) {
            if (n1Var == n1Var2 || !(n1Var instanceof b0)) {
                return n1Var;
            }
            n1Var = ((b0) n1Var).M0();
        }
        return null;
    }
}
