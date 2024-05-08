package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Collect.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class s {
    @Nullable
    public static final Object a(@NotNull c<?> cVar, @NotNull Continuation<? super kotlin.p> continuation) {
        Object a10 = cVar.a(kotlinx.coroutines.flow.internal.m.f51329b, continuation);
        return a10 == sd.a.d() ? a10 : kotlin.p.f51048a;
    }

    @Nullable
    public static final <T> Object b(@NotNull c<? extends T> cVar, @NotNull Function2<? super T, ? super Continuation<? super kotlin.p>, ? extends Object> function2, @NotNull Continuation<? super kotlin.p> continuation) {
        c b4;
        b4 = t.b(e.y(cVar, function2), 0, null, 2, null);
        Object f10 = e.f(b4, continuation);
        return f10 == sd.a.d() ? f10 : kotlin.p.f51048a;
    }

    @Nullable
    public static final <T> Object c(@NotNull d<? super T> dVar, @NotNull c<? extends T> cVar, @NotNull Continuation<? super kotlin.p> continuation) {
        e.n(dVar);
        Object a10 = cVar.a(dVar, continuation);
        return a10 == sd.a.d() ? a10 : kotlin.p.f51048a;
    }
}
