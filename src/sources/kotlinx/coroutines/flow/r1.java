package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StateFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class r1 extends kotlinx.coroutines.flow.internal.c<StateFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51346a = AtomicReferenceFieldUpdater.newUpdater(r1.class, Object.class, "_state");

    @NotNull
    public volatile /* synthetic */ Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull StateFlowImpl<?> stateFlowImpl) {
        kotlinx.coroutines.internal.f0 f0Var;
        if (this._state != null) {
            return false;
        }
        f0Var = q1.f51344a;
        this._state = f0Var;
        return true;
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super kotlin.p> continuation) {
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.m mVar = new kotlinx.coroutines.m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.y();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51346a;
        f0Var = q1.f51344a;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, f0Var, mVar)) {
            Result.Companion companion = Result.Companion;
            mVar.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
        }
        Object r10 = mVar.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10 == sd.a.d() ? r10 : kotlin.p.f51048a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Continuation<kotlin.p>[] b(@NotNull StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return kotlinx.coroutines.flow.internal.b.f51324a;
    }

    public final void f() {
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        kotlinx.coroutines.internal.f0 f0Var3;
        kotlinx.coroutines.internal.f0 f0Var4;
        while (true) {
            Object obj = this._state;
            if (obj == null) {
                return;
            }
            f0Var = q1.f51345b;
            if (obj == f0Var) {
                return;
            }
            f0Var2 = q1.f51344a;
            if (obj == f0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51346a;
                f0Var3 = q1.f51345b;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, f0Var3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f51346a;
                f0Var4 = q1.f51344a;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, obj, f0Var4)) {
                    Result.Companion companion = Result.Companion;
                    ((kotlinx.coroutines.m) obj).resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
                    return;
                }
            }
        }
    }

    public final boolean g() {
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51346a;
        f0Var = q1.f51344a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, f0Var);
        kotlin.jvm.internal.s.f(andSet);
        f0Var2 = q1.f51345b;
        return andSet == f0Var2;
    }
}
