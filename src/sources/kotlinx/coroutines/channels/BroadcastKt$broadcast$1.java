package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Broadcast.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class BroadcastKt$broadcast$1 extends Lambda implements Function1<Throwable, kotlin.p> {
    public final /* synthetic */ ReceiveChannel<Object> $this_broadcast;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastKt$broadcast$1(ReceiveChannel<Object> receiveChannel) {
        super(1);
        this.$this_broadcast = receiveChannel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        invoke2(th);
        return kotlin.p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        h.b(this.$this_broadcast, th);
    }
}
