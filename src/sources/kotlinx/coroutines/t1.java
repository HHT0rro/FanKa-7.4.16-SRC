package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class t1 extends z implements t0, h1 {

    /* renamed from: e, reason: collision with root package name */
    public u1 f51536e;

    @NotNull
    public final u1 Q() {
        u1 u1Var = this.f51536e;
        if (u1Var != null) {
            return u1Var;
        }
        kotlin.jvm.internal.s.A("job");
        return null;
    }

    public final void R(@NotNull u1 u1Var) {
        this.f51536e = u1Var;
    }

    @Override // kotlinx.coroutines.h1
    @Nullable
    public y1 c() {
        return null;
    }

    @Override // kotlinx.coroutines.t0
    public void dispose() {
        Q().w0(this);
    }

    @Override // kotlinx.coroutines.h1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return j0.a(this) + '@' + j0.b(this) + "[job@" + j0.b(Q()) + ']';
    }
}
