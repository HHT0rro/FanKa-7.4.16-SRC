package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class s extends o1 implements r {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final t f51463f;

    public s(@NotNull t tVar) {
        this.f51463f = tVar;
    }

    @Override // kotlinx.coroutines.z
    public void P(@Nullable Throwable th) {
        this.f51463f.d(Q());
    }

    @Override // kotlinx.coroutines.r
    public boolean b(@NotNull Throwable th) {
        return Q().R(th);
    }

    @Override // kotlinx.coroutines.r
    @NotNull
    public n1 getParent() {
        return Q();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        P(th);
        return kotlin.p.f51048a;
    }
}
