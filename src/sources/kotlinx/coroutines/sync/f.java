package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f extends c0<f> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public /* synthetic */ AtomicReferenceArray f51535e;

    public f(long j10, @Nullable f fVar, int i10) {
        super(j10, fVar, i10);
        int i11;
        i11 = SemaphoreKt.f51524f;
        this.f51535e = new AtomicReferenceArray(i11);
    }

    @Override // kotlinx.coroutines.internal.c0
    public int n() {
        int i10;
        i10 = SemaphoreKt.f51524f;
        return i10;
    }

    public final void q(int i10) {
        f0 f0Var;
        f0Var = SemaphoreKt.f51523e;
        this.f51535e.set(i10, f0Var);
        o();
    }

    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + m() + ", hashCode=" + hashCode() + ']';
    }
}
