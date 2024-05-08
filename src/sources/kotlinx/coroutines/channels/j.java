package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConflatedChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j<E> extends AbstractChannel<E> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final ReentrantLock f51175e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Object f51176f;

    public j(@Nullable Function1<? super E, kotlin.p> function1) {
        super(function1);
        this.f51175e = new ReentrantLock();
        this.f51176f = a.f51154a;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean N(@NotNull n<? super E> nVar) {
        ReentrantLock reentrantLock = this.f51175e;
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
        ReentrantLock reentrantLock = this.f51175e;
        reentrantLock.lock();
        try {
            return this.f51176f == a.f51154a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void T(boolean z10) {
        ReentrantLock reentrantLock = this.f51175e;
        reentrantLock.lock();
        try {
            UndeliveredElementException d02 = d0(a.f51154a);
            kotlin.p pVar = kotlin.p.f51048a;
            reentrantLock.unlock();
            super.T(z10);
            if (d02 != null) {
                throw d02;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    public Object X() {
        ReentrantLock reentrantLock = this.f51175e;
        reentrantLock.lock();
        try {
            Object obj = this.f51176f;
            f0 f0Var = a.f51154a;
            if (obj != f0Var) {
                this.f51176f = f0Var;
                kotlin.p pVar = kotlin.p.f51048a;
                return obj;
            }
            Object i10 = i();
            if (i10 == null) {
                i10 = a.f51157d;
            }
            return i10;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    public Object Y(@NotNull kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f51175e;
        reentrantLock.lock();
        try {
            Object obj = this.f51176f;
            f0 f0Var = a.f51154a;
            if (obj == f0Var) {
                Object i10 = i();
                if (i10 == null) {
                    i10 = a.f51157d;
                }
                return i10;
            }
            if (!fVar.l()) {
                return kotlinx.coroutines.selects.g.d();
            }
            Object obj2 = this.f51176f;
            this.f51176f = f0Var;
            kotlin.p pVar = kotlin.p.f51048a;
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final UndeliveredElementException d0(Object obj) {
        Function1<E, kotlin.p> function1;
        Object obj2 = this.f51176f;
        UndeliveredElementException undeliveredElementException = null;
        if (obj2 != a.f51154a && (function1 = this.f51161b) != null) {
            undeliveredElementException = OnUndeliveredElementKt.d(function1, obj2, null, 2, null);
        }
        this.f51176f = obj;
        return undeliveredElementException;
    }

    @Override // kotlinx.coroutines.channels.b
    @NotNull
    public String g() {
        ReentrantLock reentrantLock = this.f51175e;
        reentrantLock.lock();
        try {
            return "(value=" + this.f51176f + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.b
    public final boolean v() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    public final boolean w() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        r1 = F();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (r1 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if ((r1 instanceof kotlinx.coroutines.channels.i) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        kotlin.jvm.internal.s.f(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r1.i(r4, null) == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        r2 = kotlin.p.f51048a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        r0.unlock();
        r1.e(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        return r1.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        r4 = d0(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        if (r4 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        return kotlinx.coroutines.channels.a.f51155b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
    
        if (r3.f51176f == kotlinx.coroutines.channels.a.f51154a) goto L9;
     */
    @Override // kotlinx.coroutines.channels.b
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object y(E r4) {
        /*
            r3 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r3.f51175e
            r0.lock()
            kotlinx.coroutines.channels.i r1 = r3.i()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto Lf
            r0.unlock()
            return r1
        Lf:
            java.lang.Object r1 = r3.f51176f     // Catch: java.lang.Throwable -> L48
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.a.f51154a     // Catch: java.lang.Throwable -> L48
            if (r1 != r2) goto L3b
        L15:
            kotlinx.coroutines.channels.o r1 = r3.F()     // Catch: java.lang.Throwable -> L48
            if (r1 != 0) goto L1c
            goto L3b
        L1c:
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.i     // Catch: java.lang.Throwable -> L48
            if (r2 == 0) goto L24
            r0.unlock()
            return r1
        L24:
            kotlin.jvm.internal.s.f(r1)     // Catch: java.lang.Throwable -> L48
            r2 = 0
            kotlinx.coroutines.internal.f0 r2 = r1.i(r4, r2)     // Catch: java.lang.Throwable -> L48
            if (r2 == 0) goto L15
            kotlin.p r2 = kotlin.p.f51048a     // Catch: java.lang.Throwable -> L48
            r0.unlock()
            r1.e(r4)
            java.lang.Object r4 = r1.a()
            return r4
        L3b:
            kotlinx.coroutines.internal.UndeliveredElementException r4 = r3.d0(r4)     // Catch: java.lang.Throwable -> L48
            if (r4 != 0) goto L47
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.channels.a.f51155b     // Catch: java.lang.Throwable -> L48
            r0.unlock()
            return r4
        L47:
            throw r4     // Catch: java.lang.Throwable -> L48
        L48:
            r4 = move-exception
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.j.y(java.lang.Object):java.lang.Object");
    }
}
