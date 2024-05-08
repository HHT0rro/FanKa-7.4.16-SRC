package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StateFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class StateFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<r1> implements g1<T>, c, kotlinx.coroutines.flow.internal.k<T> {

    @NotNull
    private volatile /* synthetic */ Object _state;

    /* renamed from: f, reason: collision with root package name */
    public int f51292f;

    public StateFlowImpl(@NotNull Object obj) {
        this._state = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b3, code lost:
    
        if (kotlin.jvm.internal.s.d(r11, r12) == false) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00aa A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:13:0x003e, B:14:0x00a6, B:16:0x00aa, B:18:0x00af, B:20:0x00d0, B:22:0x00d6, B:26:0x00b5, B:29:0x00bc, B:38:0x005c, B:40:0x006f, B:41:0x0097), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00af A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:13:0x003e, B:14:0x00a6, B:16:0x00aa, B:18:0x00af, B:20:0x00d0, B:22:0x00d6, B:26:0x00b5, B:29:0x00bc, B:38:0x005c, B:40:0x006f, B:41:0x0097), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:13:0x003e, B:14:0x00a6, B:16:0x00aa, B:18:0x00af, B:20:0x00d0, B:22:0x00d6, B:26:0x00b5, B:29:0x00bc, B:38:0x005c, B:40:0x006f, B:41:0x0097), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00d4 -> B:14:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00e6 -> B:14:0x00a6). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.j1, kotlinx.coroutines.flow.c
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.d<? super T> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> r12) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.a(kotlinx.coroutines.flow.d, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.internal.k
    @NotNull
    public c<T> b(@NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        return q1.d(this, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.d
    @Nullable
    public Object emit(T t2, @NotNull Continuation<? super kotlin.p> continuation) {
        setValue(t2);
        return kotlin.p.f51048a;
    }

    @Override // kotlinx.coroutines.flow.p1
    public T getValue() {
        kotlinx.coroutines.internal.f0 f0Var = kotlinx.coroutines.flow.internal.n.f51330a;
        T t2 = (T) this._state;
        if (t2 == f0Var) {
            return null;
        }
        return t2;
    }

    @Override // kotlinx.coroutines.flow.f1
    public void j() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.f1
    public boolean k(T t2) {
        setValue(t2);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public r1 f() {
        return new r1();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public r1[] g(int i10) {
        return new r1[i10];
    }

    public final boolean p(Object obj, Object obj2) {
        int i10;
        r1[] l10;
        l();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !kotlin.jvm.internal.s.d(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.s.d(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i11 = this.f51292f;
            if ((i11 & 1) == 0) {
                int i12 = i11 + 1;
                this.f51292f = i12;
                r1[] l11 = l();
                kotlin.p pVar = kotlin.p.f51048a;
                while (true) {
                    r1[] r1VarArr = l11;
                    if (r1VarArr != null) {
                        for (r1 r1Var : r1VarArr) {
                            if (r1Var != null) {
                                r1Var.f();
                            }
                        }
                    }
                    synchronized (this) {
                        i10 = this.f51292f;
                        if (i10 == i12) {
                            this.f51292f = i12 + 1;
                            return true;
                        }
                        l10 = l();
                        kotlin.p pVar2 = kotlin.p.f51048a;
                    }
                    l11 = l10;
                    i12 = i10;
                }
            } else {
                this.f51292f = i11 + 2;
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.g1
    public void setValue(T t2) {
        if (t2 == null) {
            t2 = (T) kotlinx.coroutines.flow.internal.n.f51330a;
        }
        p(null, t2);
    }
}
