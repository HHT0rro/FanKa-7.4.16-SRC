package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;

/* compiled from: MainDispatchers.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f51422a = true;

    public static final x a(Throwable th, String str) {
        if (f51422a) {
            return new x(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ x b(Throwable th, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(@NotNull x1 x1Var) {
        return x1Var.x() instanceof x;
    }

    @NotNull
    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @NotNull
    public static final x1 e(@NotNull u uVar, @NotNull List<? extends u> list) {
        try {
            return uVar.c(list);
        } catch (Throwable th) {
            return a(th, uVar.b());
        }
    }
}
