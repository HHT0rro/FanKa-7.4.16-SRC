package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlowCoroutine.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i {
    @Nullable
    public static final <R> Object a(@NotNull Function2<? super h0, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        h hVar = new h(continuation.getContext(), continuation);
        Object e2 = ee.b.e(hVar, hVar, function2);
        if (e2 == sd.a.d()) {
            td.f.c(continuation);
        }
        return e2;
    }
}
