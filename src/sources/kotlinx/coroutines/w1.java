package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: Builders.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class w1 extends f2 {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Continuation<kotlin.p> f51560d;

    public w1(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super h0, ? super Continuation<? super kotlin.p>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.f51560d = IntrinsicsKt__IntrinsicsJvmKt.b(function2, this, this);
    }

    @Override // kotlinx.coroutines.u1
    public void t0() {
        ee.a.b(this.f51560d, this);
    }
}
