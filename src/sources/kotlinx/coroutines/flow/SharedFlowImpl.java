package kotlinx.coroutines.flow;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SharedFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<l1> implements f1<T>, c, kotlinx.coroutines.flow.internal.k<T> {

    /* renamed from: f, reason: collision with root package name */
    public final int f51277f;

    /* renamed from: g, reason: collision with root package name */
    public final int f51278g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final BufferOverflow f51279h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public Object[] f51280i;

    /* renamed from: j, reason: collision with root package name */
    public long f51281j;

    /* renamed from: k, reason: collision with root package name */
    public long f51282k;

    /* renamed from: l, reason: collision with root package name */
    public int f51283l;

    /* renamed from: m, reason: collision with root package name */
    public int f51284m;

    /* compiled from: SharedFlow.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements kotlinx.coroutines.t0 {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final SharedFlowImpl<?> f51285b;

        /* renamed from: c, reason: collision with root package name */
        public long f51286c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final Object f51287d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public final Continuation<kotlin.p> f51288e;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull SharedFlowImpl<?> sharedFlowImpl, long j10, @Nullable Object obj, @NotNull Continuation<? super kotlin.p> continuation) {
            this.f51285b = sharedFlowImpl;
            this.f51286c = j10;
            this.f51287d = obj;
            this.f51288e = continuation;
        }

        @Override // kotlinx.coroutines.t0
        public void dispose() {
            this.f51285b.y(this);
        }
    }

    /* compiled from: SharedFlow.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51289a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f51289a = iArr;
        }
    }

    public SharedFlowImpl(int i10, int i11, @NotNull BufferOverflow bufferOverflow) {
        this.f51277f = i10;
        this.f51278g = i11;
        this.f51279h = bufferOverflow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(3:(6:(1:(1:11)(2:41|42))(1:43)|12|13|14|15|(3:16|(3:28|29|(2:31|32)(1:33))(4:18|(1:20)|21|(2:23|24)(1:26))|27))(4:44|45|46|47)|37|38)(5:53|54|55|(2:57|(1:59))|61)|48|49|15|(3:16|(0)(0)|27)))|64|6|(0)(0)|48|49|15|(3:16|(0)(0)|27)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d2, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d3, code lost:
    
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object A(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.d r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.A(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.d, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object F(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        Object G;
        return (!sharedFlowImpl.k(obj) && (G = sharedFlowImpl.G(obj, continuation)) == sd.a.d()) ? G : kotlin.p.f51048a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r9.f51320b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B(long r10) {
        /*
            r9 = this;
            int r0 = kotlinx.coroutines.flow.internal.a.c(r9)
            if (r0 == 0) goto L27
            kotlinx.coroutines.flow.internal.c[] r0 = kotlinx.coroutines.flow.internal.a.d(r9)
            if (r0 == 0) goto L27
            r1 = 0
            int r2 = r0.length
        Le:
            if (r1 >= r2) goto L27
            r3 = r0[r1]
            if (r3 == 0) goto L24
            kotlinx.coroutines.flow.l1 r3 = (kotlinx.coroutines.flow.l1) r3
            long r4 = r3.f51337a
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L24
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 >= 0) goto L24
            r3.f51337a = r10
        L24:
            int r1 = r1 + 1
            goto Le
        L27:
            r9.f51282k = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.B(long):void");
    }

    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public l1 f() {
        return new l1();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public l1[] g(int i10) {
        return new l1[i10];
    }

    public final void E() {
        Object[] objArr = this.f51280i;
        kotlin.jvm.internal.s.f(objArr);
        k1.e(objArr, K(), null);
        this.f51283l--;
        long K = K() + 1;
        if (this.f51281j < K) {
            this.f51281j = K;
        }
        if (this.f51282k < K) {
            B(K);
        }
    }

    public final Object G(T t2, Continuation<? super kotlin.p> continuation) {
        Continuation<kotlin.p>[] continuationArr;
        a aVar;
        kotlinx.coroutines.m mVar = new kotlinx.coroutines.m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.y();
        Continuation<kotlin.p>[] continuationArr2 = kotlinx.coroutines.flow.internal.b.f51324a;
        synchronized (this) {
            if (R(t2)) {
                Result.Companion companion = Result.Companion;
                mVar.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
                continuationArr = I(continuationArr2);
                aVar = null;
            } else {
                a aVar2 = new a(this, P() + K(), t2, mVar);
                H(aVar2);
                this.f51284m++;
                if (this.f51278g == 0) {
                    continuationArr2 = I(continuationArr2);
                }
                continuationArr = continuationArr2;
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.o.a(mVar, aVar);
        }
        for (Continuation<kotlin.p> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
            }
        }
        Object r10 = mVar.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10 == sd.a.d() ? r10 : kotlin.p.f51048a;
    }

    public final void H(Object obj) {
        int P = P();
        Object[] objArr = this.f51280i;
        if (objArr == null) {
            objArr = Q(null, 0, 2);
        } else if (P >= objArr.length) {
            objArr = Q(objArr, P, objArr.length * 2);
        }
        k1.e(objArr, K() + P, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r1 = r11.f51320b;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.coroutines.Continuation<kotlin.p>[] I(kotlin.coroutines.Continuation<kotlin.p>[] r12) {
        /*
            r11 = this;
            int r0 = r12.length
            int r1 = kotlinx.coroutines.flow.internal.a.c(r11)
            if (r1 == 0) goto L48
            kotlinx.coroutines.flow.internal.c[] r1 = kotlinx.coroutines.flow.internal.a.d(r11)
            if (r1 == 0) goto L48
            r2 = 0
            int r3 = r1.length
        Lf:
            if (r2 >= r3) goto L48
            r4 = r1[r2]
            if (r4 == 0) goto L45
            kotlinx.coroutines.flow.l1 r4 = (kotlinx.coroutines.flow.l1) r4
            kotlin.coroutines.Continuation<? super kotlin.p> r5 = r4.f51338b
            if (r5 != 0) goto L1c
            goto L45
        L1c:
            long r6 = r11.T(r4)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L45
            int r6 = r12.length
            if (r0 < r6) goto L3a
            int r6 = r12.length
            r7 = 2
            int r6 = r6 * 2
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            kotlin.jvm.internal.s.h(r12, r6)
        L3a:
            r6 = r12
            kotlin.coroutines.Continuation[] r6 = (kotlin.coroutines.Continuation[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f51338b = r0
            r0 = r7
        L45:
            int r2 = r2 + 1
            goto Lf
        L48:
            kotlin.coroutines.Continuation[] r12 = (kotlin.coroutines.Continuation[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.I(kotlin.coroutines.Continuation[]):kotlin.coroutines.Continuation[]");
    }

    public final long J() {
        return K() + this.f51283l;
    }

    public final long K() {
        return Math.min(this.f51282k, this.f51281j);
    }

    public final T L() {
        Object d10;
        Object[] objArr = this.f51280i;
        kotlin.jvm.internal.s.f(objArr);
        d10 = k1.d(objArr, (this.f51281j + O()) - 1);
        return (T) d10;
    }

    public final Object M(long j10) {
        Object d10;
        Object[] objArr = this.f51280i;
        kotlin.jvm.internal.s.f(objArr);
        d10 = k1.d(objArr, j10);
        return d10 instanceof a ? ((a) d10).f51287d : d10;
    }

    public final long N() {
        return K() + this.f51283l + this.f51284m;
    }

    public final int O() {
        return (int) ((K() + this.f51283l) - this.f51281j);
    }

    public final int P() {
        return this.f51283l + this.f51284m;
    }

    public final Object[] Q(Object[] objArr, int i10, int i11) {
        Object d10;
        if (i11 > 0) {
            Object[] objArr2 = new Object[i11];
            this.f51280i = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long K = K();
            for (int i12 = 0; i12 < i10; i12++) {
                long j10 = i12 + K;
                d10 = k1.d(objArr, j10);
                k1.e(objArr2, j10, d10);
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public final boolean R(T t2) {
        if (i() == 0) {
            return S(t2);
        }
        if (this.f51283l >= this.f51278g && this.f51282k <= this.f51281j) {
            int i10 = b.f51289a[this.f51279h.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 == 2) {
                return true;
            }
        }
        H(t2);
        int i11 = this.f51283l + 1;
        this.f51283l = i11;
        if (i11 > this.f51278g) {
            E();
        }
        if (O() > this.f51277f) {
            V(this.f51281j + 1, this.f51282k, J(), N());
        }
        return true;
    }

    public final boolean S(T t2) {
        if (this.f51277f == 0) {
            return true;
        }
        H(t2);
        int i10 = this.f51283l + 1;
        this.f51283l = i10;
        if (i10 > this.f51277f) {
            E();
        }
        this.f51282k = K() + this.f51283l;
        return true;
    }

    public final long T(l1 l1Var) {
        long j10 = l1Var.f51337a;
        if (j10 < J()) {
            return j10;
        }
        if (this.f51278g <= 0 && j10 <= K() && this.f51284m != 0) {
            return j10;
        }
        return -1L;
    }

    public final Object U(l1 l1Var) {
        Object obj;
        Continuation<kotlin.p>[] continuationArr = kotlinx.coroutines.flow.internal.b.f51324a;
        synchronized (this) {
            long T = T(l1Var);
            if (T < 0) {
                obj = k1.f51336a;
            } else {
                long j10 = l1Var.f51337a;
                Object M = M(T);
                l1Var.f51337a = T + 1;
                continuationArr = W(j10);
                obj = M;
            }
        }
        for (Continuation<kotlin.p> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
            }
        }
        return obj;
    }

    public final void V(long j10, long j11, long j12, long j13) {
        long min = Math.min(j11, j10);
        for (long K = K(); K < min; K++) {
            Object[] objArr = this.f51280i;
            kotlin.jvm.internal.s.f(objArr);
            k1.e(objArr, K, null);
        }
        this.f51281j = j10;
        this.f51282k = j11;
        this.f51283l = (int) (j12 - min);
        this.f51284m = (int) (j13 - j12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        r4 = r21.f51320b;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.coroutines.Continuation<kotlin.p>[] W(long r22) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.W(long):kotlin.coroutines.Continuation[]");
    }

    public final long X() {
        long j10 = this.f51281j;
        if (j10 < this.f51282k) {
            this.f51282k = j10;
        }
        return j10;
    }

    @Override // kotlinx.coroutines.flow.j1, kotlinx.coroutines.flow.c
    @Nullable
    public Object a(@NotNull d<? super T> dVar, @NotNull Continuation<?> continuation) {
        return A(this, dVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.k
    @NotNull
    public c<T> b(@NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        return k1.c(this, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.d
    @Nullable
    public Object emit(T t2, @NotNull Continuation<? super kotlin.p> continuation) {
        return F(this, t2, continuation);
    }

    @Override // kotlinx.coroutines.flow.f1
    public void j() {
        synchronized (this) {
            V(J(), this.f51282k, J(), N());
            kotlin.p pVar = kotlin.p.f51048a;
        }
    }

    @Override // kotlinx.coroutines.flow.f1
    public boolean k(T t2) {
        int i10;
        boolean z10;
        Continuation<kotlin.p>[] continuationArr = kotlinx.coroutines.flow.internal.b.f51324a;
        synchronized (this) {
            if (R(t2)) {
                continuationArr = I(continuationArr);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (Continuation<kotlin.p> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
            }
        }
        return z10;
    }

    public final Object x(l1 l1Var, Continuation<? super kotlin.p> continuation) {
        kotlin.p pVar;
        kotlinx.coroutines.m mVar = new kotlinx.coroutines.m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.y();
        synchronized (this) {
            if (T(l1Var) < 0) {
                l1Var.f51338b = mVar;
            } else {
                Result.Companion companion = Result.Companion;
                mVar.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
            }
            pVar = kotlin.p.f51048a;
        }
        Object r10 = mVar.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10 == sd.a.d() ? r10 : pVar;
    }

    public final void y(a aVar) {
        Object d10;
        synchronized (this) {
            if (aVar.f51286c < K()) {
                return;
            }
            Object[] objArr = this.f51280i;
            kotlin.jvm.internal.s.f(objArr);
            d10 = k1.d(objArr, aVar.f51286c);
            if (d10 != aVar) {
                return;
            }
            k1.e(objArr, aVar.f51286c, k1.f51336a);
            z();
            kotlin.p pVar = kotlin.p.f51048a;
        }
    }

    public final void z() {
        Object d10;
        if (this.f51278g != 0 || this.f51284m > 1) {
            Object[] objArr = this.f51280i;
            kotlin.jvm.internal.s.f(objArr);
            while (this.f51284m > 0) {
                d10 = k1.d(objArr, (K() + P()) - 1);
                if (d10 != k1.f51336a) {
                    return;
                }
                this.f51284m--;
                k1.e(objArr, K() + P(), null);
            }
        }
    }
}
