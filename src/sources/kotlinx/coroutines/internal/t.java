package kotlinx.coroutines.internal;

import android.view.View;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LockFreeTaskQueue.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class t<E> {

    @NotNull
    private volatile /* synthetic */ Object _next = null;

    @NotNull
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f51414a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f51415b;

    /* renamed from: c, reason: collision with root package name */
    public final int f51416c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public /* synthetic */ AtomicReferenceArray f51417d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f51410e = new a(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final f0 f51413h = new f0("REMOVE_FROZEN");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51411f = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f51412g = AtomicLongFieldUpdater.newUpdater(t.class, "_state");

    /* compiled from: LockFreeTaskQueue.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j10, int i10) {
            return d(j10, 1073741823L) | (i10 << 0);
        }

        public final long c(long j10, int i10) {
            return d(j10, 1152921503533105152L) | (i10 << 30);
        }

        public final long d(long j10, long j11) {
            return j10 & (~j11);
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f51418a;

        public b(int i10) {
            this.f51418a = i10;
        }
    }

    public t(int i10, boolean z10) {
        this.f51414a = i10;
        this.f51415b = z10;
        int i11 = i10 - 1;
        this.f51416c = i11;
        this.f51417d = new AtomicReferenceArray(i10);
        if (!(i11 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i10 & i11) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(@org.jetbrains.annotations.NotNull E r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.t$a r14 = kotlinx.coroutines.internal.t.f51410e
            int r14 = r14.a(r2)
            return r14
        L12:
            kotlinx.coroutines.internal.t$a r0 = kotlinx.coroutines.internal.t.f51410e
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r8 = 0
            long r4 = r4 >> r8
            int r1 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r9 = 30
            long r4 = r4 >> r9
            int r9 = (int) r4
            int r10 = r13.f51416c
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L30
            return r11
        L30:
            boolean r4 = r13.f51415b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.f51417d
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L4f
            int r0 = r13.f51414a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4e:
            return r11
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.internal.t.f51412g
            long r11 = r0.c(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f51417d
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L69:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L7c
            kotlinx.coroutines.internal.t r0 = r0.i()
            kotlinx.coroutines.internal.t r0 = r0.e(r9, r14)
            if (r0 != 0) goto L69
        L7c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.t.a(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<E> b(long j10) {
        t<E> tVar = new t<>(this.f51414a * 2, this.f51415b);
        int i10 = (int) ((1073741823 & j10) >> 0);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f51416c;
            if ((i10 & i12) != (i11 & i12)) {
                Object obj = this.f51417d.get(i12 & i10);
                if (obj == null) {
                    obj = new b(i10);
                }
                tVar.f51417d.set(tVar.f51416c & i10, obj);
                i10++;
            } else {
                tVar._state = f51410e.d(j10, FileUtils.ONE_EB);
                return tVar;
            }
        }
    }

    public final t<E> c(long j10) {
        while (true) {
            t<E> tVar = (t) this._next;
            if (tVar != null) {
                return tVar;
            }
            androidx.concurrent.futures.a.a(f51411f, this, null, b(j10));
        }
    }

    public final boolean d() {
        long j10;
        do {
            j10 = this._state;
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((FileUtils.ONE_EB & j10) != 0) {
                return false;
            }
        } while (!f51412g.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    public final t<E> e(int i10, E e2) {
        Object obj = this.f51417d.get(this.f51416c & i10);
        if (!(obj instanceof b) || ((b) obj).f51418a != i10) {
            return null;
        }
        this.f51417d.set(i10 & this.f51416c, e2);
        return this;
    }

    public final int f() {
        long j10 = this._state;
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j10) >> 0)));
    }

    public final boolean g() {
        long j10 = this._state;
        return ((int) ((1073741823 & j10) >> 0)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j10;
        long j11;
        do {
            j10 = this._state;
            if ((j10 & FileUtils.ONE_EB) != 0) {
                return j10;
            }
            j11 = j10 | FileUtils.ONE_EB;
        } while (!f51412g.compareAndSet(this, j10, j11));
        return j11;
    }

    @NotNull
    public final t<E> i() {
        return c(h());
    }

    @Nullable
    public final Object j() {
        while (true) {
            long j10 = this._state;
            if ((FileUtils.ONE_EB & j10) != 0) {
                return f51413h;
            }
            a aVar = f51410e;
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f51416c;
            if ((i11 & i12) == (i10 & i12)) {
                return null;
            }
            Object obj = this.f51417d.get(i12 & i10);
            if (obj == null) {
                if (this.f51415b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i13 = (i10 + 1) & View.LAST_APP_AUTOFILL_ID;
                if (f51412g.compareAndSet(this, j10, aVar.b(j10, i13))) {
                    this.f51417d.set(this.f51416c & i10, null);
                    return obj;
                }
                if (this.f51415b) {
                    t<E> tVar = this;
                    do {
                        tVar = tVar.k(i10, i13);
                    } while (tVar != null);
                    return obj;
                }
            }
        }
    }

    public final t<E> k(int i10, int i11) {
        long j10;
        a aVar;
        int i12;
        do {
            j10 = this._state;
            aVar = f51410e;
            i12 = (int) ((1073741823 & j10) >> 0);
            if ((FileUtils.ONE_EB & j10) != 0) {
                return i();
            }
        } while (!f51412g.compareAndSet(this, j10, aVar.b(j10, i11)));
        this.f51417d.set(this.f51416c & i12, null);
        return null;
    }
}
