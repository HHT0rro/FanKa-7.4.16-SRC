package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ArrayChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c<E> extends AbstractChannel<E> {

    /* renamed from: e, reason: collision with root package name */
    public final int f51165e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final BufferOverflow f51166f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final ReentrantLock f51167g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Object[] f51168h;

    /* renamed from: i, reason: collision with root package name */
    public int f51169i;

    @NotNull
    private volatile /* synthetic */ int size;

    /* compiled from: ArrayChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51170a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f51170a = iArr;
        }
    }

    public c(int i10, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, kotlin.p> function1) {
        super(function1);
        this.f51165e = i10;
        this.f51166f = bufferOverflow;
        if (i10 >= 1) {
            this.f51167g = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i10, 8)];
            kotlin.collections.l.n(objArr, kotlinx.coroutines.channels.a.f51154a, 0, 0, 6, null);
            this.f51168h = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i10 + " was specified").toString());
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean N(@NotNull n<? super E> nVar) {
        ReentrantLock reentrantLock = this.f51167g;
        reentrantLock.lock();
        try {
            return super.N(nVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean P() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean Q() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean R() {
        ReentrantLock reentrantLock = this.f51167g;
        reentrantLock.lock();
        try {
            return super.R();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void T(boolean z10) {
        Function1<E, kotlin.p> function1 = this.f51161b;
        ReentrantLock reentrantLock = this.f51167g;
        reentrantLock.lock();
        try {
            int i10 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = this.f51168h[this.f51169i];
                if (function1 != null && obj != kotlinx.coroutines.channels.a.f51154a) {
                    undeliveredElementException = OnUndeliveredElementKt.c(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.f51168h;
                int i12 = this.f51169i;
                objArr[i12] = kotlinx.coroutines.channels.a.f51154a;
                this.f51169i = (i12 + 1) % objArr.length;
            }
            this.size = 0;
            kotlin.p pVar = kotlin.p.f51048a;
            reentrantLock.unlock();
            super.T(z10);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    public Object X() {
        ReentrantLock reentrantLock = this.f51167g;
        reentrantLock.lock();
        try {
            int i10 = this.size;
            if (i10 == 0) {
                Object i11 = i();
                if (i11 == null) {
                    i11 = kotlinx.coroutines.channels.a.f51157d;
                }
                return i11;
            }
            Object[] objArr = this.f51168h;
            int i12 = this.f51169i;
            Object obj = objArr[i12];
            q qVar = null;
            objArr[i12] = null;
            this.size = i10 - 1;
            Object obj2 = kotlinx.coroutines.channels.a.f51157d;
            boolean z10 = false;
            if (i10 == this.f51165e) {
                q qVar2 = null;
                while (true) {
                    q G = G();
                    if (G == null) {
                        qVar = qVar2;
                        break;
                    }
                    kotlin.jvm.internal.s.f(G);
                    if (G.S(null) != null) {
                        obj2 = G.Q();
                        qVar = G;
                        z10 = true;
                        break;
                    }
                    G.T();
                    qVar2 = G;
                }
            }
            if (obj2 != kotlinx.coroutines.channels.a.f51157d && !(obj2 instanceof i)) {
                this.size = i10;
                Object[] objArr2 = this.f51168h;
                objArr2[(this.f51169i + i10) % objArr2.length] = obj2;
            }
            this.f51169i = (this.f51169i + 1) % this.f51168h.length;
            kotlin.p pVar = kotlin.p.f51048a;
            if (z10) {
                kotlin.jvm.internal.s.f(qVar);
                qVar.P();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if (r1 == r8.f51165e) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        r3 = L();
        r7 = r9.g(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r7 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r7 == kotlinx.coroutines.channels.a.f51157d) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        if (r7 == kotlinx.coroutines.internal.c.f51374b) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r7 != kotlinx.coroutines.selects.g.d()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r8.size = r1;
        r8.f51168h[r8.f51169i] = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        if ((r7 instanceof kotlinx.coroutines.channels.i) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r2 = r7;
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
    
        if (r2 == kotlinx.coroutines.channels.a.f51157d) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0086, code lost:
    
        if ((r2 instanceof kotlinx.coroutines.channels.i) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        r8.size = r1;
        r9 = r8.f51168h;
        r9[(r8.f51169i + r1) % r9.length] = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00aa, code lost:
    
        r8.f51169i = (r8.f51169i + 1) % r8.f51168h.length;
        r9 = kotlin.p.f51048a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
    
        if (r3 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ba, code lost:
    
        kotlin.jvm.internal.s.f(r5);
        ((kotlinx.coroutines.channels.q) r5).P();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c2, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
    
        if (r9.l() != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009a, code lost:
    
        r8.size = r1;
        r8.f51168h[r8.f51169i] = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
    
        return kotlinx.coroutines.selects.g.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
    
        throw new java.lang.IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r7).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0033, code lost:
    
        r5 = r3.o();
        kotlin.jvm.internal.s.f(r5);
        r2 = ((kotlinx.coroutines.channels.q) r5).Q();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x007f, code lost:
    
        r3 = false;
     */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object Y(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.f<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.f51167g
            r0.lock()
            int r1 = r8.size     // Catch: java.lang.Throwable -> Lc3
            if (r1 != 0) goto L15
            kotlinx.coroutines.channels.i r9 = r8.i()     // Catch: java.lang.Throwable -> Lc3
            if (r9 != 0) goto L11
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.a.f51157d     // Catch: java.lang.Throwable -> Lc3
        L11:
            r0.unlock()
            return r9
        L15:
            java.lang.Object[] r2 = r8.f51168h     // Catch: java.lang.Throwable -> Lc3
            int r3 = r8.f51169i     // Catch: java.lang.Throwable -> Lc3
            r4 = r2[r3]     // Catch: java.lang.Throwable -> Lc3
            r5 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> Lc3
            int r2 = r1 + (-1)
            r8.size = r2     // Catch: java.lang.Throwable -> Lc3
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.a.f51157d     // Catch: java.lang.Throwable -> Lc3
            int r3 = r8.f51165e     // Catch: java.lang.Throwable -> Lc3
            r6 = 1
            if (r1 != r3) goto L7f
        L29:
            kotlinx.coroutines.channels.AbstractChannel$g r3 = r8.L()     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r7 = r9.g(r3)     // Catch: java.lang.Throwable -> Lc3
            if (r7 != 0) goto L43
            java.lang.Object r5 = r3.o()     // Catch: java.lang.Throwable -> Lc3
            kotlin.jvm.internal.s.f(r5)     // Catch: java.lang.Throwable -> Lc3
            r2 = r5
            kotlinx.coroutines.channels.q r2 = (kotlinx.coroutines.channels.q) r2     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r2 = r2.Q()     // Catch: java.lang.Throwable -> Lc3
        L41:
            r3 = 1
            goto L80
        L43:
            kotlinx.coroutines.internal.f0 r3 = kotlinx.coroutines.channels.a.f51157d     // Catch: java.lang.Throwable -> Lc3
            if (r7 == r3) goto L7f
            java.lang.Object r3 = kotlinx.coroutines.internal.c.f51374b     // Catch: java.lang.Throwable -> Lc3
            if (r7 == r3) goto L29
            java.lang.Object r2 = kotlinx.coroutines.selects.g.d()     // Catch: java.lang.Throwable -> Lc3
            if (r7 != r2) goto L5d
            r8.size = r1     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = r8.f51168h     // Catch: java.lang.Throwable -> Lc3
            int r1 = r8.f51169i     // Catch: java.lang.Throwable -> Lc3
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc3
            r0.unlock()
            return r7
        L5d:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.i     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto L64
            r2 = r7
            r5 = r2
            goto L41
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r1.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = "performAtomicTrySelect(describeTryOffer) returned "
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc3
            r1.append(r7)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc3
            r9.<init>(r1)     // Catch: java.lang.Throwable -> Lc3
            throw r9     // Catch: java.lang.Throwable -> Lc3
        L7f:
            r3 = 0
        L80:
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.channels.a.f51157d     // Catch: java.lang.Throwable -> Lc3
            if (r2 == r7) goto L94
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.i     // Catch: java.lang.Throwable -> Lc3
            if (r7 != 0) goto L94
            r8.size = r1     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = r8.f51168h     // Catch: java.lang.Throwable -> Lc3
            int r7 = r8.f51169i     // Catch: java.lang.Throwable -> Lc3
            int r7 = r7 + r1
            int r1 = r9.length     // Catch: java.lang.Throwable -> Lc3
            int r7 = r7 % r1
            r9[r7] = r2     // Catch: java.lang.Throwable -> Lc3
            goto Laa
        L94:
            boolean r9 = r9.l()     // Catch: java.lang.Throwable -> Lc3
            if (r9 != 0) goto Laa
            r8.size = r1     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = r8.f51168h     // Catch: java.lang.Throwable -> Lc3
            int r1 = r8.f51169i     // Catch: java.lang.Throwable -> Lc3
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r9 = kotlinx.coroutines.selects.g.d()     // Catch: java.lang.Throwable -> Lc3
            r0.unlock()
            return r9
        Laa:
            int r9 = r8.f51169i     // Catch: java.lang.Throwable -> Lc3
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.f51168h     // Catch: java.lang.Throwable -> Lc3
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lc3
            int r9 = r9 % r1
            r8.f51169i = r9     // Catch: java.lang.Throwable -> Lc3
            kotlin.p r9 = kotlin.p.f51048a     // Catch: java.lang.Throwable -> Lc3
            r0.unlock()
            if (r3 == 0) goto Lc2
            kotlin.jvm.internal.s.f(r5)
            kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
            r5.P()
        Lc2:
            return r4
        Lc3:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.c.Y(kotlinx.coroutines.selects.f):java.lang.Object");
    }

    public final void d0(int i10, E e2) {
        if (i10 < this.f51165e) {
            e0(i10);
            Object[] objArr = this.f51168h;
            objArr[(this.f51169i + i10) % objArr.length] = e2;
        } else {
            Object[] objArr2 = this.f51168h;
            int i11 = this.f51169i;
            objArr2[i11 % objArr2.length] = null;
            objArr2[(i10 + i11) % objArr2.length] = e2;
            this.f51169i = (i11 + 1) % objArr2.length;
        }
    }

    public final void e0(int i10) {
        Object[] objArr = this.f51168h;
        if (i10 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f51165e);
            Object[] objArr2 = new Object[min];
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr3 = this.f51168h;
                objArr2[i11] = objArr3[(this.f51169i + i11) % objArr3.length];
            }
            kotlin.collections.l.l(objArr2, kotlinx.coroutines.channels.a.f51154a, i10, min);
            this.f51168h = objArr2;
            this.f51169i = 0;
        }
    }

    @Override // kotlinx.coroutines.channels.b
    @Nullable
    public Object f(@NotNull q qVar) {
        ReentrantLock reentrantLock = this.f51167g;
        reentrantLock.lock();
        try {
            return super.f(qVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final f0 f0(int i10) {
        if (i10 < this.f51165e) {
            this.size = i10 + 1;
            return null;
        }
        int i11 = a.f51170a[this.f51166f.ordinal()];
        if (i11 == 1) {
            return kotlinx.coroutines.channels.a.f51156c;
        }
        if (i11 == 2) {
            return kotlinx.coroutines.channels.a.f51155b;
        }
        if (i11 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlinx.coroutines.channels.b
    @NotNull
    public String g() {
        return "(buffer:capacity=" + this.f51165e + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.b
    public final boolean v() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    public final boolean w() {
        return this.size == this.f51165e && this.f51166f == BufferOverflow.SUSPEND;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (r1 == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        r2 = F();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        if (r2 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if ((r2 instanceof kotlinx.coroutines.channels.i) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        kotlin.jvm.internal.s.f(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (r2.i(r5, null) == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        r4.size = r1;
        r1 = kotlin.p.f51048a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r0.unlock();
        r2.e(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        return r2.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0028, code lost:
    
        r4.size = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        d0(r1, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        return kotlinx.coroutines.channels.a.f51155b;
     */
    @Override // kotlinx.coroutines.channels.b
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object y(E r5) {
        /*
            r4 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r4.f51167g
            r0.lock()
            int r1 = r4.size     // Catch: java.lang.Throwable -> L50
            kotlinx.coroutines.channels.i r2 = r4.i()     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L11
            r0.unlock()
            return r2
        L11:
            kotlinx.coroutines.internal.f0 r2 = r4.f0(r1)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L1b
            r0.unlock()
            return r2
        L1b:
            if (r1 != 0) goto L47
        L1d:
            kotlinx.coroutines.channels.o r2 = r4.F()     // Catch: java.lang.Throwable -> L50
            if (r2 != 0) goto L24
            goto L47
        L24:
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.i     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L2e
            r4.size = r1     // Catch: java.lang.Throwable -> L50
            r0.unlock()
            return r2
        L2e:
            kotlin.jvm.internal.s.f(r2)     // Catch: java.lang.Throwable -> L50
            r3 = 0
            kotlinx.coroutines.internal.f0 r3 = r2.i(r5, r3)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L1d
            r4.size = r1     // Catch: java.lang.Throwable -> L50
            kotlin.p r1 = kotlin.p.f51048a     // Catch: java.lang.Throwable -> L50
            r0.unlock()
            r2.e(r5)
            java.lang.Object r5 = r2.a()
            return r5
        L47:
            r4.d0(r1, r5)     // Catch: java.lang.Throwable -> L50
            kotlinx.coroutines.internal.f0 r5 = kotlinx.coroutines.channels.a.f51155b     // Catch: java.lang.Throwable -> L50
            r0.unlock()
            return r5
        L50:
            r5 = move-exception
            r0.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.c.y(java.lang.Object):java.lang.Object");
    }
}
