package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Distinct.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class FlowKt__DistinctKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Function1<Object, Object> f51249a = new Function1<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Function2<Object, Object, Boolean> f51250b = new Function2<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: invoke */
        public final Boolean mo1743invoke(@Nullable Object obj, @Nullable Object obj2) {
            return Boolean.valueOf(kotlin.jvm.internal.s.d(obj, obj2));
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> c<T> a(@NotNull c<? extends T> cVar) {
        return cVar instanceof p1 ? cVar : b(cVar, f51249a, f51250b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> c<T> b(c<? extends T> cVar, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (cVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) cVar;
            if (distinctFlowImpl.f51238c == function1 && distinctFlowImpl.f51239d == function2) {
                return cVar;
            }
        }
        return new DistinctFlowImpl(cVar, function1, function2);
    }
}
