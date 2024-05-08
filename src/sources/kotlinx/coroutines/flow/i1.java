package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i1<T> extends AbstractFlow<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function2<d<? super T>, Continuation<? super kotlin.p>, Object> f51298b;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(@NotNull Function2<? super d<? super T>, ? super Continuation<? super kotlin.p>, ? extends Object> function2) {
        this.f51298b = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    @Nullable
    public Object c(@NotNull d<? super T> dVar, @NotNull Continuation<? super kotlin.p> continuation) {
        Object mo1743invoke = this.f51298b.mo1743invoke(dVar, continuation);
        return mo1743invoke == sd.a.d() ? mo1743invoke : kotlin.p.f51048a;
    }
}
