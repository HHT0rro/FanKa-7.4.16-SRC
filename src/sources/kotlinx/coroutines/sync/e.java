package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import kotlinx.coroutines.l;
import kotlinx.coroutines.m;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e implements d {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51528c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "head");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f51529d = AtomicLongFieldUpdater.newUpdater(e.class, "deqIdx");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51530e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "tail");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f51531f = AtomicLongFieldUpdater.newUpdater(e.class, "enqIdx");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51532g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_availablePermits");

    @NotNull
    public volatile /* synthetic */ int _availablePermits;

    /* renamed from: a, reason: collision with root package name */
    public final int f51533a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function1<Throwable, p> f51534b;

    @NotNull
    private volatile /* synthetic */ long deqIdx;

    @NotNull
    private volatile /* synthetic */ long enqIdx;

    @NotNull
    private volatile /* synthetic */ Object head;

    @NotNull
    private volatile /* synthetic */ Object tail;

    @Override // kotlinx.coroutines.sync.d
    @Nullable
    public Object a(@NotNull Continuation<? super p> continuation) {
        if (f51532g.getAndDecrement(this) > 0) {
            return p.f51048a;
        }
        Object d10 = d(continuation);
        return d10 == sd.a.d() ? d10 : p.f51048a;
    }

    public final Object d(Continuation<? super p> continuation) {
        m b4 = o.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        while (true) {
            if (e(b4)) {
                break;
            }
            if (f51532g.getAndDecrement(this) > 0) {
                b4.h(p.f51048a, this.f51534b);
                break;
            }
        }
        Object r10 = b4.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10 == sd.a.d() ? r10 : p.f51048a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(kotlinx.coroutines.l<? super kotlin.p> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.Object r2 = r0.tail
            kotlinx.coroutines.sync.f r2 = (kotlinx.coroutines.sync.f) r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.sync.e.f51531f
            long r3 = r3.getAndIncrement(r0)
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.f()
            long r5 = (long) r5
            long r5 = r3 / r5
        L15:
            r7 = r2
        L16:
            long r8 = r7.m()
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 < 0) goto L2a
            boolean r8 = r7.g()
            if (r8 == 0) goto L25
            goto L2a
        L25:
            java.lang.Object r7 = kotlinx.coroutines.internal.d0.a(r7)
            goto L3c
        L2a:
            java.lang.Object r8 = kotlinx.coroutines.internal.g.a(r7)
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.internal.f.a()
            if (r8 != r9) goto Lb9
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.internal.f.a()
            java.lang.Object r7 = kotlinx.coroutines.internal.d0.a(r7)
        L3c:
            boolean r8 = kotlinx.coroutines.internal.d0.c(r7)
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L81
            kotlinx.coroutines.internal.c0 r8 = kotlinx.coroutines.internal.d0.b(r7)
        L48:
            java.lang.Object r11 = r0.tail
            kotlinx.coroutines.internal.c0 r11 = (kotlinx.coroutines.internal.c0) r11
            long r12 = r11.m()
            long r14 = r8.m()
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 < 0) goto L5a
        L58:
            r8 = 1
            goto L74
        L5a:
            boolean r12 = r8.p()
            if (r12 != 0) goto L62
            r8 = 0
            goto L74
        L62:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = kotlinx.coroutines.sync.e.f51530e
            boolean r12 = androidx.concurrent.futures.a.a(r12, r0, r11, r8)
            if (r12 == 0) goto L77
            boolean r8 = r11.l()
            if (r8 == 0) goto L58
            r11.j()
            goto L58
        L74:
            if (r8 == 0) goto L15
            goto L81
        L77:
            boolean r11 = r8.l()
            if (r11 == 0) goto L48
            r8.j()
            goto L48
        L81:
            kotlinx.coroutines.internal.c0 r2 = kotlinx.coroutines.internal.d0.b(r7)
            kotlinx.coroutines.sync.f r2 = (kotlinx.coroutines.sync.f) r2
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.f()
            long r5 = (long) r5
            long r3 = r3 % r5
            int r4 = (int) r3
            r3 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.f51535e
            boolean r3 = r5.compareAndSet(r4, r3, r1)
            if (r3 == 0) goto La0
            kotlinx.coroutines.sync.a r3 = new kotlinx.coroutines.sync.a
            r3.<init>(r2, r4)
            r1.v(r3)
            return r10
        La0:
            kotlinx.coroutines.internal.f0 r3 = kotlinx.coroutines.sync.SemaphoreKt.e()
            kotlinx.coroutines.internal.f0 r5 = kotlinx.coroutines.sync.SemaphoreKt.g()
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r2.f51535e
            boolean r2 = r2.compareAndSet(r4, r3, r5)
            if (r2 == 0) goto Lb8
            kotlin.p r2 = kotlin.p.f51048a
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.p> r3 = r0.f51534b
            r1.h(r2, r3)
            return r10
        Lb8:
            return r9
        Lb9:
            kotlinx.coroutines.internal.g r8 = (kotlinx.coroutines.internal.g) r8
            kotlinx.coroutines.internal.c0 r8 = (kotlinx.coroutines.internal.c0) r8
            if (r8 == 0) goto Lc2
        Lbf:
            r7 = r8
            goto L16
        Lc2:
            long r8 = r7.m()
            r10 = 1
            long r8 = r8 + r10
            r10 = r7
            kotlinx.coroutines.sync.f r10 = (kotlinx.coroutines.sync.f) r10
            kotlinx.coroutines.sync.f r8 = kotlinx.coroutines.sync.SemaphoreKt.a(r8, r10)
            boolean r9 = r7.k(r8)
            if (r9 == 0) goto L16
            boolean r9 = r7.g()
            if (r9 == 0) goto Lbf
            r7.j()
            goto Lbf
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.e.e(kotlinx.coroutines.l):boolean");
    }

    public final boolean f(l<? super p> lVar) {
        Object B = lVar.B(p.f51048a, null, this.f51534b);
        if (B == null) {
            return false;
        }
        lVar.s(B);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.e.g():boolean");
    }

    @Override // kotlinx.coroutines.sync.d
    public void release() {
        while (true) {
            int i10 = this._availablePermits;
            if (i10 < this.f51533a) {
                if (f51532g.compareAndSet(this, i10, i10 + 1) && (i10 >= 0 || g())) {
                    return;
                }
            } else {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f51533a).toString());
            }
        }
    }
}
