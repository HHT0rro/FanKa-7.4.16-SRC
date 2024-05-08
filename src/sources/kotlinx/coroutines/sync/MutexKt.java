package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Mutex.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MutexKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f0 f51513a = new f0("LOCK_FAIL");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f0 f51514b = new f0("UNLOCK_FAIL");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f0 f51515c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final f0 f51516d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final b f51517e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final b f51518f;

    static {
        f0 f0Var = new f0("LOCKED");
        f51515c = f0Var;
        f0 f0Var2 = new f0("UNLOCKED");
        f51516d = f0Var2;
        f51517e = new b(f0Var);
        f51518f = new b(f0Var2);
    }

    @NotNull
    public static final c a(boolean z10) {
        return new MutexImpl(z10);
    }

    public static /* synthetic */ c b(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.c r4, @org.jetbrains.annotations.Nullable java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = sd.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$2
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.c r4 = (kotlinx.coroutines.sync.c) r4
            kotlin.e.b(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.e.b(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.a(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5c
            kotlin.jvm.internal.r.b(r3)
            r4.b(r5)
            kotlin.jvm.internal.r.a(r3)
            return r6
        L5c:
            r6 = move-exception
            kotlin.jvm.internal.r.b(r3)
            r4.b(r5)
            kotlin.jvm.internal.r.a(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.h(kotlinx.coroutines.sync.c, java.lang.Object, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
