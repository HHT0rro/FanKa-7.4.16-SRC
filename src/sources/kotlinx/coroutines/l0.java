package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: DefaultExecutor.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f51435a = kotlinx.coroutines.internal.g0.e("kotlinx.coroutines.main.delay", false);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final m0 f51436b = b();

    @NotNull
    public static final m0 a() {
        return f51436b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final m0 b() {
        if (!f51435a) {
            return k0.f51428g;
        }
        x1 c4 = r0.c();
        return (kotlinx.coroutines.internal.w.c(c4) || !(c4 instanceof m0)) ? k0.f51428g : (m0) c4;
    }
}
