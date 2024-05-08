package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q extends o1 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final m<?> f51457f;

    public q(@NotNull m<?> mVar) {
        this.f51457f = mVar;
    }

    @Override // kotlinx.coroutines.z
    public void P(@Nullable Throwable th) {
        m<?> mVar = this.f51457f;
        mVar.H(mVar.q(Q()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        P(th);
        return kotlin.p.f51048a;
    }
}
