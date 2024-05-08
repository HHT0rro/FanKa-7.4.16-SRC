package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d {
    public static final /* synthetic */ kotlinx.coroutines.flow.d a(kotlinx.coroutines.flow.d dVar, CoroutineContext coroutineContext) {
        return d(dVar, coroutineContext);
    }

    @Nullable
    public static final <T, V> Object b(@NotNull CoroutineContext coroutineContext, V v2, @NotNull Object obj, @NotNull Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object c4 = ThreadContextKt.c(coroutineContext, obj);
        try {
            Object mo1743invoke = ((Function2) z.e(function2, 2)).mo1743invoke(v2, new q(continuation, coroutineContext));
            ThreadContextKt.a(coroutineContext, c4);
            if (mo1743invoke == sd.a.d()) {
                td.f.c(continuation);
            }
            return mo1743invoke;
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, c4);
            throw th;
        }
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return b(coroutineContext, obj, obj2, function2, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.d<T> d(kotlinx.coroutines.flow.d<? super T> dVar, CoroutineContext coroutineContext) {
        return dVar instanceof p ? true : dVar instanceof m ? dVar : new UndispatchedContextCollector(dVar, coroutineContext);
    }
}
