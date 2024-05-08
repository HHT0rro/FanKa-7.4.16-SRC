package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Combine.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CombineKt {
    @Nullable
    public static final <R, T> Object a(@NotNull kotlinx.coroutines.flow.d<? super R> dVar, @NotNull kotlinx.coroutines.flow.c<? extends T>[] cVarArr, @NotNull Function0<T[]> function0, @NotNull Function3<? super kotlinx.coroutines.flow.d<? super R>, ? super T[], ? super Continuation<? super kotlin.p>, ? extends Object> function3, @NotNull Continuation<? super kotlin.p> continuation) {
        Object a10 = i.a(new CombineKt$combineInternal$2(cVarArr, function0, function3, dVar, null), continuation);
        return a10 == sd.a.d() ? a10 : kotlin.p.f51048a;
    }
}
