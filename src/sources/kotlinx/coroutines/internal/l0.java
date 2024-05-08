package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.i2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadContext.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final CoroutineContext f51397a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Object[] f51398b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final i2<Object>[] f51399c;

    /* renamed from: d, reason: collision with root package name */
    public int f51400d;

    public l0(@NotNull CoroutineContext coroutineContext, int i10) {
        this.f51397a = coroutineContext;
        this.f51398b = new Object[i10];
        this.f51399c = new i2[i10];
    }

    public final void a(@NotNull i2<?> i2Var, @Nullable Object obj) {
        Object[] objArr = this.f51398b;
        int i10 = this.f51400d;
        objArr[i10] = obj;
        i2<Object>[] i2VarArr = this.f51399c;
        this.f51400d = i10 + 1;
        i2VarArr[i10] = i2Var;
    }

    public final void b(@NotNull CoroutineContext coroutineContext) {
        int length = this.f51399c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            i2<Object> i2Var = this.f51399c[length];
            kotlin.jvm.internal.s.f(i2Var);
            i2Var.f(coroutineContext, this.f51398b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
