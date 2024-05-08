package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class n2<T> extends kotlinx.coroutines.internal.b0<T> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public ThreadLocal<Pair<CoroutineContext, Object>> f51450e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public n2(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext r3, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.o2 r0 = kotlinx.coroutines.o2.f51452b
            kotlin.coroutines.CoroutineContext$a r1 = r3.get(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.CoroutineContext r0 = r3.plus(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f51450e = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.c$b r0 = kotlin.coroutines.c.A0
            kotlin.coroutines.CoroutineContext$a r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r4)
            r2.O0(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.n2.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):void");
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.a
    public void I0(@Nullable Object obj) {
        Pair<CoroutineContext, Object> pair = this.f51450e.get();
        if (pair != null) {
            ThreadContextKt.a(pair.component1(), pair.component2());
            this.f51450e.set(null);
        }
        Object a10 = a0.a(obj, this.f51372d);
        Continuation<T> continuation = this.f51372d;
        CoroutineContext context = continuation.getContext();
        Object c4 = ThreadContextKt.c(context, null);
        n2<?> g3 = c4 != ThreadContextKt.f51364a ? CoroutineContextKt.g(continuation, context, c4) : null;
        try {
            this.f51372d.resumeWith(a10);
            kotlin.p pVar = kotlin.p.f51048a;
        } finally {
            if (g3 == null || g3.N0()) {
                ThreadContextKt.a(context, c4);
            }
        }
    }

    public final boolean N0() {
        if (this.f51450e.get() == null) {
            return false;
        }
        this.f51450e.set(null);
        return true;
    }

    public final void O0(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        this.f51450e.set(kotlin.f.a(coroutineContext, obj));
    }
}
