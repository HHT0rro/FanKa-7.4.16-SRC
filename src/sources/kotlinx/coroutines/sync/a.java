package kotlinx.coroutines.sync;

import kotlin.p;
import kotlinx.coroutines.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a extends j {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final f f51525b;

    /* renamed from: c, reason: collision with root package name */
    public final int f51526c;

    public a(@NotNull f fVar, int i10) {
        this.f51525b = fVar;
        this.f51526c = i10;
    }

    @Override // kotlinx.coroutines.k
    public void a(@Nullable Throwable th) {
        this.f51525b.q(this.f51526c);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
        a(th);
        return p.f51048a;
    }

    @NotNull
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + ((Object) this.f51525b) + ", " + this.f51526c + ']';
    }
}
