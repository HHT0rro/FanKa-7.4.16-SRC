package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Distinct.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DistinctFlowImpl<T> implements c<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final c<T> f51237b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Function1<T, Object> f51238c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Function2<Object, Object, Boolean> f51239d;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(@NotNull c<? extends T> cVar, @NotNull Function1<? super T, ? extends Object> function1, @NotNull Function2<Object, Object, Boolean> function2) {
        this.f51237b = cVar;
        this.f51238c = function1;
        this.f51239d = function2;
    }

    @Override // kotlinx.coroutines.flow.c
    @Nullable
    public Object a(@NotNull d<? super T> dVar, @NotNull Continuation<? super kotlin.p> continuation) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (T) kotlinx.coroutines.flow.internal.n.f51330a;
        Object a10 = this.f51237b.a(new DistinctFlowImpl$collect$2(this, ref$ObjectRef, dVar), continuation);
        return a10 == sd.a.d() ? a10 : kotlin.p.f51048a;
    }
}
