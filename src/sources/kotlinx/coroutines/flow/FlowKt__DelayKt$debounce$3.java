package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Delay.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class FlowKt__DelayKt$debounce$3 extends Lambda implements Function1<Object, Long> {
    public final /* synthetic */ Function1<Object, de.a> $timeout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$3(Function1<Object, de.a> function1) {
        super(1);
        this.$timeout = function1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Long invoke(Object obj) {
        return Long.valueOf(DelayKt.d(this.$timeout.invoke(obj).D()));
    }
}
