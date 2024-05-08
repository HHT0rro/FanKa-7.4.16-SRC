package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.i0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Semaphore.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SemaphoreKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f51519a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f0 f51520b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f0 f51521c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final f0 f51522d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final f0 f51523e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f51524f;

    static {
        int d10;
        int d11;
        d10 = i0.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f51519a = d10;
        f51520b = new f0("PERMIT");
        f51521c = new f0("TAKEN");
        f51522d = new f0("BROKEN");
        f51523e = new f0("CANCELLED");
        d11 = i0.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f51524f = d11;
    }

    public static final f h(long j10, f fVar) {
        return new f(j10, fVar, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.d r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = sd.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.d r4 = (kotlinx.coroutines.sync.d) r4
            kotlin.e.b(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.e.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.a(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.r.b(r3)
            r4.release()
            kotlin.jvm.internal.r.a(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.r.b(r3)
            r4.release()
            kotlin.jvm.internal.r.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.i(kotlinx.coroutines.sync.d, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
