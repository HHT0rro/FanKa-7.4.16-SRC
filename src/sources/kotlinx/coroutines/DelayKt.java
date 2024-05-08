package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DelayKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> r4) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L13
            r0 = r4
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = sd.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2d:
            kotlin.e.b(r4)
            goto L52
        L31:
            kotlin.e.b(r4)
            r0.label = r3
            kotlinx.coroutines.m r4 = new kotlinx.coroutines.m
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r0)
            r4.<init>(r2, r3)
            r4.y()
            java.lang.Object r4 = r4.r()
            java.lang.Object r2 = sd.a.d()
            if (r4 != r2) goto L4f
            td.f.c(r0)
        L4f:
            if (r4 != r1) goto L52
            return r1
        L52:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DelayKt.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final Object b(long j10, @NotNull Continuation<? super kotlin.p> continuation) {
        if (j10 <= 0) {
            return kotlin.p.f51048a;
        }
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.y();
        if (j10 < Long.MAX_VALUE) {
            c(mVar.getContext()).k(j10, mVar);
        }
        Object r10 = mVar.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10 == sd.a.d() ? r10 : kotlin.p.f51048a;
    }

    @NotNull
    public static final m0 c(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext.a aVar = coroutineContext.get(kotlin.coroutines.c.A0);
        m0 m0Var = aVar instanceof m0 ? (m0) aVar : null;
        return m0Var == null ? l0.a() : m0Var;
    }

    public static final long d(long j10) {
        if (de.a.f(j10, de.a.f48693c.a()) > 0) {
            return ce.n.c(de.a.m(j10), 1L);
        }
        return 0L;
    }
}
