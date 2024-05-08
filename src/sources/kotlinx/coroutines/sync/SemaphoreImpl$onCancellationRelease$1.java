package kotlinx.coroutines.sync;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Semaphore.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SemaphoreImpl$onCancellationRelease$1 extends Lambda implements Function1<Throwable, p> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SemaphoreImpl$onCancellationRelease$1(e eVar) {
        super(1);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
        invoke2(th);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Throwable th) {
        this.this$0.release();
    }
}
