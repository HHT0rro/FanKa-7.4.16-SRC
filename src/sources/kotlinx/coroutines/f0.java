package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f0 extends kotlin.coroutines.a implements i2<String> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f51233c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final long f51234b;

    /* compiled from: CoroutineContext.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements CoroutineContext.b<f0> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // kotlinx.coroutines.i2
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull CoroutineContext coroutineContext, @NotNull String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.i2
    @NotNull
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public String F(@NotNull CoroutineContext coroutineContext) {
        String str;
        g0 g0Var = (g0) coroutineContext.get(g0.f51348c);
        if (g0Var == null || (str = g0Var.x()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int d02 = StringsKt__StringsKt.d0(name, " @", 0, false, 6, null);
        if (d02 < 0) {
            d02 = name.length();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + d02 + 10);
        String substring = name.substring(0, d02);
        kotlin.jvm.internal.s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb2.append(substring);
        sb2.append(" @");
        sb2.append(str);
        sb2.append('#');
        sb2.append(this.f51234b);
        String sb3 = sb2.toString();
        kotlin.jvm.internal.s.h(sb3, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb3);
        return name;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && this.f51234b == ((f0) obj).f51234b;
    }

    public int hashCode() {
        return b2.a.a(this.f51234b);
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.f51234b + ')';
    }

    public final long x() {
        return this.f51234b;
    }
}
