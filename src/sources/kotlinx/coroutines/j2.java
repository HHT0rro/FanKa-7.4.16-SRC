package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: EventLoop.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j2 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j2 f51426a = new j2();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ThreadLocal<x0> f51427b = new ThreadLocal<>();

    @NotNull
    public final x0 a() {
        ThreadLocal<x0> threadLocal = f51427b;
        x0 x0Var = threadLocal.get();
        if (x0Var != null) {
            return x0Var;
        }
        x0 a10 = a1.a();
        threadLocal.set(a10);
        return a10;
    }

    public final void b() {
        f51427b.set(null);
    }

    public final void c(@NotNull x0 x0Var) {
        f51427b.set(x0Var);
    }
}
