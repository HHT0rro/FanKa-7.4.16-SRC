package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuationImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k1 extends j {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function1<Throwable, kotlin.p> f51430b;

    /* JADX WARN: Multi-variable type inference failed */
    public k1(@NotNull Function1<? super Throwable, kotlin.p> function1) {
        this.f51430b = function1;
    }

    @Override // kotlinx.coroutines.k
    public void a(@Nullable Throwable th) {
        this.f51430b.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        a(th);
        return kotlin.p.f51048a;
    }

    @NotNull
    public String toString() {
        return "InvokeOnCancel[" + j0.a(this.f51430b) + '@' + j0.b(this) + ']';
    }
}
