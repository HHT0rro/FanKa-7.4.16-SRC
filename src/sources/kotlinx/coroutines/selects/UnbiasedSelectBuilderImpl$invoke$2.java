package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

/* compiled from: SelectUnbiased.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class UnbiasedSelectBuilderImpl$invoke$2 extends Lambda implements Function0<p> {
    public final /* synthetic */ Function2<Object, Continuation<Object>, Object> $block;
    public final /* synthetic */ d<Object> $this_invoke;
    public final /* synthetic */ i<Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnbiasedSelectBuilderImpl$invoke$2(d<Object> dVar, i<Object> iVar, Function2<Object, ? super Continuation<Object>, ? extends Object> function2) {
        super(0);
        this.$this_invoke = dVar;
        this.$block = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ p invoke() {
        invoke2();
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        throw null;
    }
}
