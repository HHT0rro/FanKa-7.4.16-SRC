package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.z;
import kotlin.p;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DebugProbesImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f51215a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final SimpleDateFormat f51216b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final ConcurrentWeakMap<a<?>, Boolean> f51217c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final /* synthetic */ e f51218d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f51219e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final ReentrantReadWriteLock f51220f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f51221g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f51222h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static final Function1<Boolean, p> f51223i;
    private static volatile int installations;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final ConcurrentWeakMap<td.c, c> f51224j;

    /* compiled from: DebugProbesImpl.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements Continuation<T>, td.c {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final Continuation<T> f51225b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final c f51226c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final td.c f51227d;

        @Override // td.c
        @Nullable
        public td.c getCallerFrame() {
            td.c cVar = this.f51227d;
            if (cVar != null) {
                return cVar.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        @NotNull
        public CoroutineContext getContext() {
            return this.f51225b.getContext();
        }

        @Override // td.c
        @Nullable
        public StackTraceElement getStackTraceElement() {
            td.c cVar = this.f51227d;
            if (cVar != null) {
                return cVar.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object obj) {
            d.f51215a.f(this);
            this.f51225b.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.f51225b.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.debug.internal.e] */
    static {
        d dVar = new d();
        f51215a = dVar;
        f51216b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f51217c = new ConcurrentWeakMap<>(false, 1, null);
        final long j10 = 0;
        f51218d = new Object(j10) { // from class: kotlinx.coroutines.debug.internal.e
            public volatile long sequenceNumber;

            {
                this.sequenceNumber = j10;
            }
        };
        f51220f = new ReentrantReadWriteLock();
        f51221g = true;
        f51222h = true;
        f51223i = dVar.d();
        f51224j = new ConcurrentWeakMap<>(true);
        f51219e = AtomicLongFieldUpdater.newUpdater(e.class, "sequenceNumber");
    }

    public final Function1<Boolean, p> d() {
        Object m3565constructorimpl;
        Object newInstance;
        try {
            Result.Companion companion = Result.Companion;
            newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(kotlin.e.a(th));
        }
        if (newInstance != null) {
            m3565constructorimpl = Result.m3565constructorimpl((Function1) z.e(newInstance, 1));
            if (Result.m3571isFailureimpl(m3565constructorimpl)) {
                m3565constructorimpl = null;
            }
            return (Function1) m3565constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
    }

    public final boolean e(a<?> aVar) {
        n1 n1Var;
        CoroutineContext b4 = aVar.f51226c.b();
        if (b4 == null || (n1Var = (n1) b4.get(n1.C0)) == null || !n1Var.isCompleted()) {
            return false;
        }
        f51217c.remove(aVar);
        return true;
    }

    public final void f(a<?> aVar) {
        td.c g3;
        f51217c.remove(aVar);
        td.c e2 = aVar.f51226c.e();
        if (e2 == null || (g3 = g(e2)) == null) {
            return;
        }
        f51224j.remove(g3);
    }

    public final td.c g(td.c cVar) {
        do {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        } while (cVar.getStackTraceElement() == null);
        return cVar;
    }
}
