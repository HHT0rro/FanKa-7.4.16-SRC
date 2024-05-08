package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Yield.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q2 {
    @Nullable
    public static final Object a(@NotNull Continuation<? super kotlin.p> continuation) {
        Object d10;
        CoroutineContext context = continuation.getContext();
        q1.g(context);
        Continuation c4 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        kotlinx.coroutines.internal.i iVar = c4 instanceof kotlinx.coroutines.internal.i ? (kotlinx.coroutines.internal.i) c4 : null;
        if (iVar == null) {
            d10 = kotlin.p.f51048a;
        } else {
            if (iVar.f51388e.isDispatchNeeded(context)) {
                iVar.j(context, kotlin.p.f51048a);
            } else {
                p2 p2Var = new p2();
                CoroutineContext plus = context.plus(p2Var);
                kotlin.p pVar = kotlin.p.f51048a;
                iVar.j(plus, pVar);
                if (p2Var.f51456b) {
                    d10 = kotlinx.coroutines.internal.j.d(iVar) ? sd.a.d() : pVar;
                }
            }
            d10 = sd.a.d();
        }
        if (d10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return d10 == sd.a.d() ? d10 : kotlin.p.f51048a;
    }
}
